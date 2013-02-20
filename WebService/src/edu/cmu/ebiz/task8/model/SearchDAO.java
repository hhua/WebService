/**
 * @author Shoucong Chen
 * Feb 17, 2013
 */

package edu.cmu.ebiz.task8.model;

import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import edu.cmu.ebiz.task8.basic.Constants;
import edu.cmu.ebiz.task8.bean.PlaceReviewBean;
import edu.cmu.ebiz.task8.bean.SearchPlaceDetailBean;

public class SearchDAO {
	public SearchPlaceDetailBean getDetails(String reference) {
		try {

			String preparedURL = "https://maps.googleapis.com/maps/api/place/details/xml?"
					+ "reference="
					+ reference
					+ "&sensor=false&key="
					+ Constants.GOOGLE_API_KEY;
			String xmlString = GetXMLDocString.getString(preparedURL);

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlString));
			Document doc = builder.parse(is);

			SearchPlaceDetailBean bean = new SearchPlaceDetailBean();

			bean.setReference(reference);

			Node name = GetXMLDocString.getSingleResult(doc,
					"//result/name/text()");
			bean.setName(name == null ? "N/A" : name.getNodeValue());

			Node phone = GetXMLDocString.getSingleResult(doc,
					"//result/formatted_phone_number/text()");
			bean.setPhone(phone == null ? "N/A" : phone.getNodeValue());

			Node address = GetXMLDocString.getSingleResult(doc,
					"//result/formatted_address/text()");
			bean.setAddress(address == null ? "N/A" : address.getNodeValue());

			Node latitude = GetXMLDocString.getSingleResult(doc,
					"//result/geometry/location/lat/text()");
			double latitudeD = latitude == null ? 0.0 : Double.parseDouble(latitude.getNodeValue());
			bean.setLatitude(latitudeD);

			Node longitude = GetXMLDocString.getSingleResult(doc,
					"//result/geometry/location/lng/text()");
			double longitudeD = longitude == null ? 0.0 : Double.parseDouble(longitude.getNodeValue());
			bean.setLongitude(longitudeD);

			Node rating = GetXMLDocString.getSingleResult(doc,
					"//result/rating/text()");
			if (rating == null) {
				bean.setRating(0.0);
			} else {
				double ratingD = Double.parseDouble(rating.getNodeValue());
				bean.setRating(ratingD);
			}

			Node url = GetXMLDocString.getSingleResult(doc,
					"//result/url/text()");
			bean.setUrl(url == null ? "#" : url.getNodeValue());

			Node website = GetXMLDocString.getSingleResult(doc,
					"//result/website/text()");
			bean.setWebsite(website == null ? "#" : website.getNodeValue());

			Node priceLevel = GetXMLDocString.getSingleResult(doc,
					"//result/price_level/text()");
			if (priceLevel == null) {
				bean.setPriceLevel(0);
			} else {
				int priceLevelI = Integer.parseInt(priceLevel.getNodeValue());
				bean.setPriceLevel(priceLevelI);
			}

			Node photoReference = GetXMLDocString.getSingleResult(doc,
					"//result/photo/photo_reference/text()");
			if (photoReference == null) {
				bean.setPhotoReference("");
				bean.setImgUrl("#");
			} else {
				bean.setPhotoReference(photoReference.getNodeValue());
				String imgUrl = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=300&maxheight=200&"
						+ "photoreference="
						+ bean.getPhotoReference()
						+ "&sensor=true&" + "key=" + Constants.GOOGLE_API_KEY;
				bean.setImgUrl(imgUrl);
			}

			NodeList reviewsTime = GetXMLDocString.getExpressionResult(doc,
					"//result/review/time/text()");
			if (reviewsTime == null || reviewsTime.getLength() == 0) {
				bean.setReviews(null);
				return bean;
			}
			
			PlaceReviewBean[] reviews = new PlaceReviewBean[reviewsTime.getLength()];
			bean.setReviews(reviews);

			NodeList reviewsText = GetXMLDocString.getExpressionResult(doc,	"//result/review/text/text()");
			NodeList reviewsAuthor = GetXMLDocString.getExpressionResult(doc, "//result/review/author_name/text()");
			NodeList reviewsUrl = GetXMLDocString.getExpressionResult(doc, "//result/review/author_url/text()");

			for (int i = 0; i < reviews.length; i++) {
				reviews[i] = new PlaceReviewBean();
				
				if (reviewsTime.item(i) == null) {
					reviews[i].setTime("N/A");
				} else {
					DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
					long time = Long.parseLong(reviewsTime.item(i).getNodeValue()) * 1000; // Because it returns seconds, not milliseconds.
					Date date = new Date(time);
					reviews[i].setTime(df.format(date));
				}
				
				reviews[i].setText(reviewsText.item(i) == null ? "There is no reviews." : reviewsText.item(i).getNodeValue());
				reviews[i].setAuthor(reviewsAuthor.item(i) == null ? "Anonymous" : reviewsAuthor.item(i).getNodeValue());
				reviews[i].setUrl(reviewsUrl.item(i) == null ? "#" : reviewsUrl.item(i).getNodeValue());
			}

			return bean;
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
		SearchDAO t = new SearchDAO();
		SearchPlaceDetailBean bean = t
				.getDetails("CnRtAAAA1sIrVJWjlkStRaPTjZqBM53p7eGKg5BOR1XsS9rYd2KBY6NczLNbjs6l1AT2eH1pUXAeV1K4TFVYsxUTkF9yC5u8zzPvEViKadmqCf3crYn2-8LvQihCBWnnZ4XzaPoVhS0PwIuAYpSwXWlVUmWIyhIQ8rpcNbW2YXtsBR8q-0XIrxoUaL1bjOwVl79EEK8nHCS2zzN0uMY");
		System.out.println(bean.toString());
	}
}
