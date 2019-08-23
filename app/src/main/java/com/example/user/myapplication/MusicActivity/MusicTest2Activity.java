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
import static com.example.user.myapplication.MusicActivity.MusicTest1Activity.emotionM1;

public class MusicTest2Activity extends AppCompatActivity {

    Button musicTest2_1, musicTest2_2,musicTest2_Play, musicTest2_Stop, musicTest2_Pause;

    private MediaPlayer mp;

    public static MediaPlayer emotionM2;
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
    
    public static Long musicScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_test2);

        musicTest2_1 = (Button) findViewById(R.id.musicTest2_1);
        musicTest2_2 = (Button) findViewById(R.id.musicTest2_2);
        musicTest2_Play = (Button) findViewById(R.id.musicTest2_Play);
        musicTest2_Stop = (Button) findViewById(R.id.musicTest2_Stop);
        musicTest2_Pause = (Button) findViewById(R.id.musicTest2_Pause);

        userController = new UserController(getApplicationContext());
        playController = new PlayController(getApplicationContext());

        musicTest2_1.setEnabled(false);
        musicTest2_2.setEnabled(false);

        mp = new MediaPlayer();
        emotionM2 = new MediaPlayer();
        
        RESULT_PATH = FILE_PATH + "/슬픔2.mp3";

        try {
            mp.setDataSource(RESULT_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        musicTest2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionM2.setDataSource(CLICK_PATH + "/기뻐요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionM2);

                lastTime = System.currentTimeMillis();
                musicScore2 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음악",2, "슬픔", "기쁨", musicScore2, "슬픔", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음악",2,"슬픔","기쁨",musicScore2,"슬픔",(lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), MusicTest3Activity.class);
                startActivity(intent);

            }
        });

        musicTest2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionM2.setDataSource(CLICK_PATH + "/슬퍼요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionM2);

                lastTime = System.currentTimeMillis();
                musicScore2 = 1L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음악",2, "슬픔", "슬픔", musicScore2, null, (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);

                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음악",2,"슬픔","슬픔",musicScore2,null,(lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), MusicTest3Activity.class);
                startActivity(intent);

            }
        });

        musicTest2_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(timerCounter == 0) {
                    startTime = System.currentTimeMillis();
                    timerCounter++;
                    emotionM1.release();
                }

                if(playCheck == false) {
                    playController.IsPlaying(mp);
                    playCheck = false;
                }
                else if(playCheck == true)
                    mp.start();

                musicTest2_1.setEnabled(true);
                musicTest2_2.setEnabled(true);

            }
        });

        musicTest2_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playController.IsStopping(mp);
                playCheck = false;

            }
        });

        musicTest2_Pause.setOnClickListener(new View.OnClickListener() {
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
