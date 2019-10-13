package com.example.myannuallytasks.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.myannuallytasks.Controller.First_Fragment;
import com.example.myannuallytasks.R;

public class First_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_);



        FragmentManager fragmentManager = getSupportFragmentManager();//      هر جا که قراره اد شود بزارید ولی معمولا همین جاست
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container_First);

        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container_First, new First_Fragment())/////id container ,,,,,object Fragment
                .commit();


    }
}
