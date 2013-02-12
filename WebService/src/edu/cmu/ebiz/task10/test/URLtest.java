package edu.cmu.ebiz.task10.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.Text;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.xpath.XPathExpression;
/**
 * XML looks like this:
 * <site>
 * 		<title>Importing</title>
 * 		<url>http://www.sba.gov/content/exporting-and-importing</url>
 * 		<description>Learn about laws, regulations and procedures that apply to importing goods</description>
 * 		<keywords>importing</keywords>
 * 		<category>managing a business</category>
 * 		<orders>1</orders>
 * 		<master_term>Importing</master_term>
 * </site>
 * <site>
 *    .....
 * </site>
 * 
 * @author taozheng
 *
 */
	
public class URLtest {
	public static void main(String[] args) throws Exception {
		//URL oracle = new URL("http://api.sba.gov/rec_sites/category/managing%20a%20business.xml");
		//URLConnection yc = oracle.openConnection();
		
		//BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("http://api.sba.gov/rec_sites/category/managing%20a%20business.xml");
		
		XPathFactory factory = XPathFactory.newInstance();
		XPath xPath = factory.newXPath();
		javax.xml.xpath.XPathExpression expr = xPath.compile("//site/title/text()");
		
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;
		for (int i = 0; i<nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getNodeValue());
		}
		
		
		/**
		Element e = doc.getDocumentElement();
		
		/**
		 *  get list of sites element, total 88
		 */
		
		/**
		NodeList nodeList = doc.getElementsByTagName("site"); 
		
		System.out.println(nodeList.getLength());
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			//get a specified <site> </site>
			/**
			 *  * <site>
			 * 		<title>Importing</title>
			 * 		<url>http://www.sba.gov/content/exporting-and-importing</url>
			 * 		<description>Learn about laws, regulations and procedures that apply to importing goods</description>
			 * 		<keywords>importing</keywords>
			 * 		<category>managing a business</category>
			 * 		<orders>1</orders>
			 * 		<master_term>Importing</master_term>
			 * 	  </site>
			 * parse node to element!
			 */
		/**
			Element firstElement = (Element) nodeList.item(i);  
			
			// each entry, e.g. <title>Importing</title>, is treated as a two-level nodelist
			// parent is <title> itself, it has only one child "Importing" (if it has attribute, then more children)
			// first node is itself, next is it's value, when we get item(0), we are get the true node
			NodeList titles = firstElement.getElementsByTagName("title");
			// site -- > title --> important
			Element titleElement = (Element) titles.item(0);
			System.out.println(titleElement.getFirstChild().getNodeValue());
			
			/**
			NodeList siteList = firstElement.getElementsByTagName("title"); 
			Element siteElement = (Element) siteList.item(0);
			siteList = siteElement.getChildNodes();
			System.out.println(siteList.item(0).getNodeValue());
			
			}
			**/
			
			
		
	
		//in.close();
		
		
	}
}
