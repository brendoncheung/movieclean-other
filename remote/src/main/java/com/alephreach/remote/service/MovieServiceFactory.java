package com.alephreach.remote.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class MovieServiceFactory {

    private static String API_KEY = "6fffa22d1ba58423a952b48709479f7d";

    public MovieApiService getMovieApiService(Boolean isDebug) {

        return getMovieApiService(getHttpClient(getLoggingInterceptor(isDebug)));
    }

    private MovieApiService getMovieApiService(OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(MovieApiService.class);

    }

    private OkHttpClient getHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build();
    }

    private HttpLoggingInterceptor getLoggingInterceptor(Boolean isdebug) {

        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        if(isdebug) {
            logger.level(HttpLoggingInterceptor.Level.BODY);
        } else {
            logger.level(HttpLoggingInterceptor.Level.NONE);
        }
        return logger;
    }



}
