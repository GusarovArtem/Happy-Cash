package ua.happycash.service.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.happycash.database.repository.TransactionRepository;
import ua.happycash.dto.transaction.TransactionCreateEditDto;
import ua.happycash.dto.transaction.TransactionReadDto;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    @Override
    public Optional<TransactionReadDto> getById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<TransactionReadDto> create(TransactionCreateEditDto transactionCreateEditDto) {
        return Optional.empty();
    }

    @Override
    public Optional<TransactionReadDto> update(String id, TransactionCreateEditDto transactionCreateEditDto) {
        return Optional.empty();
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
