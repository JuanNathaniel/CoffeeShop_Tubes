/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CustomerFunction;
import static Controller.CustomerFunction.getCustomer;
import Model.Customer;
import Model.EnumMember;
import Model.SingletonUserManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Juan Nathaniel
 */
public class JoinMembershipCustomer extends JFrame implements ActionListener {


    JButton join;

    Customer cs;

    public JoinMembershipCustomer() {
        this.setTitle("Kofi Membership");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame frame = this;
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 650, 950);
        panel.setBackground(Color.gray);
        //
        SingletonUserManager.getInstance().setUser(getCustomer("micel@gmail.com"));
        cs = (Customer) SingletonUserManager.getInstance().getUser();

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

        //Title
        JLabel membersip = new JLabel("<html><b>Membership<hr></html>");
        membersip.setFont(new Font("Arial", Font.BOLD, 25));
        membersip.setForeground(Color.white);
        membersip.setBounds(220, 20, 280, 150);
        panel.add(membersip);
        //
        //Tagline
        JLabel benefitMember = new JLabel("<html><b>Benefits Member<hr><br>"
                + "+ Lifetime member <br>"
                + "+ Discount member up to 40% <br>"
                + "+ Free Coffee at 2AM <br>"
                + "+ Free vouchers <br>"
                + "+ And more. <br><br>"
                + "  Extra buy. Extra Benefits. Only in Kofi Coffee.</html>");
        benefitMember.setFont(new Font("Arial", Font.PLAIN, 20));
        benefitMember.setForeground(Color.white);
        benefitMember.setBounds(20, 195, 280, 200);
        panel.add(benefitMember);

        join = new JButton("Join Membership");
        join.setBounds(100, 420, 390, 50);
        join.setForeground(Color.black);
        join.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(join);
        join.addActionListener(this);
        
        if (cs.getMember() == EnumMember.ISMEMBER) {
            join.setVisible(false);
            //Title
            JLabel infoMemberText = new JLabel("You are already a member :)");
            infoMemberText.setFont(new Font("Arial", Font.BOLD, 25));
            infoMemberText.setForeground(Color.white);
            infoMemberText.setBounds(130, 420, 390, 290);
            panel.add(infoMemberText);
            infoMemberText.setVisible(true);
        }

        //Footer
        JLabel footer = new JLabel("                         Kofi By MJME             Whatsapp CS Kofi : 0817-1717-1717");
        footer.setFont(new Font("Arial", Font.BOLD, 15));
        footer.setForeground(Color.white);
        footer.setBackground(Color.DARK_GRAY);
        footer.setOpaque(true);
        footer.setBounds(0, 820, 610, 90);
        panel.add(footer);

        //JFrame
        this.add(panel);
        panel.setLayout(null);
        //
        this.setSize(610, 950);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == join) {
            JPasswordField pwd = new JPasswordField();
            int confirmPass = JOptionPane.showConfirmDialog(null, pwd, "Enter Password", JOptionPane.INFORMATION_MESSAGE);
            //cek yes or no press
            if (confirmPass == JOptionPane.YES_OPTION) {
                //cek field keisi atau engga
                if (pwd.getText() == null) {
                    JOptionPane.showMessageDialog(null, "Fill the field!", "Membership", JOptionPane.WARNING_MESSAGE);
                }
                //
                if (cs.getPassword().equals(pwd.getText())) {
                    JOptionPane.showMessageDialog(null, "<html>Thankyou for joining us!<br> ^_^</html>", "Membership", JOptionPane.INFORMATION_MESSAGE);
                    CustomerFunction.updateMembership(cs);
                    join.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong password!", "Membership", JOptionPane.WARNING_MESSAGE);
                }
            }

        }
    }
}
