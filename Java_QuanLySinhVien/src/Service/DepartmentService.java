/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Department;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 84362
 */
public class DepartmentService {
    private final String filePath = "department.txt";
    private List<Department> departmentList;

    public DepartmentService() {
        departmentList = new ArrayList<>();
        FakeData();
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }
    
    public List<String> getDepartmentNameList() {
        List<String> list = new ArrayList<>();
        Collections.sort(departmentList);
        for(Department item : departmentList){
            list.add(item.name);
        }
        return list;
    }
    
    private void FakeData(){
        departmentList.add(new Department("Công nghệ thông tin"));
        departmentList.add(new Department("Kế toán - Kiểm toán"));
        departmentList.add(new Department("Quản lý kinh doanh"));
        departmentList.add(new Department("Điện tử"));
        departmentList.add(new Department("Cơ khí - Ô tô"));
        departmentList.add(new Department("Điện"));
        for(Department item : departmentList){
            System.out.println(item.toString());
        }
    }
    
    public int count(){
        return departmentList.size();
    }
}
