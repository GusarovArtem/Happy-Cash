package ua.happycash.database.entity.wallet;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ua.happycash.database.entity.user.Holder;
import ua.happycash.database.entity.user.User;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Document
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    String name;

    User user;
}
