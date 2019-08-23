package com.example.user.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapplication.MusicActivity.MusicTest1Activity;
import com.example.user.myapplication.controller.PlayController;
import static com.example.user.myapplication.VoiceTypeActivity.musicCount;

import java.io.IOException;

public class MusicExampleActivity extends AppCompatActivity {

    private Button happyExamButton, sadExamButton, musicNextButton, musicStopButton, happyExampleButton, sadExampleButton;

    private MediaPlayer mp, exampleM;

    private String FILE_PATH = Environment.getExternalStorageDirectory() + "/Music";
    private String EXAM_PATH = "";

    private PlayController playController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_example);

        happyExamButton = (Button) findViewById(R.id.happyExamButtonMusic);
        sadExamButton = (Button) findViewById(R.id.sadExamButtonMusic);
        musicNextButton = (Button) findViewById(R.id.musicExampleButton);
        musicStopButton = (Button) findViewById(R.id.musicExampleStopButton);
        happyExampleButton = (Button) findViewById(R.id.happyExampleButtonMusic);
        sadExampleButton = (Button) findViewById(R.id.sadExampleButtonMusic);

        musicCount = 1;

        mp = new MediaPlayer();
        exampleM = new MediaPlayer();

        playController = new PlayController(getApplicationContext());

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                mp.reset();

                happyExamButton.setEnabled(true);
                sadExamButton.setEnabled(true);
                happyExampleButton.setEnabled(true);
                sadExampleButton.setEnabled(true);
            }
        });

        happyExamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                EXAM_PATH = FILE_PATH + "/HappyExampleMusic.mp3";
                EXAM_PATH = FILE_PATH + "/기뻐요.mp3";

                try {
                    exampleM.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(exampleM);

                if(mp.isPlaying()) {
                    playController.IsExamStopping(mp);
                    mp.reset();
                }

                happyExamButton.setEnabled(false);
                sadExamButton.setEnabled(false);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);

            }
        });

        sadExamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXAM_PATH = FILE_PATH + "/슬퍼요.mp3";
                try {
                    exampleM.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(exampleM);

                if(mp.isPlaying()) {
                    playController.IsExamStopping(mp);
                    mp.reset();
                }

                if(mp.isPlaying())
                    playController.IsExamPlaying(mp);

                happyExamButton.setEnabled(false);
                sadExamButton.setEnabled(false);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);

            }
        });

        musicStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playController.IsExamStopping(mp);
                playController.IsExamStopping(exampleM);
                exampleM.reset();

                happyExamButton.setEnabled(true);
                sadExamButton.setEnabled(true);
                happyExampleButton.setEnabled(true);
                sadExampleButton.setEnabled(true);

            }
        });

        musicNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();
                exampleM.release();

                Intent intent = new Intent(getApplicationContext(), MusicTest1Activity.class);
                startActivity(intent);

            }
        });


        happyExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXAM_PATH = FILE_PATH + "/HappyExampleMusic.mp3";

                try {
                    mp.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(mp);

                happyExamButton.setEnabled(true);
                sadExamButton.setEnabled(true);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);

            }
        });

        sadExampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EXAM_PATH = FILE_PATH + "/SadExampleMusic.mp3";

                try {
                    mp.setDataSource(EXAM_PATH);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsExamPlaying(mp);

                happyExamButton.setEnabled(true);
                sadExamButton.setEnabled(true);
                happyExampleButton.setEnabled(false);
                sadExampleButton.setEnabled(false);

            }
        });
    }
}
