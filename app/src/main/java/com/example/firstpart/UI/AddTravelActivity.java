package com.example.firstpart.UI;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstpart.R;
import androidx.lifecycle.ViewModelProvider;
import com.example.firstpart.model.TravelDataSource;
import com.example.firstpart.model.Travel;
import com.example.firstpart.model.InterfaceTravel;
import com.example.firstpart.Repository.TravelRepository;
import com.example.firstpart.model.TravelDataSource;
import com.example.firstpart.UI.TravelViewModel;

import java.util.Date;


public class AddTravelActivity extends MainActivity implements View.OnClickListener
{
    private TravelViewModel travelViewModel;
    private EditText travelId;
    private EditText  clientName;
    private EditText  clientPhone;
    private EditText  clientEmail;
    private EditText destination;
    private EditText travellersNumbers;
    private DatePicker departureDate;
    private DatePicker  returneDate;

    private Button addTravelButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.addtravelactivity_main);
        addTravelButton=(Button) findViewById(R.id.confirmButton);
        addTravelButton.setOnClickListener(new View.OnClickListener() {
           @Override
          public void onClick(View v)
           {
          setContentView(R.layout.first_activity_main);
          try
            {
             findViews();
            checkEmptyFields();
            Travel travel=getClient();
            travelViewModel.addTravel(travel);
          }
          catch (Exception e)
          {
              Toast.makeText(AddTravelActivity.this, "you have to fill the all fields", Toast.LENGTH_LONG).show();
          }
         }
         });
        travelViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(TravelViewModel.class);
        travelViewModel.isSuccess().observe(this,new Observer<Boolean>(){
            @Override
            public void onChanged(Boolean aBoolean) {
                if (new Boolean(String.valueOf(travelViewModel.isSuccess())))
                    Toast.makeText(AddTravelActivity.this, "client inserted with success", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AddTravelActivity.this, "failure !!", Toast.LENGTH_LONG).show();
            }
        });
    }


    private void findViews()
    {
        travelId = (EditText) findViewById(R.id.travelId);
        clientName = (EditText) findViewById(R.id.clientName);
        clientPhone = (EditText) findViewById(R.id.phoneNumber);
        clientEmail = (EditText) findViewById(R.id.clientEmail);
        destination =(EditText) findViewById(R.id.destination);
        travellersNumbers=(EditText)findViewById(R.id.travellersNumbers);
    }


   // travelViewModel  =   ViewModelProvider(this).get(TravelViewModel.class);




    public Travel getClient()
    {
       Travel travel=new Travel();
       getDates(travel);
       travel.setTravelId(travelId.getText().toString());
       travel.setclientName(clientName.getText().toString());
       travel.setclientPhone(clientPhone.getText().toString());
       travel.setclientEmail(clientEmail.getText().toString());
       travel.setdestination(destination.getText().toString());
       int number= Integer.valueOf(travellersNumbers.getText().toString());
       travel.settravellersNumbers(number);
       travel.setclientEmail(clientEmail.getText().toString());
       return travel;
    }



    public boolean checkEmptyFields()
    {
        if (TextUtils.isEmpty(travelId.getText().toString().trim())||TextUtils.isEmpty(clientName.getText().toString().trim())||
                TextUtils.isEmpty(clientPhone.getText().toString().trim())||TextUtils.isEmpty(clientEmail.getText().toString().trim()))
            return false;
        else
            return true;
    }








    public void getDates(Travel travel)
    {
        final CalendarView departureDate = (CalendarView) findViewById(R.id.departureDate);
        final CalendarView returneDate = (CalendarView) findViewById(R.id.returnDate);
        departureDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                travel.setdeparture(new Date(i, i1, 12));
            }
        });
        returneDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                travel.setback(new Date(i, i1, i2));
            }
        });

    }
}












