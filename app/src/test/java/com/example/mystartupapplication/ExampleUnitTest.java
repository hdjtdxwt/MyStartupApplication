package com.example.mystartupapplication;

import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Log;

import com.example.mystartupapplication.startup.Startup;
import com.example.mystartupapplication.startup.TopologySort;
import com.example.mystartupapplication.tasks.Task1;
import com.example.mystartupapplication.tasks.Task2;
import com.example.mystartupapplication.tasks.Task3;
import com.example.mystartupapplication.tasks.Task4;
import com.example.mystartupapplication.tasks.Task5;

import java.util.ArrayList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

        List<Startup> list = new ArrayList<>();
        list.add(new Task5());
        list.add(new Task3());
        list.add(new Task1());
        list.add(new Task2());
        list.add(new Task4());
        System.out.println("list.size="+list.size());
        List<Startup>result = TopologySort.getInstnace().sort(list);
        System.out.println("result.size="+result.size());
        if(result!=null){
            for(Startup startup:result){
                System.out.println( startup.getClass().getName());
            }
        }else{
            System.out.println("null");
        }
    }
}