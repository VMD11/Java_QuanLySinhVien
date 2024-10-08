/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Student;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 84362
 */
public class StudentService {
    private final String filePath = "student.txt";
    private final List<Student> studentList;

    public StudentService() {
        this.studentList = getList();
    }
    
    public List<Student> getStudentList() {
        Collections.sort(studentList);
        return studentList;
    }
    
    
    public List<Student> getList(){
        List<Student> list = null;
        try {
            list = getListFromFile(filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public int count(){
        return studentList.size();
    }
    
    
    public boolean add(Student student){
        boolean check = false;
        try {
            if(studentList.contains(student)){
                JOptionPane.showMessageDialog(null, "Mã sinh viên đã tồn tại");
            }else{
                addToFile(filePath, student);
                studentList.add(student);
                JOptionPane.showMessageDialog(null, "Thêm mới thành công");
                check = true;
            }
        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
    public void delete(Student student){
        studentList.remove(student);
        List<Student> list = studentList;
        addRangeToFile(filePath, list);
        JOptionPane.showMessageDialog(null, "Xóa thành công");
    }
    
    public void deleteByClass_id(String class_id){
        Iterator<Student> it = studentList.iterator();
        while(it.hasNext()){
            Student item = it.next();
            if(item.getClass_id().equalsIgnoreCase(class_id)){
                System.out.println("class_id: " +class_id);
                System.out.println(item.toString());
                it.remove();
            }
        }
        addRangeToFile(filePath, studentList);
    }
    
    public void update(Student student){
        for(Student item : studentList){
            if(student.getId().equalsIgnoreCase(item.getId())){
                int index = studentList.indexOf(item);
                studentList.remove(item);
                studentList.add(index, student);
                break;
            }
        }
        List<Student> list = studentList;
        addRangeToFile(filePath, list);
        JOptionPane.showMessageDialog(null, "Sửa thành công");
    }
    
    public void setDetail(Student student) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"));
            writer.write(student.toString());
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public Student getDetail(){
        Student student = null;
        try{
            for(Student item : getListFromFile("temp.txt")){
                student = item;
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return student;
    }
    
    
    private void addRangeToFile(String filePath, List<Student> list){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            Iterator<Student> it = list.iterator();
            while(it.hasNext()){
                Student item = it.next();
//                if(item != null){
                    writer.write(item.toString());
                    writer.newLine();
//                }
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void addToFile(String filePath, Student student) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
        writer.newLine();
        writer.write(student.toString());
        writer.close();
        
    }
    
    private List<Student> getListFromFile(String filePath) throws IOException{
        List<Student> list = new ArrayList<>();
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
        return list;
    }
}
