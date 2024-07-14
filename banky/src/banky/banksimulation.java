package banky;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
public class banksimulation {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		banksimulation.mainloop();
	}
	public static void mainloop() {
		final JFrame f=new JFrame("Banky");
	    JButton create_but = new JButton("Create Account");
	    create_but.setBounds(50,60,120,25);
	    create_but.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	             
	            createaccount ac = new createaccount();
	            ac.create();
	            
	             
	        }
	    });
	    JButton deposit_but = new JButton("Deposit");
	    deposit_but.setBounds(200,60,120,25);
	    deposit_but.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	             
	        	depositmoney dm = new depositmoney();
				dm.deposit();
	            
	             
	        }
	    });
	    JButton withdraw_but = new JButton("Withdraw");
	    withdraw_but.setBounds(350,60,120,25);
	    withdraw_but.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	        	withdrawmoney wm = new withdrawmoney();
	        	wm.withdraw();
	            
	             
	        }
	    });
	    JButton transfer_but = new JButton("Transfer");
	    transfer_but.setBounds(500,60,120,25);
	    transfer_but.addActionListener(new ActionListener() { 
	        public void actionPerformed(ActionEvent e){
	        	transactionmoney tm = new transactionmoney();
				tm.transaction();
	            
	             
	        }
	    });
	    f.add(transfer_but);
	    f.add(withdraw_but);
	    f.add(deposit_but);
	    f.add(create_but);
	    f.setSize(700,200);
	    f.setLayout(null);
	    f.setVisible(true);
	    f.setLocationRelativeTo(null);
	}
//	public void mainloop()
//	{
//		System.out.println("choose given options");
//		System.out.println("1. create account");
//		System.out.println("2. deposit money");
//		System.out.println("3. withdraw money");
//		System.out.println("4. transfer money");
//		System.out.println("5. exit");
//		try {
//			int x = sc.nextInt();
//			switch(x) {
//				case 1:
//					createaccount ca = new createaccount();
//					ca.create();
//				    break;
//				case 2:
//					depositmoney dm = new depositmoney();
//					dm.deposit();
//					break;
//				case 3:
//					withdrawmoney wm = new withdrawmoney();
//					wm.withdraw();
//					break;
//				case 4:
//					transactionmoney tm = new transactionmoney();
//					tm.transaction();
//					break;
//				case 5:
//					System.out.println("Thanks for using");
//					System.exit(0);
//					break;
//				default:
//					System.out.println("Invalid Input");
//					banksimulation obj = new banksimulation();
//					obj.mainloop();
//					break;
//			}	
//		}
//		catch(Exception e)
//		{
//			System.out.println("Invalid input1");
//			banksimulation obj = new banksimulation();
//			obj.mainloop();
//		}
//	}
	
}
