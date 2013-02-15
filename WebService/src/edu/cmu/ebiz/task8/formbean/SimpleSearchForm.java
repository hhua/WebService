package edu.cmu.ebiz.task8.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SimpleSearchForm extends FormBean{
	private String searchPlaces;
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		
		return errors;
	}

	public String getSearchPlaces() {
		return searchPlaces;
	}

	public void setSearchPlaces(String searchPlaces) {
		this.searchPlaces = trimAndConvert(searchPlaces.trim(), "<>\"");
	}
	
	
}
