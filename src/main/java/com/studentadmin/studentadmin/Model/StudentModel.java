package com.studentadmin.studentadmin.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Student_table")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    Integer id;
    String name;
    String email;
    String Address;
    String  Course;
    String password;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getCourse() {
        return Course;
    }
    public void setCourse(String course) {
        Course = course;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModel that = (StudentModel) o;
        return Objects
        .equals(id, that.id) && Objects
        .equals(name, that.name) && Objects
        .equals(email, that.email) && Objects
        .equals(Address, that.Address) && Objects
        .equals(Course, that.Course) && Objects
        .equals(password, that.password);
    }

    @Override
    public int hashCode() {
       
        return Objects.hash(id,name, email, Address, Course, password);
    }
    @Override
    public String toString() {
        return "StudentModel [Address=" + Address + ", Course=" + Course + ", email=" + email + ", id=" + id + ", name="
                + name + "]";
    }

    
    

}
