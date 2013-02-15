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

import edu.cmu.ebiz.task8.bean.RecommendedWebsitesBean;

public class RecommendedWebsitesDAO {
	private static Document document;

	public ArrayList<RecommendedWebsitesBean> getManageABusinessCategory() {
		try {
			// prepare statement, based on your own api
			String preparedURL = "http://api.sba.gov/rec_sites/category/managing%20a%20business.xml";

			String xmlString = GetXMLDocString.getString(preparedURL);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			Document doc = builder.parse(is);

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();

			// here is your customize xpath expression
			XPathExpression exprTitle = xpath.compile("//site/title/text()");

			Object resultTitle = exprTitle
					.evaluate(doc, XPathConstants.NODESET);
			NodeList manageTitle = (NodeList) resultTitle;

			XPathExpression exprURL = xpath.compile("//site/url/text()");

			Object resultURL = exprURL.evaluate(doc, XPathConstants.NODESET);
			NodeList manageURL = (NodeList) resultURL;

			XPathExpression exprDesc = xpath
					.compile("//site/description/text()");

			Object resultDesc = exprDesc.evaluate(doc, XPathConstants.NODESET);
			NodeList manageDesc = (NodeList) resultDesc;
			// Test
			// for (int i = 0; i<manageNodes.getLength(); i++) {
			// System.out.println(manageNodes.item(i).getNodeValue());
			// }

			// RecommendedWebsitesBean manage = new RecommendedWebsitesBean();
			ArrayList<RecommendedWebsitesBean> manage = new ArrayList<RecommendedWebsitesBean>();
			for (int i = 0; i < manageTitle.getLength(); i++) {
				RecommendedWebsitesBean currentManage = new RecommendedWebsitesBean();
				currentManage.setTitle(manageTitle.item(i).getNodeValue());
				currentManage.setUrl(manageURL.item(i).getNodeValue());
				currentManage.setDescription(manageDesc.item(i).getNodeValue());

				manage.add(currentManage);

			}

			return manage;

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<RecommendedWebsitesBean> getFinanceABusinessCategory() {
		try {
			// prepare statement, based on your own api
			String preparedURL = "http://api.sba.gov/rec_sites/category/financing%20a%20business.xml";

			String xmlString = GetXMLDocString.getString(preparedURL);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			Document doc = builder.parse(is);

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();

			// here is your customize xpath expression
			XPathExpression exprTitle = xpath.compile("//site/title/text()");

			Object resultTitle = exprTitle
					.evaluate(doc, XPathConstants.NODESET);
			NodeList financeTitle = (NodeList) resultTitle;

			XPathExpression exprURL = xpath.compile("//site/url/text()");

			Object resultURL = exprURL.evaluate(doc, XPathConstants.NODESET);
			NodeList financeURL = (NodeList) resultURL;

			XPathExpression exprDesc = xpath
					.compile("//site/description/text()");

			Object resultDesc = exprURL.evaluate(doc, XPathConstants.NODESET);
			NodeList financeDesc = (NodeList) resultDesc;

			ArrayList<RecommendedWebsitesBean> finance = new ArrayList<RecommendedWebsitesBean>();
			for (int i = 0; i < financeTitle.getLength(); i++) {
				RecommendedWebsitesBean currentFinance = new RecommendedWebsitesBean();
				currentFinance.setTitle(financeTitle.item(i).getNodeValue());
				currentFinance.setUrl(financeURL.item(i).getNodeValue());
				currentFinance.setDescription(financeDesc.item(i)
						.getNodeValue());

				finance.add(currentFinance);
			}
			
			return finance;
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void getRegisterABusinessCategory() {
		try {
			// prepare statement, based on your own api
			String preparedURL = "http://api.sba.gov/rec_sites/category/registering%20a%20business.xml";

			String xmlString = GetXMLDocString.getString(preparedURL);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			Document doc = builder.parse(is);

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();

			// here is your customize xpath expression
			XPathExpression expr = xpath
					.compile("//site/title/text() | //site/url/text() | //site/description/text()");

			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
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

	public static void getStartABusinessCategory() {
		try {
			// prepare statement, based on your own api
			String preparedURL = "http://api.sba.gov/rec_sites/category/starting%20a%20business.xml";

			String xmlString = GetXMLDocString.getString(preparedURL);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			Document doc = builder.parse(is);

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();

			// here is your customize xpath expression
			XPathExpression expr = xpath
					.compile("//site/title/text() | //site/url/text() | //site/description/text()");

			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
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

	public static void getOtherCategory() {
		try {
			// prepare statement, based on your own api
			String preparedURL = "http://api.sba.gov/rec_sites/category/other.xml";

			String xmlString = GetXMLDocString.getString(preparedURL);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			Document doc = builder.parse(is);

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();

			// here is your customize xpath expression
			XPathExpression expr = xpath
					.compile("//site/title/text() | //site/url/text() | //site/description/text()");

			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
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
//		getManageABusinessCategory();
		System.out.println("------------------------------------------------");
		// getFinanceABusinessCategory();
		// System.out.println("------------------------------------------------");
		// getRegisterABusinessCategory();
		// System.out.println("------------------------------------------------");
		// getStartABusinessCategory();
		// System.out.println("------------------------------------------------");
		// getOtherCategory();
	}
}