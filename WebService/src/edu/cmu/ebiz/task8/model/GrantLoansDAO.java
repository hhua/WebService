package edu.cmu.ebiz.task8.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import edu.cmu.ebiz.task8.bean.GrantLoansBean;


public class GrantLoansDAO {
	public List<GrantLoansBean> jsonParser(URL url) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					url.openStream()));
			String line;

			StringBuffer buffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();

			String jsonString = buffer.toString();

			// parse start

			Object obj = JSONValue.parse(jsonString);
			JSONArray array = (JSONArray) obj;

			//JSONArray array = (JSONArray) response.get("");

			List<GrantLoansBean> loans = new ArrayList<GrantLoansBean>();
			// store results
			for (int i = 0; i < array.size(); i++) {
				JSONObject result = (JSONObject) array.get(i);

				GrantLoansBean loan = new GrantLoansBean();
				loan.setAgency((String) result.get("agency"));
				loan.setProgram(((String) result.get("title")));
				loan.setDescription((String) result.get("description"));
				loan.setUrl((String) result.get("url"));
				
				loans.add(loan);
			}
			
			return loans;

		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
