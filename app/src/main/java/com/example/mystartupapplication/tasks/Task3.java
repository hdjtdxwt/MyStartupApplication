package com.example.mystartupapplication.tasks;

import android.content.Context;
import android.util.Log;

import com.example.mystartupapplication.startup.AndroidStartup;

import java.util.ArrayList;

public class Task3 extends AndroidStartup<Void> {
    String TAG = "Task3";

    public Task3(){
        depends = new ArrayList<>();
        depends.add(Task1.class);
    }

    @Override
    public Void create(Context context) {
        Log.e(TAG,"Task3  create--start");


        try{
            Thread.sleep(1200);
        }catch(Exception e){
            e.printStackTrace();
        }
        Log.e(TAG,"Task3  create--end");
        return null;
    }
}
