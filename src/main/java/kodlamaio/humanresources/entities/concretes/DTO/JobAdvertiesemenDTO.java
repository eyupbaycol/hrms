package kodlamaio.humanresources.entities.concretes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertiesemenDTO {
    private int jobPositionId;
    private String jobPosition;
    private int cityId;
    private String minSalary;
    private String maxSalary;
    private int employerId;
    private int positionPiece;
    private Date lastApplicaitonDate;
    private char isActive;
    private Date createDate;
}