package kodlamaio.humanresources.core.utilities.Base;

import kodlamaio.humanresources.core.utilities.results.ErrorResult;
import kodlamaio.humanresources.entities.concretes.DTO.EmployerDTO;
import kodlamaio.humanresources.entities.concretes.DTO.JobSeekerDTO;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BaseRegisterController {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }


    public boolean seekerUserValidate(JobSeekerDTO jobSeekerDTO) {
        if (jobSeekerDTO.getEmail().isEmpty() || jobSeekerDTO.getPassword().isEmpty() ||
                jobSeekerDTO.getFirstName().isEmpty() || jobSeekerDTO.getLastName().isEmpty() ||
                jobSeekerDTO.getIdentyNo().isEmpty() || jobSeekerDTO.getVerifyPassword().isEmpty() ||
                jobSeekerDTO.getBirthDate() == null
        ) {
            return false;
        }
        return true;
    }

    public  boolean employerUserValidate(EmployerDTO employerDTO) {
        if (employerDTO.getEmail().isEmpty() ||
            employerDTO.getPassword().isEmpty() ||
            employerDTO.getVerifyPassword().isEmpty() ||
            employerDTO.getCompanyName().isEmpty() ||
            employerDTO.getCompanyWebsite().isEmpty() ||
            employerDTO.getCompanyPhone().isEmpty()
        ) {
            return false;
        }
        return true;
    }
    public  boolean isValidCompanyMail(String companyWebSite,String email){
        String[] str = email.split("@");
        String mailReg = str[1];
        String domain = mailReg.split("\\.")[0];
        return companyWebSite.matches(domain);
    }
}
