package com.hackintosh.foodwaste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ProductInfo extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    ImageView imageView;
    EditText editText;
    int index;

    public static user u;
    public preset pr;

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
                try {
                    String q = editText.getText().toString();
                    q = q.replace(',', '.');
                    double quantitiy = Double.parseDouble(q);

                    File file = new File(getFilesDir(), "fridgetrackerdata");
                    if (file.exists()) {
                        try {
                            FileInputStream fileIn = new FileInputStream(new File(getFilesDir(), "fridgetrackerdata"));
                            ObjectInputStream in = new ObjectInputStream(fileIn);
                            u = (user) in.readObject();
                            in.close();
                            fileIn.close();
                        } catch (IOException i) {
                            i.printStackTrace();
                            return;
                        } catch (ClassNotFoundException c) {
                            System.out.println("Employee class not found");
                            c.printStackTrace();
                            return;
                        }
                    } else {
                        u = new user();
                    }
                    file.delete();

                    File file1 = new File(getFilesDir(), "fridgetrackerdata1");
                    if (file1.exists()) {
                        try {
                            FileInputStream fileIn = new FileInputStream(new File(getFilesDir(), "fridgetrackerdata1"));
                            ObjectInputStream in = new ObjectInputStream(fileIn);
                            pr = (preset) in.readObject();
                            in.close();
                            fileIn.close();
                        } catch (IOException i) {
                            i.printStackTrace();
                            return;
                        } catch (ClassNotFoundException c) {
                            System.out.println("Employee class not found");
                            c.printStackTrace();
                            return;
                        }
                    } else {
                        pr = new preset();
                    }
                    file1.delete();

                    u.addProduct(pr.preProd.get(index), quantitiy);

                    try {
                        FileOutputStream fileOut =
                                new FileOutputStream(new File (getFilesDir(), "fridgetrackerdata"));
                        ObjectOutputStream out = new ObjectOutputStream(fileOut);
                        out.writeObject(u);
                        out.flush();
                        out.close();
                        fileOut.close();
                    } catch (IOException i) {
                         i.printStackTrace();
                    }

                    try {
                        FileOutputStream fileOut1 =
                                new FileOutputStream(new File (getFilesDir(), "fridgetrackerdata1"));
                        ObjectOutputStream out1 = new ObjectOutputStream(fileOut1);
                        out1.writeObject(pr);
                        out1.flush();
                        out1.close();
                        fileOut1.close();
                    } catch (IOException i) {
                        i.printStackTrace();
                    }

                    finish();
                    break;
                } catch (NumberFormatException e) {
                    Toast.makeText(ProductInfo.this, "Incorrect quantity!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
