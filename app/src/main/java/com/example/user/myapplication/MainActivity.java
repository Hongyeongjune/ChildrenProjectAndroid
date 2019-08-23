package com.example.user.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.user.myapplication.controller.FileController;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.user.myapplication.ChildTypeActivity.childTypeCheck;
import static com.example.user.myapplication.LoginCIActivity.userCIDto;
import static com.example.user.myapplication.LoginNHActivity.userNHDto;


public class MainActivity extends AppCompatActivity {

    Button button;
    FileController fileController;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permissionReadStorage = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
        int permissionWriteStorage = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permissionAudio = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO);
        if (permissionReadStorage == PackageManager.PERMISSION_DENIED || permissionWriteStorage == PackageManager.PERMISSION_DENIED || permissionAudio == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 2);
        }

        button = (Button) findViewById(R.id.mainButton);

        fileController = new FileController(getApplicationContext());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fileController.createFilePath();

                try {
                    fileSetting();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
    private void fileSetting() {

        timer = new Timer();
        Log.d("fileSetting : ", "fileController.confirmFile");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

//                boolean test = fileController.confirmFile("test.txt");

                if(childTypeCheck == 2) {
                    if(!fileController.confirmFile(userNHDto.getName() + userNHDto.getAge() + "정서검사결과지.xlsx")) {
                        fileController.downloadFileByFileName(userNHDto.getName() + userNHDto.getAge() + "정서검사결과지.xlsx");
                    }
                }
                else if(childTypeCheck == 1) {
                    if(!fileController.confirmFile(userCIDto.getName() + userCIDto.getAge() + "정서검사결과지.xlsx")) {
                        fileController.downloadFileByFileName(userCIDto.getName() + userCIDto.getAge() + "정서검사결과지.xlsx");
                    }
                }
            }
        },0,100);

    }

}
