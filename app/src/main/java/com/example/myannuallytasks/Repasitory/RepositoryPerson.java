package com.example.myannuallytasks.Repasitory;

import com.example.myannuallytasks.model.Person;

import java.util.ArrayList;
import java.util.List;

public class RepositoryPerson {

    //////////////////////////////////////////////////////////////////
    public static final RepositoryPerson instance = new RepositoryPerson();
    private List<Person> mPerson= new ArrayList<>();
    //////////////////////////////////////////////////////////////////
    private RepositoryPerson() {
    }
    //////////////////////////////////////////////////////////////////
    public static RepositoryPerson getInstance() {
        return instance;
    }
    /////////////////////////////////////////////////////////////////
    public void insert(Person person) {
        mPerson.add(person);
    }
/////////////////////////////////////////////////////////////
int result=0 ;
    public int search(String user, String pass) {

        for (int i = 0; i < mPerson.size(); i++) {

            if (user.equals(mPerson.get(i).getmUser()) && (pass.equals(mPerson.get(i).getmPass()))) {
                result = 1;
            } else if (user.equals(mPerson.get(i).getmUser())) {
                result = 2;
            } else if (pass.equals(mPerson.get(i).getmPass())) {
                result = 3;
            }



        }
        return result;
    }

    public Person getPerson(String user, String pass) {
        Person person = null;
        for (int i = 0; i < mPerson.size(); i++) {
            if (user.equals(mPerson.get(i).getmUser()) && (pass.equals(mPerson.get(i).getmPass()))) {
                person = mPerson.get(i);
            }
        }
        return person;
    }


}
