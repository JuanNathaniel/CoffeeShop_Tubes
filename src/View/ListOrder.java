/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CustomerFunction;
import Controller.GlobalFunction;
import Controller.StoreFunction;
import Model.Item;
import Model.Transaction;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author RAPHAEL
 */
public class ListOrder extends JFrame{
    private JPanel panel;
    JButton back;
    public ListOrder(ArrayList <Transaction> undoneTransactions) {
        ArrayList <Transaction> newTrans = GlobalFunction.getHistoryTransaction();
        for (int i = 0; i < 3; i++) {
            undoneTransactions.add(newTrans.get(i));
        }
        
        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBounds(450, 20, 70, 60);
        this.add(back);
//        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panel.setVisible(false);
//              
                new MainMenuAdmin();
            }
        });
        
        this.setTitle("Order List");
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setLayout(null);

        // Your code to dynamically add components for each transaction in undoneTransactions
        // For example:
        int yPosition = 50;
        for (Transaction transaction : undoneTransactions) {
            JLabel orderLabel = new JLabel("Order: " + transaction.getId());
            orderLabel.setBounds(50, yPosition, 150, 25);
            orderLabel.setFont(new Font("Arial", Font.BOLD, 18));
            orderLabel.setForeground(Color.white);
            panel.add(orderLabel);

            JButton doneButton = new JButton("Done");
            doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                panel.setVisible(false);
            }
            });
            doneButton.setBounds(250, yPosition, 100, 30);
            panel.add(doneButton);

            yPosition += 40;
        }

        this.add(panel);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        ArrayList <Transaction> newTrans = new ArrayList();
        new ListOrder(newTrans);
    }
}
