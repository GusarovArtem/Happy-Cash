package ua.happycash.service.wallet;

import ua.happycash.database.entity.user.User;
import ua.happycash.dto.wallet.WalletCreateEditDto;
import ua.happycash.dto.wallet.WalletReadDto;

import java.util.Optional;

public interface WalletService {

    Optional<WalletReadDto> getById(String id);

    Optional<WalletReadDto> create(WalletCreateEditDto walletCreateEditDto);

    Optional<WalletReadDto> update(String id, WalletCreateEditDto walletCreateEditDto);

    Optional<WalletReadDto> getAllByUser(User user);

    Optional<WalletReadDto> getAllByUserAndId(User user, String id);

    boolean delete(String id);
}
