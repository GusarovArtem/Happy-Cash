package ua.happycash.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.happycash.database.entity.CreditCard;
import ua.happycash.database.entity.Expense;
import ua.happycash.dto.expense.ExpenseReadDto;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {

    Optional<ExpenseReadDto> findAllByCreditCard(CreditCard creditCard);
}
