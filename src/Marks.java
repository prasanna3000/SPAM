
    import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Marks extends Frame implements ActionListener{
    public static void main(String args[])
    {
        new Marks();
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
    ImageIcon a;
   static WindowListener wl;
 
    Marks()
    {
        this.setVisible(true);
         //this.setSize(460, 600);
        // setBackground(Color.RED);
         this.setLayout(null);
                  this.setTitle("MarksSheet");

         Font f=new Font("Comic Sans",Font.BOLD,15);
         this.setFont(f);
         this.setForeground(Color.black);
         this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e)
         {
                dispose();  
         }  
     });
        l1=new Label("Student ID",Label.CENTER); 
        t1=new TextField(20);
        l2=new Label("Project ID",Label.CENTER); 
        t2=new TextField(10);
        l3=new Label("Faculty ID",Label.CENTER); 
        t3=new TextField(10);
        l4=new Label("Review-1",Label.CENTER); 
        t4=new TextField(5);
        l5=new Label("Review-2",Label.CENTER); 
        t5=new TextField(10);
        l6=new Label("Seminar Marks",Label.CENTER); 
        t6=new TextField(5);
       l1.setBounds(70, 50, 120, 30);
        t1.setBounds(230, 50, 120, 30);
        l2.setBounds(70, 110, 120, 30);
        t2.setBounds(230, 110, 120, 30);
        l3.setBounds(70, 170, 120, 30);
        t3.setBounds(230, 170, 120, 30);
        l4.setBounds(70, 230, 120, 30);
        t4.setBounds(230, 230, 120, 30);
        l5.setBounds(70, 290, 120, 30);
        t5.setBounds(230, 290, 120, 30);
        l6.setBounds(70, 350, 120, 30);
        t6.setBounds(230, 350, 120, 30);
       // l7=new Label("Total"); 
        //t7=new TextField(10);
        b1= new Button("Cancel");
        b2= new Button("Submit");
        b1.setBounds(60,440,120,30);
        b2.setBounds(230,440,120,30);
         a=new ImageIcon("h17.jpg");
    setSize(706,600);
    //setLocation(null);
    setVisible(true);
    addWindowListener(wl);
   
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
        String Sid=t1.getText();
        String Pid =t2.getText();
        String Fid=t3.getText();
        String R1=t4.getText();
        String R2= t5.getText();
        String R3=t6.getText();
        int To=Integer.parseInt(R1)+Integer.parseInt(R2)+Integer.parseInt(R3);
        String Total=Integer.toString(To);
       // String Total=t7.getText();
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql:///javaproject","root","vignan");
            pstmt=conn.prepareStatement("insert into Marks values(?,?,?,?,?,?,?)");
            pstmt.setString(1,Sid);
            pstmt.setString(2,Pid);
            pstmt.setString(3,Fid);
            pstmt.setString(4,R1);
            pstmt.setString(5,R2);
            pstmt.setString(6,R3);
            pstmt.setString(7,Total);
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
        }
        }
        
    }
