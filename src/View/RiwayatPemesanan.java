/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CustomerFunction;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class RiwayatPemesanan extends JFrame {

    private int customerId;

    public RiwayatPemesanan(int customerId) {
        this.customerId = customerId;
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Riwayat Pemesanan");

        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);

        JLabel heading = new JLabel("Riwayat Pemesanan");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setBounds(20, 20, 250, 30);
        panel.add(heading);

        JTextArea historyTextArea = new JTextArea();
        historyTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        historyTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyTextArea);
        scrollPane.setBounds(20, 60, 600, 600);
        panel.add(scrollPane);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBounds(100, 680, 400, 50);
        panel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        CustomerFunction.fetchAndDisplayOrderHistory(historyTextArea);

        JLabel footer = new JLabel("Kofi By MJME             Whatsapp CS Kofi : 0817-1717-1717");
        footer.setFont(new Font("Arial", Font.BOLD, 15));
        footer.setForeground(Color.white);
        footer.setBackground(Color.DARK_GRAY);
        footer.setOpaque(true);
        footer.setBounds(10, 780, 610, 90);
        panel.add(footer);

        this.add(panel);
        panel.setLayout(null);

        this.setSize(650, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private RiwayatPemesanan() {
    }
    public static void main(String[] args) {
        // Create the RiwayatPesanan GUI for customer ID 1
        int customerId = 1; // Ganti nilai ini dengan ID customer yang ingin Anda lihat riwayat pesanannya
        new RiwayatPemesanan(customerId);
    }
}