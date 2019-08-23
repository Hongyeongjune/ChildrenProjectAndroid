package com.example.user.myapplication.VoiceActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapplication.MainActivity;
import com.example.user.myapplication.MusicExampleActivity;
import com.example.user.myapplication.R;
import com.example.user.myapplication.controller.FileController;
import com.example.user.myapplication.controller.PlayController;
import com.example.user.myapplication.controller.UserController;
import com.example.user.myapplication.model.dto.CIDto;
import com.example.user.myapplication.model.dto.NHDto;

import java.io.IOException;

import static com.example.user.myapplication.ChildTypeActivity.childTypeCheck;
import static com.example.user.myapplication.LoginCIActivity.userCIDto;
import static com.example.user.myapplication.LoginNHActivity.userNHDto;
import static com.example.user.myapplication.VoiceActivity.VoiceTest23Activity.emotionV23;
import static com.example.user.myapplication.VoiceTypeActivity.musicCount;

public class VoiceTest24Activity extends AppCompatActivity {

    private Button voiceTest24_1, voiceTest24_2, voiceTest24_3, voiceTest24_4, voiceTest24_Play, voiceTest24_Stop, voiceTest24_Pause;

    private MediaPlayer mp;

    public static MediaPlayer emotionV24 ;
    private String CLICK_PATH = Environment.getExternalStorageDirectory() + "/Music";

    private String FILE_PATH = Environment.getExternalStorageDirectory() + "/Music/VoiceFile";

    private String RESULT_PATH = "";

    private Long startTime, lastTime;
    private int timerCounter = 0;

    private CIDto cIDto;
    private NHDto nHDto;

    private UserController userController;
    private PlayController playController;
    private FileController fileController;

    private boolean playCheck = false;

    public static Long voiceScore24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_test24);

        voiceTest24_1 = (Button) findViewById(R.id.voiceTest24_1);
        voiceTest24_2 = (Button) findViewById(R.id.voiceTest24_2);
        voiceTest24_3 = (Button) findViewById(R.id.voiceTest24_3);
        voiceTest24_4 = (Button) findViewById(R.id.voiceTest24_4);
        voiceTest24_Play = (Button) findViewById(R.id.voiceTest24_Play);
        voiceTest24_Stop = (Button) findViewById(R.id.voiceTest24_Stop);
        voiceTest24_Pause = (Button) findViewById(R.id.voiceTest24_Pause);

        userController = new UserController(getApplicationContext());
        playController = new PlayController(getApplicationContext());
        fileController = new FileController(getApplicationContext());

        voiceTest24_1.setEnabled(false);
        voiceTest24_2.setEnabled(false);
        voiceTest24_3.setEnabled(false);
        voiceTest24_4.setEnabled(false);

        mp = new MediaPlayer();
        emotionV24 = new MediaPlayer();
        
        RESULT_PATH = FILE_PATH + "/무서움24.wav";

        try {
            mp.setDataSource(RESULT_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        voiceTest24_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV24.setDataSource(CLICK_PATH + "/기뻐요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV24);
                
                lastTime = System.currentTimeMillis();
                voiceScore24 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",24, "무서움", "기쁨", voiceScore24, "무서움", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",24, "무서움", "기쁨", voiceScore24, "무서움", (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                if(musicCount == 0) {
                    Intent intent = new Intent(getApplicationContext(), MusicExampleActivity.class);
                    startActivity(intent);
                }
                else if(musicCount == 1) {

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

        voiceTest24_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV24.setDataSource(CLICK_PATH + "/슬퍼요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV24);
                
                lastTime = System.currentTimeMillis();
                voiceScore24 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",24, "무서움", "슬픔", voiceScore24, "무서움", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",24, "무서움", "슬픔", voiceScore24, "무서움", (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                if(musicCount == 0) {
                    Intent intent = new Intent(getApplicationContext(), MusicExampleActivity.class);
                    startActivity(intent);
                }
                else if(musicCount == 1) {

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

        voiceTest24_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV24.setDataSource(CLICK_PATH + "/화났어요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV24);
                
                lastTime = System.currentTimeMillis();
                voiceScore24 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",24, "무서움", "화남", voiceScore24, "무서움", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",24, "무서움", "화남", voiceScore24, "무서움", (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                if(musicCount == 0) {
                    Intent intent = new Intent(getApplicationContext(), MusicExampleActivity.class);
                    startActivity(intent);
                }
                else if(musicCount == 1) {

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

        voiceTest24_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionV24.setDataSource(CLICK_PATH + "/무서워요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionV24);
                
                lastTime = System.currentTimeMillis();
                voiceScore24 = 1L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음성",24, "무서움", "무서움", voiceScore24, null, (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음성",24, "무서움", "무서움", voiceScore24, null, (lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                if(musicCount == 0) {
                    Intent intent = new Intent(getApplicationContext(), MusicExampleActivity.class);
                    startActivity(intent);
                }
                else if(musicCount == 1) {

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

        voiceTest24_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(timerCounter == 0) {
                    startTime = System.currentTimeMillis();
                    timerCounter++;
                    emotionV23.release();
                }

                if(playCheck == false) {
                    playController.IsPlaying(mp);
                    playCheck = false;
                }
                else if(playCheck == true)
                    mp.start();

                voiceTest24_1.setEnabled(true);
                voiceTest24_2.setEnabled(true);
                voiceTest24_3.setEnabled(true);
                voiceTest24_4.setEnabled(true);


            }
        });

        voiceTest24_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playController.IsStopping(mp);
                playCheck = false;

            }
        });

        voiceTest24_Pause.setOnClickListener(new View.OnClickListener() {
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

