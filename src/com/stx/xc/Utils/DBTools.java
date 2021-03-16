package com.stx.xc.Utils;

import java.sql.*;

public class DBTools {
    //Class.forName()
    private static String dbUser = "zhilong";
    private static String dbPwd="199812";
    private static String url = "jdbc:mysql://127.0.0.1:3306/stx_blog";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        http://localhost:8080/intel
        try {
            conn = DriverManager.getConnection(url, dbUser, dbPwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
