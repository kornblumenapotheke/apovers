

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeChecker extends Thread{
	boolean abort = false;
	Statusbox statusbox;
	
	TimeChecker (Statusbox inStatusbox){
		statusbox = inStatusbox;
	}
		
	
	public void run(){
	      
		  while (!abort)
		  {
			  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			  Calendar cal = Calendar.getInstance();  
			  statusbox.setTime(dateFormat.format(cal.getTime()));
		  			  
			  try {
				this.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }

	}
}