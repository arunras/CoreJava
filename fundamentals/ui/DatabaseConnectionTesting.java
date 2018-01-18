package core.fundamentals.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseConnectionTesting {
  public static void main(String[] args) {
    updateData("UPDATE materials SET title = ? WHERE id = ?", "Second title", 1);
    retrieveResultSet("SELECT * FROM materials");
  }

  public static void updateData(String sql, String title, int id) {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library")) {
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
          stm.setString(1, title);
          stm.setInt(2, id);
          int results = stm.executeUpdate(); 
          System.out.println("Records amended: " + results);
        }
      } 
    } catch (ClassNotFoundException e) {
      System.out.println("Update failed, Something went wrong");
      System.out.println(e);
    } catch (SQLException e) {
      System.out.println("Update failed, Something went wrong");
      System.out.println(e);
    }
  }

  public static void retrieveResultSet(String sql) {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library")) {
        try (Statement stm = conn.createStatement()) {
          try (ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
              System.out.println(rs.getString("title"));
            }
          } 
        }
      } 
    } catch (ClassNotFoundException e) {
      System.out.println("Retrieve failed, Something went wrong");
      System.out.println(e);
    } catch (SQLException e) {
      System.out.println("Retrieve failed, Something went wrong");
      System.out.println(e);
    }
  }

}
