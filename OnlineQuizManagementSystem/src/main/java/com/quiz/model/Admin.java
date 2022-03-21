package com.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Admin is the Entity representing admin_table in database
 *
 * @author Malatesh A
 *
 */
@Entity
@Table(name = "admin_table")
public class Admin {

	@Id
	@Column(name = "admin_id")
	private int adminId;

	@Column(name = "admin_name")
	private String adminName;

	@Column(name = "admin_password")
	private String adminPassword;

	/**
	 * Admin Constructor with fields as parameters
	 *
	 * @param adminId       the admin Id
	 * @param adminName     the name of admin
	 * @param adminPassword the password of admin
	 * 
	 */

	public Admin(int adminId, String adminName, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	/**
	 * Admin default Constructor
	 */

	public Admin() {
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
	}

}