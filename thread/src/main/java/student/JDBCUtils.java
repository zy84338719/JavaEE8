package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils {
    public static Connection getConnection()
    {
        String driverName = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/zydatabase";
        String user = "root" ;
        String password = "zx19950124";
        Connection con = null ;
        try {

            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con ;

    }

    /**
     * 关闭连接
     */
    public static void free(ResultSet rs, Statement sta , Connection con)
    {
        try {
            if(null != rs)
            {
                rs.close();
                rs = null ;
            }

            if(null != sta)
            {
                sta.close();
                sta = null ;
            }

            if(null != con)
            {
                con.close();
                con = null ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
