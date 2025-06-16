package com.startkit.demo.dao;

import com.startkit.demo.models.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SupplierDao {
    @Autowired
    private DataSource dataSource;

    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        String sql = "SELECT SupplierID, CompanyName FROM suppliers";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Supplier s = new Supplier();
                s.setSupplierId(rs.getInt("SupplierID"));
                s.setCompanyName(rs.getString("CompanyName"));
                suppliers.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return suppliers;
    }
}
