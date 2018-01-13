package dev.trainingapp.adapter.web.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class SignInForm {
    @NotEmpty(message = "userId入力してください。")
    private String userId;
    @NotEmpty(message = "passwordを入力してください。")
    private String password;
}
