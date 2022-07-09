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
public class TableModelEmployee extends AbstractTableModel implements Runnable {

    ArrayList<Employee> list;
    String[] columns = {"First Name", "Last Name", "Role"};
    private String param;

    public TableModelEmployee() {
        list = new ArrayList<>();
        param ="";
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
        } catch (Exception ex) {
            Logger.getLogger(TableModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(Employee employee) {
        list.add(employee);
        fireTableDataChanged();
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshTable() {
        try {
            list = ClientController.getInstance().getAllEmployees();
            if (!param.equals("")) {
                ArrayList<Employee> newList = new ArrayList<>();
                for (Employee e : list) {
                    if (e.getFirstName().toLowerCase().contains(param.toLowerCase()) || e.getLastName().contains(param.toLowerCase())) {
                        newList.add(e);
                    }
                }
                list = newList;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setParam(String param) {
        this.param = param;
        refreshTable();
    }
}
