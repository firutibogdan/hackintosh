package com.hackintosh.foodwaste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class MyList extends AppCompatActivity implements View.OnClickListener {

    public user u;
    public preset pr;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mylist);

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

        GridView gridview = (GridView) findViewById(R.id.gridview1);
        gridview.setAdapter(new ImageAdapter1(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
            }
        });
    }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.save1:
                    finish();
                    break;

                case R.id.add:
                    Intent i = new Intent(this, choose.class);
                    startActivity(i);
                    break;
            }
        }
}
