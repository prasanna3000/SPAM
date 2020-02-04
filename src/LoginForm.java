
import java.awt.Label;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class LoginForm extends Frame implements ActionListener {
    public static void main(String args[]) 
    {
        new LoginForm();
             wl =new WindowAdapter(){
     public void windowClosing(WindowEvent e)
         {
             System.exit(0);
         }  
    };

    }
    Label l1,l2,l3;
    TextField t1,t2;
     ImageIcon a;
   static WindowListener wl;
 
     LoginForm()
     { 
         Font f=new Font("Comic Sans",Font.BOLD,20);
         this.setFont(f);
         this.setVisible(true);
        // this.setSize(460, 600);
        // this.setBackground(Color.DARK_GRAY);
        // setForeground(Color.B+LUE);
         this.setTitle("Login Form");
         this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e)
         {
             dispose();
         }  
     });
  
        this.setLayout(null);
         l1=new Label("User name",Label.CENTER);
         l2=new Label("Password",Label.CENTER);
         t1=new TextField(25);
         t2=new TextField(25);
                t2.setEchoChar('*');

                     Button b1= new Button("Login");
            Button b2= new Button("Cancel");
            Button b3= new Button("New Register");
            add(l1);
            l1.setBounds(100, 100, 120,30);
            add(t1);
            t1.setBounds(270, 100, 140, 30);
            add(l2);
            l2.setBounds(100, 170, 120, 30);
            add(t2);
            t2.setBounds(270, 170, 140, 30);
            add(b1);
            b1.setBounds(120,250, 100,30);
            add(b2);
            b2.setBounds(280, 250, 100, 30);
            add(b3);
            b3.setBounds(180, 320, 140, 30);
             a=new ImageIcon("h4.jpg");
    setSize(706,600);
    //setLocation(null);
    setVisible(true);
    addWindowListener(wl);
   
            b1.addActionListener(this);             
            b2.addActionListener(this);             
            b3.addActionListener(this);             
     }
      public void paint(Graphics g)
  {
      super.paint(g);
      g.drawImage(a.getImage(), 10, 10, this);
  }

     public void actionPerformed(ActionEvent ae)
    {
        String str=ae.getActionCommand();
        if(str.equals("Login"))
        {
        String Fid=t2.getText();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql:///javaproject","root","vignan");
            pstmt=conn.prepareStatement("select * from Faculty where Fid='"+Fid+"' ");
            rs=pstmt.executeQuery();
            if(rs.next())
            {
                new MenuDemo();
               }
            else  JOptionPane.showMessageDialog(null,"Please Enter a Valid UserID and Password" );


        }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"There is no such Entry in the Database" );
                    }
        finally{
            try{
                conn.close();
                pstmt.close();
                rs.close();
            }
            catch(Exception e){
        }
    }

}
        else if(str.equals("New Register"))
        new TeacherForm();
        else if(str.equals("Cancel"))
            t1.setText(" ");
            t2.setText(" ");
}
}