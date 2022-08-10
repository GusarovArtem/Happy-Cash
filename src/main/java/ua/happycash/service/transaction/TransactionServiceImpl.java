package ua.happycash.service.transaction;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.happycash.database.entity.CreditCard;
import ua.happycash.database.entity.Transaction;
import ua.happycash.database.repository.TransactionRepository;
import ua.happycash.dto.transaction.TransactionCreateEditDto;
import ua.happycash.dto.transaction.TransactionReadDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<TransactionReadDto> getById(String id) {
        return transactionRepository.findById(id).map(transaction -> modelMapper.map(transaction, TransactionReadDto.class));
    }

    @Override
    @Transactional
    public Optional<TransactionReadDto> create(TransactionCreateEditDto transactionCreateEditDto) {
        return Optional.of(transactionCreateEditDto)
                .map(transaction -> modelMapper.map(transactionCreateEditDto, Transaction.class))
                .map(transactionRepository::save)
                .map(Transaction -> modelMapper.map(Transaction, TransactionReadDto.class));
    }

    @Override
    public List<TransactionReadDto> getAllByCreditCard(CreditCard creditCard) {
        return transactionRepository.findAllByCreditCard(creditCard)
                .stream().map(transaction -> modelMapper.map(transaction, TransactionReadDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean delete(String id) {
        return transactionRepository.findById(id)
                .map(entity -> {
                    transactionRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }
}
