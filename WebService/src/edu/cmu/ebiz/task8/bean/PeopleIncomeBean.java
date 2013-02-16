package edu.cmu.ebiz.task8.bean;

public class PeopleIncomeBean {
	private String nationIncome;
	private double nationP;
	private String cityIncome;
	private double cityP;
	private String neighborIncome;
	private double neighborP;
	
	public double getNationP() {
		return nationP;
	}
	public double getCityP() {
		return cityP;
	}
	public double getNeighborP() {
		return neighborP;
	}
	public void setNationP(double nationP) {
		this.nationP = nationP;
	}
	public void setCityP(double cityP) {
		this.cityP = cityP;
	}
	public void setNeighborP(double neighborP) {
		this.neighborP = neighborP;
	}
	public String getNationIncome() {
		return nationIncome;
	}
	public String getCityIncome() {
		return cityIncome;
	}
	public String getNeighborIncome() {
		return neighborIncome;
	}
	public void setNationIncome(String nationIncome) {
		this.nationIncome = nationIncome;
		
	}
	public void setCityIncome(String cityIncome) {
		this.cityIncome = cityIncome;
	}
	public void setNeighborIncome(String neighborIncome) {
		this.neighborIncome = neighborIncome;
	}
}
