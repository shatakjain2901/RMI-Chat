import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ChatClient extends JFrame implements Runnable
{
	JLabel l1=new JLabel("Name:");
	JLabel l2=new JLabel("Message:");
	JLabel l3=new JLabel("Chat Communication:");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextArea t3=new JTextArea();
	JButton b1=new JButton("Send");
	ChatServerInterface chat;
	ChatClient()
	{
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350,400);
		l1.setBounds(5,5,70,30);add(l1);
		t1.setBounds(75,5,250,30);add(t1);
		l2.setBounds(5,40,70,30);add(l2);
		t2.setBounds(75,40,250,30);add(t2);
		l3.setBounds(5,80,200,30);add(l3);
		b1.setBounds(230,75,95,30);add(b1);
		t3.setBounds(5,110,300,240);add(t3);
		String s=JOptionPane.showInputDialog(this,"Enter Your Name:");
		t1.setText(s);
		t2.requestFocus();
		try{
				Registry r=LocateRegistry.getRegistry("127.0.0.1",1099);
				chat=(ChatServerInterface)r.lookup("CHAT");
		}catch(Exception e){}
		b1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){b1_Click(e);}});
		Thread t=new Thread(this);
		t.start();
	}
	public void run()
	{
		String s1="";
		String nm=t1.getText();
		while(true)
		{
			try{
				String s=chat.getMessage();
				if(!s.equals(s1))
				{
					s1=s;
					if(s1.startsWith(nm))
					{
						t3.setText(t3.getText()+"\r\n          ->"+s);
					}
					else
					{
						t3.setText(t3.getText()+"\r\n"+s);
					}
				}
				Thread.sleep(500);
			}catch(Exception ee){}
		}
	}
	void b1_Click(ActionEvent e)
	{
		try{
				String m=t1.getText()+":"+t2.getText();
				chat.setMessage(m);
				t2.setText(null);
				t2.requestFocus();
		}catch(Exception eE){}
	}
	public static void main(String[] ar)
	{
			new ChatClient().setVisible(true);
	}
}
