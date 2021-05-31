package kodlamaio.humanresources.business.concretes;

import kodlamaio.humanresources.business.abstracts.JobAdvertisementService;
import kodlamaio.humanresources.core.utilities.results.DataResult;
import kodlamaio.humanresources.core.utilities.results.Result;
import kodlamaio.humanresources.core.utilities.results.SuccessDataResult;
import kodlamaio.humanresources.core.utilities.results.SuccessResult;
import kodlamaio.humanresources.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.humanresources.entities.concretes.DTO.JobAdvertiesemenDTO;
import kodlamaio.humanresources.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result addAdvertisement(JobAdvertisement jobAdvertisement) throws Exception {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("İş ilanı başarı ile eklendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByIsActive(char isActive) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(isActive), "iş ilanları listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByIsActive(char isActive, Sort sort) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(isActive, sort), "iş ilanları listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getEmployerActiveAdversitements(char isActive, int userid) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveAndEmployer_UserId(isActive,userid),"iş ilanları listelendi");
    }

    @Override
    public Result updateJobAdvertisementState(int id) {
        return new SuccessResult("Başarı ile güncellendi");
    }
}
