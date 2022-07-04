package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.awt.Color.yellow;

public class login extends JFrame implements ActionListener {
    private final JFrame frame;
    private final JTextField textField;
    private final JPasswordField passwordField;
    private JLabel l1,l2;
    private JButton b1,b2,b3;
    Container c;
    public login(){

        frame = new JFrame() ;
        textField = new JTextField();
        passwordField = new JPasswordField();
        l1 = new JLabel();
        l2 = new JLabel();


        frame.setBounds(80,80,500,400);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setTitle("Library");
        Container c = frame.getContentPane();
        c.setBackground(Color.GRAY);
        c.setLayout(null);

        l1.setText("Username---->>");
        l1.setBounds(140,110,100,20);
        l1.setForeground(Color.BLUE);
        c.add(l1);

        l2.setText("Password---->>");
        l2.setBounds(140,140,100,20);
        l2.setForeground(Color.BLUE);
        c.add(l2);

        textField.setBounds(250,110,120,20);
        textField.setBackground(Color.WHITE);
        textField.setBorder(null);
        c.add(textField);

        passwordField.setBounds(250,140,120,20);
        passwordField.setBackground(Color.WHITE);
        passwordField.setBorder(null);
        c.add(passwordField);

        b1 = new JButton();
        b1.setBounds(110,200,140,40);
        b1.setBackground(Color.green);
        b1.setText("Login");
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        c.add(b1);

        b2 = new JButton();
        b2.setBounds(280,200,140,40);
        b2.setBackground(yellow);
        b2.setText("Signup");
        b2.setForeground(Color.black);
        b2.addActionListener(this);
        c.add(b2);

        b3 = new JButton();
        b3.setBounds(190,270,140,40);
        b3.setBackground(Color.RED);
        b3.setText("Forgot Password");
        b3.setForeground(Color.black);
        c.add(b3);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==b1){

            try {
                dbconn con = new dbconn();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    frame.setVisible(false);
                    new Home().setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid Login...!.");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        else if (e.getSource()==b2) {
            Signup s= new Signup();
            frame.setVisible(false);
            s.setVisible(true);}
    }
    public static void main(String[] args) {new login().setVisible(true);}
}
