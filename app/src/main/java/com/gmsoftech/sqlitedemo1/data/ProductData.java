package com.gmsoftech.sqlitedemo1.data;

/**
 * Created by Admin on 9/19/2018.
 */

public class ProductData {
    private long productId;
    private String productName;
    private String category;
    private float price;
    private int stkQty;

    public ProductData(String productName, String category, float price, int stkQty) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stkQty = stkQty;
    }

    public ProductData(long productId, String productName, String category, float price, int stkQty) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stkQty = stkQty;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStkQty() {
        return stkQty;
    }

    public void setStkQty(int stkQty) {
        this.stkQty = stkQty;
    }
}
