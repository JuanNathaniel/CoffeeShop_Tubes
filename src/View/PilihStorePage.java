package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Store;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;

public class PilihStorePage extends JFrame {

    int storeId = -1;

    public PilihStorePage() {
        this.setTitle("Pilih Lokasi Store");

        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);
        //

        ArrayList<Store> stores = Controller.StoreFunction.getStores();

        for (int i = 0; i < stores.size(); i++) {
            JLabel namaCabang = new JLabel("<html><h1>" + stores.get(i).getCabang() + "</h1>" + stores.get(i).getDeskripsi() + "</html>");
            namaCabang.setFont(new Font("Arial", Font.PLAIN, 17));
            namaCabang.setForeground(Color.white);
            namaCabang.setBounds(20, 90 * i, 250, 70);
            panel.add(namaCabang);
            JLabel idCabang = new JLabel(String.valueOf(stores.get(i).getId()));
            JButton pilihCabang = new JButton("Pilih Cabang Ini");
            pilihCabang.setFont(new Font("Arial", Font.PLAIN, 14));
            pilihCabang.setBounds(450, 90 * i + 20, 150, 50);

            pilihCabang.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    storeId = Integer.parseInt(idCabang.getText() + 1);
                    frame.dispose();
                }
            });
            panel.add(pilihCabang);
        }

        // Back Button
        JButton back = new JButton("Back");
        back.setBounds(20, 90 * stores.size() + 20, 150, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MainMenuCustomer();
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
        this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                frame.dispose();
                new MenuOrder(storeId);
            }
        });
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new PilihStorePage();
    }
}
