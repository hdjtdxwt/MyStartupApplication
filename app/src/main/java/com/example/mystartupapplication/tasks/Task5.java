package com.example.mystartupapplication.tasks;

import android.content.Context;
import android.util.Log;

import com.example.mystartupapplication.startup.AndroidStartup;

import java.util.ArrayList;

public class Task5 extends AndroidStartup<Void> {
    String TAG = "Task5";

    public Task5(){
        depends = new ArrayList<>();
        depends.add(Task3.class);
        depends.add(Task4.class);
    }

    @Override
    public Void create(Context context) {
        Log.e(TAG,"Task5  create--start");


        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
        Log.e(TAG,"Task5  create--end");
        return null;
    }
}
