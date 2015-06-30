import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SimpleJavaGUI {

	private JFrame frame;
	private JTextField nameText;
	private JTextField ageText;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleJavaGUI window = new SimpleJavaGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimpleJavaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nameLabel = new JLabel("My name is: ");
		nameLabel.setFont(new Font("Georgia", Font.BOLD, 12));
		nameLabel.setBounds(72, 33, 99, 34);
		frame.getContentPane().add(nameLabel);
		
		nameText = new JTextField();
		nameText.setBounds(199, 40, 131, 20);
		frame.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		JLabel age = new JLabel("I am:");
		age.setFont(new Font("Georgia", Font.BOLD, 12));
		age.setBounds(72, 67, 69, 29);
		frame.getContentPane().add(age);
		
		ageText = new JTextField();
		ageText.setBounds(199, 71, 131, 20);
		frame.getContentPane().add(ageText);
		ageText.setColumns(10);
		
		lblNewLabel = new JLabel("I am a student at Year Up!");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 13));
		lblNewLabel.setBounds(129, 107, 200, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JButton whoButton = new JButton("Who are you?");
		whoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (whoButton.getText().equals("Who are you?"))
				{
					nameText.setText("Beatriz Resendiz");
					ageText.setText("18");
					whoButton.setText("Clear Me!");
				}
				else if (whoButton.getText().equals("Clear Me!"))
				{
					nameText.setText("");
					ageText.setText("");
					whoButton.setText("Who are you?");
				}
			}
		});
		whoButton.setFont(new Font("Georgia", Font.BOLD, 12));
		whoButton.setBounds(153, 152, 139, 47);
		frame.getContentPane().add(whoButton);
	}
}
