package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;

public class Modèle extends Observable {
	public DataBaseRecette db;
	public DataBaseRecette db1;



	public Modèle() throws IOException {
		super();

		db = new DataBaseRecette("BaseDonnéeDessert.txt");
		//creer une grosse base entre plat dessert
		//db1 = new DataBaseRecette("BaseDonnéeDessert.txt");
		//db.recettemap.putAll(db1.recettemap);

	}

	public void afficheRecette() {
		this.setChanged();
		this.notifyObservers(db.recettemap.values());

	}

	public void afficherResultatRecherche(String str,String select) {
		if(select.equals("Par nom de recette")) {
			for (Map.Entry mapentry : db.recettemap.entrySet()) {
				if(mapentry.getKey().equals(str)) {
					this.setChanged();

					this.notifyObservers(mapentry.getValue());
				}
			}
			this.setChanged();
			this.notifyObservers("notfound");
		}
		else {
			ArrayList<Recette> lfound = new ArrayList<Recette>();
			System.out.println("x");
			for (Map.Entry mapentry : db.recettemap.entrySet()) {
				Recette r = (Recette) mapentry.getValue();
				if(r.ingredients.contains(str)) {
					lfound.add(r);
				}

			}
			this.setChanged();
			this.notifyObservers(lfound);
		}


	}

}
