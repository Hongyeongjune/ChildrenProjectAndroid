package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapplication.controller.FileController;

public class ChildTypeActivity extends AppCompatActivity {

    public static int childTypeCheck = 0;

    private FileController fileController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_type);

        Button button1 = (Button) findViewById(R.id.childTypeButton1);
        Button button2 = (Button) findViewById(R.id.childTypeButton2);

        fileController = new FileController(getApplicationContext());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginCIActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginNHActivity.class);
                startActivity(intent);
            }
        });

    }
}
