package com.stx.xc.BBS.dao;

import com.stx.xc.BBS.entity.Article;
import com.stx.xc.BBS.entity.User;
import com.stx.xc.Utils.DBTools;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ArticleDao {
    public static void insertArticle(String title, String summary, String content, Integer userid) {

        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into article(userid,title,summary,content,add_time,read_total,like_total,comment_total,status) values(?,?,?,?,?,0,0,0,0)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setString(2, title);
            ps.setString(3, summary);
            ps.setString(4, content);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(5, timestamp);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }
    }


    //首页文章
    public ArrayList<Article> queryAllArticles() {
        //文章列表数组
        ArrayList<Article> articles = new ArrayList<>();
        Connection conn = DBTools.getConnection();
        String sql = "select a.*,u.nickname from article as a,user as u where a.userid = u.id and a.status = 0";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            Article article;
            while (rs.next()) {

                article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setSummary(rs.getString("summary"));
                article.setContent(rs.getString("content"));
                article.setReadTotal(rs.getInt("read_total"));
                article.setStatus(rs.getInt("status"));
                article.setLikeTotal(rs.getInt("like_total"));
                article.setCommentTotal(rs.getInt("comment_total"));
                article.setNickName(rs.getString("nickname"));

                Timestamp timestamp = rs.getTimestamp("add_time");
//——————————————————————————————————————————————————————————————————————————————————————————
//                Timestamp timestamp = rs.getTimestamp("add_time");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String dateString = formatter.format(timestamp);
                article.setAddTimeDate(dateString);
//——————————————————————————————————————————————————————————————————————————————————————————


//                if (timestamp != null) {
//                    Date addTime = new Date(timestamp.getTime());
//                    article.setAddTime(addTime);
//                } else {
//                    article.setAddTime(new Date());
//                }

                User user = new User();
                user.setId(rs.getInt("userid"));
                article.setUser(user);
                //将文章添加到列表中
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(conn);
            DBTools.close(ps);
            DBTools.close(rs);
        }
        return articles;
    }


    //文章详情
    public Article getArtileById(String aid) {
        Article article = null;
        String sql = "select a.*,u.nickname,u.avatar,u.sex from article as a,user as u where a.userid = u.id and a.id=?";
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, aid);
            rs = ps.executeQuery();
            while (rs.next()) {

                article = new Article();
                article.setId(rs.getInt("id"));
                article.setUserid(rs.getInt("userid"));
                article.setTitle(rs.getString("title"));
                article.setSummary(rs.getString("summary"));
                article.setContent(rs.getString("content"));
                Timestamp time = rs.getTimestamp("add_time");

//——————————————————————————————————————————————————————————————————————————————————————————
//                Timestamp timestamp = rs.getTimestamp("add_time");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String dateString = formatter.format(time);
                article.setAddTimeDate(dateString);
//——————————————————————————————————————————————————————————————————————————————————————————

//                if (time != null) {
//                    Date addTime = new Date(time.getTime());
//                    article.setAddTime(addTime);
//                } else {
//                    article.setAddTime(new Date());
//                }

                article.setStatus(rs.getInt("status"));
                article.setReadTotal(rs.getInt("read_total"));
                article.setLikeTotal(rs.getInt("like_total"));
                article.setCommentTotal(rs.getInt("comment_total"));

                User user = new User();
                user.setId(rs.getInt("userid"));
                user.setNickname(rs.getString("nickname"));
                user.setAvatar(rs.getString("avatar"));
                user.setSex(rs.getString("sex"));

                article.setUser(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(rs);
            DBTools.close(ps);
            DBTools.close(conn);
        }
        return article;
    }

    public void deleteByid(String aid) {
        //伪删除
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update article set status=1 where id =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, aid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }
    }

    public void updateArticle(String aid, String title, String summary, String content) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update article set title=?,summary=?,content=? where id =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, summary);
            ps.setString(3, content);
            ps.setString(4, aid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }
    }


    //查询某人文章
    public ArrayList<Article> queryAllArticlesById(String userId) {

        //文章列表数组
        ArrayList<Article> articles = new ArrayList<>();
        Connection conn = DBTools.getConnection();
        String sql = "select a.*,u.nickname from article as a,user as u where a.userid = u.id and userid =? and a.status = 0";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();

            Article article;
            while (rs.next()) {

                article = new Article();
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setSummary(rs.getString("summary"));
                article.setContent(rs.getString("content"));
                article.setReadTotal(rs.getInt("read_total"));
                article.setStatus(rs.getInt("status"));
                article.setLikeTotal(rs.getInt("like_total"));
                article.setCommentTotal(rs.getInt("comment_total"));
                article.setNickName(rs.getString("nickname"));

                Timestamp timestamp = rs.getTimestamp("add_time");
//——————————————————————————————————————————————————————————————————————————————————————————
//                Timestamp timestamp = rs.getTimestamp("add_time");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String dateString = formatter.format(timestamp);
                article.setAddTimeDate(dateString);
//——————————————————————————————————————————————————————————————————————————————————————————


//                if (timestamp != null) {
//                    Date addTime = new Date(timestamp.getTime());
//                    article.setAddTime(addTime);
//                } else {
//                    article.setAddTime(new Date());
//                }

                User user = new User();
                user.setId(rs.getInt("userid"));
                article.setUser(user);
                //将文章添加到列表中
                articles.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(conn);
            DBTools.close(ps);
            DBTools.close(rs);
        }
        return articles;
    }

    public void updateLike(int likeCount,String id) {

        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update article set like_total=? where id =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, likeCount);
            ps.setString(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }

    }

    public void updateComment(int haveComment, String articleId) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update article set comment_total=? where id =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, haveComment);
            ps.setString(2, articleId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }
    }
}
