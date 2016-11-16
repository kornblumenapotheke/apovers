import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class ReadXMLNumberProcessingOrders {
	
	Document doc;
	
	ReadXMLNumberProcessingOrders(String inString)
	{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = dBuilder.parse(inString);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
	}
	
	
	public int getNumberProcessing ()
	{
	Element element = doc.getDocumentElement();
	NodeList nList = element.getChildNodes();
	
	for (int temp = 0; temp < nList.getLength(); temp++) {
			return Integer.valueOf(element.getElementsByTagName("processing").item(0).getTextContent());
			}
		return -77;
		
	}
	
	
	public int getNumberPending ()
	{
	NodeList nList = doc.getElementsByTagName("xml");
	for (int temp = 0; temp < nList.getLength(); temp++) {
	Node nNode = nList.item(temp);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			return Integer.valueOf(eElement.getElementsByTagName("pending").item(0).getTextContent());
			}
		return -77;
		}
	return -77;
	}
}