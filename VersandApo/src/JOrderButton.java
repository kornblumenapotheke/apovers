import javax.swing.JButton;

public class JOrderButton extends JButton {

	public JOrderButton(String orderPzn, String orderItem, String orderQuantity) 
		{
		String html = "<html><font color=\"green\">"+orderPzn+"</font> <font size=\"+1\">"+orderItem+"</font> </strong>";
		if (Integer.valueOf(orderQuantity)>1)
			html += "<font color=\"red\">"+orderQuantity+"</font>"+"</html>";
		this.setLabel(html);
	}
	
	

}
