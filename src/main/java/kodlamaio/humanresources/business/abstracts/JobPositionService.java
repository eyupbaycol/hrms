package kodlamaio.humanresources.business.abstracts;

import kodlamaio.humanresources.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {
    List<JobPosition> getJobList();
}
