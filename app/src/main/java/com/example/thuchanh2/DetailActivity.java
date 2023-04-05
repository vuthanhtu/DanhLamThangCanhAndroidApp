package com.example.thuchanh2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Intent intent = this.getIntent();
        TextView ten = (TextView) findViewById(R.id.name);
        TextView mota = (TextView)findViewById(R.id.description);
        ImageView img = (ImageView) findViewById(R.id.imgAdd);
        Button map = (Button) findViewById(R.id.btnMap);
        if(intent!=null){
            String name = intent.getStringExtra("name");
            String description = intent.getStringExtra("description");
            int imageid = intent.getIntExtra("imageid",R.drawable.a);
            ten.setText(name);
            mota.setText(description);
            img.setImageResource(imageid);
        }
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = String.format(Locale.ENGLISH,"geo:%f,%f",21.023999904,105.85196594);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }
}
