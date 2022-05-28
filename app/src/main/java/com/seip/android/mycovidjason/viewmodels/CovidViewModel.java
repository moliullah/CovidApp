package com.seip.android.mycovidjason.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.seip.android.mycovidjason.models.CovidModel;
import com.seip.android.mycovidjason.repos.CovidModelRepository;

public class CovidViewModel extends ViewModel {
    CovidModelRepository repository;
    public CovidViewModel() {
        repository=new CovidModelRepository();
    }
    public LiveData<CovidModel>getAllDatafromViews(String endUrl){
       // Object endUrl;
        return repository.getAllCovidInformationFromRepos(endUrl);
    }
}
