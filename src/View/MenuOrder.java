/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Controller.CustomerFunction;
import Model.Customer;
import Model.Item;
import View.LandingPage;
import java.util.ArrayList;

/**
 * Represents the MenuOrder window.
 */
public class MenuOrder extends JFrame implements ActionListener {

    JButton back, viewCart, removeItem, pay;
    JFrame frame = this;
    ArrayList<Item> customerItems = new ArrayList<>();

    public MenuOrder(int idStore) {
        ArrayList<Item> items = Controller.StoreFunction.getAvailItem(idStore);

        this.setTitle("Order Menu");

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBounds(20, 20, 70, 60);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new MainMenuCustomer();
            }
        });

        viewCart = new JButton("View Cart");
        viewCart.setFont(new Font("Arial", Font.PLAIN, 13));
        viewCart.setBounds(500, 20, 100, 70);
        panel.add(viewCart);
        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showCart();
            }
        });

        int startY = 130;
        int height = 130;

        for (int i = 0; i < items.size(); i++) {
            JLabel menu = new JLabel(items.get(i).getName());
            menu.setFont(new Font("Arial", Font.PLAIN, 25));
            menu.setForeground(Color.white);
            menu.setBounds(110, startY + 10 + (i * height), 200, height);
            panel.add(menu);

            JLabel menuharga = new JLabel("| Rp. " + String.valueOf(items.get(i).getPrice()));
            menuharga.setFont(new Font("Arial", Font.PLAIN, 15));
            menuharga.setForeground(Color.white);
            menuharga.setBounds(110, startY + 32 + (i * height), 300, height);
            panel.add(menuharga);

            JLabel menudesc = new JLabel("<html>" + items.get(i).getDesc() + " <br><br><br><br><br></html>");
            menudesc.setFont(new Font("Arial", Font.PLAIN, 15));
            menudesc.setForeground(Color.white);
            menudesc.setBounds(110, startY + 110 + (i * height), 300, height);
            panel.add(menudesc);

            JButton addButton = new JButton("Add");
            addButton.setBounds(400, startY + 80 + (i * height), 100, 30);
            addButton.setFont(new Font("Arial", Font.PLAIN, 14));
            panel.add(addButton);

            final int index = i;

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    customerItems.add(items.get(index));
                    JOptionPane.showMessageDialog(frame, "Item added to cart.");
                }
            });
        }

        removeItem = new JButton("Remove Item");
        removeItem.setFont(new Font("Arial", Font.PLAIN, 13));
        removeItem.setBounds(300, 800, 150, 50);
        panel.add(removeItem);
        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                removeItemFromCart();
            }
        });

        // Pay button
        pay = new JButton("Pay");
        pay.setFont(new Font("Arial", Font.PLAIN, 13));
        pay.setBounds(500, 800, 90, 50);
        panel.add(pay);
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!customerItems.isEmpty()) {
                    frame.dispose();
                    new Pembayaran(idStore, customerItems);
                    //proceedToPayment();
                }else{
                    JOptionPane.showMessageDialog(null, "Insert item first!", "MenuOrder", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        this.add(panel);
        panel.setLayout(null);
        this.setSize(610, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void showCart() {
        if (customerItems.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Your cart is empty.");
        } else {
            StringBuilder cartItems = new StringBuilder();
            for (Item item : customerItems) {
                cartItems.append(item.getName()).append(" | Rp. ").append(item.getPrice()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, "Your cart contains:\n" + cartItems.toString());
        }
    }

    private void removeItemFromCart() {
        if (customerItems.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Your cart is empty.");
        } else {
            String[] itemNames = new String[customerItems.size()];
            for (int i = 0; i < customerItems.size(); i++) {
                itemNames[i] = customerItems.get(i).getName();
            }
            String selectedName = (String) JOptionPane.showInputDialog(frame, "Select an item to remove:", "Remove Item",
                    JOptionPane.QUESTION_MESSAGE, null, itemNames, itemNames[0]);

            if (selectedName != null) {
                Item selectedItem = null;
                for (Item item : customerItems) {
                    if (item.getName().equals(selectedName)) {
                        selectedItem = item;
                        break;
                    }
                }

                if (selectedItem != null) {
                    customerItems.remove(selectedItem);
                    JOptionPane.showMessageDialog(frame, "Item removed from cart: " + selectedName);
                }
            }
        }
    }

    private void proceedToPayment() {
        if (customerItems.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Your cart is empty. Add items to the cart before proceeding to payment.");
        } else {

            JOptionPane.showMessageDialog(frame, "Payment successful. Thank you for your purchase!");
            customerItems.clear();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new MenuOrder(1);
    }
}
