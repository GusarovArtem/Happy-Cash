package ua.happycash.service.creaditCard;

import org.springframework.stereotype.Service;
import ua.happycash.database.entity.User;
import ua.happycash.database.entity.Wallet;
import ua.happycash.dto.creditCard.CreditCardCreateEditDto;
import ua.happycash.dto.creditCard.CreditCardReadDto;

import java.util.List;
import java.util.Optional;

public interface CreditCardService {

    Optional<CreditCardReadDto> getById(String id);

    List<CreditCardReadDto> getAllByWallet(Wallet wallet);

    Optional<CreditCardReadDto> create(CreditCardCreateEditDto creditCardCreateEditDto);

    Optional<CreditCardReadDto> update(String id, CreditCardCreateEditDto creditCardCreateEditDto);

    boolean delete(String id);
}
