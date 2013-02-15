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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import edu.cmu.ebiz.task8.bean.PeopleIncomeBean;
import edu.cmu.ebiz.task8.bean.PeopleSegmentBean;

public class ZillowDAO {
	private static Document document;

	//this method check whether user input is a valid city
	public boolean getMsgCode(String state, String city, String area) {
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

			//before using XPath get information, first check error code!
			XPathExpression msgCode = xpath.compile("//message/code/text()");
			Object code = msgCode.evaluate(doc, XPathConstants.NODE);
			Node codeNode = (Node) code;
			if (codeNode.getNodeValue().equals("0"))
				return true;
			else {
				return false;
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

		return false;
	}


	public ArrayList<PeopleSegmentBean> getSegmentation(String state, String city, String area) {
		try {
			// prepare statement, based on your own api
			String preparedURL = "http://www.zillow.com/webservice/GetDemographics.htm?zws-id=X1-ZWz1di5yjoznd7_2ca3z" 
					+"&state="+ replaceSpace(state)
					+"&city=" + replaceSpace(city)
					+"&neighborhood=" + replaceSpace(area);

			String xmlString = GetXMLDocString.getString(preparedURL);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			Document doc = builder.parse(is);

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();

			//here is your customize xpath expression
			/**
			 * <liveshere>
			 * 		<title>Ramen Metros</title>
			 * 		<name>Lower-income urban singles.</name>
			 * 		<description>
			 * 			Most rent their apartment or condo. Some have a college education and work in services and the professional sector.
			 *  	</description>
			 * </liveshere>
			 */
			//get <title>
			/**
			XPathExpression exprTitle = xpath.compile("//page[name='People']/segmentation/liveshere/title/text()");
			Object resultTitle = exprTitle.evaluate(doc, XPathConstants.NODESET);
			NodeList titles = (NodeList) resultTitle;
			//get <name>
			XPathExpression exprName = xpath.compile("//page[name='People']/segmentation/liveshere/name/text()");
			Object resultName = exprName.evaluate(doc, XPathConstants.NODESET);
			NodeList names = (NodeList) resultName;
			//get <description>
			XPathExpression exprDesc = xpath.compile("//page[name='People']/segmentation/liveshere/description/text()");
			Object resultDesc = exprDesc.evaluate(doc, XPathConstants.NODESET);
			NodeList descs = (NodeList) resultDesc;
			**/
			NodeList titles = GetXMLDocString.getExpressionResult(doc, "//page[name='People']/segmentation/liveshere/title/text()");
			NodeList names = GetXMLDocString.getExpressionResult(doc, "//page[name='People']/segmentation/liveshere/name/text()");
			NodeList descs = GetXMLDocString.getExpressionResult(doc, "//page[name='People']/segmentation/liveshere/description/text()");
			
			ArrayList<PeopleSegmentBean> segments = new ArrayList<PeopleSegmentBean>();
			for (int i = 0; i<titles.getLength(); i++) {
				PeopleSegmentBean currentSeg = new PeopleSegmentBean();
				currentSeg.setTitle(titles.item(i).getNodeValue());
				if (names.item(i) != null) 
					currentSeg.setName(names.item(i).getNodeValue());
				if (descs.item(i) != null)
					currentSeg.setDescription(descs.item(i).getNodeValue());

				segments.add(currentSeg);
			} 

			return segments;
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public PeopleIncomeBean getIncome(String state, String city, String area) {
		try {
			// prepare statement, based on your own api
			String preparedURL = "http://www.zillow.com/webservice/GetDemographics.htm?zws-id=X1-ZWz1di5yjoznd7_2ca3z&state="+replaceSpace(state)
					+"&city=" + replaceSpace(city)
					+"&neighborhood="+ replaceSpace(area);

			String xmlString = GetXMLDocString.getString(preparedURL);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			Document doc = builder.parse(is);
	
			/**
=======

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();

			//before using XPath get information, first check error code!
			XPathExpression msgCode = xpath.compile("//message/code/text()");
			Object code = msgCode.evaluate(doc, XPathConstants.NODE);
			Node codeNode = (Node) code;
			if (!codeNode.getNodeValue().equals("0"))
				return null;

>>>>>>> branch 'master' of ssh://git@github.com/chinesecold/WebService.git
			//here is your customize xpath expression
			XPathExpression exprNation = xpath.compile("//attribute[name='Median Household Income']/values/nation/value/text()");
			Object resultNation = exprNation.evaluate(doc, XPathConstants.NODESET);
			NodeList nationIncome = (NodeList) resultNation;
			//get city income
			XPathExpression exprCity = xpath.compile("//attribute[name='Median Household Income']/values/city/value/text()");
			Object resultCity = exprCity.evaluate(doc, XPathConstants.NODESET);
			NodeList cityIncome = (NodeList) resultCity;
			//get neighborhood income, some area may not have this data: example, shadyside, pittsburgh
			XPathExpression exprNeighbor = xpath.compile("//attribute[name='Median Household Income']/values/neighborhood/value/text()");
			Object resultNeighbor = exprNeighbor.evaluate(doc, XPathConstants.NODESET);
			NodeList neighborIncome = (NodeList) resultNeighbor;
			**/
			// easy way to get result of XPath Expression, just call GetXMLDocString
			NodeList nationIncome = GetXMLDocString.getExpressionResult(doc, "//attribute[name='Median Household Income']/values/nation/value/text()");
			NodeList cityIncome = GetXMLDocString.getExpressionResult(doc, "//attribute[name='Median Household Income']/values/city/value/text()");
			NodeList neighborIncome = GetXMLDocString.getExpressionResult(doc, "//attribute[name='Median Household Income']/values/neighborhood/value/text()");

			//for each area, there is only one set of data, so we don't use for loop
			PeopleIncomeBean income = new PeopleIncomeBean();
			if (nationIncome == null || nationIncome.getLength() == 0) 
				income.setNationIncome("Data does not exist");
			else
				income.setNationIncome(nationIncome.item(0).getNodeValue());
			if (cityIncome == null || cityIncome.getLength() == 0) 
				income.setCityIncome("Data does not exist");
			else 
				income.setCityIncome(cityIncome.item(0).getNodeValue());

			if (neighborIncome == null || neighborIncome.getLength() == 0) 
				income.setNeighborIncome("Data does not exist");
			else
				income.setNeighborIncome(neighborIncome.item(0).getNodeValue());

			return income;
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("-----------");
//		getIncome("PA", "Pittsburgh", "Shadyside");
	}
	
	// covert space to %20, prevent data error
	private String replaceSpace(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i<str.length(); i++) {
			if (str.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(str.charAt(i));
			}
		}

		return sb.toString();
	}
}
