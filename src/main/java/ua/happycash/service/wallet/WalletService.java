package ua.happycash.service.wallet;

import org.springframework.security.oauth2.core.user.OAuth2User;
import ua.happycash.database.entity.Wallet;
import ua.happycash.dto.wallet.WalletCreateEditDto;
import ua.happycash.dto.wallet.WalletReadDto;

import java.util.List;
import java.util.Optional;

public interface WalletService {

    Optional<WalletReadDto> getById(String id);

    Optional<WalletReadDto> create(WalletCreateEditDto walletCreateEditDto);

    Optional<WalletReadDto> update(String id, WalletCreateEditDto walletCreateEditDto);

    Optional<WalletReadDto> getAllForUser(OAuth2User oAuth2User);

    List<Wallet> getForUserByWalletId(OAuth2User oAuth2User, String id);

    boolean delete(String id);
}
