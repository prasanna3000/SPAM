
    import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class StudentForm extends Frame implements ActionListener{
    ImageIcon a;
   static WindowListener wl;

    public static void main(String args[])
    {
        new StudentForm();
        
wl =new WindowAdapter(){
     public void windowClosing(WindowEvent e)
         {
             System.exit(0);
         }  
    };

    }
    Label l1,l2,l3,l4,l5,l6,l7,l8;
    TextField t1,t2,t3,t4,t5,t6,t7,t8;
    Button b1,b2;
    StudentForm()
    {
        this.setVisible(true);
        // this.setSize(460, 600);
       //  setBackground(Color.BLUE);
                  this.setTitle("StudentRegister");

           Font f=new Font("Comic Sans",Font.BOLD,15);
         this.setFont(f);
       
         this.setLayout(null);
              
         this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e)
         {
                dispose();  
         }  
     });
        l1=new Label("Name of the User",Label.CENTER); 
        t1=new TextField(20);
        l2=new Label("Branch",Label.CENTER); 
        t2=new TextField(5);
        l3=new Label("Year of Graduation",Label.CENTER); 
        t3=new TextField(5);
        l4=new Label("Password",Label.CENTER); 
        t4=new TextField(10);
        l5=new Label("E-Mail",Label.CENTER); 
        t5=new TextField(25);
        l6=new Label("Phno",Label.CENTER); 
        t6=new TextField(10);
        l7=new Label("Section",Label.CENTER); 
        t7=new TextField(5);
        l8=new Label("Project ID",Label.CENTER); 
        t8=new TextField(10);
        b1= new Button("Cancel");
        b2= new Button("Register");
         l1.setBounds(50,80,150, 30);
        l2.setBounds(50,130,150, 30);
        l3.setBounds(50,180,160, 30);
        l4.setBounds(50,230,160, 30);
        l5.setBounds(50,280,160, 30);
        l6.setBounds(50,330,160, 30);
        l7.setBounds(50,380,160, 30);
        l8.setBounds(50,430,160, 30);
        t1.setBounds(250,80,120, 30);
        t2.setBounds(250,130,120, 30);
        t3.setBounds(250,180,120, 30);
        t4.setBounds(250,230,120, 30);
        t5.setBounds(250,280,120, 30);
        t6.setBounds(250,330,120, 30);
        t7.setBounds(250,380,120, 30);
       // b1.setBounds(60,290 ,120,30);
        t8.setBounds(250,430 ,120,30);
        b1.setBounds(70,500 ,120,30);
        b2.setBounds(240,500 ,120,30);
       t4.setEchoChar('*');
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
        add(l8);
        add(t8);
        add(b1);
        add(b2);
        
   a=new ImageIcon("h11.jpg");
    setSize(706,600);
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
        if(str.equals("Register"))
        {
        String Sid=t4.getText();
        String Sname =t1.getText();
        String Branch=t2.getText();
        String Sec=t7.getText();
        String Syear= t3.getText();
        String Email=t5.getText();
        String Phno=t6.getText();
        String Pid=t8.getText();
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql:///javaproject","root","vignan");
            pstmt=conn.prepareStatement("insert into Student values(?,?,?,?,?,?,?,?)");
            pstmt.setString(1,Sid);
            pstmt.setString(2,Sname);
            pstmt.setString(3,Branch);
            pstmt.setString(4,Sec);
            pstmt.setString(5,Syear);
            pstmt.setString(6,Email);
            pstmt.setString(7,Phno);
            pstmt.setString(8,Pid);
            int i=pstmt.executeUpdate();
            if(i>0)
            {
                JOptionPane.showMessageDialog(null, "Your Data is Saved");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Data not Saved");
            }
        }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
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
           t8.setText(" ");
        }
}
}