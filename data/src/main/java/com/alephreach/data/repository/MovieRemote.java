package com.alephreach.data.repository;

import com.alephreach.domain.model.Movie;

import java.util.List;

import io.reactivex.Observable;

public interface MovieRemote {

    Observable<List<Movie>> getPopularMovies();

}
