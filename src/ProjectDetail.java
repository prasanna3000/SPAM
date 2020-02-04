
//import static LoginForm.wl;
//import static LoginForm.wl;
//import static MenuDemo.wl;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class ProjectDetail extends Frame implements ActionListener{
    ImageIcon a;
   static WindowListener wl;
 
    public static void main(String args[])
    {
        new ProjectDetail();
            wl =new WindowAdapter(){
     public void windowClosing(WindowEvent e)
         {
             System.exit(0);
         }  
    };

    }
    Label l1,l2,l3,l4;
    TextField t1,t2,t3,t4;
    Button b1,b2;
    ProjectDetail()
    {
        this.setVisible(true);
        // this.setSize(460, 600);
         this.setTitle("ProjectDetail");
     // setBackground(Color.DARK_GRAY);
       // setForeground(Color.WHITE);
         this.setLayout(null);
         Font f=new Font("Comic Sans",Font.BOLD,15);
         this.setFont(f);
         this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e)
         {
                dispose();  
         }  
     });
        l1=new Label("Project ID",Label.CENTER); 
        t1=new TextField(5);
        l2=new Label("Faculty ID",Label.CENTER); 
        t2=new TextField(10);
        l3=new Label("Name of the Project",Label.CENTER); 
        t3=new TextField(20);
        l4=new Label("Type of the Project",Label.CENTER); 
        t4=new TextField(10);
        b1= new Button("Cancel");
        b2= new Button("Submit");
        l1.setBounds(50,90,160, 30);
        l2.setBounds(50,140,160, 30);
        l3.setBounds(50,200,160, 30);
        l4.setBounds(50,260,160, 30);
        t1.setBounds(250,90,120, 30);
        t2.setBounds(250,140,120, 30);
        t3.setBounds(250,200,120, 30);
        t4.setBounds(250,260,120, 30);
        b1.setBounds(70,340 ,120,30);
        b2.setBounds(240,340 ,120,30);
         a=new ImageIcon("h14.jpg");
    setSize(706,600);
    //setLocation(null);
    setVisible(true);
    addWindowListener(wl);
   
               t1.setEchoChar('*');
       t2.setEchoChar('*');

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(b1);
        add(b2);
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
        String  Pid=t1.getText();
      String  Fid=t2.getText();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql:///javaproject","root","vignan");
            pstmt=conn.prepareStatement("select * from Project where Pid=? and Fid=? ");
            pstmt.setString(1,Pid);
           pstmt.setString(2,Fid);
            rs=pstmt.executeQuery();
            while(rs.next()){
               // t2.setText(rs.getString("Fid"));
                t3.setText(rs.getString("Pname"));
                t4.setText(rs.getString("Ptype"));
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
                    JOptionPane.showMessageDialog(null, e);
        }
    }
}
         else if(str.equals("Cancel"))
         {
             t1.setText(" ");
             t2.setText(" ");
             t3.setText(" ");
             t4.setText(" ");
         }
         
}
}
   
