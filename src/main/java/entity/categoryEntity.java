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

    @Column(name = "DESCRIPTION",length = 100)
    private String description;

    public categoryEntity() {
    }

    public categoryEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "categoryEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
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
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
    }
}
