package application;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;



import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Vue implements Observer{
	
	public static Controlleur c;
	public static AnchorPane root;

	public Vue(Controlleur c) {
		
		this.c = c;
	}
	public static AnchorPane getRoot()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Vue.class.getResource("fxxlmappli.fxml"));
        loader.setController(c);

        try {
            root = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }


	@Override
	public void update(Observable o, Object arg) {
		Collection<Recette> recettecol =  (Collection<Recette>) arg;
		ArrayList<Recette> listRecette = new ArrayList<Recette>(recettecol);
		//Collections.sort((List<Recette>) listRecette);
		//VBox boxrecette = (VBox) root.lookup("#receAcceuil");
		
		for(int i=0; i<listRecette.size()/3+listRecette.size()%3;i++) {
			HBox lig = new HBox();
			lig.setAlignment(Pos.CENTER);
			lig.setSpacing(10);
			
			for(int j=0;j<3;j++) {
				if((i+2)*i+j<listRecette.size()) {
					String nomrecette =listRecette.get((i+2)*i+j).intutile;
					VBox imgbox = new VBox();
					Label lbl = new Label(nomrecette);
					try {
						FileInputStream files = new FileInputStream("src/image/"+nomrecette+".jfif");
						ImageView img = new ImageView(new Image(files));
						img.setPreserveRatio(true);
						img.setFitWidth(165);
						Button btn = new Button();
						btn.setOnAction(e -> {
							try {
								c.Chargerrecette(img);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						});
						btn.setGraphic(img);
						//setgraphic pour le bouton image
						lbl.getStyleClass().add("lbl");
						imgbox.getChildren().addAll(btn,lbl);
						
						
					} catch (FileNotFoundException e) {
						System.out.println("pas d'images pour"+ nomrecette);
					}
					
					lig.getChildren().add(imgbox);
					
					
				}
			}
			
			this.c.id1.getChildren().add(lig);
			
			
		}
	}
	

}
