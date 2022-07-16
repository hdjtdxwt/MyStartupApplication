package com.example.mystartupapplication.startup;

import java.util.List;

public abstract class AndroidStartup<T> implements Startup<T> {
    protected List<Class<? extends Startup<?>>> depends;
    @Override
    public List<Class<? extends Startup<?>>> dependencies() {
        return depends;
    }

    @Override
    public int getDependenciesCount() {
        List<Class<? extends Startup<?>>> list = dependencies();
        return list == null ? 0 : list.size();
    }

}
