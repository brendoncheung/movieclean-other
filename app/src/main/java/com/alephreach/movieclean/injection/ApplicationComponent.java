package com.alephreach.movieclean.injection;

import com.alephreach.movieclean.MainActivity;
import com.alephreach.movieclean.injection.module.RemoteModule;

import dagger.Component;

@Component(modules = RemoteModule.class)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
