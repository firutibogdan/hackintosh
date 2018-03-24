package com.hackintosh.foodwaste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class Product extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    ImageView imageView;
    EditText editText;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);

        textView = findViewById(R.id.Name);
        imageView = findViewById(R.id.productImage);
        editText = findViewById(R.id.quantity);

        Intent i = getIntent();
        index = i.getIntExtra("index", 0);

        textView.setText(ImageAdapter.products[index]);
        textView.setTextSize(40);
        imageView.setImageResource(ImageAdapter.mThumbIds[index]);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.OK:
                //TODO: Add product to your list
                try {
                    String q = editText.getText().toString();
                    q = q.replace(',', '.');
                    double quantitiy = Double.parseDouble(q);
                    Intent intent = new Intent(this, choose.class);
                    startActivity(intent);
                    break;
                } catch (NumberFormatException e) {
                    Toast.makeText(Product.this, "Incorrect quantity!", Toast.LENGTH_SHORT).show();
                }
        }
    }

}
