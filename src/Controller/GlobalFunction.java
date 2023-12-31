/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.CustomerFunction.conn;
import Model.Customer;
import Model.Admin;
import Model.EnumMember;
import Model.Manager;
import Model.SingletonUserManager;
import Model.Transaction;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * INI FUNCTION YANG ADMIN SAMA CUSTOMER BISA MAKE
 */
public class GlobalFunction {

    //Function Login
    public static User checkEmailPassLogin(String email, String pass) {
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            String query = "SELECT * FROM customer WHERE email='" + email + "' AND password='" + pass + "'";
            String nameQuery = "custo";

            for (int i = 1; i <= 3; i++) {
                if (i == 2) {
                    nameQuery = "admi";
                    query = "SELECT * FROM admin WHERE email='" + email + "' AND password='" + pass + "'";
                } else if (i == 3) {
                    nameQuery = "manage";
                    query = "SELECT * FROM manager WHERE email='" + email + "' AND password='" + pass + "'";
                }

                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    if (nameQuery.equals("admi")) {
                        System.out.println("masok admin");
                        Admin adm = new Admin();
                        adm.setId(rs.getInt("id"));
                        adm.setUsername(rs.getString("username"));
                        adm.setPassword(rs.getString("password"));
                        adm.setEmail(rs.getString("email"));
                        adm.setCabang(rs.getInt("idStore"));
                        //
                        SingletonUserManager.getInstance().setUser(adm);
                        return (adm);
                    } else if (nameQuery.equals("custo")) {
                        System.out.println("masok custme");
                        Customer cust = new Customer();
                        cust.setId(rs.getInt("id"));
                        cust.setUsername(rs.getString("username"));
                        cust.setPassword(rs.getString("password"));
                        cust.setEmail(rs.getString("email"));
                        cust.setAddress(rs.getString("address"));
                        cust.setNoHp(rs.getString("noHp"));
                        cust.setMember(EnumMember.valueOf(EnumMember.class, rs.getString("member").toUpperCase()));
                        cust.setSaldo(rs.getInt("saldo"));
                        //
                        SingletonUserManager.getInstance().setUser(cust);
                        return (cust);
                    } else if (nameQuery.equals("manage")) {
                        System.out.println("masok manage");
                        Manager manager = new Manager();
                        manager.setId(rs.getInt("id"));
                        manager.setIdManager(rs.getInt("id"));
                        manager.setUsername(rs.getString("username"));
                        manager.setPassword(rs.getString("password"));
                        manager.setEmail(rs.getString("email"));
                        SingletonUserManager.getInstance().setUser(manager);
                        return (manager);
                    };
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null,
                "User not founds. Try again.",
                "Error Message",
                JOptionPane.ERROR_MESSAGE);
        return null;
    }

    public static ArrayList<Transaction> getHistoryTransaction() {
        conn.connect();
        String query = "SELECT * FROM transaction";
        ArrayList<Transaction> trans = new ArrayList<Transaction>();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Transaction temp = new Transaction();
                temp.setId(rs.getInt("id"));
                temp.setIdCustomer(rs.getInt("idCustomer"));
                temp.setIdStore(rs.getInt("idStore"));
                temp.setIdVoucher(rs.getInt("idVoucher"));
                temp.setDate(rs.getDate("transactionDate"));
                trans.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trans;
    }
}
