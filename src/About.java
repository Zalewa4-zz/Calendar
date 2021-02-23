import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
/**
 * Klasa okienka "O programie"
 * @author Adrian Zalewski
 *
 */
public class About extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JLabel lblAutorAdrianZalewski;
	private JLabel lblProgramSuyDo;
	private JLabel lblWczytywaniaInformacjiZ;
	private JLabel lblEdycjiTychDanych;
	private JLabel lblOrazPonownegoZapisu;
	private JLabel lblOrganizer;

	/**
	 * Metoda uruchamiajıca okienko.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
					frame.setVisible(true);
					frame.setTitle("O Programie");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Metoda w której zawarte sı graficzne komponenty okienka.
	 */
	public About() {
		setTitle("O Programie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblOProgramie = new JLabel("O Programie:");
		lblOProgramie.setBounds(175, 11, 97, 14);
		panel.add(lblOProgramie);
		
		lblAutorAdrianZalewski = new JLabel("Autor: Adrian Zalewski");
		lblAutorAdrianZalewski.setBounds(246, 214, 158, 14);
		panel.add(lblAutorAdrianZalewski);
		
		lblProgramSuyDo = new JLabel("Program s\u0142u\u017Cy do:");
		lblProgramSuyDo.setBounds(31, 70, 158, 14);
		panel.add(lblProgramSuyDo);
		
		lblWczytywaniaInformacjiZ = new JLabel("Wczytywania informacji z bazy danych, oraz z pliku xml");
		lblWczytywaniaInformacjiZ.setBounds(31, 95, 328, 14);
		panel.add(lblWczytywaniaInformacjiZ);
		
		lblEdycjiTychDanych = new JLabel("Edycji tych danych");
		lblEdycjiTychDanych.setBounds(31, 120, 241, 14);
		panel.add(lblEdycjiTychDanych);
		
		lblOrazPonownegoZapisu = new JLabel("Oraz ponownego zapisu danych do bazy i pliku XML");
		lblOrazPonownegoZapisu.setBounds(31, 145, 317, 14);
		panel.add(lblOrazPonownegoZapisu);
		
		lblOrganizer = new JLabel("Organizer");
		lblOrganizer.setBounds(185, 36, 92, 14);
		panel.add(lblOrganizer);
		
	}
}
