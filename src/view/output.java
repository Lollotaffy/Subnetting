package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import utilities.FileBuffered;

/**
 * classe che si occupa dell'output della pagina GUI, richiede come parametro un Array di Stringhe per poter stampare il risultato in TextArea
 * @author Lorenzo Tafuro
 * @version 1.7
 */
public class output extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public output(String[] outputArray) {
		setTitle("Subnetting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(13, 13, 15));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(13, 13, 15));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("Chiudi");
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Salva");
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_1.setBounds(30, 391, 150, 40);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					FileBuffered.fileWriter(outputArray);
					JOptionPane.showMessageDialog(output.this, "sessione salvata con successo", "Salvataggio effettuato", JOptionPane.PLAIN_MESSAGE);
						
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(output.this, "Qualcosa è andato storto, riprovare", "Errore", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		textArea.setEditable(false);
		contentPane.add(textArea, BorderLayout.CENTER);
		textArea.setBackground(new Color(23, 23, 25));
		textArea.setForeground(new Color(240, 240, 240));
		for(int i = 0; i < outputArray.length; i++) {
			textArea.append(outputArray[i]);
		}
		
		JScrollPane scrollPane  = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scrollPane );
		
		JButton[] btns = {btnNewButton, btnNewButton_1};
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
	}

}
