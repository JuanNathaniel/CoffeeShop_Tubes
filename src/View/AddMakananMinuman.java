/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AdminFunction;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
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
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author RAPHAEL
 */
public class AddMakananMinuman extends JFrame implements ActionListener {

    JTextField inputNamaMenu, inputHargaMenu, inputDeskripsi;
    JButton back;
    JFrame frame = this;

    public AddMakananMinuman() {
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Back button
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBounds(20, 20, 70, 70);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new MainMenuAdmin();
            }
        });

        JLabel masuk = new JLabel("Add Menu");
        masuk.setFont(new Font("Arial", Font.BOLD, 23));
        masuk.setForeground(Color.white);
        masuk.setBounds(230, 20, 250, 70);
        panel.add(masuk);
        JLabel masuk2 = new JLabel("Add Menu");
        masuk2.setFont(new Font("Arial", Font.BOLD, 23));
        masuk2.setForeground(Color.BLACK);
        masuk2.setBounds(232, 22, 250, 70);
        panel.add(masuk2);

    //Text
        JLabel labelInputEmail = new JLabel("Masukkan Nama Menu");
        labelInputEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInputEmail.setForeground(Color.white);
        labelInputEmail.setBounds(155, 120, 290, 70);
        panel.add(labelInputEmail);

    //Input Nama Menu
        inputNamaMenu = new JTextField();
        inputNamaMenu.setBounds(155, 190, 290, 40);
        panel.add(inputNamaMenu);

    //Text
        JLabel labelInputUname = new JLabel("Masukkan Harga Menu");
        labelInputUname.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInputUname.setForeground(Color.white);
        labelInputUname.setBounds(155, 240, 290, 70);
        panel.add(labelInputUname);

    //Input Harga Menu
        inputHargaMenu = new JTextField();
        inputHargaMenu.setBounds(155, 310, 290, 40);
        panel.add(inputHargaMenu);

    //Text
        JLabel labelInputPass = new JLabel("Masukkan Deskripsi Menu");
        labelInputPass.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInputPass.setForeground(Color.white);
        labelInputPass.setBounds(155, 360, 290, 70);
        panel.add(labelInputPass);

    //Input Deskripsi
        inputDeskripsi = new JTextField();
        inputDeskripsi.setBounds(155, 430, 290, 40);
        panel.add(inputDeskripsi);

    //AddButton
        JButton RegisterButton = new JButton("Add Menu");
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
        String namaMenu = inputNamaMenu.getText();
        String deskripsi = inputDeskripsi.getText();
        String hargaMenu = inputHargaMenu.getText();

        if (namaMenu.isEmpty() || deskripsi.isEmpty() || hargaMenu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Register failed! Semua bidang harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Boolean cs = AdminFunction.AddMakananMinuman(namaMenu, deskripsi, hargaMenu);
            if (cs) {
                JOptionPane.showMessageDialog(this, "Makanan / Minuman berhasil ditambahkan.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed. Menu sudah ada!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new AddMakananMinuman();
    }

}
