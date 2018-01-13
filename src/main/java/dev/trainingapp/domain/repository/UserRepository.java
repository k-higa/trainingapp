package dev.trainingapp.domain.repository;

import dev.trainingapp.domain.entity.user.User;
import dev.trainingapp.domain.vo.user.Password;
import dev.trainingapp.domain.vo.user.UserId;
import org.eclipse.collections.api.list.ImmutableList;

import java.util.Optional;

/**
 * ユーザに関するレポジトリ
 */
public interface UserRepository {

    User save(User user);

    ImmutableList<User> findAll();

    Optional<User> getUserOpt(UserId userId);

    boolean startAuthentication(User user, Password password);

}
