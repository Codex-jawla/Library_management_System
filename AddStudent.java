package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {

    private JFrame frame;
    private JButton b1,b2;
    private JLabel l1,l2,l3,l4,l5,l6,l7;
    private JTextField t1,t2,t3,t4,t5,t6,t7;
    private Random r=new Random();

    public AddStudent(){
        frame=new JFrame("AddStudent");
        frame.setBounds(80,80,500,400);
        Container c=frame.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.darkGray);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        l1=new JLabel();
        l1.setText("Student_id :");
        l1.setBounds(100,70,100,20);
        l1.setForeground(Color.BLUE);
        c.add(l1);

        l2=new JLabel();
        l2.setText("Name :");
        l2.setBounds(100,100,100,20);
        l2.setForeground(Color.BLUE);
        c.add(l2);

        l3=new JLabel();
        l3.setText("Father Name :");
        l3.setBounds(100,130,100,20);
        l3.setForeground(Color.BLUE);
        c.add(l3);

        l4=new JLabel();
        l4.setText("Course :");
        l4.setBounds(100,160,120,20);
        l4.setForeground(Color.BLUE);
        c.add(l4);

        l5=new JLabel();
        l5.setText("Branch :");
        l5.setBounds(100,190,100,20);
        l5.setForeground(Color.BLUE);
        c.add(l5);

        l6=new JLabel();
        l6.setText("Year :");
        l6.setBounds(100,220,100,20);
        l6.setForeground(Color.BLUE);
        c.add(l6);

        l7=new JLabel();
        l7.setText("Semester :");
        l7.setBounds(100,250,100,20);
        l7.setForeground(Color.BLUE);
        c.add(l7);

        t1=new JTextField();
        t1.setText(" "+r.nextInt(1,10000));
        t1.setBounds(260,70,120,20);
        t1.setBackground(Color.WHITE);
        c.add(t1);

        t2=new JTextField();
        t2.setBounds(260,100,120,20);
        t2.setBackground(Color.WHITE);
        c.add(t2);

        t3=new JTextField();
        t3.setBounds(260,130,120,20);
        t3.setBackground(Color.WHITE);
        c.add(t3);

        t4=new JTextField();
        t4.setBounds(260,160,120,20);
        t4.setBackground(Color.WHITE);
        c.add(t4);

        t5=new JTextField();
        t5.setBounds(260,190,120,20);
        t5.setBackground(Color.WHITE);
        c.add(t5);

        t6=new JTextField();
        t6.setBounds(260,220,120,20);
        t6.setBackground(Color.WHITE);
        c.add(t6);

        t7=new JTextField();
        t7.setBounds(260,250,120,20);
        t7.setBackground(Color.WHITE);
        c.add(t7);

        b2=new JButton("Add Student");
        b2.setBounds(100,290,130,40);
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        c.add(b2);

        b1=new JButton("Back");
        b1.setBounds(270,290,120,40);
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.addActionListener( this);
        c.add(b1);

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try {
            dbconn con=new dbconn();
            if (ae.getSource() == b1) {
                frame.setVisible(false);
                Home h = new Home();
                h.setVisible(true);
            } else if (ae.getSource() == b2) {
                String sql = "insert into student(student_id, name, father_name,course, branch, year,semester) values(?,?, ?, ?, ?, ?, ?)";
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
                    JOptionPane.showMessageDialog(null, "Successfully Added");
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

    public static void main(String[] args) {new AddStudent();}
}
