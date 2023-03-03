package com.project.entity;
// Generated 03-Mar-2023, 8:40:48 pm by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * PatientPrimary generated by hbm2java
 */
@Entity
@Table(name = "patient_primary", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ADDRESS_ID"), @UniqueConstraint(columnNames = "ADHAAR_CARD"),
		@UniqueConstraint(columnNames = "EMAIL"), @UniqueConstraint(columnNames = "PHONE"),
		@UniqueConstraint(columnNames = "SECURITY_QUESTIONS_ID") })
public class PatientPrimary implements java.io.Serializable {

	private Integer uid;
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
	//private String extCol1;
	//private String extCol2;
	//private String extCol3;
	//private Set patientMedLogs = new HashSet(0);

	public PatientPrimary() {
	}

	public PatientPrimary(String fname, String lname, String email, String pwd, Date dateOfBirth, String adhaarCard,
			String phone, char gender, char maritalStatus, String occupation, Date lastUpdated) {
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
		//this.extCol1 = extCol1;
		//this.extCol2 = extCol2;
		//this.extCol3 = extCol3;
		//this.patientMedLogs = patientMedLogs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "UID", unique = true, nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_ID", unique = true)
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MED_RECORD_ID")
	public PatientMedRecord getPatientMedRecord() {
		return this.patientMedRecord;
	}

	public void setPatientMedRecord(PatientMedRecord patientMedRecord) {
		this.patientMedRecord = patientMedRecord;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECURITY_QUESTIONS_ID", unique = true)
	public SecurityQuestions getSecurityQuestions() {
		return this.securityQuestions;
	}

	public void setSecurityQuestions(SecurityQuestions securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	@Column(name = "PROFILE_PHOTO", length = 100)
	public String getProfilePhoto() {
		return this.profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	@Column(name = "FNAME", nullable = false, length = 50)
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column(name = "LNAME", nullable = false, length = 50)
	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Pwd", nullable = false)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date_of_Birth", nullable = false, length = 10)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "ADHAAR_CARD", unique = true, nullable = false, length = 12)
	public String getAdhaarCard() {
		return this.adhaarCard;
	}

	public void setAdhaarCard(String adhaarCard) {
		this.adhaarCard = adhaarCard;
	}

	@Column(name = "PHONE", unique = true, nullable = false, length = 13)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "GENDER", nullable = false, length = 1)
	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Column(name = "MARITAL_STATUS", nullable = false, length = 1)
	public char getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(char maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Column(name = "OCCUPATION", nullable = false, length = 100)
	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name = "SECURITY_QUESTIONS_ANSWER", length = 100)
	public String getSecurityQuestionsAnswer() {
		return this.securityQuestionsAnswer;
	}

	public void setSecurityQuestionsAnswer(String securityQuestionsAnswer) {
		this.securityQuestionsAnswer = securityQuestionsAnswer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED", nullable = false, length = 19)
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/*
	 * @Column(name = "EXT_COL_1", length = 100) public String getExtCol1() { return
	 * this.extCol1; }
	 * 
	 * public void setExtCol1(String extCol1) { this.extCol1 = extCol1; }
	 * 
	 * @Column(name = "EXT_COL_2", length = 100) public String getExtCol2() { return
	 * this.extCol2; }
	 * 
	 * public void setExtCol2(String extCol2) { this.extCol2 = extCol2; }
	 * 
	 * @Column(name = "EXT_COL_3", length = 100) public String getExtCol3() { return
	 * this.extCol3; }
	 * 
	 * public void setExtCol3(String extCol3) { this.extCol3 = extCol3; }
	 * 
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "patientPrimary") public Set
	 * getPatientMedLogs() { return this.patientMedLogs; }
	 * 
	 * public void setPatientMedLogs(Set patientMedLogs) { this.patientMedLogs =
	 * patientMedLogs; }
	 */
}
