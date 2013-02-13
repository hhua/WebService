package edu.cmu.ebiz.task10.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Zillow {
	public static void main(String[] args) {
		/**
		 * http://www.zillow.com/webservice/GetSearchResults.htm?zws-id=X1-ZWz1di5yjoznd7_2ca3z&address=5662+Beacon+Street&citystatezip=Pittsburgh%2C+PA%22
		 *	the link above can get price of a house
		 *
		 *get neighborhood  info
		 *http://www.zillow.com/webservice/GetDemographics.htm?zws-id=X1-ZWz1di5yjoznd7_2ca3z&state=PA&city=Pittsburgh&neighborhood=North%20Oakland
		 */
		try {
			/**
			 *  these parameters can get from user's input
			 */
			String state = "PA";
			String city = "Pittsburgh";
			String neighbor = "North Oakland";
			//http://www.zillow.com/webservice/GetDemographics.htm?zws-id=X1-ZWz1di5yjoznd7_2ca3z&state=PA&city=Pittsburgh&neighborhood=North%20Oakland
			String preURL = "http://www.zillow.com/webservice/GetDemographics.htm?zws-id=X1-ZWz1di5yjoznd7_2ca3z&state="+state
					+"&city=" + city 
					+"&neighborhood="+ neighbor;
			URL url = new URL(preURL);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
            connection.setRequestMethod("GET");
            
            InputStream in = connection.getInputStream();
            
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // OK
            	
            	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    			String line;

    			StringBuffer buffer = new StringBuffer();
    			while ((line = reader.readLine()) != null) {
    				buffer.append(line);
    			}
    			reader.close();

    			String xmlString = buffer.toString();
    			
    			// parse XML
            	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    			factory.setNamespaceAware(true); // never forget this!
    			DocumentBuilder builder = factory.newDocumentBuilder();
    			InputSource is = new InputSource(new StringReader(xmlString));
    			Document doc = builder.parse(is);

    			XPathFactory xFactory = XPathFactory.newInstance();
    			XPath xpath = xFactory.newXPath();
    			
    			/**
    			 * Here, we can get median value of different type of house
    			 * and display as chart
    			 * we can also get other information
    			 * 
    			 */
    			XPathExpression expr = xpath.compile("//chart[name='Median Condo Value']/name/text()");
    			
    			Object result = expr.evaluate(doc, XPathConstants.NODESET);
    			NodeList nodes = (NodeList) result;
    			for (int i = 0; i<nodes.getLength(); i++) {
    				System.out.println(nodes.item(i).getNodeValue());
    			}
            } else {
                // Server returned HTTP error code.
            }
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
}
