package servlets ;
import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnect {
private static Connection con;
public static Connection getConn() {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes_sharing", "root","root");
} catch (Exception e) { e.printStackTrace();
}
return con;
}
}