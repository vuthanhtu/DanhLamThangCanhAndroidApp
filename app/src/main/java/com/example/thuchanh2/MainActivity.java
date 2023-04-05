package com.example.thuchanh2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhLam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvDanhLam = (ListView) findViewById(R.id.listviewDanhLam);
        ArrayList<String> ten = new ArrayList<>();
        ten.add("Hồ Gươm");
        ten.add("Lăng Bác Hồ");
        ten.add("Cột cờ Hà Nội");
        ten.add("Chùa Một Cột");
        ten.add("Hồ Tây");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,ten);
        lvDanhLam.setAdapter(adapter);
        ArrayList<Integer> imageId = new ArrayList<>();
        imageId.add(R.drawable.a);
        imageId.add(R.drawable.b);
        imageId.add(R.drawable.c);
        imageId.add(R.drawable.d);
        imageId.add(R.drawable.e);
        ArrayList<String> description = new ArrayList<>();
        description.add("Là một hồ nước ngọt nằm ở trung tâm thành phố Hà Nội");
        description.add("Là nơi gìn giữ di hài Chủ tịch Hồ Chí Minh");
        description.add("Là một kết cấu dạng tháp được xây dựng dưới thời nhà Nguyễn");
        description.add("Là một ngôi chùa có kiến trúc độc đáo");
        description.add("Là hồ tự nhiên lớn nhất Hà Nội");
        ArrayList<DanhLam> dl = new ArrayList<>();
        for(int i=0;i<imageId.size();i++){
            DanhLam tmp = new DanhLam(ten.get(i),description.get(i),imageId.get(i));
            dl.add(tmp);
        }
        lvDanhLam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("name",ten.get(i));
                intent.putExtra("description",description.get(i));
                intent.putExtra("imageid",imageId.get(i));
                startActivity(intent);
            }
        });
    }
}