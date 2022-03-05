package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Group;
import peaksoft.service.CourseServiceImpl;
import peaksoft.service.GroupServiceImpl;

@Controller
@RequestMapping("/gro")
public class GroupCantroller {
    private final GroupServiceImpl service;
    private final CourseServiceImpl courseService;

    @Autowired
    public GroupCantroller(GroupServiceImpl service, CourseServiceImpl courseService) {
        this.service = service;
        this.courseService = courseService;
    }

    @GetMapping()
    public String getAllCompany(Model model) {
        model.addAttribute("groups", service.groups());
        return "group/groups";
    }

    @GetMapping("/avv")
    public String saveCompany(Model model) {
        model.addAttribute("group1", new Group());
        return "group/createGroup";
    }

    @PostMapping("saveGroup")
    public String add(@ModelAttribute("group") Group group) {
        group.setCourse(courseService.getById(group.getCourseId()));
        service.saveGroup(group);
        return "redirect:/gro";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        //redirect.addAttribute("message","Saccsesfull");
        return "redirect:/gro";
    }

    /////////////////////////////////////////////////////////////////////////////
    @GetMapping("/update3/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("updateGro", service.getById(id));
        return "group/updateGroup";
    }

    //
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("group1") Group group, @PathVariable("id") long id) {
        service.updateGroup(id, group);
        return "redirect:/gro";
    }


}
