/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db.impl;

import domain.Employee;
import java.io.IOException;
import java.sql.Connection;
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

    public RepositoryEmployee() {
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
    public void add(Employee t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Employee t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Employee t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getById(Long k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
