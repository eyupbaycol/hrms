package kodlamaio.humanresources.business.concretes;

import com.fasterxml.jackson.databind.ser.Serializers;
import kodlamaio.humanresources.business.abstracts.JobSeekerService;
import kodlamaio.humanresources.business.abstracts.UserService;
import kodlamaio.humanresources.core.adapters.abstracts.CheckRealPerson;
import kodlamaio.humanresources.core.adapters.concretes.MernisServiceAdapter;
import kodlamaio.humanresources.core.utilities.Base.BaseRegisterController;
import kodlamaio.humanresources.core.utilities.results.*;
import kodlamaio.humanresources.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.humanresources.entities.concretes.DTO.JobSeekerDTO;
import kodlamaio.humanresources.entities.concretes.JobSeeker;
import kodlamaio.humanresources.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;
    private UserService userService;
    @Qualifier(value = "MernisServiceAdaptar" )
    private CheckRealPerson checkRealPerson;
    private BaseRegisterController baseRegisterController;

    @Override
    public DataResult<List<JobSeeker>> getJobSeekers() {
        return new SuccessDataResult<List<JobSeeker>>
                (this.jobSeekerDao.findAll(),"Jobseeker listesi başarıyla listelendi");
    }

    @Override
    public Result addUser(JobSeekerDTO jobSeekerDTO) throws Exception {
        if(!baseRegisterController.seekerUserValidate(jobSeekerDTO)){
            return new ErrorResult("Lütfen zorunlu tüm alanları doldurun");
        }
        if(!baseRegisterController.isValidEmail(jobSeekerDTO.getEmail())){
            return new ErrorResult("Lütfen geçerli bir mail adresi giriniz");
        }
        if(!jobSeekerDTO.getVerifyPassword().equals(jobSeekerDTO.getPassword()) ){
            return new ErrorResult("Girdiğiniz parola eşleşmiyor");
        }

        if(!checkRealPerson.CheckIfRealPerson(Long.parseLong(jobSeekerDTO.getIdentyNo()),jobSeekerDTO.getFirstName(),jobSeekerDTO.getLastName(),jobSeekerDTO.getBirthDate())){
            return new ErrorResult("Lütfen geçerli bilgiler girdiğinizden emin olun");
        }
        User user = new User(
                jobSeekerDTO.getEmail(),
                jobSeekerDTO.getPassword(),
                ' ',
                null);

        this.userService.addUser(user);

        JobSeeker jobSeeker = new JobSeeker(
                user.getId(),
                jobSeekerDTO.getFirstName(),
                jobSeekerDTO.getLastName(),
                jobSeekerDTO.getIdentyNo(),
                jobSeekerDTO.getBirthDate());
        this.jobSeekerDao.save(jobSeeker);

         return new SuccessResult("Başarıyla Kayıt Olundu");

    }
}
