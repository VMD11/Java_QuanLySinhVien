/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author 84362
 */
public class Major {
    public String id;
    public String name;
    public String department_id;

    public Major() {
    }

    public Major(String name, String department_id) {
        this.id = String.valueOf(100000 + (int)(100000*Math.random()));
        this.name = name;
        this.department_id = department_id;
    }

    public Major(String id, String name, String department_id) {
        this.id = id;
        this.name = name;
        this.department_id = department_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Major{" + "id=" + id + ", name=" + name + ", department=" + department_id + '}';
    }

    
}
