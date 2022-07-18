package com.example.baithi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;


import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;


import com.example.baithi.database.AppDatabase;
import com.example.baithi.database.Employee;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    EditText EmployeeName, Designation, Salary;
    Button btEmployee, btUpdate, btDelete;
    AppDatabase db;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        EmployeeName = findViewById(R.id.EmployeeName);
        Designation = findViewById(R.id.Designation);
        Salary = findViewById(R.id.Salary);
        btEmployee = findViewById(R.id.btEmployee);
        btUpdate = findViewById(R.id.btUpdate);
        btDelete = findViewById(R.id.btDelete);
        btEmployee.setOnClickListener(this);
        List<Employee> employees = db.employeeDao().getAllEmployee();

    } @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btEmployee:
                add();
                break;
            case R.id.btUpdate:
                update();
                break;
            case R.id.btDelete:
                delete();
                break;
            default:
                break;
        }
    }

    private void delete() {
        if (btEmployee == null) {
            Toast.makeText(this, "NoEmployee", Toast.LENGTH_SHORT).show();

        }
        if (db.employeeDao().deleteEmployee(employee) > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

            employee = null;
        }
    }

    private void update() {
        if (employee == null) {
            Toast.makeText(this, "NoEmployee", Toast.LENGTH_SHORT).show();

        }
        if (db.employeeDao().UpdateEmployee(employee) > 0) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

            employee = null;
        }
    }
    public void getInfoEmployee(int id) {
        employee = db.employeeDao().findEmployee(id);
        EmployeeName.setText(employee.getName());
        Designation.setText(employee.getDes());
        Salary.setText(employee.getSalary());
    }
    private void add(){
        if (!validate()){
            return;
        }
        Employee employee = new Employee();
        long id=db.employeeDao().insertEmployee(employee);
        if (id>0){
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate() {
        String mes = null;
        if (EmployeeName.getText().toString().trim().isEmpty()) {
            mes = "chưa nhập name";
        } else if (Designation.getText().toString().trim().isEmpty()) {
            mes = "chưa nhập des";
        }
        if (mes != null) {
            Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}