package dev.trainingapp.adapter.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignOutController {

    @GetMapping("/sign_out")
    public String signUp(Model model) {
        return "sign_out";
    }

}
