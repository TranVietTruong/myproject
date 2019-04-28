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
public class Catagory {
    private int id;
    private String name_catagory;
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

    public String getName_catagory() {
        return name_catagory;
    }

    public void setName_catagory(String name_catagory) {
        this.name_catagory = name_catagory;
    }

    public Catagory(int id, String name_catagory) {
        this.id = id;
        this.name_catagory = name_catagory;
    }

    public Catagory() {
    }
}
