package ua.happycash.service.creaditCard;

import org.springframework.stereotype.Service;
import ua.happycash.database.entity.User;
import ua.happycash.dto.creditCard.CreditCardCreateEditDto;
import ua.happycash.dto.creditCard.CreditCardReadDto;

import java.util.List;
import java.util.Optional;

@Service
public interface CreditCardService {

    Optional<CreditCardReadDto> getById(String id);

    List<CreditCardReadDto> getAllByAuthor(User User);

    Optional<CreditCardReadDto> createName(CreditCardCreateEditDto creditCardCreateEditDto);

    Optional<CreditCardReadDto> updateName(String id, CreditCardCreateEditDto creditCardCreateEditDto);

    boolean delete(String id);
}
