/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Service.ClassesService;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author 84362
 */
public class Student implements Comparable<Student>{
    private String id;
    private String fullName;
    private String birthday;
    private String homeland;
    private int gender;
    private String class_id;
    private double GPA;

    public Student() {
    }

    public Student(String fullName, String birthday, String homeland, int gender, String class_id, double GPA) {
        this.id = String.valueOf(new Random().nextInt(2024609999-2020600000+1)+2020600000);
        this.fullName = fullName;
        this.birthday = birthday;
        this.homeland = homeland;
        this.gender = gender;
        this.class_id = class_id;
        this.GPA = GPA;
    }
    

    public Student(String id, String fullName, String birthday, String homeland, int gender, String class_id, double GPA) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.homeland = homeland;
        this.gender = gender;
        this.class_id = class_id;
        this.GPA = GPA;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHomeland() {
        return homeland;
    }

    public void setHomeLand(String homeland) {
        this.homeland = homeland;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }
    
    public String getClassName(){
        return new ClassesService().getNameByID(class_id);
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", fullName=" + fullName + ", birthday=" + birthday + ", homeland=" + homeland + ", gender=" + gender + ", class_id=" + class_id + ", GPA=" + GPA + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Student other = (Student) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public int compareTo(Student o) {
        return this.fullName.compareTo(o.getFullName());
    }

}
