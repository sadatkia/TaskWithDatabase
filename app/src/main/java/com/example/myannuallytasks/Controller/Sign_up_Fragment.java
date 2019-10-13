package com.example.myannuallytasks.Controller;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myannuallytasks.R;
import com.example.myannuallytasks.Repasitory.RepositoryPerson;
import com.example.myannuallytasks.model.Person;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sign_up_Fragment extends Fragment {

    private EditText mEditText_UserName;
    private EditText mEditText_PassWord;
    private Button mButton_Sign_up;

    public static final String YOUR_USER_NAME = "your_task";
    public static final String YOUR_PASS= "your_num";

    public String user = "";
    public int pass;

 ///////////////////////////////////
    public Sign_up_Fragment() {
        // Required empty public constructor
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static Sign_up_Fragment newInstance() {

        Bundle args = new Bundle();

        Sign_up_Fragment fragment = new Sign_up_Fragment();
        fragment.setArguments(args);
        return fragment;
    }
    ///////////////////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

     // Sign_up_Fragment.this.setTitle("Sign up");
        View view=inflater.inflate(R.layout.fragment_sign_up_, container, false);

        mEditText_UserName=view.findViewById(R.id.id_UserNameSignUp);
        mEditText_PassWord=view.findViewById(R.id.id_PasWord);
        mButton_Sign_up=view.findViewById(R.id.id_button_SignUp);

       /////////////////////////////////////////////////
        mEditText_UserName.getText().toString();
      mEditText_PassWord.getText().toString();

        ///////////////////////////////////////////
        mButton_Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
   /*             String user=mEditText_UserName.getText().toString();
                int value=Integer.valueOf( mEditText_PassWord.getText().toString());*/
                if (!(mEditText_UserName.getText().toString().equals("")) && !(mEditText_PassWord.getText().toString().equals(""))) {
                    RepositoryPerson.getInstance().insert(new Person(mEditText_UserName.getText().toString(), mEditText_PassWord.getText().toString()));
                }
              Intent intent = new Intent(getActivity(), Log_in_Activity.class);
                int number = Integer.parseInt(mEditText_PassWord.getText().toString());
                intent.putExtra(YOUR_USER_NAME ,  mEditText_UserName.getText().toString());
                intent.putExtra(YOUR_PASS , number);
                startActivity(intent);






               /*
                Intent intent = new Intent();
                intent.putExtra("user", user);
               intent.putExtra("pass",value);
                startActivity(intent);
               *//* setResult(Activity.RESULT_OK, intent);
                finish();*//*
*/

            }
        });

        return view;




    }

}
