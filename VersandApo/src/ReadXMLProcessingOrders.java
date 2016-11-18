import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.swing.JButton;
import javax.xml.parsers.*;
import java.io.*;


public class ReadXMLProcessingOrders {


	Document document;
	Element root;
	int intProcessing =-99;
	int intPending = -99;
	JButton[] buttons;
	
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
		
		NodeList nList = document.getElementsByTagName("xml");
		System.out.println(nList.getLength());
		Node node = nList.item(0);
		Element eElement = (Element)node;
		
		intProcessing = Integer.valueOf(eElement.getElementsByTagName("processing").item(0).getTextContent());
		intPending = Integer.valueOf(eElement.getElementsByTagName("pending").item(0).getTextContent());
        
	}
	
	
	public JButton[] getButtons ()
	{
		
		return buttons;
		
	}

	
	
	
	


}
