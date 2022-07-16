package com.example.mystartupapplication.tasks;

import android.content.Context;
import android.util.Log;

import com.example.mystartupapplication.startup.AndroidStartup;
import com.example.mystartupapplication.startup.Startup;

import java.util.ArrayList;
import java.util.List;

public class Task1 extends AndroidStartup<String> {
    String TAG = "Task1";

    public Task1(){
        depends = new ArrayList<>();
    }
    @Override
    public String create(Context context) {

        Log.e(TAG,"Task1  create--start");
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
        Log.e(TAG,"Task1  create--end");
        return "task1";
    }

}
