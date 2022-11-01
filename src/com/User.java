package com;
import java.util.Date;

public class User {
	    private String email;
	    private String fullname;
	    private Date dob;
	    private String gender;
	    private String mailingAddress; 
	    private String password;
	    
	    
	    
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFullname() {
			return fullname;
		}
		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getMailingAddress() {
			return mailingAddress;
		}
		public void setMailingAddress(String mailingAddress) {
			this.mailingAddress = mailingAddress;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	   

}
