package ua.happycash.service.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ua.happycash.configuration.WebSecurityConfig;
import ua.happycash.database.entity.Role;
import ua.happycash.database.entity.User;
import ua.happycash.database.repository.UserRepository;
import ua.happycash.dto.user.UserCreateEditDto;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void create(UserCreateEditDto userDto) {
        Optional.of(userDto)
                .map(this::copyToEntity)
                .map( user -> {
                    userRepository.save(user);
                    return user;
                });
    }

    @Override
    public User getById(String id) {
        return userRepository.getById(id);
    }

    @Override
    public User getByEmail(String email) {
        Optional<User> userFindByEmail = userRepository.findByEmail(email);

        if(userFindByEmail.isPresent()) {
            return userFindByEmail.get();
        } else {
            throw new UsernameNotFoundException("Failed to retrieve user");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> userFindByEmail = userRepository.findByEmail(username);
        Optional<User> userFindByUsername = userRepository.findByUsername(username);

        if(userFindByEmail.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    userFindByEmail.get().getEmail(),
                    userFindByEmail.get().getPassword(),
                    Collections.singleton(userFindByEmail.get().getRole()));
        }

        if(userFindByUsername.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                    userFindByUsername.get().getEmail(),
                    userFindByUsername.get().getPassword(),
                    Collections.singleton(userFindByUsername.get().getRole()));
        }

        throw new UsernameNotFoundException("Failed to retrieve user");
    }


    @Transactional
    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        String username = userRequest.getIdToken().getClaim("email");
        UserDetails userDetails = getUserDetails(userRequest, username);

        DefaultOidcUser oidcUser = new DefaultOidcUser(userDetails.getAuthorities(), userRequest.getIdToken());

        Set<Method> userDetailsMethods = Set.of(UserDetails.class.getMethods());

        return (OidcUser) Proxy.newProxyInstance(WebSecurityConfig.class.getClassLoader(),
                new Class[]{UserDetails.class, OidcUser.class},
                (proxy, method, args) -> userDetailsMethods.contains(method)
                        ? method.invoke(userDetails, args)
                        : method.invoke(oidcUser, args));
    }

    private UserDetails getUserDetails(OidcUserRequest userRequest, String email) {
        return userRepository.findByEmail(email)
                .map(user -> new org.springframework.security.core.userdetails.User(email, user.getPassword(), Collections.singleton(user.getRole())))
                .orElseGet(() -> {
                    String firstname = userRequest.getIdToken().getClaim("given_name");
                    Role role = Role.USER;
                    String password = UUID.randomUUID().toString();
                    User user = User.builder()
                            .username(firstname)
                            .email(email)
                            .password(password)
                            .role(role)
                            .build();

                    return Optional.of(user)
                            .map(userRepository::save)
                            .map(u -> new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), Collections.singleton(u.getRole())))
                            .orElseThrow();
                });
    }

    private User copyToEntity(UserCreateEditDto userDto) {
        User mappedEntity = modelMapper.map(userDto, User.class);
        mappedEntity.setRole(Role.USER);
        Optional.ofNullable(userDto.getRawPassword())
                .filter(StringUtils::hasText)
                .map(passwordEncoder::encode)
                .ifPresent(mappedEntity::setPassword);
        return mappedEntity;
    }
}