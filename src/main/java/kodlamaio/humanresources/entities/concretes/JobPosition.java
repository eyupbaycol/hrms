package kodlamaio.humanresources.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_positions")
public class JobPosition {
    @Id
    @GeneratedValue()
    @Column(name="id")
    private int id;

    @Column(name="job_position")
    private String position;

    @Column(name = "is_active")
    private char isActive;

}
