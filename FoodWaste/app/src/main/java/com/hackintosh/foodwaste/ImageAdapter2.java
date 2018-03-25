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

public class ImageAdapter2 extends BaseAdapter {
        private Context mContext;

        public ImageAdapter2(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIdsr.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            RelativeLayout relativeLayout = new RelativeLayout(mContext);
            TextView textView;

            textView = new TextView(mContext);

            imageView.setLayoutParams(new GridView.LayoutParams(400, 200));
            textView.setLayoutParams(new GridView.LayoutParams(850, 500));
            relativeLayout.setLayoutParams(new GridView.LayoutParams(850, 200));
            relativeLayout.setPadding(8, 8, 8, 8);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
            textView.setPadding(400, 20, 8, 8);


            imageView.setImageResource(mThumbIdsr[position]);
            String toShow = productsr[position];
            textView.setText(toShow);


            relativeLayout.addView(imageView);
            relativeLayout.addView(textView);
            return relativeLayout;
        }

        // references to our images
        static final Integer[] mThumbIdsr = {
                R.drawable.bolognese, R.drawable.omleta,
                R.drawable.salfrct, R.drawable.cartofic
        };

        static final String[] productsr = {
                "Paste Bolognese\n\nIngrediente:" +
                        "\n" +
                        "2 lingurite ulei de masline\n" +
                        "6 felii de sunca italieneasca neafumata tocata\n" +
                        "2 cepe mari, tocate\n" +
                        "3 catei de usturoi zdrobiti\n" +
                        "2 morcovi tocati\n" +
                        "1 telina\n" +
                        "1 kg carte de vita tocata\n" +
                        "2 pahare mari de vin rosu\n" +
                        "2 cutii de rosii tocate x 400g/buc\n" +
                        "2 frunze uscate sau proaspete de dafin\n" +
                        "sare si piper negru proaspat macinat\n" +
                        "800 g - 1 kg tagliatele uscate\n" +
                        "parmezan ras proaspat pentru servire\n" +
                        "\n" +
                        "\n" + "Mod de preparare:\n" +
    "Incalzeste uleiul intr-o cratita mare si prajeste sunca la foc mediu pana devine aurie. Adauga ceapa si usturoiul si prajeste-le pana se inmoaie.\n" +

    "Adauga morcovul, frunzele de dafin si lasa in continuare pe foc pana cand legumele incep sa se inmoaie.\n" +

    "Mareste focul si adauga carnea de vita tocata. Prajeste pana se rumeneste.\n" +

    "Toarna apoi vinul si fierbe pana si-a redus din volum cu aproximativ o treime. Reduce temperatura si adauga rosiile si telina.\n" +

    "Fierbe tagliatelele in apa cu sare la foc mic, intr-o oala cu capac, dupa instructiunile de pe ambalaj. Cand sunt gata, imparte-le in farfurii. Presara putin parmezan, iar apoi adauga sosul. La sfarsit, presara din nou parmezan si putin piper negru.\n",
                "Omleta\n\nIngrediente:\n" + "2 oua\n (optional branza/sunca/cascaval)\n\n" + "Mod de preparare:\n" + "Bate bine ouale, adauga sare si piper.\nPune intr-o tigaie uleiul la incins.\n(Optional, poti adauga sunca/bacon/ceapa in tigaie).\n"
                + "Toarna ouale batute, amesteca repede si apoi lasa omleta sa devina pufoasa\n",
                "Salata de fructe\n\nIngrediente:\norice fel de fructe\n\nMod de preparare:\nSe toaca fructele bucati. Se pun intr-un bol. Se amesteca si, dupa preferinte, se poate adauga lichior\n",
                "Cartofi prajiti cu carnati\n\nIngrediente:\ncartofi\ncarnati\n\nMod de preparare:\nSe taie cartofii in bucati.\nSe pune uleiul la incins. Cand e suficient de incins, se adauga cartofii.\nDupa aproximativ 10-15 minute se adauga bucatele de carnati\n"
        };
}
