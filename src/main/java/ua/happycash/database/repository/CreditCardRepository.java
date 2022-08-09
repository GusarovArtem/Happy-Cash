package ua.happycash.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.happycash.database.entity.CreditCard;

@Repository
public interface CreditCardRepository extends MongoRepository<CreditCard, String> {

}
