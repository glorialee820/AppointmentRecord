package project.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//technically don't use this because I have to save a patient before I can put an appointment for them
//made another way to get to the appointment panel, but don't need it


//this panel displays a button used to add an appointment button 

public class AppointmentListPanel extends JPanel {

	public AppointmentListPanel(JTabbedPane tabbedPane) {

		setLayout(new BorderLayout(0, 0));

		JList list = new JList();
		add(list, BorderLayout.CENTER);

		JButton btnNewButton = new JButton("Add Appointment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// this is what will happen when add appointment button is clicked - code

				JPanel panel = new AppointmentPanel();

				tabbedPane.setComponentAt(1, panel);

			}
		});
		add(btnNewButton, BorderLayout.SOUTH);
	}

}

