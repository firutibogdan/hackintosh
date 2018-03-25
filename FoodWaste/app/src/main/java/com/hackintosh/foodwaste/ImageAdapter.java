package com.hackintosh.foodwaste;

import android.content.Context;
import android.graphics.Color;
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

            imageView = new ImageView(mContext);
            relativeLayout = new RelativeLayout(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(400, 200));
            relativeLayout.setLayoutParams(new GridView.LayoutParams(400, 200));
            relativeLayout.setPadding(8, 8, 8 ,8);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
            imageView.setImageResource(mThumbIds[position]);
            
            relativeLayout.addView(imageView);
            return relativeLayout;
        }

        // references to our images
        static final Integer[] mThumbIds = {
                R.drawable.cascaval, R.drawable.paste,
                R.drawable.carnatia, R.drawable.carnati,
                R.drawable.parmezan, R.drawable.lapte,
                R.drawable.oua, R.drawable.branza,
                R.drawable.sunca, R.drawable.salam,
                R.drawable.rosii, R.drawable.castraveti,
                R.drawable.ceapa, R.drawable.cartofi,
                R.drawable.morcovi, R.drawable.mere,
                R.drawable.portocale, R.drawable.lamai,
                R.drawable.banane,
        };

        static final String[] products = {
                "Cascaval", "Paste", "Carnati afumati",
                "Carnati proaspeti", "Parmezan",
                "Lapte", "Oua", "Branza",
                "Sunca", "Salam", "Rosii",
                "Castraveti", "Ceapa",
                "Cartofi", "Morcovi",
                "Mere", "Portocale",
                "Lamai", "Banane"
        };
}
