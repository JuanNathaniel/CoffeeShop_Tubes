/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Customer;
import Model.SingletonUserManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Juan Nathaniel
 */
public class PanelProfile extends JFrame{
    public PanelProfile(){
        this.setTitle("Panel Profile");

        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 450, 950);
        panel.setBackground(Color.gray);
        
        Customer cs = (Customer)SingletonUserManager.getInstance().getUser();
        //Text
        JLabel selamatdatang = new JLabel(cs.getUsername());
        selamatdatang.setFont(new Font("Arial", Font.BOLD, 20));
        selamatdatang.setForeground(Color.white);
        selamatdatang.setBounds(20, 30, 350, 70);
        panel.add(selamatdatang);
        
        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 11));
        back.setBounds(350, 30, 70, 70);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new MainMenuCustomer();
            }            
        });
        
        
        //Edit alamat tersimpan
        JButton editAlamat = new JButton("Alamat Tersimpan");
        editAlamat.setFont(new Font("Arial", Font.PLAIN, 15));
        editAlamat.setBounds(20, 170, 300, 50);
        // Button diklik, pindah page ke pilihstorepage
        editAlamat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new EditAlamat();
            }
        });
        panel.add(editAlamat);
        
        JButton button0 = new JButton("Button0");
        button0.setFont(new Font("Arial", Font.PLAIN, 15));
        button0.setBounds(20, 240, 300, 50);
        // Button diklik, pindah page ke pilihstorepage
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               }
        });
        panel.add(button0);
        
        JButton button1 = new JButton("Button1");
        button1.setFont(new Font("Arial", Font.PLAIN, 15));
        button1.setBounds(20, 310, 300, 50);
        // 
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //fungsi disini
            }
        });
        panel.add(button1);
        
        JButton button2 = new JButton("Button2");
        button2.setFont(new Font("Arial", Font.PLAIN, 15));
        button2.setBounds(20, 380, 300, 50);
        // 
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //fungsi disini
            }
        });
        panel.add(button2);
        
        //Footer
//        JLabel footer = new JLabel("                         Kofi By MJME             Whatsapp CS Kofi : 0817-1717-1717");
//        footer.setFont(new Font("Arial", Font.BOLD, 15));
//        footer.setForeground(Color.white);
//        footer.setBackground(Color.DARK_GRAY);
//        footer.setOpaque(true);
//        footer.setBounds(0, 820, 610, 90);
//        panel.add(footer);
        //JFrame
        this.add(panel);
        panel.setLayout(null);
        //
        this.setSize(610, 950);
        this.setBackground(Color.yellow);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
//    public static void main(String[] args) {
//        new PanelProfile();
//    }
}
