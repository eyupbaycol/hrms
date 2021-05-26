package kodlamaio.humanresources.entities.concretes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerDTO {
    private String email;
    private String password;
    private String verifyPassword;
    private String companyName;
    private String companyWebsite;
    private String companyPhone;
}
