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

/**
 *
 * @author Andrej
 */
public class Location extends AbstractDomainObject implements Serializable{
  private long locationID;
  private String city;
  private String neighborhood;

    public Location() {
    }

    public Location(long locationID, String city, String neighborhood) {
        this.locationID = locationID;
        this.city = city;
        this.neighborhood = neighborhood;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public long getLocationID() {
        return locationID;
    }

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String tableName() {
        return " location ";
    }

    @Override
    public String alias() {
        return " loc ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> getList(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Location loc = new Location(rs.getLong("LocationID"), rs.getString("City"),rs.getString("Neighborhood"));
            lista.add(loc);
        }

        rs.close();
        return lista;
    }

    @Override
    public String insertColumns() {
        return "";
    }

    @Override
    public String primaryKeyValue() {
        return "LocationID = "+locationID;
    }

    @Override
    public String insertValue() {
        return "";
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
