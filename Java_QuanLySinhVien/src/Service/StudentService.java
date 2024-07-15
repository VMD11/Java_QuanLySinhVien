/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Classes;
import Model.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;

/**
 *
 * @author 84362
 */
public class StudentService {
    private final String filePath = "student.txt";
    private List<Student> studentList;

    public StudentService() {
        this.studentList = getStudentListFromFile(filePath);
        FakeData();
    }
    
    public List<Student> getStudentList() {
        return studentList;
    }
    private void FakeData(){
        studentList.add(new Student("2020", "nguyễn văn a", "12/12/12", "Hanoi", 0, "L01",3.1));
        studentList.add(new Student("2020", "nguyễn văn a", "12/12/12", "Hanoi", 0, "L01",3.1));
        studentList.add(new Student("2020", "nguyễn văn a", "12/12/12", "Hanoi", 0, "L02",3.1));
        studentList.add(new Student("2020", "nguyễn văn a", "12/12/12", "Hanoi", 0, "L03",3.1));
        for(Student student : studentList){
            System.out.println(student.toString());
        }
    }
    
    public int count(){
        return studentList.size();
    }
    
    public void addNewStudent(Student student){
        try {
            if(studentList.contains(student)){
                JOptionPane.showMessageDialog(null, "Sinh viên đã tồn tại");
            }else{
                addStudentToFile(filePath, student);
                studentList.add(student);
                JOptionPane.showMessageDialog(null, "Thêm mới thành công");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteStudent(String id){
        
    } 
    
    private void addStudentToFile(String filePath, Student student) throws Exception{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
        writer.write(student.toString());
        writer.newLine();
        
    }
    
    private List<Student> getStudentListFromFile(String filePath){
        List<Student> list = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = reader.readLine()) != null){
                if(line.startsWith("Student{") && line.endsWith("}")){
                    line = line.substring(8,line.length()-1);
                    String[] items = line.split(",");
                    String id=null;
                    String fullName=null;
                    String birthday=null;
                    String homeland=null;
                    int gender=0;
                    String class_id=null;
                    double GPA=0;
                    for(String item : items){
                        String[] parts = item.split("=");
                        if(parts.length == 2){
                            switch (parts[0].trim()) {
                                case "id":
                                    id = parts[1];
                                    break;
                                case "fullName":
                                    fullName = parts[1];
                                    break;
                                case "birthday":
                                    birthday = parts[1];
                                    break;
                                case "homeland":
                                    homeland = parts[1];
                                    break;
                                case "gender":
                                    gender = Integer.parseInt(parts[1]);
                                    break;
                                case "class_id":
                                    class_id = parts[1];
                                    break;
                                case "GPA":
                                    GPA = Double.parseDouble(parts[1]);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    list.add(new Student(id, fullName, birthday, homeland, gender, class_id, GPA));
                }
            }
            reader.close();
        }catch(IOException | NumberFormatException ex){
            ex.printStackTrace();
        }
        return list;
    }
}
