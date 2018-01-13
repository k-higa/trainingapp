package dev.trainingapp.adapter.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuController {

    @GetMapping("/menu/show")
    public String home() {
        return "show_menu";
    }

    @GetMapping("/menu/edit")
    public String edit() {
        return "edit_menu";
    }

    @PostMapping("/menu/confirm")
    public String menuConfirm() {
        System.out.println("post"); //TODO post処理実装
        return "show_menu";
    }

}
