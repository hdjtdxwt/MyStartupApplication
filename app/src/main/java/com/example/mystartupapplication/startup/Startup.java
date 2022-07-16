package com.example.mystartupapplication.startup;

import android.content.Context;

import java.util.List;

public interface Startup<T> {
    T create(Context context);

    List<Class<? extends Startup<?>>> dependencies();

    int getDependenciesCount();
}
