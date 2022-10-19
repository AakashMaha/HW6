package hw6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Main {
	private static JButton inputBtn;
	private static JButton outputBtn;
	private static JButton computeBtn;
	private static JFrame jframeWindow;
	private static JPanel panel;
	private static File fileToRead;
	private static File fileToSave;

	static double sumOfSquares = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		constructAppWindow();
		addListenerEvents();
	}

	private static void constructAppWindow() {
		jframeWindow = new JFrame();
		jframeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// construct a panel container to store buttons, etc.
		panel = new JPanel(new GridLayout(2, 0)); // 3 ROWS NO COLUMNS
		panel.setPreferredSize(new Dimension(500, 150));
		panel.setBackground(Color.DARK_GRAY);

		// build buttons, etc. and add them to the panel
		inputBtn = new JButton("Pick file to analyze");
		computeBtn = new JButton("Analyze");
		panel.add(inputBtn);
		panel.add(computeBtn);

		// add panel to the application window
		jframeWindow.add(panel);

		// TASK 5: MAKE THE APPLICATION WINDOW VISIBLE TO THE USER
		jframeWindow.pack();
		jframeWindow.setVisible(true);
	}

	private static void addListenerEvents() {
		inputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				requestInputFile();
			}
		});
		computeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
					try {
						computeSomething();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});

	}

	public static void requestInputFile() {
		// parent component of the dialog
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JAVA FILES", "java", "java");
		jfc.setFileFilter(filter); // ONLY SHOW TEXT FILES FOR EASE OF USE
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			fileToRead = jfc.getSelectedFile();
			System.out.println(fileToRead.getAbsolutePath());
		}
	}
	public static void computeSomething() throws IOException {
			System.out.println("Lines of Code: " + analyzer.countLines(fileToRead));
//			System.out.println("Lines of Comment: " + analyzer.countCom(fileToRead));

			System.out.println("Number of For Loops: " + analyzer.countFor(fileToRead));
			System.out.println("Number of While Loops: " + analyzer.countWhile(fileToRead));
			System.out.println("Number of If Statements: " + analyzer.countIf(fileToRead));
			System.out.println("Number of Else Statements: " + analyzer.countElse(fileToRead));
			System.out.println("Number of Else If Statements: " + analyzer.countElseIf(fileToRead));

	}

}
