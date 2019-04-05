package project.models;

import java.io.File;

import com.google.gson.annotations.Expose;

//All the properties of the patient panel

public class Patient {
	@Expose 
	private String name; 
	@Expose
	private int patientNumber; 
	@Expose
	private int age;
	@Expose
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(int patientNumber) {
		this.patientNumber = patientNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isPatientSaved() { //method created to see if the patient has a file saved for them
		File theFile = new File("Patients/" + patientNumber + ".dat");

		return theFile.exists();

	}

	public String toString() { //method to overrides the default toString() method which means the patient name is shown instead of showing patient
		return getName(); 
	}

}