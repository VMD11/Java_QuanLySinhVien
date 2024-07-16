/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Major;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author 84362
 */
public class MajorService {
    private final String filePath = "major.txt";
    private final List<Major> majorList;

    public MajorService() {
        majorList = getList();
    }

    public List<Major> getMajorList() {
        return majorList;
    }
    
   public List<Major> getList(){
       List<Major> list = null;
       try {
           list = getListFromFile(filePath);
       } catch (IOException ex) {
           ex.printStackTrace();
       }
       return list;
   }
    
    public int count(){
        return majorList.size();
    }
    
    public String getNameByID(String id){
        String name = null;
        for(Major item : majorList){
            if(item.getId().equals(id)){
                name = item.getName();
                break;
            }
        }
        return name;
    }
    
    public String getIDByName(String name){
        String id = null;
        for(Major item : majorList){
            if(item.getName().equals(name)){
                id = item.getId();
                break;
            }
        }
        return id;
    }
    
    public List<String> getNameList(JComboBox jComboBox){
        String parentName = jComboBox.getSelectedItem().toString();
        String parentId = new DepartmentService().getIDByName(parentName);
        List<String> list = new ArrayList<>();
        if(parentName.equalsIgnoreCase("Tất cả Khoa")){
            for(Major item : majorList)
                list.add(item.getName());
            return list;
        }else{
            for(Major item : majorList){
                if(item.getDepartment_id().equalsIgnoreCase(parentId))
                    list.add(item.getName());
            }
            return list;
        }
    }
    
    public void add(Major major){
        try {
            if(majorList.contains(major)){
                JOptionPane.showMessageDialog(null, "Ngành " + major.getName() + " đã tồn tại");
            }else{
                addToFile(filePath, major);
                majorList.add(major);
                JOptionPane.showMessageDialog(null, "Thêm mới thành công");
            }
        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        }
    }
    public void delete(Major major){
        majorList.remove(major);
        List<Major> list = majorList;
        addRangeToFile(filePath, list);
    }
    
    public void update(Major major){
        for(Major item : majorList){
            if(major.getId().equalsIgnoreCase(item.getId())){
                int index = majorList.indexOf(item);
                majorList.remove(item);
                majorList.add(index, major);
                break;
            }
        }
        List<Major> list = majorList;
        addRangeToFile(filePath, list);
    }
    
    private void addRangeToFile(String filePath, List<Major> list){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for(Major item : list){
                writer.write(item.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void addToFile(String filePath, Major major) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
        writer.write(major.toString());
        writer.newLine();
    }
    
    private List<Major> getListFromFile(String filePath) throws IOException{
        List<Major> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while((line = reader.readLine()) != null){
            if(line.startsWith("Major{") && line.endsWith("}")){
                line = line.substring(6,line.length()-1);
                String[] items = line.split(",");
                String id=null;
                String name=null;
                String department_id=null;
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
                            case "department_id":
                                department_id = parts[1];
                                break;
                            default:
                                break;
                        }
                    }
                }
                list.add(new Major(id, name, department_id));
            }
        }
        reader.close();
        return list;
    }
}
