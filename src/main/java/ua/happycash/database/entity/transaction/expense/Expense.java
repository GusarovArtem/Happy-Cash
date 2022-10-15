package ua.happycash.database.entity.transaction.expense;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Data
@Document
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    String name;

    LocalDateTime dateTime;

    Long amount;

    ExpenseType expenseType;
}
