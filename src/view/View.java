package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicRadioButtonUI;

import classes.Address;
import classes.IPAddress;
import classes.SubnetMask;

/**
 * classe che si occupa della pagina GUI principale
 * @author Lorenzo Tafuro
 * @version 1.71
 */
public class View extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInserireIndirizzoIp;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnSalva;
	private JRadioButton rdbtnTracciaUnIndirizzo;
	private JRadioButton rdbtnCalcolaDallaSubnet;
	private JRadioButton rdbtnNewRadioButton;
	private ButtonGroup group;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Subnetting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(12, 12, 13));
		panel.setBounds(0, 0, 425, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSignIn = new JLabel("Subnetting");
		lblSignIn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblSignIn.setForeground(Color.LIGHT_GRAY);
		lblSignIn.setBounds(30, 25, 93, 30);
		panel.add(lblSignIn);
		
		JLabel lblCalcolaIlSubnetting = new JLabel("Calcola il subnetting con maschera fissa");
		lblCalcolaIlSubnetting.setForeground(new Color(128, 128, 128));
		lblCalcolaIlSubnetting.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCalcolaIlSubnetting.setBounds(30, 48, 222, 30);
		panel.add(lblCalcolaIlSubnetting);
		
		JLabel lblIndirizzoIp = new JLabel("Indirizzo di rete");
		lblIndirizzoIp.setForeground(new Color(128, 128, 128));
		lblIndirizzoIp.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblIndirizzoIp.setBounds(30, 116, 93, 30);
		panel.add(lblIndirizzoIp);
		
		txtInserireIndirizzoIp = new JTextField();
		txtInserireIndirizzoIp.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtInserireIndirizzoIp.setHorizontalAlignment(SwingConstants.CENTER);
		txtInserireIndirizzoIp.setForeground(new Color(0, 139, 139));
		txtInserireIndirizzoIp.setBackground(new Color(23, 23, 25));
		txtInserireIndirizzoIp.setBounds(30, 150, 360, 30);
		panel.add(txtInserireIndirizzoIp);
		txtInserireIndirizzoIp.setColumns(10);
		
		JLabel lblSubnetmask = new JLabel("Subnet mask");
		lblSubnetmask.setForeground(new Color(128, 128, 128));
		lblSubnetmask.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblSubnetmask.setBounds(30, 189, 77, 30);
		panel.add(lblSubnetmask);
		
		textField_1 = new JTextField();
		textField_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(new Color(0, 139, 139));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(23, 23, 25));
		textField_1.setBounds(30, 223, 360, 30);
		panel.add(textField_1);
		
		JLabel lblIndirizzoIp_1_1 = new JLabel("Numero Subnet");
		lblIndirizzoIp_1_1.setForeground(new Color(128, 128, 128));
		lblIndirizzoIp_1_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblIndirizzoIp_1_1.setBounds(30, 264, 93, 30);
		panel.add(lblIndirizzoIp_1_1);
		
		textField_2 = new JTextField();
		textField_2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(new Color(192, 192, 192));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(23, 23, 25));
		textField_2.setBounds(30, 298, 360, 30);
		panel.add(textField_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(0, 0, 420, 7);
		panel.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(0, 153, 255));
		panel_1_1.setBounds(30, 178, 360, 3);
		panel.add(panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(0, 153, 255));
		panel_1_1_1.setBounds(30, 251, 360, 3);
		panel.add(panel_1_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(new Color(0, 153, 255));
		panel_1_1_1_1.setBounds(30, 326, 360, 3);
		panel.add(panel_1_1_1_1);
		
		btnNewButton = new JButton("Chiudi");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.setBounds(30, 391, 150, 40);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnSalva = new JButton("Invia");
		btnSalva.setBackground(Color.LIGHT_GRAY);
		btnSalva.setForeground(Color.WHITE);
		btnSalva.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSalva.setBounds(240, 391, 150, 40);
		panel.add(btnSalva);
		btnSalva.addActionListener(this);
		
		rdbtnNewRadioButton = new JRadioButton("Calcola da numero subnet");
		rdbtnNewRadioButton.setForeground(new Color(128, 128, 128));
		rdbtnNewRadioButton.setBackground(new Color(12, 12, 13));
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setFont(new Font("Segoe UI", Font.BOLD, 8));
		rdbtnNewRadioButton.setBounds(30, 348, 121, 23);
		rdbtnNewRadioButton.setUI(new BasicRadioButtonUI());
		panel.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_1.setEditable(false);
				textField_1.setBackground(new Color(50, 50, 60));
				textField_2.setEditable(true);
				textField_2.setBackground(new Color(23, 23, 25));
				
				setSubnetMask();
			}
		});
		
		rdbtnCalcolaDallaSubnet = new JRadioButton("Calcola dalla subnet mask");
		rdbtnCalcolaDallaSubnet.setForeground(new Color(128, 128, 128));
		rdbtnCalcolaDallaSubnet.setBackground(new Color(12, 12, 13));
		rdbtnCalcolaDallaSubnet.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnCalcolaDallaSubnet.setFont(new Font("Segoe UI", Font.BOLD, 8));
		rdbtnCalcolaDallaSubnet.setBounds(153, 348, 136, 23);
		rdbtnCalcolaDallaSubnet.setUI(new BasicRadioButtonUI());
		panel.add(rdbtnCalcolaDallaSubnet);
		rdbtnCalcolaDallaSubnet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_1.setEditable(true);
				textField_1.setBackground(new Color(23, 23, 25));
				textField_2.setEditable(false);
				textField_2.setBackground(new Color(50, 50, 60));
			}
		});
		
		rdbtnTracciaUnIndirizzo = new JRadioButton("Traccia un Indirizzo");
		rdbtnTracciaUnIndirizzo.setForeground(new Color(128, 128, 128));
		rdbtnTracciaUnIndirizzo.setBackground(new Color(12, 12, 13));
		rdbtnTracciaUnIndirizzo.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTracciaUnIndirizzo.setFont(new Font("Segoe UI", Font.BOLD, 8));
		rdbtnTracciaUnIndirizzo.setBounds(291, 348, 99, 23);
		rdbtnTracciaUnIndirizzo.setUI(new BasicRadioButtonUI());
		panel.add(rdbtnTracciaUnIndirizzo);
		rdbtnTracciaUnIndirizzo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_1.setEditable(true);
				textField_1.setBackground(new Color(23, 23, 25));
				textField_2.setEditable(false);
				textField_2.setBackground(new Color(50, 50, 60));
			}
		});
		
		group = new ButtonGroup();
		group.add(rdbtnTracciaUnIndirizzo);
		group.add(rdbtnCalcolaDallaSubnet);
		group.add(rdbtnNewRadioButton);
		
		JButton[] btns = {btnNewButton, btnSalva};
		for(JButton btn : btns) {
			btn.setBackground(new Color(23, 23, 25));
			btn.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			btn.setUI(new BasicButtonUI());
			
			btn.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					btn.setBackground(new Color(0, 140, 204));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					btn.setBackground(new Color(23, 23, 25));
				}
				
			});
		}
		
		this.setResizable(false);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (this.group.getSelection() == null) {
			JOptionPane.showMessageDialog(View.this, "Selezionare un opzione di calcolo", "Errore", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(this.rdbtnNewRadioButton.isSelected()) {
			setSubnetMask();
			String indirizzoIP = this.txtInserireIndirizzoIp.getText();
			Address ad = null;
			try {
				ad = Address.stringtoAddressRemDot(indirizzoIP);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				this.errorSettingAddress();
				e2.printStackTrace();
			}
			String subnet = this.textField_1.getText();
			SubnetMask sm;
			
			if(textField_1.getText().equals("")) {
				setSubnetMask();
				JOptionPane.showMessageDialog(View.this, "Subnet mask reinserita, riprovare", "Errore", JOptionPane.ERROR_MESSAGE);
			}
			
			
			if(subnet.length() <= 2) {
				sm = new SubnetMask(Integer.valueOf(subnet));
			}else {
				Address sub = null;
				try {
					sub = Address.stringtoAddressRemDot(subnet);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					this.errorSettingAddress();
				}
				sm = new SubnetMask(SubnetMask.toSlashNotation(sub));
			}
			
			IPAddress ipAddress = new IPAddress(ad, sm);
			
			output frame = new output(ipAddress.stringDoSubnettingByNSubnet(Integer.parseInt(this.textField_2.getText())));
			frame.setVisible(true);
			
		} else if(this.rdbtnCalcolaDallaSubnet.isSelected()) {
			String indirizzoIP = this.txtInserireIndirizzoIp.getText();
			Address ad = null;
			try {
				ad = Address.stringtoAddressRemDot(indirizzoIP);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				this.errorSettingAddress();
				e2.printStackTrace();
			}
			String subnet = this.textField_1.getText();
			SubnetMask sm;
			
			if(subnet.length() <= 2) {
				sm = new SubnetMask(Integer.valueOf(subnet));
			}else {
				Address sub = null;
				try {
					sub = Address.stringtoAddressRemDot(subnet);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					this.errorSettingAddress();
					e1.printStackTrace();
				}
				sm = new SubnetMask(SubnetMask.toSlashNotation(sub));
			}
			
			IPAddress ipAddress = new IPAddress(ad, sm);
			
			output frame = new output(ipAddress.stringDoSubnettingBySubnetMask());
			frame.setVisible(true);
			
		} else if (this.rdbtnTracciaUnIndirizzo.isSelected()) {
			String indirizzoIP = this.txtInserireIndirizzoIp.getText();
			Address ad = null;
			try {
				ad = Address.stringtoAddressRemDot(indirizzoIP);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				this.errorSettingAddress();
				e2.printStackTrace();
			}
			String subnet = this.textField_1.getText();
			SubnetMask sm;
			
			if(subnet.length() <= 2) {
				sm = new SubnetMask(Integer.valueOf(subnet));
			}else {
				Address sub = null;
				
				try {
					sub = Address.stringtoAddressRemDot(subnet);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					this.errorSettingAddress();
					e1.printStackTrace();
				}
				sm = new SubnetMask(SubnetMask.toSlashNotation(sub));
			}
			
			IPAddress ipAddress = new IPAddress(ad, sm);
			output frame = null;
			try {
				frame = new output(IPAddress.stringFindSubnetByIP(ipAddress));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(View.this, "Errore durante l'inserimento dei paramentri, ricontrollarne la correttezza", "Errore", JOptionPane.ERROR_MESSAGE);
			}
			frame.setVisible(true);
		} 
		this.textField_1.setText("");
		this.textField_2.setText("");
		this.txtInserireIndirizzoIp.setText("");
		this.group.clearSelection();
		this.textField_1.setEditable(true);
		this.textField_1.setBackground(new Color(23, 23, 25));
		this.textField_2.setEditable(true);
		this.textField_2.setBackground(new Color(23, 23, 25));
		
	}
	
	private void errorSettingAddress() { JOptionPane.showMessageDialog(View.this, "Errore durante l'inserimento dell'indirizzo di rete, controllare di averlo scritto correttamente, controllare anche i punti", "Errore", JOptionPane.ERROR_MESSAGE);}
	private void setSubnetMask() {
		Address address = null;
		try {
			address = Address.stringtoAddressRemDot(txtInserireIndirizzoIp.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.errorSettingAddress();
			e.printStackTrace();
			this.textField_1.setEditable(true);
			this.txtInserireIndirizzoIp.setEditable(true);
			this.textField_2.setEditable(true);
			this.group.clearSelection();
			this.textField_1.setBackground(new Color(23, 23, 25));
		}
		int primoOttetto = address.getPrimoOttetto().getOttetto();
		
		if(0 <=  primoOttetto && primoOttetto <= 127) {
			textField_1.setText("255.0.0.0");
		}else if(128 <= primoOttetto && primoOttetto <= 191) {
			textField_1.setText("255.255.0.0");
		}else if(192 <= primoOttetto && primoOttetto <=223) {
			textField_1.setText("255.255.255.0");
		}else {
			textField_1.setText("");
		}
	}
}