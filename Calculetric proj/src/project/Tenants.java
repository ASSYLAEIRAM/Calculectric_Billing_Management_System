package project;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;



import java.sql.*;


public class Tenants {
		JFrame Frame = new JFrame();
	  DefaultTableModel model = new DefaultTableModel();
	    JTable jtbl = new JTable(model);
	    JPanel panel = new JPanel(null);
	    
	   
	    JButton add = new JButton("ADD");
	    JButton update = new JButton("UPDATE");
	    JButton delete = new JButton("DELETE");
	    JButton Reset = new JButton("RESET");
	    JButton Back = new JButton("BACK");
	    
	    JTextField TextRoomNo = new JTextField();
	    JTextField TextLastName = new JTextField();
	    JTextField TextFirstName = new JTextField();
	    JTextField TextContactNo = new JTextField();
	    JTextField TextEmail = new JTextField();
	    
	    JLabel RoomNo = new JLabel("ROOM NO: ");
	    JLabel LastName = new JLabel("LAST NAME: ");
	    JLabel FirstName = new JLabel("FIRST NAME: ");
	    JLabel ContactNo = new JLabel("CONTACT NO: ");
	    JLabel Email = new JLabel("EMAIL:");
	    
	    JLabel Tenant = new JLabel("TENANT");
	    JLabel TenantList = new JLabel("TENANTS LIST");
	    
	   
	    
	    public Tenants() {
	    	panel.setBackground(new Color(255, 204, 51));
	    	Frame.add(panel);
	    	
	        model.addColumn("ROOM NO:");
	        model.addColumn("LAST NAME");
	        model.addColumn("FIRST NAME");
	        model.addColumn("CONTACT NO");
	        model.addColumn("EMAIL");
	        
	        JScrollPane pg = new JScrollPane(jtbl);
	        pg.setBounds(400, 110, 550, 350);
	        panel.add(pg);
	        
	        updatetable();
	        //label
	        Tenant.setBounds(165,20,200,60);
	        Tenant.setFont(new Font("Agency FB", Font.BOLD, 40));
	        Tenant.setForeground(Color.BLACK);
	        panel.add(Tenant);
	        
	        TenantList.setBounds(550,20,300,60);
	        TenantList.setFont(new Font("Agency FB",Font.BOLD,40));
	        TenantList.setForeground(Color.BLACK);
	        panel.add(TenantList);
	        
	        
	        RoomNo.setBounds(40, 145, 100, 30);
	        RoomNo.setFont(new Font("Tahoma",Font.PLAIN,15));
	        RoomNo.setForeground(Color.BLACK);
	        panel.add(RoomNo);
	        
	        TextRoomNo.setBounds(165, 140, 200, 40);
	        TextRoomNo.setFont(new Font("Tahoma",Font.PLAIN,15));
	        TextRoomNo.setForeground(Color.BLACK);
	        panel.add(TextRoomNo);
	        
	        LastName.setBounds(40, 215, 80, 30);
	        LastName.setFont(new Font("Tahoma",Font.PLAIN,14));
	        LastName.setForeground(Color.BLACK);
	        panel.add(LastName);
	        
	        TextLastName.setBounds(165, 210, 200, 40);
	        TextLastName.setFont(new Font("Tahoma",Font.PLAIN,15));
	        LastName.setForeground(Color.BLACK);
	        panel.add(TextLastName);
	        
	        FirstName.setBounds(40, 285, 150, 30);
	        FirstName.setFont(new Font("Tahoma",Font.PLAIN,15));
	        FirstName.setForeground(Color.BLACK);
	        panel.add(FirstName);
	        
	        TextFirstName.setBounds(165, 280, 200, 40);
	        TextFirstName.setFont(new Font("Tahoma",Font.PLAIN,15));
	        TextFirstName.setForeground(Color.BLACK);
	        panel.add(TextFirstName);
	        
	        ContactNo.setBounds(40, 355, 180, 30);
	        ContactNo.setFont(new Font("Tahoma",Font.PLAIN,15));
	        ContactNo.setForeground(Color.BLACK);
	        panel.add(ContactNo);
	        
	        TextContactNo.setBounds(165, 350, 200, 40);
	        TextContactNo.setFont(new Font("Tahoma",Font.PLAIN,15));
	        panel.add(TextContactNo);
	        
	        Email.setBounds(40,425,190,40);
	        Email.setFont(new Font("Tahoma",Font.PLAIN,15));
	        Email.setForeground(Color.BLACK);
	        panel.add(Email);
	        
	        TextEmail.setBounds(165,420,200,40);
	        TextEmail.setFont(new Font("Tahoma",Font.PLAIN,15));
	        TextEmail.setForeground(Color.BLACK);
	        panel.add(TextEmail);
	        
	        
	        //BUTTON
	        add.setBounds(60, 500, 150, 60);
	        add.setForeground(Color.BLACK);
	        panel.add(add);
	        
	        update.setBounds(245, 500, 150, 60);
	        update.setForeground(Color.BLACK);
	        panel.add(update);
	        
	        delete.setBounds(430, 500, 150, 60);
	        delete.setForeground(Color.BLACK);
	        panel.add(delete);
	        
	        Reset.setBounds(615, 500, 150, 60);
	        Reset.setForeground(Color.BLACK);
	        panel.add(Reset);
	        
	        Back.setBounds(800, 500, 150, 60);
	        Back.setForeground(Color.BLACK);
	        panel.add(Back);
	        
	        
	        
	        	//performed
	        Back.addActionListener(new ActionListener() { //back button functionality

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					Frame.dispose();
					new home();
				}
	        	
	        });
	     
	        update.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					updatedata();
					removedata();
					updatetable();
				}
	        	
	        });
	        Reset.addActionListener(new ActionListener() {   //reset button functionality

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					TextRoomNo.setText("");
					TextLastName.setText("");
					TextFirstName.setText("");
					TextContactNo.setText("");
					TextEmail.setText("");
					
				}
	        	
	        });
	        
	        delete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					deletedata();
					removedata();
					updatetable();
				}
	        	
	        });
	        
	        add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					adddata();
				}
	        	
	        });
	      
	        Frame.setTitle("Tenants");
		    Frame.setSize(1000, 650);
		    Frame.setLocationRelativeTo(null);
		    Frame.setVisible(true);
		    Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    }
	     String sid="";
	     
	    
	    public void adddata(){
	    	 Connection conn = null;
	    	   Statement stmt = null;	
	    	   try{
	    	      //Class.forName("com.mysql.cj.jdbc.Driver");
	    	      System.out.println("Connecting to database...");
	    	      conn = DriverManager.getConnection("jdbc:mysql://localhost:/calculectric?useTimezone=true&serverTimezone=UTC","root","");
	    	      stmt = conn.createStatement();
	    	      String sql2;
	    	      sid= TextRoomNo.getText();
	    	      int id1 = Integer.parseInt(sid);
	    	      String tlastname = TextLastName.getText(); //username1
	    	      String tfname=	TextFirstName.getText();///pssword1
	    	      String tcontno=TextContactNo.getText();//create1
	    	      int cont = Integer.parseInt(sid);
	    	      String temail=TextEmail.getText();
	    	 
	    	      sql2 = "INSERT INTO tenant VALUES("+id1+",'"+tlastname+"','"+tfname+"','"+cont+"','"+temail+"')";
	    	      stmt.executeUpdate(sql2);
	    	      stmt.close();
	    	      conn.close();
	    	      Object[] rows ={sid,tlastname,tfname,tcontno,temail};
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
	    		TextRoomNo.setText("");
				TextLastName.setText("");
				TextFirstName.setText("");
				TextContactNo.setText("");
				TextEmail.setText("");
	    }
		
	    void updatetable() {
	    	try {

	    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/calculectric?useTimezone=true&serverTimezone=UTC", "root", "");
	              Class.forName("com.mysql.cj.jdbc.Driver");
	              PreparedStatement pstm = con.prepareStatement("SELECT * FROM tenant");
	              ResultSet Rs = pstm.executeQuery();
	              
	              while(Rs.next()){
	                  model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getString(5)});
	              }
	              con.close();
	              Rs.close();
	    	    
	    	} catch (Exception e) {
	              System.out.println(e.getMessage());
	          }
	    }

	    
	    void updatedata(){
	    	Connection conn = null;
	    	int row = model.getRowCount();
	    	 
   	       String tlastname = TextLastName.getText(); //username1
   	       String tfname=	TextFirstName.getText();///pssword1
   	       
   	       String tcontno=TextContactNo.getText();//create1
   	       int cont = Integer.parseInt(tcontno);
   	       
   	       String temail=TextEmail.getText();
   	      
   	      
				
		    	try
		        {
		    	      
		          String myDriver = "com.mysql.cj.jdbc.Driver";
		          String myUrl = "jdbc:mysql://localhost:/calculectric?useTimezone=true&serverTimezone=UTC";
		          Class.forName(myDriver);
		           conn = DriverManager.getConnection(myUrl, "root", "");
		          String query = "update tenant SET  lname='"+tlastname+"', fname='"+tfname+"', contactno="+cont+",email='"+temail+"' where roomno = ?";
		          PreparedStatement preparedStmt = conn.prepareStatement(query);
		          String ids= TextRoomNo.getText();
		          int id = Integer.parseInt(ids);
		         
		          preparedStmt.setInt(1, id);
		        
		          preparedStmt.execute();
		          conn.close();
		        }
		        catch (Exception e)
		        {
		          System.err.println("Got an exception! ");
		          System.err.println(e.getMessage());
		        }
			
	    }

	    
	    public void deletedata() {

	    	try
	        {
	          // create the mysql database connection
	          String myDriver = "com.mysql.cj.jdbc.Driver";
	          String myUrl = "jdbc:mysql://localhost/calculectric?useTimezone=true&serverTimezone=UTC";
	          Class.forName(myDriver);
	          Connection conn = DriverManager.getConnection(myUrl, "root", "");
	          String query = "delete from tenant where roomno = ?";
	          PreparedStatement preparedStmt = conn.prepareStatement(query);
	          String ids = TextRoomNo.getText();
	          int id = Integer.parseInt(ids);
	          preparedStmt.setInt(1, id);
	          preparedStmt.execute();
	          conn.close();
	        }
	        catch (Exception e)
	        {
	          System.err.println("Got an exception! ");
	          System.err.println(e.getMessage());
	        }
	    }
	    
	    void removedata(){
	    	
	    	int row = model.getRowCount();
	    	for(int x =0;x<row;x++) {
	    	   	model.removeRow(0);
	    	}
	    }
	    
			public static void main(String[] args) {				
				new Tenants();
			  
			}
}
