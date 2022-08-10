package ua.happycash.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import ua.happycash.database.entity.User;
import ua.happycash.dto.user.UserCreateEditDto;

public interface UserService extends UserDetailsService, OAuth2UserService<OidcUserRequest, OidcUser> {
    void create(UserCreateEditDto userDto);

    User getById(String id);
    User getByEmail(String email);
}
