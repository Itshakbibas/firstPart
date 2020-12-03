package com.example.firstpart.model;

import android.location.Location;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import android.location.Location;

import com.example.firstpart.model.InterfaceTravel;


//@Entity
public class Travel implements InterfaceTravel {

    @NonNull
    //@PrimaryKey
    private String travelId;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    private String pickupReturn;
    private String destination;
    private int travellersNumbers;
    private Date departure;
    private Date back;
    private HashMap<Integer, Boolean> hashMap;

    //@TypeConverters(UserLocationConverter.class)
    //private UserLocation travelLocation;

    //@TypeConverters(RequestType.class)
    private RequestType requestType;

    // @TypeConverters(DateConverter.class)
    private Date travelDate;

    //@TypeConverters(DateConverter.class)
    private Date arrivalDate;


    private HashMap<String, Boolean> company;

    public void setTravelId(String travelId) {
        this.travelId = travelId;
    }

    public String getTravelId() {
        return travelId;
    }

    public void setclientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setclientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getclientPhone() {
        return clientPhone;
    }

    public void setclientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getclientEmail() {
        return clientEmail;
    }

    public void setPickupReturn(String PickupReturn) {
        this.pickupReturn = PickupReturn;
    }

    public String getPickupReturn() {
        return pickupReturn;
    }

    public void setdestination(String destination) {
        this.destination = destination;
    }

    public String getdestination() {
        return destination;
    }

    public void settravellersNumbers(int travellersNumbers) {
        this.travellersNumbers = travellersNumbers;
    }

    public int gettravellersNumbers() {
        return travellersNumbers;
    }

    public void setdeparture(Date departure) {
        this.departure = departure;
    }

    public Date getdeparture() {
        return departure;
    }

    public void setback(Date back) {
        this.back = back;
    }

    public Date getback() {
        return back;
    }

    public void sethashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    public HashMap gethashMap() {
        return hashMap;
    }


    public Travel(Travel travel) {
        travelId = travel.getTravelId();
        clientName = travel.getClientName();
        clientPhone = travel.getclientPhone();
        clientEmail = travel.getClientName();
        pickupReturn = travel.getPickupReturn();
        destination = travel.getdestination();
        travellersNumbers = travel.gettravellersNumbers();
        departure = travel.getdeparture();
        back = travel.getback();

    }

    public Travel() {
        travelId = "";
        clientName = "";
        clientPhone = "";
        clientEmail = "";
        pickupReturn = "";
        destination = "";
        travellersNumbers = 0;
        //departure=00/00/0000;
        //back=;
        //hashMap="";
    }

    @Override
    public void Insert(com.example.firstpart.model.Travel... travels) {

    }

    @Override
    public MutableLiveData<Boolean> isSuccess() {
        return null;
    }




    public static class DateConverter {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        // @TypeConverter
        public Date fromTimestamp(String date) throws ParseException {
            return (date == null ? null : format.parse(date));
        }

        //@TypeConverter
        public String dateToTimestamp(Date date) {
            return date == null ? null : format.format(date);
        }
    }


    public enum RequestType {
        sent(0), accepted(1), run(2), close(3);
        private final Integer code;

        RequestType(Integer value) {
            this.code = value;
        }

        public Integer getCode() {
            return code;
        }

        // @TypeConverter
        public static RequestType getType(Integer numeral) {
            for (RequestType ds : values())
                if (ds.code.equals(numeral))
                    return ds;
            return null;
        }

        //@TypeConverter
        public static Integer getTypeInt(RequestType requestType) {
            if (requestType != null)
                return requestType.code;
            return null;
        }
    }

}


