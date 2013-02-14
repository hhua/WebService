package edu.cmu.ebiz.task8.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
			
			
			for(int i = 0; i< array.size(); i++){
				System.out.println(array.get(i));
				JSONObject result = (JSONObject) array.get(i);
				
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
