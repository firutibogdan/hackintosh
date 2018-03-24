package com.hackintosh.foodwaste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class choose1 extends AppCompatActivity implements View.OnClickListener {

    public user u;
    public preset pr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose1);

        File file = new File("user_storage_197466588299931246658290017389927333");
        if (file.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream("user_storage_197466588299931246658290017389927333");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                u = (user) in.readObject();
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
            u = new user();
            pr = new preset();
        }

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(choose1.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.product:
                Intent intent = new Intent(this, choose.class);
                startActivity(intent);
                break;

            case R.id.save1:

                try {
                    FileOutputStream fileOut =
                            new FileOutputStream("user_storage_197466588299931246658290017389927333");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(u);
                    out.writeObject(pr);
                    out.close();
                    fileOut.close();
                } catch (IOException i) {
                    i.printStackTrace();
                }

                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}
