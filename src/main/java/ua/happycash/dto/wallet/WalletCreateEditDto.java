package ua.happycash.dto.wallet;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ua.happycash.database.entity.user.User;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WalletCreateEditDto {

    @NotBlank(message = "Enter the desired name of the wallet, you can only see it in the application")
    String name;

    User user;
}