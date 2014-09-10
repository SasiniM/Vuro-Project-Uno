import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

class MainFrame1 extends JFrame implements ActionListener
{
    JMenuBar mbar;
    JMenu m_pers,m_perf,m_pay,m_exit;
    JMenuItem pers_add,pers_edit,pers_del,pers_inq,perf_add,perf_edit,perf_del,perf_inq,pay_add,pay_edit,pay_del,pay_inq,quit;
    
    MainFrame1()
    {
        super("Main Frame");
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screensize);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.pink);
        
        mbar=new JMenuBar();
        setJMenuBar(mbar);
        
        m_pers=new JMenu("Personal");
        mbar.add(m_pers);
        
        m_perf=new JMenu("Performance");
        mbar.add(m_perf);
        
        m_pay=new JMenu("Payment");
        mbar.add(m_pay);
        
        m_exit=new JMenu("Exit");
        mbar.add(m_exit);
        
        pers_add=new JMenuItem("Addition");
        m_pers.add(pers_add);
        pers_add.addActionListener(this);
        
        pers_edit=new JMenuItem("Edit");
        m_pers.add(pers_edit);
        pers_edit.addActionListener(this);
        
        pers_del=new JMenuItem("Deletion");
        m_pers.add(pers_del);
        pers_del.addActionListener(this);
        
        pers_inq=new JMenuItem("Inquiry");
        m_pers.add(pers_inq);
        pers_inq.addActionListener(this);
        
        perf_add=new JMenuItem("Addition");
        m_perf.add(perf_add);
        perf_add.addActionListener(this);
        
        perf_edit=new JMenuItem("Edit");
        m_perf.add(perf_edit);
        perf_edit.addActionListener(this);
        
        perf_del=new JMenuItem("Deletion");
        m_perf.add(perf_del);
        perf_del.addActionListener(this);
        
        perf_inq=new JMenuItem("Inquary");
        m_perf.add(perf_inq);
        perf_inq.addActionListener(this);
        
        pay_add=new JMenuItem("Addition");
        m_pay.add(pay_add);
        pay_add.addActionListener(this);
        
        pay_edit=new JMenuItem("Edit");
        m_pay.add(pay_edit);
        pay_edit.addActionListener(this);
        
        pay_del=new JMenuItem("Delete");
        m_pay.add(pay_del);
        pay_del.addActionListener(this);
        
        pay_inq=new JMenuItem("Inquary");
        m_pay.add(pay_inq);
        pay_inq.addActionListener(this);
        
        quit=new JMenuItem("Quit");
        m_exit.add(quit);
        quit.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object oop=e.getSource();
        
        if(oop==pers_add)
        {
            Pers_Add add=new Pers_Add();
            add.show();
        }
        
        else if(oop==pers_edit)
        {
            Pers_Edit edit=new Pers_Edit();
            edit.show();
        }
        
        else if(oop==pers_del)
        {
            Pers_Delete del=new Pers_Delete();
            del.show();
        }
        else  if(oop==pers_inq)
        {
            Pers_Inq inq=new Pers_Inq();
            inq.show();
        }
        
        else if(oop==perf_add)
        {
            Perf_Add add=new Perf_Add();
            add.show();
        }
        
        else if(oop==perf_edit)
        {
            Perf_Edit edit=new Perf_Edit();
            edit.show();
        }
         
        else  if(oop==perf_del)
        {
            Perf_Delete del=new Perf_Delete();
            del.show();
        }
        
         else  if(oop==perf_inq)
        {
            Perf_Inq inq=new Perf_Inq();
            inq.show();
        }
        
        else  if(oop==pay_add)
        {
            Pay_Add add=new Pay_Add();
            add.show();
        }
        
        else  if(oop==pay_edit)
        {
            Pay_Edit edit=new Pay_Edit();
            edit.show();
        }
        
        else  if(oop==pay_del)
        {
            Pay_Delete add=new Pay_Delete();
            add.show();
        }
        
        else  if(oop==pay_inq)
        {
            Pay_Inq add=new Pay_Inq();
            add.show();
        }
        
        else if(oop==quit)
        {
            int confirm=JOptionPane.showConfirmDialog(null,"Do you want to exit","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

           if (confirm==JOptionPane.YES_OPTION) 
          {            
          System.exit(0);
               }
           else
           {
               this.show();
           }
        }
    }
    
    public static void main(String args[])
    {
        MainFrame1 mf1=new MainFrame1();
        mf1.show();
    }
}
