/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Juan Nathaniel
 */
public class Item {
    private int id;
    private String name;
    private String desc;
    private int price;
    private EnumCheckItem availability;

    public Item() {
    }

    public Item(String name, String harga, String deskripsi, EnumCheckItem enumCheckItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public EnumCheckItem getAvailability() {
        return availability;
    }

    public void setAvailability(EnumCheckItem availability) {
        this.availability = availability;
    }
}
