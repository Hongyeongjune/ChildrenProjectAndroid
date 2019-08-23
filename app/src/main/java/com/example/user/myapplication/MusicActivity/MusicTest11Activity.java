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
import static com.example.user.myapplication.MusicActivity.MusicTest10Activity.emotionM10;

public class MusicTest11Activity extends AppCompatActivity {

    Button musicTest11_1, musicTest11_2,musicTest11_Play, musicTest11_Stop, musicTest11_Pause;

    private MediaPlayer mp;

    public static MediaPlayer emotionM11;
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

    public static Long musicScore11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_test11);

        musicTest11_1 = (Button) findViewById(R.id.musicTest11_1);
        musicTest11_2 = (Button) findViewById(R.id.musicTest11_2);
        musicTest11_Play = (Button) findViewById(R.id.musicTest11_Play);
        musicTest11_Stop = (Button) findViewById(R.id.musicTest11_Stop);
        musicTest11_Pause = (Button) findViewById(R.id.musicTest11_Pause);

        userController = new UserController(getApplicationContext());
        playController = new PlayController(getApplicationContext());

        musicTest11_1.setEnabled(false);
        musicTest11_2.setEnabled(false);
        
        mp = new MediaPlayer();
        emotionM11 = new MediaPlayer();
        
        RESULT_PATH = FILE_PATH + "/슬픔11.mp3";

        try {
            mp.setDataSource(RESULT_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        musicTest11_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionM11.setDataSource(CLICK_PATH + "/기뻐요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionM11);

                lastTime = System.currentTimeMillis();
                musicScore11 = 0L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음악",11, "슬픔", "기쁨", musicScore11, "슬픔", (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);
                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음악",11,"슬픔","기쁨",musicScore11,"슬픔",(lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), MusicTest12Activity.class);
                startActivity(intent);

            }
        });

        musicTest11_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();

                try {
                    emotionM11.setDataSource(CLICK_PATH + "/슬퍼요.mp3");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                playController.IsPlaying(emotionM11);

                lastTime = System.currentTimeMillis();
                musicScore11 = 1L;

                if(childTypeCheck == 2) {

                    nHDto = new NHDto(userNHDto.getName().toString(), userNHDto.getAge().toString(), userNHDto.getSex().toString(),
                            "음악",11, "슬픔", "슬픔", musicScore11, null, (lastTime - startTime) / 1000);

                    userController.signupNH(nHDto);

                }

                else if(childTypeCheck == 1) {

                    cIDto = new CIDto(userCIDto.getName().toString(), userCIDto.getAge().toString(), userCIDto.getSex().toString(),
                            userCIDto.getLeftStart().toString(),userCIDto.getRightStart().toString(),userCIDto.getLeftDate().toString(),userCIDto.getRightDate().toString(),
                            userCIDto.getLeftDevice().toString(),userCIDto.getRightDevice().toString(),
                            "음악",11,"슬픔","슬픔",musicScore11,null,(lastTime - startTime) / 1000);

                    userController.signupCI(cIDto);

                }

                Intent intent = new Intent(getApplicationContext(), MusicTest12Activity.class);
                startActivity(intent);

            }
        });

        musicTest11_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(timerCounter == 0) {
                    startTime = System.currentTimeMillis();
                    timerCounter++;
                    emotionM10.release();
                }

                if(playCheck == false) {
                    playController.IsPlaying(mp);
                    playCheck = false;
                }
                else if(playCheck == true)
                    mp.start();

                musicTest11_1.setEnabled(true);
                musicTest11_2.setEnabled(true);

            }
        });

        musicTest11_Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                playController.IsStopping(mp);
                playCheck = false;

            }
        });

        musicTest11_Pause.setOnClickListener(new View.OnClickListener() {
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
