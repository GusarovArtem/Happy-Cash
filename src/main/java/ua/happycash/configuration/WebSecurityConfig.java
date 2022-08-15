package ua.happycash.configuration;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ua.happycash.service.user.UserService;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    UserService userService;

    String appMatcher = "/";
    String loginMatcher = "/login";
    String authMatcher = "/auth";
    String logoutMatcher = "/logout";
    String registrationMatcher = "/registration";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers( appMatcher, authMatcher, loginMatcher, logoutMatcher, registrationMatcher).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin(login -> login
                        .loginPage(loginMatcher)
                        .defaultSuccessUrl(appMatcher))
                .rememberMe()
                .and()
                .logout(logout -> logout
                        .logoutUrl(logoutMatcher)
                        .logoutSuccessUrl(loginMatcher)
                        .deleteCookies("JSESSIONID"))
                .oauth2Login(config -> config
                        .loginPage(loginMatcher)
                        .defaultSuccessUrl(appMatcher)
                        .userInfoEndpoint(userInfo -> userInfo.oidcUserService(userService))
                );

    }
}