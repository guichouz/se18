package application;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controlleur {
	
	
	@FXML 
	private ImageView recetteclilc1;
	
	@FXML 
	private ImageView recetteclilc2;
	
	@FXML 
	private ImageView recetteclilc3;
	
	@FXML
	private TextArea barrerecherche;
	
	@FXML
	private Button btnrechercher;
	
	@FXML 
	private ImageView imagelogo;
	
	public void Chargerrecette() throws ClassNotFoundException {
		System.out.println("1");
		Stage mainStage = (Stage) recetteclilc1.getScene().getWindow();

		    try {
		            Parent root = FXMLLoader.load(getClass().getResource("pagerecette.fxml"));
		            Scene scene = new Scene(root);
		            mainStage.setScene(scene);
		            mainStage.setTitle("Test Window");
		        }
		            catch(Exception e){}
	    

}
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

