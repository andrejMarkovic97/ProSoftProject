/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Andrej
 */
public class Renting implements Serializable{
    private Employee employee;
    private Listing listing;
    private Date rentingDate;

    public Renting() {
    }

    public Renting(Employee employee, Listing listing, Date rentingDate) {
        this.employee = employee;
        this.listing = listing;
        this.rentingDate = rentingDate;
    }

    public Date getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(Date rentingDate) {
        this.rentingDate = rentingDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }
    
}
