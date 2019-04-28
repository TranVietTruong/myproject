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
public class BillDetail {
    private int id;
    private int id_bill;
    private int id_commic;
    private String name_commic;
    private int price;
    private int quantity_order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_bill() {
        return id_bill;
    }

    public void setId_bill(int id_bill) {
        this.id_bill = id_bill;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity_order() {
        return quantity_order;
    }

    public void setQuantity_order(int quantity_order) {
        this.quantity_order = quantity_order;
    }
    public int getMoney() {
        return this.price * this.quantity_order;
    }
    
    public BillDetail(int id, int id_bill, int id_commic, String name_commic, int price, int quantity_order) {
        this.id = id;
        this.id_bill = id_bill;
        this.id_commic = id_commic;
        this.name_commic = name_commic;
        this.price = price;
        this.quantity_order = quantity_order;
    }

    public BillDetail() {
    }
}
