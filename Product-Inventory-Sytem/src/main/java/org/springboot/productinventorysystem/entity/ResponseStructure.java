package org.springboot.productinventorysystem.entity;


//ResponseStructure<T> is a generic wrapper class used to send a consistent API response structure containing data (T),
//message, and status across all end points.

public class ResponseStructure<T> {
	
	private String message;
	private int statuscode;
	private T data;
	
//	no argument constructor
	public ResponseStructure() {
		super();
	}
	
//	Parameterize constructor
	public ResponseStructure(String message, int statuscode, T data) {
		super();
		this.message = message;
		this.statuscode = statuscode;
		this.data = data;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	

}
