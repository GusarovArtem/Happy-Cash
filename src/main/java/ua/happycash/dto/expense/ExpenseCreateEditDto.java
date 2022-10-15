package ua.happycash.dto.expense;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ua.happycash.database.entity.transaction.expense.ExpenseType;

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
