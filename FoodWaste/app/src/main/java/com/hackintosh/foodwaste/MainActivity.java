package com.hackintosh.foodwaste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

    }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.getLocation:
                    Intent intent = new Intent(this, choose.class);
                    startActivity(intent);
                    break;


                case R.id.end_ride:
                    //TODO send data
//                    Intent i = new Intent(this, Graph.class);
//                    startActivity(i);
                    break;
            }
        }
}
