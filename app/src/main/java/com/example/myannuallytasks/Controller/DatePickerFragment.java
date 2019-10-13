package com.example.myannuallytasks.Controller;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.myannuallytasks.R;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment {
   // View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_time_picker, null, false);
    private static final String ARG_TASK_DATE = "taskDate";
    private static final String ARG_TASK_TIME = "taskTime";
    public static final String EXTRA_TASK_DATE = "com.example.myannuallytasks.taskDate";

    private DatePicker mDatePicker;
    private Date mDate;

    public static DatePickerFragment newInstance(Date date) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK_DATE, date);


        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public DatePickerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mDate = (Date) getArguments().getSerializable(ARG_TASK_DATE);/////اطلاعات دراه میاد برای date peaker مون خودش رندم با garigory calender بصورت رندم داده یود یهش
            }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view = layoutInflater
                .inflate(R.layout.fragment_date_picker, null, false);////اینجا نقاشی  دیت پییییکر پیاده سازی شد

        mDatePicker = view.findViewById(R.id.id_date_picker);
       // mDatePicker.init(   نال   و     روز   و   ماه  و  سال)

        initDatePicker();

        return new AlertDialog.Builder(getActivity())

                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendResult();

                       ///ز اینترنت چگونگی گرفتن تاریخ را از DatePicker گرفتیم
                        ///تابه پایین نوشته شده اینجا صداش کردیم
                      /*  AddDialogFragment addDialogFragment= (AddDialogFragment) getTargetFragment();
                        addDialogFragment.updatTaskDate(mDate);*/
                      ///////با دو حط بالا date picher وابسته شد به AddDialogFragment
                        //////پس برای ReUseble باید بصورت کلی تعریف شود و اطلاعات بفرستد

                       // Toast.makeText(getActivity(), date.toSting,Toast.LENGTH_SHORT).show();
                    }
                })
                .setView(view)
                .create();
    }

    private void sendResult() {
        int year = mDatePicker.getYear();
        int monthOfYear = mDatePicker.getMonth();
        int dayOfMonth = mDatePicker.getDayOfMonth();

        GregorianCalendar calendar = new GregorianCalendar(year, monthOfYear, dayOfMonth);
        Date date = calendar.getTime();

        Intent intent = new Intent();
        intent.putExtra(EXTRA_TASK_DATE, date);


        Fragment fragment = getTargetFragment();
        fragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
    }

    private void initDatePicker() {
        Calendar calendar = Calendar.getInstance();///getInstance نشلنه ی singletone
        calendar.setTime(mDate);

        int year = calendar.get(Calendar.YEAR);////از اینترنت گزفتیم
        int monthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        mDatePicker.init(year, monthOfYear, dayOfMonth, null);
    }

}
