package com.example.webui;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicationFrame extends JFrame{
	
	private TitleBar title;
	private List list;
	private ButtonBar btnBar;
	
	private JButton addTask;
	private JButton delete;
	
	//Constructor
	ApplicationFrame(){
		this.setSize(400,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		title = new TitleBar();
		list = new List();
		btnBar = new ButtonBar();
		
		this.add(title, BorderLayout.NORTH);
		this.add(btnBar,BorderLayout.SOUTH);
		this.add(list,BorderLayout.CENTER);
		
		addTask = btnBar.getAddTask();
		delete = btnBar.getDeleted();
		
		addListeners();
		
	}
	
	public void addListeners() {
		addTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Task task = new Task();
				list.add(task);
				list.taskNumbers();
				
				task.getDone().addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						task.changeState();
						list.taskNumbers();
						revalidate();
					}
				});
			}
		});
		
		delete.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				list.removeCompletedTask();
				repaint();
			}
		});
	}
	
}
