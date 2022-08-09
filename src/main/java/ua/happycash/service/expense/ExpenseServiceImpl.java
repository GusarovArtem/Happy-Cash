package ua.happycash.service.expense;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.happycash.database.repository.ExpenseRepository;
import ua.happycash.dto.expense.ExpenseCreateEditDto;
import ua.happycash.dto.expense.ExpenseReadDto;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Override
    public Optional<ExpenseReadDto> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<ExpenseReadDto> create(ExpenseCreateEditDto expenseCreateEditDto) {
        return Optional.empty();
    }

    @Override
    public Optional<ExpenseReadDto> update(String id, ExpenseCreateEditDto expenseCreateEditDto) {
        return Optional.empty();
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
