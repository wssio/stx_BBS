package com.stx.xc.BBS.dao;

import com.stx.xc.Utils.DBTools;

import java.sql.*;

public class LIkeArticleDao {


    public void addLikeArticle(String id, String like_user) {

        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into like_article (articleid,like_user)values (?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, like_user);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }

    }

    public void deleteLikeArticle(String id, String like_user) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from like_article where articleid=? and like_user=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, like_user);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }

    }

    public int lookLikeArticle(String id, String like_user) {
        int lIkeArticle = 0;
        String sql = "SELECT COUNT(id) as count FROM like_article WHERE articleid =? and like_user=?";
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, like_user);
            rs = ps.executeQuery();
            while(rs.next()) {
                lIkeArticle = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lIkeArticle;
    }


    public int haveLike(String id) {
        int lIkeArticle = 0;
        String sql = "SELECT COUNT(id) as count FROM like_article WHERE articleid =?";
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                lIkeArticle = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lIkeArticle;

    }
}
