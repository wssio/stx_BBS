package com.stx.xc.BBS.entity;

import java.util.Date;

public class Article extends Base {
    private User user;
    private String title;
    private Integer userid;
    private String summary;
    private String content;
    private String nickName;
    private Integer readTotal;
    private Integer likeTotal;
    private Integer commentTotal;
    private Date addTime;
    private String addTimeDate;
    private Integer status;


    @Override
    public String toString() {
        return "Article{" +
                "user=" + user +
                ", title='" + title + '\'' +
                ", userid=" + userid +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", nickName='" + nickName + '\'' +
                ", readTotal=" + readTotal +
                ", likeTotal=" + likeTotal +
                ", commentTotal=" + commentTotal +
                ", addTime=" + addTime +
                ", addTimeDate='" + addTimeDate + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getReadTotal() {
        return readTotal;
    }

    public void setReadTotal(Integer readTotal) {
        this.readTotal = readTotal;
    }

    public Integer getLikeTotal() {
        return likeTotal;
    }

    public void setLikeTotal(Integer likeTotal) {
        this.likeTotal = likeTotal;
    }

    public Integer getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(Integer commentTotal) {
        this.commentTotal = commentTotal;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddTimeDate() {
        return addTimeDate;
    }

    public void setAddTimeDate(String addTimeDate) {
        this.addTimeDate = addTimeDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Article(User user, String title, Integer userid, String summary, String content, String nickName, Integer readTotal, Integer likeTotal, Integer commentTotal, Date addTime, String addTimeDate, Integer status) {
        this.user = user;
        this.title = title;
        this.userid = userid;
        this.summary = summary;
        this.content = content;
        this.nickName = nickName;
        this.readTotal = readTotal;
        this.likeTotal = likeTotal;
        this.commentTotal = commentTotal;
        this.addTime = addTime;
        this.addTimeDate = addTimeDate;
        this.status = status;
    }

    public Article() {
    }
}
