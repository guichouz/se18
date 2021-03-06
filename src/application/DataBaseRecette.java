package application;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
public class DataBaseRecette {
	String pathtxt;
	 public HashMap<String, Recette> recettemap = new HashMap<String, Recette>();
	
	

	public DataBaseRecette(String pathtxt) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(pathtxt));
		String line;
		while ((line = in.readLine()) != null)
		{
			String[] mots= line.split(";");
			String[] ingredTab= mots[4].split(",");
			String[] etapeTab= mots[5].split("/");
			ArrayList<Ingredient> listIngre = new ArrayList<>();
			ArrayList<String> listEtape = new ArrayList<>();
			
			
			for(String x : ingredTab) {
				String nomin="";
				String[] getingre=x.split(" ");
				for(int i=2;i<getingre.length;i++) {
					nomin+=getingre[i]+" ";
					
					
				}
				//System.out.println(nomin);
				Ingredient ne = new Ingredient(nomin,Float.parseFloat(getingre[0]),getingre[1]);
				listIngre.add(ne);
			}
			for(String x : etapeTab) {
				listEtape.add(x);
				
				
			}
			
			
			
			Recette recnew = new Recette(mots[0],Integer.parseInt(mots[1]),Integer.parseInt(mots[2]),Integer.parseInt(mots[3]),listIngre,listEtape);
			this.recettemap.put(mots[0],recnew);
			
		}
		in.close();
		
	}
	
	public ArrayList<String> createTabIngre() {
		ArrayList<String> ltotingre = new ArrayList<>();
		
		 for (Map.Entry mapentry : this.recettemap.entrySet()) {
			Recette r =  (Recette) mapentry.getValue();
			ArrayList<Ingredient> lingre =r.ingredients;
			for(Ingredient ingre : lingre) {
				if(!ltotingre.contains(ingre.nomin)) {
					ltotingre.add(ingre.nomin);
					
					
				}
					
						
					
				
			}
			 
		 }
		return ltotingre;
		
	}
	public ArrayList<String> createTabIntit() {
		ArrayList<String> ltotint = new ArrayList<>();
		
		 for (Map.Entry mapentry : this.recettemap.entrySet()) {
			Recette r =  (Recette) mapentry.getValue();
			String intitu = r.intutile;
			
			if(!ltotint.contains(intitu)) {
				ltotint.add(intitu);
					
						
					
				
			}
			 
		 }
		return ltotint;
		
	}

}
