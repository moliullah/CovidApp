package com.seip.android.mycovidjason;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seip.android.mycovidjason.databinding.FragmentHomeBinding;
import com.seip.android.mycovidjason.models.CovidModel;
import com.seip.android.mycovidjason.viewmodels.CovidViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeFragment extends Fragment {
    private String TAG=HomeFragment.class.getSimpleName();
    private FragmentHomeBinding binding;
    private CovidViewModel covidViewModel;
    //private String countryName="bangladesh";
    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(inflater);

        covidViewModel=new ViewModelProvider(requireActivity()).get(CovidViewModel.class);
        //final String endUrl = String.format("covid-19/countries/%s", countryName);

        binding.checkCountryId.setOnClickListener(v->{

            final String name=binding.countryNameId.getText().toString();
            final String endUrl = String.format("countries/%s?yesterday=true&strict=true&query",name);
            binding.setCountryTv.setText(name);


            covidViewModel.getAllDatafromViews(endUrl).observe(getViewLifecycleOwner(), covidModel -> {
                //Toast.makeText(getContext(), ""+covidModel.getCountry(), Toast.LENGTH_SHORT).show();
                bind(covidModel);
                binding.updateDateId.setText(new SimpleDateFormat("MMM dd, yyyy")
                        .format(new Date(covidModel.getUpdated())));
            });
        });


        return binding.getRoot();
    }
    private void bind(CovidModel covidModel) {
        binding.setCovidModel(covidModel);
    }
}