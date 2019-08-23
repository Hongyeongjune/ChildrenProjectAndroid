package com.example.user.myapplication.controller;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

public class PlayController {

    Context context;

    public PlayController(Context context) {
        this.context = context;
    }

    public void IsPlaying(MediaPlayer mp) {

        if(!mp.isPlaying()) {
            try {
                mp.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mp.start();
        }

    }


    public void IsStopping(MediaPlayer mp) {


        mp.stop();


    }

    public void IsPausing(MediaPlayer mp) {

//        if(mp.isPlaying()) {
            mp.pause();
//        }

    }

    public void IsExamPlaying(MediaPlayer mp) {

        if(!mp.isPlaying()) {
            try {
                mp.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mp.start();
        }

    }

    public void IsExamStopping(MediaPlayer mp) {

        if(mp.isPlaying()) {
            mp.stop();
            mp.reset();
        }

    }

}
