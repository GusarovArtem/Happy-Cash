package ua.happycash.dto.expense;

import lombok.Builder;
import lombok.Value;
import ua.happycash.database.entity.transaction.expense.ExpenseType;

import java.time.LocalDateTime;

@Builder
@Value
public class ExpenseReadDto {

    String id;

    String name;

    LocalDateTime dateTime;

    Long amount;

    ExpenseType expenseType;
}
