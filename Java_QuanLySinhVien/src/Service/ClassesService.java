/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Classes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84362
 */
public class ClassesService {
    private final String filePath = "class.txt";
    private List<Classes> classList;

    public ClassesService() {
        classList = new ArrayList<>();//getClassListFromFile();
        FakeData();
    }

    public List<Classes> getClassList() {
        return classList;
    }
    
    private void FakeData(){
//        Major{id=173126, name=Công nghệ thông tin, department=129343}
//        Major{id=187337, name=Công nghệ thông tin, department=129343}
//        Major{id=193939, name=Kế toán, department=157535}
//        Major{id=185090, name=Quản trị kinh doanh, department=157535}
//        Major{id=131551, name=Kiểm toán, department=157535}
//        Major{id=163854, name=Công nghệ ô tô, department=129769}
//        Major{id=133194, name=Cơ khí, department=129769}
        classList.add(new Classes("Công nghệ thông tin 1", "173126"));
        classList.add(new Classes("Công nghệ thông tin 2", "173126"));
        classList.add(new Classes("Công nghệ thông tin 3", "173126"));
        classList.add(new Classes("Công nghệ thông tin 4", "173126"));
                
        classList.add(new Classes("Kỹ thuật phầm mềm 1", "187337"));
        classList.add(new Classes("Kỹ thuật phầm mềm 2", "187337"));
        classList.add(new Classes("Kỹ thuật phầm mềm 3", "187337"));
                
        classList.add(new Classes("Kế toán 1", "193939"));
        classList.add(new Classes("Kế toán 2", "193939"));
        classList.add(new Classes("Kế toán 3", "193939"));
        classList.add(new Classes("Kế toán 4", "193939"));
        classList.add(new Classes("Kế toán 5", "193939"));
                
        classList.add(new Classes("Quản trị kinh doanh 1", "185090"));
        classList.add(new Classes("Quản trị kinh doanh 2", "185090"));
        classList.add(new Classes("Quản trị kinh doanh 3", "185090"));
                
        classList.add(new Classes("Cơ khí 1", "133194"));
        classList.add(new Classes("Cơ khí 2", "133194"));
        classList.add(new Classes("Cơ khí 3", "133194"));
        classList.add(new Classes("Cơ khí 4", "133194"));
        classList.add(new Classes("Cơ khí 5", "133194"));
                
        classList.add(new Classes("Công nghệ ô tô 1", "163854"));
        classList.add(new Classes("Công nghệ ô tô 2", "163854"));
        classList.add(new Classes("Công nghệ ô tô 3", "163854"));
        for(var item : classList){
            System.out.println(item.toString());
        }
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
    
    public List<String> getClassNameList(){
        List<String> list = new ArrayList<>();
        for(Classes item : classList){
            list.add(item.getName());
        }
        return list;
    }
    
    private List<Classes> getClassListFromFile(){
        List<Classes> list = null;
        try {
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
