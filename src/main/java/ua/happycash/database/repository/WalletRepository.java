package ua.happycash.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.happycash.database.entity.User;
import ua.happycash.database.entity.Wallet;
import ua.happycash.dto.wallet.WalletReadDto;

import java.util.List;

@Repository
public interface WalletRepository extends MongoRepository<Wallet, String> {

    List<WalletReadDto> getAllForUser(User user);
}
