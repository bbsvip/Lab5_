package com.bbs.mr.employeemanage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    public static List<Employee> employees = new ArrayList<>();
    static int check = 0;
    ListView lvEmployee;
    ArrayAdapter<Employee> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        if (check == 0) {
            dummyData();
        }
        lvEmployee = findViewById(R.id.lvEmployee);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);
        lvEmployee.setAdapter(adapter);
        lvEmployee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new
                        Intent(ListActivity.this, DetailActivity.class);
                startActivity(intent);
                DetailActivity.position = position;
            }
        });
        lvEmployee.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int
                    position, long id) {
                return false;
            }
        });
    }

    private int dummyData() {
        employees.add(new Employee("PD01634", "Huỳnh Nguyễn Hà Nam", "12/12/1990", "0905234532", "namhnhpd01634@fpt.edu.vn"));
        employees.add(new Employee("PD02345", "Lưu Trương Hữu Khánh", "30/03/1999", "01647079556", "khanhlthpd02345@fpt.edu.vn"));
        employees.add(new Employee("MrBBS", "Cừu Đen", "null", "01647079556", "0331999bbs@gmail.com"));
        employees.add(new Employee("PD01829", "Phan Đình Phi Hải", "15/12/1990", "0905234535", "haipdppd01829@fpt.edu.vn"));
        check = 1;
        return check;
    }
}
