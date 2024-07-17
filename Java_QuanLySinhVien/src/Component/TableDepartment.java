/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Component;

import Model.Department;
import Service.DepartmentService;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 84362
 */
public class TableDepartment extends AbstractTableModel{
    private String[] title = {"Mã khoa","Tên khoa"};
    private Class[] classes = {String.class,String.class};
    private List<Department> departmentList;
    public TableDepartment(DepartmentService departmentService) {
       departmentList = departmentService.getDepartmentList();
    }

    @Override
    public int getRowCount() {
        return departmentList.size();
    }

    @Override
    public int getColumnCount() {
        return title.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return departmentList.get(rowIndex).getId();
            case 1:
                return departmentList.get(rowIndex).getName();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return title[column];
    }
        
}
