package project.ui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import project.Application;
import project.JO;
import project.models.Appointment;
import project.models.Patient;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

//Open with -> WindowBuilder Editor (used to design the layout)

public class AppointmentPanel extends JPanel {

	private JTextField txtAppointmentDate;
	private JTextField txtAppointmentPatientNumber;

	public void setTxtAppointmentPatientNumber(int patientNumber) {
		this.txtAppointmentPatientNumber.setText(Integer.toString(patientNumber));;
	}

	private JTextField txtHeight;
	private JTextField txtWeight;
	private JTextField txtHeartRate;
	private JTextField txtSystolicBP;
	private JTextField txtDiastolicBP;

	public AppointmentPanel() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(16, 6, 160, 16);
		add(lblNewLabel);

		JLabel label = new JLabel("Patient Number");
		label.setBounds(16, 34, 160, 16);
		add(label);

		JLabel label_1 = new JLabel("Height (in)");
		label_1.setBounds(16, 62, 160, 16);
		add(label_1);

		JLabel label_2 = new JLabel("Weight (lb)");
		label_2.setBounds(16, 90, 160, 16);
		add(label_2);

		JLabel label_4 = new JLabel("Heart Rate (bpm)");
		label_4.setBounds(16, 118, 160, 16);
		add(label_4);

		JLabel label_5 = new JLabel("Systolic Blood Pressure (mmHg)");
		label_5.setBounds(16, 146, 210, 16);
		add(label_5);

		JLabel label_6 = new JLabel("Diastolic Blood Pressure (mmHg)");
		label_6.setBounds(16, 175, 210, 16);
		add(label_6);

		txtAppointmentDate = new JTextField();
		txtAppointmentDate.setBounds(228, 1, 200, 26);
		add(txtAppointmentDate);
		txtAppointmentDate.setColumns(10);

		txtAppointmentPatientNumber = new JTextField();
		txtAppointmentPatientNumber.setColumns(10);
		txtAppointmentPatientNumber.setBounds(228, 29, 200, 26);
		add(txtAppointmentPatientNumber);

		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		txtHeight.setBounds(228, 57, 200, 26);
		add(txtHeight);

		txtWeight = new JTextField();
		txtWeight.setColumns(10);
		txtWeight.setBounds(228, 85, 200, 26);
		add(txtWeight);

		txtHeartRate = new JTextField();
		txtHeartRate.setColumns(10);
		txtHeartRate.setBounds(228, 142, 200, 26);
		add(txtHeartRate);

		txtSystolicBP = new JTextField();
		txtSystolicBP.setColumns(10);
		txtSystolicBP.setBounds(228, 170, 200, 26);
		add(txtSystolicBP);

		txtDiastolicBP = new JTextField();
		txtDiastolicBP.setColumns(10);
		txtDiastolicBP.setBounds(228, 113, 200, 26);
		add(txtDiastolicBP);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //this is a method to show what happens when the button is clicked

				Patient patient = new Patient(); //create a new object called patient
				Appointment appointment = new Appointment(); //create a new object called appointment
				
				patient.setPatientNumber(Integer.parseInt(txtAppointmentPatientNumber.getText()));

				if (!patient.isPatientSaved()) { //if there is no patient saved, then error message pops up
					JOptionPane.showMessageDialog(null, "PATIENT NUMBER IS NOT FOUND", "ERROR",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				//populating the appointment object with the information user inputed
				appointment.setAppointmentDate(txtAppointmentDate.getText()); 
				appointment.setHeight(Integer.parseInt(txtHeight.getText()));
				appointment.setWeight(Integer.parseInt(txtWeight.getText()));
				appointment.setHeartRate(Integer.parseInt(txtHeartRate.getText()));
				appointment.setSystolicBloodPressure(Integer.parseInt(txtSystolicBP.getText()));
				appointment.setDiastolicBloodPressure(Integer.parseInt(txtDiastolicBP.getText()));

				String serializedAppointmentData = JO.toJson(appointment); // converting object to Json

				Application.createDirectoryIfNotExist("Appointment"); // make sure there's a appointment folder
				Application.createDirectoryIfNotExist("Appointment/" + patient.getPatientNumber()); // make sure there's
																									// a folder for
																									// every patient to
																									// store their
																									// appointments
				Application.writeOutput(
						"Appointment/" + patient.getPatientNumber() + "/" + new Random().nextInt(99999) + ".dat", //how the file named when saved
						serializedAppointmentData); // file name, content

			}
		});
		btnNewButton.setBounds(160, 236, 117, 29);
		add(btnNewButton);

	}

}
