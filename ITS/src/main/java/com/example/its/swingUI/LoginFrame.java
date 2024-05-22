package com.example.its.swingUI;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import lombok.RequiredArgsConstructor;

public class LoginFrame extends JFrame {
	private final LoginController controller;

	private JTextField IDTextField;
	private JTextField PasswordTextField;
	
	
	@RequiredArgsConstructor
	class LoginButtonAction implements ActionListener {
		private final JFrame frame;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(controller.sendLogin(IDTextField.getText(), PasswordTextField.getText())){
				controller.openMainScene();
				frame.dispose();
			}
			else{
				// Print Message
			}
		}
    }

    LoginFrame(LoginController controller){
		this.controller = controller;

		setTitle("Login");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel IDInputPanel = new JPanel();
		GridBagConstraints gbc_IDInputPanel = new GridBagConstraints();
		gbc_IDInputPanel.insets = new Insets(10, 10, 5, 0);
		gbc_IDInputPanel.fill = GridBagConstraints.BOTH;
		gbc_IDInputPanel.gridx = 0;
		gbc_IDInputPanel.gridy = 0;
		getContentPane().add(IDInputPanel, gbc_IDInputPanel);
		GridBagLayout gbl_IDInputPanel = new GridBagLayout();
		gbl_IDInputPanel.columnWidths = new int[] {0};
		gbl_IDInputPanel.rowHeights = new int[] {30, 30, 30, 30};
		gbl_IDInputPanel.columnWeights = new double[]{1.0};
		gbl_IDInputPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		IDInputPanel.setLayout(gbl_IDInputPanel);
		
		JLabel IDLabel = new JLabel("ID");
		IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_IDLabel = new GridBagConstraints();
		gbc_IDLabel.anchor = GridBagConstraints.WEST;
		gbc_IDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_IDLabel.gridx = 0;
		gbc_IDLabel.gridy = 1;
		IDInputPanel.add(IDLabel, gbc_IDLabel);
		
		IDTextField = new JTextField();
		GridBagConstraints gbc_iDTextField = new GridBagConstraints();
		gbc_iDTextField.insets = new Insets(0, 0, 5, 0);
		gbc_iDTextField.gridwidth = 0;
		gbc_iDTextField.fill = GridBagConstraints.BOTH;
		gbc_iDTextField.gridx = 0;
		gbc_iDTextField.gridy = 2;
		IDInputPanel.add(IDTextField, gbc_iDTextField);
		IDTextField.setColumns(10);
		
		JPanel PasswordInputPanel = new JPanel();
		GridBagConstraints gbc_PasswordInputPanel = new GridBagConstraints();
		gbc_PasswordInputPanel.insets = new Insets(0, 10, 10, 0);
		gbc_PasswordInputPanel.fill = GridBagConstraints.BOTH;
		gbc_PasswordInputPanel.gridx = 0;
		gbc_PasswordInputPanel.gridy = 1;
		getContentPane().add(PasswordInputPanel, gbc_PasswordInputPanel);
		GridBagLayout gbl_PasswordInputPanel = new GridBagLayout();
		gbl_PasswordInputPanel.columnWidths = new int[]{0, 0};
		gbl_PasswordInputPanel.rowHeights = new int[] {30, 30, 30, 30};
		gbl_PasswordInputPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_PasswordInputPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		PasswordInputPanel.setLayout(gbl_PasswordInputPanel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_PasswordLabel = new GridBagConstraints();
		gbc_PasswordLabel.anchor = GridBagConstraints.WEST;
		gbc_PasswordLabel.insets = new Insets(0, 0, 5, 0);
		gbc_PasswordLabel.gridx = 0;
		gbc_PasswordLabel.gridy = 1;
		PasswordInputPanel.add(PasswordLabel, gbc_PasswordLabel);
		
		PasswordTextField = new JTextField();
		GridBagConstraints gbc_passwordTextField = new GridBagConstraints();
		gbc_passwordTextField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordTextField.fill = GridBagConstraints.BOTH;
		gbc_passwordTextField.gridx = 0;
		gbc_passwordTextField.gridy = 2;
		PasswordInputPanel.add(PasswordTextField, gbc_passwordTextField);
		PasswordTextField.setColumns(10);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new LoginButtonAction(this));
		GridBagConstraints gbc_LoginButton = new GridBagConstraints();
		gbc_LoginButton.insets = new Insets(10, 10, 10, 10);
		gbc_LoginButton.fill = GridBagConstraints.BOTH;
		gbc_LoginButton.gridheight = 2;
		gbc_LoginButton.gridx = 1;
		gbc_LoginButton.gridy = 0;
		getContentPane().add(LoginButton, gbc_LoginButton);
    }
}