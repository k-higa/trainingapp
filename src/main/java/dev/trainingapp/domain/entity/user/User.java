package dev.trainingapp.domain.entity.user;

import dev.trainingapp.adapter.gateway.rds.entity.UserRds;
import dev.trainingapp.adapter.web.form.SignUpForm;
import dev.trainingapp.domain.vo.user.*;
import dev.trainingapp.other.enums.ConstApp;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * ユーザドメインモデル
 */

@AllArgsConstructor(staticName = "of")
@Value
public class User {

    private final UserId userId;
    private final Password password;
    private final Rank rank;
    private final UserInfo userInfo;
    private final IconImage iconImage;

    public static User convert(UserRds userRds) {
        return User.of(UserId.of(userRds.getUserId()),
                Password.of(userRds.getPassword()),
                Rank.of(userRds.getRank()),
                UserInfo.of(userRds.getAge(),
                        userRds.getName(),
                        State.of(userRds.getState())),
                IconImage.of(userRds.getIconImage())
        );
    }

    public static User convert(SignUpForm form, String password) {
        return User.of(UserId.of(form.getUserId()),
                Password.of(password),
                Rank.of(ConstApp.MemberRank.getMemberRank("FREE")), //会員登録時は無料会員
                UserInfo.of(form.getAge(), form.getName(), State.of(form.getState())),
                IconImage.of("defualt") //TODO ICONが画面にないのであとで
        );
    }

}
