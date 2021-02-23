/**
 * G³ówna klasa interfejsu, która odpowiada za wygl¹d okienka g³ównego.
 * @author Adrian Zalewski
 */
import java.awt.EventQueue;

import javax.swing.JFrame;

import com.sun.glass.events.KeyEvent;
import com.toedter.calendar.JCalendar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class Window extends JFrame {
	
	Methods mtd = new Methods();
	JFrame frmOrganizerZalewy;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Odpalanie aplikacji
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmOrganizerZalewy.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Inicjalizacja
	 */
	public Window() {
		initialize();
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOrganizerZalewy = new JFrame();
		frmOrganizerZalewy.setTitle("Organizer Zalewy");
		frmOrganizerZalewy.setBounds(100, 100, 800, 540);
		frmOrganizerZalewy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOrganizerZalewy.getContentPane().setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(12, 0, 23, 1));
		spinner.setBounds(10, 282, 44, 20);
		frmOrganizerZalewy.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_1.setBounds(64, 282, 41, 20);
		frmOrganizerZalewy.getContentPane().add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_2.setBounds(115, 282, 44, 20);
		frmOrganizerZalewy.getContentPane().add(spinner_2);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 11, 604, 228);
		frmOrganizerZalewy.getContentPane().add(calendar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 313, 604, 156);
		frmOrganizerZalewy.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Dzie\u0144 Tygodnia", "Dzie\u0144", "Miesi\u0105c", "Rok", "Godzina", "Minuta", "Sekunda", "Opis", "Miejsce"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setPreferredWidth(39);
		table.getColumnModel().getColumn(3).setPreferredWidth(53);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(55);
		table.getColumnModel().getColumn(6).setPreferredWidth(53);
		table.getColumnModel().getColumn(7).setPreferredWidth(54);
		table.getColumnModel().getColumn(8).setPreferredWidth(131);
		table.getColumnModel().getColumn(9).setPreferredWidth(92);
		scrollPane.setViewportView(table);
		
		JLabel lblNarzdzia = new JLabel("Narz\u0119dzia");
		lblNarzdzia.setBounds(672, 11, 67, 14);
		frmOrganizerZalewy.getContentPane().add(lblNarzdzia);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		panel.setBounds(624, 32, 150, 437);
		frmOrganizerZalewy.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 24, 130, 79);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnDodajZdarzenie = new JButton("Dodaj");
		panel_1.add(btnDodajZdarzenie);
		btnDodajZdarzenie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField == null || textField_1 == null) {
					JOptionPane.showMessageDialog(null, "Dodaj miejsce oraz opis!");
				}else {
			mtd.Dodaj(table, textField, textField_1, calendar, spinner, spinner_1, spinner_2);
				}
			}
		});
		
		JButton btnUsuZaznaczoneZdarzenie = new JButton("Usu\u0144 zaznaczone");
		panel_1.add(btnUsuZaznaczoneZdarzenie);
		btnUsuZaznaczoneZdarzenie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mtd.UsunZaznaczony(table);;
			}
		});
		
		JButton btnWyczyTabelk = new JButton("Wyczy\u015B\u0107 tabelk\u0119");
		btnWyczyTabelk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mtd.CzyscTabele(table);
			}
		});
		panel_1.add(btnWyczyTabelk);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 149, 130, 60);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("SQL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mtd.TabelkaDoArrayListy(table);
				mtd.SQLZapisz();
				
			}

		
			
		});
		panel_2.add(btnNewButton);
		
		JButton btnXml = new JButton("XML");
		btnXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mtd.TabelkaDoArrayListy(table);
				mtd.XMLZapisz();
			}
		});
		panel_2.add(btnXml);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 245, 130, 60);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnSql = new JButton("SQL");
		btnSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mtd.CzyscTabele(table);
				mtd.SQLWczytaj();
				mtd.ArrayListaDoTabelki(table);
			}
		});
		panel_3.add(btnSql);
		
		JButton btnXml_1 = new JButton("XML");
		btnXml_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mtd.CzyscTabele(table);
				mtd.XMLWczytaj();
				mtd.ArrayListaDoTabelki(table);
			}
		});
		panel_3.add(btnXml_1);
		
		JLabel lblWczytaj = new JLabel("Wczytaj");
		lblWczytaj.setBounds(55, 220, 46, 14);
		panel.add(lblWczytaj);
		
		JLabel lblZdarzenie = new JLabel("Zdarzenie");
		lblZdarzenie.setBounds(55, 11, 58, 14);
		panel.add(lblZdarzenie);
		
		JLabel lblZapisz = new JLabel("Zapisz");
		lblZapisz.setBounds(55, 114, 58, 37);
		panel.add(lblZapisz);
		
		textField = new JTextField();
		textField.setBounds(368, 266, 197, 36);
		frmOrganizerZalewy.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(204, 282, 106, 20);
		frmOrganizerZalewy.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		

		
		JLabel lblKrtkiOpis = new JLabel("Kr\u00F3tki Opis:");
		lblKrtkiOpis.setBounds(368, 239, 67, 33);
		frmOrganizerZalewy.getContentPane().add(lblKrtkiOpis);
		
		JLabel lblCzas = new JLabel("Czas:");
		lblCzas.setBounds(10, 248, 44, 14);
		frmOrganizerZalewy.getContentPane().add(lblCzas);
		
		JLabel lblMiejsce = new JLabel("Miejsce:");
		lblMiejsce.setBounds(205, 250, 55, 14);
		frmOrganizerZalewy.getContentPane().add(lblMiejsce);
		
		JLabel lblH = new JLabel("H");
		lblH.setBounds(44, 269, 46, 14);
		frmOrganizerZalewy.getContentPane().add(lblH);
		
		JLabel lblM = new JLabel("M");
		lblM.setBounds(93, 269, 46, 14);
		frmOrganizerZalewy.getContentPane().add(lblM);
		
		JLabel lblS = new JLabel("S");
		lblS.setBounds(149, 269, 46, 14);
		frmOrganizerZalewy.getContentPane().add(lblS);
		
		JMenuBar menuBar = new JMenuBar();
		frmOrganizerZalewy.setJMenuBar(menuBar);
		
		JMenu mnPlik = new JMenu("Plik");
		menuBar.add(mnPlik);
		
		JMenuItem mntmZapiszSql = new JMenuItem("Zapisz SQL");
		mntmZapiszSql.setMnemonic(KeyEvent.VK_F1);
		mntmZapiszSql.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
		mntmZapiszSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mtd.TabelkaDoArrayListy(table);
				mtd.SQLZapisz();
			}
		});
		
		mnPlik.add(mntmZapiszSql);
		
		JMenuItem mntmZapiszXml = new JMenuItem("Zapisz XML");
		mntmZapiszXml.setMnemonic(KeyEvent.VK_F2);
		mntmZapiszXml.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F2, ActionEvent.CTRL_MASK));
		mntmZapiszXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mtd.TabelkaDoArrayListy(table);
				mtd.XMLZapisz();
			}
		});
		
		mnPlik.add(mntmZapiszXml);
		
		JMenuItem mntmWczytajSql = new JMenuItem("Wczytaj SQL");
		mntmWczytajSql.setMnemonic(KeyEvent.VK_F3);
		mntmWczytajSql.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F3, ActionEvent.CTRL_MASK));
		mntmWczytajSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mtd.CzyscTabele(table);
				mtd.SQLWczytaj();
				mtd.ArrayListaDoTabelki(table);
			}
		});
		
		mnPlik.add(mntmWczytajSql);
		
		JMenuItem mntmWczytajXml = new JMenuItem("Wczytaj XML");
		mntmWczytajXml.setMnemonic(KeyEvent.VK_F4);
		mntmWczytajXml.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
		mntmWczytajXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mtd.CzyscTabele(table);
				mtd.XMLWczytaj();
				mtd.ArrayListaDoTabelki(table);
			}
		});
		
		mnPlik.add(mntmWczytajXml);
		
		JMenu mnNarzdzia = new JMenu("Narzêdzia");
		menuBar.add(mnNarzdzia);
		
		JMenuItem mntmUstawienia = new JMenuItem("Ustawienia");
		mntmUstawienia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mtd.Settings();
			}
		});
		mnNarzdzia.add(mntmUstawienia);
		
		JMenu mnPomoc = new JMenu("Pomoc");
		menuBar.add(mnPomoc);
		
		JMenuItem mntmOProgramie = new JMenuItem("O Programie");
		mntmOProgramie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mtd.AboutApp();
			}
		});
		mnPomoc.add(mntmOProgramie);
	}
}