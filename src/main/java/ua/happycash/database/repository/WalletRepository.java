package ua.happycash.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.happycash.database.entity.Wallet;

@Repository
public interface WalletRepository extends MongoRepository<Wallet, String> {
}
