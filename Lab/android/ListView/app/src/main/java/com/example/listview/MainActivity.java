package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvCourse;
    ArrayList<String> arrayCourse;
    Button btnAdd,btnUpdate;
    EditText editCourse;
    int vt=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        lvCourse=(ListView) findViewById(R.id.lvCourse);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnUpdate=(Button) findViewById(R.id.btnUpdate);
        editCourse =(EditText)  findViewById(R.id.editTextCourse);
        //dữ liệu
        arrayCourse=new ArrayList<>();
        arrayCourse.add("Asp.net");
        arrayCourse.add("Nodejs");
        arrayCourse.add("PHP");
        arrayCourse.add("Pythont");
        //adapter trung gian để truyền dữ liệu cho view
        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_list_item_1,arrayCourse);
        lvCourse.setAdapter(adapter);
        //sự kiện click vào 1 item
        lvCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    editCourse.setText(arrayCourse.get(i));
                    vt=i;
            }
        });
        //sự kiện add 1 dữ liệu vào listview
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String course=editCourse.getText().toString().trim();
                if(course.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Tên môn học không được rỗng",Toast.LENGTH_SHORT).show();
                    return;
                }
                arrayCourse.add(course);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                editCourse.setText("");
            }
        });
        //update 1 dữ liệu
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String course=editCourse.getText().toString().trim();
                    if(course.isEmpty())
                    {
                        Toast.makeText(MainActivity.this,"Tên môn học không được rỗng",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    arrayCourse.set(vt,course);
                    adapter.notifyDataSetChanged();
            }
        });
        //sự kiện click dài xoá 1 dữ liệu
        lvCourse.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayCourse.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Xoá thành công",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}