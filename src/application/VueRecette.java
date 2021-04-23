package application;

import java.util.Observable;
import java.util.Observer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VueRecette  implements Observer {
	public static Controlleur c;
	
	public VueRecette(Controlleur c) {
		this.c=c;
		
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	public void updateonclick(Recette r) {
		Stage stage2 = new Stage();

	    try {
	            Parent root = FXMLLoader.load(Vue.class.getResource("pagerecette.fxml"));
	            Scene scene = new Scene(root);
	            stage2.setScene(scene);
	           
	            stage2.setTitle(r.intutile);
	            stage2.show();
	        }
	            catch(Exception e){
	            	e.printStackTrace();
	            }
	}

}
