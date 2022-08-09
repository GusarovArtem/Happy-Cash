package ua.happycash.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.happycash.database.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
