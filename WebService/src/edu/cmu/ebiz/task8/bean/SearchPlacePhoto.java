package edu.cmu.ebiz.task8.bean;

import java.util.List;

public class SearchPlacePhoto {
	private long height;
	private long width;
	private String photoReference;
	private List<String> htmlAttributions;

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public long getWidth() {
		return width;
	}

	public void setWidth(long width) {
		this.width = width;
	}

	public String getPhotoReference() {
		return photoReference;
	}

	public void setPhotoReference(String photoReference) {
		this.photoReference = photoReference;
	}

	public List<String> getHtmlAttributions() {
		return htmlAttributions;
	}

	public void setHtmlAttributions(List<String> htmlAttributions) {
		this.htmlAttributions = htmlAttributions;
	}

}
