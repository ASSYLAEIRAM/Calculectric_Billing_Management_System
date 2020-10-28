package project;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 100, 682, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Close = new JLabel("X");
		Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		Close.setFont(new Font("Tahoma", Font.BOLD, 21));
		Close.setBounds(10, 7, 18, 26);
		contentPane.add(Close);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(home.class.getResource("/light.png")));
		lblNewLabel_2.setBounds(67, 75, 200, 315);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(home.class.getResource("/circlee.png")));
		lblNewLabel_1.setBounds(39, 100, 261, 262);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setAutoscrolls(true);
		lblNewLabel.setBackground(new Color(255, 165, 0));
		lblNewLabel.setBounds(0, 0, 336, 468);
		contentPane.add(lblNewLabel);
		setUndecorated(true);
		
		JButton btnNewButton = new JButton("TENANT");
		btnNewButton.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(434, 131, 158, 47);
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new Tenants();
			}
		});
		
		JButton btnNewButton_1 = new JButton("<html>ELECTRIC BILL<br />CALCULATION</html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					dispose();
					Calculation calcu = new Calculation();
				   
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnNewButton_1.setBounds(434, 200, 158, 55);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BILLING INFO"); 
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new tenantbilling();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(434, 274, 158, 55);
		contentPane.add(btnNewButton_2);
		
		
		setVisible(true);
	}
}
