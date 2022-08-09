package ua.happycash.service.wallet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.happycash.database.repository.WalletRepository;
import ua.happycash.dto.wallet.WalletCreateEditDto;
import ua.happycash.dto.wallet.WalletReadDto;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

        private final WalletRepository walletRepository;

        @Override
        public Optional<WalletReadDto> getById(String id) {
                return Optional.empty();
        }

        @Override
        public Optional<WalletReadDto> create(WalletCreateEditDto walletCreateEditDto) {
                return Optional.empty();
        }

        @Override
        public Optional<WalletReadDto> update(String id, WalletCreateEditDto walletCreateEditDto) {
                return Optional.empty();
        }

        @Override
        public boolean delete(String id) {
                return false;
        }
}
