package saif;

import javax.swing.JOptionPane;

public class Account {
	private double Balance ;
	private String cardNum;
	public String[] history=new String[5];
	int j =-1;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//set balance to 0.00
	///////////////////////////////////////////////////////////////////////////////////////////////
	public Account(String cardNum){
		
		this.cardNum=cardNum;
		Balance = 0.00;
		
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//deposit
	/////////////////////////////////////////////////////////////////////////////////////////////
	public void deposit (double amount) {
		
		Balance = Balance + amount;
		JOptionPane.showMessageDialog(null, "Transaction Complete. You Deposited "+ amount +" and your Balance now is " + getbalance());
		for(int i=4;i>0;i--) {
			history[i]=history[i-1];
		}
		history[0]="You Deposited "+amount;
	
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	//withdraw 
    ////////////////////////////////////////////////////////////////////////////////////////////
	public void withdraw (double amount) {
		
		if(Balance<amount) {
			JOptionPane.showMessageDialog(null, "Your Balance is insufficient");
		}
			
			
		else {
			Balance=Balance-amount;
			JOptionPane.showMessageDialog(null, "Transaction Complete. You Withdrawn "+ amount +" and your Balance now is " + getbalance());
			for(int i=4;i>0;i--) {
				history[i]=history[i-1];
			}
			history[0]="You withdrawn "+amount;
		}
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	//get balance
	//////////////////////////////////////////////////////////////////////////////////////////
	public double getbalance() {
		
		return (Balance) ;
		
	}
	
	public boolean Login(String cardNum) {
		return (this.cardNum.equals(cardNum));
	}
	
	public String prev() {
		return(history[++j]);
	}
	
	public String next() {
		return(history[--j]);
	}
	
}
