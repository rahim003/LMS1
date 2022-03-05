package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.dao.CompanyDaoImpl;
import peaksoft.model.Course;
import peaksoft.service.CourseServiceImpl;

@Controller
@RequestMapping("/cor")
public class CourseCantroller {

    private final CourseServiceImpl service;
    private final CompanyDaoImpl company;

    @Autowired
    public CourseCantroller(CourseServiceImpl service, CompanyDaoImpl company) {
        this.service = service;
        this.company = company;

    }
    @GetMapping("/{id}")
    public String getAllCompany(@PathVariable("id") long id, Model model) {
        model.addAttribute("courses", service.courses(id));
        model.addAttribute("idCompany",id);
        return "course/courses";
    }

    //    @GetMapping("/{id}")
//    public String findById(@PathVariable("id") long id, Model model) {
//        model.addAttribute("findByIdCourse", service.getById(id));
//        return "course/findCourse";
//    }
    @GetMapping("/adddCourse")
    public String saveCourse(Model model) {
        model.addAttribute("course1", new Course());
        return "course/createCourse";
    }

    @PostMapping("/saveCourse")
    public String add(@ModelAttribute("course") Course course) {
        course.setCompany(company.getById(course.getCompanyId()));
        service.saveCourse(course);
        return "redirect:/cor/1";
    }

    @DeleteMapping("/deleteCourse/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        //redirect.addAttribute("message","Saccsesfull");
        return "redirect:/cor/1";
    }

    /////////////////////////////////////////////////////////////////////////////
    @GetMapping("/updateCourse/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("updateCourse", service.getById(id));
        return "course/updateCourse";
    }

    //
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("updateCourse") Course course, @PathVariable("id") long id) {
        course.setCompany(service.getById(id).getCompany());
        service.updateCourse(id,course);
        return "redirect:/cor/1";
    }

}
