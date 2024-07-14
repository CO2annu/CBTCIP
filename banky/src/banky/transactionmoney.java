package banky;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class transactionmoney {
	static Scanner sc = new Scanner(System.in);
	public void transaction(){
		final JFrame f=new JFrame("Transaction");
	    JLabel l1 , l2 , l3;  
	    l1=new JLabel("Username(FROM)");  
	    l1.setBounds(30,15, 100,30);  
	    l2=new JLabel("Username(TO)");  
	    l2.setBounds(30,55, 100,30);  
	    l3= new JLabel("Amount");
	    l3.setBounds(30 , 95 , 100 ,30);
	     
	    final JTextField user1 = new JTextField();
	    user1.setBounds(140, 15, 200, 30);
	    
	    final JTextField user2 = new JTextField();
	    user2.setBounds(140, 55, 200, 30);
	    
	    final JTextField Amount = new JTextField();
	    Amount.setBounds(140, 95, 200, 30);
	    
	    JButton login_but=new JButton("Transfer");
	    login_but.setBounds(150,135,120,25);
	    login_but.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){ 
	   	 
	        String username1 = user1.getText(); 
	        String username2 = user2.getText();
	        int amount = Integer.parseInt(Amount.getText());
	         
	        if(username1.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter username"); 
	            return;
	        } 
	        if(username2.equals("")) 
	        {
	            JOptionPane.showMessageDialog(null,"Please enter username"); 
	            return;
	        }
	        if(amount == 0)
	        {
	            JOptionPane.showMessageDialog(null,"Please enter Amount"); 
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
				PreparedStatement st = con.prepareStatement("update accounts set amount = amount - ? where name = ?");
				st.setInt(1, amount);
				st.setString(2, username1);
				st.executeUpdate();
				PreparedStatement st1 = con.prepareStatement("update accounts set amount = amount + ? where name = ?");
				st1.setInt(1, amount);
				st1.setString(2, username2);
				st1.executeUpdate();
				PreparedStatement st2 = con.prepareStatement("SELECT amount FROM accounts WHERE name = '" + username1 + "'");
				ResultSet rs = st2.executeQuery();
				PreparedStatement st3 = con.prepareStatement("SELECT amount FROM accounts WHERE name = '" + username2 + "'");
				ResultSet rs1 = st3.executeQuery();
				if (rs.next() && rs1.next()) {
	                int updatedAmount = rs.getInt("amount");
	                JOptionPane.showMessageDialog(null ,"Updated balance for " + username1 + ": " + updatedAmount);
	                int updatedAmount1 = rs1.getInt("amount");
	                JOptionPane.showMessageDialog(null ,"Updated balance for " + username2 + ": " + updatedAmount1);
	                f.dispose();
	            }
				else {
					JOptionPane.showMessageDialog(null ,"Account does not exists");
					PreparedStatement st4 = con.prepareStatement("update accounts set amount = amount + ? where name = ?");
					st4.setInt(1, amount);
					st4.setString(2, username1);
					st4.executeUpdate();
					PreparedStatement st5 = con.prepareStatement("update accounts set amount = amount - ? where name = ?");
					st5.setInt(1, amount);
					st5.setString(2, username2);
					st5.executeUpdate();
				}
				rs.close();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	    }
	        

	    });
	    f.add(login_but);
	    f.add(l1);
	    f.add(l2);
	    f.add(l3);
	    f.add(user1);
	    f.add(user2);
	    f.add(Amount);
	    f.setSize(400,220);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	}
}
//	Connection con;
//	public void transaction() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root" , "root");
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		System.out.println("Enter name you want to transfer money from");	
//		String s1 = sc.next();
//		System.out.println("Enter name you want to transfer money to");
//		String s2 = sc.next();
//		System.out.println("Enter the amount you want to transfer");
//		int x = sc.nextInt();
//		
//		try {
//			PreparedStatement st = con.prepareStatement("update accounts set amount = amount - ? where name = ?");
//			st.setInt(1, x);
//			st.setString(2, s1);
//			st.executeUpdate();
//			PreparedStatement st1 = con.prepareStatement("update accounts set amount = amount + ? where name = ?");
//			st1.setInt(1, x);
//			st1.setString(2, s2);
//			st1.executeUpdate();
//			PreparedStatement st2 = con.prepareStatement("SELECT amount FROM accounts WHERE name = '" + s1 + "'");
//			ResultSet rs = st2.executeQuery();
//			PreparedStatement st3 = con.prepareStatement("SELECT amount FROM accounts WHERE name = '" + s2 + "'");
//			ResultSet rs1 = st3.executeQuery();
//			if (rs.next() && rs1.next()) {
//                int updatedAmount = rs.getInt("amount");
//                System.out.println("Updated balance for " + s1 + ": " + updatedAmount);
//                int updatedAmount1 = rs1.getInt("amount");
//                System.out.println("Updated balance for " + s1 + ": " + updatedAmount1);
//            }
//			else {
//				System.out.println("Account does not exists");
//				PreparedStatement st4 = con.prepareStatement("update accounts set amount = amount + ? where name = ?");
//				st4.setInt(1, x);
//				st4.setString(2, s1);
//				st4.executeUpdate();
//				PreparedStatement st5 = con.prepareStatement("update accounts set amount = amount - ? where name = ?");
//				st5.setInt(1, x);
//				st5.setString(2, s2);
//				st5.executeUpdate();
//			}
//			rs.close();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		banksimulation obj = new banksimulation();
//		obj.mainloop();
//		
//	}
//}
