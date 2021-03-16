package com.stx.xc.BBS.entity;

import java.util.Date;

public class Comment extends Base {
    private int commentID;
    private int articleID;
    private Article article;
    private User user;
    private String content;
    private Date addTime;
    private String addTimeString;
    private Integer status;

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", articleID=" + articleID +
                ", article=" + article +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", addTime=" + addTime +
                ", addTimeString='" + addTimeString + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }

    public Comment(int commentID, int articleID, Article article, User user, String content, Date addTime, String addTimeString, Integer status) {
        this.commentID = commentID;
        this.articleID = articleID;
        this.article = article;
        this.user = user;
        this.content = content;
        this.addTime = addTime;
        this.addTimeString = addTimeString;
        this.status = status;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddTimeString() {
        return addTimeString;
    }

    public void setAddTimeString(String addTimeString) {
        this.addTimeString = addTimeString;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
