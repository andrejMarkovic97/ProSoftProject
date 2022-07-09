/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;

import domain.Employee;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.DBConnectionFactory;
import repository.db.DBRepository;

/**
 *
 * @author Andrej
 */
public class RepositoryEmployee implements DBRepository<Employee, Long> {

    private Connection connection;
    private final RepositoryRental storageRental;

    public RepositoryEmployee() {
        storageRental = new RepositoryRental();
    }

    @Override
    public List<Employee> getAll() throws SQLException, IOException {
        try {
            List<Employee> employees = new ArrayList<>();
            String query = "SELECT * FROM employee";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getLong("EmployeeID"));
                e.setFirstName(rs.getString("FirstName"));
                e.setLastName(rs.getString("LastName"));
                e.setRole(rs.getString("Role"));
                e.setUsername(rs.getString("Username"));
                e.setPassword(rs.getString("Password"));
                employees.add(e);
            }
            rs.close();
            statement.close();
            System.out.println("Employee list loaded successfully!");
            return employees;
        } catch (SQLException ex) {
            System.out.println("Unsuccessful employee list loading\n" + ex);
            throw ex;

        }
    }

    @Override
    public void add(Employee e) throws IOException, SQLException {
        String query = "INSERT INTO EMPLOYEE(FirstName,LastName,Role,Username,Password) VALUES(?,?,?,?,?)";
        try {
            System.out.println(query);
            connection = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, e.getFirstName());
            statement.setString(2, e.getLastName());
            statement.setString(3, e.getRole());
            statement.setString(4, e.getUsername());
            statement.setString(5, e.getPassword());
            statement.executeUpdate();
            System.out.println("Employee added");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failure in adding employee");
        }

    }

    @Override
    public void edit(Employee e)throws Exception {
         String sql = "UPDATE EMPLOYEE SET FirstName='" + e.getFirstName() + "',"
                    + "LastName='" + e.getLastName() + "',Role='" + e.getRole() + "', "
                    + "Username='" + e.getUsername() + "',Password='" + e.getPassword() + "'"+
                 "WHERE EmployeeID="+e.getEmployeeID();
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.prepareStatement(sql);

            statement.executeUpdate(sql);
            System.out.println("Successfully update employee");
    }


    @Override
    public void delete(Employee t) throws Exception {
        try {
            String sql = "DELETE FROM EMPLOYEE WHERE EmployeeID="+ t.getEmployeeID()+"";
            connection = DBConnectionFactory.getInstance().getConnection();
            Statement statement = connection.prepareStatement(sql);
            if (t.getRole().equals("Agent")) {
                try {
                    storageRental.deleteEmployeesRentalsByID(t.getEmployeeID());
                   
                    System.out.println("Successfully deleted employee");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failure in deleting employee");
        }
    }

    @Override
    public Employee getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
