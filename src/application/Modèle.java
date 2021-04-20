package application;

import java.io.IOException;
import java.util.Observable;

public class Modèle extends Observable {
	public DataBaseRecette db;
	
	
	
	public Modèle() throws IOException {
		super();
		db = new DataBaseRecette("BaseDonnéeDessert.txt");
		
		
	}

	public void afficheRecette() {
		this.setChanged();
		this.notifyObservers(db.recettemap.values());
	}

}
