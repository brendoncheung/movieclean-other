package com.alephreach.remote.service;

import com.alephreach.domain.model.Movie;
import com.alephreach.domain.model.PopularMovie;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("/3/movie/popular")
    Observable<PopularMovie> getPopularMovie(@Query("api_key") String key);

}
