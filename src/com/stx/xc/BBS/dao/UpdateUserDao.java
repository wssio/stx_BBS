package com.stx.xc.BBS.dao;

import com.stx.xc.Utils.DBTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UpdateUserDao {


    public void updateAvarat(String update_userId, String updateAvarat) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update user set avatar=? where id =?";

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, updateAvarat);
            ps.setString(2, update_userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }
    }

    public void updateSex(String update_userId, String updateSex) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update user set sex=? where id =?";

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, updateSex);
            ps.setString(2, update_userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }
    }

    public void updateNickname(String update_userId, String updateNickname) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update user set nickname=? where id =?";

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, updateNickname);
            ps.setString(2, update_userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }
    }

    public void updatePassword(String update_userId, String updatePassword) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update user set password=? where id =?";

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, updatePassword);
            ps.setString(2, update_userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }
    }

    public void deketePassword(String delete_user) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "update user set status=1,delete_time=? where id =?";




        try {

            ps = conn.prepareStatement(sql);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(1, timestamp);
            ps.setString(2, delete_user);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(ps);
            DBTools.close(conn);
        }
    }
}
