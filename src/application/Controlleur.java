package application;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	private TextArea nomrecette;
	
	@FXML 
	public VBox imagerecettep;

	@FXML 
	public VBox ingredients;
	
	@FXML 
	public VBox preparation;
	
	@FXML 
	public VBox tempspreparation;
	
	@FXML 
	public VBox note;
	
	@FXML
	public VBox id1;
	
	public Modèle m;
	
	public Controlleur(Modèle m) {
	
		this.m = m;
	}
	
	public void Chargerrecette(ImageView img) throws ClassNotFoundException {
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
	public void Rechercher() {
		String chaine = barrerecherche.getText();
		System.out.println(chaine);
		
		
	}
	public void Retourmenu() throws ClassNotFoundException {
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

