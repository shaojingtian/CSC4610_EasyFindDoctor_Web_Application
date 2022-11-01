package com;

import java.util.Date;

public class Doctor {
	private int id;
    private String fullname;
    private String email;
    private String phone;
    private int gender_num;
    private int specialty_num ; 
    private int location_num;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getGender_num() {
		return gender_num;
	}
	public void setGender_num(int gender_num) {
		this.gender_num = gender_num;
	}
	public int getSpecialty_num() {
		return specialty_num;
	}
	public void setSpecialty_num(int specialty_num) {
		this.specialty_num = specialty_num;
	}
	public int getLocation_num() {
		return location_num;
	}
	public void setLocation_num(int location_num) {
		this.location_num = location_num;
	}
    
    
    
}
