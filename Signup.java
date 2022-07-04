package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class Signup extends JFrame implements ActionListener {
   private JFrame frame;
   private Container c;
   private JButton b,b1;
   private JLabel l1,l2,l3,l4,l5;
   private JTextField txt1,txt2,txt3,txt4;
   private JComboBox cb;


    public Signup(){
        frame=new JFrame("signup");
        frame.setBounds(80,80,500,400);
        frame.setBackground(Color.GRAY);
        Container c=frame.getContentPane();
        c.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        l1=new JLabel();
        l1.setText("Username  -->>");
        l1.setBounds(100,70,100,20);
        l1.setForeground(Color.BLUE);
        c.add(l1);

        l2=new JLabel();
        l2.setText("Name  -->>");
        l2.setBounds(100,100,100,20);
        l2.setForeground(Color.BLUE);
        c.add(l2);

        l3=new JLabel();
        l3.setText("Password  -->>");
        l3.setBounds(100,130,100,20);
        l3.setForeground(Color.BLUE);
        c.add(l3);

        l4=new JLabel();
        l4.setText("Security Qusetion  ");
        l4.setBounds(100,160,120,20);
        l4.setForeground(Color.BLUE);
        c.add(l4);

        l5=new JLabel();
        l5.setText("Answer  -->>");
        l5.setBounds(100,190,100,20);
        l5.setForeground(Color.BLUE);
        c.add(l5);

        txt1=new JTextField();
        txt1.setBounds(260,70,120,20);
        txt1.setBackground(Color.WHITE);
        c.add(txt1);

        txt2=new JTextField();
        txt2.setBounds(260,100,120,20);
        txt2.setBackground(Color.WHITE);
        c.add(txt2);

        txt3=new JTextField();
        txt3.setBounds(260,130,120,20);
        txt3.setBackground(Color.WHITE);
        c.add(txt3);

        txt4=new JTextField();
        txt4.setBounds(260,190,120,20);
        txt4.setBackground(Color.WHITE);
        c.add(txt4);

        cb=new JComboBox();
        cb.setModel(new DefaultComboBoxModel(new String[] { "Your NickName?", "Your Lucky Number?",
                "Your child SuperHero?", "Your childhood Name ?" }));
        cb.setBounds(260,160,120,20);
        c.add(cb);

         b=new JButton("Create");
        b.setBounds(100,230,100,40);
        b.addActionListener(this);
        c.add(b);

         b1=new JButton("Back");
        b1.setBounds(240,230,100,40);
        b1.addActionListener(this);
        c.add(b1);


        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
try{
        dbconn con = new dbconn();
        if (e.getSource()==b){
            String sql = "insert into account(username, name, password, sec_q, sec_ans) values(?, ?, ?, ?, ?)";
            PreparedStatement st = con.c.prepareStatement(sql);

            st.setString(1, txt1.getText());
            st.setString(2, txt2.getText());
            st.setString(3, txt3.getText());
            st.setString(4, (String) cb.getSelectedItem());
            st.setString(5, txt4.getText());

            int i = st.executeUpdate();
            if (i > 0){
                JOptionPane.showMessageDialog(null, "successfully Created");
            }

            txt1.setText("");
            txt2.setText("");
            txt3.setText("");
            txt4.setText("");}
        else if (e.getSource()==b1) {
            frame.setVisible(false);
            login l=new login();
            l.setVisible(true);
        }
    }catch (Exception e1) {
}
    }
    
    public static void main(String[] args) {
        new Signup();
    }


}
