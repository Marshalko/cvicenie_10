package sk.stuba.fei.oop.cvicenie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {

    Optional<User> findById(Long id);
}
