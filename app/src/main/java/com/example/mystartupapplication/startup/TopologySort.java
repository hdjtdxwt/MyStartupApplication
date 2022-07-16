package com.example.mystartupapplication.startup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TopologySort {
    private static TopologySort instnace;
    private TopologySort(){

    }

    public static TopologySort getInstnace() {
        if(instnace==null){
            synchronized (TopologySort.class){
                if(instnace==null){
                    instnace = new TopologySort();
                }
            }
        }
        return instnace;
    }

    public List<Startup> sort(List<Startup> list){
        if(list==null){
            return null;
        }
        ConcurrentHashMap<Class<? extends Startup>,Integer> map = new ConcurrentHashMap<>();
        List<Startup>result = new ArrayList<>();

        for(Startup startup: list){
            map.put(startup.getClass(), startup.getDependenciesCount());
        }
        Iterator<Class<? extends Startup>> iterable = map.keySet().iterator();
        while(iterable.hasNext()){
            Class startup = iterable.next();
            if(map.get(startup).intValue()==0) {
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).getClass() == startup){
                        result.add(list.get(i));
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    List<Startup>depends = list.get(i).dependencies();
                    if (depends!=null && depends.contains(startup)) {
                        int count = map.get(list.get(i).getClass());
                        --count ;
                        map.replace(list.get(i).getClass(), count);
                    }
                }
                map.remove(startup);
                iterable = map.keySet().iterator();
            }
        }
        return result;
    }

}
