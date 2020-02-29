package springBootCrud.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springBootCrud.model.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {

    Role findRoleById(Long id);

}
