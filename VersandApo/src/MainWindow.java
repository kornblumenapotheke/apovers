import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame
{
	private Statusbox statusbox = new Statusbox();
	private OrdersBox ordersbox = new OrdersBox();

	MainWindow()
	{
		this.setLayout(new BorderLayout());
		this.add(statusbox,BorderLayout.SOUTH);
		this.add(ordersbox,BorderLayout.NORTH);
		this.setSize(500, 500);
        this.setVisible(true);
        
        new ConnectionChecker(getStatusbox()).start(); //verknüpfe Verbindungschecker mit Button
        new NewOrdersChecker (getStatusbox()).start();
        new TimeChecker(getStatusbox()).start();
        new OrdersChecker (getOrdersBox()).start();
        
	}
	
	
	
	public Statusbox getStatusbox()
	{
		return statusbox;
	}
	
	public OrdersBox getOrdersBox()
	{
		return ordersbox;
	}
	
}
