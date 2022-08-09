package ua.happycash.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.happycash.database.entity.Expense;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
}
