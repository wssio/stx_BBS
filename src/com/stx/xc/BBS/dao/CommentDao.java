package com.stx.xc.BBS.dao;

import com.stx.xc.BBS.entity.Comment;
import com.stx.xc.BBS.entity.User;
import com.stx.xc.Utils.DBTools;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CommentDao {



    public static void deleteByid(String commentId) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update comment set status=1 where id =?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, commentId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }
    }

    public ArrayList<Comment> getCommentById(String articleid) {

        ArrayList<Comment> comments = new ArrayList<>();

        Connection connection = DBTools.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT c.*,u.nickname FROM comment AS c , user AS u WHERE  c.userid= u.id AND c.status=0 AND c.articleid=?";

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, articleid);
            resultSet = preparedStatement.executeQuery();
            Comment comment;
            while (resultSet.next()) {
                comment = new Comment();

                //获取评论内容与时间
                comment.setCommentID(resultSet.getInt("id"));
                comment.setArticleID(resultSet.getInt("articleid"));
                comment.setContent(resultSet.getString("content"));
                Timestamp timestamp = resultSet.getTimestamp("add_time");
//——————————————————————————————————————————————————————————————————————————————————————————
                //date转string
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = formatter.format(timestamp);
                comment.setAddTimeString(dateString);
//——————————————————————————————————————————————————————————————————————————————————————————

                //获取评论用户id
                User user = new User();
                user.setId(resultSet.getInt("userid"));
                user.setNickname(resultSet.getString("nickname"));
                comment.setUser(user);

                //添加到数组
                comments.add(comment);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(connection);
            DBTools.close(preparedStatement);
            DBTools.close(resultSet);
        }

        return comments;
    }

    public void updateComment(String updateCommentID, String updateComment) {

        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update comment set content=? where id =?";

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, updateComment);
            ps.setString(2, updateCommentID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }
    }


    public void addComment(String articleId, String login_user, String addComment) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into comment(articleid,userid,content,add_time,status) values(?,?,?,?,0)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, articleId);
            ps.setString(2, login_user);
            ps.setString(3, addComment);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(4, timestamp);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }

    }

    public int haveComment(String articleId) {

        int haveComment = 0;
        String sql = "SELECT COUNT(id) as count FROM comment WHERE articleid =? and status=0";
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, articleId);
            rs = ps.executeQuery();
            while(rs.next()) {
                haveComment = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return haveComment;
    }

    public int lookNumber(String articleId) {
        int lookNumber = 0;
        String sql = "SELECT read_total as count FROM article WHERE id=?";
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, articleId);
            rs = ps.executeQuery();
            while(rs.next()) {
                lookNumber = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lookNumber;
    }

    public void updateLookNumber(int lookNumber, String articleId) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update article set read_total=? where id =?";

        try {

            ps = conn.prepareStatement(sql);
            ps.setInt(1, lookNumber);
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
