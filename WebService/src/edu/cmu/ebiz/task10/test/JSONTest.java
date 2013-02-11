package edu.cmu.ebiz.task10.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * Test on Twitter Trends API https://api.twitter.com/1.1/trends/place.json?id=1
 */
public class JSONTest {
	public static void main(String[] args) {
		try {
			URL url = new URL(
					"https://api.twitter.com/1/statuses/user_timeline.json?include_entities=true&include_rts=true&screen_name=twitterapi&count=2");
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
			
			Object obj=JSONValue.parse(jsonString);
			JSONArray array=(JSONArray)obj;
			

			//JSONParser parser = new JSONParser();
			//Map json = (Map) parser.parse(jsonString);
			Map json = (Map)array.get(0);
			Map json1 = (Map)array.get(1);
			Iterator iter = json.entrySet().iterator();
			Iterator iter1 = json.entrySet().iterator();
			System.out.println("==iterate result==");

			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				System.out.println(entry.getKey() + "=>" + entry.getValue());
			}
			

			System.out.println("==toJSONString()==");
			System.out.println(JSONValue.toJSONString(json));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		} catch (ParseException ex) {
//			ex.printStackTrace();
//		}

	}
}
