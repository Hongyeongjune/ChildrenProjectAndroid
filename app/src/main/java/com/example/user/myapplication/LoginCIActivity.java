package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.myapplication.controller.UserController;
import com.example.user.myapplication.model.dto.UserCIDto;
import com.example.user.myapplication.network.RetrofitInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.user.myapplication.ChildTypeActivity.childTypeCheck;

public class LoginCIActivity extends AppCompatActivity {

    private EditText nameEdit, ageEdit, sexEdit, leftStartEdit, rightStartEdit, leftDateEdit, rightDateEdit, leftDeviceEdit, rightDeviceEdit;

    private Button button;

    private UserController userController;

    public static UserCIDto userCIDto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ci);

        nameEdit = (EditText) findViewById(R.id.LoginCIEditName);
        ageEdit = (EditText) findViewById(R.id.LoginCIEditAge);
        sexEdit = (EditText) findViewById(R.id.LoginCIEditSex);
        leftStartEdit = (EditText) findViewById(R.id.LoginCIEditLeftStart);
        rightStartEdit = (EditText) findViewById(R.id.LoginCIEditRightStart);
        leftDateEdit = (EditText) findViewById(R.id.LoginCIEditLeftDate);
        rightDateEdit = (EditText) findViewById(R.id.LoginCIEditRightDate);
        leftDeviceEdit = (EditText) findViewById(R.id.LoginCIEditLeftDevice);
        rightDeviceEdit = (EditText) findViewById(R.id.LoginCIEditRightDevice);

        button = (Button) findViewById(R.id.LoginCIButton);

        userController = new UserController(getApplicationContext());

        childTypeCheck = 1;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userCIDto = new UserCIDto(nameEdit.getText().toString(), ageEdit.getText().toString(), sexEdit.getText().toString(), leftStartEdit.getText().toString(),
                        rightStartEdit.getText().toString(), leftDateEdit.getText().toString(), rightDateEdit.getText().toString(), leftDeviceEdit.getText().toString(), rightDeviceEdit.getText().toString());

//                userController.signupUserCI(userCIDto);

                Intent intent = new Intent(getApplicationContext(), VoiceTypeActivity.class);
                startActivity(intent);

            }
        });

    }
}
