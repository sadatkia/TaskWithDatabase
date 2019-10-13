package com.example.myannuallytasks.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.myannuallytasks.Controller.Sign_up_Fragment;
import com.example.myannuallytasks.R;

import java.util.UUID;

public class Sign_up_Activity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);

        FragmentManager fragmentManager = getSupportFragmentManager();//      هر جا که قراره اد شود بزارید ولی معمولا همین جاست
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container_SingUp);

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container_SingUp, new Sign_up_Fragment())/////id container ,,,,,object Fragment
                .commit();

    }


}
