/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class CouponDetail {
    private int id;
    private int id_coupon;
    private int id_commic;
    private String name_commic;
    private int quantity_order;
    private int import_price;
    
    public int getMoney()
    {
        return this.quantity_order * this.import_price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_coupon() {
        return id_coupon;
    }

    public void setId_coupon(int id_coupon) {
        this.id_coupon = id_coupon;
    }

    public int getId_commic() {
        return id_commic;
    }

    public void setId_commic(int id_commic) {
        this.id_commic = id_commic;
    }

    public String getName_commic() {
        return name_commic;
    }

    public void setName_commic(String name_commic) {
        this.name_commic = name_commic;
    }

    public int getQuantity_order() {
        return quantity_order;
    }

    public void setQuantity_order(int quantity_order) {
        this.quantity_order = quantity_order;
    }

    public int getImport_price() {
        return import_price;
    }

    public void setImport_price(int import_price) {
        this.import_price = import_price;
    }

    public CouponDetail(int id, int id_coupon, int id_commic, String name_commic, int quantity_order, int import_price) {
        this.id = id;
        this.id_coupon = id_coupon;
        this.id_commic = id_commic;
        this.name_commic = name_commic;
        this.quantity_order = quantity_order;
        this.import_price = import_price;
    }

    public CouponDetail() {
    }
}
