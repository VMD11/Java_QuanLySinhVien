/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Classes;
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
public class ClassesService {
    private final String filePath = "class.txt";
    private final List<Classes> classList;

    public ClassesService() {
        classList = getList();
    }

    public List<Classes> getClassList() {
        return classList;
    }
    
    public List<Classes> getList(){
        List<Classes> list = null;
        try {
            list = getListFromFile(filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public int count(){
        return classList.size();
    }
    
    public String getNameByID(String id){
        String name = null;
        for(Classes item : classList){
            if(item.getId().equals(id)){
                name = item.getName();
                break;
            }
        }
        return name;
    }
    
    public String getIDByName(String name){
        String id = null;
        for(Classes item : classList){
            if(item.getName().equals(name)){
                id = item.getId();
                break;
            }
        }
        return id;
    }
    
    public List<String> getNameList(JComboBox jComboBox){
        String parentName = jComboBox.getSelectedItem().toString();
        String parentId = new MajorService().getIDByName(parentName);
        List<String> list = new ArrayList<>();
//        if(parentName.equalsIgnoreCase("Tất cả "))
        for(Classes item : classList){
            if(item.getMajor_id().equalsIgnoreCase(parentId))
                list.add(item.getName());
        }
        return list;
    }
    
    public void addNew(Classes classes){
        try {
            if(classList.contains(classes)){
                JOptionPane.showMessageDialog(null, "lớp "+classes.getName()+" đã tồn tại");
            }else{
                addToFile(filePath, classes);
                classList.add(classes);
                JOptionPane.showMessageDialog(null, "Thêm mới thành công");
            }
        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void addToFile(String filePath, Classes classes) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
        writer.write(classes.toString());
        writer.newLine();
        
    }
    
    private List<Classes> getListFromFile(String filePath) throws IOException{
        List<Classes> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while((line = reader.readLine()) != null){
            if(line.startsWith("Class{") && line.endsWith("}")){
                line = line.substring(6,line.length()-1);
                String[] items = line.split(",");
                String id=null;
                String name=null;
                String major_id=null;
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
                            case "major_id":
                                major_id = parts[1];
                                break;
                            default:
                                break;
                        }
                    }
                }
                list.add(new Classes(id, name, major_id));
            }
        }
        reader.close();
        return list;
    }
}
