package dev.trainingapp.usecase.web.inputport;

import dev.trainingapp.domain.entity.user.User;
import dev.trainingapp.domain.vo.user.Password;

public interface UserUseCase {

    User register(User user);

    void startAuthentication(User user, Password password);

}
