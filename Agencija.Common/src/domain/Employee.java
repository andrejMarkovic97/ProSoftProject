/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Andrej
 */
public class Employee implements Serializable{
   private long employeeID;
   private String firstName;
   private String lastName;
   private String role;
   private String username;
   private String password;
   private ArrayList<Rental> rentals;

    public Employee() {
    }

    public Employee(long employeeID, String name, String lastName, String role, String username, String password, ArrayList<Rental> rentals) {
        this.employeeID = employeeID;
        this.firstName = name;
        this.lastName = lastName;
        this.role = role;
        this.username = username;
        this.password = password;
        this.rentals = rentals;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(ArrayList<Rental> rentals) {
        this.rentals = rentals;
    }
   
}
