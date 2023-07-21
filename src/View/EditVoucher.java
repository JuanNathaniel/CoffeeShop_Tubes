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
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new GridLayout(8, 2));

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

        lblStatus = new JLabel("");

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

        btnEdit.addActionListener(this);
        btnAddNew.addActionListener(this);

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
                lblStatus.setText("Voucher updated successfully!");
            } else {
                lblStatus.setText("Error while updating the voucher!");
            }
        } else if (e.getSource() == btnAddNew) {
            int id = Integer.parseInt(tfId.getText());
            String name = tfName.getText();
            String desc = tfDesc.getText();
            double discount = Double.parseDouble(tfDiscount.getText());
            double condition = Double.parseDouble(tfCondition.getText());

            boolean success = VoucherFunction.insertVoucher(id, name, desc, discount, condition);

            if (success) {
                lblStatus.setText("New voucher added successfully!");
            } else {
                lblStatus.setText("Error while adding the voucher!");
            }
            lblStatus.setText("New voucher added successfully!");
        }
    }

    public static void main(String[] args) {
        new EditVoucher();
    }

}
