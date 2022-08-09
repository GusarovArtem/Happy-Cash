package ua.happycash.service.creaditCard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.happycash.database.entity.User;
import ua.happycash.database.repository.CreditCardRepository;
import ua.happycash.dto.creditCard.CreditCardCreateEditDto;
import ua.happycash.dto.creditCard.CreditCardReadDto;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService{

    private final CreditCardRepository creditCardRepository;

    @Override
    public Optional<CreditCardReadDto> getById(String id) {
        return Optional.empty();
    }

    @Override
    public List<CreditCardReadDto> getAllByAuthor(User User) {
        return null;
    }

    @Override
    public Optional<CreditCardReadDto> createName(CreditCardCreateEditDto scheduleCreateEditDto) {
        return Optional.empty();
    }

    @Override
    public Optional<CreditCardReadDto> updateName(String id, CreditCardCreateEditDto scheduleCreateEditDto) {
        return Optional.empty();
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
