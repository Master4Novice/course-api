package io.abhi.data;

public class Patient {

	private int patientId;
	private String name;
	private String fatherName;
	private String address;
	private String contactNo;
	private String emailId;
	private String age;
	private String gender;
	private String bloodGroup;
	private String remarks;

	public Patient() {

	}

	public Patient(int patientId, String name, String fatherName, String address, String contactNo, String emailId,
			String age, String gender, String bloodGroup, String remarks) {
		this.patientId = patientId;
		this.name = name;
		this.fatherName = fatherName;
		this.address = address;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.age = age;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.remarks = remarks;
	}


	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}




}
