package kodlamaio.humanresources.entities.concretes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activation_codes")
public class ActivationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;

    @Column(name="user_id")
    private int userId;

    @Column(name = "activaiton_code")
    private String activaitonCode;

    @Column(name = "is_confirmed")
    private char isConfirmed;

    @Column(name = "confirmed_date")
    private Date confirmedDate;

    @ManyToOne
    private JobSeeker jobSeeker;
}
