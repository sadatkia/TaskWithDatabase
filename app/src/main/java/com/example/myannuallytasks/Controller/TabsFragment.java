package com.example.myannuallytasks.Controller;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myannuallytasks.R;
import com.example.myannuallytasks.Repasitory.Repasitory_Task;
import com.example.myannuallytasks.model.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabsFragment extends Fragment {

    public static final int REQUEST_CODE1 = 1;
    public static final String ARG_STATE = "arg state";
    private ImageView mBackground;
    private FloatingActionButton mFloatingAction;

    private RecyclerView mRecyclerView;
    private TaskAdapter mTaskAdapter ;
    private RecyclerView.LayoutManager mLayoutManager;


    private List<Task> mTasks;


    public TabsFragment() {
        // Required empty public constructor
    }

    public static TabsFragment newInstance(State state) {
     TabsFragment fragment = new TabsFragment();
        Bundle args = new Bundle();
        String StateString =state.toString();

        args.putString(ARG_STATE,StateString);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tabs, container, false);
        mTaskAdapter = new TaskAdapter(mTasks);
        //mBackground = view.findViewById(R.id.id_imageView_RecycelerView);
        mFloatingAction=view.findViewById(R.id.id_floating_add);
        mRecyclerView=view.findViewById(R.id.id_recyclerview);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        if(getArguments().getString(ARG_STATE)=="DOING")
           mTasks= Repasitory_Task.getInstance().getmTasksDoing();
        else if(getArguments().getString(ARG_STATE)=="DONE")
            mTasks= Repasitory_Task.getInstance().getmTasksDone();
        else if(getArguments().getString(ARG_STATE)=="TODO")
            mTasks= Repasitory_Task.getInstance().getmTasksToDo();




        updateUI();


        mFloatingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                getActivity().getSupportFragmentManager();
                AddDialogFragment fragment=new AddDialogFragment();
                fragment.setTargetFragment(TabsFragment.this, 2);/////////////اضافه کرد مهسسسسسسااااااااااااااااااااااا

                fragment.show(getFragmentManager(), " My Add ");
                updateUI();
            }
        });

        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.taskmenu, menu);

        MenuItem subtitleItem = menu.findItem(R.id.id_LogOff);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_LogOff:
                Intent intent =new Intent(getActivity(), First_Activity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void updateUI() {


            mRecyclerView.setAdapter(mTaskAdapter);
            mTaskAdapter.setTasks(mTasks);
            mTaskAdapter.notifyDataSetChanged();



    }
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
        mTaskAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        updateUI();
    }

    @Override
    public void onStop() {
        super.onStop();
        updateUI();
    }

    @Override
    public void onPause() {
        super.onPause();
        updateUI();
    }


    private class TaskHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewTitle;
        // private TextView mTextViewDate;
        private ImageView mImageViewTask;

        private Task mTask;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.id_textView_RecycelerView);
            // mTextViewDate = itemView.findViewById(R.id.txtview_list_item_date);
            mImageViewTask = itemView.findViewById(R.id.id_imageView_RecycelerView);

           itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().getSupportFragmentManager();
                    AddDialogFragment fragment=new AddDialogFragment();
                    fragment.setTargetFragment(TabsFragment.this, 2);/////////////اضافه کرد مهسسسسسسااااااااااااااااااااااا


                    fragment.show(getFragmentManager(), " My Add ");
                    updateUI();


                }
            });
        }

        public void bind(Task Task) {
            mTask = Task;
            mTextViewTitle.setText(Task.getmTitle());
            mImageViewTask.setVisibility( View.VISIBLE);

            //mTextViewDate.setText(Task.getDate().toString());
            // mImageViewTask.setVisibility();
        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {

        public static final String TAG = "TaskAdapter";


        public TaskAdapter(List<Task> Tasks) {
            mTasks = Tasks;
        }

        public void setTasks(List<Task> Tasks) {
            mTasks = Tasks;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d(TAG, "onCreateViewHolder");
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.item_layout_recycelerview, parent, false);
            return new TaskHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder");
            holder.bind(mTasks.get(position));
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }



}
