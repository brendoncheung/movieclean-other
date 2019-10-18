package com.alephreach.data.repository;

import com.alephreach.domain.model.Movie;
import com.alephreach.domain.model.PopularMovie;

import java.util.List;

import io.reactivex.Observable;

public interface MovieRemote {

    Observable<PopularMovie> getPopularMovies();

}
