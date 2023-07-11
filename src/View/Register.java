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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Controller.CustomerFunction;
import Model.Customer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author RAPHAEL
 */
public class Register extends JFrame implements ActionListener {

    JTextField inputEmail, inputPass, inputUname, inputnoHp, inputaddress;
    JButton back;
    JFrame frame = this;

    public Register() {
        this.setTitle("Landing Page");

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);

        //Back button
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBounds(20, 20, 70, 70);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new LandingPage();
            }
        });

        JLabel masuk = new JLabel("Register");
        masuk.setFont(new Font("Arial", Font.BOLD, 23));
        masuk.setForeground(Color.white);
        masuk.setBounds(230, 20, 250, 70);
        panel.add(masuk);
        JLabel masuk2 = new JLabel("Register");
        masuk2.setFont(new Font("Arial", Font.BOLD, 23));
        masuk2.setForeground(Color.BLACK);
        masuk2.setBounds(232, 22, 250, 70);
        panel.add(masuk2);

        //Text
        JLabel labelInputEmail = new JLabel("Masukkan Email");
        labelInputEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInputEmail.setForeground(Color.white);
        labelInputEmail.setBounds(155, 120, 290, 70);
        panel.add(labelInputEmail);

//Input email
        inputEmail = new JTextField();
        inputEmail.setBounds(155, 190, 290, 40);
        panel.add(inputEmail);

//Text
        JLabel labelInputUname = new JLabel("Masukkan username");
        labelInputUname.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInputUname.setForeground(Color.white);
        labelInputUname.setBounds(155, 240, 290, 70);
        panel.add(labelInputUname);

//Input username
        inputUname = new JTextField();
        inputUname.setBounds(155, 310, 290, 40);
        panel.add(inputUname);

//Text
        JLabel labelInputPass = new JLabel("Masukkan Password");
        labelInputPass.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInputPass.setForeground(Color.white);
        labelInputPass.setBounds(155, 360, 290, 70);
        panel.add(labelInputPass);

//Input password
        inputPass = new JPasswordField();
        inputPass.setBounds(155, 430, 290, 40);
        panel.add(inputPass);

//Text
        JLabel labelInputaddress = new JLabel("Masukkan address");
        labelInputaddress.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInputaddress.setForeground(Color.white);
        labelInputaddress.setBounds(155, 480, 290, 70);
        panel.add(labelInputaddress);

//Input address
        inputaddress = new JTextField();
        inputaddress.setBounds(155, 550, 290, 40);
        panel.add(inputaddress);

//Text
        JLabel labelInputnoHp = new JLabel("Masukkan No HP");
        labelInputnoHp.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInputnoHp.setForeground(Color.white);
        labelInputnoHp.setBounds(155, 600, 290, 70);
        panel.add(labelInputnoHp);

//Input noHp
        inputnoHp = new JTextField();
        inputnoHp.setBounds(155, 670, 290, 40);
        panel.add(inputnoHp);

        //RegisterButton
        JButton RegisterButton = new JButton("Register");
        RegisterButton.setFont(new Font("Arial", Font.PLAIN, 20));
        RegisterButton.setBounds(255, 720, 190, 40);
        panel.add(RegisterButton);
        //--
        RegisterButton.addActionListener(this);
        //
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = inputUname.getText();
        String password = inputPass.getText();
        String email = inputEmail.getText();
        String address = inputaddress.getText();
        String noHp = inputnoHp.getText();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || address.isEmpty() || noHp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Register failed! Semua bidang harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Boolean cs = CustomerFunction.register(username, password, email, address, noHp);
            if (cs) {
                JOptionPane.showMessageDialog(this, "Registration successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed. Email sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

//    public static void main(String[] args) {
//        new Register();
//    }

}
