package com.seip.android.mycovidjason.network;

import com.seip.android.mycovidjason.models.CovidModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CovieModelApi {

    @GET()
    Call<CovidModel>getAllCvoid(@Url String endUrl);
    @GET("")
    Call<CovidModel>getAllCvoid();
}
