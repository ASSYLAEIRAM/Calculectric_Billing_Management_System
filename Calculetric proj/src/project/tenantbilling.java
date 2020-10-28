package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import project.Calculation.Function;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;

public class tenantbilling  {

	private JFrame frame;
	private JTextField tfname;
	private JTextField tfroomno;
	private JTextField tflastreading;
	private JTextField presentreadingtf;
	private JTextField tftotalpresentcon;
	private JTextField tfamountpayable;
	private JTextField tfamountperkw;
	private JTextField tfyr;
    private JComboBox MonthcomboBox;
	
	private JScrollPane scrollpane;
	
	
	private static JTextArea textarea;
	
	private JPanel roomnoPanel;

	JButton btnsearch;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tenantbilling window = new tenantbilling();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tenantbilling() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(0, 0, 1360, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//--------------------------------TEXT AREA---------------------------------------------------------------------		
		textarea = new JTextArea();
		textarea.setEditable(false);
		scrollpane = new JScrollPane(textarea);
		scrollpane.setBounds(568, 137, 753, 484);
		frame.getContentPane().add(scrollpane);
		
//----------------------------------------- P A N E L ------------------------------------------------------------		
		//TENANT ELECTRIC BILLING
		JPanel tenantelectricbillingPanel = new JPanel();
		tenantelectricbillingPanel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		tenantelectricbillingPanel.setBackground(new Color(255, 204, 51));
		tenantelectricbillingPanel.setBounds(38, 29, 1298, 95);
		frame.getContentPane().add(tenantelectricbillingPanel);
		
		//NAME
		JPanel namePanel = new JPanel();
		namePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		namePanel.setBackground(Color.DARK_GRAY);
		namePanel.setBounds(51, 245, 180, 32);
		frame.getContentPane().add(namePanel);
		namePanel.setLayout(null);
		
		//LAST READING
		JPanel lastreadingPanel = new JPanel();
		lastreadingPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lastreadingPanel.setBackground(Color.DARK_GRAY);
		lastreadingPanel.setBounds(51, 290, 180, 32);
		frame.getContentPane().add(lastreadingPanel);
		lastreadingPanel.setLayout(null);
		
		//TOTAL PRESENT CONSUMPTION
		JPanel TPCpanel = new JPanel();
		TPCpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TPCpanel.setBackground(Color.DARK_GRAY);
		TPCpanel.setBounds(51, 461, 281, 32);
		frame.getContentPane().add(TPCpanel);
		TPCpanel.setLayout(null);
		
		//ROOM NO
		roomnoPanel = new JPanel();
		roomnoPanel.setForeground(new Color(255, 204, 51));
		roomnoPanel.setBackground(Color.DARK_GRAY);
		roomnoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		roomnoPanel.setBounds(51, 204, 180, 32);
		frame.getContentPane().add(roomnoPanel);
		roomnoPanel.setLayout(null);
		
		
		//TOTAL AMOUNT PAYABLE
		JPanel TAPpanel = new JPanel();
		TAPpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		TAPpanel.setBackground(Color.DARK_GRAY);
		TAPpanel.setBounds(51, 505, 281, 32);
		frame.getContentPane().add(TAPpanel);
		TAPpanel.setLayout(null);
		
		//SEARCH
		JPanel searchpanel = new JPanel();
		searchpanel.setBackground(new Color(204, 204, 102));
		searchpanel.setBounds(369, 204, 116, 32);
		frame.getContentPane().add(searchpanel);
		searchpanel.setLayout(null);
			

		//MONTH 
		JPanel monthpanel = new JPanel();
		monthpanel.setForeground(Color.DARK_GRAY);
		monthpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		monthpanel.setBounds(51, 146, 100, 32);
		monthpanel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(monthpanel);
		monthpanel.setLayout(new BorderLayout(0, 0));
		
		//YEAR
		JPanel yrpanel = new JPanel();
		yrpanel.setForeground(Color.DARK_GRAY);
		yrpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		yrpanel.setBounds(280, 146, 90, 32);
		yrpanel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(yrpanel);
		yrpanel.setLayout(new BorderLayout(0, 0));
			
		
		//AMOUNT PER KILOWATT
		JPanel APKpanel = new JPanel();
		APKpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		APKpanel.setBackground(Color.DARK_GRAY);
		APKpanel.setBounds(51, 401, 175, 32);
		frame.getContentPane().add(APKpanel);
		APKpanel.setLayout(null);
		
		//PRESENT READING
		JPanel presentreadingPanel = new JPanel();
		presentreadingPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		presentreadingPanel.setBackground(Color.DARK_GRAY);
		presentreadingPanel.setBounds(50, 343, 180, 32);
		frame.getContentPane().add(presentreadingPanel);
		presentreadingPanel.setLayout(null);
		
		
//------------------------------------ L A B E L S ---------------------------------------------------------------
		
		
		//TENANT ELECTRIC BILLING
		JLabel tenantelectricbilliongLBL = new JLabel("TENANT ELECTRIC BILLING INFORMATION");
		tenantelectricbilliongLBL.setFont(new Font("Tahoma", Font.BOLD, 38));
		tenantelectricbillingPanel.add(tenantelectricbilliongLBL);

	    //NAME
		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setForeground(new Color(255, 204, 51));
		nameLbl.setBounds(0, 0, 119, 32);
		namePanel.add(nameLbl);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 20));

		
		//LAST READING
		JLabel lastreadingLbl = new JLabel("Last Reading:");
		lastreadingLbl.setForeground(new Color(255, 204, 51));
		lastreadingLbl.setBounds(0, 0, 150, 32);
		lastreadingPanel.add(lastreadingLbl);
		lastreadingLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		//PRESENT READING
		JLabel presentreadingLbl = new JLabel("Present Reading:");
		presentreadingLbl.setForeground(new Color(255, 204, 51));
		presentreadingLbl.setBounds(0, 0, 190, 32);
		presentreadingPanel.add(presentreadingLbl);
		presentreadingLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
	
		//TOTAL PRESENT CONSUMPTION
		JLabel TPClbl = new JLabel("Total Present Consumption:");
		TPClbl.setForeground(new Color(255, 204, 51));
		TPClbl.setBounds(0, 0, 281, 32);
		TPCpanel.add(TPClbl);
		TPClbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		//ROOM NO
		JLabel roomnoLbl = new JLabel("Room No:");
		roomnoLbl.setBounds(0, 0, 119, 32);
		roomnoPanel.add(roomnoLbl);
		roomnoLbl.setForeground(new Color(255, 204, 51));
		roomnoLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		//TOTAL AMOUNT PAYABLE
		JLabel TAPlbl = new JLabel("Total Amount Payable:");
		TAPlbl.setForeground(new Color(255, 204, 51));
		TAPlbl.setBounds(0, 0, 281, 32);
		TAPpanel.add(TAPlbl);
		TAPlbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		

		//MONTH 
		JLabel monthlabel = new JLabel("Month:");
		monthlabel.setForeground(new Color(255, 204, 51));
		monthpanel.add(monthlabel);
		monthlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		//YEAR
		JLabel yrlabel = new JLabel("Year:");
		yrlabel.setForeground(new Color(255, 204, 51));
		yrpanel.add(yrlabel);
		yrlabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		

		//AMOUNT PER KILOWATT
		JLabel APKperkwLbl = new JLabel("Amount per KW:");
		APKperkwLbl.setForeground(new Color(255, 204, 51));
		APKperkwLbl.setBounds(0, 0, 175, 32);
		APKpanel.add(APKperkwLbl);
		APKperkwLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
//-------------------------------------T E X T   F I E L D S ----------------------------------------------------------
		
		//NAME
		tfname = new JTextField();
		tfname.setBounds(240, 245, 244, 32);
		tfname.setColumns(10);
		tfname.setEditable(false);
		frame.getContentPane().add(tfname);
		
			
		//LAST READING
		tflastreading = new JTextField();
		tflastreading.setColumns(10);
		tflastreading.setBounds(240, 290, 244, 32);
		tflastreading.setEditable(false);
		frame.getContentPane().add(tflastreading);
		
	
	
		// TOTAL PRESNET CONSUMPTION
		tftotalpresentcon = new JTextField();
		tftotalpresentcon.setColumns(10);
		tftotalpresentcon.setBounds(365, 461, 119, 32);
		tftotalpresentcon.setEditable(false);
		frame.getContentPane().add(tftotalpresentcon);
		
		//TOTAL AMOUNT PAYABLE
		tfamountpayable = new JTextField();
		tfamountpayable.setColumns(10);
		tfamountpayable.setBounds(365, 510, 119, 32);
		tfamountpayable.setEditable(false);
		frame.getContentPane().add(tfamountpayable);
		

		
		//ROOM NO
		tfroomno = new JTextField();
		tfroomno.setColumns(10);
		tfroomno.setBounds(240, 204, 119, 32);
		frame.getContentPane().add(tfroomno);

		//YEAR
		tfyr = new JTextField();
		tfyr.setColumns(10);
		tfyr.setBounds(380, 146, 105, 32);
		frame.getContentPane().add(tfyr);
	
		//AMOUNT PER KILOWATT
		tfamountperkw = new JTextField();
		tfamountperkw.setColumns(10);
		tfamountperkw.setBounds(240, 401, 244, 32);
		tfamountperkw.setEditable(false);
		frame.getContentPane().add(tfamountperkw);
		
		
		//PRESENT READING
		presentreadingtf = new JTextField();
		presentreadingtf.setColumns(10);
		presentreadingtf.setBounds(240, 348, 244, 32);
		presentreadingtf.setEditable(false);
		frame.getContentPane().add(presentreadingtf);
	
//----------------------- COMBO BOX -------------------------------------------------------------------------------
	String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
	    MonthcomboBox = new JComboBox(month);
		MonthcomboBox.setBounds(165, 146, 100, 32);
		frame.getContentPane().add(MonthcomboBox);

//----------------------------------------BUTTONS------------------------------------------------------------------
		
		//Exit
		JButton btnexit = new JButton("EXIT");
		btnexit.setForeground(new Color(204, 0, 0));
		btnexit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnexit.setBackground(Color.LIGHT_GRAY);
		btnexit.setBounds(1181, 649, 140, 45);
		frame.getContentPane().add(btnexit);
		
		//Exit
		JButton btnback = new JButton("BACK");
		btnback.setForeground(new Color(204, 0, 0));
		btnback.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnback.setBackground(Color.LIGHT_GRAY);
		btnback.setBounds(1010, 649, 140, 45);
		frame.getContentPane().add(btnback);
		
		//reset
		JButton btnreset = new JButton("RESET");
		btnreset.setForeground(new Color(204, 0, 0));
		btnreset.setBackground(Color.LIGHT_GRAY);
		btnreset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnreset.setBounds(356, 573, 128, 58);
		frame.getContentPane().add(btnreset);
		
		//print
		JButton btnprint = new JButton("PRINT");
		btnprint.setForeground(new Color(204, 0, 0));
		btnprint.setBackground(Color.LIGHT_GRAY);
		btnprint.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnprint.setBounds(356, 649, 128, 58);
		frame.getContentPane().add(btnprint);
		
		//generate receipt
		JButton generatebtn = new JButton("GENERATE RECEIPT");
		generatebtn.setForeground(new Color(204, 0, 0));
		generatebtn.setBackground(Color.LIGHT_GRAY);
		generatebtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		generatebtn.setBounds(51, 573, 259, 58);
		frame.getContentPane().add(generatebtn);
		
		//search
		btnsearch = new JButton("SEARCH");
		btnsearch.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						search();
					}
			
				});
		btnsearch.setForeground(new Color(204, 0, 0));
		btnsearch.setBounds(0, 0, 116, 32);
		searchpanel.add(btnsearch);
		btnsearch.setBackground(Color.LIGHT_GRAY);
		btnsearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		frame.setUndecorated(true);   //para walang mga frame outline/border
		frame.setLocationRelativeTo(null);
		
//------------------------------------------action listeners------------------------------------------------------//
		
		//********** BACK BUTTON ***********
		btnback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				back();
			}
		});
		
		//*********** EXIT BUTTON ************
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit();
			}
		});
		
		//************ PRINT BUTTON **************
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			    print();
			}
		});
		
		//************ RESET BUTTON *****************
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset();
			}
		});
		
		//******* GENERATE RECEIPT BUTTON ********
		generatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  generate();
			}
		});
		
		
		
		
		
		frame.setVisible(true);
		
	}
	
	
	
	
	
//---------------------------------------------FUNCTIONS--------------------------------------------------------------------	
    
    public void back()
    {
    	frame.dispose();
    	new home();

    }
	
//-----------------------------------------------------------------------------------------------------------------------------------
	public void print()
    {
    	try {
			textarea.print();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
    }
//---------------------------------------------------------------------------------------------------------------------------------------
	public void exit()
	{
		frame= new JFrame();
		if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Print System",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
			System.exit(0);
		}
	}
//---------------------------------------------------------------------------------------------------------------------------------------	
   public void reset()
   {
	   tfname.setText("");
		tfroomno.setText("");
		MonthcomboBox.setSelectedIndex(0);
		tflastreading.setText("");
		presentreadingtf.setText("");
		tfamountperkw.setText("");
		tftotalpresentcon.setText("");
		tfamountpayable.setText("");
   }
//-------------------------------------------------------------------------------------------------------------------------------------------
	public void generate()
	{
		
		textarea.append("\n\t\t\tELECTRIC BILL RECEIPT");
		textarea.append("\n______________________________________________________________________________________________________");
		textarea.append("\n************************************************************************************************************************************************");
		textarea.append("\n\t\t\tCALCULECTRIC SYSTEM");
		textarea.append("\n______________________________________________________________________________________________________");
		textarea.append("\n************************************************************************************************************************************************");
		textarea.append("\nTENANT NAME:\t\t");
		textarea.append("                              "+tfname.getText());
		textarea.append("\nRoom No.:\t\t\t");
		textarea.append(tfroomno.getText());
		textarea.append("\nMONTH:\t\t\t");
		textarea.append((String) MonthcomboBox.getSelectedItem());
		textarea.append("\nYEAR:\t\t\t");
		textarea.append(tfyr.getText());
		textarea.append("\nLAST READING:\t\t");
		textarea.append(tflastreading.getText());
		textarea.append("\nPRESENT READING:\t\t");
		textarea.append(presentreadingtf.getText());
		textarea.append("\nAmount per KW:\t\t");
		textarea.append(tfamountperkw.getText());
		textarea.append("\nTOTAL PRESENT CONSUMPTION:\t");
		textarea.append(tftotalpresentcon.getText());
		textarea.append("\nTOTAL AMOUNT PAYABLE:\t\t");
		textarea.append(tfamountpayable.getText());


	}

//----------------------------------------------------------------------------------------------------------
	void search() {
		
		String month = (String) MonthcomboBox.getSelectedItem();
		int year = Integer.parseInt(tfyr.getText());
		int roomno = Integer.parseInt(tfroomno.getText());
		
		
		try {

    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/calculectric?useTimezone=true&serverTimezone=UTC", "root", "");
              Class.forName("com.mysql.cj.jdbc.Driver");
              PreparedStatement pstm = con.prepareStatement("SELECT tenant.roomno,tenant.lname,tenant.fname,tenantelectricbill.lastreading,tenantelectricbill.presentreading,tenantelectricbill.amountperkilowatt,tenantelectricbill.totalpresentconsumption,tenantelectricbill.totalamountpayable "
              		+ "								FROM tenant,tenantelectricbill WHERE tenant.roomno=? AND tenantelectricbill.month =? AND tenantelectricbill.year =?");
              pstm.setInt(1, roomno);
              pstm.setString(2, month);
              pstm.setInt(3, year);
              ResultSet Rs = pstm.executeQuery();
              
              while(Rs.next()){
                  String fname = Rs.getString("fname");
                  String lname =Rs.getString("lname");
                  float lastread = Rs.getFloat("lastreading");
                  float presentread = Rs.getFloat("presentreading");
                  float amountkilowat = Rs.getFloat("amountperkilowatt");
                  float totalconsump = Rs.getFloat("totalpresentconsumption");
                  float totalpayable = Rs.getFloat("totalamountpayable");
                  
                  tfname.setText(fname+" "+lname);
                  tflastreading.setText(""+lastread);
                  presentreadingtf.setText(""+presentread);
                  tfamountperkw.setText(""+amountkilowat);
                  tfamountpayable.setText(""+totalpayable);
                  tftotalpresentcon.setText(""+totalconsump);
              }
              con.close();
              Rs.close();
    	} catch (Exception e) {
              System.out.println(e.getMessage());
          }
		
	}
	
}
