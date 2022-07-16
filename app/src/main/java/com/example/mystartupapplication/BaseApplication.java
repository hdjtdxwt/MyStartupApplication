package com.example.mystartupapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.mystartupapplication.startup.Startup;
import com.example.mystartupapplication.startup.TopologySort;
import com.example.mystartupapplication.tasks.Task1;
import com.example.mystartupapplication.tasks.Task2;
import com.example.mystartupapplication.tasks.Task3;
import com.example.mystartupapplication.tasks.Task4;
import com.example.mystartupapplication.tasks.Task5;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class BaseApplication extends Application {
    String TAG = "BaseApplication";
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    /**
     * 拓扑排序，找出合适的遍历顺序
     */
    @Override
    public void onCreate() {
        super.onCreate();
        List<Startup> list = new ArrayList();
        list.add(new Task5());
        list.add(new Task3());
        list.add(new Task1());
        list.add(new Task2());
        list.add(new Task4());

        List<Startup>resultList = TopologySort.getInstnace().sort(list);
        if(resultList!=null){
            for(Startup startup:resultList){
                Log.e(TAG, startup.getClass().getName());
            }
        }else{
            Log.e(TAG, "null");
        }
    }
}
