package entity;

import javax.persistence.*;

@Entity
@Table(name = "ROLL")
public class rollEntity {

    @Id
    @Column(name = "ID", length = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ROLL_TITLE")
    private String rollTitle;

    public rollEntity() {
    }

    public rollEntity(String rollTitle) {
        this.rollTitle = rollTitle;
    }

    @Override
    public String toString() {
        return "rollEntity{" +
                "id=" + id +
                ", rollTitle='" + rollTitle + '\'' +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRollTitle() {
        return rollTitle;
    }

    public void setRollTitle(String rollTitle) {
        this.rollTitle = rollTitle;
    }
}
