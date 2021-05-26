package kodlamaio.humanresources.business.abstracts;

import kodlamaio.humanresources.core.utilities.results.DataResult;
import kodlamaio.humanresources.core.utilities.results.Result;
import kodlamaio.humanresources.entities.concretes.DTO.JobSeekerDTO;
import kodlamaio.humanresources.entities.concretes.JobSeeker;

import java.util.List;


public interface JobSeekerService {
    DataResult<List<JobSeeker>> getJobSeekers();
    Result addUser(JobSeekerDTO jobSeeker) throws Exception;
}
