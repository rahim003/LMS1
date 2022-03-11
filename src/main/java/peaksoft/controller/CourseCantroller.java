package peaksoft.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Course;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;


@Controller
@RequestMapping("/course/{companyId}")
@AllArgsConstructor
public class CourseCantroller {

    private final CourseService courseService;
    private final CompanyService companyService;


    @GetMapping
    public String getAllCompany(@PathVariable("companyId") long id, Model model) {
        model.addAttribute("courses", courseService.getAllCourse(id));
        model.addAttribute("idCompany", id);
        return "course/courses";
    }

    @GetMapping("/addNew")
    public String saveCourse(Model model) {
        model.addAttribute("course1", new Course());
        return "course/createCourse";
    }

    @PostMapping("/saveCourse")
    public String add(@ModelAttribute("course") Course course) {
        try {
            course.setCompany(companyService.getById(course.getCompanyId()));
            if (course.getCompanyId() == null) {
                throw new Exception("kata bar 500 server");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        courseService.saveCourse(course);
        return "redirect:/course/{companyId}";

    }

    @DeleteMapping("/deleteCourse/{idDeleteCourse}")
    public String deleteCourse(@PathVariable("idDeleteCourse") int id) {
        courseService.deleteById(id);
        return "redirect:/course/{companyId}";
    }

    @GetMapping("/updateCourse/{id}")
    public String editCourse(Model model, @PathVariable("id") long id) {
        Course course = courseService.getById(id);
        model.addAttribute("updateCourse", course);
        return "course/updateCourse";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("updateCourse") Course course, @PathVariable("id") long id) {
        course.setCompany(courseService.getById(id).getCompany());
        courseService.updateCourse(id, course);
        long companyId = companyService.getById(id).getId();
        return "redirect:/course/" + companyId;
    }


}
