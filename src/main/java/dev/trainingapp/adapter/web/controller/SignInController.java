package dev.trainingapp.adapter.web.controller;

import dev.trainingapp.adapter.web.form.SignInForm;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class SignInController {

    @GetMapping("/sign_in")
    public String signUp(Model model) {
        val signInForm = new SignInForm();
        model.addAttribute("signInForm", signInForm);
        return "sign_in";
    }

    @PostMapping("/sign_in_process")
    public String signUpConfirm(@Validated SignInForm form, BindingResult error, Model model) {
        if (error.hasErrors()) {
            val errors = Lists.immutable.ofAll(error.getAllErrors()).collect(ObjectError::getDefaultMessage);
            model.addAttribute("errors", errors);
            model.addAttribute("signInForm", form);
            return "sign_in";
        }


        return "redirect:/";
    }


}
