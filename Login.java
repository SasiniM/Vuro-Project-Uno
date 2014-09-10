import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

class Login extends JFrame implements KeyListener

{
JLabel l1,l2;
JTextField t1;
JPasswordField p1;

Connection con;

PreparedStatement ps;
ResultSet rs;
Statement st;

String uname,pword;


Login()
{
super("User  window");
setSize(300,300);
setResizable(false);
setLayout(null);
setLocation(120,130);
getContentPane().setBackground(Color.PINK);
    
Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
Dimension windowsize =getSize();
    
this.setBounds((screensize.width-windowsize.width)/2,(screensize.height-windowsize.height)/2,windowsize.width,windowsize.height); 
    
l1=new JLabel("User Name:");
add(l1);
l1.setBounds(60,100,100,30);
        
l2=new JLabel("Password");
add(l2);
l2.setBounds(60,175,100,30);
        
t1=new JTextField();
add(t1);
t1.setBounds(180,100,100,30);
t1.addKeyListener(this);
        
p1=new JPasswordField();
add(p1);
p1.setEditable(false);
p1.setBounds(180,175,100,30);
p1.addKeyListener(this);
        
try
{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
            
JOptionPane.showMessageDialog(null,"Database Connection Succeeded","Connection Message",JOptionPane.INFORMATION_MESSAGE);                  
}
          
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.INFORMATION_MESSAGE);                     
System.exit(0);//terminate the System
}   
}

public void keyPressed(KeyEvent e)
{
int code=e.getKeyChar();
if(code==10)
if(e.getSource()==t1)
{
onUserNameVal();
}
else if(e.getSource()==p1)
{
onPasswordVal();
}
}
 
public void keyTyped(KeyEvent e)
{
}
    
public void keyReleased(KeyEvent e)
{       
}
     
public void onUserNameVal()
{
uname = t1.getText();
if(uname.equals(""))
{
JOptionPane.showMessageDialog(null,"User Name is not entered","Error",JOptionPane.ERROR_MESSAGE); 
}
else if((uname.trim().length()!=5))
{
JOptionPane.showMessageDialog(null,"User name should have minimum of 5 characters length ","Error",JOptionPane.ERROR_MESSAGE);   
t1.setText("");
}   
else
{
try
{
st=con.createStatement();
rs=st.executeQuery("select*from users where uname='"+uname+"'");
if(!(rs.next()))
{
JOptionPane.showMessageDialog(null,"User does not exits in table","Error",JOptionPane.ERROR_MESSAGE);    
t1.setText("");
t1.requestFocus();
}
else
{
pword=rs.getString(2);	
p1.setEditable(true);
p1.requestFocus();
t1.setEditable(false);
}
}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.INFORMATION_MESSAGE);    
}
}
}
     
public void onPasswordVal()
{
String ppword;
ppword = p1.getText();
if(ppword.equals(""))
{
JOptionPane.showMessageDialog(null,"Password is not entered","Error",JOptionPane.ERROR_MESSAGE); 
}
else if((ppword.trim().length()!=5))
{
JOptionPane.showMessageDialog(null,"Password should have minimum of 5 characters","Error",JOptionPane.ERROR_MESSAGE);   
p1.setText("");
}
else
{
if(!(ppword.equals(pword)))
{
JOptionPane.showMessageDialog(null,"Invalid Password","Error",JOptionPane.ERROR_MESSAGE);            	
p1.setText("");
}
else
{
MainFrame1 mf1=new MainFrame1();
mf1.show();
this.hide();
//System.exit(0);
}
}
} 
     
public void onClear()
{
t1.setText("");
p1.setText("");
                 
t1.setEditable(true);
t1.requestFocus();
}

public void onExit()
{
int confirm=JOptionPane.showConfirmDialog(null, "Do You want To Exit?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);   
if (confirm==JOptionPane.YES_OPTION)
{
System.exit(0);
}
}
  
     
public static void main(String args[])
{
Login uadd=new Login();
uadd.show();
}
}