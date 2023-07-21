/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CustomerFunction;
import static Controller.CustomerFunction.getCustomer;
import Controller.GlobalFunction;
import Controller.StoreFunction;
import Controller.VoucherFunction;

import static Controller.StoreFunction.getVoucher;
import static Controller.VoucherFunction.getVoucherByID;
import Model.Customer;
import Model.Item;
import Model.SingletonUserManager;
import Model.Transaction;
import Model.Voucher;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author ASUS
 */
// 3 ntar diganti sama size arraylist dari keranjang menu michael
public class Pembayaran extends JFrame implements ActionListener, MouseListener {

    Customer cs;
    JScrollPane scroll;
    JButton pay;
    JRadioButton butDelivery, butPickup;
    JLabel lDiskon, textTotal;
    Voucher voucher = new Voucher();
    ArrayList<Integer> qty;
    JButton cbVoucher;
    int totalBayar;
    int totalPrice;
    //
    ArrayList<Item> items = new ArrayList();

    public Pembayaran() {

        items = StoreFunction.getItem();
        voucher.setDiscount(0);
        qty = new ArrayList();

        qty.add(1);
        qty.add(2);
        qty.add(1);
        qty.add(1);
        qty.add(2);

//        qty.add(1);
//        qty.add(1);
//        qty.add(1);
//        qty.add(1);
//        qty.add(1);
//        qty.add(1);
//        qty.add(2);
//        qty.add(1);
//        qty.add(1);
//        qty.add(2);
        this.setTitle("Kofi Payment");

        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);
        //
        SingletonUserManager.getInstance().setUser(getCustomer("micel@gmail.com"));
        cs = (Customer) SingletonUserManager.getInstance().getUser();

        //Title
        JLabel membersip = new JLabel("<html><b>Payment<hr></html>");
        membersip.setFont(new Font("Arial", Font.BOLD, 25));
        membersip.setForeground(Color.white);
        membersip.setBounds(240, 20, 280, 150);
        panel.add(membersip);
        //profile
        //Back button
        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 13));
        back.setBounds(20, 20, 70, 70);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false);
                new PanelProfile();
            }
        });

        JLabel headMenu = new JLabel("<html>&ensp;Item &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp; Qty &emsp;&ensp;X&ensp;&emsp; Price&ensp;&emsp;&ensp;Tot.Price<br>--------------------------------------------------------------------------</html>");
        headMenu.setFont(new Font("Arial", Font.BOLD, 20));
        headMenu.setForeground(Color.white);
        headMenu.setBounds(39, 150, 600, 50);
        panel.add(headMenu);

        int spaceAntarText = 210;
        totalPrice = 0;
        for (int i = 0; i < 3; i++) {
            JLabel nameLabel = new JLabel("<html>" + (i + 1) + ".&ensp; " + items.get(i).getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
            nameLabel.setBounds(50, spaceAntarText, 220, 25);
            nameLabel.setForeground(Color.white);
            panel.add(nameLabel);

            JLabel quantity = new JLabel(String.valueOf(qty.get(i)));
            quantity.setFont(new Font("Arial", Font.BOLD, 18));
            quantity.setBounds(267, spaceAntarText, 150, 25);
            quantity.setForeground(Color.white);
            panel.add(quantity);

            JLabel pricePerItem = new JLabel(String.valueOf(items.get(i).getPrice()));
            pricePerItem.setFont(new Font("Arial", Font.BOLD, 18));
            pricePerItem.setBounds(360, spaceAntarText, 150, 25);
            pricePerItem.setForeground(Color.white);
            panel.add(pricePerItem);

            JLabel priceLabel = new JLabel("<html>:&emsp;&emsp;&emsp;" + String.valueOf(items.get(i).getPrice() * qty.get(i)) + "<html>");
            priceLabel.setFont(new Font("Arial", Font.BOLD, 18));
            priceLabel.setBounds(435, spaceAntarText, 150, 25);
            priceLabel.setForeground(Color.white);
            panel.add(priceLabel);
            //
            totalPrice += items.get(i).getPrice() * qty.get(i);
            //       
            spaceAntarText += 50;
        }

        JLabel garisBawah = new JLabel("--------------------------------------------------------------------------");
        garisBawah.setFont(new Font("Arial", Font.BOLD, 20));
        garisBawah.setForeground(Color.white);
        garisBawah.setBounds(42, spaceAntarText - 20, 600, 50);
        panel.add(garisBawah);

        //LabelVoucher
        JLabel lVoucher = new JLabel("Voucher : ");
        lVoucher.setFont(new Font("Arial", Font.BOLD, 20));
        lVoucher.setBounds(50, spaceAntarText + 80, 150, 25);
        lVoucher.setForeground(Color.white);
        panel.add(lVoucher);
        //Voucher
        JLabel textVoucher = new JLabel();
        JLabel totalPriceLabel = new JLabel(String.valueOf(totalPrice));
        textVoucher.setFont(new Font("Arial", Font.BOLD, 20));
        textVoucher.setBounds(50, spaceAntarText + 50, 150, 25);
        textVoucher.setForeground(Color.white);
        cbVoucher = new JButton("Pilih Voucher");
        cbVoucher.setBounds(150, spaceAntarText + 80, 250, 30);
        cbVoucher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewVoucherPage temp = new ViewVoucherPage(Integer.parseInt(totalPriceLabel.getText()));
                temp.addWindowListener(new WindowAdapter() {
                    public void windowClosed(WindowEvent e) {
                        textVoucher.setText(temp.voucherID);
                        voucher = VoucherFunction.getVoucherByID(textVoucher.getText());
                        textVoucher.setText(voucher.getName());
                    }
                });
            }
        });
        panel.add(textVoucher);
        panel.add(cbVoucher);
        cbVoucher.addMouseListener(this);

        //Labeltotal before diskon
        JLabel totBefDis = new JLabel(String.valueOf(totalPrice));
        totBefDis.setFont(new Font("Arial", Font.BOLD, 18));
        totBefDis.setForeground(Color.white);
        totBefDis.setBounds(488, spaceAntarText + 20, 600, 50);
        panel.add(totBefDis);

        //Label dapet diskon
        lDiskon = new JLabel();
        lDiskon.setFont(new Font("Arial", Font.PLAIN, 18));
        lDiskon.setBounds(482, spaceAntarText + 80, 150, 25);
        lDiskon.setForeground(Color.white);
        panel.add(lDiskon);
        lDiskon.setText("- " + String.valueOf(voucher.getDiscount()));

        JLabel garisBawah2 = new JLabel("--------------------------------------------------------------------------");
        garisBawah2.setFont(new Font("Arial", Font.BOLD, 20));
        garisBawah2.setForeground(Color.white);
        garisBawah2.setBounds(42, spaceAntarText + 100, 600, 50);
        panel.add(garisBawah2);

        textTotal = new JLabel("Total   :        " + (int) (totalPrice - voucher.getDiscount()));
        textTotal.setFont(new Font("Arial", Font.BOLD, 20));
        textTotal.setForeground(Color.white);
        textTotal.setBounds(365, spaceAntarText + 130, 600, 50);
        panel.add(textTotal);
        totalBayar = (int) (totalPrice - voucher.getDiscount());

        butPickup = new JRadioButton("Pickup");
        butPickup.setBounds(100, spaceAntarText + 130, 100, 50);
        butPickup.setFont(new Font("Arial", Font.PLAIN, 18));
        butPickup.setForeground(Color.white);
        butPickup.setBackground(Color.gray);
        butPickup.doClick();
        butDelivery = new JRadioButton("Delivery");
        butDelivery.setBounds(200, spaceAntarText + 130, 100, 50);
        butDelivery.setForeground(Color.white);
        butDelivery.setFont(new Font("Arial", Font.PLAIN, 18));
        butDelivery.setBackground(Color.gray);
        ButtonGroup bg = new ButtonGroup();
        bg.add(butDelivery);
        bg.add(butPickup);
        panel.add(butDelivery);
        panel.add(butPickup);

        pay = new JButton("Pay");
        pay.setBounds(39, spaceAntarText + 190, 520, 50);
        pay.setForeground(Color.black);
        panel.add(pay);
        pay.addActionListener(this);

        //Footer
        JLabel footer = new JLabel("                         Kofi By MJME             Whatsapp CS Kofi : 0817-1717-1717");
        footer.setFont(new Font("Arial", Font.BOLD, 15));
        footer.setForeground(Color.white);
        footer.setBackground(Color.DARK_GRAY);
        footer.setOpaque(true);
        footer.setBounds(0, spaceAntarText + 270, 620, 90);
        panel.add(footer);

        //scrollbar kebawah jika pesanan banyak
        scroll = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(0, 0, 610, 1500);
        panel.setPreferredSize(new Dimension(0, spaceAntarText + 290));
        this.add(scroll);

        //JFrame
        //this.add(panel);
        panel.setLayout(null);
        //
        this.setSize(610, 950);
        //this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Pembayaran();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            //cek saldo cukup ngga
            if (cs.getSaldo() >= totalBayar) {
                JPasswordField pwd = new JPasswordField();
                int action = JOptionPane.showConfirmDialog(null, pwd, "Enter Password", JOptionPane.OK_CANCEL_OPTION);
                if (action == JOptionPane.YES_OPTION) {
                    //cek password
                    if (cs.getPassword().equals(new String(pwd.getPassword()))) {
                        cs.setSaldo(cs.getSaldo() - totalBayar);
                        //looping sebanyak berapa pesanan yang dibuat, keknya kurang quantity nanti dipikirinlagi zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
                        //zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
                        for (int i = 0; i < 3; i++) {
                            CustomerFunction.insertHistoryTransaction(cs.getId(), 1, voucher.getId());
                            System.out.println("masok 1");
                        }
                        ArrayList<Transaction> trans = GlobalFunction.getHistoryTransaction();
                        ArrayList<Transaction> transreverse = new ArrayList();

                        //reverse arraylist untuk ambil transaksi terakhir
                        for (int i = 3; i > 0; i--) {
                            transreverse.add(trans.get(i - 1));
                        }
                        for (int j = 0; j < 3; j++) {
                            CustomerFunction.insertDetailHistoryTransaction(transreverse.get(j).getId(), items.get(j).getId(), qty.get(j));
                        }

                        JOptionPane.showMessageDialog(null, "<html>Order successful<br>Your order is being processed ^-^</html>", "Payment", JOptionPane.INFORMATION_MESSAGE);
                        new MainMenuCustomer();
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Password", "Payment", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient balance", "Payment", JOptionPane.ERROR_MESSAGE);
                new MainMenuCustomer();
            }
            //Cek saldo
            //Konfirmasi passsword
            //JOptionPane berhasil
            //ke status pesanan
            //jika selesai add ke riwayat pembelian
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        lDiskon.setText("- " + String.valueOf(voucher.getDiscount()));
        textTotal.setText("Total   :        " + (int) (totalPrice - voucher.getDiscount()));
    }

    @Override
    public void mousePressed(MouseEvent me) {
        lDiskon.setText("- " + String.valueOf(voucher.getDiscount()));
        textTotal.setText("Total   :        " + (int) (totalPrice - voucher.getDiscount()));
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        lDiskon.setText("- " + String.valueOf(voucher.getDiscount()));
        textTotal.setText("Total   :        " + (int) (totalPrice - voucher.getDiscount()));
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        lDiskon.setText("- " + String.valueOf(voucher.getDiscount()));
        textTotal.setText("Total   :        " + (int) (totalPrice - voucher.getDiscount()));
    }

    @Override
    public void mouseExited(MouseEvent me) {
        lDiskon.setText("- " + String.valueOf(voucher.getDiscount()));
        textTotal.setText("Total   :        " + (int) (totalPrice - voucher.getDiscount()));
    }
}
