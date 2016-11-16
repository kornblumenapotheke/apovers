import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionChecker extends Thread {
	
	Statusbox statusbox;
	boolean abort = false;
	ConnectionChecker (Statusbox instatusbox) //Dorthin werden die ergebnisse gespiegelt
	{
		statusbox = instatusbox;
		
	}
	  public void run(){
	      
		  while (!abort)
		  {
			  if (isConnected())
		    	  statusbox.setConnected(2);
		      else 
		    	  statusbox.setConnected(0);
		      
			  try {
				this.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	}
	  
	private boolean isConnected() {
		
		String strUrl = "http://www.meineapo.at";

	    try {
	        URL url = new URL(strUrl);
	        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
	        urlConn.connect();

	        if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK)
	        	return true;
	        return false;
	    } catch (IOException e) {
	        return false;
	    }
	}
	  

}
