import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NewOrdersChecker extends Thread {
Statusbox statusbox;
boolean abort = false;
	
	NewOrdersChecker (Statusbox instatusbox) //Dorthin werden die ergebnisse gespiegelt
	{
		statusbox = instatusbox;
		
	}
	  public void run(){
	     
		  while (!abort)
		  {
			  int orderNumber = getOrderNumber();
			  
		  
			  try {
				  this.sleep(10000);
			  } catch (InterruptedException e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			  }
		  }
	  }
	  
	  
	  
	private int  getOrderNumber() {
		
		URL meineapo_getProcessing = null;
		try {
			meineapo_getProcessing = new URL("http://www.meineapo.at/apoconnect/getProcessing.php");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        BufferedReader in;
        String inputLine = null;
        String fullinputLine = "";
		try {
			in = new BufferedReader(
			new InputStreamReader(meineapo_getProcessing.openStream()));
			 
		        while ((inputLine = in.readLine()) != null)
		        	fullinputLine += inputLine;
		            in.close();
		        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -88;
		}
		 ReadXMLNumberProcessingOrders readXMLNumberProcessingOrders = new ReadXMLNumberProcessingOrders("http://www.meineapo.at/apoconnect/getProcessing.php");
		 statusbox.setAuftraege (readXMLNumberProcessingOrders.getNumberProcessing(), readXMLNumberProcessingOrders.getNumberPending());
		 
		
		return -99;
       
		
	}
	  
	
}


