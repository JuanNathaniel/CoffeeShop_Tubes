/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author CoffeeShop
 */
public class Admin extends User implements InterfaceUserFunction {

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
    public void viewVoucher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
