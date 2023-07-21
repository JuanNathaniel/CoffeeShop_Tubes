/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.AdminFunction;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TambahLokasi extends JFrame {

    public TambahLokasi() {
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Add Location");

        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 300);
        panel.setBackground(Color.gray);

        JLabel titleLabel = new JLabel("Add Location");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(20, 20, 200, 30);
        panel.add(titleLabel);

        JLabel cabangLabel = new JLabel("Cabang:");
        cabangLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        cabangLabel.setBounds(20, 60, 100, 30);
        panel.add(cabangLabel);

        JTextField cabangTextField = new JTextField();
        cabangTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        cabangTextField.setBounds(130, 60, 200, 30);
        panel.add(cabangTextField);

        JLabel deskripsiLabel = new JLabel("Deskripsi:");
        deskripsiLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        deskripsiLabel.setBounds(20, 100, 100, 30);
        panel.add(deskripsiLabel);

        JTextField deskripsiTextField = new JTextField();
        deskripsiTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        deskripsiTextField.setBounds(130, 100, 200, 30);
        panel.add(deskripsiTextField);

        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        incomeLabel.setBounds(20, 140, 100, 30);
        panel.add(incomeLabel);

        JTextField incomeTextField = new JTextField();
        incomeTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        incomeTextField.setBounds(130, 140, 200, 30);
        panel.add(incomeTextField);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setBounds(20, 200, 150, 40);
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminFunction.saveLocationToDatabase(cabangTextField.getText(), deskripsiTextField.getText(), incomeTextField.getText());
                frame.setVisible(false);
            }
        });
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
        cancelButton.setBounds(200, 200, 150, 40);
        panel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenuAdmin();
            }
        });

        this.add(panel);
        panel.setLayout(null);

        this.setSize(400, 300);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}