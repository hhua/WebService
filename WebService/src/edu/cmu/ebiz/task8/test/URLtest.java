package edu.cmu.ebiz.task8.test;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
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
import org.xml.sax.InputSource;
/**
 *
 *This method use XPath to parse XML
 * 
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
		/**
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("http://api.sba.gov/geodata/all_links_for_county_of/allegheny/pa.xml");
		**/
		URL url = new URL(
				"http://api.sba.gov/geodata/all_links_for_county_of/allegheny/pa.xml");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoInput(true);
        connection.setRequestMethod("GET");
        
        InputStream in = connection.getInputStream();
        
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            // OK
        	
        	BufferedReader reader = new BufferedReader(new InputStreamReader(
					in));
			String line;

			StringBuffer buffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();

			String xmlString = buffer.toString();
			System.out.println(xmlString);
			
			
			// parse XML
        	DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			//ByteArrayInputStream stream = new ByteArrayInputStream(xmlString.getBytes());
			Document doc = builder.parse(is);
        
		XPathFactory xfactory = XPathFactory.newInstance();
		XPath xPath = xfactory.newXPath();
		javax.xml.xpath.XPathExpression expr = xPath.compile("//site/county_name/text()");
		
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;
		for (int i = 0; i<nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getNodeValue());
		}
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
