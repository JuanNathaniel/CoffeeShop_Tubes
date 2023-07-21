/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Customer;
import Model.EnumMember;
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
public class PanelProfile extends JFrame implements ActionListener {

    JFrame frame = this;
    JButton button2;

    public PanelProfile() {
        this.setTitle("Panel Profile");

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 450, 950);
        panel.setBackground(Color.gray);

        Customer cs = (Customer) SingletonUserManager.getInstance().getUser();
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
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new EditAlamat();
            }
        });
        panel.add(editAlamat);

        JButton buttonMember = new JButton("Membership");
        buttonMember.setFont(new Font("Arial", Font.PLAIN, 15));
        buttonMember.setBounds(20, 240, 300, 50);
        // Button diklik, ke page memberhsip
        buttonMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cs.getMember() == EnumMember.ISMEMBER) {
                    new JoinMembershipCustomer();
                    //JOptionPane.showMessageDialog(null, "<html>You are already membership<br>Thankyou ^_^</html>", "Membership", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    frame.setVisible(false);
                    new JoinMembershipCustomer();
                }
            }
        });
        panel.add(buttonMember);

        JButton button1 = new JButton("Button1");
        button1.setFont(new Font("Arial", Font.PLAIN, 15));
        button1.setBounds(20, 310, 300, 50);
        // 
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fungsi disinii
            }
        });
        panel.add(button1);

        button2 = new JButton("Logout");
        button2.setFont(new Font("Arial", Font.PLAIN, 15));
        button2.setBounds(20, 780, 300, 50);
        // 
        button2.addActionListener(this);
        
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button2) {
            System.out.println("kok gamasuk2");
            SingletonUserManager.getInstance().setUser(null);
            new LandingPage();
            frame.dispose();
        }
    }
}
