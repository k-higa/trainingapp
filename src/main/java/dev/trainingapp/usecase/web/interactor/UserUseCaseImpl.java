package dev.trainingapp.usecase.web.interactor;

import dev.trainingapp.domain.entity.user.User;
import dev.trainingapp.domain.repository.UserRepository;
import dev.trainingapp.domain.vo.user.Password;
import dev.trainingapp.other.exception.AuthFailedException;
import dev.trainingapp.usecase.web.inputport.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserUseCaseImpl implements UserUseCase {
    private final UserRepository userRepository;

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }


    @Override
    public void startAuthentication(User user, Password password) {
        boolean isAuthentication = userRepository.startAuthentication(user, password);
        if (!isAuthentication) {
            throw new AuthFailedException("会員登録後の認証処理に失敗しました。");
        }
    }
}
