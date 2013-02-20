package edu.cmu.ebiz.task8.formbean;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class PolicyForm extends FormBean {
	private String state;
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		
		if (state == null || state.trim().length() == 0) {
			errors.add("State is required!");
		}
		
		return errors;
	}

	public String getState() {
		return state;
	}
	
	
	public void setState(String state) {
		this.state = trimAndConvert(state, "<>\"");;
	}


}
