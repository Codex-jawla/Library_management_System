package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookReturn extends JFrame implements ActionListener {

    private JFrame frame;
    private JButton b1,b2,b3;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8;

    public void delete() {
        try {
            dbconn con = new dbconn();
            String sql = "delete from issueBook where b_id=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, t1.getText());
            int i = st.executeUpdate();
            if (i > 0)
                JOptionPane.showConfirmDialog(null, "Book Returned");
            else
                JOptionPane.showMessageDialog(null, "error in Deleting");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
public BookReturn(){

    frame=new JFrame();
    frame.setBounds(400,100,700,400);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    frame.setTitle("Return Book");
    Container c=frame.getContentPane();
    c.setLayout(null);

    l1=new JLabel();
    l1.setText("Book_id ");
    l1.setFont(new Font("Tahoma", Font.BOLD, 14));
    l1.setBounds(70,70,100,20);
    l1.setForeground(Color.BLACK);
    c.add(l1);

    l2=new JLabel();
    l2.setText("Book");
    l2.setFont(new Font("Tahoma", Font.BOLD, 14));
    l2.setBounds(70,120,100,20);
    l2.setForeground(Color.BLACK);
    c.add(l2);

    l3=new JLabel();
    l3.setText("Semester");
    l3.setFont(new Font("Tahoma", Font.BOLD, 14));
    l3.setBounds(70,170,100,20);
    l3.setForeground(Color.BLACK);
    c.add(l3);

    l4=new JLabel();
    l4.setText("Date of Issue");
    l4.setFont(new Font("Tahoma", Font.BOLD, 14));
    l4.setBounds(70,220,120,20);
    l4.setForeground(Color.BLACK);
    c.add(l4);

    l5=new JLabel();
    l5.setText("Date of Return");
    l5.setFont(new Font("Tahoma", Font.BOLD, 14));
    l5.setBounds(70,270,120,20);
    l5.setForeground(Color.BLACK);
    c.add(l5);

    t1=new JTextField();
    t1.setBounds(160,70,120,20);
    t1.setBackground(Color.WHITE);
    c.add(t1);

    t3=new JTextField();
    t3.setBounds(160,120,120,20);
    t3.setBackground(Color.WHITE);
    c.add(t3);

    t5=new JTextField();
    t5.setBounds(160,170,120,20);
    t5.setBackground(Color.WHITE);
    c.add(t5);

    t7=new JTextField();
    t7.setBounds(190,220,120,20);
    t7.setBackground(Color.WHITE);
    c.add(t7);

    t8=new JTextField();
    t8.setBounds(190,270,120,20);
    t8.setBackground(Color.WHITE);
    c.add(t8);

    l6=new JLabel();
    l6.setText("Student id");
    l6.setFont(new Font("Tahoma", Font.BOLD, 14));
    l6.setBounds(300,70,120,20);
    l6.setForeground(Color.BLACK);
    c.add(l6);

    l7=new JLabel();
    l7.setText("Name");
    l7.setFont(new Font("Tahoma", Font.BOLD, 14));
    l7.setBounds(300,120,120,20);
    l7.setForeground(Color.BLACK);
    c.add(l7);

    l8=new JLabel();
    l8.setText("Branch");
    l8.setFont(new Font("Tahoma", Font.BOLD, 14));
    l8.setBounds(300,170,120,20);
    l8.setForeground(Color.BLACK);
    c.add(l8);

    t2=new JTextField();
    t2.setBounds(400,70,120,20);
    t2.setBackground(Color.WHITE);
    c.add(t2);

    t4=new JTextField();
    t4.setBounds(400,120,120,20);
    t4.setBackground(Color.WHITE);
    c.add(t4);

    t6=new JTextField();
    t6.setBounds(400,170,120,20);
    t6.setBackground(Color.WHITE);
    c.add(t6);

//    b1=new JButton("Search");
//    b1.setBackground(Color.black);
//    b1.setForeground(Color.WHITE);
//    b1.setBounds(540,60,120,30);
//    b1.addActionListener(this);
//    c.add(b1);

    b2=new JButton("Return");
    b2.setBackground(Color.black);
    b2.setForeground(Color.WHITE);
    b2.setBounds(400,220,120,30);
    b2.addActionListener(this);
    c.add(b2);

    b3=new JButton("Back");
    b3.setBackground(Color.black);
    b3.setForeground(Color.WHITE);
    b3.setBounds(400,270,120,30);
    b3.addActionListener(this);
    c.add(b3);

frame.setVisible(true);
}
public void actionPerformed(ActionEvent ae){
    try{
        dbconn con = new dbconn();
//        if(ae.getSource() == b1){
//            String sql = "select * from issueBook where student_id = ? and book_id =?";
//            PreparedStatement st = con.c.prepareStatement(sql);
//            st.setString(1, t2.getText());
//            st.setString(2, t1.getText());
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//                t3.setText(rs.getString("bname"));
//                t4.setText(rs.getString("sname"));
//                t5.setText(rs.getString("course"));
//                t6.setText(rs.getString("branch"));
//                t7.setText(rs.getString("dateOfIssue"));
//            }
//            st.close();
//            rs.close();

//        }
        if(ae.getSource() == b2){
            String sql = "insert into returnbook(b_id, s_id, bname, sname,semester, branch, dateOfIssue, dateOfReturn) values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, t1.getText());
            st.setString(2, t2.getText());
            st.setString(3, t3.getText());
            st.setString(4, t4.getText());
            st.setString(5, t5.getText());
            st.setString(6, t6.getText());
            st.setString(7, t7.getText());
            st.setString(8, t8.getText());

            int i = st.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Processing..");
                delete();
            } else
                JOptionPane.showMessageDialog(null, "error");

        }
        if(ae.getSource() == b3){
            frame.setVisible(false);
            new Home().setVisible(true);

        }
    }catch(Exception e){

    }
}

    public static void main(String[] args) {new BookReturn();}
}
