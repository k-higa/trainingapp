package dev.trainingapp;

import dev.trainingapp.usecase.aggregate.auth.AccountUserDetailsService;
import dev.trainingapp.other.enums.ConstApp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final AccountUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/js/**", "/css/**", "/admin/**", "/assets/**", "/fonts/**", "/images/**").permitAll() //静的ファイルにはすべてアクセス可能
                .and()
                .authorizeRequests().antMatchers("/sign_up").permitAll() //会員登録画面は誰でもアクセス可能
                .and()
                .authorizeRequests().anyRequest().authenticated() //ログイン画面を強制
                .and()
                .authorizeRequests().antMatchers("/menu/**").hasRole(ConstApp.MemberRank.FREE.name()) //menu配下のページにはALLユーザのみアクセス可能
                .and()
                .formLogin()
                .loginPage("/sign_in")
                .loginProcessingUrl("/sign_in_process")
                .usernameParameter("userId")
                .passwordParameter("password")
                .permitAll()
                .defaultSuccessUrl("/")
                .permitAll()
                .failureUrl("/sign_in")
                .permitAll();
        //ログアウト
        http.logout()
                .logoutUrl("/sign_out/confirm")
                .permitAll()
                .logoutSuccessUrl("/sign_in")
                .permitAll()
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);

    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
