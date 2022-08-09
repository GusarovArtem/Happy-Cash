package ua.happycash.service.transaction;

import org.springframework.stereotype.Service;
import ua.happycash.dto.expense.ExpenseCreateEditDto;
import ua.happycash.dto.expense.ExpenseReadDto;
import ua.happycash.dto.transaction.TransactionCreateEditDto;
import ua.happycash.dto.transaction.TransactionReadDto;

import java.util.Optional;

@Service
public interface TransactionService {

    Optional<TransactionReadDto> getById(String id);

    Optional<TransactionReadDto> create(TransactionCreateEditDto transactionCreateEditDto);

    Optional<TransactionReadDto> update(String id, TransactionCreateEditDto transactionCreateEditDto);

    boolean delete(String id);
}
