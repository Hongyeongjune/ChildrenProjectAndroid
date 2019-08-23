package com.example.user.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapplication.VoiceActivity.VoiceTest1Activity;
import com.example.user.myapplication.controller.PlayController;

import static com.example.user.myapplication.VoiceTypeActivity.voiceCount;

import java.io.IOException;

public class VoiceExampleActivity extends AppCompatActivity {

    private Button happyExamButton, sadExamButton, angryExamButton, scaredExamButton, voiceExampleButton, voiceStopButton;
    private Button happyExampleButton, sadExampleButton, angryExampleButton, scaredExampleButton;

    private MediaPlayer mp;
    private MediaPlayer exampleV;

    private String FILE_PATH = Environment.getExternalStorageDirectory() + "/Music";
    private String EXAM_PATH = "";

    private PlayController playController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_example);

        happyExamButton = (Button) findViewById(R.id.happyExamButtonVoice);
        sadExamButton = (Button) findViewById(R.id.sadExamButtonVoice);
        angryExamButton = (Button) findViewById(R.id.angryExamButtonVoice);
        scaredExamButton = (Button) findViewById(R.id.scaredExamButtonVoice);
        voiceExampleButton = (Button) findViewById(R.id.voiceExampleButton);
        voiceStopButton = (Button) findViewById(R.id.voiceExampleStopButton);

        happyExampleButton = (Button) findViewById(R.id.happyExampleButtonVoice);
        sadExampleButton = (Button) findViewById(R.id.sadExampleButtonVoice);
        angryExampleButton = (Button) findViewById(R.id.angryExampleButtonVoice);
        scaredExampleButton = (Button) findViewById(R.id.scaredExampleButtonVoice);

        voiceCount = 1;

        mp = new MediaPlayer();
        exampleV = new MediaPlayer();

        playController = new PlayController(getApplicationContext());

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.reset();
                happyExamButton.setEnabled(true);
                sadExamButton.setEnabled(true);
                angryExamButton.setEnabled(true);
                scaredExamButton.setEnabled(true);

                happyExampleButton.setEnabled(true);
                sadExampleButton.setEnabled(true);
                angryExampleButton.setEnabled(true);
                scaredExampleButton.setEnabled(true);
            }
        });

        happyExamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXAM_PATH = FILE_PATH + "/기뻐요.mp3";

                try {
                    exampleV.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(exampleV);

                if(mp.isPlaying()) {
                    playController.IsExamStopping(mp);
                    mp.reset();
                }

                happyExamButton.setEnabled(false);
                sadExamButton.setEnabled(false);
                angryExamButton.setEnabled(false);
                scaredExamButton.setEnabled(false);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);
                angryExampleButton.setEnabled(false);
                scaredExampleButton.setEnabled(false);

            }
        });

        sadExamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXAM_PATH = FILE_PATH + "/슬퍼요.mp3";

                try {
                    exampleV.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(exampleV);

                if(mp.isPlaying()) {
                    playController.IsExamStopping(mp);
                    mp.reset();
                }

                happyExamButton.setEnabled(false);
                sadExamButton.setEnabled(false);
                angryExamButton.setEnabled(false);
                scaredExamButton.setEnabled(false);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);
                angryExampleButton.setEnabled(false);
                scaredExampleButton.setEnabled(false);
            }
        });

        angryExamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXAM_PATH = FILE_PATH + "/화났어요.mp3";

                try {
                    exampleV.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(exampleV);

                if(mp.isPlaying()) {
                    playController.IsExamStopping(mp);
                    mp.reset();
                }

                happyExamButton.setEnabled(false);
                sadExamButton.setEnabled(false);
                angryExamButton.setEnabled(false);
                scaredExamButton.setEnabled(false);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);
                angryExampleButton.setEnabled(false);
                scaredExampleButton.setEnabled(false);
            }
        });

        scaredExamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXAM_PATH = FILE_PATH + "/무서워요.mp3";

                try {
                    exampleV.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(exampleV);

                if(mp.isPlaying()) {
                    playController.IsExamStopping(mp);
                    mp.reset();
                }

                happyExamButton.setEnabled(false);
                sadExamButton.setEnabled(false);
                angryExamButton.setEnabled(false);
                scaredExamButton.setEnabled(false);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);
                angryExampleButton.setEnabled(false);
                scaredExampleButton.setEnabled(false);
            }
        });

        voiceExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                Intent intent = new Intent(getApplicationContext(), VoiceTest1Activity.class);
                startActivity(intent);

            }
        });

        voiceStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playController.IsExamStopping(mp);
                playController.IsExamStopping(exampleV);
                exampleV.reset();

                happyExamButton.setEnabled(true);
                sadExamButton.setEnabled(true);
                angryExamButton.setEnabled(true);
                scaredExamButton.setEnabled(true);
                happyExampleButton.setEnabled(true);
                sadExampleButton.setEnabled(true);
                angryExampleButton.setEnabled(true);
                scaredExampleButton.setEnabled(true);
            }
        });


        happyExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXAM_PATH = FILE_PATH + "/HappyExampleVoice.wav";

                try {
                    mp.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(mp);

                happyExamButton.setEnabled(true);
                sadExamButton.setEnabled(true);
                angryExamButton.setEnabled(true);
                scaredExamButton.setEnabled(true);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);
                angryExampleButton.setEnabled(false);
                scaredExampleButton.setEnabled(false);

            }
        });

        sadExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXAM_PATH = FILE_PATH + "/SadExampleVoice.wav";

                try {
                    mp.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(mp);

                happyExamButton.setEnabled(true);
                sadExamButton.setEnabled(true);
                angryExamButton.setEnabled(true);
                scaredExamButton.setEnabled(true);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);
                angryExampleButton.setEnabled(false);
                scaredExampleButton.setEnabled(false);

            }
        });

        angryExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXAM_PATH = FILE_PATH + "/AngryExampleVoice.wav";

                try {
                    mp.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(mp);

                happyExamButton.setEnabled(true);
                sadExamButton.setEnabled(true);
                angryExamButton.setEnabled(true);
                scaredExamButton.setEnabled(true);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);
                angryExampleButton.setEnabled(false);
                scaredExampleButton.setEnabled(false);

            }
        });

        scaredExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXAM_PATH = FILE_PATH + "/ScaredExampleVoice.wav";

                try {
                    mp.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(mp);

                happyExamButton.setEnabled(true);
                sadExamButton.setEnabled(true);
                angryExamButton.setEnabled(true);
                scaredExamButton.setEnabled(true);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);
                angryExampleButton.setEnabled(false);
                scaredExampleButton.setEnabled(false);

            }
        });

    }
}
