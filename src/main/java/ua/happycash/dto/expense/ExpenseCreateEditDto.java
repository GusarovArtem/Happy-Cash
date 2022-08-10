package ua.happycash.dto.expense;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ua.happycash.database.entity.CreditCardType;
import ua.happycash.database.entity.ExpenseType;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseCreateEditDto {

    String name;

    LocalDateTime dateTime;

    Long amount;

    ExpenseType expenseType;
}
