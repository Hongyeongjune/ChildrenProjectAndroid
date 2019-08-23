package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.myapplication.controller.UserController;
import com.example.user.myapplication.model.dto.UserNHDto;

import static com.example.user.myapplication.ChildTypeActivity.childTypeCheck;

public class LoginNHActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private Button button;

    public static UserNHDto userNHDto;
    private UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_nh);

//        final EditText editText1 = (EditText) findViewById(R.id.LoginNHEditName);
//        final EditText editText2 = (EditText) findViewById(R.id.LoginNHEditAge);
//        final EditText editText3 = (EditText) findViewById(R.id.LoginNHEditSex);

         editText1 = (EditText) findViewById(R.id.LoginNHEditName);
         editText2 = (EditText) findViewById(R.id.LoginNHEditAge);
         editText3 = (EditText) findViewById(R.id.LoginNHEditSex);

//        Button button = (Button) findViewById(R.id.LoginNHButton);
        button = (Button) findViewById(R.id.LoginNHButton);

        userController = new UserController(getApplicationContext());

        childTypeCheck = 2;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userNHDto = new UserNHDto(editText1.getText().toString(), editText2.getText().toString(), editText3.getText().toString());

//                userController.signupUser(userNHDto);

                Intent intent = new Intent(getApplicationContext(), VoiceTypeActivity.class);
                startActivity(intent);

            }
        });
    }
}
