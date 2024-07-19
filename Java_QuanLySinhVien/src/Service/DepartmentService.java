/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Department;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 84362
 */
public class DepartmentService {
    private final String filePath = "department.txt";
    private final List<Department> departmentList;

    public DepartmentService() {
        departmentList = getList();
    }

    public List<Department> getDepartmentList() {
        Collections.sort(departmentList);
        return departmentList;
    }
    
    public List<Department> getList(){
       List<Department> list = null;
       try {
           list = getListFromFile(filePath);
       } catch (IOException ex) {
           ex.printStackTrace();
       }
       return list;
   }
    
    public List<String> getNameList() {
        List<String> list = new ArrayList<>();
        Collections.sort(departmentList);
        for(Department item : departmentList){
            list.add(item.name);
        }
        list.add(0, "Tất cả Khoa");
        return list;
    }
    
    public void add(Department department){
        try {
            if(departmentList.contains(department)){
                JOptionPane.showMessageDialog(null, "Khoa " + department.getName() + " đã tồn tại");
            }else{
                addToFile(filePath, department);
                departmentList.add(department);
                JOptionPane.showMessageDialog(null, "Thêm mới thành công");
            }
        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public String getIDByName(String name){
        String id = null;
        for(Department item : departmentList){
            if(item.getName().equalsIgnoreCase(name)){
                id = item.getId();
                break;
            }
        }
        return id;
    }
    
    public String getNameByID(String id){
        String name = null;
        for(Department item : departmentList){
            if(item.getId().equalsIgnoreCase(id)){
                name = item.getName();
                break;
            }
        }
        return name;
    }
    
    public int count(){
        return departmentList.size();
    }
    
    public void delete(Department department){
        new MajorService().deleteByDepartment_id(department.getId());
        departmentList.remove(department);
        List<Department> list = departmentList;
        addRangeToFile(filePath, list);
        JOptionPane.showMessageDialog(null, "Xóa thành công");
    }
    
    public void update(Department department){
        for(Department item : departmentList){
            if(department.getId().equalsIgnoreCase(item.getId())){
                int index = departmentList.indexOf(item);
                departmentList.remove(item);
                departmentList.add(index, department);
                break;
            }
        }
        List<Department> list = departmentList;
        addRangeToFile(filePath, list);
        JOptionPane.showMessageDialog(null, "Sửa thành công");
    }
    
    private void addRangeToFile(String filePath, List<Department> list){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for(Department item : list){
                writer.write(item.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void addToFile(String filePath, Department department) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
        writer.newLine();
        writer.write(department.toString());
        writer.close();
        
    }
    private List<Department> getListFromFile(String filePath) throws IOException{
        List<Department> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while((line = reader.readLine()) != null){
            if(line.startsWith("Department{") && line.endsWith("}")){
                line = line.substring(11,line.length()-1);
                String[] items = line.split(",");
                String id=null;
                String name=null;
                for(String item : items){
                    String[] parts = item.split("=");
                    if(parts.length == 2){
                        switch (parts[0].trim()) {
                            case "id":
                                id = parts[1];
                                break;
                            case "name":
                                name = parts[1];
                                break;
                            default:
                                break;
                        }
                    }
                }
                list.add(new Department(id, name));
            }
        }
        reader.close();
        return list;
    }
}
