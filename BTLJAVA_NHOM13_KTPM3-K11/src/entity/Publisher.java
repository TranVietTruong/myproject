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
public class Publisher {
    private int id;
    private String name_publisher;
    private int is_delete;

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

    public String getName_publisher() {
        return name_publisher;
    }

    public void setName_publisher(String name_publisher) {
        this.name_publisher = name_publisher;
    }

    public Publisher(int id, String name_publisher) {
        this.id = id;
        this.name_publisher = name_publisher;
    }

    public Publisher() {
    }
    
    
}
