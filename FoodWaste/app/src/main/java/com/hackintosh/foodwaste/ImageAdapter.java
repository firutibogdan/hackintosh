package com.hackintosh.foodwaste;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by bogdan-cristianfiruti on 08/03/2018.
 */

public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            RelativeLayout relativeLayout;
            TextView textView;

            imageView = new ImageView(mContext);
            textView = new TextView(mContext);
            relativeLayout = new RelativeLayout(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(400, 200));
            textView.setLayoutParams(new GridView.LayoutParams(700, 200));
            relativeLayout.setLayoutParams(new GridView.LayoutParams(700, 200));
            relativeLayout.setPadding(8, 8, 8 ,8);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
            textView.setPadding(400, 100, 8, 8);
            textView.setText(busses[position]);
            imageView.setImageResource(mThumbIds[0]);
            
            relativeLayout.addView(imageView);
            relativeLayout.addView(textView);
            return relativeLayout;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.bus, R.drawable.bus,
                R.drawable.bus, R.drawable.bus,
                R.drawable.bus, R.drawable.bus
        };

        private String[] busses = {
                "Branza", "Oua",
                "B 102 CAR", "B 103 CAR",
                "B 104 CAR", "B 105 CAR"
        };
    }
