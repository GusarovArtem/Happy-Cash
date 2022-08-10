package ua.happycash.service.wallet;

import org.springframework.stereotype.Service;
import ua.happycash.dto.wallet.WalletCreateEditDto;
import ua.happycash.dto.wallet.WalletReadDto;

import java.util.Optional;

public interface WalletService {

    Optional<WalletReadDto> getById(String id);

    Optional<WalletReadDto> create(WalletCreateEditDto walletCreateEditDto);

    Optional<WalletReadDto> update(String id, WalletCreateEditDto walletCreateEditDto);

    boolean delete(String id);
}
