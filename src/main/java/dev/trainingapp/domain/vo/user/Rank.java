package dev.trainingapp.domain.vo.user;

import dev.trainingapp.other.enums.ConstApp;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

@AllArgsConstructor(staticName = "of")
@Value
public class Rank implements Serializable {
    private static final long serialVersionUID = 1L;
    private final ConstApp.MemberRank memberRank;

    public static Rank of(String code) {
        return Rank.of(ConstApp.MemberRank.getMemberRank(code));
    }

}
