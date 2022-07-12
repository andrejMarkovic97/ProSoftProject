/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Andrej
 */
public class Rental extends AbstractDomainObject implements Serializable{
    private Employee employee;
    private Listing listing;
    private Date rentingDate;

    public Rental() {
    }

    public Rental(Employee employee, Listing listing, Date rentingDate) {
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

    @Override
    public String tableName() {
        return " rental ";
    }

    @Override
    public String alias() {
        return " r ";
    }

    @Override
    public String join() {
        return " JOIN listing l ON (r.listingid=l.listingid) JOIN employee e ON (r.employeeid=e.employeeid)\n" +
"             JOIN location loc ON (l.locationid=loc.locationid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
          ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            
            Location loc = new Location(rs.getLong("LocationID"), rs.getString("City"), rs.getString("Neighborhood"));
            
            Listing l = new Listing(rs.getLong("ListingID"), new Date(rs.getDate("PublicationDate").getTime())
                    ,rs.getInt("Price"),rs.getString("AdditionalDescription"),null,null,loc);
            
            Employee e = new Employee(rs.getLong("EmployeeID"), rs.getString("FirstName"),
                    rs.getString("LastName"), rs.getString("Role"),
                    rs.getString("Username"), rs.getString("Password"), null);
            
            Rental r = new Rental(e, l, new Date(rs.getDate("RentingDate").getTime()));
            

            lista.add(r);
        }

        rs.close();
        return lista;
    }

    @Override
    public String insertColumns() {
        return " (ListingID,EmployeeID,RentingDate) ";
    }

    @Override
    public String primaryKeyValue() {
        return " EmployeeID = " + employee.getEmployeeID()+" AND ListingID="+listing.getListingID();
    }

    @Override
    public String insertValue() {
        return " "+listing.getListingID()+", "+employee.getEmployeeID()+","
                + " '"+new java.sql.Date(rentingDate.getTime())+"'";
    }

    @Override
    public String updateValue() {
        return "";
    }

    @Override
    public String condition() {
        return "";
    }
    
}
