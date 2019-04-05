package project.models;

import com.google.gson.annotations.Expose;

// All the properties of the appointment panel 

public class Appointment {

	@Expose //@Expose is an annotation marker to tell Gson to save it
	private String appointmentDate;
	@Expose // @Expose takes one thing as a time and decouples variables
	private int patientNumber;
	@Expose
	private double weight; 
	@Expose
	private double height;
	@Expose
	private int heartRate;
	@Expose
	private int systolicBloodPressure;
	@Expose
	private int diastolicBloodPressure;

	public String getAppointmentDate() {
		return appointmentDate;
	}
	
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public int getSystolicBloodPressure() {
		return systolicBloodPressure;
	}

	public void setSystolicBloodPressure(int systolicBloodPressure) {
		this.systolicBloodPressure = systolicBloodPressure;
	}

	public int getDiastolicBloodPressure() {
		return diastolicBloodPressure;
	}

	public void setDiastolicBloodPressure(int diastolicBloodPressure) {
		this.diastolicBloodPressure = diastolicBloodPressure;
	}

}
