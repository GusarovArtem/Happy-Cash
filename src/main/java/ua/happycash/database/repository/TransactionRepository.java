package ua.happycash.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.happycash.database.entity.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
