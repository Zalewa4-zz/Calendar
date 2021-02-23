/**
 * Klasa Zdarzenie to jedna z najwa¿niejszych wartsw danych w moim programie. 
 * Zainicjowane s¹ tu typy danych jakie przechodz¹ przez buffor.
 * Znajduj¹ siê tu zdefiniowane metody getterów i setterów, konstruktor, oraz metoda toString().
 * 
 * @author Adrian Zalewski
 */
public class Zdarzenie {
	@Override
	public String toString() {
		return "Zdarzenie [ID=" + ID + ", dzient=" + dzient + ", dzien=" + dzien + ", miesiac=" + miesiac + ", rok="
				+ rok + ", godzina=" + godzina + ", minuta=" + minuta + ", sekunda=" + sekunda + ", opis=" + opis
				+ ", miejsce=" + miejsce + "]";
	}

	private int ID;
	private String dzient;
	private int dzien;
	private int miesiac;
	private int rok;
	private int godzina;
	private int minuta;
	private int sekunda;
	private String opis;
	private String miejsce;
	
	public Zdarzenie(int ID, String dzient, int dzien, int miesiac, int rok, int godzina, int minuta, int sekunda, String opis, String miejsce) {
		this.ID = ID;
		this.dzient = dzient;
		this.dzien = dzien;
		this.miesiac = miesiac;
		this.rok = rok;
		this.godzina = godzina;
		this.minuta = minuta;
		this.sekunda = sekunda;
		this.opis = opis;
		this.miejsce = miejsce;
	}
	




	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getDzient() {
		return dzient;
	}

	public void setDzient(String dzient) {
		this.dzient = dzient;
	}

	public int getDzien() {
		return dzien;
	}

	public void setDzien(int dzien) {
		this.dzien = dzien;
	}

	public int getMiesiac() {
		return miesiac;
	}

	public void setMiesiac(int miesiac) {
		this.miesiac = miesiac;
	}

	public int getRok() {
		return rok;
	}

	public void setRok(int rok) {
		this.rok = rok;
	}

	public int getGodzina() {
		return godzina;
	}

	public void setGodzina(int godzina) {
		this.godzina = godzina;
	}

	public int getMinuta() {
		return minuta;
	}

	public void setMinuta(int minuta) {
		this.minuta = minuta;
	}

	public int getSekunda() {
		return sekunda;
	}

	public void setSekunda(int sekunda) {
		this.sekunda = sekunda;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getMiejsce() {
		return miejsce;
	}

	public void setMiejsce(String miejsce) {
		this.miejsce = miejsce;
	}
	
}
