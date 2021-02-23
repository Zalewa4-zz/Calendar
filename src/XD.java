package kalendar;


import java.awt.EventQueue;

import javax.swing.JFrame;

import com.toedter.calendar.JCalendar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
	
	metody mtd = new metody();
	private JFrame okno;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.okno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		okno = new JFrame();
		okno.setTitle("organizer");
		okno.setBounds(100, 100, 800, 540);
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.getContentPane().setLayout(null);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(12, 0, 23, 1));
		spinner.setBounds(10, 282, 44, 20);
		okno.getContentPane().add(spinner);
		
		final JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_1.setBounds(64, 282, 41, 20);
		okno.getContentPane().add(spinner_1);
		
		final JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_2.setBounds(115, 282, 44, 20);
		okno.getContentPane().add(spinner_2);
		
		final JCalendar calendar = new JCalendar();
		calendar.getDayChooser().setDecorationBackgroundVisible(false);
		calendar.getDayChooser().setBackground(Color.GREEN);
		calendar.setBounds(10, 11, 604, 228);
		okno.getContentPane().add(calendar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 313, 604, 156);
		okno.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "dzien tygodnia", "dzien", "miesiac", "rok", "godzina", "minuta", "sekunda", "opis", "miejsce"
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
		
		JButton btnDodajWpis = new JButton("Dodaj");
		btnDodajWpis.setBounds(624, 347, 127, 36);
		okno.getContentPane().add(btnDodajWpis);
		btnDodajWpis.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				if(textField == null || textField_1 == null) {
					JOptionPane.showMessageDialog(null, "Dodaj miejsce oraz opis!");
				}else {
			mtd.dodaj(table, textField, textField_1, calendar, spinner, spinner_1, spinner_2);
				}
			}
		});
		
		JButton btnUsun = new JButton("usun");
		btnUsun.setBounds(624, 392, 126, 37);
		okno.getContentPane().add(btnUsun);
		btnUsun.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				mtd.Usun(table);;
			}
		});
		
		JButton btnWyczyTabelk = new JButton("wyczysc tabele");
		btnWyczyTabelk.setBounds(624, 432, 126, 37);
		okno.getContentPane().add(btnWyczyTabelk);
		btnWyczyTabelk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mtd.Wyczysc(table);
			}
		});
		
		textField = new JTextField();
		textField.setBounds(368, 266, 197, 36);
		okno.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(204, 282, 106, 20);
		okno.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		

		
		JLabel lblKrtkiOpis = new JLabel("Opis:");
		lblKrtkiOpis.setBounds(368, 239, 67, 33);
		okno.getContentPane().add(lblKrtkiOpis);
		
		JLabel lblCzas = new JLabel("Czas:");
		lblCzas.setBounds(10, 248, 44, 14);
		okno.getContentPane().add(lblCzas);
		
		JLabel lblMiejsce = new JLabel("Miejsce:");
		lblMiejsce.setBounds(205, 250, 55, 14);
		okno.getContentPane().add(lblMiejsce);
		
		JLabel lblH = new JLabel("godzina");
		lblH.setBounds(10, 266, 46, 14);
		okno.getContentPane().add(lblH);
		
		JLabel lblM = new JLabel("minuta");
		lblM.setBounds(59, 266, 46, 14);
		okno.getContentPane().add(lblM);
		
		JLabel lblS = new JLabel("sekunda");
		lblS.setBounds(113, 266, 46, 14);
		okno.getContentPane().add(lblS);
		
		JMenuBar menuBar = new JMenuBar();
		okno.setJMenuBar(menuBar);
		
		JMenu mnPlik = new JMenu("Plik");
		menuBar.add(mnPlik);
		
		JMenuItem mntmZapiszSql = new JMenuItem("Zapisz SQL");
		mntmZapiszSql.setMnemonic(KeyEvent.VK_F1);
		mntmZapiszSql.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F1, ActionEvent.CTRL_MASK));
		mntmZapiszSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mtd.TabelaDoListy(table);
                                mtd.SQLZapisz();
                                
                               
			}
		});
		
		mnPlik.add(mntmZapiszSql);
		
		JMenuItem mntmZapiszXml = new JMenuItem("Zapisz XML");
		mntmZapiszXml.setMnemonic(KeyEvent.VK_F3);
		mntmZapiszXml.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F3, ActionEvent.CTRL_MASK));
		mntmZapiszXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mtd.TabelaDoListy(table);
				mtd.XMLZapisz();
			}
		});
		
		JMenuItem mntmWczytajSql = new JMenuItem("Wczytaj SQL");
		mntmWczytajSql.setMnemonic(KeyEvent.VK_F2);
		mntmWczytajSql.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F2, ActionEvent.CTRL_MASK));
		mntmWczytajSql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            mtd.Wyczysc(table);
                                mtd.SQLWczytaj();
				mtd.ListaDoTabeli(table);
                                
			}
		});
		
		mnPlik.add(mntmWczytajSql);
		
		mnPlik.add(mntmZapiszXml);
		
		JMenuItem mntmWczytajXml = new JMenuItem("Wczytaj XML");
		mntmWczytajXml.setMnemonic(KeyEvent.VK_F4);
		mntmWczytajXml.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
		mntmWczytajXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            mtd.Wyczysc(table);
				mtd.XMLWczytaj(table);
				mtd.ListaDoTabeli(table);
			}
		});
		
		mnPlik.add(mntmWczytajXml);
		
		JMenu mnPomoc = new JMenu("Pomoc");
		menuBar.add(mnPomoc);
		
		JMenuItem mntmOProgramie = new JMenuItem("O Programie");
		mntmOProgramie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mtd.OProgramie();
			}
		});
		mnPomoc.add(mntmOProgramie);
	}
}


