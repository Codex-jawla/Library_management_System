package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class BookIssue extends JFrame implements ActionListener {

    private JFrame frame;
    private JLabel l1,l2,l3,l4,l5,l6,l7;
    private JTextField t1,t2,t3,t4,t5,t6,t7;
    private JButton b1,b2;

public BookIssue() {

    frame=new JFrame();
    frame.setBounds(400,100,700,350);
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    frame.setTitle("Issue Book");
    Container c=frame.getContentPane();
    c.setLayout(null);

    l1=new JLabel();
    l1.setText("Book_id ");
    l1.setFont(new Font("Tahoma", Font.BOLD, 14));
    l1.setBounds(70,70,100,20);
    l1.setForeground(Color.BLACK);
    c.add(l1);

    t1=new JTextField();
    t1.setBounds(160,70,70,20);
    t1.setBackground(Color.WHITE);
    c.add(t1);

    l2=new JLabel();
    l2.setText("Book Name");
    l2.setFont(new Font("Tahoma", Font.BOLD, 14));
    l2.setBounds(70,110,100,20);
    l2.setForeground(Color.BLACK);
    c.add(l2);

    t3=new JTextField();
    t3.setBounds(160,110,160,20);
    t3.setBackground(Color.WHITE);
    c.add(t3);

    l3=new JLabel();
    l3.setText("Date if Issue");
    l3.setFont(new Font("Tahoma", Font.BOLD, 14));
    l3.setBounds(70,150,100,20);
    l3.setForeground(Color.BLACK);
    c.add(l3);

    t7=new JTextField();
    t7.setBounds(190,150,130,20);
    t7.setBackground(Color.WHITE);
    c.add(t7);

    l2=new JLabel();
    l2.setText("Student id");
    l2.setFont(new Font("Tahoma", Font.BOLD, 14));
    l2.setBounds(360,70,100,20);
    l2.setForeground(Color.BLACK);
    c.add(l2);

    t2=new JTextField();
    t2.setBounds(480,70,70,20);
    t2.setBackground(Color.WHITE);
    c.add(t2);


    l4=new JLabel();
    l4.setText("Name ");
    l4.setFont(new Font("Tahoma", Font.BOLD, 14));
    l4.setBounds(360,110,100,20);
    l4.setForeground(Color.BLACK);
    c.add(l4);

    t4=new JTextField();
    t4.setBounds(480,110,160,20);
    t4.setBackground(Color.WHITE);
    c.add(t4);

    l6=new JLabel();
    l6.setText("Branch ");
    l6.setFont(new Font("Tahoma", Font.BOLD, 14));
    l6.setBounds(360,150,100,20);
    l6.setForeground(Color.BLACK);
    c.add(l6);

    t5=new JTextField();
    t5.setBounds(480,150,160,20);
    t5.setBackground(Color.WHITE);
    c.add(t5);

    l7=new JLabel();
    l7.setText("Semester ");
    l7.setFont(new Font("Tahoma", Font.BOLD, 14));
    l7.setBounds(360,190,100,20);
    l7.setForeground(Color.BLACK);
    c.add(l7);


    t6=new JTextField();
    t6.setBounds(480,190,160,20);
    t6.setBackground(Color.WHITE);
    c.add(t6);

    b1=new JButton("Issue");
    b1.setBackground(Color.black);
    b1.setForeground(Color.WHITE);
    b1.setBounds(130,190,150,40);
    b1.addActionListener(this);
    c.add(b1);

    b2=new JButton("Back");
    b2.setBackground(Color.black);
    b2.setForeground(Color.WHITE);
    b2.setBounds(130,250,150,40);
    b2.addActionListener(this);
    c.add(b2);

    frame.setVisible(true);}
    public void actionPerformed(ActionEvent ae){
        try {
            dbconn con=new dbconn();
            if (ae.getSource() == b2) {
                frame.setVisible(false);
                Home h = new Home();
                h.setVisible(true);
            } else if (ae.getSource() == b1) {
                String sql = "insert into issuebook(b_id,s_id, bname, sname,branch,semester,dateOfIssue) values(?,?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, t1.getText());
                st.setString(2, t2.getText());
                st.setString(3, t3.getText());
                st.setString(4, t4.getText());;
                st.setString(5, t5.getText());
                st.setString(6, t6.getText());
                st.setString(7, t7.getText());

                int rs = st.executeUpdate();
                if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Book Issued Successfully");
                else
                    JOptionPane.showMessageDialog(null, "Error");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                st.close();
            }
        }catch (Exception e){
        }
    }



    public static void main(String[] args) {new BookIssue();}
}

//    l4 =new JLabel();
//    l4.setText("Publisher");
//    l4.setFont(new Font("Tahoma", Font.BOLD, 14));
//    l4.setBounds(70,190,100,20);
//    l4.setForeground(Color.BLACK);
//    c.add(l4);

//    l5=new JLabel();
//    l5.setText("Edition");
//    l5.setFont(new Font("Tahoma", Font.BOLD, 14));
//    l5.setBounds(70,230,100,20);
//    l5.setForeground(Color.BLACK);
//    c.add(l5);
//
//    l6=new JLabel();
//    l6.setText("Date of Issue ");
//    l6.setFont(new Font("Tahoma", Font.BOLD, 14));
//    l6.setBounds(70,280,100,20);
//    l6.setForeground(Color.BLACK);
//    c.add(l6);

//    t4=new JTextField();
//    t4.setBounds(160,190,160,20);
//    t4.setBackground(Color.WHITE);
//    t4.setEditable(false);
//    c.add(t4);
//
//    t5=new JTextField();
//    t5.setBounds(160,230,160,20);
//    t5.setBackground(Color.WHITE);
//    t5.setEditable(false);
//    c.add(t5);
//
//    t6=new JTextField();
//    t6.setBounds(190,280,130,20);
//    t6.setBackground(Color.WHITE);
//    c.add(t6);

//    l11=new JLabel();
//    l11.setText("Branch ");
//    l11.setFont(new Font("Tahoma", Font.BOLD, 14));
//    l11.setBounds(360,270,100,20);
//    l11.setForeground(Color.BLACK);
//    c.add(l11);

//    l12=new JLabel();
//    l12.setText("Year ");
//    l12.setFont(new Font("Tahoma", Font.BOLD, 14));
//    l12.setBounds(360,320,100,20);
//    l12.setForeground(Color.BLACK);
//    c.add(l12);

//    l13=new JLabel();
//    l13.setText("Semester ");
//    l13.setFont(new Font("Tahoma", Font.BOLD, 14));
//    l13.setBounds(360,370,100,20);
//    l13.setForeground(Color.BLACK);
//    c.add(l13);

//    t11=new JTextField();
//    t11.setBounds(480,270,160,20);
//    t11.setBackground(Color.WHITE);
//    c.add(t11);
//
//    t12=new JTextField();
//    t12.setBounds(480,320,160,20);
//    t12.setBackground(Color.WHITE);
//    c.add(t12);
//
//    t13=new JTextField();
//    t13.setBounds(480,370,160,20);
//    t13.setBackground(Color.WHITE);
//    c.add(t13);

//    b1=new JButton("Search");
//    b1.setBackground(Color.black);
//    b1.setForeground(Color.WHITE);
//    b1.setBounds(240,67,80,25);
//    b1.addActionListener(this);
//    c.add(b1);
//
//    b2=new JButton("Search");
//    b2.setBackground(Color.black);
//    b2.setForeground(Color.WHITE);
//    b2.setBounds(560,67,80,25);
//    b2.addActionListener(this);
//    c.add(b2);


//    public void actionPerformed(ActionEvent e){
//        try{
//            dbconn con = new dbconn();
//            if(e.getSource() == b1){
//                String sql = "select * from book where book_id = ?";
//                PreparedStatement st = con.c.prepareStatement(sql);
//                st.setString(1, t1.getText());
//                ResultSet rs = st.executeQuery();
//
//                while (rs.next()) {
//                    t2.setText(rs.getString("name"));
//                    t3.setText(rs.getString("author"));
//                    t4.setText(rs.getString("publisher"));
//                    t5.setText(rs.getString("edition"));
//
//                }
//                st.close();
//                rs.close();
//
//            }
//            if(e.getSource() == b2){
//                String sql = "select * from student where student_id = ?";
//                PreparedStatement st = con.c.prepareStatement(sql);
//                st.setString(1, t7.getText());
//                ResultSet rs = st.executeQuery();
//
//                while (rs.next()) {
//                    t8.setText(rs.getString("name"));
//                    t9.setText(rs.getString("father_name"));
//                    t10.setText(rs.getString("course"));
//                    t11.setText(rs.getString("branch"));
//                    t12.setText(rs.getString("year"));
//                    t13.setText(rs.getString("semester"));
//                }
//                st.close();
//                rs.close();
//
//            }
//            if(e.getSource() == b3){
//                try{
//                    String sql = "insert into issueBook(book_id, student_id, bname, sname, course, branch, dateOfIssue) values(?, ?, ?, ?, ?, ?, ?)";
//                    PreparedStatement st = con.c.prepareStatement(sql);
//                    st.setString(1, t1.getText());
//                    st.setString(2, t7.getText());
//                    st.setString(3, t2.getText());
//                    st.setString(4, t8.getText());
//                    st.setString(5, t10.getText());
//                    st.setString(6, t11.getText());
//                    st.setString(7, t6.getText());
//                    int i = st.executeUpdate();
//                    if (i > 0)
//                        JOptionPane.showMessageDialog(null, "Successfully Book Issued..!");
//                    else
//                        JOptionPane.showMessageDialog(null, "error");
//                }catch(Exception e1){
//                    e1.printStackTrace();
//                }
//            }
//            if(e.getSource() == b4){
//                frame.setVisible(false);
//                new Home().setVisible(true);
//
//            }
//
//            con.c.close();
//        }catch(Exception e2){
//
//        }
//    }



