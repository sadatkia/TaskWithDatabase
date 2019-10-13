package com.example.myannuallytasks.Controller;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.myannuallytasks.R;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimePickerFragment extends DialogFragment {
    // View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_time_picker, null, false);

    private static final String ARG_TASK_TIME = "taskTime";
    public static final String EXTRA_TASK_Time = "com.example.myannuallytasks.taskTime";

    private DatePicker mDatePicker;
    private Date mDate;
    private TimePicker mTimePicker;

    public TimePickerFragment() {
        // Required empty public constructor
    }


    public static TimePickerFragment newInstance(Date date) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK_TIME, date);


        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    mDate = (Date) getArguments().getSerializable(ARG_TASK_TIME);/////اطلاعات دراه میاد برای date peaker مون خودش رندم با garigory calender بصورت رندم داده یود یهش
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view = layoutInflater
                .inflate(R.layout.fragment_time_picker, null, false);////اینجا نقاشی  دیت پییییکر پیاده سازی شد

        mTimePicker = view.findViewById(R.id.id_time_picker);
        // mDatePicker.init(   نال   و     روز   و   ماه  و  سال)

        //initDTimePicker();
        initTimePicker();



        return new AlertDialog.Builder(getActivity())

                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendResult();
                    }
                })
                .setView(view)
                .create();
    }


    private void sendResult() {


       mDate.setHours(mTimePicker.getCurrentHour());
       mDate.setMinutes(mTimePicker.getCurrentMinute());


        Intent intent = new Intent();
        intent.putExtra(EXTRA_TASK_Time, mDate);

        Fragment fragment = getTargetFragment();
        fragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
    }

    private void initTimePicker() {
        Calendar calendar = Calendar.getInstance();///getInstance نشلنه ی singletone
        calendar.setTime(mDate);

        int hour = calendar.get(Calendar.HOUR);////از اینترنت گزفتیم
        int minute = calendar.get(Calendar.MINUTE);

        mTimePicker.setCurrentHour(hour);
        mTimePicker.setCurrentMinute(minute);

        //int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
       // mTimePicker.init(year, monthOfYear, dayOfMonth, null);
       // sendResult(mTime);
    }



}
