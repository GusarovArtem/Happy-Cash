package ua.happycash.service.expense;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.happycash.database.entity.creaditCard.CreditCard;
import ua.happycash.database.entity.transaction.expense.Expense;
import ua.happycash.database.repository.ExpenseRepository;
import ua.happycash.dto.expense.ExpenseCreateEditDto;
import ua.happycash.dto.expense.ExpenseReadDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<ExpenseReadDto> getById(String id) {
        return expenseRepository.findById(id).map(expense -> modelMapper.map(expense, ExpenseReadDto.class));
    }

    @Override
    @Transactional
    public Optional<ExpenseReadDto> create(ExpenseCreateEditDto expenseCreateEditDto) {
        return Optional.of(expenseCreateEditDto)
                .map(expense -> modelMapper.map(expenseCreateEditDto, Expense.class))
                .map(expenseRepository::save)
                .map(expense -> modelMapper.map(expense, ExpenseReadDto.class));
    }

    @Override
    public List<ExpenseReadDto> getAllByCreditCard(CreditCard creditCard) {
        return expenseRepository.findAllByCreditCard(creditCard)
                .stream().map(expense -> modelMapper.map(expense, ExpenseReadDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean delete(String id) {
        return expenseRepository.findById(id)
                .map(entity -> {
                    expenseRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }

}
