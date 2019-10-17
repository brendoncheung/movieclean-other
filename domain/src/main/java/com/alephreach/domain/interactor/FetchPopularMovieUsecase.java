package com.alephreach.domain.interactor;

import com.alephreach.domain.model.Movie;
import com.alephreach.domain.repository.MovieRepository;

import java.util.List;

import io.reactivex.Observable;

public class FetchPopularMovieUsecase<T> {

    private final MovieRepository mMovieRepository;

    public FetchPopularMovieUsecase(MovieRepository repository) {
        mMovieRepository = repository;
    }

    public Observable<List<Movie>> getPopularMovies(){
        return mMovieRepository.getPopularMovies();
    }
}
