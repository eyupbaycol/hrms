package kodlamaio.humanresources.dataAccess.abstracts;


import kodlamaio.humanresources.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
}
