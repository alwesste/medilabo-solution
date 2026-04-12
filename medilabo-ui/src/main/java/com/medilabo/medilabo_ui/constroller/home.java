package com.medilabo.medilabo_ui.constroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class home {

    @GetMapping
    public String getHome() {
        return "home";
    }


}
