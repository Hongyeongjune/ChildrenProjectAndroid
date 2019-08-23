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
import static com.example.user.myapplication.VoiceActivity.VoiceTest10Activity.emotionV10;

public class VoiceTest11Activity extends AppCompatActivity {

    private Button voiceTest11_1, voiceTest11_2, voiceTest11_3, voiceTest11_4, voiceTest11_Play, voiceTest11_Stop, voiceTest11_Pause;

    private MediaPlayer mp;

    public static MediaPlayer emotionV11 ;
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

    public static Long voiceScore11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_test11);

        voiceTest11_1 = (Button) findViewById(R.id.voiceTest11_1);
        voiceTest11_2 = (Button) findViewById(R.id.voiceTest11_2);
        voiceTest11_3 = (Button) findViewById(R.id.voiceTest11_3);
        voiceTest11_4 = (Button) findViewById(R.id.voiceTest11_4);
        voiceTest11_Play = (Button) findViewById(R.id.voiceTest11_Play);
        voiceTest11_Stop = (Button) findViewById(R.id.voiceTest11_Stop);
        voiceTest11_Pause = (Button) findViewById(R.id.voiceTest11_Pause);

        userController = new UserController(getApplicationContext());
        playController = new PlayController(getApplicationContext());

        voiceTest11_1.setEnabled(false);
        voiceTest11_2.setEnabled(false);
        voiceTest11_3.setEnabled(false);
        voiceTest11_4.setEnabled(false);

        mp = new MediaPlayer();
        emotionV11 = new MediaPlayer();

        RESULT_PATH = FILE_PATH + "/무서움11.wav";

        try {
            mp.setDataSource(RESULT_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        voiceTest11_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV11.setDataSource(CLICK_PATH + "/기뻐요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV11);

                lastTime = System.currentTimeMillis();
                voiceScore11 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",11, "무서움", "기쁨", voiceScore11, "무서움", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",11, "무서움", "기쁨", voiceScore11, "무서움", (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), VoiceTest12Activity.class);
                startActivity(intent);


            }
        });

        voiceTest11_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV11.setDataSource(CLICK_PATH + "/슬퍼요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV11);

                lastTime = System.currentTimeMillis();
                voiceScore11 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",11, "무서움", "슬픔", voiceScore11, "무서움", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",11, "무서움", "슬픔", voiceScore11, "무서움", (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), VoiceTest12Activity.class);
                startActivity(intent);

            }
        });

        voiceTest11_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV11.setDataSource(CLICK_PATH + "/화났어요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV11);

                lastTime = System.currentTimeMillis();
                voiceScore11 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",11, "무서움", "화남", voiceScore11, "무서움", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",11, "무서움", "화남", voiceScore11, "무서움", (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), VoiceTest12Activity.class);
                startActivity(intent);

            }
        });

        voiceTest11_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV11.setDataSource(CLICK_PATH + "/무서워요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV11);

                lastTime = System.currentTimeMillis();
                voiceScore11 = 1L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",11, "무서움", "무서움", voiceScore11, null, (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",11, "무서움", "무서움", voiceScore11, null, (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), VoiceTest12Activity.class);
                startActivity(intent);

            }
        });

        voiceTest11_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(timerCounter == 0) {
                    startTime = System.currentTimeMillis();
                    timerCounter++;
                    emotionV10.release();
                }

                if(playCheck == false) {
                    playController.IsPlaying(mp);
                    playCheck = false;
                }
                else if(playCheck == true)
                    mp.start();

                voiceTest11_1.setEnabled(true);
                voiceTest11_2.setEnabled(true);
                voiceTest11_3.setEnabled(true);
                voiceTest11_4.setEnabled(true);


            }
        });

        voiceTest11_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playController.IsStopping(mp);
                playCheck = false;

            }
        });

        voiceTest11_Pause.setOnClickListener(new View.OnClickListener() {
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

