package com.seip.android.mycovidjason.repos;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.seip.android.mycovidjason.adapters.CovidBindingAdapter;
import com.seip.android.mycovidjason.models.CovidModel;
import com.seip.android.mycovidjason.network.RetrofitService;

import java.nio.channels.MulticastChannel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidModelRepository {

    public LiveData<CovidModel>getAllCovidInformationFromRepos(String endUrl){
        final MutableLiveData<CovidModel>covidModelMutableLiveData=new MutableLiveData<>();
        //CovidBindingAdapter.setFlag(null,endUrl);
        RetrofitService.getAllCovidInformation().getAllCvoid(endUrl).enqueue(new Callback<CovidModel>() {
            @Override
            public void onResponse(Call<CovidModel> call, Response<CovidModel> response) {
                if (response.code()==200){
                    final CovidModel covidModel=response.body();
                    covidModelMutableLiveData.postValue(covidModel);
                }
            }
            @Override
            public void onFailure(Call<CovidModel> call, Throwable t) {

            }
        });
        return covidModelMutableLiveData;
    }
}
