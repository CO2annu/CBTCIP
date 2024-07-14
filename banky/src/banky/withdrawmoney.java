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
public class withdrawmoney {
	static Scanner sc = new Scanner(System.in);
	public void withdraw(){
		final JFrame f=new JFrame("Withdraw");
	    JLabel l1 , l2;  
	    l1=new JLabel("Username");  
	    l1.setBounds(30,15, 100,30);  
	    l2=new JLabel("Amount");  
	    l2.setBounds(30,55, 100,30);     
	     
	    final JTextField user = new JTextField();
	    user.setBounds(110, 15, 200, 30);
	    
	    final JTextField Amount = new JTextField();
	    Amount.setBounds(110, 55, 200, 30);
	    
	    JButton login_but=new JButton("withdraw");
	    login_but.setBounds(130,90,80,25);
	    login_but.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e){ 
	   	 
	        String username = user.getText(); 
	        int amount = Integer.parseInt(Amount.getText());
	         
	        if(username.equals("")) 
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
				st.setInt(1 ,amount);
				st.setString(2, username);
				st.executeUpdate();
				PreparedStatement st1 = con.prepareStatement("SELECT amount FROM accounts WHERE name = '" + username + "'");
				ResultSet rs = st1.executeQuery();
				if (rs.next()) {
	                int updatedAmount = rs.getInt("amount");
	                if(updatedAmount<0) {
	                	PreparedStatement st2 = con.prepareStatement("update accounts set amount = amount + ? where name = ?");
	        			st2.setInt(1 ,amount);
	        			st2.setString(2, username);
	        			st2.executeUpdate();
	        			updatedAmount+=amount;
	                		JOptionPane.showMessageDialog(null, "Insuffecient balance , current Balance = "+updatedAmount);
	                }else {
	                	JOptionPane.showMessageDialog( null , " Amount withdrawed , Updated balance for " + username + ": " + updatedAmount);
	                	f.dispose();
	                }
	            }
				else
			{
					JOptionPane.showMessageDialog(null,"Account does not exists");
					
				}
				rs.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e1) {
			
			e1.printStackTrace();
			}

	    }

	    });
	    f.add(login_but);
	    f.add(l1);
	    f.add(l2);
	    f.add(user);
	    f.add(Amount);
	    f.setSize(400,180);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	}
}
//	static Scanner sc = new Scanner(System.in);
//	Connection con;
//	public void withdraw() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root" , "root");
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		System.out.println("enter name you want to withdraw money from");
//		String s = sc.next();
//		System.out.println("enter the amount to withdraw");
//		int x = sc.nextInt();
//		try {
//			PreparedStatement st = con.prepareStatement("update accounts set amount = amount - ? where name = ?");
//			st.setInt(1 ,x);
//			st.setString(2, s);
//			st.executeUpdate();
//			PreparedStatement st1 = con.prepareStatement("SELECT amount FROM accounts WHERE name = '" + s + "'");
//			ResultSet rs = st1.executeQuery();
//			if (rs.next()) {
//                int updatedAmount = rs.getInt("amount");
//                if(updatedAmount<0) {
//                	PreparedStatement st2 = con.prepareStatement("update accounts set amount = amount + ? where name = ?");
//        			st2.setInt(1 ,x);
//        			st2.setString(2, s);
//        			st2.executeUpdate();
//        			updatedAmount+=x;
//        			System.out.println("insufficient balance"+"\n"+"current balance = "+updatedAmount);
//                }
//                else
//                	System.out.println("Updated balance for " + s + ": " + updatedAmount);
//            }
//			else
//			{
//				System.out.println("Account does not exists");
//				banksimulation obj = new banksimulation();
//				obj.mainloop();
//			}
//			rs.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		banksimulation obj = new banksimulation();
//		obj.mainloop();
//     }
//}

