package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Teacher;
import peaksoft.service.CourseService;
import peaksoft.service.TeacherService;


@Controller
@RequestMapping("/teacher/{courseId2}")
public class TeacherController {
    private final TeacherService teacherService;
    private final CourseService courseService;

    @Autowired
    public TeacherController(TeacherService teacherServicee, CourseService courseService) {
        this.teacherService = teacherServicee;
        this.courseService = courseService;
    }

    @GetMapping
    public String getAllTeacher(@PathVariable("courseId2") long id, Model model) {
        model.addAttribute("teachers", teacherService.getAllTeacher(id));
        model.addAttribute("courseId", id);
        return "teacher/teachers";
    }

    @GetMapping("/addTea")
    public String saveTeacher(Model model) {
        model.addAttribute("teacher1", new Teacher());
        return "teacher/createTeacher";
    }

    @PostMapping("/saveTeacher")
    public String add(@PathVariable("courseId2") long id,@ModelAttribute("teacher") Teacher teacher) throws Exception {
        if (courseService.getById(id).getTeacher()==null) {
            teacher.setCourse(courseService.getById(teacher.getCourseId()));
            teacherService.save(teacher);
        }else{
            throw new Exception("error one teacher save tru");
        }

        return "redirect:/teacher/{courseId2}";
    }

    @DeleteMapping("/deleteTeacher/{idDeleteTeacher}")
    public String deleteTeacher(@PathVariable("idDeleteTeacher") long id) {
        teacherService.deleteById(id);
        System.out.println(id);
        return "redirect:/teacher/{courseId2}";
    }
    @GetMapping("/updateTeacher/{id}")
    public String editTeacher(Model model, @PathVariable("id") long id, @PathVariable String courseId2) {
        model.addAttribute("updateTeacher", teacherService.getById(id));
        return "teacher/updateTeacher";
    }

    //
    @PatchMapping("/{id}")
    public String updateTeacher(@ModelAttribute("updateTeacher") Teacher teacher, @PathVariable("id") long id, @PathVariable String courseId2) {
        teacherService.updateTeacher(id, teacher);
        long courseId = teacherService.getById(id).getCourse().getId();
        return "redirect:/teacher/" + courseId;
    }
}
