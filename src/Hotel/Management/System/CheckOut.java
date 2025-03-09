package Hotel.Management.System;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {

    CheckOut(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(8,44,99));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-Out");
        label.setBounds(100,20,150,30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(label);

        JLabel UserId = new JLabel("Customer Id:");
        UserId.setBounds(30,80,150,30);
        UserId.setForeground(Color.WHITE);
        UserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(UserId);

        Choice Customer = new Choice();
        Customer.setBounds(200,80,150,25);
        panel.add(Customer);

        JLabel roomNum = new JLabel("Room Number:");
        roomNum.setBounds(30,130,150,30);
        roomNum.setForeground(Color.WHITE);
        roomNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(roomNum);

        JLabel labelRoomnumber = new JLabel();
        labelRoomnumber.setBounds(200,130,150,30);
        labelRoomnumber.setForeground(Color.WHITE);
        labelRoomnumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelRoomnumber);

        JLabel checkintime = new JLabel("Check-In Time:");
        checkintime.setBounds(30,180,150,30);
        checkintime.setForeground(Color.WHITE);
        checkintime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(checkintime);

        JLabel labelcheckintime = new JLabel();
        labelcheckintime.setBounds(200,180,200,30);
        labelcheckintime.setForeground(Color.WHITE);
        labelcheckintime.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelcheckintime);

        JLabel checkouttime = new JLabel("Check-Out Time:");
        checkouttime.setBounds(30,230,150,30);
        checkouttime.setForeground(Color.WHITE);
        checkouttime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(checkouttime);

        Date date = new Date();

        JLabel labelcheckouttime = new JLabel(""+date);
        labelcheckouttime.setBounds(200,230,200,30);
        labelcheckouttime.setForeground(Color.WHITE);
        labelcheckouttime.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(labelcheckouttime);

        try{
            con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");

            while(resultSet.next()){
                Customer.add(resultSet.getString("number"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        JButton checkOut = new JButton("Check-Out");
        checkOut.setBounds(30,300,120,30);
        checkOut.setBackground(Color.BLACK);
        checkOut.setForeground(Color.WHITE);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con cv = new con();
                    cv.statement.executeUpdate("delete from customer where number = '"+Customer.getSelectedItem()+"'");
                    cv.statement.executeUpdate("update room set availability = 'Available' where roomnumber  = '"+labelRoomnumber.getText()+"'");

                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con c = new con();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select * from customer where number = '"+Customer.getSelectedItem()+"'");

                    while(resultSet.next()){
                        labelRoomnumber.setText(resultSet.getString("room"));
                        labelcheckintime.setText(resultSet.getString("checkintime"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setLayout(null);
        setLocation(500,210);
        setSize(800,400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
