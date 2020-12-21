package fundamentals;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class WorkWithSwing {

	public void createSimpleFrame() {
		JFrame frame = new JFrame("My First GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		JButton button = new JButton("Press");
		frame.getContentPane().add(button); // Adds Button to content pane of frame
		frame.setVisible(true);
	}
	
	public void createMoreComplexGUI() {
		//Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        JMenuItem m33 = new JMenuItem("Exit");
        m1.add(m11);
        m1.add(m22);
        m1.add(m33);
        
        JMenuItem m21 = new JMenuItem("About");
        JMenuItem m221 = new JMenuItem("Check for updates");
        m2.add(m21);
        m2.add(m221);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        // Text Area at the Center
        JTextArea ta = new JTextArea();
        
        // Perform actions with buttons
        send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				printMsg("Pressed send button");
				if(!tf.getText().isEmpty())
				{
					printMsg(tf.getText());
					ta.append("Sam: " + tf.getText() + " (" + getCurrentTime() + ")\n");
					tf.setText("");
				}
			}
        	
        });
        
        reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printMsg("Pressed reset button");
				ta.setText("");
				tf.setText("");
			}
		});
        
        // Act on menu items
        m11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printMsg("Pressed Open menu option");
			}
		});
        
        m22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printMsg("Pressed Save As menu option");
			}
		});

        // When selecting the Exit option, exit program.
        m33.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				printMsg("Pressed Exit menu option");
				
				WorkWithFiles wf = new WorkWithFiles();
				String fname = getDateTime() + ".txt";
				wf.createFile(fname);
				wf.updateFile(fname, ta.getText());
				
				System.exit(0);
			}
		});
        
        m21.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printMsg("Pressed About menu option");
			}
		});
        m221.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printMsg("Pressed Check for updates menu option");
			}
		});
        
        tf.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        			printMsg(tf.getText());
        			if(!tf.getText().isEmpty())
    				{
    					ta.append("Sam: " + tf.getText() + " (" + getCurrentTime() + ")\n");
	        			tf.setText("");
    				}
        		}
        	}
		});

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
	}
	
	/**
	 * This method captures the local date time and returns in a specified format 
	 * @return
	 * 		String object containing date time format
	 */
	public String getDateTime() {
		DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"); 
		LocalDateTime datetime = LocalDateTime.now(); 
		String output = datetime.format(oldPattern);

		return output;
	}
	
	/**
	 * This method computes and returns the current time
	 * @return
	 * 		String object with current time
	 */
	public String getCurrentTime() {
		DateTimeFormatter oldPattern = DateTimeFormatter.ofPattern("HH:mm:ss"); 
		LocalDateTime datetime = LocalDateTime.now(); 
		String output = datetime.format(oldPattern);

		return output;
	}
	
	/**
	 * This method prints a message to the console.
	 * @param msg
	 * 			The message to print to the console.
	 */
	public void printMsg(String msg) {
		System.out.println(msg);
	}
}
