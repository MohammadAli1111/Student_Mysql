/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_mysql;

/**
 *
 * @author Mohammad
 */
public class Student {
    
    private int Id;
    private String FullName;
    private int Age;
    private String Department;

    public Student() {
    }

    public Student(String FullName, int Age, String Department) {
        this.FullName = FullName;
        this.Age = Age;
        this.Department = Department;
    }

    public Student(int Id, String FullName, int Age, String Department) {
        this.Id = Id;
        this.FullName = FullName;
        this.Age = Age;
        this.Department = Department;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }
    
    
    
}
