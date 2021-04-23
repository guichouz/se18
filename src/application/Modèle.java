package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Random;

public class Modèle extends Observable {
	public DataBaseRecette db;
	public DataBaseRecette db2;
	public DataBaseRecette db3;
	public HashMap<String, Recette> dbglobal;



	public Modèle() throws IOException {
		super();

		db = new DataBaseRecette("BaseDonnéeDessert.txt");
		//creer une grosse base entre plat dessert
		//db1 = new DataBaseRecette("BaseDonnéeDessert.txt");
		this.dbglobal = new HashMap<String, Recette>();

		this.dbglobal.putAll(db.recettemap);

	}

	public void afficheRecette() {
		this.setChanged();
		this.notifyObservers(dbglobal.values());

	}
	public void afficheRecetteUne() {
		Collection<Recette> recettedessert =  (Collection<Recette>) this.db.recettemap.values();
		ArrayList<Recette> listRecetteDessert = new ArrayList<>(recettedessert);
		Recette[] tabrecetteune = new Recette[6];

		Random x = new Random();
		for(int i=0;i<6;i++) {
			if(i<2) {
				int temp=-1;
				int rnd= x.nextInt(listRecetteDessert.size());
				while(rnd==temp) {
					rnd= x.nextInt(listRecetteDessert.size());
				}
				tabrecetteune[i]=listRecetteDessert.get(x.nextInt(listRecetteDessert.size()));
				temp=rnd;
			}
			else if(i<4) {
				int temp=-1;
				int rnd= x.nextInt(listRecetteDessert.size());
				while(rnd==temp) {
					rnd= x.nextInt(listRecetteDessert.size());
				}
				tabrecetteune[i]=listRecetteDessert.get(x.nextInt(listRecetteDessert.size()));
				temp=rnd;

			}
			else {
				int temp=-1;
				int rnd= x.nextInt(listRecetteDessert.size());
				while(rnd==temp) {
					rnd= x.nextInt(listRecetteDessert.size());
				}
				tabrecetteune[i]=listRecetteDessert.get(x.nextInt(listRecetteDessert.size()));
				temp=rnd;

			}
		}
		this.setChanged();
		this.notifyObservers(tabrecetteune);

	}

	public void afficherResultatRecherche(String str,String select) {
		if(select.equals("Par nom de recette")) {
			for (Map.Entry mapentry : dbglobal.entrySet()) {
				if(mapentry.getKey().equals(str)) {
					this.setChanged();

					this.notifyObservers(mapentry.getValue());
					return;
				}
			}
			this.setChanged();
			this.notifyObservers(str);
			
		}
		else {
			ArrayList<Recette> lfound = new ArrayList<Recette>();
			
			for (Map.Entry mapentry : dbglobal.entrySet()) {
				Recette r = (Recette) mapentry.getValue();
				for(Ingredient in : r.ingredients) {
					if(in.nomin.equals(str)) {
						lfound.add(r);
					}

				}


			}
			
			this.setChanged();
			this.notifyObservers(lfound);
		}


	}

}
