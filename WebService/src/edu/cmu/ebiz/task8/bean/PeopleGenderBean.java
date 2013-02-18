package edu.cmu.ebiz.task8.bean;

public class PeopleGenderBean {
	private String divorcedFemale;
	private String divorcedMale;
	private String marriedFemale;
	private String marriedMale;
	private String singleFemale;
	private String singleMale;
	private String widowedFemale;
	private String widowedMale;
	
	public PeopleGenderBean() {
		
	}
	
	public PeopleGenderBean(String msg) {
		this.divorcedFemale = msg;
		this.divorcedMale = msg;
		this.marriedFemale = msg;
		this.marriedMale = msg;
		this.singleFemale = msg;
		this.singleMale = msg;
		this.widowedFemale = msg;
		this.widowedMale = msg; 
	}
	
	public String getDivorcedFemale() {
		return divorcedFemale;
	}
	public String getDivorcedMale() {
		return divorcedMale;
	}
	public String getMarriedFemale() {
		return marriedFemale;
	}
	public String getMarriedMale() {
		return marriedMale;
	}
	public String getSingleFemale() {
		return singleFemale;
	}
	public String getSingleMale() {
		return singleMale;
	}
	public String getWidowedFemale() {
		return widowedFemale;
	}
	public String getWidowedMale() {
		return widowedMale;
	}
	public void setDivorcedFemale(String divorcedFemale) {
		this.divorcedFemale = divorcedFemale;
	}
	public void setDivorcedMale(String divorcedMale) {
		this.divorcedMale = divorcedMale;
	}
	public void setMarriedFemale(String marriedFemale) {
		this.marriedFemale = marriedFemale;
	}
	public void setMarriedMale(String marriedMale) {
		this.marriedMale = marriedMale;
	}
	public void setSingleFemale(String singleFemale) {
		this.singleFemale = singleFemale;
	}
	public void setSingleMale(String singleMale) {
		this.singleMale = singleMale;
	}
	public void setWidowedFemale(String widowedFemale) {
		this.widowedFemale = widowedFemale;
	}
	public void setWidowedMale(String widowedMale) {
		this.widowedMale = widowedMale;
	}
}
