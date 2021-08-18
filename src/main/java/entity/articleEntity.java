package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ARTICLE")
public class articleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ARTICLE_ID")
    private Long id;

    @ManyToMany(targetEntity = articleEntity.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "ARTICLE_TAG",
            joinColumns = {@JoinColumn(name = "ARTICLE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TAG_ID")})
    private List<tagEntity> tag;

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

    public articleEntity() {
    }

    public articleEntity(String title,
                         String brief,
                         String content,
                         LocalDate creatDate,
                         boolean isPublished,
                         LocalDate publishedDate,
                         LocalDate lastUpdateDate) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.creatDate = creatDate;
        this.isPublished = isPublished;
        this.publishedDate = publishedDate;
        this.lastUpdateDate = lastUpdateDate;
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
}