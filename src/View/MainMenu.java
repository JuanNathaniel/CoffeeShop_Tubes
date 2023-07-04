/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Model.Customer;

/**
 *
 * @author Ju
 */
//ini menu setelah login/register (setelah LandingPage.java)
//Tambahin button button disini
public class MainMenu extends JFrame {

    public MainMenu() {
        this.setTitle("Landing Page");

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);
        //

        Customer cs;
        cs = Controller.CustomerFunction.getCustomer("micel@gmail.com");
        //profile
        JButton profil = new JButton(cs.getUsername());
        profil.setFont(new Font("Arial", Font.BOLD, 11));
        profil.setBounds(20, 20, 70, 70);
        panel.add(profil);

        //Text
        JLabel selamatdatang = new JLabel("<html>Welcome to Kofi,<br>" + cs.getUsername() + "</html>");
        selamatdatang.setFont(new Font("Arial", Font.BOLD, 23));
        selamatdatang.setForeground(Color.white);
        selamatdatang.setBounds(20, 120, 250, 70);
        panel.add(selamatdatang);

        //Tagline
        JLabel tagline = new JLabel("<html>Beragam rasa di Kofi Coffee <br>siap menemani harimu!");
        tagline.setFont(new Font("Arial", Font.PLAIN, 17));
        tagline.setForeground(Color.white);
        tagline.setBounds(20, 195, 250, 70);
        panel.add(tagline);

        //Saldo
        JLabel saldo = new JLabel("<html>Saldo mu : <br> Rp "+cs.getSaldo()+"</html>");
        saldo.setFont(new Font("Arial", Font.PLAIN, 19));
        saldo.setForeground(Color.white);
        saldo.setBounds(450, 190,150, 70);
        panel.add(saldo);
        
        //Pilih Lokasi Store
        JButton store = new JButton("Pilih Lokasi Store");
        store.setFont(new Font("Arial", Font.PLAIN, 23));
        store.setBounds(20, 270, 250, 70);
        panel.add(store);
        
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

    public static void main(String[] args) {
        new MainMenu();
    }
}