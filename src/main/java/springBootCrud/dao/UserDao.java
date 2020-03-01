package springBootCrud.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springBootCrud.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
