package edu.cmu.ebiz.task8.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.ebiz.task8.bean.SimpleSearchPlacesBean;
import edu.cmu.ebiz.task8.formbean.SimpleSearchForm;
import edu.cmu.ebiz.task8.parser.GooglePlacesParser;

public class SimpleSearchAction extends Action {
	private FormBeanFactory<SimpleSearchForm> formBeanFactory = FormBeanFactory
			.getInstance(SimpleSearchForm.class);

	public SimpleSearchAction() {

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "simple-search.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub

		// Set up error list
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			SimpleSearchForm form = formBeanFactory.create(request);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			if (!form.isPresent()) {
				return "simplesearch.jsp";
			}

			// Check for any validation errors
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "simplesearch.jsp";
			}
			
			//handle request
			String query = form.getSearchPlaces();
			URL requestURL = generateBasicURL(query, form.getPlaceTypes());
			
			List<SimpleSearchPlacesBean> places = GooglePlacesParser.jsonParser(requestURL);

			for(SimpleSearchPlacesBean place : places){
				System.out.println(place);
			}
			// Success
			SimpleSearchPlacesBean[] placesArr = new SimpleSearchPlacesBean[places.size()];
			for (int i = 0; i<places.size(); i++) {
				placesArr[i] = places.get(i);
			}
			request.setAttribute("places", placesArr);
			return "simplesearch.jsp";
		} catch (FormBeanException e) {
			errors.add(e.toString());
			return "error.jsp";
		}
	}
	
	// generate basic Google Places text search api call
	private URL generateBasicURL(String query, String types){
		try{
			String places = query.replace(' ', '+');
			URL url;
			if(types.equals("All places")){		
				url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + places + "&key=AIzaSyDy-3-hP8uDctn2XDeXw5EbV_H2Sza9WZg&sensor=false");	
			} else {
				url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + places + "&key=AIzaSyDy-3-hP8uDctn2XDeXw5EbV_H2Sza9WZg&sensor=false" + "&types=" + types);	
			}
			
			return url;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
