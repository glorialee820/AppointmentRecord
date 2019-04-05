package project.ui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;

//main user interface class
//set up initial ui objects 
//created in WindowBuilder Editor 

public class MainFrame extends JFrame {

	private JTabbedPane tabbedPane; // instance variable

	public MainFrame() {
		setSize(new Dimension(550, 450));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new PatientListPanel(tabbedPane);
		tabbedPane.addTab("Patient", null, panel, null);

		JPanel panel2 = new AppointmentListPanel(tabbedPane);
		tabbedPane.addTab("Appointment", null, panel2, null);

	}

}