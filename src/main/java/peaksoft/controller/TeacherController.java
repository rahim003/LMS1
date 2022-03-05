package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Teacher;
import peaksoft.service.CourseServiceImpl;
import peaksoft.service.TeacherServiceImpl;
@Controller
@RequestMapping("/tea")
public class TeacherController {
    private final TeacherServiceImpl service;
    private final CourseServiceImpl courseService;
@Autowired
    public TeacherController(TeacherServiceImpl service, CourseServiceImpl courseService) {
        this.service = service;
    this.courseService = courseService;
}
    @GetMapping("/{id}")
    public String getAllTeacher(@PathVariable("id")long id, Model model) {
        model.addAttribute("teachers", service.teachers(id));
        model.addAttribute("courseId",id);
        return "teacher/teachers";
    }
    //    @GetMapping("/{id}")
//    public String findById(@PathVariable("id") long id, Model model) {
//        model.addAttribute("findByIdCourse", service.getById(id));
//        return "course/findCourse";
//    }

    @GetMapping("/addTea")
    public String saveTeacher( Model model) {
        model.addAttribute("teacher1", new Teacher());
        return "teacher/createTeacher";
    }

    @PostMapping("/saveTeacher")
    public String add(@ModelAttribute("teacher")Teacher teacher) {
    teacher.setCourse(courseService.getById(teacher.getCourseId()));
        service.save(teacher);
        return "redirect:/tea";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/tea";
    }
    /////////////////////////////////////////////////////////////////////////////
    @GetMapping("/updateTeacher/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("updateTeacher", service.getById(id));
        return "teacher/updateTeacher";
    }
    //
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("updateTeacher") Teacher teacher, @PathVariable("id") long id) {
        service.updateTeacher(id,teacher);
        return "redirect:/tea";
    }
}
