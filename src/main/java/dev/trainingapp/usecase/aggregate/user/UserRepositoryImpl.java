package dev.trainingapp.usecase.aggregate.user;

import dev.trainingapp.adapter.gateway.rds.entity.UserRds;
import dev.trainingapp.domain.entity.user.User;
import dev.trainingapp.domain.repository.UserRepository;
import dev.trainingapp.domain.vo.user.Password;
import dev.trainingapp.domain.vo.user.UserId;
import dev.trainingapp.other.enums.ConstApp;
import dev.trainingapp.usecase.gateway.rds.user.UserRdsGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserRdsGateway userRdsGateway;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public User save(User user) {
        val saveUser = userRdsGateway.save(UserRds.of(user));
        log.info("save entity [%s]", saveUser.getUserId());
        return User.convert(saveUser);
    }

    @Override
    public ImmutableList<User> findAll() {
        return Lists.immutable.ofAll(userRdsGateway.findAll())
                .collect(userRds -> User.convert(userRds));
    }

    @Override
    public Optional<User> getUserOpt(UserId userId) {
        return Optional.ofNullable(User.convert(userRdsGateway.findOne(userId.getId())));
    }

    @Override
    public boolean startAuthentication(User user, Password password) {
        final Principal principal = () -> user.getUserId().getId();
        ImmutableList<GrantedAuthority> authorities = Lists.immutable.of(new SimpleGrantedAuthority(ConstApp.MemberRank.FREE.getCode()));
        val authentication = new UsernamePasswordAuthenticationToken(principal, password.getPass(), authorities.castToList());
        val authenticate = authenticationManager.authenticate(authentication);

        val securityContext = new SecurityContextImpl();
        securityContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(securityContext);

        val isAuthenticated = authenticate.isAuthenticated();

        return isAuthenticated;
    }
}
