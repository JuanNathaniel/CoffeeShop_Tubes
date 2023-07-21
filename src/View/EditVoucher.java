/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AdminFunction;
import Controller.VoucherFunction;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class EditVoucher extends JFrame implements ActionListener {

    private JTextField tfId, tfName, tfDesc, tfDiscount, tfCondition;
    private JButton btnEdit, btnAddNew;
    private JLabel lblStatus;

    public EditVoucher() {
        setTitle("Edit Voucher (Super Admin)");
        setSize(650, 950); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null); 

        JLabel lblId = new JLabel("Voucher ID:");
        tfId = new JTextField();
        JLabel lblName = new JLabel("Voucher Name:");
        tfName = new JTextField();
        JLabel lblDesc = new JLabel("Voucher Description:");
        tfDesc = new JTextField();
        JLabel lblDiscount = new JLabel("Voucher Discount (%):");
        tfDiscount = new JTextField();
        JLabel lblCondition = new JLabel("Voucher Condition:");
        tfCondition = new JTextField();

        btnEdit = new JButton("Edit");
        btnAddNew = new JButton("Add New");

        lblStatus = new JLabel();

        lblId.setBounds(20, 20, 100, 30);
        tfId.setBounds(230, 20, 200, 30);
        lblName.setBounds(20, 100, 120, 30);
        tfName.setBounds(230, 100, 200, 30);
        lblDesc.setBounds(20, 180, 150, 30);
        tfDesc.setBounds(230, 180, 200, 30);
        lblDiscount.setBounds(20, 240, 150, 30);
        tfDiscount.setBounds(230, 240, 200, 30);
        lblCondition.setBounds(20, 320, 150, 30);
        tfCondition.setBounds(230, 320, 200, 30);
        btnEdit.setBounds(20, 460, 150, 40);
        btnAddNew.setBounds(280, 460, 150, 40);
        lblStatus.setBounds(20, 560, 400, 30);

        btnEdit.addActionListener(this);
        btnAddNew.addActionListener(this);

        c.add(lblId);
        c.add(tfId);
        c.add(lblName);
        c.add(tfName);
        c.add(lblDesc);
        c.add(tfDesc);
        c.add(lblDiscount);
        c.add(tfDiscount);
        c.add(lblCondition);
        c.add(tfCondition);
        c.add(btnEdit);
        c.add(btnAddNew);
        c.add(lblStatus);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBounds(20, 770, 150, 40);
        c.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new MainMenuAdmin(); 
            }
        });

        JLabel footer = new JLabel("Kofi By MJME | Whatsapp CS Kofi : 0817-1717-1717");
        footer.setFont(new Font("Arial", Font.BOLD, 15));
        footer.setForeground(Color.white);
        footer.setBackground(Color.DARK_GRAY);
        footer.setOpaque(true);
        footer.setBounds(0, 720, 650, 40); 
        c.add(footer);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEdit) {
            int id = Integer.parseInt(tfId.getText());
            String name = tfName.getText();
            String desc = tfDesc.getText();
            double discount = Double.parseDouble(tfDiscount.getText());
            double condition = Double.parseDouble(tfCondition.getText());
            boolean success = VoucherFunction.updateVoucher(id, name, desc, discount, condition);

            if (success) {
                lblStatus.setText("Voucher berhasil diupdate!");
            } else {
                lblStatus.setText("Error saat mengupdate voucher!");
            }
        } else if (e.getSource() == btnAddNew) {
            int id = Integer.parseInt(tfId.getText());
            String name = tfName.getText();
            String desc = tfDesc.getText();
            double discount = Double.parseDouble(tfDiscount.getText());
            double condition = Double.parseDouble(tfCondition.getText());

            boolean success = VoucherFunction.insertVoucher(id, name, desc, discount, condition);

            if (success) {
                lblStatus.setText("Voucher baru berhasil ditambahkan!");
            } else {
                lblStatus.setText("Error saat menambahkan voucher!");
            }
        }
    }

    public static void main(String[] args) {
        new EditVoucher();
    }

}
