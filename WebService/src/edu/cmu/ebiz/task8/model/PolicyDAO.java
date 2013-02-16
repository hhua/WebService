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

import edu.cmu.ebiz.task8.bean.PolicyBean;


public class PolicyDAO {
	
//	public boolean getMsgCode(String state, String city, String business) {
//		try {
//			// prepare statement, based on your own api
//			String preparedURL = "http://api.sba.gov/license_permit/state_and_city" 
////					+"/"+ replaceSpace(businesstype)
//					+"/" + state
//					+"/" + city;
//
//			String xmlString = GetXMLDocString.getString(preparedURL);
//
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			factory.setNamespaceAware(true); // never forget this!
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			InputSource is = new InputSource(new StringReader(xmlString));
//			Document doc = builder.parse(is);
//
//			XPathFactory xFactory = XPathFactory.newInstance();
//			XPath xpath = xFactory.newXPath();
//
//			//before using XPath get information, first check error code!
//			XPathExpression msgCode = xpath.compile("//message/code/text()");
//			Object code = msgCode.evaluate(doc, XPathConstants.NODE);
//			Node codeNode = (Node) code;
//			if (codeNode.getNodeValue().equals("0"))
//				return true;
//			else {
//				return false;
//			}
//
//		} catch (SAXException e) {
//			e.printStackTrace();
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (XPathExpressionException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return false;
//	}

	
	public static ArrayList<PolicyBean> getPolicy(String state, String city, String businessType) {
		try {
			
			String preparedURL = "http://api.sba.gov/license_permit/state_and_city" 
//					+"/"+ replaceSpace(businesstype)
					+"/" + replaceSpace(state)
					+"/" + replaceSpace(city);
			
			String xmlString = GetXMLDocString.getString(preparedURL);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			Document doc = builder.parse(is);

			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();

			// here is your customize xpath expression
	
			XPathExpression exprTitle = xpath.compile("//site/link_title/text()");

			Object resultTitle = exprTitle
					.evaluate(doc, XPathConstants.NODESET);
			NodeList policyTitle = (NodeList) resultTitle;

			XPathExpression exprURL = xpath.compile("//site/url/text()");

			Object resultURL = exprURL.evaluate(doc, XPathConstants.NODESET);
			NodeList policyURL = (NodeList) resultURL;

			XPathExpression exprDesc = xpath
					.compile("//site/description/text()");

			Object resultDesc = exprDesc.evaluate(doc, XPathConstants.NODESET);
			NodeList policyDesc = (NodeList) resultDesc;

			ArrayList<PolicyBean> policy = new ArrayList<PolicyBean>();
			for (int i = 0; i < policyTitle.getLength(); i++) {
				PolicyBean currentPolicy = new PolicyBean();
				currentPolicy.setTitle(policyTitle.item(i).getNodeValue());
				currentPolicy.setUrl(policyURL.item(i).getNodeValue());
				currentPolicy.setDescription(policyDesc.item(i)
						.getNodeValue());
				
				System.out.println(policyTitle.item(i).getNodeValue());
				System.out.println(policyURL.item(i).getNodeValue());
				System.out.println(policyDesc.item(i)
						.getNodeValue());
				policy.add(currentPolicy);
				
			}
			
			return policy;
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
	public static void main(String[] args) {
//		getPolicy("pa", "pittsburgh", "child care services");
		//getPolicy();
		System.out.println();
	}
	private static String replaceSpace(String str) {
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