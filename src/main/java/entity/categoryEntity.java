package entity;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class categoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESC")
    private Long desc;

    public categoryEntity() {
    }

    public categoryEntity(String title, Long desc) {
        this.title = title;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "categoryEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc=" + desc +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDesc() {
        return desc;
    }

    public void setDesc(Long desc) {
        this.desc = desc;
    }
}
