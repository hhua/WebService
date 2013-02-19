package edu.cmu.ebiz.task8.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
			//System.out.println(places.size());
			if(places != null){
				SearchPlaceDetailBean[] placesArr = new SearchPlaceDetailBean[places.size()];
				for (int i = 0; i<places.size(); i++) {
					placesArr[i] = searchDAO.getDetails(places.get(i).getReference());
				}
				Arrays.sort(placesArr);
				
				if(placesArr.length <= 10)
					request.setAttribute("places", placesArr);
				else{
					SearchPlaceDetailBean[] returnPlaces = new SearchPlaceDetailBean[10];
					for(int i = 0; i < 10; i++){
						returnPlaces[i] = placesArr[i];
					}
					request.setAttribute("places", returnPlaces);
				}
			}
			
			
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
