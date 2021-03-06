package edu.cmu.ebiz.task8.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class DemographicForm extends FormBean {
	private String state;
	private String city;
	private String area;
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		
		if (state == null || state.trim().length() == 0) {
			errors.add("State is required!");
		}
		
		if (city == null || city.trim().length() == 0) {
			errors.add("City is required!");
		}
		/*
		if (area == null || area.trim().length() == 0) {
			errors.add("Area is required!");
		}
		*/
		return errors;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getArea() {
		return area;
	}

	public void setState(String state) {
		this.state = trimAndConvert(state, "<>\"");;
	}

	public void setCity(String city) {
		this.city = trimAndConvert(city, "<>\"");;
	}

	public void setArea(String area) {
		this.area = trimAndConvert(area, "<>\"");
	}
	
}
