/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Juan Nathaniel
 */
public class Store {
    private int id;
    private String cabang;
    private String storeCabang;
    private double income;
    private ArrayList<item> listMenu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCabang() {
        return cabang;
    }

    public void setCabang(String cabang) {
        this.cabang = cabang;
    }

    public String getStoreCabang() {
        return storeCabang;
    }

    public void setStoreCabang(String storeCabang) {
        this.storeCabang = storeCabang;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public ArrayList<item> getListMenu() {
        return listMenu;
    }

    public void setListMenu(ArrayList<item> listMenu) {
        this.listMenu = listMenu;
    }
    
    
}
