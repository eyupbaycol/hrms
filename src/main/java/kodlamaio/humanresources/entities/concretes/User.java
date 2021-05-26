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
@Table(name="users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="email", unique=true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_active")
    private char   isActive;

    @Column(name = "change_time")
    private Date changeTime;

    public User(String email, String password, char isActive, Date changeTime){
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.changeTime = changeTime;
    }

}
