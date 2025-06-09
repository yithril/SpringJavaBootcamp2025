package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TemplateDao {
    // CHANGE THIS: Replace 'Template' with your actual class name, e.g., CustomerDao, ProductDao, etc.
    private final String dbUrl;
    private final String dbUser;
    private final String dbPass;

    public TemplateDao(String dbUrl, String dbUser, String dbPass) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    // 🔍 READ ALL
    public List<Template> getAll() {
        List<Template> list = new ArrayList<>();
        String sql = "SELECT * FROM table_name"; // CHANGE THIS

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Template obj = new Template(
                        // CHANGE THIS: Match constructor and column names
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("value")
                );
                list.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 🔍 READ ONE BY ID
    public Template getById(int id) {
        String sql = "SELECT * FROM table_name WHERE id = ?"; // CHANGE THIS

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Template(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("value")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // ➕ INSERT
    public void insert(Template obj) {
        String sql = "INSERT INTO table_name (name, value) VALUES (?, ?)"; // CHANGE THIS

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, obj.getName());  // CHANGE THIS
            stmt.setString(2, obj.getValue()); // CHANGE THIS

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✏️ UPDATE
    public void update(Template obj) {
        String sql = "UPDATE table_name SET name = ?, value = ? WHERE id = ?"; // CHANGE THIS

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, obj.getName());     // CHANGE THIS
            stmt.setString(2, obj.getValue());    // CHANGE THIS
            stmt.setInt(3, obj.getId());          // CHANGE THIS

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ❌ DELETE
    public void delete(int id) {
        String sql = "DELETE FROM table_name WHERE id = ?"; // CHANGE THIS

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
