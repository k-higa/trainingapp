package dev.trainingapp.other.util;

import dev.trainingapp.usecase.aggregate.auth.UserDetailsImpl;
import lombok.val;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class ViewUtils {

    /**
     * ユーザが認証済みか判定します。
     * @return 認証済みの場合true
     */
    public static boolean isAuthenticated() {
        try {
            val principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (Objects.nonNull(principal) && principal instanceof UserDetailsImpl) {
                 val accountUserDetails = (UserDetailsImpl) principal;
                if (accountUserDetails != null) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
           return false;
        }
    }

}
