/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author CoffeeShop
 */
public class LandingPage extends JFrame {

    public LandingPage() {
        this.setTitle("Landing Page");

        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);

//      profile
        JButton profil = new JButton("Profile");
        profil.setFont(new Font("Arial", Font.BOLD, 11));
        profil.setBounds(20, 20, 70, 70);
        panel.add(profil);

        //Text
        JLabel selamatdatang = new JLabel("<html>Welcome to Kofi,<br>FRIENDS</html>");
        selamatdatang.setFont(new Font("Arial", Font.BOLD, 23));
        selamatdatang.setForeground(Color.white);
        selamatdatang.setBounds(20, 120, 250, 70);
        panel.add(selamatdatang);

        //Tagline
        JLabel tagline = new JLabel("<html>Beragam warna di Kofi Coffee <br>siap menemani harimu!");
        tagline.setFont(new Font("Arial", Font.PLAIN, 17));
        tagline.setForeground(Color.white);
        tagline.setBounds(20, 195, 250, 70);
        panel.add(tagline);

        //Register
        JButton register = new JButton("Register");
        register.setFont(new Font("Arial", Font.BOLD, 16));
        register.setBounds(100, 640, 400, 50);
        panel.add(register);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new Register();
            }
        });

        //Login
        JButton login = new JButton("Login");
        login.setFont(new Font("Arial", Font.BOLD, 16));
        login.setBounds(100, 715, 400, 50);
        panel.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new Login();
            }
        });

        //copyright
        JLabel footer = new JLabel("                           Kofi By MJME             Whatsapp CS Kofi : 0817-1717-1717");
        footer.setFont(new Font("Arial", Font.BOLD, 15));
        footer.setForeground(Color.white);
        footer.setBackground(Color.DARK_GRAY);
        footer.setOpaque(true);
        footer.setBounds(0, 820, 610, 90);
        panel.add(footer);
        //JFrame
        this.add(panel);
        panel.setLayout(null);
        //
        this.setSize(610, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
