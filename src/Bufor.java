import java.util.ArrayList;
/**
 * Klasa Database, w kt�rej zainicjowana jest ArrayLista, kt�ra jest bufforem danych w programie.
 * @author Adrian Zalewski
 *
 */
public class Bufor {
	ArrayList<Zdarzenie> zda = new ArrayList<Zdarzenie>();

	public String toString(){
		String x = null;
		for(int i=0; i<zda.size(); i++){
			x += zda.get(i) + "\n";
		}
		return x;
		
		
	}
}