package edu.cmu.ebiz.task8.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.cmu.ebiz.task8.bean.SearchPlacePhoto;
import edu.cmu.ebiz.task8.bean.SimpleSearchPlacesBean;
import edu.cmu.ebiz.task8.parser.KeyFinder;

public class GooglePlaceAPITest {
	public static void main(String[] args) {
		try {
			URL url = new URL(
					"https://maps.googleapis.com/maps/api/place/textsearch/json?query=restuarants+in+Pittsburgh&key=AIzaSyDy-3-hP8uDctn2XDeXw5EbV_H2Sza9WZg&sensor=false");
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					url.openStream()));
			String line;

			StringBuffer buffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();

			String jsonString = buffer.toString();

			System.out.println(jsonString);

			// parse start
			
			Object obj =JSONValue.parse(jsonString);
			JSONObject response = (JSONObject) obj;

			JSONArray array = (JSONArray) response.get("results");
			
			List<SimpleSearchPlacesBean> searchPlaces = new ArrayList<SimpleSearchPlacesBean>();
			// store results
			for(int i = 0; i< array.size(); i++){
				//System.out.println(array.get(i));
				JSONObject result = (JSONObject) array.get(i);
				
				SimpleSearchPlacesBean place = new SimpleSearchPlacesBean();
				place.setAddress((String) result.get("formatted_address"));
				place.setIconURL(new URL((String)result.get("icon")));
				place.setId((String)result.get("id"));
				place.setName((String)result.get("name"));
				JSONObject geometry = (JSONObject) result.get("geometry");
				if(geometry != null){
					JSONObject location = (JSONObject) geometry.get("location");
					
					if(location != null){
						place.setLatitude((Double) location.get("lat"));
						place.setLongitude((Double)location.get("lng"));
					}
				}
				if(result.get("price_level") != null){
					place.setPriceLevel((Long)result.get("price_level"));
				}
				
				place.setRating((Double)result.get("rating"));
				place.setReference((String)result.get("reference"));
				JSONArray typeArray = (JSONArray)result.get("types");
				if(typeArray != null){
					List<String> types = new ArrayList<String>();
					for(int j = 0; j < typeArray.size(); j++){
						types.add((String) typeArray.get(j));
					}
					place.setTypes(types);
				}
				JSONObject opening_hours = (JSONObject)result.get("opening_hours");
				if(opening_hours != null){
					place.setOpen((Boolean)opening_hours.get("open_now"));
				}
				JSONArray photoArray = (JSONArray) result.get("photos");
				if(photoArray != null){
					List<SearchPlacePhoto> photos = new ArrayList<SearchPlacePhoto>();
					for(int j = 0; j < photoArray.size(); j++){
						JSONObject photo = (JSONObject) photoArray.get(j);			
						if(photo != null){
							SearchPlacePhoto pic = new SearchPlacePhoto();
							pic.setHeight((Long)photo.get("height"));
							pic.setWidth((Long)photo.get("width"));
							pic.setPhotoReference((String)photo.get("photo_reference"));
							JSONArray htmlAttr = (JSONArray)photo.get("html_attributions");
							if(htmlAttr != null){
								List<String> htmlAttributions = new ArrayList<String>();
								for(int k = 0; k < htmlAttr.size(); k++){
									htmlAttributions.add((String)htmlAttr.get(k));
								}
								pic.setHtmlAttributions(htmlAttributions);
							}
							photos.add(pic);
						}
						
					}
					
					place.setPhotos(photos);
				}
				
				searchPlaces.add(place);
				//System.out.println(place);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
