package ua.happycash.service.creaditCard;

import ua.happycash.database.entity.wallet.Wallet;
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
