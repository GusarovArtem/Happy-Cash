package ua.happycash.database.entity.creaditCard;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ua.happycash.database.entity.transaction.expense.Expense;
import ua.happycash.database.entity.transaction.Transaction;

import java.util.List;

@Data
@Document
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditCardInfo {

    @Id
    String id;

    CreditCard creditCard;

    Long balance;

    String name;

    Long creditLimit;

    List<Transaction> transactions;

    List<Expense> expenses;

}
