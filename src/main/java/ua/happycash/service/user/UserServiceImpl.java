package ua.happycash.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.happycash.database.repository.UserRepository;
import ua.happycash.dto.user.UserCreateEditDto;
import ua.happycash.dto.user.UserReadDto;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Optional<UserReadDto> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserReadDto> create(UserCreateEditDto userCreateEditDto) {
        return Optional.empty();
    }

    @Override
    public Optional<UserReadDto> update(String id, UserCreateEditDto userCreateEditDto) {
        return Optional.empty();
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
