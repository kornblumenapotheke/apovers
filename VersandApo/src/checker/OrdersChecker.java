import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JButton;

public class OrdersChecker extends Thread 
{
boolean abort = false;
OrdersBox ordersBox;

	OrdersChecker (OrdersBox inOrdersBox)
	{
		ordersBox = inOrdersBox;
	}

public void run(){
    
	  while (!abort)
	  {
		  //Hier sollte noch gecheckt werden ob eine Änderung vorliegt !!
		  
		  ReadXMLProcessingOrders processingorders = new ReadXMLProcessingOrders ("http://www.meineapo.at/apoconnect/getOrdersStatusProcessed.php");
		  ArrayList buttons = processingorders.getButtons();
		  ordersBox.removeAll();
		  for (int i = 0; i < buttons.size();i++)
			  ordersBox.add((Component) buttons.get(i));
		  try {
			  this.sleep(30000);
		  } catch (InterruptedException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
	  }
}
	
}
