package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TAG")
public class TagEntity {

    @Id
    @Column(name = "ID",length = 5)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TAG_TITLE")
    private String tagTitle;
//
//    @ManyToMany(mappedBy = "tagEntities")
//    private Set<articleEntity> articleEntities = new HashSet<>();

    public TagEntity() {
    }

    public TagEntity(String tagTitle) {
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
