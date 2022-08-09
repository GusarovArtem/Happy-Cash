package ua.happycash.service.expense;

import org.springframework.stereotype.Service;
import ua.happycash.dto.expense.ExpenseCreateEditDto;
import ua.happycash.dto.expense.ExpenseReadDto;

import java.util.Optional;

@Service
public interface ExpenseService {

    Optional<ExpenseReadDto> getById(String id);

    Optional<ExpenseReadDto> create(ExpenseCreateEditDto expenseCreateEditDto);

    Optional<ExpenseReadDto> update(String id, ExpenseCreateEditDto expenseCreateEditDto);

    boolean delete(String id);
}
