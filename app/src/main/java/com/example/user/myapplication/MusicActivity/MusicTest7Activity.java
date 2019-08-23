package com.example.user.myapplication.MusicActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapplication.R;
import com.example.user.myapplication.controller.PlayController;
import com.example.user.myapplication.controller.UserController;
import com.example.user.myapplication.model.dto.CIDto;
import com.example.user.myapplication.model.dto.NHDto;

import java.io.IOException;

import static com.example.user.myapplication.ChildTypeActivity.childTypeCheck;
import static com.example.user.myapplication.LoginCIActivity.userCIDto;
import static com.example.user.myapplication.LoginNHActivity.userNHDto;
import static com.example.user.myapplication.MusicActivity.MusicTest6Activity.emotionM6;

public class MusicTest7Activity extends AppCompatActivity {

    Button musicTest7_1, musicTest7_2,musicTest7_Play, musicTest7_Stop, musicTest7_Pause;

    private MediaPlayer mp;

    public static MediaPlayer emotionM7;
    private String CLICK_PATH = Environment.getExternalStorageDirectory() + "/Music";

    private String FILE_PATH = Environment.getExternalStorageDirectory() + "/Music/MusicFile";

    private String RESULT_PATH = "";

    private Long startTime, lastTime;
    private int timerCounter = 0;

    private NHDto nHDto;
    private CIDto cIDto;
    private UserController userController;
    private PlayController playController;
    private boolean playCheck = false;

    public static Long musicScore3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_test7);

        musicTest7_1 = (Button) findViewById(R.id.musicTest7_1);
        musicTest7_2 = (Button) findViewById(R.id.musicTest7_2);
        musicTest7_Play = (Button) findViewById(R.id.musicTest7_Play);
        musicTest7_Stop = (Button) findViewById(R.id.musicTest7_Stop);
        musicTest7_Pause = (Button) findViewById(R.id.musicTest7_Pause);

        userController = new UserController(getApplicationContext());
        playController = new PlayController(getApplicationContext());

        musicTest7_1.setEnabled(false);
        musicTest7_2.setEnabled(false);

        mp = new MediaPlayer();
        emotionM7 = new MediaPlayer();
        
        RESULT_PATH = FILE_PATH + "/기쁨7.mp3";

        try {
            mp.setDataSource(RESULT_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        musicTest7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionM7.setDataSource(CLICK_PATH + "/기뻐요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionM7);

                lastTime = System.currentTimeMillis();
                musicScore3 = 1L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음악",7, "기쁨", "기쁨", musicScore3, null, (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음악",7,"기쁨","기쁨",musicScore3,null,(lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), MusicTest8Activity.class);
                startActivity(intent);

            }
        });

        musicTest7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionM7.setDataSource(CLICK_PATH + "/슬퍼요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionM7);

                lastTime = System.currentTimeMillis();
                musicScore3 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음악",7, "기쁨", "슬픔", musicScore3, "기쁨", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);

                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음악",7,"기쁨","슬픔",musicScore3,"기쁨",(lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), MusicTest8Activity.class);
                startActivity(intent);

            }
        });

        musicTest7_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(timerCounter == 0) {
                    startTime = System.currentTimeMillis();
                    timerCounter++;
                    emotionM6.release();
                }

                if(playCheck == false) {
                    playController.IsPlaying(mp);
                    playCheck = false;
                }
                else if(playCheck == true)
                    mp.start();

                musicTest7_1.setEnabled(true);
                musicTest7_2.setEnabled(true);

            }
        });

        musicTest7_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playController.IsStopping(mp);
                playCheck = false;

            }
        });

        musicTest7_Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mp.isPlaying()) {
                    playController.IsPausing(mp);
                    playCheck = true;
                }

            }
        });

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
            }
        });

    }

}
