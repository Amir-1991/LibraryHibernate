package entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "ROLL")
public class rollEntity {

    @Id
    @Column(name = "ID" ,length = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ROLL_NAME")
    private String rollName;

    public rollEntity() {
    }

    public rollEntity(String rollName) {
        this.rollName = rollName;
    }

    @Override
    public String toString() {
        return "rollEntity{" +
                "id=" + id +
                ", rollName='" + rollName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }
}
