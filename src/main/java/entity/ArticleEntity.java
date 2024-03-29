package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ARTICLE")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ARTICLE_ID")
    private Long id;

    @ManyToMany(cascade = { CascadeType.ALL })
    private Set<TagEntity> tagEntities = new HashSet<>();

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BRIEF")
    private String brief;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CREAT_DATE")
    private LocalDate creatDate;

    @Column(name = "IS_PUBLISHED")
    private boolean isPublished;

    @Column(name = "PUBLISHED_DATE")
    private LocalDate publishedDate;

    @Column(name = "LAST_UPDATE_DATE")
    private LocalDate lastUpdateDate;

    public ArticleEntity() {
    }

    public ArticleEntity(String title,
                         String brief,
                         String content,
                         LocalDate creatDate,
                         boolean isPublished,
                         LocalDate publishedDate,
                         LocalDate lastUpdateDate,
                         Set<TagEntity> tagEntities) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.creatDate = creatDate;
        this.isPublished = isPublished;
        this.publishedDate = publishedDate;
        this.lastUpdateDate = lastUpdateDate;
        this.tagEntities = tagEntities;
    }

    @Override
    public String toString() {
        return "articleEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", creatDate=" + creatDate +
                ", isPublished=" + isPublished +
                ", publishedDate=" + publishedDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", tagEntities=" + tagEntities +
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(LocalDate creatDate) {
        this.creatDate = creatDate;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Set<TagEntity> getTagEntities() {
        return tagEntities;
    }

    public void setTagEntities(Set<TagEntity> tagEntities) {
        this.tagEntities = tagEntities;
    }
}