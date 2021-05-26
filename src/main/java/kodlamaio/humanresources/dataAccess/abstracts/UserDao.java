package kodlamaio.humanresources.dataAccess.abstracts;

import kodlamaio.humanresources.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
