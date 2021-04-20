package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
			
			
			Vue vue1 = new Vue(c1);
			this.m.addObserver(vue1);
			
			
			
			Scene scene = new Scene(Vue.getRoot());
			this.m.afficheRecette();
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		
		launch(args);
	
		
		
	}
}
