//STEP 1. Import required packages

package connectMySql;

import java.sql.Connection;
// import java.sql.Driver; 
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
   private final static String URL = "jdbc:mysql://localhost:3306/quanlycuahang";
   private final static String USERNAME = "root";
   private final static String PASSWORD = "thanh35062496";
   private final static String DRIVER = "com.mysql.cj.jdbc.Driver";

   public static Connection connectDB() {
      try {
         Class.forName(DRIVER);
         Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         System.out.println("Connected database successfully...");
         return conn;
      } catch (ClassNotFoundException e) {
         System.out.println("Can not find Driver!");
         e.printStackTrace();
      } catch (SQLException e) {
         System.out.println("Wrong user or password!!");
         e.printStackTrace();
      }
      return null;
   }
}
