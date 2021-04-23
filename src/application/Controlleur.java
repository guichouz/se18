package application;





import java.util.ArrayList;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controlleur {
	
	
	@FXML
	private AnchorPane recette1;
	
	@FXML
	private TextArea barrerecherche;
	
	@FXML
	private Button btnrechercher;
	
	@FXML 
	private ImageView imagelogo;
	

	@FXML
	public VBox id1;
	
	@FXML
	public ComboBox searchbar;
	
	@FXML
	public MenuButton selectresearch;
	
	@FXML
	public ToggleGroup selectionitem;
	
	@FXML
	public VBox recefav;
	
	@FXML
	public Text textacc1,textacc2;
	
	@FXML
	private Text nomrecette1;
	
	
	public SearchBar barreRecherche;
	
	
	public Modèle m;
	
	public Controlleur(Modèle m) {
	
		this.m = m;
	}
	
	public void creerBarre() {
		barreRecherche= new SearchBar(searchbar,this);
		
		
	}
	@FXML
	public void reupdateSearchBar() {
		this.searchbar.getItems().clear();
		
		this.fillBarre(this.m.db.createTabIntit(), this.m.db.createTabIngre());
		this.creerBarre();
	}
	
	
	public void fillBarre(ArrayList<String> lrecette, ArrayList<String> lingredient ) {
		String select = ((RadioMenuItem) this.selectionitem.getSelectedToggle()).getText();
		System.out.println(select);
		if(select.equals("Par nom de recette")) {
			for(String c : lrecette) {
				this.searchbar.getItems().add(c);
				
				
			}
			
			
		}
		else {
			for(String c : lingredient) {
				this.searchbar.getItems().add(c);
				
			}
		}
		
	}
	
	public void resultatRecherche(String str) {
		String select = ((RadioMenuItem) this.selectionitem.getSelectedToggle()).getText();
		this.m.afficherResultatRecherche(str,select);
		
		
	}
	public void chargerrecette(ImageView img) throws ClassNotFoundException {
		System.out.println("1");
		Stage mainStage = (Stage) img.getScene().getWindow();

		    try {
		            Parent root = FXMLLoader.load(getClass().getResource("pagerecette.fxml"));
		            Scene scene = new Scene(root);
		            mainStage.setScene(scene);
		            mainStage.setTitle("Test Window");
		        }
		            catch(Exception e){
		            	System.out.println("error");
		            }
	    

}
	@FXML
	public void rechercher() {
		String chaine = barrerecherche.getText();
		System.out.println(chaine);
		
		
	}
	public void retourmenu() throws ClassNotFoundException {
		System.out.println("2");
		Stage mainStage = (Stage) imagelogo.getScene().getWindow();

		    try {
		            Parent root = FXMLLoader.load(getClass().getResource("fxxlmappli.fxml"));
		            Scene scene = new Scene(root);
		            mainStage.setScene(scene);
		            mainStage.setTitle("Test Window");
		        }
		            catch(Exception e){}

}
}

