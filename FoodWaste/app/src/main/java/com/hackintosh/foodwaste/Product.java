package com.hackintosh.foodwaste;

public class product implements java.io.Serializable{
    private Integer ttl;
    private Integer maxTtl; // how much time this product can stay unused until it goes bad
    private String name;
    private Double quantity;
    private int day;

    product(Integer ttl, Integer maxTtl, String name, Double quantity, int day) {
        this.quantity = quantity;
        this.name = name;
        this.maxTtl = maxTtl;
        this.ttl = ttl;
        this.setDay(day);
    }
    product() { }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public Integer getMaxTtl() {
        return maxTtl;
    }

    public void setMaxTtl(Integer maxTtl) {
        this.maxTtl = maxTtl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void decTtl() {
        --this.ttl;
    }

    public void useProduct(double used) {
        this.quantity -= used;
    }

    public int getDay() {
        return day;
    }


    public void setDay(int day) {
        this.day = day;
    }
}
