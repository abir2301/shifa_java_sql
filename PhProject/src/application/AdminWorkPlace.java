package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import events.AdminActions;
import events.ButtonEvents;
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

public class AdminWorkPlace {
	class WindowButtons extends HBox {

	    public WindowButtons() {
	        Button closeBtn = new Button("X");

	        closeBtn.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent actionEvent) {
	                Platform.exit();
	            }
	        });

	        this.getChildren().add(closeBtn);
	    }
	}
	static Scene scene ;
	static  int width=1500,height=900,toolBarHeight = 20;
	 public static Button   accueil ,  stock ,fournisseur, livraison ,addButton , editButton  ,deleteButton ,bestSeller, finStock , perime ;
	   public static VBox searchBox  ,contentVBox ;
	  public static  BorderPane Contenu ;
	 public static  StackPane leftFrame ;
	  public static BorderPane  root ;
	

	
	public static Scene getScene() {
		 
		 root = new BorderPane();
		
		scene = new Scene(root,width,height);
		scene.getStylesheets().add(Main.css);

		VBox intro = new VBox(25);
		intro.setPrefSize(width *.2, height);
		//intro.setBackground(new Background(new BackgroundFill(Color.valueOf("#b98b56"), null, null)));
		intro.setAlignment(Pos.CENTER_LEFT);
		
		
		
		Image introBackground;
		try {
			introBackground = new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/introBackground.jpg"));
			intro.setBackground(new Background(new BackgroundImage(introBackground, null, null, null, null)));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
		/**************Acceuil *******************/
         accueil = new Button("Accueil");
        accueil.setOnAction(new AdminActions());
        //accueil.setPadding(new Insets(0,70,0,0));
        accueil.setPrefSize(width*.2, 80);
		accueil.setStyle("-fx-background-color: rgba(0, 100, 100, 0.3);-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light ");
		try {
			ImageView home = new ImageView(
					new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/home.png")));
			home.setFitHeight(50);
			home.setFitWidth(60);
			accueil.setGraphic(home);
			accueil.setContentDisplay(ContentDisplay.TOP);
		} catch (Exception e) {
			// TODO: handle exception
		}
        
		/**************stock ****************/
		
        stock = new Button("Stock");
        stock.setOnAction(new AdminActions());
		//stock.setPadding(new Insets(0,82,0,0));
        stock.setPrefSize(width*.2, 80);
		stock.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
		try {
			ImageView stockIcon = new ImageView(new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/stock.png")));
		stockIcon.setFitHeight(60); stockIcon.setFitWidth(60);
		stock.setGraphic(stockIcon);
		stock.setContentDisplay(ContentDisplay.TOP);
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/******************Fournisseur *********************/
		 fournisseur = new Button("Fournisseur");
		 fournisseur.setOnAction(new AdminActions());
		//fournisseur.setPadding(new Insets(0,27,0,0));
		fournisseur.setPrefSize(width*.2, 80);
		fournisseur.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light ");
		try {
			ImageView fournisseurIcon = new ImageView(new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/fournisseur.png")));
		fournisseurIcon.setFitHeight(37); fournisseurIcon.setFitWidth(50);
		fournisseur.setGraphic(fournisseurIcon);
		fournisseur.setContentDisplay(ContentDisplay.TOP);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/*****************Livraison *********************/
		 livraison = new Button("Livraison");
		//livraison.setPadding(new Insets(0,50,0,0));
		livraison.setPrefSize(width*.2, 80);
		livraison.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light ");
		try {
			ImageView livraisonIcon = new ImageView(
					new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/livraison.png")));
			livraisonIcon.setFitHeight(52);
			livraisonIcon.setFitWidth(62);
			livraison.setGraphic(livraisonIcon);
			livraison.setContentDisplay(ContentDisplay.TOP);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
        
		
     //add toggle groupe 
		intro.getChildren().addAll(accueil,stock,fournisseur,livraison);
		
		
		
		
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
		
		
		
		
		
		
       
       
		
		
		StackPane leftFrame = new StackPane();
		leftFrame.setPrefSize(width *.2, height);
		
		 Contenu = new BorderPane();
		Contenu.setPadding(new Insets(0, 50, 50,0));
		Contenu.setPrefSize(width *.0, height);
		Contenu.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
		//Contenu.getChildren().add(StockModel.getStickers());
	//	AdminWorkPlace.Contenu.setRight(StockModel.getStickers());

		
		 searchBox = new VBox(10);
		 searchBox.setPadding(new Insets(20, 20, 50, 0));
		 searchBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
		
		
		
		
		VBox rightFrame = new VBox();
		rightFrame.setPrefSize(width *.8, height);
		
		//Contenu.setCenter(contentVBox);
		rightFrame.getChildren().addAll(searchBox,Contenu);
		
	//	intro.getChildren().add(menuBox);
		leftFrame.getChildren().addAll(intro);
		
		

		
		root.setLeft(leftFrame);
		root.setRight(rightFrame);
		
		return scene ;
		
	}
	public static  void updateAdd(Observable o, Object arg) {
	    Platform.runLater(new Runnable() {
	       public void run() {             
	           new StockAdd3().start(new Stage());
	       }
	    });
	}
	
	public  static void updateMod(Observable o, Object arg) {
	    Platform.runLater(new Runnable() {
	       public void run() {             
	           new StockEdit().start(new Stage());
	       }
	    });
	}
	
	public  static void updateDel(Observable o, Object arg) {
	    Platform.runLater(new Runnable() {
	       public void run() {             
	           new StockDelete3().start(new Stage());
	       }
	    });
	}
	
	

}
