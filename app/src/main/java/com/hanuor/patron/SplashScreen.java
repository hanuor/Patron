package com.hanuor.patron;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.user.UserService;

/**
 * Created by Shantanu Johri on 18-07-2016.
 */
public class SplashScreen extends AppCompatActivity {

    Button signup;
    EditText name,uname,pass;
    UserService userService;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        userService = App42API.buildUserService();
        signup = (Button) findViewById(R.id.signup);
        uname= (EditText) findViewById(R.id.uname);
        pass = (EditText) findViewById(R.id.pass);
        name = (EditText) findViewById(R.id.name);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog pd = new ProgressDialog(SplashScreen.this);
                pd.show();
                String unamestr = uname.getText().toString();
                String passstr = pass.getText().toString();
                String namestr = name.getText().toString();
                userService.createUser(unamestr, passstr, "xyz@gmail.com", new App42CallBack() {
                    @Override
                    public void onSuccess(Object o) {
                        pd.dismiss();
                    }

                    @Override
                    public void onException(Exception e) {
                        Toast.makeText(SplashScreen.this, "Sorry", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}
