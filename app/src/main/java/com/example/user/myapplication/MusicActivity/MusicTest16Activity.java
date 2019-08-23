package com.example.user.myapplication.MusicActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.R;
import com.example.user.myapplication.VoiceExampleActivity;
import com.example.user.myapplication.controller.FileController;
import com.example.user.myapplication.controller.PlayController;
import com.example.user.myapplication.controller.UserController;
import com.example.user.myapplication.model.dto.CIDto;
import com.example.user.myapplication.model.dto.NHDto;

import java.io.IOException;

import static com.example.user.myapplication.ChildTypeActivity.childTypeCheck;
import static com.example.user.myapplication.LoginCIActivity.userCIDto;
import static com.example.user.myapplication.LoginNHActivity.userNHDto;
import static com.example.user.myapplication.MusicActivity.MusicTest15Activity.emotionM15;
import static com.example.user.myapplication.VoiceTypeActivity.voiceCount;

public class MusicTest16Activity extends AppCompatActivity {

    Button musicTest16_1, musicTest16_2,musicTest16_Play, musicTest16_Stop, musicTest16_Pause;

    private MediaPlayer mp;

    public static MediaPlayer emotionM16;
    private String CLICK_PATH = Environment.getExternalStorageDirectory() + "/Music";

    private String FILE_PATH = Environment.getExternalStorageDirectory() + "/Music/MusicFile";

    private String RESULT_PATH = "";

    private Long startTime, lastTime;
    private int timerCounter = 0;

    private NHDto nHDto;
    private CIDto cIDto;
    private UserController userController;
    private PlayController playController;
    private FileController fileController;
    private boolean playCheck = false;

    public static Long musicScore3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_test16);

        musicTest16_1 = (Button) findViewById(R.id.musicTest16_1);
        musicTest16_2 = (Button) findViewById(R.id.musicTest16_2);
        musicTest16_Play = (Button) findViewById(R.id.musicTest16_Play);
        musicTest16_Stop = (Button) findViewById(R.id.musicTest16_Stop);
        musicTest16_Pause = (Button) findViewById(R.id.musicTest16_Pause);

        userController = new UserController(getApplicationContext());
        playController = new PlayController(getApplicationContext());
        fileController = new FileController(getApplicationContext());

        musicTest16_1.setEnabled(false);
        musicTest16_2.setEnabled(false);

        mp = new MediaPlayer();
        emotionM16 = new MediaPlayer();
        
        RESULT_PATH = FILE_PATH + "/기쁨16.mp3";

        try {
            mp.setDataSource(RESULT_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        musicTest16_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionM16.setDataSource(CLICK_PATH + "/기뻐요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionM16);

                lastTime = System.currentTimeMillis();
                musicScore3 = 1L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음악",16, "기쁨", "기쁨", musicScore3, null, (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음악",16,"기쁨","기쁨",musicScore3,null,(lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                if(voiceCount == 0) {
                    Intent intent = new Intent(getApplicationContext(), VoiceExampleActivity.class);
                    startActivity(intent);
                }
                else if(voiceCount == 1) {

                    if(childTypeCheck == 2) {
                        fileController.createNHFile(nHDto.getName());
                    }
                    else if(childTypeCheck == 1) {
                        fileController.createCIFile(cIDto.getName());
                    }

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }

            }
        });

        musicTest16_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionM16.setDataSource(CLICK_PATH + "/슬퍼요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionM16);

                lastTime = System.currentTimeMillis();
                musicScore3 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음악",16, "기쁨", "슬픔", musicScore3, "기쁨", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);

                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음악",16,"기쁨","슬픔",musicScore3,"기쁨",(lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                if(voiceCount == 0) {
                    Intent intent = new Intent(getApplicationContext(), VoiceExampleActivity.class);
                    startActivity(intent);
                }
                else if(voiceCount == 1) {

                    if(childTypeCheck == 2) {
                        fileController.createNHFile(nHDto.getName());
                    }
                    else if(childTypeCheck == 1) {
                        fileController.createCIFile(cIDto.getName());
                    }

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }

            }
        });

        musicTest16_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(timerCounter == 0) {
                    startTime = System.currentTimeMillis();
                    timerCounter++;
                    emotionM15.release();
                }

                if(playCheck == false) {
                    playController.IsPlaying(mp);
                    playCheck = false;
                }
                else if(playCheck == true)
                    mp.start();

                musicTest16_1.setEnabled(true);
                musicTest16_2.setEnabled(true);

            }
        });

        musicTest16_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playController.IsStopping(mp);
                playCheck = false;

            }
        });

        musicTest16_Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playController.IsPausing(mp);
                playCheck = true;

            }
        });

    }

}
