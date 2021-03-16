package com.stx.xc.BBS.dao;

import com.stx.xc.BBS.entity.User;
import com.stx.xc.Utils.DBTools;

import java.sql.*;
import java.util.Date;

public class UserDao {

    public void insertUser(String username, String password, String nickname) {
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into user (username,password,nickname,add_time,status,sex)values (?,?,?,?,0,2)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, nickname);
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

    public User queryUserByName(String username) {
        User user = null;
        String sql = "select * from user where username = ? and status = 0";
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {

                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setNickname(rs.getString("nickname"));
                user.setAvatar(rs.getString("avatar"));
                //时间转换 数据库时间转成Java.util的date类型
                Timestamp time = rs.getTimestamp("add_time");
                if (time != null) {
                    Date addTime = new Date(time.getTime());
                    user.setAddTime(addTime);
                } else {
                    user.setAddTime(new Date());
                }
                user.setStatus(rs.getInt("status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Integer queryUserCount() {
        Integer userTotal = null;
        Connection conn = DBTools.getConnection();
        String sql = "select count(*) from user where status=0";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            userTotal = rs.getInt(1);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            {
                DBTools.close(rs);
                DBTools.close(ps);
                DBTools.close(conn);
            }
        }
        return userTotal;
    }
}
