
    import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class TeacherDetail extends Frame implements ActionListener{
    ImageIcon a;
   static WindowListener wl;
    public static void main(String args[])
    {
        new TeacherDetail();
        wl =new WindowAdapter(){
     public void windowClosing(WindowEvent e)
         {
             System.exit(0);
         }  
    };

    }
    Label l1,l2,l3,l4,l5,l6,l7,l8;
    TextField t1,t2,t3,t4,t5,t6,t7;
    Button b1,b2;
    TeacherDetail()
    {
        this.setVisible(true);
        // this.setSize(460, 600);
         //setBackground(Color.PINK);
         this.setLayout(null);
         this.setTitle("TeacherDetail");
              Font f=new Font("Comic Sans",Font.BOLD,15);
         this.setFont(f);

         this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e)
         {
                dispose();  
         }  
     });
        l1=new Label("Password",Label.CENTER); 
        t1=new TextField(10);
        l2=new Label("Name of the User",Label.CENTER); 
        t2=new TextField(20);
        l3=new Label("Designation",Label.CENTER); 
        t3=new TextField(10);
        l4=new Label("Year of teaching",Label.CENTER); 
        t4=new TextField(5);
        l5=new Label("Department",Label.CENTER); 
        t5=new TextField(5);
        l6=new Label("Phno",Label.CENTER); 
        t6=new TextField(10);
        l7=new Label("E-Mail",Label.CENTER); 
        t7=new TextField(20);
        b1= new Button("Cancel");
        b2= new Button("Submit");
        l1.setBounds(50,80,160, 30);
        l2.setBounds(50,140,160, 30);
        l3.setBounds(50,200,160, 30);
        l4.setBounds(50,260,160, 30);
        l5.setBounds(50,320,160, 30);
        l6.setBounds(50,380,160, 30);
        l7.setBounds(50,440,160, 30);
        t1.setBounds(250,80,120, 30);
        t2.setBounds(250,140,120, 30);
        t3.setBounds(250,200,120, 30);
        t4.setBounds(250,260,120, 30);
        t5.setBounds(250,320,120, 30);
        t6.setBounds(250,380,120, 30);
        t7.setBounds(250,440,120, 30);
       // b1.setBounds(60,290 ,120,30);
        b1.setBounds(70,500 ,120,30);
        b2.setBounds(240,500 ,120,30);
           t1.setEchoChar('*');

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(b1);
        add(b2);
         a=new ImageIcon("h10.jpg");
    setSize(700,600);
    //setLocation(null);
    setVisible(true);
    addWindowListener(wl);
  
       b1.addActionListener(this);
       b2.addActionListener(this);
    }
     public void paint(Graphics g)
  {
      super.paint(g);
      g.drawImage(a.getImage(), 10, 10, this);
  }
   
	public void actionPerformed(ActionEvent ae)
    {
        String str=ae.getActionCommand();
        if(str.equals("Submit"))
        {
        String Fid=t1.getText();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql:///javaproject","root","vignan");
            pstmt=conn.prepareStatement("select * from Faculty where Fid=?");
            pstmt.setString(1,Fid);
           
            rs=pstmt.executeQuery();
            while(rs.next()){
                t2.setText(rs.getString("Fname"));
                t3.setText(rs.getString("Designation"));
                t4.setText(rs.getString("Syear"));
                t5.setText(rs.getString("Department"));
                t6.setText(rs.getString("Phno"));
                t7.setText(rs.getString("Email"));                
            }
        }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
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
        else if(str.equals("Cancel"))
        {
            t1.setText(" ");
            t2.setText(" ");
            t3.setText(" ");
            t4.setText(" ");
            t5.setText(" ");
            t6.setText(" ");
            t7.setText(" ");
        }
}
   
}
