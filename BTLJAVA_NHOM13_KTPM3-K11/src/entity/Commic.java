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
public class Commic {
    private int id;
    private int id_catagory;
    private int id_publisher;
    private String name_commic;
    private String name_catagory;
    private String name_publisher;
    private int quantity;
    private int price;
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

    public int getId_catagory() {
        return id_catagory;
    }

    public void setId_catagory(int id_catagory) {
        this.id_catagory = id_catagory;
    }

    public int getId_publisher() {
        return id_publisher;
    }

    public void setId_publisher(int id_publisher) {
        this.id_publisher = id_publisher;
    }

    public String getName_commic() {
        return name_commic;
    }

    public void setName_commic(String name_commic) {
        this.name_commic = name_commic;
    }

    public String getName_catagory() {
        return name_catagory;
    }

    public void setName_catagory(String name_catagory) {
        this.name_catagory = name_catagory;
    }

    public String getName_publisher() {
        return name_publisher;
    }

    public void setName_publisher(String name_publisher) {
        this.name_publisher = name_publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Commic(int id, int id_catagory, int id_publisher, String name_commic, String name_catagory, String name_publisher, int quantity, int price) {
        this.id = id;
        this.id_catagory = id_catagory;
        this.id_publisher = id_publisher;
        this.name_commic = name_commic;
        this.name_catagory = name_catagory;
        this.name_publisher = name_publisher;
        this.quantity = quantity;
        this.price = price;
    }

    public Commic() {
    }
    
}
