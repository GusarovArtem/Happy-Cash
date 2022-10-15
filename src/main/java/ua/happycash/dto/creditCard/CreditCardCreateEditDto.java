package ua.happycash.dto.creditCard;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ua.happycash.database.entity.creaditCard.CreditCardType;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditCardCreateEditDto {

    @NotBlank(message = "Enter the desired name of the card, you can only see it in the application")
    String cardName;

    @NotBlank(message = "Enter the expiry date of the card")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-yy")
    private LocalDateTime expiryDate;

    @NotBlank(message = "Enter the cardholder name")
    String cardholderName;

    @NotBlank(message = "Enter the CVV code of the card")
    byte cvv;

    @NotBlank(message = "Enter the card number")
    String cardNumber;

    @NotBlank(message = "Choose card type")
    CreditCardType creditCardType;
}
