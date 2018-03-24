package com.hackintosh.foodwaste;


import java.util.LinkedList;
import java.util.List;


public class preset implements java.io.Serializable {
    List<product> preProd = new LinkedList<product>();
    List<recipe> preRec = new LinkedList<recipe>();

    preset() {
        product p = new product();

        // cascaval
        p.setName("Cascaval");
        p.setMaxTtl(70);
        p.setTtl(70);

        preProd.add(p);
        p = new product();
        // paste
        p.setName("Paste");
        p.setMaxTtl(700);
        p.setTtl(700);
        preProd.add(p);
        p = new product();
        // carnati afumati
        p.setName("Carnati afumati");
        p.setMaxTtl(20);
        p.setTtl(20);
        preProd.add(p);
        p = new product();
        // carnati proaspeti
        p.setName("Carnati proaspeti");
        p.setMaxTtl(6);
        p.setTtl(6);
        preProd.add(p);

        // parmezan
        p = new product();
        p.setName("Parmezan");
        p.setMaxTtl(80);
        p.setTtl(80);
        preProd.add(p);

        p = new product();
        // lapte
        p.setName("Lapte");
        p.setMaxTtl(14);
        p.setTtl(14);
        preProd.add(p);
        p = new product();
        // oua
        p.setName("Oua");
        p.setMaxTtl(20);
        p.setTtl(20);
        preProd.add(p);
        p = new product();
        // branza
        p.setName("Branza");
        p.setMaxTtl(40);
        p.setTtl(40);
        preProd.add(p);
        p = new product();
        // sunca
        p.setName("Sunca");
        p.setMaxTtl(10);
        p.setTtl(10);
        preProd.add(p);
        p = new product();
        // salam
        p.setName("Salam");
        p.setMaxTtl(12);
        p.setTtl(12);
        preProd.add(p);
        p = new product();
        // rosii
        p.setName("Rosii");
        p.setMaxTtl(10);
        p.setTtl(10);
        preProd.add(p);
        p = new product();
        // castraveti
        p.setName("Castraveti");
        p.setMaxTtl(10);
        p.setTtl(10);
        preProd.add(p);

        p = new product();
        // ceapa
        p.setName("Ceapa");
        p.setMaxTtl(25);
        p.setTtl(25);
        preProd.add(p);
        p = new product();
        // cartofi
        p.setName("Cartofi");
        p.setMaxTtl(30);
        p.setTtl(30);
        preProd.add(p);
        p = new product();
        // morcovi
        p.setName("Morcovi");
        p.setMaxTtl(15);
        p.setTtl(15);
        preProd.add(p);
        p = new product();
        // mere
        p.setName("Mere");
        p.setMaxTtl(14);
        p.setTtl(14);
        preProd.add(p);

        p = new product();
        // portocale
        p.setName("Portocale");
        p.setMaxTtl(10);
        p.setTtl(10);
        preProd.add(p);
        p = new product();
        // lamai
        p.setName("Lamai");
        p.setMaxTtl(13);
        p.setTtl(13);
        preProd.add(p);

        p = new product();
        // banane
        p.setName("Banane");
        p.setMaxTtl(8);
        p.setTtl(8);
        preProd.add(p);


        // add recipe

        // macaroane cu branza
        List<product> pr = new LinkedList<product>();
        pr.add(preProd.get(2));
        pr.add(preProd.get(6));
        pr.add(preProd.get(7));
        pr.add(preProd.get(8));


        recipe mac = new recipe();
        mac.setIngredients(pr);

        preRec.add(mac);
    }

    public void addCustomProduct(String name, int ttl) {
        product p = new product();
        p.setName(name);
        p.setTtl(ttl);
        p.setMaxTtl(ttl);
        preProd.add(p);
    }
}