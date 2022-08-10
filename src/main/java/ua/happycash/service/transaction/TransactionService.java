package ua.happycash.service.transaction;

import org.springframework.stereotype.Service;
import ua.happycash.database.entity.CreditCard;
import ua.happycash.dto.transaction.TransactionCreateEditDto;
import ua.happycash.dto.transaction.TransactionReadDto;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    Optional<TransactionReadDto> getById(String id);

    Optional<TransactionReadDto> create(TransactionCreateEditDto transactionCreateEditDto);

    boolean delete(String id);

    List<TransactionReadDto> getAllByCreditCard(CreditCard creditCard);
}
