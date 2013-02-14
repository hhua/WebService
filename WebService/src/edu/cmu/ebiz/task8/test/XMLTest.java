package edu.cmu.ebiz.task8.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
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
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

//import javax.xml.parsers.DocumentBuilderFactory;

public class XMLTest {
	public static void main(String[] args) {
		// DocumentBuilderFactory factory =
		// DocumentBuilderFactory.newInstance();

		try {
			URL url = new URL(
					"http://www.zillow.com/webservice/GetSearchResults.htm?zws-id=X1-ZWz1di5yjoznd7_2ca3z&address=5662+Beacon+Street&citystatezip=Pittsburgh%2C+PA");
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

    			NodeList responses = doc.getElementsByTagName("result");
    			Element response = (Element) responses.item(0);
    			NodeList children = response.getChildNodes();
    			for(int i = 0; i < children.getLength(); i++){
    				Node child = children.item(i);
    				System.out.println(child.getTextContent()); // don't use the child directly to get the content, it will return null
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
		}
	}
}
