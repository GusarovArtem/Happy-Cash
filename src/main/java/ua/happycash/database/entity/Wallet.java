package ua.happycash.database.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Wallet {

    @Id
    String id;

    String name;

    User holder;
}
