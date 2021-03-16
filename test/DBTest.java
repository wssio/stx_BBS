import com.stx.xc.BBS.dao.ArticleDao;
import com.stx.xc.BBS.dao.LIkeArticleDao;
import com.stx.xc.Utils.DBTools;
import org.junit.Test;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBTest {

    LIkeArticleDao lIkeArticleDao = new LIkeArticleDao();
    ArticleDao articleDao = new ArticleDao();
    @Test//用例，一个方法对应一个用例
    public void testQuery() {






        //Class.forName()

        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "select * from user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
//                System.out.println(rs.getString("username") + rs.getString("nickname"));
//                System.out.println(rs.getTimestamp("add_time"));

                Timestamp timestamp = rs.getTimestamp("add_time");
                SimpleDateFormat formatter = new SimpleDateFormat("HH");
                String dateString = formatter.format(timestamp);
                System.out.println(dateString);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBTools.close(conn);
            DBTools.close(ps);
            DBTools.close(rs);
        }
    }

    @Test
    public void testUpdate() {
        System.out.println("2");
    }


    @Test
    public void testQeery() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String dateHH = format.format(date);
        System.out.println(dateHH);
    }

    @Test
    public void lookLikeArticle() {
        int lookNumber = 0;
        String sql = "SELECT read_total as count FROM article WHERE id=?";
        Connection conn = DBTools.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, "29");
            rs = ps.executeQuery();
            while(rs.next()) {
                lookNumber = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(lookNumber);
    }

}
