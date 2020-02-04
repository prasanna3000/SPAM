
    import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class data extends Frame implements ActionListener{
    public static void main(String args[])
    {
        new data();
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
 
    data()
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
        l7=new Label("Total",Label.CENTER); 
        t7=new TextField(5);
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
        l7.setBounds(70, 410, 120, 30);
        t7.setBounds(230, 410, 120, 30);
       
       // l7=new Label("Total"); 
        //t7=new TextField(10);
        b1= new Button("Cancel");
        b2= new Button("Submit");
        b1.setBounds(60,500,120,30);
        b2.setBounds(230,500,120,30);
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
        add(l7);
        add(t7);
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
       // String Total=t7.getText();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql:///javaproject","root","vignan");
             pstmt=conn.prepareStatement("select * from Marks where Sid=? ");
            pstmt.setString(1,Sid);
            rs=pstmt.executeQuery();
            while(rs.next()){
               // t2.setText(rs.getString("Fid"));
                t2.setText(rs.getString("Pid"));
                t3.setText(rs.getString("Fid"));
                t4.setText(rs.getString("Review1"));
                t5.setText(rs.getString("Review2"));
                t6.setText(rs.getString("Seminarmarks"));
                t7.setText(rs.getString("Total"));
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
