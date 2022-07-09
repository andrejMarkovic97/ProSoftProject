/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.models;

import client.controller.ClientController;
import domain.Employee;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andrej
 */
public class EmployeeTable extends AbstractTableModel{

    ArrayList<Employee> list;
    String[] columns = {"First Name", "Last Name","Role"};

    public EmployeeTable() {
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
        
        switch(columnIndex){
            case 0: return employee.getFirstName();
            case 1: return employee.getLastName();
            case 2: return employee.getRole();
            
            default: return "return!";
        }
    }

    public void fillTable() {
        try {
            list = ClientController.getInstance().getAllEmployees();
        } catch (Exception ex) {
            Logger.getLogger(EmployeeTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(Employee employee) {
        list.add(employee);
        fireTableDataChanged();
    }
    
}
