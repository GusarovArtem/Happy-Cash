package ua.happycash.dto.user;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserReadDto {

    String id;

    String name;

    String email;

    String password;

    String phoneNumber;

    String role;
}
