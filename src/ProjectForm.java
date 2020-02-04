
    import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class ProjectForm extends Frame implements ActionListener{
    ImageIcon a;
   static WindowListener wl;
 
    public static void main(String args[])
    {
        new ProjectForm();
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
    ProjectForm()
    {
        this.setVisible(true);
         //this.setSize(460, 600);
        // setBackground(Color.ORANGE);
         this.setLayout(null);
                  this.setTitle("ProjectForm");
          Font f=new Font("Comic Sans",Font.BOLD,15);
         this.setFont(f);
         this.addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent e)
         {
                dispose();  
         }  
     });
        l1=new Label("Name of the Project",Label.CENTER); 
        t1=new TextField(20);
        l2=new Label("Type fo the Project",Label.CENTER); 
        t2=new TextField(10);
        l3=new Label("Project ID",Label.CENTER); 
        t3=new TextField(5);
        l4=new Label("Faculty ID",Label.CENTER); 
        t4=new TextField(10);
        b1= new Button("Cancel");
        b2= new Button("Register");
         l1.setBounds(50,80,160, 30);
        l2.setBounds(50,140,160, 30);
        l3.setBounds(50,200,160, 30);
        l4.setBounds(50,260,160, 30);
        t1.setBounds(250,80,120, 30);
        t2.setBounds(250,140,120, 30);
        t3.setBounds(250,200,120, 30);
        t4.setBounds(250,260,120, 30);
        b1.setBounds(80,340 ,120,30);
        b2.setBounds(240,340 ,120,30);
            t3.setEchoChar('*');
         t4.setEchoChar('*');
         a=new ImageIcon("h16.jpg");
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
        if(str.equals("Register"))
        {
        String Pid=t3.getText();
        String Pname =t1.getText();
        String Ptype=t2.getText();
        String Fid=t4.getText();
        Connection conn=null;
        PreparedStatement pstmt=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql:///javaproject","root","vignan");
            pstmt=conn.prepareStatement("insert into Project values(?,?,?,?)");
            pstmt.setString(1,Pid);
            pstmt.setString(2,Pname);
            pstmt.setString(3,Ptype);
            pstmt.setString(4,Fid);
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
        }
}
}
