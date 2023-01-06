package phoneBook;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PhoneBook {

	private JFrame frame;
	private JTextField textname;
	private JTextField textnumber;
	private JTextField textemail;
	private JTextField textcompany;
	private JTextField textbirthday;
	private JTable table;
	private JTable table_1;
	private JTextField textsearchname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhoneBook window = new PhoneBook();
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
	public PhoneBook() {
		initialize();
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(210, 194, 228));
		frame.getContentPane().setBackground(new Color(210, 194, 228));
		frame.setBounds(100, 100, 1338, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phone Book Directory");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
		lblNewLabel.setBounds(306, 0, 532, 96);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel addnewpanel = new JPanel();
		addnewpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ADD NEW", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		addnewpanel.setBackground(new Color(255, 255, 255));
		addnewpanel.setBounds(22, 75, 476, 381);
		frame.getContentPane().add(addnewpanel);
		addnewpanel.setLayout(null);
		
		JLabel lblhname = new JLabel("NAME");
		lblhname.setFont(new Font("Segoe UI Historic", Font.BOLD, 23));
		lblhname.setBounds(28, 48, 158, 33);
		addnewpanel.add(lblhname);
		
		JLabel lblhnumber = new JLabel("Phone Number");
		lblhnumber.setFont(new Font("Segoe UI Historic", Font.BOLD, 23));
		lblhnumber.setBounds(28, 111, 174, 33);
		addnewpanel.add(lblhnumber);
		
		JLabel lblhemail = new JLabel("Email");
		lblhemail.setFont(new Font("Segoe UI Historic", Font.BOLD, 23));
		lblhemail.setBounds(28, 176, 104, 31);
		addnewpanel.add(lblhemail);
		
		JLabel lblhcompany = new JLabel("Company");
		lblhcompany.setFont(new Font("Segoe UI Historic", Font.BOLD, 23));
		lblhcompany.setBounds(28, 242, 114, 31);
		addnewpanel.add(lblhcompany);
		
		JLabel lblhbirthday = new JLabel("Birthday");
		lblhbirthday.setFont(new Font("Segoe UI Historic", Font.BOLD, 23));
		lblhbirthday.setBounds(28, 315, 104, 33);
		addnewpanel.add(lblhbirthday);
		
		textname = new JTextField();
		textname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textname.setBounds(133, 48, 327, 33);
		addnewpanel.add(textname);
		textname.setColumns(10);
		
		textnumber = new JTextField();
		textnumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textnumber.setBounds(227, 111, 233, 33);
		addnewpanel.add(textnumber);
		textnumber.setColumns(10);
		
		textemail = new JTextField();
		textemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textemail.setBounds(141, 176, 318, 33);
		addnewpanel.add(textemail);
		textemail.setColumns(10);
		
		textcompany = new JTextField();
		textcompany.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textcompany.setBounds(152, 247, 305, 33);
		addnewpanel.add(textcompany);
		textcompany.setColumns(10);
		
		textbirthday = new JTextField();
		textbirthday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textbirthday.setBounds(152, 315, 305, 33);
		addnewpanel.add(textbirthday);
		textbirthday.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(432, 154, 90, -58);
		frame.getContentPane().add(panel_1);
		
		JButton btnupdateButton = new JButton("Update");
		btnupdateButton.setBounds(615, 569, 223, 42);
		frame.getContentPane().add(btnupdateButton);
		btnupdateButton.setFont(new Font("SimSun-ExtB", Font.BOLD, 23));
		
		JButton btndeleteButton = new JButton("Delete");
		btndeleteButton.setBounds(932, 569, 223, 42);
		frame.getContentPane().add(btndeleteButton);
		btndeleteButton.setFont(new Font("SimSun-ExtB", Font.BOLD, 23));
		
		JPanel searchpanel = new JPanel();
		searchpanel.setBorder(new TitledBorder(null, "SEARCH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchpanel.setBounds(22, 559, 498, 67);
		frame.getContentPane().add(searchpanel);
		searchpanel.setLayout(null);
		
		textsearchname = new JTextField();
		textsearchname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textsearchname.setBounds(98, 19, 390, 35);
		searchpanel.add(textsearchname);
		textsearchname.setColumns(10);
		
		JLabel lblsearchhname = new JLabel("Name");
		lblsearchhname.setFont(new Font("SimSun-ExtB", Font.BOLD, 23));
		lblsearchhname.setBounds(20, 17, 68, 34);
		searchpanel.add(lblsearchhname);
		
		table = new JTable();
		table.setBorder(new TitledBorder(null, "ALL CONTACTS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBackground(new Color(255, 255, 255));
		table.setBounds(1033, 465, -385, -371);
		frame.getContentPane().add(table);
		
		JScrollPane table_2 = new JScrollPane();
		table_2.setBounds(519, 74, 739, 449);
		frame.getContentPane().add(table_2);
		
		table_1 = new JTable();
		table_2.setViewportView(table_1);
		
		JButton btnsaveButton = new JButton("Save");
			btnsaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pname,pnumber,pemail,pcompany,pbirthday; 
				pname=textname.getText();
				pnumber=textnumber.getText();
				pemail=textemail.getText();
				pcompany=textcompany.getText();
				pbirthday=textbirthday.getText();
				
				
				try {
		             Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/PhBook", "root", "vaishu");

		             String query = "INSERT INTO phonebook values('" + pname + "','" + pnumber + "','" + pemail + "','" + pcompany 
		            		 + "','" + pbirthday + "')";		          
		             
		             Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                     JOptionPane.showMessageDialog(btnsaveButton, "Contact Saved!");
	                    
		            //JOptionPane.showMessageDialog(btnsaveButton, "Contact Saved!");
		             
		             textname.setText("");
		             textnumber.setText("");
		             textemail.setText("");
		             textcompany.setText("");
		             textbirthday.setText("");
		             textname.requestFocus();
		             
		             connection.close();
		         } catch (Exception exception) {
		             exception.printStackTrace();
		         }
				
				
			}
		});
			
		
		
		
		btnsaveButton.setFont(new Font("SimSun-ExtB", Font.BOLD, 23));
		btnsaveButton.setBounds(35, 481, 129, 42);
		frame.getContentPane().add(btnsaveButton);
		
		JButton btnexitButton = new JButton("Exit");
		btnexitButton.setFont(new Font("SimSun-ExtB", Font.BOLD, 23));
		btnexitButton.setBounds(197, 482, 129, 41);
		frame.getContentPane().add(btnexitButton);
		
		JButton btnclearButton = new JButton("Clear");
		btnclearButton.setFont(new Font("SimSun-ExtB", Font.BOLD, 23));
		btnclearButton.setBounds(360, 481, 129, 42);
		frame.getContentPane().add(btnclearButton);
		
		//------------ CONNECTION ---------------------------------------------------------//
		
		 
     
	}
}
