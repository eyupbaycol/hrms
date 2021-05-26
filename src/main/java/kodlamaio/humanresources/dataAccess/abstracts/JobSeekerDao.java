package kodlamaio.humanresources.dataAccess.abstracts;

import kodlamaio.humanresources.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
}
