package application;
import java.awt.Label;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Recette {
	String intutile;
	int nbpers;
	int tempprep;
	int difficulte;
	ArrayList<Ingredient> ingredients;
	ArrayList<String> etapeprep;
	public Recette(String intutile, int nbpers, int tempprep, int difficulte, ArrayList<Ingredient> ingredients, ArrayList<String> etapeprep) {
		
		this.intutile = intutile;
		this.nbpers = nbpers;
		this.tempprep = tempprep;
		this.difficulte = difficulte;
		this.ingredients = ingredients;
		this.etapeprep = etapeprep;
	}
	public String  toString() {
		return this.intutile+" " + this.ingredients+" " + this.etapeprep;
	}
	
	public static void main(String[] args) throws IOException {
		DataBaseRecette  dessert = new DataBaseRecette("BaseDonnéeDessert.txt");
		System.out.println(dessert.recettemap.size());
		 for (Map.Entry mapentry : dessert.recettemap.entrySet()) {
			 Label lbl = new Label(mapentry.getKey() + " |  ");
			 
	           System.out.println(mapentry.getKey() 
	                              + " |  " + mapentry.getValue());
	        }
		
	}
	

}
