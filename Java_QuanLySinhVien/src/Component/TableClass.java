/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Component;

import Model.Classes;
import Service.ClassesService;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 84362
 */
public class TableClass extends AbstractTableModel{
    private String[] title = {"Mã lớp","Tên lớp","Ngành"};
        private Class[] classes = {String.class,String.class,String.class};
        private List<Classes> classList;
        public TableClass(ClassesService classesService) {
           classList = classesService.getClassList();
        }
        
        @Override
        public int getRowCount() {
            return classList.size();
        }

        @Override
        public int getColumnCount() {
            return title.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return classList.get(rowIndex).getId();
                case 1:
                    return classList.get(rowIndex).getName();
                case 2:
                    return classList.get(rowIndex).getMajorName();
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
