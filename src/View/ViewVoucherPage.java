package View;

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

import Controller.VoucherFunction;
import Model.Voucher;

public class ViewVoucherPage extends JFrame{
    String voucherID = null;
    public ViewVoucherPage(double totalPrice){
        this.setTitle("View Voucher");
        
        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);
        //
        
        // Show List Voucher
        ArrayList<Voucher> vouchers = Controller.VoucherFunction.getVouchersList();
        for (int i = 0; i < vouchers.size(); i++) {
            JLabel namaVoucher = new JLabel("<html><h1>" + vouchers.get(i).getName() + "</h1>" + vouchers.get(i).getDesc() + "<br>Discount Rp." + vouchers.get(i).getDiscount() + "<br>Min. Pembelian Rp." + vouchers.get(i).getCondition() + "</html>");
            namaVoucher.setFont(new Font("Arial", Font.PLAIN, 17));
            namaVoucher.setForeground(Color.white);
            namaVoucher.setBounds(20, 130*i, 250, 130);
            panel.add(namaVoucher);
            JLabel idVoucher = new JLabel(String.valueOf(vouchers.get(i).getId()));
            JLabel voucherCond = new JLabel(String.valueOf(vouchers.get(i).getCondition()));
            JButton pilihVoucher = new JButton("Gunakan Voucher Ini");
            pilihVoucher.setFont(new Font("Arial", Font.PLAIN, 14));
            pilihVoucher.setBounds(380, 130*i + 20, 200, 50);
            pilihVoucher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (Double.compare(totalPrice, Double.parseDouble(voucherCond.getText())) < 0){
                    JOptionPane.showMessageDialog(null, "Anda tidak memenuhi minimal pembelian dari voucher!", "Tidak memenuhi min. pembelian", JOptionPane.ERROR_MESSAGE, null);
                }
                else{
                    voucherID = idVoucher.getText();
                    frame.dispose();
                }
            }
        });
            panel.add(pilihVoucher);
        }


        // Back Button
        JButton back = new JButton("Back");
        back.setBounds(20, 130*vouchers.size()+20, 150, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });
        panel.add(back);

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
        new ViewVoucherPage(0);
    }
}
