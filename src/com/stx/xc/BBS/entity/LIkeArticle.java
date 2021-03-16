package com.stx.xc.BBS.entity;

public class LIkeArticle {
    private Integer id;
    private Integer articleid;
    private Integer like_user;

    public LIkeArticle() {
    }

    public LIkeArticle(Integer id, Integer articleid, Integer like_user) {
        this.id = id;
        this.articleid = articleid;
        this.like_user = like_user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public Integer getLike_user() {
        return like_user;
    }

    public void setLike_user(Integer like_user) {
        this.like_user = like_user;
    }

    @Override
    public String toString() {
        return "LIkeArticle{" +
                "id=" + id +
                ", articleid=" + articleid +
                ", like_user=" + like_user +
                '}';
    }
}
