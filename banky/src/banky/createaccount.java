package banky;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

import javax.swing.*;
public class createaccount {
	static Scanner sc = new Scanner(System.in);
	public void create(){
		final JFrame f=new JFrame("create");
	    JLabel l1;  
	    l1=new JLabel("Username");  
	    l1.setBounds(30,15, 100,30);  
	         
	     
	    final JTextField user = new JTextField();
	    user.setBounds(110, 15, 200, 30);
	    
	    JButton login_but=new JButton("Create");
	    login_but.setBounds(130,90,80,25);
	    login_but.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){ 
	   	 
	        String username = user.getText();  
	         
	        if(username.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter username"); 
	            return;
	        } 
	        Connection con = null;
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root" , "root");
			}
			catch(Exception e1) {
				System.out.println(e1);
			}
	        try {
				
				PreparedStatement st = con.prepareStatement("insert into accounts(name , amount) values(?,?)");
				
				st.setString(1 , username);
				st.setInt(2, 0);
				st.executeUpdate();
				JOptionPane.showMessageDialog(null , "Account created Successfully!");
				f.dispose();
	        }
	        catch(Exception e1)
	        {
	        	JOptionPane.showMessageDialog(null, "Account already exists with that name!! try unique name");
	        }

	    }

	    });
	    f.add(login_but);
	    f.add(l1);
	    f.add(user);
	    f.setSize(400,180);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	}
//	public void create() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root" , "root");
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		System.out.println("enter name \n");
//		String s = sc.next();
//		try {
//			
//			PreparedStatement st = con.prepareStatement("insert into accounts(name , amount) values(?,?)");
//			st.setString(1 , s);
//			st.setInt(2, 0);
//			st.executeUpdate();
//			System.out.println("Account created"+"\n"+"Name = "+s+" balance = 0");
//		} catch (SQLException e) {
//			System.out.println("Account already exits with that name!! try unique name");
//			createaccount ca = new createaccount();
//			ca.create();
//		}
//		try {
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		banksimulation obj = new banksimulation();
//		obj.mainloop();
}
