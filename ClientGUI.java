import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultCaret;


public class ClientGUI {
	private static final String connectButtonText = "Connect";
	private static final String disconnectButtonText = "Disconnect";
	private static final String enterCommandButtonText = "Enter command";
	
	private JTextArea text; //responses from the server get shown here
	private JTextField field; //user entered commands go here
	private VideoClient client;
	private JButton connectButton;
	private JButton commandButton;
	private boolean connected; //keep track of whether we are connected to the server or not
	
	private History history; //keep a record of every command sent. the user can use the up and down arrows to recall them 

	public ClientGUI()
	{
		connected = false;
		history = new History();
		client = new VideoClient();
		field = new JTextField(46);
		connectButton = new JButton(connectButtonText);
		connectButton.addActionListener(new connectButtonAction());
		
		commandButton = new JButton(enterCommandButtonText);
		commandButton.addActionListener(new commandButtonAction());
		commandButton.setEnabled(false);//do not enable this button until the TextField has some text in it
		
		text = new JTextArea(25,60);
		text.setLineWrap(false);// need to set to false to make the horizontal scroller work
		text.setEditable(false);
		text.setTabSize(4);

		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel southPanel = new JPanel();
		
		southPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		southPanel.add(field);
		southPanel.add(commandButton);
		
		panel.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		southPanel.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		
		panel.add(scroller);

		Container contentPane = frame.getContentPane();
		contentPane.add(connectButton, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		frame.setSize(800,520);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//stop the command button being enabled when there is no text in the TextField
		field.getDocument().addDocumentListener(new EnableButtonListener());
		field.addKeyListener(new HistoryListener());
		
		//make the command button the default button, meaning when you hit the enter key it'll be 'clicked'
		frame.getRootPane().setDefaultButton(commandButton);
	}
	
	private void displayError(Exception e) {
        append("ERROR: " + e.getMessage());
	}
	
	private void append(String s) {
		text.append(String.format("%s%n", s));
		scrollToEnd();
	}

	private void scrollToEnd() {
		text.setCaretPosition(text.getText().length());
	}
	
	//if the TextField is empty, disable button. otherwise enable it
	private void disableCommandButtonIfTextFieldEmpty() {
		if (field.getText().length() > 0) {
			if (!commandButton.isEnabled()) {
				commandButton.setEnabled(true);
			}
		} else {
			if (commandButton.isEnabled()) {
				commandButton.setEnabled(false);
			}
		}
	}
	
	public static void main (String[] args)
	{
		new ClientGUI();
	}

	//toggle the behavior and text of the connect/disconnect button
	private class connectButtonAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!connected) {
				//connect
				try {
					//hardcoded to connect to localhost. change this line if you want to connect to a remote host
					String msg = client.connect("localhost");
					append(msg);
					connectButton.setText(disconnectButtonText);
					//change state
					connected = !connected;
				} catch (Exception e1) {
					displayError(e1);
				}
			} else {
				//disconnect
				try {
					client.disconnect();
					append("Disconnected.");
					connectButton.setText(connectButtonText);
					//change state
					connected = !connected;
				} catch (Exception e1) {
					displayError(e1);
				}
			}
		}	
	}
	
	private class HistoryListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			//do nothing
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
				String restoredText;
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					restoredText = history.backwards();
				} else {
					restoredText = history.forwards();
				}

				field.setText(restoredText);

				//move the cursor to the end of the line
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						field.setCaretPosition(field.getText().length());
					}
				});
			}
		}

		@Override
		public void keyReleased(KeyEvent e) { 
			//do nothing
		}
		
	}
	
	private class commandButtonAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				//send user inputed command to server, display response in textfield
				append(client.sendCommand(field.getText()));
			} catch (Exception e1) {
				displayError(e1);
			}
			//add the command to the history
			history.add(field.getText());
			//clear the text field so the user doesn't have to manually delete their last command to enter a new one
			field.setText("");
			//bring the keyboard focus back to where you're going to want to type stuff
			field.requestFocusInWindow();
		}
		
	}
	
	private class EnableButtonListener implements DocumentListener {
		@Override
		public void changedUpdate(DocumentEvent e) {
			//Plain text components do not fire these events
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			disableCommandButtonIfTextFieldEmpty();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			disableCommandButtonIfTextFieldEmpty();
		}
		
	}
}
