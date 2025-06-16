package com.startkit.demo.dao;

import com.startkit.demo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {
    //Another way to do injection
    @Autowired
    private DataSource dataSource;

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                employees.add(mapRowToEmployee(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE EmployeeID = ?";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToEmployee(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addEmployee(Employee employee) {
        String sql = "INSERT INTO employees " +
                "(LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, " +
                "Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath, Salary, SSN) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            setEmployeeParams(stmt, employee);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                try (ResultSet keys = stmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        employee.setEmployeeId(keys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET " +
                "LastName=?, FirstName=?, Title=?, TitleOfCourtesy=?, BirthDate=?, HireDate=?, Address=?, City=?, Region=?, PostalCode=?, " +
                "Country=?, HomePhone=?, Extension=?, Photo=?, Notes=?, ReportsTo=?, PhotoPath=?, Salary=?, SSN=? " +
                "WHERE EmployeeID=?";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            setEmployeeParams(stmt, employee);
            stmt.setInt(20, employee.getEmployeeId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE EmployeeID = ?";

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

    private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
        Employee emp = new Employee();
        emp.setEmployeeId(rs.getInt("EmployeeID"));
        emp.setLastName(rs.getString("LastName"));
        emp.setFirstName(rs.getString("FirstName"));
        emp.setTitle(rs.getString("Title"));
        emp.setTitleOfCourtesy(rs.getString("TitleOfCourtesy"));
        emp.setBirthDate(rs.getTimestamp("BirthDate") != null ? rs.getTimestamp("BirthDate").toLocalDateTime() : null);
        emp.setHireDate(rs.getTimestamp("HireDate") != null ? rs.getTimestamp("HireDate").toLocalDateTime() : null);
        emp.setAddress(rs.getString("Address"));
        emp.setCity(rs.getString("City"));
        emp.setRegion(rs.getString("Region"));
        emp.setPostalCode(rs.getString("PostalCode"));
        emp.setCountry(rs.getString("Country"));
        emp.setHomePhone(rs.getString("HomePhone"));
        emp.setExtension(rs.getString("Extension"));
        emp.setPhoto(rs.getBytes("Photo"));
        emp.setNotes(rs.getString("Notes"));
        emp.setReportsTo(rs.getObject("ReportsTo") != null ? rs.getInt("ReportsTo") : null);
        emp.setPhotoPath(rs.getString("PhotoPath"));
        emp.setSalary(rs.getObject("Salary") != null ? rs.getFloat("Salary") : null);
        emp.setSsn(rs.getString("SSN"));
        return emp;
    }

    private void setEmployeeParams(PreparedStatement stmt, Employee emp) throws SQLException {
        stmt.setString(1, emp.getLastName());
        stmt.setString(2, emp.getFirstName());
        stmt.setString(3, emp.getTitle());
        stmt.setString(4, emp.getTitleOfCourtesy());
        if (emp.getBirthDate() != null) stmt.setTimestamp(5, Timestamp.valueOf(emp.getBirthDate())); else stmt.setNull(5, Types.TIMESTAMP);
        if (emp.getHireDate() != null) stmt.setTimestamp(6, Timestamp.valueOf(emp.getHireDate())); else stmt.setNull(6, Types.TIMESTAMP);
        stmt.setString(7, emp.getAddress());
        stmt.setString(8, emp.getCity());
        stmt.setString(9, emp.getRegion());
        stmt.setString(10, emp.getPostalCode());
        stmt.setString(11, emp.getCountry());
        stmt.setString(12, emp.getHomePhone());
        stmt.setString(13, emp.getExtension());
        stmt.setBytes(14, emp.getPhoto());
        stmt.setString(15, emp.getNotes());
        if (emp.getReportsTo() != null) stmt.setInt(16, emp.getReportsTo()); else stmt.setNull(16, Types.INTEGER);
        stmt.setString(17, emp.getPhotoPath());
        if (emp.getSalary() != null) stmt.setFloat(18, emp.getSalary()); else stmt.setNull(18, Types.FLOAT);
        stmt.setString(19, emp.getSsn());
    }
}
