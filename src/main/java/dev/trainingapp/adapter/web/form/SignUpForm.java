package dev.trainingapp.adapter.web.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class SignUpForm {
    @NotEmpty(message = "userId入力してください。")
    private String userId;
    @NotEmpty(message = "passwordを入力してください。")
    private String password;
    @NotEmpty(message = "Emailを入力してください。")
    private String email;
    @NotEmpty(message = "出身地を選択してください。")
    private int state;
    @NotEmpty(message = "性別を選択してください。")
    private String gender;
    @NotNull(message = "年齢を入力してください。")
    @Pattern(regexp = "[0-9]*", message = "年齢は数値で入力してください。")
    private String age;
    private String mailMagazine;
    @NotNull(message = "表示名(ニックネーム等)を入力してください。")
    private String name;

}
