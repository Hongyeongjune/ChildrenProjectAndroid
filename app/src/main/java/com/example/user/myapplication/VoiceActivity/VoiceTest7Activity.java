package com.example.user.myapplication.VoiceActivity;

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
import static com.example.user.myapplication.VoiceActivity.VoiceTest6Activity.emotionV6;

public class VoiceTest7Activity extends AppCompatActivity {

    private Button voiceTest7_1, voiceTest7_2, voiceTest7_3, voiceTest7_4, voiceTest7_Play, voiceTest7_Stop, voiceTest7_Pause;

    private MediaPlayer mp;

    public static MediaPlayer emotionV7 ;
    private String CLICK_PATH = Environment.getExternalStorageDirectory() + "/Music";

    private String FILE_PATH = Environment.getExternalStorageDirectory() + "/Music/VoiceFile";

    private String RESULT_PATH = "";

    private Long startTime, lastTime;
    private int timerCounter = 0;

    private CIDto cIDto;
    private NHDto nHDto;

    private UserController userController;
    private PlayController playController;
    private boolean playCheck = false;

    public static Long voiceScore7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_test7);

        voiceTest7_1 = (Button) findViewById(R.id.voiceTest7_1);
        voiceTest7_2 = (Button) findViewById(R.id.voiceTest7_2);
        voiceTest7_3 = (Button) findViewById(R.id.voiceTest7_3);
        voiceTest7_4 = (Button) findViewById(R.id.voiceTest7_4);
        voiceTest7_Play = (Button) findViewById(R.id.voiceTest7_Play);
        voiceTest7_Stop = (Button) findViewById(R.id.voiceTest7_Stop);
        voiceTest7_Pause = (Button) findViewById(R.id.voiceTest7_Pause);

        userController = new UserController(getApplicationContext());
        playController = new PlayController(getApplicationContext());

        voiceTest7_1.setEnabled(false);
        voiceTest7_2.setEnabled(false);
        voiceTest7_3.setEnabled(false);
        voiceTest7_4.setEnabled(false);

        mp = new MediaPlayer();
        emotionV7 = new MediaPlayer();
        
        RESULT_PATH = FILE_PATH + "/슬픔7.wav";

        try {
            mp.setDataSource(RESULT_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        voiceTest7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV7.setDataSource(CLICK_PATH + "/기뻐요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV7);

                lastTime = System.currentTimeMillis();
                voiceScore7 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",7, "슬픔", "기쁨", voiceScore7, "슬픔", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",7, "슬픔", "기쁨", voiceScore7, "슬픔", (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), VoiceTest8Activity.class);
                startActivity(intent);


            }
        });

        voiceTest7_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV7.setDataSource(CLICK_PATH + "/슬퍼요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV7);

                lastTime = System.currentTimeMillis();
                voiceScore7 = 1L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",7, "슬픔", "슬픔", voiceScore7, null, (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",7, "슬픔", "슬픔", voiceScore7, null, (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), VoiceTest8Activity.class);
                startActivity(intent);

            }
        });

        voiceTest7_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV7.setDataSource(CLICK_PATH + "/화났어요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV7);

                lastTime = System.currentTimeMillis();
                voiceScore7 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",7, "슬픔", "화남", voiceScore7, "슬픔", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",7, "슬픔", "화남", voiceScore7, "슬픔", (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), VoiceTest8Activity.class);
                startActivity(intent);

            }
        });

        voiceTest7_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV7.setDataSource(CLICK_PATH + "/무서워요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV7);

                lastTime = System.currentTimeMillis();
                voiceScore7 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",7, "슬픔", "무서움", voiceScore7, "슬픔", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",7, "슬픔", "무서움", voiceScore7, "슬픔", (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), VoiceTest8Activity.class);
                startActivity(intent);

            }
        });

        voiceTest7_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(timerCounter == 0) {
                    startTime = System.currentTimeMillis();
                    timerCounter++;
                    emotionV6.release();
                }

                if(playCheck == false) {
                    playController.IsPlaying(mp);
                    playCheck = false;
                }
                else if(playCheck == true)
                    mp.start();

                voiceTest7_1.setEnabled(true);
                voiceTest7_2.setEnabled(true);
                voiceTest7_3.setEnabled(true);
                voiceTest7_4.setEnabled(true);


            }
        });

        voiceTest7_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playController.IsStopping(mp);
                playCheck = false;

            }
        });

        voiceTest7_Pause.setOnClickListener(new View.OnClickListener() {
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
