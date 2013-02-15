package edu.cmu.ebiz.task8.bean;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SimpleSearchPlacesBean {
	private double longitude;
	private double latitude;
	private String address;
	private URL iconURL;
	private String name;
	private String id;
	private boolean isOpen;
	private long priceLevel;
	private double rating;
	private List<String> types = new ArrayList<String>();
	private String reference;
	private List<SearchPlacePhoto> photos = new ArrayList<SearchPlacePhoto>();
	
	public SimpleSearchPlacesBean(){
		
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public URL getIconURL() {
		return iconURL;
	}

	public void setIconURL(URL iconURL) {
		this.iconURL = iconURL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public long getPriceLevel() {
		return priceLevel;
	}

	public void setPriceLevel(long priceLevel) {
		this.priceLevel = priceLevel;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<SearchPlacePhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(List<SearchPlacePhoto> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "SimpleSearchPlacesBean [longitude=" + longitude + ", latitude="
				+ latitude + ", address=" + address + ", iconURL=" + iconURL
				+ ", name=" + name + ", id=" + id + ", isOpen=" + isOpen
				+ ", priceLevel=" + priceLevel + ", rating=" + rating
				+ ", types=" + types + ", reference=" + reference + ", photos="
				+ photos + "]";
	}
	
}
