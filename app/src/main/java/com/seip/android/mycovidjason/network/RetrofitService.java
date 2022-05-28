package com.seip.android.mycovidjason.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static CovieModelApi getAllCovidInformation(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://corona.lmao.ninja/v2/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(CovieModelApi.class);
    }
}
