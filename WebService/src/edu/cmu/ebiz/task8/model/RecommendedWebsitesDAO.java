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

			Object resultDesc = exprDesc.evaluate(doc, XPathConstants.NODESET);
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

	public ArrayList<RecommendedWebsitesBean> getRegisterABusinessCategory() {
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
	
			XPathExpression exprTitle = xpath.compile("//site/title/text()");

			Object resultTitle = exprTitle
					.evaluate(doc, XPathConstants.NODESET);
			NodeList registerTitle = (NodeList) resultTitle;

			XPathExpression exprURL = xpath.compile("//site/url/text()");

			Object resultURL = exprURL.evaluate(doc, XPathConstants.NODESET);
			NodeList registerURL = (NodeList) resultURL;

			XPathExpression exprDesc = xpath
					.compile("//site/description/text()");

			Object resultDesc = exprDesc.evaluate(doc, XPathConstants.NODESET);
			NodeList registerDesc = (NodeList) resultDesc;

			ArrayList<RecommendedWebsitesBean> register = new ArrayList<RecommendedWebsitesBean>();
			for (int i = 0; i < registerTitle.getLength(); i++) {
				RecommendedWebsitesBean currentRegister = new RecommendedWebsitesBean();
				currentRegister.setTitle(registerTitle.item(i).getNodeValue());
				currentRegister.setUrl(registerURL.item(i).getNodeValue());
				currentRegister.setDescription(registerDesc.item(i)
						.getNodeValue());

				register.add(currentRegister);
			}
			
			return register;
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

	public ArrayList<RecommendedWebsitesBean> getStartABusinessCategory() {
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
			XPathExpression exprTitle = xpath.compile("//site/title/text()");

			Object resultTitle = exprTitle
					.evaluate(doc, XPathConstants.NODESET);
			NodeList startTitle = (NodeList) resultTitle;

			XPathExpression exprURL = xpath.compile("//site/url/text()");

			Object resultURL = exprURL.evaluate(doc, XPathConstants.NODESET);
			NodeList startURL = (NodeList) resultURL;

			XPathExpression exprDesc = xpath
					.compile("//site/description/text()");

			Object resultDesc = exprDesc.evaluate(doc, XPathConstants.NODESET);
			NodeList startDesc = (NodeList) resultDesc;

			ArrayList<RecommendedWebsitesBean> start = new ArrayList<RecommendedWebsitesBean>();
			for (int i = 0; i < startTitle.getLength(); i++) {
				RecommendedWebsitesBean currentStart = new RecommendedWebsitesBean();
				currentStart.setTitle(startTitle.item(i).getNodeValue());
				currentStart.setUrl(startURL.item(i).getNodeValue());
				currentStart.setDescription(startDesc.item(i)
						.getNodeValue());

				start.add(currentStart);
			}
			
			return start;
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

	public ArrayList<RecommendedWebsitesBean> getOtherCategory() {
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
			XPathExpression exprTitle = xpath.compile("//site/title/text()");

			Object resultTitle = exprTitle
					.evaluate(doc, XPathConstants.NODESET);
			NodeList othersTitle = (NodeList) resultTitle;

			XPathExpression exprURL = xpath.compile("//site/url/text()");

			Object resultURL = exprURL.evaluate(doc, XPathConstants.NODESET);
			NodeList othersURL = (NodeList) resultURL;

			XPathExpression exprDesc = xpath
					.compile("//site/description/text()");

			Object resultDesc = exprDesc.evaluate(doc, XPathConstants.NODESET);
			NodeList othersDesc = (NodeList) resultDesc;

			ArrayList<RecommendedWebsitesBean> others = new ArrayList<RecommendedWebsitesBean>();
			for (int i = 0; i < othersTitle.getLength(); i++) {
				RecommendedWebsitesBean currentOthers = new RecommendedWebsitesBean();
				currentOthers.setTitle(othersTitle.item(i).getNodeValue());
				currentOthers.setUrl(othersURL.item(i).getNodeValue());
				currentOthers.setDescription(othersDesc.item(i)
						.getNodeValue());

				others.add(currentOthers);
			}
			
			return others;
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
	

		public ArrayList<RecommendedWebsitesBean> getLawCategory() {
		try {
			// prepare statement, based on your own api
			String preparedURL = "http://api.sba.gov/rec_sites/category/business%20law.xml";

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
			NodeList lawTitle = (NodeList) resultTitle;

			XPathExpression exprURL = xpath.compile("//site/url/text()");

			Object resultURL = exprURL.evaluate(doc, XPathConstants.NODESET);
			NodeList lawURL = (NodeList) resultURL;

			XPathExpression exprDesc = xpath
					.compile("//site/description/text()");

			Object resultDesc = exprDesc.evaluate(doc, XPathConstants.NODESET);
			NodeList lawDesc = (NodeList) resultDesc;

			ArrayList<RecommendedWebsitesBean> law = new ArrayList<RecommendedWebsitesBean>();
			for (int i = 0; i < lawTitle.getLength(); i++) {
				RecommendedWebsitesBean currentLaw = new RecommendedWebsitesBean();
				currentLaw.setTitle(lawTitle.item(i).getNodeValue());
				currentLaw.setUrl(lawURL.item(i).getNodeValue());
				currentLaw.setDescription(lawDesc.item(i)
						.getNodeValue());

				law.add(currentLaw);
			}
			
			return law;
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
//	public static void main(String[] args) {
////		getManageABusinessCategory();
//		System.out.println("------------------------------------------------");
//		// getFinanceABusinessCategory();
//		// System.out.println("------------------------------------------------");
//		// getRegisterABusinessCategory();
//		// System.out.println("------------------------------------------------");
//		// getStartABusinessCategory();
//		// System.out.println("------------------------------------------------");
//		// getOtherCategory();
//	}
}