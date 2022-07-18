package com.example.baithi.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "des")
    public String des;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "salary")
    public int salary;

    public Employee() {

    }

    public Employee(int id, String des, String name, int salary) {
        this.id = id;
        this.des = des;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
