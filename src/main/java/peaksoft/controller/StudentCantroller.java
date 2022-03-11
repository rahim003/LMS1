package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Student;
import peaksoft.service.GroupService;
import peaksoft.service.StudentService;

@Controller
@RequestMapping("student/{groupId}")
public class StudentCantroller {
    private final StudentService studentService;
    private final GroupService groupService;

    @Autowired
    public StudentCantroller(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping
    public String getAllStudent(@PathVariable("groupId") long id, Model model) {
        model.addAttribute("students", studentService.getAllStudent(id));
        model.addAttribute("groupId", id);
        return "student/students";
    }

    @GetMapping("/addStudent")
    public String saveStudent(Model model) {
        model.addAttribute("student1", new Student());
        return "student/createStudent";
    }

    @PostMapping("/saveStudent")
    public String addStudent(@ModelAttribute("student") Student student) {
        student.setGroup(groupService.getById(student.getGroupID()));
        studentService.saveStudent(student);
        return "redirect:/student/{groupId}";
    }

    /////////////////////////////////////////////////////////////////////////////
    @GetMapping("/updateStudent/{id}")
    public String editStudent(Model model, @PathVariable("id") long id) {
        model.addAttribute("updateStu", studentService.getById(id));
        return "student/updateStudents";
    }

    @PatchMapping("/{id}")
    public String updateStudent(@ModelAttribute("student1") Student student, @PathVariable("id") long id) {
        studentService.updateStudent(id, student);
        long groupId = studentService.getById(id).getGroup().getId();
        return "redirect:/student/" + groupId;
    }

    @DeleteMapping("/deleteStudent/{idDeleteStudent}")
    public String deleteStudent(@PathVariable("idDeleteStudent") int id) {
        studentService.deleteById(id);
        return "redirect:/student/{groupId}";
    }
}
