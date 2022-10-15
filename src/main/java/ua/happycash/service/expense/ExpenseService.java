package ua.happycash.service.expense;

import ua.happycash.database.entity.creaditCard.CreditCard;
import ua.happycash.dto.expense.ExpenseCreateEditDto;
import ua.happycash.dto.expense.ExpenseReadDto;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    Optional<ExpenseReadDto> getById(String id);

    Optional<ExpenseReadDto> create(ExpenseCreateEditDto expenseCreateEditDto);

    boolean delete(String id);

    List<ExpenseReadDto> getAllByCreditCard(CreditCard creditCard);

}
