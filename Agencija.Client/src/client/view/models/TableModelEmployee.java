/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.models;

import client.controller.ClientController;
import domain.Employee;
import domain.Rental;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andrej
 */
public class TableModelEmployee extends AbstractTableModel {

    private ArrayList<Employee> list;
    String[] columns = {"First Name", "Last Name", "Role"};

    public TableModelEmployee() {
        list = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int i) {
        return columns[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return employee.getFirstName();
            case 1:
                return employee.getLastName();
            case 2:
                return employee.getRole();

            default:
                return "return!";
        }
    }

    public void fillTable() {
        try {
            list = ClientController.getInstance().getAllEmployees();
            ArrayList<Rental> rentals = new ArrayList<>();
            for (Employee employee : list) {
                for (Rental rental : rentals) {
                    if(rental.getEmployee().getEmployeeID()==employee.getEmployeeID()){
                        employee.setRentals(new ArrayList<>());
                        employee.getRentals().add(rental);
                    }
                }
            }
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(Employee employee) {
        list.add(employee);
        fireTableDataChanged();
    }

    public void delete(int row) throws Exception {
        Employee e = list.get(row);
        try {
            ClientController.getInstance().deleteEmployee(e);
            list.remove(row);
            fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(TableModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Employee> getList() {
        return list;
    }

    public void search(String param) throws Exception {
        ArrayList<Employee> newList = new ArrayList<>();
        if (!param.equals("")) {
            for (Employee employee : list) {
                if (employee.getFirstName().toLowerCase().contains(param.toLowerCase())
                        || employee.getLastName().contains(param.toLowerCase())) {
                    newList.add(employee);
                }
            }
            if (newList.isEmpty()) {
                throw new Exception("Sistem ne može da pronađe zaposlene po zadatim vrijednostima");
            }
            list = newList;
            fireTableDataChanged();
        } else {
            throw new Exception("Prvo unesite vrijednost prije pretrage");
        }

    }

  

    public Employee getEmployeeRow(int row) {
        return list.get(row);
    }

}
