package com.alephreach.domain.repository;

import com.alephreach.domain.model.Movie;
import com.alephreach.domain.model.PopularMovie;

import java.util.List;

import io.reactivex.Observable;

public interface MovieRepository {

    Observable<PopularMovie> getPopularMovies();
}
