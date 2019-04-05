package project.ui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import project.Application;
import project.JO;
import project.models.Patient;

import javax.swing.event.ChangeEvent;

public class PatientPanel extends JPanel {
	private JTextField txtPatientName;
	private JTextField txtPatientNumber;
	private JTextField txtPatientAge;

	public PatientPanel() {
		setLayout(null);

		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setBounds(66, 6, 100, 16);
		add(lblPatientName);

		JLabel lblPatientNumber = new JLabel("Patient Number");
		lblPatientNumber.setBounds(65, 34, 100, 16);
		add(lblPatientNumber);

		JLabel label = new JLabel("Age");
		label.setBounds(66, 62, 100, 16);
		add(label);

		JLabel label_1 = new JLabel("Sex");
		label_1.setBounds(66, 91, 100, 16);
		add(label_1);

		txtPatientName = new JTextField();
		txtPatientName.setBounds(178, 1, 200, 26);
		add(txtPatientName);
		txtPatientName.setColumns(10);

		txtPatientNumber = new JTextField();
		txtPatientNumber.setColumns(10);
		txtPatientNumber.setBounds(178, 29, 200, 26);
		txtPatientNumber.setText(Integer.toString(new Random().nextInt(99999)));
		txtPatientNumber.setEditable(false);
		add(txtPatientNumber);

		txtPatientAge = new JTextField();
		txtPatientAge.setColumns(10);
		txtPatientAge.setBounds(178, 58, 200, 26);
		add(txtPatientAge);

		final JRadioButton rdbtnFemale = new JRadioButton("Female"); // need final because it's referenced in an
																   // anonymous class
		final JRadioButton rdbtnMale = new JRadioButton("Male");

		rdbtnFemale.addChangeListener(new ChangeListener() { // if female is clicked, male is not clicked
			public void stateChanged(ChangeEvent e) {
				if (rdbtnFemale.isSelected()) {
					rdbtnMale.setSelected(false);
				}
			}
		});
		rdbtnFemale.setName("");
		rdbtnFemale.setBounds(177, 87, 100, 23);
		add(rdbtnFemale);

		rdbtnMale.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnMale.isSelected()) { //if male is clicked, female is not clicked
					rdbtnFemale.setSelected(false);
				}
			}
		});

		rdbtnMale.setName("");
		rdbtnMale.setBounds(289, 87, 141, 23);
		add(rdbtnMale);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //Save button action 

				Patient patient = new Patient();

				patient.setName(txtPatientName.getText());
				patient.setPatientNumber(Integer.parseInt(txtPatientNumber.getText()));
				patient.setAge(Integer.parseInt(txtPatientAge.getText())); // ? boolean structure, if it's true, you get what's after the ?
				patient.setSex(rdbtnMale.isSelected() ? "M" : "F"); // if Male is selected then it sets it to M, if Male
																	// is not selected then it selects Female

				String serializedPatientData = JO.toJson(patient); // created information and converted to Json

				Application.createDirectoryIfNotExist("Patients"); // make sure there's a patient folder
				Application.writeOutput("Patients/" + patient.getPatientNumber() + ".dat", serializedPatientData); // file name, content

			}
		});
		btnSave.setBounds(160, 159, 117, 29);
		add(btnSave);

	}

}
