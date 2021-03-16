package com.stx.xc.BBS.dao;

import com.stx.xc.BBS.entity.SystemDate;
import com.stx.xc.Utils.DBTools;

import java.sql.*;

public class SystemDateDao {
    public SystemDate getPhotoCount(String userSex) {
        SystemDate systemDate = null;

        String sql = "select systemvalue from systemdata WHERE systemkey=?";
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userSex);
            rs = ps.executeQuery();
            while (rs.next()){
                systemDate = new SystemDate();
                systemDate.setValue(rs.getString("systemvalue"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(rs);
            DBTools.close(ps);
            DBTools.close(conn);
        }

        return systemDate;
    }



}
