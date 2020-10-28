package finalp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollBar;


public class Calculation extends JFrame {
	
	DefaultTableModel model = new DefaultTableModel();
    JTable jtbl = new JTable(model);
	private JPanel contentPane;
	private JTextField totalamountpayableTF;
	private JTextField TotalKilowattUsedTF;
	private JTextField yearTF;
	private JTextField AmountperkilowattresultTF;
	private JTextField SearchTF;
	private JTextField fnametf;
	private JTextField lnameTF;
	private JTextField lastreadingtf;
	private JTextField presentreadingtf;
	private JTable Jtable;
	private JTextField totalpresentconsumptiontf;
	private JTextField totalamountpayabletf;
	private JTextField ownerTPCtf;
	private JTextField ownerTMPtf;
	private JScrollPane scroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculation frame = new Calculation();
					frame.setVisible(true);
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
		
	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650); //size  ng frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTenantElectricBill = new JLabel("TENANT ELECTRIC BILL ");
		lblTenantElectricBill.setFont(new Font("Rockwell Condensed", Font.BOLD, 27));
		lblTenantElectricBill.setForeground(new Color(255, 215, 0));
		lblTenantElectricBill.setBounds(358, 191, 292, 21);
		contentPane.add(lblTenantElectricBill);
		
		JLabel lblOwnersElectricBill = new JLabel("OWNERS ELECTRIC BILL");
		lblOwnersElectricBill.setFont(new Font("Rockwell", Font.BOLD, 25));
		lblOwnersElectricBill.setBackground(Color.BLACK);
		lblOwnersElectricBill.setBounds(353, 530, 368, 30);
		contentPane.add(lblOwnersElectricBill);
		
		String[] col = {"TenantNo","RoomNo","Last Reading","Present Reading","Total Present Consumption","Total Amount Payable"};
		Jtable = new JTable();
		Jtable.setBounds(385, 441, 479, -187);
		contentPane.add(Jtable);
		
		scroll = new JScrollPane(Jtable);
		scroll.setViewportBorder(new MatteBorder(1,1,1,1,(Color) new Color(0,128,0)));
		scroll.setBounds(340,230,650,280);
		contentPane.add(scroll);
		model = new DefaultTableModel(col,0);
		Jtable.setModel(model);
		
		JLabel first_line = new JLabel("");
		first_line.setOpaque(true);
		first_line.setForeground(Color.WHITE);
		first_line.setBackground(Color.DARK_GRAY);
		first_line.setBounds(-107, 171, 1279, 6);
		contentPane.add(first_line);
		
		JLabel Second_line = new JLabel("");
		Second_line.setFont(new Font("SansSerif", Font.BOLD, 25));
		Second_line.setOpaque(true);
		Second_line.setForeground(new Color(255, 165, 0));
		Second_line.setBackground(new Color(51, 51, 51));
		Second_line.setBounds(0, 183, 1001, 34);
		contentPane.add(Second_line);
		
		JLabel third_line = new JLabel("");
		third_line.setOpaque(true);
		third_line.setForeground(Color.WHITE);
		third_line.setBackground(Color.DARK_GRAY);
		third_line.setBounds(0, 221, 1279, 6);
		contentPane.add(third_line);
		
		JLabel fourthline = new JLabel("");
		fourthline.setOpaque(true);
		fourthline.setForeground(Color.WHITE);
		fourthline.setBackground(Color.DARK_GRAY);
		fourthline.setBounds(0, 513, 1279, 6);
		contentPane.add(fourthline);
		
		JLabel fifthline = new JLabel("");
		fifthline.setOpaque(true);
		fifthline.setForeground(new Color(255, 165, 0));
		fifthline.setFont(new Font("SansSerif", Font.BOLD, 25));
		fifthline.setBackground(Color.WHITE);
		fifthline.setBounds(0, 526, 1001, 34);
		contentPane.add(fifthline);
		
		JLabel sixthline = new JLabel("");
		sixthline.setOpaque(true);
		sixthline.setForeground(Color.WHITE);
		sixthline.setBackground(Color.DARK_GRAY);
		sixthline.setBounds(-1, 568, 1279, 6);
		contentPane.add(sixthline);
		
		totalamountpayableTF = new JTextField();
		totalamountpayableTF.setBounds(191, 93, 221, 20);
		contentPane.add(totalamountpayableTF);
		totalamountpayableTF.setColumns(10);
		
		JLabel TotalAmountPayableLbl = new JLabel("Total Amount Payable:");
		TotalAmountPayableLbl.setForeground(Color.WHITE);
		TotalAmountPayableLbl.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 15));
		TotalAmountPayableLbl.setBounds(10, 90, 190, 24);
		contentPane.add(TotalAmountPayableLbl);
		
		JLabel TotalkilowattUsedlbl = new JLabel("Total kilowatt Used:");
		TotalkilowattUsedlbl.setForeground(Color.WHITE);
		TotalkilowattUsedlbl.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 15));
		TotalkilowattUsedlbl.setBounds(10, 122, 190, 24);
		contentPane.add(TotalkilowattUsedlbl);
		
		TotalKilowattUsedTF = new JTextField();
		TotalKilowattUsedTF.setColumns(10);
		TotalKilowattUsedTF.setBounds(191, 125, 221, 20);
		contentPane.add(TotalKilowattUsedTF);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setForeground(Color.WHITE);
		lblMonth.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 15));
		lblMonth.setBounds(434, 90, 74, 24);
		contentPane.add(lblMonth);
		
		String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		
		JComboBox MonthcomboBox = new JComboBox(month);
		MonthcomboBox.setBounds(496, 92, 147, 22);
		contentPane.add(MonthcomboBox);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 15));
		lblYear.setBounds(434, 122, 74, 24);
		contentPane.add(lblYear);
		
		yearTF = new JTextField();
		yearTF.setColumns(10);
		yearTF.setBounds(496, 125, 147, 20);
		contentPane.add(yearTF);
		
		JButton ComputeButton = new JButton("Compute");
		ComputeButton.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		ComputeButton.setBounds(665, 92, 134, 54);
		contentPane.add(ComputeButton);
		
		JLabel lblAmountPerKilowatt = new JLabel("AMOUNT PER KILOWATT");
		lblAmountPerKilowatt.setBackground(new Color(255, 0, 0));
		lblAmountPerKilowatt.setForeground(new Color(255, 0, 0));
		lblAmountPerKilowatt.setFont(new Font("Rockwell", Font.BOLD, 12));
		lblAmountPerKilowatt.setBounds(821, 102, 168, 24);
		contentPane.add(lblAmountPerKilowatt);
		
		AmountperkilowattresultTF = new JTextField();
		AmountperkilowattresultTF.setColumns(10);
		AmountperkilowattresultTF.setBounds(809, 125, 181, 20);
		AmountperkilowattresultTF.setEditable(false);
		contentPane.add(AmountperkilowattresultTF);
		
		JLabel resultlbl = new JLabel("RESULT");
		resultlbl.setForeground(new Color(255, 255, 255));
		resultlbl.setFont(new Font("Rockwell", Font.BOLD, 12));
		resultlbl.setBackground(Color.RED);
		resultlbl.setBounds(869, 84, 59, 24);
		contentPane.add(resultlbl);
		
		JLabel AmPerKwatbBG = new JLabel("");
		AmPerKwatbBG.setOpaque(true);
		AmPerKwatbBG.setForeground(Color.WHITE);
		AmPerKwatbBG.setBackground(Color.DARK_GRAY);
		AmPerKwatbBG.setBounds(0, 77, 1000, 87);
		contentPane.add(AmPerKwatbBG);
		
		SearchTF = new JTextField();
		SearchTF.setBounds(94, 243, 130, 27);
		contentPane.add(SearchTF);
		SearchTF.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Leelawadee", Font.BOLD, 13));
		btnSearch.setBounds(230, 243, 106, 28);
		contentPane.add(btnSearch);
		
		JLabel lblRoomNo = new JLabel("Room no:");
		lblRoomNo.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		lblRoomNo.setBounds(23, 244, 111, 14);
		contentPane.add(lblRoomNo);
		
		JLabel Namelbl = new JLabel("Name:");
		Namelbl.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		Namelbl.setBounds(25, 266, 59, 14);
		contentPane.add(Namelbl);
		
		fnametf = new JTextField();
		fnametf.setColumns(10);
		fnametf.setBounds(94, 274, 130, 24);
		contentPane.add(fnametf);
		
		lnameTF = new JTextField();
		lnameTF.setColumns(10);
		lnameTF.setBounds(231, 274, 106, 24);
		contentPane.add(lnameTF);
		
		JLabel lastreadinglbl = new JLabel("Last Reading:");
		lastreadinglbl.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		lastreadinglbl.setBounds(25, 307, 106, 18);
		contentPane.add(lastreadinglbl);
		
		lastreadingtf = new JTextField();
		lastreadingtf.setColumns(10);
		lastreadingtf.setBounds(143, 303, 193, 26);
		contentPane.add(lastreadingtf);
		
		JLabel lblPresentReading = new JLabel("Present Reading:");
		lblPresentReading.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		lblPresentReading.setBounds(23, 334, 114, 18);
		contentPane.add(lblPresentReading);
		
		presentreadingtf = new JTextField();
		presentreadingtf.setColumns(10);
		presentreadingtf.setBounds(144, 332, 192, 30);
		contentPane.add(presentreadingtf);
		
		JScrollPane jsp = new JScrollPane();
		
		
		JLabel lblTotalPresentConsumption = new JLabel("Total Present Consumption:");
		lblTotalPresentConsumption.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		lblTotalPresentConsumption.setBounds(19, 411, 183, 18);
		contentPane.add(lblTotalPresentConsumption);
		
		totalpresentconsumptiontf = new JTextField();
		totalpresentconsumptiontf.setColumns(10);
		totalpresentconsumptiontf.setBounds(191, 408, 145, 24);
		totalpresentconsumptiontf.setEditable(false);
		contentPane.add(totalpresentconsumptiontf);
		
		JLabel Total_Amount_Payable_lbl = new JLabel("Total Amount Payable:");
		Total_Amount_Payable_lbl.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		Total_Amount_Payable_lbl.setBounds(18, 439, 183, 18);
		contentPane.add(Total_Amount_Payable_lbl);
		
		totalamountpayabletf = new JTextField();
		totalamountpayabletf.setColumns(10);
		totalamountpayabletf.setBounds(192, 435, 143, 22);
		totalamountpayabletf.setEditable(false);
		contentPane.add(totalamountpayabletf);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setForeground(new Color(153, 0, 0));
		btnCalculate.setFont(new Font("Leelawadee", Font.BOLD, 19));
		btnCalculate.setBounds(25, 363, 312, 39);
		contentPane.add(btnCalculate);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnAdd.setBounds(16, 468, 99, 36);
		contentPane.add(btnAdd);
		
		JButton resetbutton = new JButton("RESET");
		resetbutton.setFont(new Font("SansSerif", Font.BOLD, 15));
		resetbutton.setBounds(126, 469, 99, 36);
		contentPane.add(resetbutton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDelete.setBounds(238, 469, 99, 37);
		contentPane.add(btnDelete);
		
		JButton ownercalculatebtn = new JButton("Compute");
		ownercalculatebtn.setForeground(new Color(153, 0, 0));
		ownercalculatebtn.setFont(new Font("Leelawadee", Font.BOLD, 19));
		ownercalculatebtn.setBounds(364, 588, 275, 48);
		contentPane.add(ownercalculatebtn);
		
		ownerTPCtf = new JTextField();
		ownerTPCtf.setEditable(false);
		ownerTPCtf.setColumns(10);
		ownerTPCtf.setBounds(113, 616, 163, 24);
		contentPane.add(ownerTPCtf);
		
		ownerTMPtf = new JTextField();
		ownerTMPtf.setEditable(false);
		ownerTMPtf.setColumns(10);
		ownerTMPtf.setBounds(710, 618, 163, 24);
		contentPane.add(ownerTMPtf);
		
		JLabel OwnerTPClbl = new JLabel("Total Present Consumption:");
		OwnerTPClbl.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		OwnerTPClbl.setBounds(111, 586, 183, 18);
		contentPane.add(OwnerTPClbl);
		
		//------------para sa EXIT sa right side-----
		JLabel close = new JLabel("X");
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		close.setForeground(Color.WHITE);
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setFont(new Font("Tahoma", Font.BOLD, 30));
		close.setBounds(10, 6, 46, 34);
		contentPane.add(close);
		
		JLabel lblAmountPerKilowatt_1 = new JLabel(" Amount Per Kilowatt Update");
		lblAmountPerKilowatt_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 25));
		lblAmountPerKilowatt_1.setBounds(343, 50, 325, 24);
		contentPane.add(lblAmountPerKilowatt_1);
		
		JLabel ownerTAPlbl = new JLabel("Total Amount Payable:");
		ownerTAPlbl.setFont(new Font("Rockwell Condensed", Font.BOLD, 15));
		ownerTAPlbl.setBounds(711, 590, 183, 18);
		contentPane.add(ownerTAPlbl);
		
		//------TALK TO ME TEXT-----------
		JLabel lblAiChatbot = new JLabel("ELECTRIC BILL CALCULATION");
		lblAiChatbot.setFont(new Font("Khmer UI", Font.BOLD, 30));
		lblAiChatbot.setForeground(Color.WHITE);
		lblAiChatbot.setBackground(Color.WHITE);
		lblAiChatbot.setBounds(294, 10, 427, 29);
		contentPane.add(lblAiChatbot);
		
		//------eto yung box sa ibabaw na gray-------------
		JLabel HEADERGRAY = new JLabel("");
		HEADERGRAY.setBackground(new Color(51, 51, 51));
		HEADERGRAY.setOpaque(true);
		HEADERGRAY.setBounds(0, 0, 1000, 46);
		contentPane.add(HEADERGRAY);
		
		//------------eto yung mismong circle-----------
		JLabel circle = new JLabel("");
		circle.setHorizontalAlignment(SwingConstants.CENTER);
		circle.setIcon(new ImageIcon(Calculation.class.getResource("")));
		circle.setBounds(41, 72, 269, 268);
		contentPane.add(circle);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(255, 204, 51));
		label.setBounds(0, 24, 1000, 625);
		contentPane.add(label);
		
		JLabel lblRoomNolbl = new JLabel("Room No.");
		lblRoomNolbl.setBounds(9, 236, 46, 14);
		contentPane.add(lblRoomNolbl);
		
		
		setUndecorated(true);   //para walang mga frame outline/border
		
	}
}
