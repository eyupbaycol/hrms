package kodlamaio.humanresources.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_seekers")

public class JobSeeker {

    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "identity_no", nullable = false,unique=true)
    private String identyNo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

    public JobSeeker(int userId, String firstName, String lastName, String identyNo, Date birthDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identyNo = identyNo;
        this.birthDate = birthDate;
    }
}
