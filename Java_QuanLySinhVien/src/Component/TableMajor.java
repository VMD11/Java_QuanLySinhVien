/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Component;

import Model.Major;
import Service.MajorService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 84362
 */
public class TableMajor extends AbstractTableModel{
    private String[] title = {"Mã ngành","Tên ngành","Khoa"};
        private Class[] classes = {String.class,String.class,String.class};
        private List<Major> majorList;
        private List<Major> majors;
        public TableMajor(MajorService majorService) {
           majors = majorService.getMajorList();
           majorList = new ArrayList<>(majors);
        }
        
        public void search(String key){
            if(key.trim().isEmpty()){
                majorList = new ArrayList<>(majors);
            }else{
                majorList = majors.stream()
                                      .filter(s -> s.getName().toUpperCase().contains(key.toUpperCase()))
                                      .collect(Collectors.toList());
            }
            fireTableDataChanged();
        }
        
        @Override
        public int getRowCount() {
            return majorList.size();
        }

        @Override
        public int getColumnCount() {
            return title.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return majorList.get(rowIndex).getId();
                case 1:
                    return majorList.get(rowIndex).getName();
                case 2:
                    return majorList.get(rowIndex).getDepartment_name();
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
