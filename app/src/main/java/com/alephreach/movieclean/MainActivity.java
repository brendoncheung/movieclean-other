package com.alephreach.movieclean;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alephreach.domain.model.Movie;
import com.alephreach.domain.model.PopularMovie;
import com.alephreach.movieclean.injection.DaggerApplicationComponent;
import com.alephreach.remote.service.MovieApiService;
import com.alephreach.remote.service.MovieServiceFactory;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    @Inject
    MovieApiService mMovieApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();

        Observer<PopularMovie> observer = new Observer<PopularMovie>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(PopularMovie movies) {
                for (Movie movie : movies.getPopularMovie()) {
                    Log.d("MainActivty", movie.getTitle());
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        mMovieApiService.getPopularMovie(MovieServiceFactory.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        Log.d("MainActivity", mMovieApiService.toString());
    }

    private <T> void execute(Observer<T> observer, T t) {
        String greeting = "Hello from RxJava";
        Observable<T> mObservable = Observable.just(t);

        mObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    private void initialization() {
        DaggerApplicationComponent.builder().build().inject(this);
    }
}
