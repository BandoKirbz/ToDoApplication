package com.example.webui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ButtonBar extends JPanel{

	private JButton addTask;
	private JButton delete;
	
	Border lineBorder = BorderFactory.createLineBorder(Color.yellow, 5);
	
	//Constuctor
	ButtonBar(){
		this.setPreferredSize(new Dimension(400,60));
		
		
		addTask = new JButton("Add Task");
		addTask.setBorder(lineBorder);
		addTask.setFont(new Font("Sans-serif",Font.PLAIN,20));
		//addTask.setVerticalAlignment(ABORT);
		
		this.add(addTask);
		this.add(Box.createHorizontalStrut(20));
		
		delete = new JButton("Delete Task");
		delete.setBorder(lineBorder);
		delete.setFont(new Font("Sans-serif",Font.PLAIN,20));
		this.add(delete);
	}
	
	public JButton getAddTask() {
		return addTask;
	}
	
	public JButton getDeleted() {
		return delete;
	}
}
