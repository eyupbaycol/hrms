package kodlamaio.humanresources.business.abstracts;

import kodlamaio.humanresources.core.utilities.results.DataResult;
import kodlamaio.humanresources.core.utilities.results.Result;

import kodlamaio.humanresources.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface JobAdvertisementService {
    Result addAdvertisement(JobAdvertisement jobAdvertisement) throws Exception;

    DataResult<List<JobAdvertisement>> getByIsActive(char isActive);
    DataResult<List<JobAdvertisement>> getByIsActive(char isActive, Sort sort);
    DataResult<List<JobAdvertisement>> getEmployerActiveAdversitements(char isActive, int userid);
    Result updateJobAdvertisementState(int id);

}
