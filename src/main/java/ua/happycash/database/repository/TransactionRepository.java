package ua.happycash.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.happycash.database.entity.CreditCard;
import ua.happycash.database.entity.Transaction;
import ua.happycash.dto.transaction.TransactionReadDto;

import java.util.Optional;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    Optional<TransactionReadDto> findAllByCreditCard(CreditCard creditCard);
}
