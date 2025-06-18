package com.startkit.demo.dao;

import com.startkit.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {
    private final DataSource dataSource;

    @Autowired
    public ProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY ProductID";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                products.add(mapRowToProduct(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // replace with logger in real app
        }

        return products;
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE ProductID = ?";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToProduct(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addProduct(Product product) {
        String sql = "INSERT INTO products " +
                "(ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            setProductParams(stmt, product);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                try (ResultSet keys = stmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        product.setProductId(keys.getInt(1));
                    }
                }
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateProduct(Product product) {
        String sql = "UPDATE products SET " +
                "ProductName = ?, SupplierID = ?, CategoryID = ?, QuantityPerUnit = ?, " +
                "UnitPrice = ?, UnitsInStock = ?, UnitsOnOrder = ?, ReorderLevel = ?, Discontinued = ? " +
                "WHERE ProductID = ?";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            setProductParams(stmt, product);
            stmt.setInt(10, product.getProductId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE ProductID = ?";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Product> getProductsByName(String name) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE ProductName LIKE ? ORDER BY ProductName";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, "%" + name + "%"); // partial match

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    products.add(mapRowToProduct(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE UnitPrice BETWEEN ? AND ? ORDER BY UnitPrice";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setBigDecimal(1, minPrice);
            stmt.setBigDecimal(2, maxPrice);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    products.add(mapRowToProduct(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    private Product mapRowToProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getInt("ProductID"));
        product.setProductName(rs.getString("ProductName"));
        product.setSupplierId(rs.getObject("SupplierID") != null ? rs.getInt("SupplierID") : null);
        product.setCategoryId(rs.getObject("CategoryID") != null ? rs.getInt("CategoryID") : null);
        product.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
        product.setUnitPrice(rs.getBigDecimal("UnitPrice"));
        product.setUnitsInStock(rs.getShort("UnitsInStock"));
        product.setUnitsOnOrder(rs.getShort("UnitsOnOrder"));
        product.setReorderLevel(rs.getShort("ReorderLevel"));
        product.setDiscontinued(rs.getBoolean("Discontinued"));
        return product;
    }

    private void setProductParams(PreparedStatement stmt, Product product) throws SQLException {
        stmt.setString(1, product.getProductName());
        if (product.getSupplierId() != null) stmt.setInt(2, product.getSupplierId()); else stmt.setNull(2, Types.INTEGER);
        if (product.getCategoryId() != null) stmt.setInt(3, product.getCategoryId()); else stmt.setNull(3, Types.INTEGER);
        stmt.setString(4, product.getQuantityPerUnit());
        stmt.setBigDecimal(5, product.getUnitPrice());
        stmt.setShort(6, product.getUnitsInStock());
        stmt.setShort(7, product.getUnitsOnOrder());
        stmt.setShort(8, product.getReorderLevel());
        stmt.setBoolean(9, product.isDiscontinued());
    }
}
