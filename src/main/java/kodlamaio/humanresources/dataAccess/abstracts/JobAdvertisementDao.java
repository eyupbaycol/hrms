package kodlamaio.humanresources.dataAccess.abstracts;

import kodlamaio.humanresources.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {
    List<JobAdvertisement> getByIsActive(char isActive);
    List<JobAdvertisement> getByIsActive(char isActive, Sort sort);
    List<JobAdvertisement> getByIsActiveAndEmployer_UserId(char isActive, int userid);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update JobAdvertisement j set j.isActive='Y' where j.id=?1")
    void updateJobAdvertisementState(int id);
}
