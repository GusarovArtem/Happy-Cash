package ua.happycash.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.happycash.database.entity.creaditCard.CreditCard;
import ua.happycash.database.entity.wallet.Wallet;
import ua.happycash.dto.creditCard.CreditCardReadDto;

import java.util.Optional;

@Repository
public interface CreditCardRepository extends MongoRepository<CreditCard, String> {

    Optional<CreditCardReadDto> findAllByWallet(Wallet wallet);
}
