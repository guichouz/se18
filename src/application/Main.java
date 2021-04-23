package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public Controlleur c1;
	public Modèle m;
	
	@Override
	public void start(Stage primaryStage) {
		try {
		
			m = new Modèle();
			c1= new Controlleur(m);
			
			
			Vue vue1 = new Vue(c1,this);
			this.m.addObserver(vue1);
			
			
			
			
			Scene scene = new Scene(Vue.getRoot());
			this.m.afficheRecette();
			this.m.afficheRecetteUne();
			this.c1.fillBarre(this.m.db.createTabIntit(), this.m.db.createTabIngre());
			this.c1.creerBarre();
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void afficherrecette(Recette r) {
		VueRecette v2 = new VueRecette(c1);
		v2.updateonclick(r);
	}
	
	public static void main(String[] args) throws IOException {
		
		
		launch(args);
	
		
		
	}
}
