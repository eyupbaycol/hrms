package kodlamaio.humanresources.dataAccess.abstracts;

import kodlamaio.humanresources.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
}
