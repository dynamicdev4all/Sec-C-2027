package com.secc.app.dto;

public class UserDataDto {
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	int _id;
	String name;
	String email;
	boolean status;
	
	public UserDataDto(int id, String name, String email, boolean status) {
		_id = id;
		this.name = name;
		this.email = email;
		this.status = status;
	}
}
