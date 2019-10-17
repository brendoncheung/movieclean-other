package com.alephreach.domain.repository;

import com.alephreach.domain.model.Movie;

import java.util.List;

import io.reactivex.Observable;

public interface MovieRepository {

    Observable<List<Movie>> getPopularMovies();
}
