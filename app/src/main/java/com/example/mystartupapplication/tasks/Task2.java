package com.example.mystartupapplication.tasks;

import android.content.Context;
import android.util.Log;

import com.example.mystartupapplication.startup.AndroidStartup;
import com.example.mystartupapplication.startup.Startup;

import java.util.ArrayList;
import java.util.List;

public class Task2 extends AndroidStartup<Void> {
    String TAG = "Task2";

    public Task2(){
        depends = new ArrayList<>();
        depends.add(Task1.class);
    }

    @Override
    public Void create(Context context) {
        depends = new ArrayList<>();
        Log.e(TAG,"Task2  create--start");


        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
        Log.e(TAG,"Task2  create--end");
        return null;
    }
}
