package com.swingtodoapp.www;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingToDoApp extends JFrame {
	private DefaultListModel<String> taskListModel;
	private JList<String> taskList;
	private JTextField taskField;
	private JButton addButton, deleteButton;

	public SwingToDoApp() {
		setTitle("To-Do List");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // center the window

		// Model for storing tasks
		taskListModel = new DefaultListModel<>();
		taskList = new JList<>(taskListModel);
		JScrollPane scrollPane = new JScrollPane(taskList);

		// Input field and buttons
		taskField = new JTextField(20);
		addButton = new JButton("Add");
		deleteButton = new JButton("Delete");

		// Panel for input
		JPanel inputPanel = new JPanel();
		inputPanel.add(taskField);
		inputPanel.add(addButton);
		inputPanel.add(deleteButton);

		// Add listeners
		addButton.addActionListener(e -> {
			String task = taskField.getText().trim();
			if (!task.isEmpty()) {
				taskListModel.addElement(task);
				taskField.setText("");
			}
		});

		deleteButton.addActionListener(e -> {
			int selectedIndex = taskList.getSelectedIndex();
			if (selectedIndex != -1) {
				taskListModel.remove(selectedIndex);
			}
		});

		// Layout
		setLayout(new BorderLayout());
		add(inputPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new SwingToDoApp().setVisible(true);
		});
	}
}