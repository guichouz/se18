package application;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;



import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vue implements Observer{

	public static Controlleur c;
	public static AnchorPane root;
	public  Main  main;


	public Vue(Controlleur c, Main main) {

		this.c = c;
		this.main= main;
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

	public void afficherResultrecette(ArrayList<Recette> lrec) {
		
		this.c.id1.getChildren().clear();
		this.c.recefav.getChildren().clear();
		this.c.textacc1.setText("Les résultats de votre recherche sont:");
		this.c.textacc2.setText(null);
		for(int i=0; i<lrec.size()/3+lrec.size()%3;i++) {
			HBox lig = new HBox();
			lig.setAlignment(Pos.CENTER);
			lig.setSpacing(10);

			for(int j=0;j<3;j++) {
				if((i+2)*i+j<lrec.size()) {
					System.out.println();
					String nomrecette =lrec.get((i+2)*i+j).intutile;
					Recette r = lrec.get((i+2)*i+j);
					VBox imgbox = new VBox();
					imgbox.setAlignment(Pos.CENTER);
					Label lbl = new Label(nomrecette);
					try {
						FileInputStream files = new FileInputStream("src/image/"+nomrecette+".jfif");
						ImageView img = new ImageView(new Image(files));
						img.setPreserveRatio(true);
						img.setFitWidth(150);
						//img.setFitHeight(150);
						Button btn = new Button();
						btn.setBackground(null);
						btn.setOnAction(e -> {
							main.afficherrecette(r);
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
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(arg.getClass());
		if(arg instanceof Recette[]) {
			Recette[] tabr = (Recette[]) arg;
			
			
			List<Recette> listRecette =  Arrays.asList(tabr);
			//VBox boxrecette = (VBox) root.lookup("#receAcceuil");

			for(int i=0; i<listRecette.size()/3+listRecette.size()%3;i++) {
				HBox lig = new HBox();
				lig.setAlignment(Pos.CENTER);
				lig.setSpacing(10);

				for(int j=0;j<3;j++) {
					if((i+2)*i+j<listRecette.size()) {
						System.out.println();
						String nomrecette =listRecette.get((i+2)*i+j).intutile;
						Recette r = listRecette.get((i+2)*i+j);
						VBox imgbox = new VBox();
						imgbox.setAlignment(Pos.CENTER);
						Label lbl = new Label(nomrecette);
						try {
							FileInputStream files = new FileInputStream("src/image/"+nomrecette+".jfif");
							ImageView img = new ImageView(new Image(files));
							img.setPreserveRatio(true);
							img.setFitWidth(150);
							//img.setFitHeight(150);
							Button btn = new Button();
							btn.setBackground(null);
							btn.setOnAction(e -> {
								main.afficherrecette(r);
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
		else if(arg instanceof ArrayList) {
			ArrayList<Recette> list = (ArrayList<Recette>) arg;
			System.out.println("instance of array"+arg);
			this.afficherResultrecette(list);
			
			
		}
		else if(arg instanceof Collection) {
			Collection<Recette> recettecol =  (Collection<Recette>) arg;
			ArrayList<Recette> listRecette = new ArrayList<>(recettecol);
			//VBox boxrecette = (VBox) root.lookup("#receAcceuil");

			for(int i=0; i<listRecette.size()/3+listRecette.size()%3;i++) {
				HBox lig = new HBox();
				lig.setAlignment(Pos.CENTER);
				lig.setSpacing(10);

				for(int j=0;j<3;j++) {
					if((i+2)*i+j<listRecette.size()) {
						String nomrecette =listRecette.get((i+2)*i+j).intutile;
						Recette r = listRecette.get((i+2)*i+j);
						VBox imgbox = new VBox();
						imgbox.setAlignment(Pos.CENTER);
						Label lbl = new Label(nomrecette);
						try {
							FileInputStream files = new FileInputStream("src/image/"+nomrecette+".jfif");
							ImageView img = new ImageView(new Image(files));
							img.setPreserveRatio(true);
							img.setFitWidth(150);
							//img.setFitHeight(150);
							Button btn = new Button();
							btn.setBackground(null);
							btn.setOnAction(e -> {
								main.afficherrecette(r);
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

				this.c.recefav.getChildren().add(lig);


			}

		}
		else if(arg instanceof Recette) {
			Recette r = (Recette) arg;
			this.afficherResultrecette2(r);
		}
		else if(arg instanceof String) {
			String str = (String) arg;
			this.afficherNotFound(str);
			
		}
		

	}
	private void afficherNotFound(String str) {

		this.c.id1.getChildren().clear();
		this.c.recefav.getChildren().clear();
		this.c.textacc1.setText("Désolé aucune recette correspond a votre recherche: "+str);
		this.c.textacc2.setText(null);


		
	}
	private void afficherResultrecette2(Recette r) {

		this.c.id1.getChildren().clear();
		this.c.recefav.getChildren().clear();
		this.c.textacc1.setText("Une recette correspond a votre recherche:");
		this.c.textacc2.setText(null);
		
		VBox imgbox = new VBox();
		imgbox.setAlignment(Pos.CENTER);
		Label lbl = new Label(r.intutile);
		try {
			FileInputStream files = new FileInputStream("src/image/"+r.intutile+".jfif");
			ImageView img = new ImageView(new Image(files));
			img.setPreserveRatio(true);
			img.setFitWidth(150);
			//img.setFitHeight(150);
			Button btn = new Button();
			btn.setBackground(null);
			btn.setOnAction(e -> {
				main.afficherrecette(r);
			});
			btn.setGraphic(img);
			//setgraphic pour le bouton image
			lbl.getStyleClass().add("lbl");
			imgbox.getChildren().addAll(btn,lbl);


		} catch (FileNotFoundException e) {
			System.out.println("pas d'images pour"+ r.intutile);
		}
		this.c.id1.getChildren().add(imgbox);
	}


}
