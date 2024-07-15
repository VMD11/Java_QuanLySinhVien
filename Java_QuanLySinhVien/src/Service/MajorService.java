/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Major;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84362
 */
public class MajorService {
    private final String filePath = "major.txt";
    private List<Major> majorList;

    public MajorService() {
        majorList = new ArrayList<>();
        FakeData();
    }

    public List<Major> getMajorList() {
        return majorList;
    }
    
    private void FakeData(){
        majorList.add(new Major("Công nghệ thông tin", "129343"));
        majorList.add(new Major("Công nghệ thông tin", "129343"));
        majorList.add(new Major("Kế toán", "157535"));
        majorList.add(new Major("Quản trị kinh doanh", "157535"));
        majorList.add(new Major("Kiểm toán", "157535"));
        majorList.add(new Major("Công nghệ ô tô", "129769"));
        majorList.add(new Major("Cơ khí", "129769"));
        for(var item : majorList){
            System.out.println(item.toString());
        }
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
    
    public List<String> getMajorNameList(){
        List<String> list = new ArrayList<>();
        for(Major item : majorList){
            list.add(item.getName());
        }
        return list;
    }
}
