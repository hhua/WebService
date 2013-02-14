package edu.cmu.ebiz.task8.model;
/**
 * This class provide a general way to get XML document by URL
 * It will return XML as String
 * In your own DAO
 * Call  GetXMLDocString.getString(url)
 * you will get a string
 * 
 * than parse the string to Document and use XPath to retrival data.
 * 
 * @author taozheng
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetXMLDocString {
	
	public static String getString(String preparedURL) {
		try {
			URL url = new URL(preparedURL);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
            connection.setRequestMethod("GET");
            
            InputStream in = connection.getInputStream();
            
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    			String line;

    			StringBuffer buffer = new StringBuffer();
    			while ((line = reader.readLine()) != null) {
    				buffer.append(line);
    			}
    			reader.close();

    			String xmlString = buffer.toString();
    			return xmlString;
    			
            } else {
                // Server returned HTTP error code.
            }
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
}