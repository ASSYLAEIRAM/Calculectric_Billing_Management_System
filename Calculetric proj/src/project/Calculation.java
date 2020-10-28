package project;

import java.text.DecimalFormat;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollBar;


public class Calculation extends Uses implements ActionListener{
	
	DefaultTableModel model = new DefaultTableModel();
    JTable jtbl = new JTable(model);
	JPanel panel = new JPanel(null);
	
	private JTextField totalamountpayableTF;
	private JTextField TotalKilowattUsedTF;
	private JTextField yearTF;
	private JTextField AmountperkilowattresultTF;
	private JTextField tenantnoTF;
	private JTextField roomnoTF;
	private JTextField fnametf;
	private JTextField lnameTF;
	private JTextField lastreadingtf;
	private JTextField presentreadingtf;
	private JTextField totalpresentconsumptiontf;
	private JTextField totalamountpayabletf;
	private JTextField ownerTPCtf;
	private JTextField ownerTMPtf;
	private JComboBox MonthcomboBox;
	private JButton btnSearch;
	private JButton btnDelete;
	
	JFrame f = new JFrame();

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Calculation();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculation() {

	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setUndecorated(true);   //para walang mga frame outline/border
		f.setLocationRelativeTo(null);
		f.setBounds(100, 100, 1000, 650); //size  ng frame
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(panel);
		panel.setLayout(null);
	
		
		model.addColumn("TransactionNo");
	    model.addColumn("RoomNo:");
        model.addColumn("Month");
        model.addColumn("Year");
        model.addColumn("Last Reading");
        model.addColumn("Present Reading");
        model.addColumn("Amount Per Kilowatt");
        model.addColumn("Total Present Consumption");
        model.addColumn("Total Amount Payable");
        model.addColumn("Total kilowatt used");
        
        JScrollPane pg = new JScrollPane(jtbl);
        pg.setBounds(340,230,650,280);
        panel.add(pg);
        
        updatetable();
	
		
		String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		
	    MonthcomboBox = new JComboBox(month);
		MonthcomboBox.setBounds(496, 92, 147, 22);
		panel.add(MonthcomboBox);
		
		
		//-------------------------------------TEXT FIELDS------------------------------------------------------------
		
		
				//YEAR
				yearTF = new JTextField();
				yearTF.setColumns(10);
				yearTF.setBounds(496, 125, 147, 20);
				panel.add(yearTF);

				
				//AMOUNT PER KILOWATT RESULT
				AmountperkilowattresultTF = new JTextField();
				AmountperkilowattresultTF.setColumns(10);
				AmountperkilowattresultTF.setBounds(809, 125, 181, 20);
				AmountperkilowattresultTF.setEditable(false);
				panel.add(AmountperkilowattresultTF);
				
				
		        //TRANSACTION(TENANT NO)
				tenantnoTF = new JTextField();
				tenantnoTF.setBounds(128,186,98,27);
				panel.add(tenantnoTF);
				tenantnoTF.setColumns(10);
				
				//ROOM NO
				roomnoTF = new JTextField();
				roomnoTF.setBounds(94, 243, 130, 27);
				panel.add(roomnoTF);
				roomnoTF.setColumns(10);
				
				//FIRSTNAME
				fnametf = new JTextField();
				fnametf.setColumns(10);
				fnametf.setBounds(94, 274, 130, 24);
				fnametf.setEditable(false);
				panel.add(fnametf);
				
				
				//LASTNAME
				lnameTF = new JTextField();
				lnameTF.setColumns(10);
				lnameTF.setEditable(false);
				lnameTF.setBounds(231, 274, 106, 24);
				panel.add(lnameTF);
				
				//LAST READING
				lastreadingtf = new JTextField();
				lastreadingtf.setColumns(10);
				lastreadingtf.setBounds(143, 303, 193, 26);
				panel.add(lastreadingtf);
				
				
				//PRESENT READING
				presentreadingtf = new JTextField();
				presentreadingtf.setColumns(10);
				presentreadingtf.setBounds(144, 332, 192, 30);
				panel.add(presentreadingtf);
			
				//TOTAL PRESENT CONSUMPTION
				totalpresentconsumptiontf = new JTextField();
				totalpresentconsumptiontf.setColumns(10);
				totalpresentconsumptiontf.setBounds(191, 408, 145, 24);
				totalpresentconsumptiontf.setEditable(false);
				panel.add(totalpresentconsumptiontf);
				
				//TOTAL AMOUNT PAYABLE
				totalamountpayabletf = new JTextField();
				totalamountpayabletf.setColumns(10);
				totalamountpayabletf.setBounds(192, 435, 143, 22);
				totalamountpayabletf.setEditable(false);
				panel.add(totalamountpayabletf);
				
				//OWNER TOTAL PRESENT CONSUMPTION
				ownerTPCtf = new JTextField();
				ownerTPCtf.setEditable(false);
				ownerTPCtf.setColumns(10);
				ownerTPCtf.setBounds(113, 616, 163, 24);
				panel.add(ownerTPCtf);
				
				//OWNER TOTAL AMOUNT PAYABLE
				ownerTMPtf = new JTextField();
				ownerTMPtf.setEditable(false);
				ownerTMPtf.setColumns(10);
				ownerTMPtf.setBounds(710, 618, 163, 24);
				panel.add(ownerTMPtf);
				
				
		//------------------------------------------BUTTONS------------------------------------------------------------
				
				//UPPER PART COMPUTE
				JButton ComputeButton = new JButton("Compute");
				ComputeButton.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
				ComputeButton.setBounds(665, 92, 134, 54);
				panel.add(ComputeButton);
				ComputeButton.addActionListener(new ActionListener() {
						
						    
					public void actionPerformed(ActionEvent e) {
						     computeamountperkilowatt();
						}}
						);
				
			    btnSearch = new JButton("Search");
				btnSearch.setFont(new Font("Leelawadee", Font.BOLD, 13));
				btnSearch.setBounds(230, 243, 106, 28);
				panel.add(btnSearch);
				btnSearch.addActionListener(this);
				
				
				
				// TENANT CALCULATE
				JButton btnCalculate = new JButton("Calculate");
				btnCalculate.setForeground(new Color(153, 0, 0));
				btnCalculate.setFont(new Font("Leelawadee", Font.BOLD, 19));
				btnCalculate.setBounds(25, 363, 312, 39);
				panel.add(btnCalculate);
				btnCalculate.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						tenantcalculate();
						
					}}
					);
			
				//ADD 
				JButton btnAdd = new JButton("ADD");
				btnAdd.setFont(new Font("SansSerif", Font.BOLD, 15));
				btnAdd.setBounds(16, 468, 99, 36);
				panel.add(btnAdd);
				btnAdd.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						adddata();
					}
		        	
		        });
				
				//RESET
				JButton resetbutton = new JButton("RESET");
				resetbutton.setFont(new Font("SansSerif", Font.BOLD, 15));
				resetbutton.setBounds(126, 469, 99, 36);
				panel.add(resetbutton);
				resetbutton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						reset();
					}
				
				});
				
				//DELETE
				JButton btnDelete = new JButton("DELETE");
				btnDelete.setFont(new Font("SansSerif", Font.BOLD, 15));
				btnDelete.setBounds(238, 469, 99, 37);
				panel.add(btnDelete);
				btnDelete.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						    deletedata();
							removedata();
							updatetable();
							
					}
					
					
				});
				
				//OWNERCALCULATE
				JButton ownercalculatebtn = new JButton("Compute");
				ownercalculatebtn.setForeground(new Color(153, 0, 0));
				ownercalculatebtn.setFont(new Font("Leelawadee", Font.BOLD, 19));
				ownercalculatebtn.setBounds(364, 588, 275, 48);
				panel.add(ownercalculatebtn);
				ownercalculatebtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						ownercompute();
					}
					
				});
				
				
				
			
				
				//BACK
				JButton btnback = new JButton("Back");
				btnback.setFont(new Font("SansSerif", Font.BOLD, 15));
				btnback.setBounds(892, 11, 80, 26);
				panel.add(btnback);
				btnback.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
					back();
					}
				});
				
				
				
//-------------------------- LABELS ------------------------------------------------------------------------
		//TRANSACTION NO
		JLabel lblTenantNo = new JLabel("Transaction no:");
		lblTenantNo.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		lblTenantNo.setForeground(Color.white);
		lblTenantNo.setBounds(19, 192, 111, 14);
		panel.add(lblTenantNo);
		
		//TENANT ELECTRIC BILL
		JLabel lblTenantElectricBill = new JLabel("TENANT ELECTRIC BILL ");
		lblTenantElectricBill.setFont(new Font("Rockwell Condensed", Font.BOLD, 27));
		lblTenantElectricBill.setForeground(new Color(255, 215, 0));
		lblTenantElectricBill.setBounds(358, 191, 292, 21);
		panel.add(lblTenantElectricBill);
		
		//OWNERS ELECTRIC BILL
		JLabel lblOwnersElectricBill = new JLabel("OWNERS ELECTRIC BILL");
		lblOwnersElectricBill.setFont(new Font("Rockwell", Font.BOLD, 25));
		lblOwnersElectricBill.setBackground(Color.BLACK);
		lblOwnersElectricBill.setBounds(353, 530, 368, 30);
		panel.add(lblOwnersElectricBill);
		
		//UNANG LINE NA MAKIKITA FROM THE NORTH
		JLabel first_line = new JLabel("");
		first_line.setOpaque(true);
		first_line.setForeground(Color.WHITE);
		first_line.setBackground(Color.DARK_GRAY);
		first_line.setBounds(-107, 171, 1279, 6);
		panel.add(first_line);
		
		//SECOND LINE NA MAKIKITA FROM THE NORTH
		JLabel Second_line = new JLabel("");
		Second_line.setFont(new Font("SansSerif", Font.BOLD, 25));
		Second_line.setOpaque(true);
		Second_line.setForeground(new Color(255, 165, 0));
		Second_line.setBackground(new Color(51, 51, 51));
		Second_line.setBounds(0, 183, 1001, 34);
		panel.add(Second_line);
		
		//THIRD LINE NA MAKIKITA FROM THE NORTH
		JLabel third_line = new JLabel("");
		third_line.setOpaque(true);
		third_line.setForeground(Color.WHITE);
		third_line.setBackground(Color.DARK_GRAY);
		third_line.setBounds(0, 221, 1279, 6);
		panel.add(third_line);
		
		//FOURTH LINE NA MAKIKITA FROM THE NORTH
		JLabel fourthline = new JLabel("");
		fourthline.setOpaque(true);
		fourthline.setForeground(Color.WHITE);
		fourthline.setBackground(Color.DARK_GRAY);
		fourthline.setBounds(0, 513, 1279, 6);
		panel.add(fourthline);
		
		//FIFTH LINE NA MAKIKITA FROM THE NORTH
		JLabel fifthline = new JLabel("");
		fifthline.setOpaque(true);
		fifthline.setForeground(new Color(255, 165, 0));
		fifthline.setFont(new Font("SansSerif", Font.BOLD, 25));
		fifthline.setBackground(Color.WHITE);
		fifthline.setBounds(0, 526, 1001, 34);
		panel.add(fifthline);
		
		//SIXTH LINE NA MAKIKITA FROM THE NORTH
		JLabel sixthline = new JLabel("");
		sixthline.setOpaque(true);
		sixthline.setForeground(Color.WHITE);
		sixthline.setBackground(Color.DARK_GRAY);
		sixthline.setBounds(-1, 568, 1279, 6);
		panel.add(sixthline);
		
		//TOTAL AMOUNT PAYABLE
		JLabel TotalAmountPayableLbl = new JLabel("Total Amount Payable:");
		TotalAmountPayableLbl.setForeground(Color.WHITE);
		TotalAmountPayableLbl.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 15));
		TotalAmountPayableLbl.setBounds(10, 90, 190, 24);
		panel.add(TotalAmountPayableLbl);
		
	    //TOTAL KILOWATT USED
		JLabel TotalkilowattUsedlbl = new JLabel("Total kilowatt Used:");
		TotalkilowattUsedlbl.setForeground(Color.WHITE);
		TotalkilowattUsedlbl.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 15));
		TotalkilowattUsedlbl.setBounds(10, 122, 190, 24);
		panel.add(TotalkilowattUsedlbl);
		
		//MONTH
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setForeground(Color.WHITE);
		lblMonth.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 15));
		lblMonth.setBounds(434, 90, 74, 24);
		panel.add(lblMonth);
		
		//YEAR
		JLabel lblYear = new JLabel("Year:");
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 15));
		lblYear.setBounds(434, 122, 74, 24);
		panel.add(lblYear);
		
		
		//AMOUNT PER KILOWATT
		JLabel lblAmountPerKilowatt = new JLabel("AMOUNT PER KILOWATT");
		lblAmountPerKilowatt.setBackground(new Color(255, 0, 0));
		lblAmountPerKilowatt.setForeground(new Color(255, 0, 0));
		lblAmountPerKilowatt.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblAmountPerKilowatt.setBounds(821, 102, 168, 24);
		panel.add(lblAmountPerKilowatt);
		
		//RESULT
		JLabel resultlbl = new JLabel("RESULT");
		resultlbl.setForeground(new Color(255, 255, 255));
		resultlbl.setFont(new Font("Rockwell", Font.BOLD, 12));
		resultlbl.setBackground(Color.RED);
		resultlbl.setBounds(869, 84, 59, 24);
		panel.add(resultlbl);
		
		//BACKGROUND PARA SA AMOUNT PER KILOWATT
		JLabel AmPerKwatbBG = new JLabel("");
		AmPerKwatbBG.setOpaque(true);
		AmPerKwatbBG.setForeground(Color.WHITE);
		AmPerKwatbBG.setBackground(Color.DARK_GRAY);
		AmPerKwatbBG.setBounds(0, 77, 1000, 87);
		panel.add(AmPerKwatbBG);
		
		//ROOM NO
		JLabel lblRoomNo = new JLabel("Room no:");
		lblRoomNo.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		lblRoomNo.setBounds(23, 244, 111, 14);
		panel.add(lblRoomNo);
		
		//NAME
		JLabel Namelbl = new JLabel("Name:");
		Namelbl.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		Namelbl.setBounds(25, 266, 59, 14);
		panel.add(Namelbl);
		totalamountpayableTF = new JTextField();
		totalamountpayableTF.setBounds(191, 93, 221, 20);
		panel.add(totalamountpayableTF);
		totalamountpayableTF.setColumns(10);
		
		
		//LAST READING
		JLabel lastreadinglbl = new JLabel("Last Reading:");
		lastreadinglbl.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		lastreadinglbl.setBounds(25, 307, 106, 18);
		panel.add(lastreadinglbl);
		
		//PRESENT READING
		JLabel lblPresentReading = new JLabel("Present Reading:");
		lblPresentReading.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		lblPresentReading.setBounds(23, 334, 114, 18);
		panel.add(lblPresentReading);
		
		//TOTAL PRESENT CONSUMPTION
		JLabel lblTotalPresentConsumption = new JLabel("Total Present Consumption:");
		lblTotalPresentConsumption.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		lblTotalPresentConsumption.setBounds(19, 411, 183, 18);
		panel.add(lblTotalPresentConsumption);
		
		//TOTAL AMOUNT PAYABLE
		JLabel Total_Amount_Payable_lbl = new JLabel("Total Amount Payable:");
		Total_Amount_Payable_lbl.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		Total_Amount_Payable_lbl.setBounds(18, 439, 183, 18);
		panel.add(Total_Amount_Payable_lbl);
		
		

		//para sa EXIT(X) sa right side
		JLabel close = new JLabel("X");
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				f.dispose();
			}
		});
		close.setForeground(Color.WHITE);
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setFont(new Font("Tahoma", Font.BOLD, 30));
		close.setBounds(10, 6, 46, 34);
		panel.add(close);
		TotalKilowattUsedTF = new JTextField();
		TotalKilowattUsedTF.setColumns(10);
		TotalKilowattUsedTF.setBounds(191, 125, 221, 20);
		panel.add(TotalKilowattUsedTF);
		
		//TOTAL PRESENT CONSUMPTION
		JLabel OwnerTPClbl = new JLabel("Total Present Consumption:");
		OwnerTPClbl.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		OwnerTPClbl.setBounds(111, 586, 183, 18);
		panel.add(OwnerTPClbl);
		
		

		JLabel lblAmountPerKilowatt_1 = new JLabel(" Amount Per Kilowatt Update");
		lblAmountPerKilowatt_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 25));
		lblAmountPerKilowatt_1.setBounds(343, 50, 325, 24);
		panel.add(lblAmountPerKilowatt_1);
		
		JLabel ownerTAPlbl = new JLabel("Total Amount Payable:");
		ownerTAPlbl.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		ownerTAPlbl.setBounds(711, 590, 183, 18);
		panel.add(ownerTAPlbl);
		
		//------TALK TO ME TEXT-----------
		JLabel lblAiChatbot = new JLabel("ELECTRIC BILL CALCULATION");
		lblAiChatbot.setFont(new Font("Khmer UI", Font.BOLD, 30));
		lblAiChatbot.setForeground(Color.WHITE);
		lblAiChatbot.setBackground(Color.WHITE);
		lblAiChatbot.setBounds(294, 10, 427, 29);
		panel.add(lblAiChatbot);
		
		//------eto yung box sa ibabaw na gray-------------
		JLabel HEADERGRAY = new JLabel("");
		HEADERGRAY.setBackground(new Color(51, 51, 51));
		HEADERGRAY.setOpaque(true);
		HEADERGRAY.setBounds(0, 0, 1000, 46);
		panel.add(HEADERGRAY);
		
		//------------eto yung mismong circle-----------
		JLabel circle = new JLabel("");
		circle.setHorizontalAlignment(SwingConstants.CENTER);
		circle.setIcon(new ImageIcon(Calculation.class.getResource("")));
		circle.setBounds(41, 72, 269, 268);
		panel.add(circle);
		
		//BACKGROUND COLOR
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(255, 204, 51));
		label.setBounds(0, 24, 1000, 625);
		panel.add(label);
		
		//ROOM NO
		JLabel lblRoomNolbl = new JLabel("Room No.");
		lblRoomNolbl.setBounds(9, 236, 46, 14);
		panel.add(lblRoomNolbl);
		

		
	}

	

//-----------------------------------------------FUNCTIONS----------------------------------------------------------	
	
//********************************************* updatetable *********************************************************	
	public void updatetable() {
	    	try {

	    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/calculectric?useTimezone=true&serverTimezone=UTC", "root", "");
	              Class.forName("com.mysql.cj.jdbc.Driver");
	              PreparedStatement pstm = con.prepareStatement("SELECT * FROM tenantelectricbill");
	              ResultSet Rs = pstm.executeQuery();
	              
	              while(Rs.next()){
	                  model.addRow(new Object[]{Rs.getInt(1), Rs.getInt(2),Rs.getString(3),Rs.getInt(4),Rs.getFloat(5),Rs.getFloat(6),Rs.getFloat(7),Rs.getFloat(8),Rs.getFloat(9),Rs.getFloat(10)});
	              }
	              con.close();
	              Rs.close();
	    	    
	    	} catch (Exception e) {
	              System.out.println(e.getMessage());
	          }
	    }
	  

//********************************************* add ****************************************************************	
	String sid="";
    public void adddata(){
   	 Connection conn = null;
   	   Statement stmt = null;	
   	   try{
   	      Class.forName("com.mysql.cj.jdbc.Driver");
   	      System.out.println("Connecting to database...");
   	      conn = DriverManager.getConnection("jdbc:mysql://localhost:/calculectric?useTimezone=true&serverTimezone=UTC","root","");
   	      stmt = conn.createStatement();
   	      String sql2;
   	      
   	      String tenantNo = tenantnoTF.getText();
   	      sid = roomnoTF.getText();//roomno
   	      String mnth = (String) MonthcomboBox.getSelectedItem();   //month
   	      String year = yearTF.getText();   //year
   	      String lstread= lastreadingtf.getText(); //last reading
   	      String prsread= presentreadingtf.getText();  //present reading
   	     // String amprkw = AmountperkilowattresultTF.getText();    //amount per kilowatt
   	      String totpc=totalpresentconsumptiontf.getText();//totalpresnt consumption
   	      //String totap=totalamountpayabletf.getText();//total amount payable
   	      String totku = TotalKilowattUsedTF.getText();//overallkilowatused
   	     
   	      
   	      int tno = Integer.parseInt(tenantNo);
   	      int rmn = Integer.parseInt(sid);
   	      int yr= Integer.parseInt(year);
   	      float lr =Float.parseFloat(lstread);
   	      float pr =Float.parseFloat(prsread);
   	      float apk =result;
   		  float tpc =Float.parseFloat(totpc);
   	      float tap = toap;
   	      float oku = Float.parseFloat(totku);
   									 
   	      String totap =  String.valueOf(toap);
   	     String amprkw = String.valueOf(apk);
   	      sql2 = "INSERT INTO tenantelectricbill VALUES("+tno+","+rmn+",'"+mnth+"',"+yr+","+lr+","+pr+","+apk+","+tpc+","+tap+","+oku+")";
   	      stmt.executeUpdate(sql2);
   	      stmt.close();
   	      conn.close();
   	      Object[] rows = {tno,sid,mnth,year,lstread,prsread,amprkw,totpc,totap,totku}; //* di ko alam kung alin yung tenant number*//
   	      model.addRow(rows);
   	   }catch(SQLException se){
   		   System.out.println(se.getMessage());
   	   }catch(Exception e){
   		   System.out.println(e.getMessage());
   	   }finally{
   	      try{
   	         if(stmt!=null)
   	            stmt.close();
   	      }catch(SQLException se2){
   	      }
   	      try{
   	         if(conn!=null)
   	            conn.close();
   	      }catch(SQLException se){
   	         se.printStackTrace();
   	      }
   	   }
   	lastreadingtf.setText("");
	presentreadingtf.setText("");
	totalpresentconsumptiontf.setText("");
	totalamountpayabletf.setText("");
	fnametf.setText("");
	lnameTF.setText("");
	roomnoTF.setText("");
	tenantnoTF.setText("");

	
	
	
   }

//************************************************** deletedata *******************************************************		
		
		public void deletedata() {

	    	try
	        {
	          // create the mysql database connection
	          String myDriver = "com.mysql.cj.jdbc.Driver";
	          String myUrl = "jdbc:mysql://localhost/calculectric?useTimezone=true&serverTimezone=UTC";
	          Class.forName(myDriver);
	          Connection conn = DriverManager.getConnection(myUrl, "root", "");
	          String query = "delete from tenantelectricbill where tenantNo = ?";
	          PreparedStatement preparedStmt = conn.prepareStatement(query);
	          String tenantNo = tenantnoTF.getText();
	          int id = Integer.parseInt(tenantNo);
	          preparedStmt.setInt(1, id);
	          preparedStmt.execute();
	          conn.close();
	          
	      	lastreadingtf.setText("");
			presentreadingtf.setText("");
			totalpresentconsumptiontf.setText("");
			totalamountpayabletf.setText("");
			fnametf.setText("");
			lnameTF.setText("");
			roomnoTF.setText("");
			tenantnoTF.setText("");
			ownerTPCtf.setText("");
			ownerTMPtf.setText("");
			
	        }
	        catch (Exception e)
	        {
	          System.err.println("Got an exception! ");
	          System.err.println(e.getMessage());
	        }
	    }

//******************************************** compute amount per kilowatt ******************************************
		float result = 0;
		public void computeamountperkilowatt()
		{
			if(totalamountpayableTF.getText().equals("") || TotalKilowattUsedTF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "PLEASE INPUT AMOUNT IN LAST AND PRESENT READING TO COMPUTE");
			
			}else
			{DecimalFormat df = new DecimalFormat("0.00");
				float tap= Float.parseFloat(totalamountpayableTF.getText());
				float tku= Float.parseFloat(TotalKilowattUsedTF.getText());
				
				
					result = tap/tku;
					AmountperkilowattresultTF.setText("  ₱  "+String.valueOf(df.format(result)));
			
			}
		}
//******************************************** tenant calculate **************************************************		
		float toap = 0;
		
		public void tenantcalculate()
		{
			if(lastreadingtf.getText().equals("") || presentreadingtf.getText().equals("") || AmountperkilowattresultTF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "   PLEASE INPUT AMOUNT IN LAST AND PRESENT READING AND\n MAKE SURE THAT THERE IS A RESULT IN AMOUNT PER KILOWATT");
			}
				else {
			DecimalFormat df = new DecimalFormat("0.00");
			int lr= Integer.parseInt(lastreadingtf.getText());
			int pr= Integer.parseInt(presentreadingtf.getText());
			int res;
		
				
				res = Math.abs(pr-lr); 
				totalpresentconsumptiontf.setText(String.valueOf(res));
				toap= Float.parseFloat(totalpresentconsumptiontf.getText())*result;
			
				totalamountpayabletf.setText("  ₱  "+df.format(toap));
				
			}	
		}
		
//********************************************** owner compute *****************************************************
         public void ownercompute()
         {
        	 String month = (String) MonthcomboBox.getSelectedItem();
        	 String year = yearTF.getText();
        	// int yr = Integer.parseInt(year);
        	 
        	 //System.out.println("month" + month + "\nYear:"+year);
        	// int count = 0;
        	 float sum = 0;
        	 float tku = 0;
        	 float apk = 0;
        		try {

    	    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/calculectric?useTimezone=true&serverTimezone=UTC", "root", "");
    	              Class.forName("com.mysql.cj.jdbc.Driver");
    	              PreparedStatement pstm = con.prepareStatement("SELECT * FROM tenantelectricbill");
    	              ResultSet Rs = pstm.executeQuery();
    	              
    	             
    	           
    	              while(Rs.next()){
    	               
    	            	         
    	            	  int y = Rs.getInt(4);
    	            	 
    	            	  String yr = String.valueOf(y);
    	            	  if(month.equals(Rs.getString(3)) && year.equals(yr))
    	            	  {
    	  
    	            		    sum += Rs.getFloat(8);   //sum of all the tenants total present consumption
    	            		    tku = Rs.getFloat(10);  //total kilowatt used
    	            		    apk = Rs.getFloat(7);   //calculated amount per kilowatt used
    	            		    
    	            	  }
    	              }
    	         

    	         
    	            float ownerKWcons = sum-tku;  // total sum of the kilowatt consumption of the tenants - total kilowatt used over all
    	            float okwcons = Math.abs(ownerKWcons);        //makes the sum absolute
    	            
    	            float ownerpayable = okwcons*apk;   //owner kilowatt consumption * calculated amount per kilowatt used
    	            
    	            String op = String.valueOf(ownerpayable);
    	            String s = 	String.valueOf(okwcons);
    	           
    	        	ownerTPCtf.setText(s);   //kilowatt consumed by the owner
    	        	ownerTMPtf.setText("  ₱  " + op);  //babayaran ni owner
    	            
    	            
    	              con.close();
    	              Rs.close();
    	    	    
    	    	} catch (Exception e) {
    	              System.out.println(e.getMessage());
    	          }
        	 
         }
//************************************************** reset ********************************************************	
		public void reset()
		{
			
				lastreadingtf.setText("");
				presentreadingtf.setText("");
				totalpresentconsumptiontf.setText("");
				totalamountpayabletf.setText("");
				fnametf.setText("");
				lnameTF.setText("");
				roomnoTF.setText("");
				tenantnoTF.setText("");
				ownerTPCtf.setText("");
				ownerTMPtf.setText("");

			}
		
//******************************************** removedata *************************************************************	   

			public void removedata(){
			    	int row = model.getRowCount();
			    	for(int x =0;x<row;x++) {
			    	   	model.removeRow(0);
			    	}
			    }


//-------------------------------------------------------CLASS-----------------------------------------------------
		public class Function
		{
			
			Connection con= null;
			ResultSet rs=null;
			PreparedStatement ps = null;
			
			public ResultSet find(String s) {
			
				try {
				  con = DriverManager.getConnection("jdbc:mysql://localhost:/calculectric?useTimezone=true&serverTimezone=UTC","root","");
				  ps = con.prepareStatement("Select * from tenant where roomno = ? "); 
				  ps.setString(1, s);
				  rs = ps.executeQuery();
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			   return rs;
			
		   }
		}

//-------------------------------------------------THIS------------------------------------------------------------		
		@Override
		public void actionPerformed(ActionEvent a) {
			
				if(a.getSource() == btnSearch)
				{
					Function f = new Function();
					ResultSet rs = null;
					
					
					rs = f.find(roomnoTF.getText());
					
					try {
							if(rs.next())
							{
								fnametf.setText(rs.getString("fname"));
								lnameTF.setText(rs.getString("lname"));
								
								
							}else {
								JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ROOM NUMBER");
							}
						
					}catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null, ex.getMessage());
						}
			 }
		}

			@Override
			public void updatedata() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void back() {
				
				f.dispose();
				home men= new home();
				men.setVisible(true);
				
			}
		
	
		
}

	


