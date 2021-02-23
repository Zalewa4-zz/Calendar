import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTree;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Klasa okienka "Ustawienia"
 * @author Adrian Zalewski
 *
 */
public class Settings extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();

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
	public Settings() {
		setTitle("Ustawienia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblOProgramie = new JLabel("Ustawienia");
		lblOProgramie.setBounds(175, 11, 97, 14);
		panel.add(lblOProgramie);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Włącz ciemny motyw");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Window;
				
				Window window = new Window();
				window.frmOrganizerZalewy.setVisible(true);
				window.setVisible(true);
				window.getContentPane().setBackground( Color.BLACK);
			}
		});
		tglbtnNewToggleButton.setBounds(112, 49, 183, 23);
		panel.add(tglbtnNewToggleButton);
		
	}
}
