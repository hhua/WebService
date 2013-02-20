/**
 * @author Shoucong Chen
 * Feb 19, 2013
 */

package edu.cmu.ebiz.task8.bean;

public class PlaceReviewBean {
	private String time;
	private String text;
	private String author;
	private String url;
	
	public String getTime() {
		return time;
	}
	public String getText() {
		return text;
	}
	public String getAuthor() {
		return author;
	}
	public String getUrl() {
		return url;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "PlaceReviewBean [time=" + time + ", text=" + text
				+ ", author=" + author + ", url=" + url + "]";
	}
}
