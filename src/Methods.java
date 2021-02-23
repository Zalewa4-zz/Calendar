import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mysql.jdbc.PreparedStatement;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.toedter.calendar.JCalendar;

//import com.mysql.jdbc.PreparedStatement;
//import com.thoughtworks.xstream.XStream;
/**
 * Wszystkie Metody
 * @author Adrian Zalewski
 *
 */
public class Methods {
	Bufor buf = new Bufor();
	
	/**
	 * Metoda do otworzenia okienka "O Programie"
	 */
	public void AboutApp() {
	JFrame About;
	About = new About();
	About.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	About.setBounds(100, 100, 450, 300);
	About.setVisible(true);
	}
	/**
	 * Metoda do otworzenia okienka "UStawienia"
	 */
	public void Settings() {
		JFrame Settings;
		Settings = new Settings();
		Settings.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Settings.setBounds(100, 100, 450, 300);
		Settings.setVisible(true);
		}
	
	
	/**
	 * Przenoszenie danych z tabelki to buforu.
	 * @param table
	 */
	public void TabelkaDoArrayListy(JTable table) {
		buf.zda.clear();

		for(int row = 0; row < table.getRowCount(); row++) {
			Zdarzenie zdarzenie = new Zdarzenie(row, null, row, row, row, row, row, row, null, null);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for(int column = 0; column < table.getColumnCount(); column++) {
				switch(column) {
					case 0:		zdarzenie.setID((int)model.getValueAt(row, column));
								break;
					case 1: 	zdarzenie.setDzient((String)model.getValueAt(row, column));
								break;
					case 2:		zdarzenie.setDzien((int)model.getValueAt(row, column));
								break;
					case 3:		zdarzenie.setMiesiac((int)model.getValueAt(row, column));
								break;
					case 4: 	zdarzenie.setRok((int)model.getValueAt(row, column));
								break;
					case 5:		zdarzenie.setGodzina((int)model.getValueAt(row, column));
								break;
					case 6: 	zdarzenie.setMinuta((int)model.getValueAt(row, column));
								break;
					case 7: 	zdarzenie.setSekunda((int)model.getValueAt(row, column));
								break;
					case 8: 	zdarzenie.setOpis((String)model.getValueAt(row, column));
								break;
					case 9: 	zdarzenie.setMiejsce((String)model.getValueAt(row, column));
								break;
	}
			}
			buf.zda.add(zdarzenie);
		}
		
	}
	
	
	/**
	 * Zapis do SQL
	 */
	public void SQLZapisz() {
		java.sql.Statement stmt = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                   "user=root&password=");

			stmt = conn.createStatement();
			//Query do wyczyszczenia tabeli.
			String query2 = "DELETE FROM Zdarzenie";
			PreparedStatement ps2=(PreparedStatement) conn.prepareStatement(query2);
			ps2.addBatch();
			ps2.executeBatch();
			//Query do dodania rekordów.
			String query = "INSERT INTO Zdarzenie(ID, DzienT, Dzien, Miesiac, Rok, Godzina, Minuta, Sekunda, Opis, Miejsce) "
	    		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(query); 
			for(int i = 0; i<buf.zda.size(); i++) {
				ps.setInt(1, buf.zda.get(i).getID()); 
				ps.setString(2, buf.zda.get(i).getDzient());
				ps.setInt(3, buf.zda.get(i).getDzien()); 
				ps.setInt(4, buf.zda.get(i).getMiesiac()); 
				ps.setInt(5, buf.zda.get(i).getRok()); 
				ps.setInt(6, buf.zda.get(i).getGodzina()); 
				ps.setInt(7, buf.zda.get(i).getMinuta()); 
				ps.setInt(8, buf.zda.get(i).getSekunda()); 
				ps.setString(9, buf.zda.get(i).getOpis());
				ps.setString(10, buf.zda.get(i).getMiejsce());
				ps.addBatch();
        }
			ps.executeBatch();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
	}

    }	
	
	/**
	 * Wczytanie z SQL
	 */
	public void SQLWczytaj() {
		buf.zda.clear();
		java.sql.Statement stmt = null;
	    String query = "SELECT ID, DzienT, Dzien, Miesiac, Rok, Godzina, Minuta, Sekunda, Opis, Miejsce " +
	                   "FROM " + " Zdarzenie " + " ORDER BY " + " ID";
	Connection conn = null;
	try {
	    conn =
	       DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                   "user=root&password=");

        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
                    	Zdarzenie zdarzenie = new Zdarzenie(0, query, 0, 0, 0, 0, 0, 0, query, query);
                        zdarzenie.setID(rs.getInt("ID"));
                        zdarzenie.setDzient(rs.getString("DzienT"));
                        zdarzenie.setDzien(rs.getInt("Dzien"));
                        zdarzenie.setMiesiac(rs.getInt("Miesiac"));
                        zdarzenie.setRok(rs.getInt("Rok"));
                        zdarzenie.setGodzina(rs.getInt("Godzina"));
                        zdarzenie.setMinuta(rs.getInt("Minuta"));
                        zdarzenie.setSekunda(rs.getInt("Sekunda"));
                        zdarzenie.setOpis(rs.getString("Opis"));
                        zdarzenie.setMiejsce(rs.getString("Miejsce")); 
                        buf.zda.add(zdarzenie);
    	}} catch (SQLException ex) {
    	    // handle any errors
    	    System.out.println("SQLException: " + ex.getMessage());
    	    System.out.println("SQLState: " + ex.getSQLState());
    	    System.out.println("VendorError: " + ex.getErrorCode());
    	    }
	
    	}
	
        
	
	/**
	 * Zapis do XML
	 */
	public void XMLZapisz() {
		File plik = new File("data/Test.xml");
		 try {
			plik.createNewFile();
			FileWriter strumienZapisu = new FileWriter(plik);
			XStream xstream = new XStream(new DomDriver("UTF-8"));
	   		String xml = xstream.toXML(buf.zda.toString());
			strumienZapisu.write(xstream.toXML(buf.zda)); 
			strumienZapisu.close(); 	
	     }
	     catch (IOException io)												
		 	{System.out.println(io.getMessage());}

	     catch (Exception se)
		 	{System.err.println("blad sec");
		 } 
	}
	
	/**
	 * Metoda do Dodawania Wiersza do Tabelki.
	 * @param table
	 * @param textField
	 * @param textField_1
	 * @param calendar
	 * @param spinner
	 * @param spinner_1
	 * @param spinner_2
	 */
	public void Dodaj(JTable table, JTextField textField, JTextField textField_1, JCalendar calendar, JSpinner spinner, JSpinner spinner_1, JSpinner spinner_2) {
		
		String DayOfWeek = " ";
		switch(calendar.getDate().getDay()) {
		case 1: DayOfWeek = "Poniedzialek";
				break;
		case 2: DayOfWeek = "Wtorek";
				break;
		case 3: DayOfWeek = "Sroda";
				break;
		case 4: DayOfWeek = "Czwartek";
				break;
		case 5: DayOfWeek = "Piatek";
				break;
		case 6: DayOfWeek = "Sobota";
				break;
		case 7: DayOfWeek = "Niedziela";
				break;
		default: DayOfWeek = "Niedziela";
				break;
		
		}
		int h = (Integer) spinner.getValue();
		int m = (Integer) spinner_1.getValue();
		int s = (Integer) spinner_2.getValue();
		int x = table.getRowCount();
		int day = calendar.getDate().getDate();
		int month = 1 + calendar.getDate().getMonth();
		int year = 1900 + calendar.getDate().getYear();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object rowData[] = new Object[10];
            rowData[0] = x;
            rowData[1] = DayOfWeek;
            rowData[2] = day;
            rowData[3] = month;
            rowData[4] = year;
            rowData[5] = h;
            rowData[6] = m;
            rowData[7] = s;
            rowData[8] = textField.getText();
            rowData[9] = textField_1.getText();
            model.addRow(rowData);
            
		
	}
	
	/**
	 * Wczytanie z XML
	*/
	public void XMLWczytaj() {
		buf.zda.clear();
		   try {
				File fXmlFile = new File("data/Test.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				NodeList nList = doc.getElementsByTagName("Zdarzenie");
				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element elem = (Element) nNode;
	                    int ID = Integer.parseInt(elem.getElementsByTagName("ID")
                          .item(0).getChildNodes().item(0).getNodeValue());
	                    String dzient = elem.getElementsByTagName("dzient").item(0)
                                .getChildNodes().item(0).getNodeValue();
	                    int dzien = Integer.parseInt(elem.getElementsByTagName("dzien")
	                            .item(0).getChildNodes().item(0).getNodeValue());
	                    int miesiac = Integer.parseInt(elem.getElementsByTagName("miesiac")
	                            .item(0).getChildNodes().item(0).getNodeValue());
	                    int rok = Integer.parseInt(elem.getElementsByTagName("rok")
	                            .item(0).getChildNodes().item(0).getNodeValue());
	                    int godzina = Integer.parseInt(elem.getElementsByTagName("godzina")
	                            .item(0).getChildNodes().item(0).getNodeValue());
	                    int minuta = Integer.parseInt(elem.getElementsByTagName("minuta")
	                            .item(0).getChildNodes().item(0).getNodeValue());
	                    int sekunda = Integer.parseInt(elem.getElementsByTagName("sekunda")
	                            .item(0).getChildNodes().item(0).getNodeValue());
	                    
	                    String opis = elem.getElementsByTagName("opis").item(0)
	                                        .getChildNodes().item(0).getNodeValue();

	                    String miejsce = elem.getElementsByTagName("miejsce").item(0)
                          			.getChildNodes().item(0).getNodeValue();

	                   

	                    buf.zda.add(new Zdarzenie(ID, dzient, dzien, miesiac, rok, godzina, minuta, sekunda, opis, miejsce));
	               }
	          }
		    } catch (Exception ex) {
		    	ex.printStackTrace();
		        }
 }
	
	/**
	 * Dodanie danych z bufora do tabelki.
	 * @param table
	 */
	public void ArrayListaDoTabelki(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object rowData[] = new Object[10];
        for(int i = 0; i < buf.zda.size(); i++)
        {
            rowData[0] = buf.zda.get(i).getID();
            rowData[1] = buf.zda.get(i).getDzient();
            rowData[2] = buf.zda.get(i).getDzien();
            rowData[3] = buf.zda.get(i).getMiesiac();
            rowData[4] = buf.zda.get(i).getRok();
            rowData[5] = buf.zda.get(i).getGodzina();
            rowData[6] = buf.zda.get(i).getMinuta();
            rowData[7] = buf.zda.get(i).getSekunda();
            rowData[8] = buf.zda.get(i).getOpis();
            rowData[9] = buf.zda.get(i).getMiejsce();
            model.addRow(rowData);
            }
        }
    /**
     * Usuwanie zaznaczonego wiersza
     * @param table
     */
	public void UsunZaznaczony(JTable table) {
    	DefaultTableModel model = (DefaultTableModel) table.getModel();
    	model.removeRow(table.getSelectedRow());;
    	for (int i = 0; i<table.getRowCount(); i++) {
    		table.setValueAt(i+1, i, 0); 
    	}
    }
    /**
     * Czyszczenie tabeli
     * @param table
     */
	public void CzyscTabele(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
    }
	
	/**
	 * Okienko
	 * @param infoMessage
	 * @param titleBar
	 */
	public static void infoBox(String infoMessage, String titleBar)
    {
        /* By specifying a null headerMessage String, we cause the dialog to
           not have a header */
        infoBox(infoMessage, titleBar);
    }
	
	/**
	 * Powiadomienia d¿wiêkowe na godzinê przed zdarzeniem.
	 */
	public void Powiadomienie() {
		Zdarzenie zda = new Zdarzenie(0, null, 0, 0, 0, 0, 0, 0, null, null);
		XMLWczytaj();
		LocalDate today = LocalDate.now();
		LocalTime time = LocalTime.now();
	    int localDay = today.getDayOfMonth();
	    int localMonth = today.getMonthValue();
	    int localYear = today.getYear();
	    int localHour = time.getHour();
	    int localMinute = time.getMinute();
	    int localSecond = time.getSecond();
	    boolean sprawdzaj = true;
	    while(sprawdzaj) {
		if(localDay==zda.getDzien()&&localMonth==zda.getMiesiac()&&
				localYear==zda.getRok()&&localHour==zda.getGodzina()-1 && localMinute==zda.getMinuta() && localSecond==zda.getSekunda() ) {
			infoBox("Za godzinê masz wydarzenie!", "Powiadomienie");
			Toolkit.getDefaultToolkit().beep();
		}
		}
		
	}
}