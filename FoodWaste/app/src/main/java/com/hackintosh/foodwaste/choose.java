package com.hackintosh.foodwaste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class choose extends AppCompatActivity implements View.OnClickListener {

    public user u;
    public preset pr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);

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
                Intent intent = new Intent(choose.this, ProductInfo.class);
                intent.putExtra("index", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.recipe:
                Intent intent = new Intent(this, choose1.class);
                startActivity(intent);
                break;

            case R.id.save:

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
