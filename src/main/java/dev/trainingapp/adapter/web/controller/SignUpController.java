package dev.trainingapp.adapter.web.controller;

import dev.trainingapp.adapter.web.form.SignUpForm;
import dev.trainingapp.domain.entity.user.User;
import dev.trainingapp.domain.vo.user.Password;
import dev.trainingapp.domain.vo.user.State;
import dev.trainingapp.usecase.web.inputport.UserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.eclipse.collections.impl.factory.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SignUpController {
    private final PasswordEncoder passwordEncoder;
    private final UserUseCase userUseCase;

    @GetMapping("/sign_up")
    public String signUp(Model model) {
        val signUpForm = new SignUpForm();
        model.addAttribute("signUpForm", signUpForm);
        model.addAttribute("states", State.ViewState.getAllState().castToList());
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String signUpConfirm(SignUpForm form, BindingResult error, Model model) {
        if (error.hasErrors()) {
            val errors = Lists.immutable.ofAll(error.getAllErrors())
                    .collect(ObjectError::getDefaultMessage);
            model.addAttribute("errors", errors.castToList());
            model.addAttribute("states", State.ViewState.getAllState().castToList());
            model.addAttribute("signUpForm", form);
            return "sign_up";
        }
        val saveUser = userUseCase.register(User.convert(form,
                passwordEncoder.encode(form.getPassword())));

        //会員登録後の認可処理開始
        userUseCase.startAuthentication(saveUser, Password.of(form.getPassword())); //暗号化される前のpasswordを渡す

        log.info("save user " + saveUser.getUserId().getId());

        return "redirect:/sign_up/complete";
    }

    @GetMapping("/sign_up/complete")
    public String complete() {
        return "sign_up_complete";
    }
}
