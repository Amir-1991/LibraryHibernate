package entity;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class categoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID",length = 2)
    private Long id;

    @Column(name = "TITLE",length = 30)
    private String title;

    @Column(name = "DESC",length = 100)
    private String desc;

    public categoryEntity() {
    }

    public categoryEntity(String title, String desc) {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
