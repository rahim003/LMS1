package peaksoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import peaksoft.model.Company;
import peaksoft.service.CompanyServiceImpl;

import javax.validation.Valid;


@Controller
@RequestMapping("/api")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    @Autowired
    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }


    @GetMapping("")
    public String getAllCompany(Model model) {
        model.addAttribute("getAllCompany", companyService.getAllCompany());
        return "company/companies";
    }
    @GetMapping("/add")
    public String saveCompany(Model model) {
        model.addAttribute("company1", new Company());
        return "company/createCompany";
    }

    @PostMapping("/save")
    public String add(@ModelAttribute("company") @Valid Company company) {
        companyService.saveCompany(company);
        return "redirect:/api";
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        companyService.deleteById(id);
        return "redirect:/api";
    }
/////////////////////////////////////////////////////////////////////////////
    @GetMapping("/update/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("company", companyService.getById(id));
        return "company/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("company") @Valid Company company, @PathVariable("id") long id) {
        companyService.updateCompany(id, company);
        return "redirect:/api";
    }



}


