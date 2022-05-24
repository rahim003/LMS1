package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Group;
import peaksoft.service.CourseServiceImpl;
import peaksoft.service.GroupService;

@Controller
@RequestMapping("/group/{courseId}")
public class GroupCantroller {
    private final GroupService groupService;
    private final CourseServiceImpl courseService;

    @Autowired
    public GroupCantroller(GroupService groupService, CourseServiceImpl courseService) {
        this.groupService = groupService;
        this.courseService = courseService;
    }
    @GetMapping
    public String getAllGroup(@PathVariable("courseId") long id, Model model) {
        model.addAttribute("groups", groupService.getAllGroup(id));
        model.addAttribute("groupId", id);
        return "group/groups";
    }

    @GetMapping("/addGroup")
    public String saveGroup(Model model) {
        model.addAttribute("group1", new Group());
        return "group/createGroup";
    }

    @PostMapping("saveGroup")
    public String add(@ModelAttribute("group") Group group) {
        group.setCourse(courseService.getById(group.getCourseId()));
        groupService.saveGroup(group);
        return "redirect:/group/{courseId}";
    }

    @DeleteMapping("/deleteGroup/{idDeleteGroup}")
    public String deleteGroup(@PathVariable("idDeleteGroup") int id) {
        groupService.deleteById(id);
        return "redirect:/group/{courseId}";
    }
    @GetMapping("/updateGroup/{id}")
    public String editGroup(Model model, @PathVariable("id") long id) {
        model.addAttribute("updateGro", groupService.getById(id));
        return "group/updateGroup";
    }
    @PatchMapping("/{id}")
    public String updateGroup(@ModelAttribute("group1") Group group, @PathVariable("id") long id) {
        groupService.updateGroup(id, group);
        long courseId = 1;
        return "redirect:/group/"+courseId;
    }


}
