import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Statusbox extends JPanel
{
	JButton auftraege = new JButton("<html><font color=red size=+3>???</font><font color=black size=+1>+???</font></html>");
	JButton connected = new JButton("<html>???</html>");
	JButton time = new JButton ("XX:XX");
	JButton printOrders = new JButton ("Drucken");
	
	Icon smiley0;
	Icon smiley1;
	Icon smiley2;
	
	Statusbox()
	{
		smiley0 = new ImageIcon(getClass().getResource("Smile0.jpeg"));
		smiley1 = new ImageIcon(getClass().getResource("Smile1.jpg"));
		smiley2 = new ImageIcon(getClass().getResource("Smile2.png"));
		this.setLayout(new BorderLayout());
		this.add(auftraege, BorderLayout.EAST);
		this.add(connected, BorderLayout.WEST);
		this.add(time, BorderLayout.CENTER);
		this.add(printOrders,BorderLayout.NORTH);
		setConnected(0);
		setAuftraege (0,0);
	}
	
	public void setAuftraege (int inProcessing, int inPending)
	{
		auftraege.setText("<html><font color=red size=+3>"+inProcessing+"</font><font color=black size=+1>+"+inPending+"</font></html>");
		if (inProcessing+inPending==0)
			auftraege.setBackground(Color.GRAY);
		if (inProcessing+inPending>0)
			auftraege.setBackground(Color.GREEN);
		if (inProcessing+inPending>10)
			auftraege.setBackground(Color.ORANGE);
		if (inProcessing+inPending>20)
			auftraege.setBackground(Color.PINK);
	}
	
	public void setConnected (int status) //0=nix, 1==lange her, 2==OK
	{
		connected.setText("");
		if (status==0)
			connected.setIcon(smiley0);
		if (status==1)
			connected.setIcon(smiley1);
		if (status==2)
			connected.setIcon(smiley2);
		
	}
	
	public void setTime(String inTime)
	{
		time.setText(inTime);
	}
}
