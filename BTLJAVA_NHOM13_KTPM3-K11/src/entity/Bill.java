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
public class Bill {
    private int id;
    private String name_customer;
    private String name_employee;
    private String date_order;
    private String note;
    private int tota_money;
    private int promotion;
    private int is_delete;
    private int stt;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public String getName_employee() {
        return name_employee;
    }

    public void setName_employee(String name_employee) {
        this.name_employee = name_employee;
    }

    public String getDate_order() {
        return date_order;
    }

    public void setDate_order(String date_order) {
        this.date_order = date_order;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTota_money() {
        return tota_money;
    }

    public void setTota_money(int tota_money) {
        this.tota_money = tota_money;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public Bill(int id, String name_customer, String name_employee, String date_order, String note, int tota_money, int promotion,int stt) {
        this.id = id;
        this.name_customer = name_customer;
        this.name_employee = name_employee;
        this.date_order = date_order;
        this.note = note;
        this.tota_money = tota_money;
        this.promotion = promotion;
        this.stt = stt;
    }

    public Bill() {
    }
}
