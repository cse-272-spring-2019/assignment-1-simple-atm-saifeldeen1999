package saif;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Color;

public class ATM {

	private JFrame frmAtm;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM window = new ATM();
					window.frmAtm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ATM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAtm = new JFrame();
		frmAtm.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Saif\\Term4\\Programming 2\\Assignment 1\\iconfinder_atm_45150 (1).png"));
		frmAtm.setTitle("ATM");
		frmAtm.setBounds(100, 100, 552, 412);
		frmAtm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Account user=new Account("4750388");
		
		
		
		JButton btnNewButton = new JButton("Withdrawal");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 220, 142, 48);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			   {
				user.withdraw(Double.parseDouble(textField.getText()));
			   }
		});
		
		
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setForeground(new Color(255, 255, 255));
		btnDeposit.setBackground(new Color(0, 0, 128));
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDeposit.setBounds(384, 220, 142, 48);
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			    {
				user.deposit(Double.parseDouble(textField.getText()));
				}
		});
		
		
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPrevious.setBackground(new Color(51, 153, 0));
		btnPrevious.setForeground(new Color(255, 255, 255));
		btnPrevious.setBounds(10, 314, 142, 48);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.j>4)
				{
					JOptionPane.showMessageDialog(null, "no previous transactions" );
				}
				else JOptionPane.showMessageDialog(null, user.prev());
			
				
				
					
			}
		});
		JButton btnNext = new JButton("Next");
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setBackground(new Color(51, 153, 0));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNext.setBounds(384, 314, 142, 48);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			    {
				if(user.j<1)
				{
					JOptionPane.showMessageDialog(null, "no following transactions" );
				}
				else JOptionPane.showMessageDialog(null, user.next());
			    }
			
		});
		
		
		JButton btnBalanceInquiry = new JButton("Balance Inquiry");
		btnBalanceInquiry.setForeground(new Color(255, 255, 255));
		btnBalanceInquiry.setBackground(new Color(0, 0, 128));
		btnBalanceInquiry.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBalanceInquiry.setBounds(170, 220, 193, 48);
		btnBalanceInquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, " your balance now is "+ user.getbalance());
				
			}
		});
		
		
		frmAtm.getContentPane().setLayout(null);
		frmAtm.getContentPane().add(btnPrevious);
		frmAtm.getContentPane().add(btnNext);
		frmAtm.getContentPane().add(btnNewButton);
		frmAtm.getContentPane().add(btnBalanceInquiry);
		frmAtm.getContentPane().add(btnDeposit);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 93, 516, 71);
		frmAtm.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterTheAmount = new JLabel("Enter the Amount of Transaction then select service:");
		lblEnterTheAmount.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 21));
		lblEnterTheAmount.setBounds(10, 11, 516, 71);
		frmAtm.getContentPane().add(lblEnterTheAmount);
	}
}
