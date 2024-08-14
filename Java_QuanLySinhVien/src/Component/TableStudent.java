/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Component;

import Model.Student;
import Service.StudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 84362
 */
public class TableStudent extends AbstractTableModel{
        private String[] title = {"Mã sinh viên","Họ tên","Giới tính","Ngày sinh","GPA","Lớp","Quê quán"};
        private Class[] classes = {String.class,String.class,String.class,String.class,String.class,String.class,String.class};
        private List<Student> studentList;
        private List<Student> students;
        public TableStudent(StudentService studentService){
            students = studentService.getList();
            studentList = new ArrayList<>(students);
        }
        
        public void search(String key){
            if(key.trim().isEmpty()){
                studentList = new ArrayList<>(students);
            }else{
                studentList = students.stream()
                                      .filter(s -> s.getFullName().toLowerCase().contains(key.toLowerCase()))
                                      .collect(Collectors.toList());
            }
            fireTableDataChanged();
        }
        
        public void filter(String name){
            if(name.equalsIgnoreCase("Tất cả lớp")){
                studentList = new ArrayList<>(students);
            }else{
                studentList = students.stream()
                                      .filter(s -> s.getClassName().equalsIgnoreCase(name))
                                      .collect(Collectors.toList());
            }
            fireTableDataChanged();
        }
        
        @Override
        public int getRowCount() {
            return studentList.size();
        }

        @Override
        public int getColumnCount() {
            return title.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return studentList.get(rowIndex).getId();
                case 1:
                    return studentList.get(rowIndex).getFullName();
                case 2:
                    return studentList.get(rowIndex).getGender()==0 ? "Nam" : "Nữ";
                case 3:
                    return studentList.get(rowIndex).getBirthday();
                case 4:
                    return studentList.get(rowIndex).getGPA();
                case 5:
                    return studentList.get(rowIndex).getClassName();
                case 6:
                    return studentList.get(rowIndex).getHomeland();
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