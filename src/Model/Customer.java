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
public class Customer extends User implements InterfaceUserFunction {

    private int id;
    private String address;
    private String noHp;
    private EnumMember member;
    private int saldo;

    public Customer() {
    }

    public Customer(int id, String address, String noHp, EnumMember member, int saldo, String username, String password, String email) {
        super(id, username, password, email);
        this.id = id;
        this.address = address;
        this.noHp = noHp;
        this.member = member;
        this.saldo = saldo;
    }
    //untuk register
    public Customer(String username, String password, String email, String address, EnumMember enumMember, String noHp, int saldo) {
        super(username, password, email);
        this.address= address;
        this.member = enumMember;
        this.noHp = noHp; 
        this.saldo = saldo;
    }

    public Customer(String text, String text0, String text1, String text2, String text3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //untuk update
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public EnumMember getMember() {
        return member;
    }

    public void setMember(EnumMember member) {
        this.member = member;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public void viewVoucher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
