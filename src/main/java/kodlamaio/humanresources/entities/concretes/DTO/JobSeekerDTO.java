package kodlamaio.humanresources.entities.concretes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerDTO {
    private String email;
    private String password;
    private String verifyPassword;
    private String firstName;
    private String lastName;
    private String identyNo;
    private Date birthDate;
}
