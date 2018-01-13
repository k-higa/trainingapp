package dev.trainingapp.adapter.gateway.rds.entity;

import dev.trainingapp.adapter.gateway.rds.base.BaseEntity;
import dev.trainingapp.domain.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "training_app")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRds extends BaseEntity {

    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "password")
    private String password;
    @Column(name = "rank")
    private String rank;
    @Column(name = "age")
    private String age;
    @Column(name = "state")
    private Integer state;
    @Column(name = "icon_image")
    private String iconImage;
    @Column(name = "name")
    private String name;

    public static UserRds of(User user) {
        return UserRds.builder()
                .userId(user.getUserId().getId())
                .password(user.getPassword().getPass())
                .rank(user.getRank().getMemberRank().getCode())
                .age(user.getUserInfo().getAge())
                .state(user.getUserInfo().getState().getCode().getPrefectureCd())
                .iconImage(user.getIconImage().getIcon())
                .name(user.getUserInfo().getName())
                .build();
    }


}
