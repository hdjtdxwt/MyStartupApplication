package com.example.mystartupapplication.tasks;

import android.content.Context;
import android.util.Log;

import com.example.mystartupapplication.startup.AndroidStartup;

import java.util.ArrayList;

public class Task4 extends AndroidStartup<Void> {
    String TAG = "Task4";

    public Task4(){
        depends = new ArrayList<>();
        depends.add(Task2.class);
    }

    @Override
    public Void create(Context context) {
        depends = new ArrayList<>();
        Log.e(TAG,"Task3  create--start");


        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        Log.e(TAG,"Task3  create--end");
        return null;
    }
}
