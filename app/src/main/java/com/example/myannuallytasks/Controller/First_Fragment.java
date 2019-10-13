package com.example.myannuallytasks.Controller;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myannuallytasks.Controller.Log_in_Activity;
import com.example.myannuallytasks.Controller.Sign_up_Fragment;
import com.example.myannuallytasks.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class First_Fragment extends Fragment {
                               /////////////////////////Initial Section/////
    private TextView mTextView;
    private Button mbuttonYes;
    private Button mbuttonNo;
    private Button mbuttonExit;
////////////////////////////////////////////////////////////////////////////
    public First_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);

    mbuttonYes=view.findViewById(R.id.id_Button_Yes);
    mbuttonNo=view.findViewById(R.id.id_Button_No);
    mbuttonExit=view.findViewById(R.id.id_Button_Exit);

        mbuttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent((AppCompatActivity)getActivity(), Log_in_Activity.class);
                startActivity(intent);

                /*
                Fragment fragment = new Log_in_Fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_First, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/
            }
        });

        mbuttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new Sign_up_Fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container_First, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        mbuttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.exit(0);

            }
        });

        return view;

    }

}
