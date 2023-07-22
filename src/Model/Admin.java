/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.StoreFunction;
import java.util.ArrayList;

/**
 *
 * @author CoffeeShop
 */
public class Admin extends User{

    private int id;
    private int idCabang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCabang() {
        return idCabang;
    }

    public void setCabang(int idCabang) {
        this.idCabang = idCabang;
    }

   @Override
    public StringBuilder viewVoucher() {
        ArrayList <Voucher> listVoucher = StoreFunction.getVoucher();
        StringBuilder vouchers= new StringBuilder();
            for (Voucher voucher : listVoucher) {
                vouchers.append(voucher.getName()).append(" | Discount Rp. ").append(voucher.getDiscount()).append("\n");
            }
            return vouchers;
    }
}
