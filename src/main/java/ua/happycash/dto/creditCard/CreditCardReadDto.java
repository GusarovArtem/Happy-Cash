package ua.happycash.dto.creditCard;


import lombok.Builder;
import lombok.Value;
import ua.happycash.database.entity.creaditCard.CreditCardType;

import java.time.LocalDateTime;

@Builder
@Value
public class CreditCardReadDto {

    String id;

    String cardName;

    String cardholderName;

    byte cvv;

    String cardNumber;

    LocalDateTime expiryDate;

    CreditCardType creditCardType;
}
