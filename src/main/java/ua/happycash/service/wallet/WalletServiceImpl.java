package ua.happycash.service.wallet;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.happycash.database.entity.wallet.Wallet;
import ua.happycash.database.repository.WalletRepository;
import ua.happycash.dto.wallet.WalletCreateEditDto;
import ua.happycash.dto.wallet.WalletReadDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

        private final WalletRepository walletRepository;

        private final ModelMapper modelMapper;

        @Override
        public Optional<WalletReadDto> getById(String id) {
                return walletRepository.findById(id).map(wallet -> modelMapper.map(wallet, WalletReadDto.class));
        }

        @Override
        @Transactional
        public Optional<WalletReadDto> create(WalletCreateEditDto walletCreateEditDto) {
                return Optional.of(walletCreateEditDto)
                        .map(wallet -> modelMapper.map(walletCreateEditDto, Wallet.class))
                        .map(walletRepository::save)
                        .map(wallet -> modelMapper.map(wallet, WalletReadDto.class));
        }

        @Transactional
        public Optional<WalletReadDto> update(String id, WalletCreateEditDto scheduleDto) {
                return walletRepository.findById(id)
                        .map(entity -> {
                                Wallet mappedEntity = modelMapper.map(scheduleDto, Wallet.class);
                                mappedEntity.setId(entity.getId());
                                return mappedEntity;
                        })
                        .map(walletRepository::save)
                        .map(schedule -> modelMapper.map(schedule, WalletReadDto.class));
        }

        @Override
        public Optional<WalletReadDto> getAllForUser(OAuth2User oAuth2User) {
                return Optional.empty();
        }

        @Override
        public List<Wallet> getForUserByWalletId(OAuth2User oAuth2User, String id) {
                return walletRepository.findAll();
        }

        @Transactional
        public boolean delete(String id) {
                return walletRepository.findById(id)
                        .map(entity -> {
                                walletRepository.deleteById(id);
                                return true;
                        })
                        .orElse(false);
        }
}
