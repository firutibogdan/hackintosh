package com.hackintosh.foodwaste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    user u;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

    }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.getLocation:
                    if (new File(getFilesDir(), "fridgetrackerdata").exists()) {
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

                    u.resetList();

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

                    Intent intent = new Intent(this, choose.class);
                    startActivity(intent);
                    break;


                case R.id.end_ride:
                    Intent intent1 = new Intent(this, MyList.class);
                    startActivity(intent1);
                    break;
            }
        }
}
