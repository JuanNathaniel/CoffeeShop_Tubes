/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Admin;
import Model.Customer;
import Model.Manager;
import Model.SingletonUserManager;
import Model.Transaction;
import Model.User;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainMenuAdmin extends JFrame {

    public MainMenuAdmin() {

        User adm = SingletonUserManager.getInstance().getUser();

        this.setTitle("Main Menu Admin");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);

        JButton hapusUserButton = new JButton("Hapus User");
        hapusUserButton.setFont(new Font("Arial", Font.PLAIN, 23));
        hapusUserButton.setBounds(20, 20, 250, 70);
        hapusUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        panel.add(hapusUserButton);

        JButton addMenuButton = new JButton("Add Makanan/Minuman");
        addMenuButton.setFont(new Font("Arial", Font.PLAIN, 23));
        addMenuButton.setBounds(20, 100, 300, 70);
        addMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new AddMakananMinuman();
            }
        });
        panel.add(addMenuButton);

        JButton tabListOrderButton = new JButton("Tab List Order/Process");
        tabListOrderButton.setFont(new Font("Arial", Font.PLAIN, 23));
        tabListOrderButton.setBounds(20, 180, 350, 70);
        tabListOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList <Transaction> newTrans = new ArrayList();
                new ListOrder(newTrans);
            }
        });
        panel.add(tabListOrderButton);

        if (adm instanceof Manager) {

            Manager adms = (Manager) SingletonUserManager.getInstance().getUser();
            JButton managerButton = new JButton("Manager");
            managerButton.setFont(new Font("Arial", Font.PLAIN, 23));
            managerButton.setBounds(20, 260, 150, 70);
            managerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });
            panel.add(managerButton);

            JButton voucherButton = new JButton("Edit/Add Voucher (Manager)");
            voucherButton.setFont(new Font("Arial", Font.PLAIN, 23));
            voucherButton.setBounds(20, 340, 400, 70);
            voucherButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new EditVoucher();
                }
            });
            panel.add(voucherButton);

            JButton tambahStoreButton = new JButton("Tambah Lokasi Store (Manager)");
            tambahStoreButton.setFont(new Font("Arial", Font.PLAIN, 23));
            tambahStoreButton.setBounds(20, 420, 400, 70);
            tambahStoreButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new TambahLokasi();
                }
            });
            panel.add(tambahStoreButton);

            JButton rekapPenjualanButton = new JButton("Rekap Penjualan (Manager)");
            rekapPenjualanButton.setFont(new Font("Arial", Font.PLAIN, 23));
            rekapPenjualanButton.setBounds(20, 500, 350, 70);
            rekapPenjualanButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new LihatRekapPenjualan();
                }
            });
            panel.add(rekapPenjualanButton);

            //View voucher
            JButton viewVoucher = new JButton("Voucher");
            viewVoucher.setFont(new Font("Arial", Font.PLAIN, 20));
            viewVoucher.setBounds(280, 20, 150, 70);
            // Button diklik, pindah page ke pilihstorepage
            viewVoucher.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "List voucher:\n" + adms.viewVoucher());
                }
            });
            panel.add(viewVoucher);
        }

        JLabel footer = new JLabel("                         Kofi By MJME             Whatsapp CS Kofi : 0817-1717-1717");
        footer.setFont(new Font("Arial", Font.BOLD, 15));
        footer.setForeground(Color.white);
        footer.setBackground(Color.DARK_GRAY);
        footer.setOpaque(true);
        footer.setBounds(0, 820, 610, 90);
        panel.add(footer);

        this.add(panel);
        panel.setLayout(null);

        this.setSize(610, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenuAdmin();
    }
}
