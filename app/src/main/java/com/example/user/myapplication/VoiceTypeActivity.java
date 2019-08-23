package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapplication.controller.FileController;

import static com.example.user.myapplication.LoginNHActivity.userNHDto;

public class VoiceTypeActivity extends AppCompatActivity {

    private Button musicTypeButton, voiceTypeButton;
    public static int musicCount = 0;
    public static int voiceCount = 0;

    FileController fileController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_type);

        musicTypeButton = (Button) findViewById(R.id.MusicTypeButton);
        voiceTypeButton = (Button) findViewById(R.id.VoiceTypeButton);

        fileController = new FileController(getApplicationContext());

        musicTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MusicExampleActivity.class);
                startActivity(intent);

            }
        });

        voiceTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), VoiceExampleActivity.class);
                startActivity(intent);

            }
        });

    }
}
