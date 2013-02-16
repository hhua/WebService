package edu.cmu.ebiz.task8.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class PolicyForm extends FormBean {
	
	private String state;
	private String city;
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		
		if(state == null || state.trim() == null){
			errors.add("State is required");
		}
		
		if(city == null || city.trim() == null){
			errors.add("State is required");
		}
		
		return errors;
		
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = trimAndConvert(state, "<>\"");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = trimAndConvert(city, "<>\"");
	}

}
