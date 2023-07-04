package model;

import java.io.Serializable;

public class ReserveBean implements Serializable{
	
	private int id;
	private String userName;
	private String date;
	private String text;
	private String start;
	private String end;
	
	public ReserveBean() {		
	}
	
	public ReserveBean(String userName, String date, String text, String start, String end) {
		this.userName = userName;
		this.date = date;
		this.text = text;
		this.start = start;
		this.end = end;
	}
	
	public ReserveBean(int id, String userName, String date, String text, String start, String end) {
		this.id = id;
		this.userName = userName;
		this.date = date;
		this.text = text;
		this.start = start;
		this.end = end;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getDate() {
		return date;
	}

	public String getText() {
		return text;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}	
	
}
