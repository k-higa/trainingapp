package dev.trainingapp.usecase.aggregate.auth;

import dev.trainingapp.domain.entity.user.User;
import dev.trainingapp.other.enums.ConstApp;
import dev.trainingapp.usecase.gateway.rds.user.UserRdsGateway;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class AccountUserDetailsService implements UserDetailsService {
    private final UserRdsGateway userRdsGateway;
    private final String ROLE_ = "ROLE_";

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        val userRds = Optional.ofNullable(userRdsGateway.findOne(userId)).orElseThrow(() -> new UsernameNotFoundException("Userが見つかりません。"));
        val user = User.convert(userRds);
        val authorities = getAuthorities(user);
        return new UserDetailsImpl(user, authorities);
    }

    public Collection<GrantedAuthority> getAuthorities(User user) {
        if (ConstApp.MemberRank.FREE.getCode().equals(user.getRank().getMemberRank().getCode())) {
            return AuthorityUtils.createAuthorityList(ROLE_ + ConstApp.MemberRank.FREE.getCode());
        } else if (ConstApp.MemberRank.NORMAL.getCode().equals(user.getRank().getMemberRank().getCode())) {
            return AuthorityUtils.createAuthorityList(ROLE_ + ConstApp.MemberRank.NORMAL.getCode());
        } else if (ConstApp.MemberRank.PREMIUM.getCode().equals(user.getRank().getMemberRank().getCode())) {
            return AuthorityUtils.createAuthorityList(ROLE_ + ConstApp.MemberRank.PREMIUM.getCode());
        } else {
            return AuthorityUtils.createAuthorityList("");
        }
    }


}
