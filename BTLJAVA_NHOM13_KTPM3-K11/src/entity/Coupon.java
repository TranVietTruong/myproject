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
public class Coupon {
    private int id;
    private String name_suppiler;
    private String date_order;
    private String note;
    private int total;
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

    public String getName_suppiler() {
        return name_suppiler;
    }

    public void setName_suppiler(String name_suppiler) {
        this.name_suppiler = name_suppiler;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Coupon(int id, String name_suppiler, String date_order, String note, int total) {
        this.id = id;
        this.name_suppiler = name_suppiler;
        this.date_order = date_order;
        this.note = note;
        this.total = total;
    }

    public Coupon() {
    }
}
