package kodlamaio.humanresources.entities.concretes;

import javax.persistence.*;

@Entity
@Table(name="job_positions")
public class JobPosition {
    @Id
    @GeneratedValue()
    @Column(name="id")
    private int id;

    @Column(name="position")
    private String position;

    public JobPosition() {
    }

    public JobPosition(int id, String position) {
        this.id = id;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
