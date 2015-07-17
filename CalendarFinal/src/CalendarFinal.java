import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CalendarFinal
{
	private DefaultTableModel m_defTblModel = new DefaultTableModel();
	private int m_realMonth = -1;
	private int m_realYear = -1;
	private int m_realDay = -1;
	private int m_currentMonth = -1;
	private int m_currentYear = -1;


	//UI components
	private JButton btnPrevious = null;
	private JButton btnNext = null;
	private JFrame frame;
	private JTable daysTable;
	private JLabel lblMonth = null;
	private JLabel lblChangeYear = null;
	private JComboBox comboBox = null;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					CalendarFinal window = new CalendarFinal();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public  CalendarFinal()
	{
		GregorianCalendar cal = new GregorianCalendar(); //Create calendar
		m_realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
		m_realMonth = cal.get(GregorianCalendar.MONTH); //Get month
		m_realYear = cal.get(GregorianCalendar.YEAR); //Get year
		m_currentMonth = m_realMonth; //Match month and year
		m_currentYear = m_realYear;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 473, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();

		panel.setBounds(0, 0, 462, 390);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//sets the logic for going back to previous dates
				if (m_currentMonth == 0)
				{ //goes Back one year
					m_currentMonth = 11;
					m_currentYear -= 1;
				}
				else
				{ // goes gBack one month
					m_currentMonth -= 1;
				}
				refreshCalendar(m_currentMonth, m_currentYear);
			}
		});
		btnPrevious.setBounds(10, 29, 84, 23);
		panel.add(btnPrevious);
		lblMonth = new JLabel("");
		lblMonth.setBounds(93, 21, 66, 38);
		panel.add(lblMonth);
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//sets the logic for going back to previous dates
				if (m_currentMonth == 11)
				{ //goes Back one year
					m_currentMonth = 0;
					m_currentYear += 1;
				}
				else
				{ // goes gBack one month
					m_currentMonth += 1;
				}
				refreshCalendar(m_currentMonth, m_currentYear);
			}
		});
		btnNext.setBounds(169, 29, 77, 23);
		panel.add(btnNext);
		lblChangeYear = new JLabel("Change Year:");
		lblChangeYear.setBounds(256, 29, 87, 23);
		lblChangeYear.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblChangeYear);

		comboBox = new JComboBox();
		
		//loops dates 100 years before and after the set current year, which is 2015 and displays into the drop box on the GUI
		for (int i = m_realYear - 100; i <= m_realYear +  100; i++)
		{
			comboBox.addItem(String.valueOf(i));
		}
		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (comboBox.getSelectedItem() != null)
				{
					String b = comboBox.getSelectedItem().toString();
					m_currentYear = Integer.parseInt(b); //Get the numeric value
					refreshCalendar(m_currentMonth, m_currentYear); //Refresh
				}
			}
		});
		comboBox.setBounds(363, 30, 77, 20);
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 442, 247);
		panel.add(scrollPane);
		daysTable = new JTable(m_defTblModel);
		scrollPane.setViewportView(daysTable);
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i=0; i<7; i++)
		{
			m_defTblModel.addColumn(headers[i]);
		}
		daysTable.setColumnSelectionAllowed(true);
		daysTable.setRowSelectionAllowed(true);
		daysTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Set row/column count
		daysTable.setRowHeight(38);
		m_defTblModel.setColumnCount(7);
		m_defTblModel.setRowCount(6);
		daysTable.getParent().setBackground(daysTable.getBackground());
		//automatically sets the month label to the current month of the year
		refreshCalendar(m_realMonth, m_realYear);
	}
	
	public void refreshCalendar(int monthIndex, int year)
	{
		String[] monthsList = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int numberOfDays= -1;  //Number Of Days
		int startOfMonth = -1; //Start Of Month
		btnPrevious.setEnabled(true); //Enable buttons at first
		btnNext.setEnabled(true);
		if ((monthIndex == 0) && (year <= m_realYear - 100))
		{
			//A month before January 1915 cannot be reached
			btnPrevious.setEnabled(false);
		}
		if ((monthIndex == 11) && (year >= m_realYear + 100))
		{
			//A month after December 2115 cannot be reached
			btnNext.setEnabled(false);
		}
		
		lblMonth.setText(monthsList[monthIndex]); 
		comboBox.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box,
		GregorianCalendar cal = new GregorianCalendar(year, monthIndex, 1);
		numberOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		startOfMonth = cal.get(GregorianCalendar.DAY_OF_WEEK);
		//Clear table
		for (int i=0; i<6; i++)
		{
			for (int j=0; j<7; j++)
			{
				m_defTblModel.setValueAt(null, i, j);
			}
		}
		for (int i=1; i<=numberOfDays; i++)
		{
			int row = new Integer((i+startOfMonth-2)/7);
			int column  =  (i+startOfMonth-2)%7;
			m_defTblModel.setValueAt(i, row, column);
		}
	}
	class yearComboBox_Action implements ActionListener
	{
		private JComboBox m_yearComboBox;
		public void actionPerformed (ActionEvent e)
		{
			if (m_yearComboBox.getSelectedItem() != null)
			{
				String b = m_yearComboBox.getSelectedItem().toString();
				m_currentYear = Integer.parseInt(b); 
				refreshCalendar(m_currentMonth, m_currentYear); 
			}
		}
	}
}