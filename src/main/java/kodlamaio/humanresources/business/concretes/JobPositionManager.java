package kodlamaio.humanresources.business.concretes;

import kodlamaio.humanresources.business.abstracts.JobPositionService;
import kodlamaio.humanresources.dataAccess.abstracts.JobPositionDao;
import kodlamaio.humanresources.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public List<JobPosition> getJobList() {
        return this.jobPositionDao.findAll();
    }
}
