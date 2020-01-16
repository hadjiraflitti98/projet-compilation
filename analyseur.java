package compil;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

public class analyseur extends semantique {

	private JFrame frmMonAnalyseur;
	JTextArea textArea;

	static JFileChooser file_chooser = new JFileChooser("C:\\Users\\pc\\Desktop");
	static FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers text", "compila");
	
	public static void charger() throws FileNotFoundException {
		file_chooser.addChoosableFileFilter(filter);
		if(file_chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			File file = file_chooser.getSelectedFile();
			Scanner sc_lignes = new Scanner(file);
			Scanner sc_mots = new Scanner(file);
			mots.clear();
			lignes.clear();
				while(sc_lignes.hasNextLine()){
					lignes.add(sc_lignes.nextLine());
				}
				while(sc_mots.hasNext()){
					mots.add(sc_mots.next());
					}

			sc_mots.close();
			sc_lignes.close();
			}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					analyseur window = new analyseur();
					window.frmMonAnalyseur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public analyseur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonAnalyseur = new JFrame();
		frmMonAnalyseur.setResizable(false);
		frmMonAnalyseur.setTitle("compilateur");
		frmMonAnalyseur.getContentPane().setBackground(Color.GRAY);
		frmMonAnalyseur.getContentPane().setLayout(null);
		frmMonAnalyseur.setLocationRelativeTo(null);

		Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 38, 218, 482);
		frmMonAnalyseur.getContentPane().add(panel);
				panel.setLayout(null);
				
								JButton btnNewButton = new JButton("Charger");
								btnNewButton.setBounds(25, 27, 156, 59);
								panel.add(btnNewButton);
								btnNewButton.setCursor(cursor);
								btnNewButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {

										try {
											  textArea.setText("");
											charger();


											int i = 0;
											while (i < lignes.size()) {
												textArea.setText(textArea.getText()+lignes.get(i)+"\n");
												i++;}
										} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}

									}
								});
								btnNewButton.setForeground(new Color(0, 0, 0));
								btnNewButton.setBackground(new Color(169, 169, 169));
								btnNewButton.setFont(new Font("Roboto", Font.BOLD, 17));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(233, 38, 728, 360);
		frmMonAnalyseur.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 708, 338);
		panel_1.add(scrollPane);

		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.GRAY);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 16));
																		
																		JPanel panel_2 = new JPanel();
																		panel_2.setLayout(null);
																		panel_2.setBackground(Color.GRAY);
																		panel_2.setBounds(238, 409, 723, 111);
																		frmMonAnalyseur.getContentPane().add(panel_2);
																		
																		JLabel label = new JLabel("Commandes :");
																		label.setForeground(Color.BLACK);
																		label.setFont(new Font("Dialog", Font.BOLD, 25));
																		label.setBounds(10, 394, 195, 59);
																		panel_2.add(label);
																		
																						JButton btnAlexicale = new JButton("Lexicale");
																						btnAlexicale.setBounds(27, 25, 156, 59);
																						panel_2.add(btnAlexicale);
																						btnAlexicale.setCursor(cursor);
																						btnAlexicale.addActionListener(new ActionListener() {
																							public void actionPerformed(ActionEvent e) {
																								textArea.setText("");
																								lexicale(mots);
																								int i = 0;
																								while (i < mots.size()) {
																									textArea.setText(textArea.getText()+mots.get(i) + " ========= " + sortie_lexic.get(i)+"\n");
																									i++;}
																							}
																						});
																						btnAlexicale.setForeground(new Color(0, 0, 0));
																						btnAlexicale.setBackground(Color.LIGHT_GRAY);
																						btnAlexicale.setFont(new Font("Roboto", Font.BOLD, 17));
																						
																										JButton btnAsyntaxique = new JButton("Syntaxique");
																										btnAsyntaxique.setBounds(258, 25, 156, 59);
																										panel_2.add(btnAsyntaxique);
																										btnAsyntaxique.setCursor(cursor);
																										btnAsyntaxique.addActionListener(new ActionListener() {
																											public void actionPerformed(ActionEvent e) {
																												textArea.setText("");
																												int i = 0;
																												while (i < lignes.size()) {
																													textArea.setText(textArea.getText()+lignes.get(i) + "=========" +syntaxique(lignes.get(i))+"\n");
																													i++;}
																											}
																										});
																										btnAsyntaxique.setForeground(new Color(0, 0, 0));
																										btnAsyntaxique.setBackground(Color.LIGHT_GRAY);
																										btnAsyntaxique.setFont(new Font("Roboto", Font.BOLD, 17));
																										
																														JButton btnAsmantique = new JButton("S\u00E9mantique");
																														btnAsmantique.setBounds(473, 25, 195, 59);
																														panel_2.add(btnAsmantique);
																														btnAsmantique.setCursor(cursor);
																														btnAsmantique.addActionListener(new ActionListener() {
																															public void actionPerformed(ActionEvent e) {
																																textArea.setText("");
																																int i = 0;
																																
																																
																																while (i < lignes.size()) {
																																	textArea.setText(textArea.getText()+lignes.get(i) + "=========" +semant(lignes.get(i))+"\n");
																																	
																																	i++;}
																																
																																
																														            
																																    
																																
																																
																															}
																														});
																														btnAsmantique.setForeground(new Color(0, 0, 0));
																														btnAsmantique.setBackground(Color.LIGHT_GRAY);
																														btnAsmantique.setFont(new Font("Roboto", Font.BOLD, 17));
		frmMonAnalyseur.setBounds(100, 100, 977, 560);
		frmMonAnalyseur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
