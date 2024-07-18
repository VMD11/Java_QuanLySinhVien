/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Service.DepartmentService;
import java.util.Objects;

/**
 *
 * @author 84362
 */
public class Major implements Comparable<Major>{
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
    
    public String getDepartment_name(){
        return new DepartmentService().getNameByID(department_id);
    }

    @Override
    public String toString() {
        return "Major{" + "id=" + id + ", name=" + name + ", department_id=" + department_id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Major other = (Major) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int compareTo(Major o) {
        return this.name.compareTo(o.getName());
    }

    
}
