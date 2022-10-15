package ua.happycash.database.entity.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false, of = "id")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Holder extends User {

    @Enumerated(EnumType.STRING)
    Role role = Role.HOLDER;
}
