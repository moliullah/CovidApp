package com.seip.android.mycovidjason.adapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.seip.android.mycovidjason.R;
import com.squareup.picasso.Picasso;

public class CovidBindingAdapter {
    @BindingAdapter(value = "app:setflag")
    public static void setFlag(ImageView imageView, String Url){
       // final String flagUrl="https://corona.lmao.ninja/v2/"+Url;
        Picasso.get().load(Url).placeholder(R.drawable.ic_baseline_pending_24).into(imageView);
    }
}
