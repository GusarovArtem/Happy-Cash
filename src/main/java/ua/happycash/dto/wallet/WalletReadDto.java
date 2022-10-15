package ua.happycash.dto.wallet;

import lombok.Builder;
import lombok.Value;
import ua.happycash.database.entity.user.User;

@Builder
@Value
public class WalletReadDto {

    String id;

    String name;

    User user;
}
