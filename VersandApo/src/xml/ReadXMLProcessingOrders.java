import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.swing.JButton;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;


public class ReadXMLProcessingOrders {


	Document document;
	Element root;
	int intProcessing =-99;
	int intPending = -99;
	ArrayList buttons = new ArrayList();
	
	ReadXMLProcessingOrders(String inString) 
	{
		DocumentBuilderFactory factory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			document = builder.parse(inString);
			
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		root = document.getDocumentElement();
		
		NodeList nList = document.getElementsByTagName("order");
		
		
		// Arbeite alle Orders durch
		for (int i = 0; i < nList.getLength();i++)
		{
			Node node = nList.item(i);
			Element eElement = (Element)node;			
			
			eElement.getElementsByTagName("item").getLength();
			for (int j=0;j<eElement.getElementsByTagName("item").getLength();j++)
			{
				String orderItem = eElement.getElementsByTagName("item").item(j).getTextContent();
				String orderQuantity = eElement.getElementsByTagName("quantity").item(j).getTextContent();
				String orderPzn = eElement.getElementsByTagName("pzn").item(j).getTextContent();
			//Erzeuge daraus Button
				buttons.add(new JOrderButton (orderPzn, orderItem, orderQuantity));
			}
		}
		
		
        
	}
	
	
	public ArrayList getButtons ()
	{
		
		return buttons;
		
	}

	
	
	
	


}
