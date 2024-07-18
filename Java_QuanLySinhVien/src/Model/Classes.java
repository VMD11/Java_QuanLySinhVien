/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Service.MajorService;
import java.util.Objects;

/**
 *
 * @author 84362
 */
public class Classes implements Comparable<Classes>{
    private  String id;
    private String name;
    private String major_id;

    public Classes() {
    }

    public Classes(String name, String major_id) {
        this.id = String.valueOf(100000 + (int)(100000*Math.random()));
        this.name = name;
        this.major_id = major_id;
    }

    public Classes(String id, String name, String major_id) {
        this.id = id;
        this.name = name;
        this.major_id = major_id;
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

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }
    
    public String getMajorName(){
        return new MajorService().getNameByID(major_id);
        
    }
    
    @Override
    public String toString() {
        return "Class{" + "id=" + id + ", name=" + name + ", major_id=" + major_id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
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
        final Classes other = (Classes) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int compareTo(Classes o) {
        return this.name.compareTo(o.getName());
    }

}
