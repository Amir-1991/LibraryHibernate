package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TAG")
public class tagEntity {

    @Id
    @Column(name = "ID",length = 5)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(targetEntity = articleEntity.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "ARTICLE_TAG",
            joinColumns = { @JoinColumn(name = "TAG_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ARTICLE_ID") })
    private List<articleEntity> article;

    @Column(name = "TAG_TITLE")
    private String tagTitle;

    public tagEntity() {
    }

    public tagEntity(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    @Override
    public String toString() {
        return "tagEntity{" +
                "id=" + id +
                ", tagTitle='" + tagTitle + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }
}
