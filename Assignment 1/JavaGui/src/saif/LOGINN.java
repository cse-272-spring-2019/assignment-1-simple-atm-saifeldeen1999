package saif;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class LOGINN extends JFrame {

	private JPanel contentPane;
	private JTextField LoginTxtf;
	private static LOGINN  frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try {
					frame = new LOGINN();
					frame.setVisible(true);
			     	} 
				catch (Exception e)
				    {
					e.printStackTrace();
				    }
			}
		});
	}
//create frame
	public LOGINN() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Saif\\Term4\\Programming 2\\Assignment 1\\iconfinder_atm_45150 (2).png"));
		Account saif =new Account("4750388");
		setTitle("ATM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		JLabel lblEnterYourAccount = new JLabel("Enter your account number");
		lblEnterYourAccount.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 25));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblEnterYourAccount, 34, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblEnterYourAccount, 12, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblEnterYourAccount, -2, SpringLayout.EAST, contentPane);
		contentPane.add(lblEnterYourAccount);
		
		
		
		LoginTxtf = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, LoginTxtf, 50, SpringLayout.SOUTH, lblEnterYourAccount);
		sl_contentPane.putConstraint(SpringLayout.WEST, LoginTxtf, 12, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, LoginTxtf, -81, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, LoginTxtf, -228, SpringLayout.EAST, contentPane);
		contentPane.add(LoginTxtf);
		LoginTxtf.setColumns(10);
		
		
		
		JButton Loginbtn = new JButton("Next");
		Loginbtn.setForeground(new Color(0, 0, 0));
		Loginbtn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Loginbtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{ 
				
			if(saif.Login(LoginTxtf.getText())) 
			{
				JOptionPane.showMessageDialog(null, "Logged in");
				ATM.main(null);
				frame.setVisible(false);
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Invalid Account Number");
			}
		
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, Loginbtn, 0, SpringLayout.NORTH, LoginTxtf);
		sl_contentPane.putConstraint(SpringLayout.WEST, Loginbtn, 220, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, Loginbtn, -81, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, Loginbtn, -10, SpringLayout.EAST, contentPane);
		Loginbtn.setBackground(new Color(51, 204, 0));
		contentPane.add(Loginbtn);
	}
}
