package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame {

    PickUp(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,590);
        panel.setBackground(new Color(8,44,99));
        panel.setLayout(null);
        add(panel);

        JLabel pus = new JLabel("Pick Up Service");
        pus.setBounds(90,11,160,25);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(pus);

        JLabel toc = new JLabel("Type of Car");
        toc.setBounds(32,97,89,14);
        toc.setForeground(Color.WHITE);
        toc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(toc);

        Choice c = new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);

        try{

            con C = new con();
            ResultSet resultSet = C.statement.executeQuery("select * from driver");
            while(resultSet.next()){
                c.add(resultSet.getString("carname"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(new Color(8,44,99));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            con C = new con();
            String q = "select * from driver";
            ResultSet resultSet = C.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(24,208,46,14);
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(165,208,46,14);
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(264,208,46,14);
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel company = new JLabel("Company");
        company.setBounds(366,208,100,14);
        company.setForeground(Color.WHITE);
        panel.add(company);

        JLabel carName = new JLabel("Car Name");
        carName.setBounds(486,208,100,14);
        carName.setForeground(Color.WHITE);
        panel.add(carName);

        JLabel available = new JLabel("Available");
        available.setBounds(600,208,100,14);
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel location = new JLabel("Location");
        location.setBounds(700,208,100,14);
        location.setForeground(Color.WHITE);
        panel.add(location);

        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where carname = '"+c.getSelectedItem()+"'";
                try{
                    con c = new con();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(420,500,120,30);
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
        setLocation(500,100);
        setSize(800,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PickUp();
    }
}
