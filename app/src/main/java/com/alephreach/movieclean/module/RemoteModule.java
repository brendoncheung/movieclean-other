package com.alephreach.movieclean.module;

import com.alephreach.movieclean.BuildConfig;
import com.alephreach.remote.service.MovieApiService;
import com.alephreach.remote.service.MovieServiceFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class RemoteModule {

    @Provides
    MovieServiceFactory provideMovieServiceFactory() {
        return new MovieServiceFactory();
    }

    @Provides
    MovieApiService provideMovieApiService(MovieServiceFactory factory) {
        return factory.getMovieApiService(BuildConfig.DEBUG);
    }




}
