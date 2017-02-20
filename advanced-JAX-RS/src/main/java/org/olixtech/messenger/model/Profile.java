package org.olixtech.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	private long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private Date created;
	
	// Getters and Setters
	public long getId() {
		return id;
	}
	public String getProfileName() {
		return profileName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	// Methods
	public Profile(String profileName, String firstName,
			String lastName) {
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = new Date();
	}
	
	public Profile() {
		super();
	}
}
