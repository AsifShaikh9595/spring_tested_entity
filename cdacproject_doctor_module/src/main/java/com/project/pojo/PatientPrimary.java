package com.project.pojo;
// Generated 24-Feb-2023, 5:28:10 pm by Hibernate Tools 5.4.33.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PatientPrimary generated by hbm2java
 */
public class PatientPrimary implements java.io.Serializable {

	private int uid;
	private Address address;
	private PatientMedRecord patientMedRecord;
	private SecurityQuestions securityQuestions;
	private String profilePhoto;
	private String fname;
	private String lname;
	private String email;
	private String pwd;
	private Date dateOfBirth;
	private String adhaarCard;
	private String phone;
	private char gender;
	private char maritalStatus;
	private String occupation;
	private String securityQuestionsAnswer;
	private Date lastUpdated;
	private String extCol1;
	private String extCol2;
	private String extCol3;
	private Set patientMedLogs = new HashSet(0);

	public PatientPrimary() {
	}

	public PatientPrimary(Address address, PatientMedRecord patientMedRecord, SecurityQuestions securityQuestions,
			String fname, String lname, String email, String pwd, Date dateOfBirth, String adhaarCard, String phone,
			char gender, char maritalStatus, String occupation, String securityQuestionsAnswer, Date lastUpdated) {
		this.address = address;
		this.patientMedRecord = patientMedRecord;
		this.securityQuestions = securityQuestions;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pwd = pwd;
		this.dateOfBirth = dateOfBirth;
		this.adhaarCard = adhaarCard;
		this.phone = phone;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
		this.securityQuestionsAnswer = securityQuestionsAnswer;
		this.lastUpdated = lastUpdated;
	}

	public PatientPrimary(Address address, PatientMedRecord patientMedRecord, SecurityQuestions securityQuestions,
			String profilePhoto, String fname, String lname, String email, String pwd, Date dateOfBirth,
			String adhaarCard, String phone, char gender, char maritalStatus, String occupation,
			String securityQuestionsAnswer, Date lastUpdated, String extCol1, String extCol2, String extCol3,
			Set patientMedLogs) {
		this.address = address;
		this.patientMedRecord = patientMedRecord;
		this.securityQuestions = securityQuestions;
		this.profilePhoto = profilePhoto;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pwd = pwd;
		this.dateOfBirth = dateOfBirth;
		this.adhaarCard = adhaarCard;
		this.phone = phone;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
		this.securityQuestionsAnswer = securityQuestionsAnswer;
		this.lastUpdated = lastUpdated;
		this.extCol1 = extCol1;
		this.extCol2 = extCol2;
		this.extCol3 = extCol3;
		this.patientMedLogs = patientMedLogs;
	}

	public int getUid() {
		return this.uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public PatientMedRecord getPatientMedRecord() {
		return this.patientMedRecord;
	}

	public void setPatientMedRecord(PatientMedRecord patientMedRecord) {
		this.patientMedRecord = patientMedRecord;
	}

	public SecurityQuestions getSecurityQuestions() {
		return this.securityQuestions;
	}

	public void setSecurityQuestions(SecurityQuestions securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	public String getProfilePhoto() {
		return this.profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAdhaarCard() {
		return this.adhaarCard;
	}

	public void setAdhaarCard(String adhaarCard) {
		this.adhaarCard = adhaarCard;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(char maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSecurityQuestionsAnswer() {
		return this.securityQuestionsAnswer;
	}

	public void setSecurityQuestionsAnswer(String securityQuestionsAnswer) {
		this.securityQuestionsAnswer = securityQuestionsAnswer;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getExtCol1() {
		return this.extCol1;
	}

	public void setExtCol1(String extCol1) {
		this.extCol1 = extCol1;
	}

	public String getExtCol2() {
		return this.extCol2;
	}

	public void setExtCol2(String extCol2) {
		this.extCol2 = extCol2;
	}

	public String getExtCol3() {
		return this.extCol3;
	}

	public void setExtCol3(String extCol3) {
		this.extCol3 = extCol3;
	}

	public Set getPatientMedLogs() {
		return this.patientMedLogs;
	}

	public void setPatientMedLogs(Set patientMedLogs) {
		this.patientMedLogs = patientMedLogs;
	}

}