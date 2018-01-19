package core.fundamentals.models;

import java.util.Map;

import org.apache.commons.codec.language.Metaphone;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MaterialCatalogDB implements MaterialCatalogInterface {
  public MaterialCatalogDB() {
    try {
      Class.forName("org.apache.derby.jdbc.ClientDiver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  @Override
  public void addMaterial(Material newMaterial) {
    Connection conn = null;
    PreparedStatement stm = null;
    try {
      try {
        conn = DriverManager.getConnection("jdbc:derby://localhost/library");
        if (newMaterial instanceof Book) {
          Book newBook = (Book) newMaterial;
          String sql = "INSERT INTO materials (barcode, title, author, isbn, numberofpages, branch, type) VALUES (?, ?, ?, ?, ?, ?, 'BOOK')";
          stm = conn.prepareStatement(sql);
          stm.setString(1, newBook.getID());
          stm.setString(2, newBook.getTitle());
          stm.setString(3, newBook.getAuthor());
          stm.setString(4, newBook.getIsbn());
          stm.setInt(5, newBook.getNumberOfPages());
          stm.setString(6, "Downtown");
        } else if (newMaterial instanceof DVD) {
          DVD newDVD = (DVD) newMaterial;
          String sql = "INSERT INTO materials (barcode, title, catalognumber, runningtime, licenced, branch, type) VALUES (?, ?, ?, ?, ?, ?, 'DVD')";
          stm = conn.prepareStatement(sql);
          stm.setString(1, newDVD.getID());
          stm.setString(2, newDVD.getTitle());
          stm.setString(3, newDVD.getCatalogNumber());
          stm.setInt(4, newDVD.getRunningTime());
          stm.setBoolean(5, newDVD.getLicensed());
          stm.setString(6, "Uptown");

          int results = stm.executeUpdate();
          System.out.println("Records added: " + results);
        }
      } finally {
        if (stm != null) { stm.close();}
        if (conn != null) { conn.close();}
      }
    } catch (SQLException e) {
      System.out.println("Something went wrong");
      System.out.println(e);
    }
  }

  @Override
  public int getNumberOfMaterials() {
    try {
      String sql = "SELECT count(id) FROM materials";
      try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library")) {
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
          try (ResultSet rs = stm.executeQuery()) {
            rs.next();
            return rs.getInt(0);
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Material findMaterial(String title) throws MaterialNotFoundException {
    try {
      String sql = "SELECT * FROM materials WHERE title like '%" + title + "%'"; 
      try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library")) {
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
          try (ResultSet rs = stm.executeQuery()) {
            if (rs.next()) {
              String materialType = rs.getString("type");
              if (materialType.equalsIgnoreCase("BOOK")) {
                Book newBook = new Book(rs.getString("barcode"), rs.getString("title"), rs.getString("author"), rs.getString("isbn"), rs.getString("branch"), rs.getInt("numberofpages"));
                return newBook;
              } else if (materialType.equalsIgnoreCase("DVD")) {
                DVD newDVD = new DVD(rs.getString("barcode"), rs.getString("title"), rs.getString("branch"), rs.getString("director"), rs.getString("catalognumber"), rs.getInt("runningtime"));
                return newDVD;
              } else {
                throw new MaterialNotFoundException();
              }
            } else {
                throw new MaterialNotFoundException();
            }
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Map<String, Material> getMaterialMap() {
    try {
      String sql = "SELECT * FROM materials"; 
      Map<String, Material> allMaterials = new LinkedHashMap<>();
      try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost/library")) {
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
          try (ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
              String materialType = rs.getString("type");
              if (materialType.equalsIgnoreCase("BOOK")) {
                Book newBook = new Book(rs.getString("barcode"), rs.getString("title"), rs.getString("author"), rs.getString("isbn"), rs.getString("branch"), rs.getInt("numberofpages"));
                allMaterials.put(rs.getString("barcode"), newBook);
              } else if (materialType.equalsIgnoreCase("DVD")) {
                DVD newDVD = new DVD(rs.getString("barcode"), rs.getString("title"), rs.getString("branch"), rs.getString("director"), rs.getString("catalognumber"), rs.getInt("runningtime"));
                allMaterials.put(rs.getString("barcode"), newDVD);
              }
            }
            return allMaterials;
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  } 

  @Override
  public List<Material> findItemsSoundingLike(String title) {
    Map<String, Material> allItems = getMaterialMap();
    List<Material> results = new ArrayList<>();
    Metaphone mph = new Metaphone();
    String mphTitle = mph.encode(title);
    for (Material nextMaterial : allItems.values()) {
      if (mph.encode(nextMaterial.getTitle()).equals(mphTitle)) {
        results.add(nextMaterial);
      }
    } 
    return results;
  }
}
