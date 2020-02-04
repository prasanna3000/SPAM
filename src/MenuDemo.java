import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
public class MenuDemo extends Frame implements ActionListener
{
  ImageIcon a;
 Label l1;
 Button b,b1;
   static WindowListener wl;
  public MenuDemo()
  {       
    MenuBar mBar = new MenuBar();
    setMenuBar(mBar);  
    Menu s= new Menu("Databases");
    Menu d= new Menu("Search");
    Menu e= new Menu("New");
   Menu exit = new Menu("Exit");
     //ta = new TextArea(10, 40);
     //this.setBackground(Color.cyan); 
   //  this.setSize(852,480);
    this.setVisible(true);
    /*  ImageIcon Image = new ImageIcon("2.jpg"); */
     mBar.add(e);
     mBar.add(s);
     mBar.add(d);
    mBar.add(exit);   // add(l1);
     l1= new Label("Data",Label.CENTER);
     b= new Button("View");
     b1= new Button("Login");
    e.add(new MenuItem("NewStudent"));
    e.add(new MenuItem("NewProject"));
    e.add(new MenuItem("Marks"));
    s.add(new MenuItem("Teacher-Data"));
    s.add(new MenuItem("Student-Data"));
    s.add(new MenuItem("Project-Data"));
    s.add(new MenuItem("Marks-Data"));
    d.add(new MenuItem("Teacher"));
    d.add(new MenuItem("Student"));
    d.add(new MenuItem("Project"));
    exit.add(new MenuItem("Close"));
       l1.setBounds(200,200,80,20);
       b.setBounds(400,200,80,20);
       b1.setBounds(800,200,80,20);

    a=new ImageIcon("h9.jpg");
   setSize(1366,768);
   //setLocation(null);
   setVisible(true);
   addWindowListener(wl);
      add(l1); 
      add(b);
      add(b1);
    e.addActionListener(this);
    s.addActionListener(this);
    d.addActionListener(this);
    b.addActionListener(this);
    b1.addActionListener(this);
    exit.addActionListener(this);
  }
  public void paint(Graphics g)
  {
      super.paint(g);
      g.drawImage(a.getImage(), 0, 0, this);
  }
public void actionPerformed(ActionEvent e)
{
    
    String str = e.getActionCommand();
    if(str.equals("Teacher-Data"))
        new tdata();
    else if(str.equals("Student-Data"))
       new sdata();
    else if(str.equals("Project-Data"))
       new pdata();
    else if(str.equals("Marks-Data"))
       new mdata();
    else if(str.equals("Teacher"))
       new TeacherDetail();
    else if(str.equals("Student"))
       new StudentDetail();
    else if(str.equals("Project"))
       new ProjectDetail();
    else if(str.equals("NewProject"))
       new ProjectForm();
    else if(str.equals("Marks"))
       new Marks();
    else if(str.equals("NewStudent"))
        new StudentForm();
    else if(str.equals("View"))
        new data();
    else if(str.equals("Login"))
        new LoginForm();
    else if(str.equals("Close"))
        System.exit(0);
        
  }
    public static void main(String args[])
  {
    MenuDemo m=new MenuDemo();
     wl =new WindowAdapter(){
     public void windowClosing(WindowEvent e)
         {
             System.exit(0);
         }  
    };
 
  }
}

