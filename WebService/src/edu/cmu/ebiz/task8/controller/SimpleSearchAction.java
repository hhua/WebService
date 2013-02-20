package edu.cmu.ebiz.task8.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import edu.cmu.ebiz.task8.basic.Constants;
import edu.cmu.ebiz.task8.bean.SearchPlaceDetailBean;
import edu.cmu.ebiz.task8.bean.SimpleSearchPlacesBean;
import edu.cmu.ebiz.task8.formbean.SimpleSearchForm;
import edu.cmu.ebiz.task8.model.Model;
import edu.cmu.ebiz.task8.model.SearchDAO;
import edu.cmu.ebiz.task8.parser.GooglePlacesParser;

public class SimpleSearchAction extends Action {
	private FormBeanFactory<SimpleSearchForm> formBeanFactory = FormBeanFactory
			.getInstance(SimpleSearchForm.class);
	
	private SearchDAO searchDAO;

	public SimpleSearchAction(Model model) {
		this.searchDAO = model.getSearchDAO();
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
			URL requestURL = generateBasicURL(query, form.getPlaceTypes(), form);
			
			List<SimpleSearchPlacesBean> places = GooglePlacesParser.jsonParser(requestURL);
			/*
			if(places != null ){
				Collections.sort(places);
				
			}
			*/
			
			//System.out.println(places.size());
			SearchPlaceDetailBean[] placesArr;
			if(places != null){
				
				if(places.size() < 10)
					placesArr = new SearchPlaceDetailBean[places.size()];
				else {
					placesArr = new SearchPlaceDetailBean[10];
				}
				for (int i = 0; i<places.size() && i < 10; i++) {
					placesArr[i] = searchDAO.getDetails(places.get(i).getReference());
				}
				//System.out.print("places size is " + placesArr.length);
				//System.out.println(placesArr[0].toString());
				
				request.setAttribute("places", placesArr);
				return "simplesearch.jsp";
			}
			
			//request.setAttribute("places", placesArr);
			return "simplesearch.jsp";
		} catch (FormBeanException e) {
			errors.add(e.toString());
			return "error.jsp";
		}
	}
	
	// generate basic Google Places text search api call
	private URL generateBasicURL(String query, String types, SimpleSearchForm form){
		try{
			String places = query.replace(' ', '+');
			URL url;

			if(types.equals("All categories")){		

				url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + places + "+" + form.getSearchLocation() + "&key=" + Constants.GOOGLE_API_KEY + "&sensor=false&longitude=" + form.getLongitude() + "&latitude=" + form.getLatitude());
			} else {
				url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + places + "+" + form.getSearchLocation() + "&key=" + Constants.GOOGLE_API_KEY + "&sensor=false&longitude=" + form.getLongitude() + "&latitude=" + form.getLatitude() + "&types=" + types);
			}
			
			return url;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
