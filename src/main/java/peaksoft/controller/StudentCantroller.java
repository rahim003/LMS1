package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Student;
import peaksoft.service.GroupServiceImpl;
import peaksoft.service.StudentServiceImpl;

@Controller
@RequestMapping("stu")
public class StudentCantroller {
private final StudentServiceImpl service;
private final GroupServiceImpl groupService;
@Autowired
    public StudentCantroller(StudentServiceImpl service, GroupServiceImpl groupService) {
        this.service = service;
    this.groupService = groupService;
}

    @GetMapping()
    public String getAllCompany(Model model) {
        model.addAttribute("students", service.students());
        return "student/students";
    }

    @GetMapping("/addStudent")
    public String saveStudent(Model model) {
        model.addAttribute("student1", new Student());
        return "student/createStudent";
    }

    @PostMapping("/saveStudent")
    public String add(@ModelAttribute("student")Student student) {
    student.setGroup(groupService.getById(student.getGroupID()));
        service.saveStudent(student);
        return "redirect:/stu";
    }
    /////////////////////////////////////////////////////////////////////////////
    @GetMapping("/update11/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("updateStu", service.getById(id));
        return "student/updateStudents";
    }
    //
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student1") Student student, @PathVariable("id") long id) {
        service.updateStudent(id,student);
        return "redirect:/stu";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        //redirect.addAttribute("message","Saccsesfull");
        return "redirect:/stu";
    }
}
