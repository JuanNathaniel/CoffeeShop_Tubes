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
import Model.SingletonUserManager;
import Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * INI FUNCTION YANG ADMIN SAMA CUSTOMER BISA MAKE
 */
public class GlobalFunction {

    public static User checkEmailPassLogin(String email, String pass) {
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            String query = "SELECT * FROM customer WHERE email='" + email + "' AND password='" + pass +"'";
            String nameQuery = "custo";
            for (int i = 1; i <= 2; i++) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println(i);
                    System.out.println();
                    if (nameQuery.equals("admi")) {
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
                    }
                }
                nameQuery = "admi";
                query = "SELECT * FROM admin WHERE email='" + email + "' AND password='" + pass +"'";
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
}
