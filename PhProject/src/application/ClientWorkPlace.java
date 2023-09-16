package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import events.AdminActions;
import events.ButtonEvents;
import events.ClientAction;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.StockModel;


public class ClientWorkPlace {

	
	static Scene scene ;
	static  int width=1500,height=900,toolBarHeight = 20;
		double xOffset ,yOffset;
		int n=0;
		 public static BorderPane  root ;
		  public static Button accueil ,  commande;
		  public static  BorderPane Contenu;
		   public static VBox searchBox;
		  
		  
		

		 public static Scene getScene() {
		
				try {
					
					int width=1500,height=900;
					int toolBarHeight = 20;
					 root = new BorderPane();
				 scene = new Scene(root,width,height);
					
				 scene.getStylesheets().add(Main.css);
					VBox intro = new VBox(25);
					intro.setPrefSize(width *.2, height);
					//intro.setBackground(new Background(new BackgroundFill(Color.valueOf("#b98b56"), null, null)));
					intro.setAlignment(Pos.TOP_LEFT);
					intro.setPadding(new Insets(250,0,0,0));
					Image introBackground;
					try {
						introBackground = new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/introBackground.jpg"));
						intro.setBackground(new Background(new BackgroundImage(introBackground, null, null, null, null)));

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			       
			        accueil = new Button("Accueil");
			        //accueil.setPadding(new Insets(0,70,0,0));
					accueil.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");

			        accueil.setPrefSize(width*.2, 80);
					ImageView home = new ImageView(new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/home.png")));
					home.setFitHeight(50); home.setFitWidth(60);
					accueil.setGraphic(home);
					accueil.setContentDisplay(ContentDisplay.TOP);
					accueil.setOnAction(new ClientAction());
					
					
			      commande   = new Button("Commande");
					//commande.setPadding(new Insets(0,82,0,0));
			        commande.setPrefSize(width*.2, 80);
					commande.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
					ImageView commandeIcon = new ImageView(new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/home.png")));
					commandeIcon.setFitHeight(60); commandeIcon.setFitWidth(60);
					commande.setGraphic(commandeIcon);
					commande.setContentDisplay(ContentDisplay.TOP);
					commande.setOnAction(new ClientAction());
					

						     
					intro.getChildren().addAll(accueil,commande);
			        /***********************/
			        
			        
			        HBox frameButtons = new HBox(10);
			        frameButtons.setAlignment(Pos.CENTER_RIGHT);
			        frameButtons.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
			        
			        Hyperlink exitButton = new Hyperlink("x");
			        exitButton.setPadding(new Insets(0,20,0,0));
					exitButton.setStyle("-fx-text-fill: #b8b3ad;-fx-border-color: transparent;-fx-underline: false;-fx-font-size: 18px;-fx-font-weight: bold;");
					
					frameButtons.getChildren().add(exitButton);
			        
					exitButton.setOnAction(new EventHandler<ActionEvent>() {
			            public void handle(ActionEvent event) {
			            	Platform.exit();
			            }
			        });
			        
					 searchBox = new VBox(10);
					 searchBox.setPadding(new Insets(20, 20, 50, 0));
					 searchBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
					

					Contenu = new BorderPane();
					Contenu.setPadding(new Insets(100, 0, 50, 100));
					Contenu.setPrefSize(width *.8, height);
					Contenu.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
					
						
							
					
					
					
					
					
			        
					VBox rightFrame = new VBox();
					rightFrame.setPrefSize(width *.8, height);
					rightFrame.getChildren().addAll(searchBox,Contenu);
					
					root.setRight(rightFrame);
					root.setLeft(intro);
					
					
		        	
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				return scene ;
			}
		 
}

		


