package com.hackintosh.foodwaste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductInfo extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    ImageView imageView;
    EditText editText;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productinfo);

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

                    finish();
                    break;
                } catch (NumberFormatException e) {
                    Toast.makeText(ProductInfo.this, "Incorrect quantity!", Toast.LENGTH_SHORT).show();
                }
        }
    }

}
