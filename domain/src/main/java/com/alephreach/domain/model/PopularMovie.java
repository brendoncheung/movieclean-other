package com.alephreach.domain.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularMovie {

    @SerializedName("page")
    private int page;

    public List<Movie> getPopularMovie() {
        return popularMovie;
    }

    @SerializedName("results")
    private List<Movie> popularMovie;
}
