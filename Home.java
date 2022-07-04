package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Home extends JFrame implements ActionListener {

    private JFrame frame;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8;
    Container c;
    public Home(){
        frame=new JFrame();
        frame.setTitle("home");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setBounds(400,100,500,400);
        c=frame.getContentPane();
        c.setBackground(Color.darkGray);
        frame.setVisible(true);
        c.setLayout(null);

        b1=new JButton("Add Books");
        b1.setBackground(Color.cyan);
        b1.setBounds(70,80,100,40);
        b1.addActionListener(this);
        c.add(b1);

        b2=new JButton("Add Students");
        b2.setBackground(Color.cyan);
        b2.setBounds(190,80,120,40);
        b2.addActionListener(this);
        c.add(b2);

        b3=new JButton("Book Issue");
        b3.setBackground(Color.cyan);
        b3.setBounds(330,80,100,40);
        b3.addActionListener(this);
        c.add(b3);

        b4=new JButton("Book Return");
        b4.setBackground(Color.cyan);
        b4.setBounds(70,150,100,40);
        b4.addActionListener(this);
        c.add(b4);

        b5=new JButton("Student Record");
        b5.setBackground(Color.cyan);
        b5.setBounds(190,150,120,40);
        b5.addActionListener(this);
        c.add(b5);

        b6=new JButton("Book Record");
        b6.setBounds(330,150,100,40);
        b6.setBackground(Color.cyan);
        b6.addActionListener(this);
        c.add(b6);

        b7=new JButton("Statistics");
        b7.setBounds(120,220,120,40);
        b7.setBackground(Color.cyan);
        b7.addActionListener(this);
        c.add(b7);

        b8 = new JButton("Exit");
        b8.setBounds(260,220,120,40);
        b8.setBackground(Color.cyan);
        b8.addActionListener(this);
        c.add(b8);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==b8){
        System.exit(ABORT);}
        else if (e.getSource()==b7) {
            frame.setVisible(false);
          new Statistics().setVisible(true);}
        else if (e.getSource()==b6) {
            frame.setVisible(false);
            new BookDetails().setVisible(true);}
        else if (e.getSource()==b5) {
            frame.setVisible(false);
            new StudentDetails().setVisible(true);}
        else if (e.getSource()==b4) {
            frame.setVisible(false);
           new BookReturn().setVisible(true);}
        else if (e.getSource()==b3) {
            frame.setVisible(false);
            new BookIssue().setVisible(true);}
        else if (e.getSource()==b2) {
            frame.setVisible(false);
            new AddStudent().setVisible(true);}
        else if (e.getSource()==b1) {
            frame.setVisible(false);
            new AddBook().setVisible(true);}
    }
    public static void main(String[] args){ new Home();}}
