package com.example.firstpart.UI;



//import com.example.Repository.R;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firstpart.R;
public class MainActivity extends AppCompatActivity  implements View.OnClickListener  {

    Button principalButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity_main);
        principalButton= (Button) findViewById(R.id.principalButton);
        principalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "client inserted with success", Toast.LENGTH_LONG).show();
                setContentView(R.layout.addtravelactivity_main);
            }
        });
    }
    @Override
    public void onClick(View v) {


    }
}
