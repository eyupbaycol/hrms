package kodlamaio.humanresources.business.concretes;

import kodlamaio.humanresources.business.abstracts.EmployerService;
import kodlamaio.humanresources.business.abstracts.UserService;
import kodlamaio.humanresources.core.utilities.Base.BaseRegisterController;
import kodlamaio.humanresources.core.utilities.results.*;
import kodlamaio.humanresources.dataAccess.abstracts.EmployerDao;
import kodlamaio.humanresources.entities.concretes.DTO.EmployerDTO;
import kodlamaio.humanresources.entities.concretes.Employer;
import kodlamaio.humanresources.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployerManager implements EmployerService {
    private UserService userService;
    private EmployerDao employerDao;
    private BaseRegisterController baseRegisterController;


    @Override
    public DataResult<List<Employer>> getEmployer() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employer listesi başarıyla listelendi");
    }

    @Override
    public Result addUser(EmployerDTO employerDTO) throws Exception {
        if(!baseRegisterController.employerUserValidate(employerDTO)){
            return new ErrorResult("Lütfen zorunlu tüm alanları doldurun");
        }
        if(!baseRegisterController.isValidEmail(employerDTO.getEmail())){
            return new ErrorResult("Lütfen geçerli bir mail adresi giriniz");
        }
//        if(!baseRegisterController.isValidCompanyMail(employerDTO.getCompanyWebsite(),employerDTO.getEmail())){
//            return new ErrorResult("Lütfen geçerli bir şirket mail adresi giriniz");
//        }
        User user = new User(
                employerDTO.getEmail(),
                employerDTO.getPassword(),
                ' ',
                null);

        this.userService.addUser(user);
        Employer employer = new Employer(
                user.getId(),
                employerDTO.getCompanyName(),
                employerDTO.getCompanyWebsite(),
                employerDTO.getCompanyPhone());
        this.employerDao.save(employer);
        return new SuccessResult("Başarı ile kayıt olundu");
    }
}
