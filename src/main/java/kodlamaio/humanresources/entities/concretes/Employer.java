package kodlamaio.humanresources.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@Entity
public class Employer {
    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name= "company_website", nullable = false)
    private String companyWebsite;

    @Column(name = "company_phone", nullable = false)
    private  String companyPhone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    private User user;

    public Employer(int userId, String companyName, String companyWebsite, String companyPhone ) {
        this.userId = userId;
        this.companyName = companyName;
        this.companyWebsite = companyWebsite;
        this.companyPhone = companyPhone;
    }
}
