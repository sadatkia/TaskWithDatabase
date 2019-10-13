package com.example.myannuallytasks.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.myannuallytasks.Controller.Log_in_Fragment;
import com.example.myannuallytasks.R;

import static com.example.myannuallytasks.Controller.Sign_up_Fragment.YOUR_PASS;
import static com.example.myannuallytasks.Controller.Sign_up_Fragment.YOUR_USER_NAME;

public class Log_in_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        FragmentManager fragmentManager = getSupportFragmentManager();//      هر جا که قراره اد شود بزارید ولی معمولا همین جاست
        //Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container_Login);

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container_Login, createFragment())////id container ,,,,,object Fragment
                .commit();
    }
    public Fragment createFragment() {
       int  MyPass = getIntent().getIntExtra(YOUR_PASS, 0);
       String  MyUser = getIntent().getStringExtra(YOUR_USER_NAME);

        return Log_in_Fragment.newInstance(MyUser,MyPass);
    }

    //////////////////////////////////////

}