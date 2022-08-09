package ua.happycash.service.user;

import org.springframework.stereotype.Service;
import ua.happycash.dto.user.UserCreateEditDto;
import ua.happycash.dto.user.UserReadDto;

import java.util.Optional;

@Service
public interface UserService {

    Optional<UserReadDto> getById(String id);

    Optional<UserReadDto> create(UserCreateEditDto userCreateEditDto);

    Optional<UserReadDto> update(String id, UserCreateEditDto userCreateEditDto);

    boolean delete(String id);
}
