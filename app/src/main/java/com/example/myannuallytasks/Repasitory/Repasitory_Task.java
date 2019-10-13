package com.example.myannuallytasks.Repasitory;

import com.example.myannuallytasks.Controller.State;
import com.example.myannuallytasks.model.Person;
import com.example.myannuallytasks.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Repasitory_Task {
    private static final Repasitory_Task instance = new Repasitory_Task();
     List<Task> mTasksToDo=new ArrayList<>();
     List<Task> mTasksDone=new ArrayList<>();
     List<Task> mTasksDoing=new ArrayList<>();


    public static Repasitory_Task getInstance() {
        return instance;
    }
//////////////////////////////////////////////////////////////////////////////////////////////
    //read
public void setToDoTasks(/*UUID taskId, State state*/ Task task) {
        if(task.getmState().equals(State.TODO))
            for (Task t: mTasksToDo){
                if (t.getId().equals(task.getId()))
                    return;
            }
        mTasksToDo.add(task);
    }


    public   List<Task>  getmTasksToDo(){
        return  mTasksToDo;
    }
////////////////////////////////
public void setDoingTasks(/*UUID taskId, State state*/ Task task) {
    if(task.getmState().equals(State.DOING))
        for (Task t: mTasksDoing){
            if (t.getId().equals(task.getId()))
                return;
        }
    mTasksDoing.add(task);
}


    public   List<Task>  getmTasksDoing(){
        return  mTasksDoing;
    }
    ///////////////////////////////////////////////
    public void setDoneTasks(/*UUID taskId, State state*/ Task task) {
        if(task.getmState().equals(State.DONE))
            for (Task t: mTasksDone){
                if (t.getId().equals(task.getId()))
                    return;
            }
        mTasksDone.add(task);
    }


    public   List<Task>  getmTasksDone(){
        return  mTasksDone;
    }
////////////////////////////////////////////////////////


    private Repasitory_Task() {


    }

/////////////////////////////////////////////////////////////////////////////
    //read
    public Task getTask(UUID id) {
        for (Task Task : mTasksToDo) {
            if (Task.getId().equals(id))
                return Task;
        }
        for (Task Task : mTasksDoing) {
            if (Task.getId().equals(id))
                return Task;
        }
        for (Task Task : mTasksDone) {
            if (Task.getId().equals(id))
                return Task;
        }
        return null;}

////////////////////////////////////////
    //insert
    public void insertTask(Task task) {
        if(task.getmState().equals(State.TODO))
        mTasksToDo.add(task);

        else if(task.getmState().equals(State.DONE))
            mTasksDone.add(task);

        else if(task.getmState().equals(State.DOING))
            mTasksDoing.add(task);
    }

    //delete
    public void deleteTask(Task task) {
        if (task != null  && task.getmState().equals(State.TODO))
            mTasksToDo.remove(task);

      else  if (task != null  && task.getmState().equals(State.DONE))
            mTasksDone.remove(task);


       else if (task != null  && task.getmState().equals(State.DOING))
            mTasksDoing.remove(task);
    }

    //delete
    public void deleteTask(UUID id) {
        deleteTask(getTask(id));
    }





}
