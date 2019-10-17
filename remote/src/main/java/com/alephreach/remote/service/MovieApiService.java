package com.alephreach.remote.service;

import com.alephreach.domain.model.Movie;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MovieApiService {

    @GET("/movie/popular")
    Observable<List<Movie>> getPopularMovie();

}
