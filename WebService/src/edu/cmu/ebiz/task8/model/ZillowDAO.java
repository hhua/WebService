package edu.cmu.ebiz.task8.model;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ZillowDAO {
	private static Document document;
	
	public static void getSegmentation(String state, String city, String area) {
		try {
			// prepare statement, based on your own api
			String preparedURL = "http://www.zillow.com/webservice/GetDemographics.htm?zws-id=X1-ZWz1di5yjoznd7_2ca3z&state="+state
					+"&city=" + city 
					+"&neighborhood="+ area;
			
			String xmlString = GetXMLDocString.getString(preparedURL);
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			Document doc = builder.parse(is);
	
			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();
			
			//here is your customize xpath expression
			XPathExpression expr = xpath.compile("//page[name='People']/segmentation/liveshere/*/text()");
			
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i<nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeValue());
			} 
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getIncome(String state, String city, String area) {
		try {
			// prepare statement, based on your own api
			String preparedURL = "http://www.zillow.com/webservice/GetDemographics.htm?zws-id=X1-ZWz1di5yjoznd7_2ca3z&state="+state
					+"&city=" + city 
					+"&neighborhood="+ area;
			
			String xmlString = GetXMLDocString.getString(preparedURL);
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			Document doc = builder.parse(is);
	
			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();
			
			//here is your customize xpath expression
			XPathExpression expr = xpath.compile("attribute[name='Median Household Income']/values/nation/value[@currency='USD']/text()");
			
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i<nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeValue());
			} 
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		getSegmentation("PA", "Pittsburgh", "Shadyside");
		System.out.println("-----------");
		getIncome("PA", "Pittsburgh", "Shadyside");
	}
}
