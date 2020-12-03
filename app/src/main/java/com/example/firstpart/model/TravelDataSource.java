package com.example.firstpart.model;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class TravelDataSource implements InterfaceTravel
{
    private MutableLiveData<Boolean> isSuccess= new MutableLiveData<>();
    private InterfaceTravel interfaceTravel;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference travels = firebaseDatabase.getReference("ExistingTravels");

    private TravelDataSource() { }





    private static TravelDataSource instance;

    public static TravelDataSource getInstance()
    {
      if (instance == null)
        instance = new TravelDataSource();
      return instance;
    }
    public void addTravel(com.example.firstpart.model.Travel p)
    {
      String  id = travels.push().getKey();
      p.setTravelId(id);
      travels.child(id).setValue(p).addOnSuccessListener(new OnSuccessListener<Void>() {
      @Override
      public void onSuccess(Void aVoid) {
        isSuccess.setValue(true);
      }
      }).addOnFailureListener(new OnFailureListener() {
      @Override
      public void onFailure(@NonNull Exception e) {
        isSuccess.setValue(false);
      }
      });
    }

    public MutableLiveData<Boolean> isSuccess(){
        return isSuccess ;
    }




    @Override
    public void Insert(com.example.firstpart.model.Travel... travels) {
        interfaceTravel.Insert(travels);
    }


}

