/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CustomerFunction;
import Model.Customer;
import Model.SingletonUserManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Juan Nathaniel
 */
public class EditAlamat extends JFrame implements ActionListener {

    JTextField inputEmail, inputPass, inputUname, inputnoHp, inputAddress;
    String emailLama;

    Customer cs = (Customer) SingletonUserManager.getInstance().getUser();

    public EditAlamat() {
        this.setTitle("Edit Alamat Tersimpan");

        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);
        //
        //Back button
        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBounds(20, 20, 70, 70);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new PanelProfile();
            }
        });

        JLabel masuk = new JLabel("Edit Alamat");
        masuk.setFont(new Font("Arial", Font.BOLD, 23));
        masuk.setForeground(Color.white);
        masuk.setBounds(195, 20, 252, 72);
        panel.add(masuk);
        JLabel masuk2 = new JLabel("Edit Alamat");
        masuk2.setFont(new Font("Arial", Font.BOLD, 23));
        masuk2.setForeground(Color.BLACK);
        masuk2.setBounds(197, 22, 250, 70);
        panel.add(masuk2);

        //
        JLabel labelAlamatUtama = new JLabel("Alamat Utama");
        labelAlamatUtama.setFont(new Font("Arial", Font.BOLD, 20));
        labelAlamatUtama.setForeground(Color.white);
        labelAlamatUtama.setBounds(110, 115, 250, 70);
        panel.add(labelAlamatUtama);

        //
        JLabel descAlamat = new JLabel(cs.getAddress());
        descAlamat.setFont(new Font("Arial", Font.PLAIN, 20));
        descAlamat.setForeground(Color.white);
        descAlamat.setBackground(Color.darkGray);
        descAlamat.setOpaque(true);
        descAlamat.setBounds(110, 160, 250, 70);
        panel.add(descAlamat);

        //update button
        JButton updateAdd = new JButton("Update");
        updateAdd.setFont(new Font("Arial", Font.PLAIN, 20));
        updateAdd.setBounds(380, 160, 100, 70);
        panel.add(updateAdd);
        updateAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel2();
                panel.setVisible(false);
            }

        });

        //Footer
        JLabel footer = new JLabel("                         Kofi By MJME             Whatsapp CS Kofi : 0817-1717-1717");
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

    void panel2() {
        //Panel editq       

        JFrame frame = this;

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 0, 650, 500);
        panel2.setBackground(Color.gray);

        //Back button
        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBounds(20, 20, 70, 70);
        panel2.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new PanelProfile();
            }
        });

//Text
        JLabel labelInputaddress = new JLabel("Masukkan address Baru");
        labelInputaddress.setFont(new Font("Arial", Font.PLAIN, 20));
        labelInputaddress.setForeground(Color.white);
        labelInputaddress.setBounds(155, 100, 290, 70);
        panel2.add(labelInputaddress);

//Input address
        inputAddress = new JTextField(cs.getAddress());
        inputAddress.setBounds(155, 150, 290, 40);
        panel2.add(inputAddress);

        //RegisterButton
        JButton updateButton = new JButton("Update");
        updateButton.setFont(new Font("Arial", Font.PLAIN, 20));
        updateButton.setBounds(255, 250, 190, 40);
        panel2.add(updateButton);
        updateButton.addActionListener(this);

        //Footer
        JLabel footer = new JLabel("                         Kofi By MJME             Whatsapp CS Kofi : 0817-1717-1717");
        footer.setFont(new Font("Arial", Font.BOLD, 15));
        footer.setForeground(Color.white);
        footer.setBackground(Color.DARK_GRAY);
        footer.setOpaque(true);
        footer.setBounds(0, 370, 610, 90);
        panel2.add(footer);

        //JFrame
        this.add(panel2);
        panel2.setLayout(null);
        //
        this.setSize(610, 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (CustomerFunction.updateCustomer(cs, inputAddress.getText())) {
            JOptionPane.showMessageDialog(this, "Success Update", "Update address", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Failed Update", "Update address", JOptionPane.ERROR_MESSAGE);
        }

    }

//    public static void main(String[] args) {
//        new EditAlamat();
//    }

}
