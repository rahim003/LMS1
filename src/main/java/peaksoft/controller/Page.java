package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Page {
    @GetMapping
    public String pages(){
        return "pages/pages";
    }
}
