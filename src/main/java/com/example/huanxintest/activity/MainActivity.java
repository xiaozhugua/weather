package com.example.huanxintest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.huanxintest.R;
import com.example.huanxintest.model.person;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=new Intent(this,MainActivity.class);
        intent.putExtra("person",new person());
        startActivity(intent);


        person p=(person)getIntent().getSerializableExtra("person");

    }
}
