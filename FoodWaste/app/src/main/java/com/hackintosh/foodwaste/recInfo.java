package com.hackintosh.foodwaste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class recInfo extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    TextView textView;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe);

        textView = findViewById(R.id.textVieww);
        imageView = findViewById(R.id.imageVieww);

        Intent i = getIntent();
        index = i.getIntExtra("index", 0);

        textView.setText(ImageAdapter2.productsr[index]);
        textView.setTextSize(20);
        imageView.setImageResource(ImageAdapter2.mThumbIdsr[index]);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.end_rride:
                    finish();
                    break;
        }
    }

}
