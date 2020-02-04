
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
public class mdata extends Frame {
    public static void main(String args[]) throws SQLException
    {
        new mdata();
    }
    mdata()
    {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        String s;
        try{
          //  Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql:///javaproject","root","vignan");
            st=conn.createStatement();
            s="select * from  Marks";
            rs=st.executeQuery(s);
            ResultSetMetaData rsmt=rs.getMetaData();
            int c=rsmt.getColumnCount();
            Vector column=new Vector(c);
            for(int i=1;i<=c;i++)
            {
               column.add(rsmt.getColumnName(i)); 
            }
            Vector data=new Vector();
            Vector row= new Vector();
            while(rs.next())
            {
                row=new Vector(c);
                for(int i=1;i<=c;i++)
                {
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            JFrame frame=new JFrame();
            frame.setSize(500, 120);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel=new JPanel();
            JTable table=new JTable(data,column);
	JScrollPane jsp=new JScrollPane(table);	
        panel.setLayout(new BorderLayout());
        panel.add(jsp,BorderLayout.CENTER);
        frame.setContentPane(panel);
        frame.setVisible(true);
     }
catch(Exception e){
                    JOptionPane.showMessageDialog(null, "ERROR");
                    System.out.println(e);
                    }
        finally{
            try{
                conn.close();
                st.close();
                rs.close();
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR");

        }
    }
}
}
   
