package entity;

import javax.persistence.*;

@Entity
@Table(name = "ARTICLE_TAG")
public class tagArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    articleEntity articleEntityId;

    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    tagEntity tagEntityId;

    public tagArticleEntity() {
    }

    public tagArticleEntity(articleEntity articleEntityId, tagEntity tagEntityId) {
        this.articleEntityId = articleEntityId;
        this.tagEntityId = tagEntityId;
    }

    @Override
    public String toString() {
        return "tagArticle{" +
                "id=" + id +
                ", articleEntityId=" + articleEntityId +
                ", tagEntityId=" + tagEntityId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public articleEntity getArticleEntityId() {
        return articleEntityId;
    }

    public void setArticleEntityId(articleEntity articleEntityId) {
        this.articleEntityId = articleEntityId;
    }

    public tagEntity getTagEntityId() {
        return tagEntityId;
    }

    public void setTagEntityId(tagEntity tagEntityId) {
        this.tagEntityId = tagEntityId;
    }
}
