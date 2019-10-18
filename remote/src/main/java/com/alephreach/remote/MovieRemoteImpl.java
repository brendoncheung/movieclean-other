package com.alephreach.remote;

import com.alephreach.data.repository.MovieRemote;
import com.alephreach.domain.model.Movie;
import com.alephreach.domain.model.PopularMovie;
import com.alephreach.remote.service.MovieApiService;
import com.alephreach.remote.service.MovieServiceFactory;

import java.util.List;

import io.reactivex.Observable;

public class MovieRemoteImpl implements MovieRemote {

    private final MovieApiService mMovieApiService;

    public MovieRemoteImpl(MovieApiService service) {
        mMovieApiService = service;
    }

    @Override
    public Observable<PopularMovie> getPopularMovies() {
        return mMovieApiService.getPopularMovie(MovieServiceFactory.API_KEY);
    }


}
