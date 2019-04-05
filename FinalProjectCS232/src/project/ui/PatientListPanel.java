package project.ui;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import project.Application;
import project.JO;
import project.models.Patient;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PatientListPanel extends JPanel {

	JList list;
	JTabbedPane tabbedPane; //PatientPanel needs to access tabbedPane (parent) - add itself to parent

	public PatientListPanel(JTabbedPane _tabbedPane) { // only passing in tabbedPane because we don't need the entire MainFrame (need to access tabbedPane which is in MainFrame)

		tabbedPane = _tabbedPane; 

		setLayout(new BorderLayout(0, 0));

		JButton btnNewButton = new JButton("Add Patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// this is what will happen when add patient button is clicked - code

				JPanel panel = new PatientPanel();

				tabbedPane.setComponentAt(0, panel);

			}
		});
		add(btnNewButton, BorderLayout.SOUTH);

		loadPatients();
	}

	public void loadPatients() { //method created to load patients

		// 1) get all files in Patients folder
		List<String> fileNames = new ArrayList<String>(); //list of file names "Patient/PatientNumber.dat"
		List<Patient> patients = new ArrayList<Patient>(); //list of actual patients

		File[] files = new File("Patients").listFiles(); //listFiles gets the names of the patients in the folder Patients
		
		// (type of object in list (File) what you want to name the object when using it(file) : list it's coming from (files)
		for (File file : files) { //for loop to go through files
			if (file.isFile()) { //isFile showing it's a file not a folder
				fileNames.add(file.getAbsolutePath()); //if it's a file, then putting the full path(saying where the file is on the hard drive) into the file names list
			}
		}

		// 2) for each file in list 1, read file to string (loop is to give us all the patients in the system)

		for (String fileName : fileNames) { 
			try {

				if (Application.getFileExtension(fileName).equals("dat")) { // using .dat to mark them as patient files, so if another file extension like .txt doesn't break code

					String serializedPatientData = Application.readInput(fileName);  // telling which file to be read from, serialized patient data is being read

					// 3) use JO to convert string to patient

					Patient patient = JO.fromJson(serializedPatientData, Patient.class);

					// 4) add patient to master list of patients

					patients.add(patient);

				}
			}

			catch (Exception e) {

				System.out.println(fileName); //this will tell us where the error is

				System.out.println(e.toString()); //toString() returns the error message

			}
		}

		// 5) for each patient in patients list, add to display on patients tab
		DefaultListModel listModel = new DefaultListModel();

		for (Patient patient : patients) {

			listModel.addElement(patient);

		}

		list = new JList(listModel);

		// double clicking patient opens up the appointment panel
		
		list.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {

				if (list.getCellBounds(list.getSelectedIndex(), list.getSelectedIndex()).contains(evt.getPoint())//you have to double click something and thing you select has to be under your mouse
						&& evt.getClickCount() == 2) {
					Patient selectedPatient = (Patient) list.getSelectedValue();

					AppointmentPanel panel = new AppointmentPanel(); // setTxtAppointmentPatientNumber only valid in AppointmentPanel

					panel.setTxtAppointmentPatientNumber(selectedPatient.getPatientNumber());

					tabbedPane.setComponentAt(1, panel);
					tabbedPane.setSelectedComponent(panel);

				}

			}
		});

		add(list, BorderLayout.CENTER);
	}

}