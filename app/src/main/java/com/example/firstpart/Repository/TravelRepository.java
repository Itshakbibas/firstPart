package com.example.firstpart.Repository;


import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.firstpart.model.TravelDataSource;
import com.example.firstpart.model.Travel;
import com.example.firstpart.model.InterfaceTravel;
import com.example.firstpart.UI.AddTravelActivity;


public class TravelRepository extends Application implements InterfaceTravel {
    private InterfaceTravel interfaceTravel;
    private TravelDataSource travelDataSource;
    //private MutableLiveData<Boolean> isSuccess=new MutableLiveData<>();

    public TravelRepository() {

    }

    public void add(final Travel travel) {
        travelDataSource.addTravel(travel);
    }

    @Override
    public void Insert(com.example.firstpart.model.Travel... travels) {
        interfaceTravel.Insert(travels);
    }

    public MutableLiveData<Boolean> isSuccess() {
        return travelDataSource.isSuccess();
    }

}