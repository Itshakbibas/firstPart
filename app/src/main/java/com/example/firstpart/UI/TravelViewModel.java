package com.example.firstpart.UI;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.firstpart.Repository.TravelRepository;

import com.example.firstpart.model.TravelDataSource;
import com.example.firstpart.model.Travel;
import com.example.firstpart.model.InterfaceTravel;



public class TravelViewModel extends ViewModel {
    String TAG="itshak";
    TravelRepository rp;

    public TravelViewModel(@NonNull Application application){

    }

    public void addTravel(Travel travel){rp.add(travel);}


    public  MutableLiveData<Boolean> isSuccess()
    {
        return rp.isSuccess();
    }






}
