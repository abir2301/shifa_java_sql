package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.*;
import java.io.FileInputStream;



public class PageAdmin extends Application {
	
double xOffset ,yOffset;
public Scene scene ;
public Pane root;

public Scene getHomeScene() {
	return scene;
}

public Pane getHomeRoot() {
	return root;
}

	public PageAdmin() {
		try {

			BorderPane root = new BorderPane();
			
			int width=1500,height=900;
			int toolBarHeight = 20;
			Scene scene = new Scene(root,width,height);
			VBox intro = new VBox(25);
			intro.setPrefSize(width *.2, height);
			//intro.setBackground(new Background(new BackgroundFill(Color.valueOf("#b98b56"), null, null)));
			intro.setAlignment(Pos.CENTER_LEFT);
			
			Image introBackground = new Image(new FileInputStream("C:\\Users\\feres\\Desktop\\ProjetJavaPharmacie\\imagesJava\\introBackground.jpg"));
	       // ImageView logoView = new ImageView(logo);
	        //logoView.setFitHeight(100); logoView.setFitWidth(100);
			intro.setBackground(new Background(new BackgroundImage(introBackground, null, null, null, null)));
			
			
			/*
			Image logo = new Image(new FileInputStream("C:\\Users\\feres\\Desktop\\Logo.png"));
	        ImageView logoView = new ImageView(logo);
	        logoView.setFitHeight(100); logoView.setFitWidth(100);
	        Label welcome = new Label("Admin");
	        welcome.setFont(Font.font("",FontWeight.MEDIUM,18));
	        */
			
	        Button accueil = new Button("Accueil");
	        //accueil.setPadding(new Insets(0,70,0,0));
	        accueil.setPrefSize(width*.2, 80);
			accueil.setStyle("-fx-background-color: rgba(0, 100, 100, 0.3);-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light ");
			ImageView home = new ImageView(new Image(new FileInputStream("C:\\Users\\feres\\Desktop\\ProjetJavaPharmacie\\imagesJava\\home.png")));
			home.setFitHeight(50); home.setFitWidth(60);
			accueil.setGraphic(home);
			accueil.setContentDisplay(ContentDisplay.TOP);
	        
			
			
	        Button stock = new Button("Stock");
			//stock.setPadding(new Insets(0,82,0,0));
	        stock.setPrefSize(width*.2, 80);
			stock.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
			ImageView stockIcon = new ImageView(new Image(new FileInputStream("C:\\Users\\feres\\Desktop\\ProjetJavaPharmacie\\imagesJava\\stock.png")));
			stockIcon.setFitHeight(60); stockIcon.setFitWidth(60);
			stock.setGraphic(stockIcon);
			stock.setContentDisplay(ContentDisplay.TOP);
		
			Button fournisseur = new Button("Fournisseur");
			//fournisseur.setPadding(new Insets(0,27,0,0));
			fournisseur.setPrefSize(width*.2, 80);
			fournisseur.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light ");
			ImageView fournisseurIcon = new ImageView(new Image(new FileInputStream("C:\\Users\\feres\\Desktop\\ProjetJavaPharmacie\\imagesJava\\fournisseur.png")));
			fournisseurIcon.setFitHeight(37); fournisseurIcon.setFitWidth(50);
			fournisseur.setGraphic(fournisseurIcon);
			fournisseur.setContentDisplay(ContentDisplay.TOP);
			
			Button livraison = new Button("Livraison");
			//livraison.setPadding(new Insets(0,50,0,0));
			livraison.setPrefSize(width*.2, 80);
			livraison.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light ");
			ImageView livraisonIcon = new ImageView(new Image(new FileInputStream("C:\\Users\\feres\\Desktop\\ProjetJavaPharmacie\\imagesJava\\livraison.png")));
			livraisonIcon.setFitHeight(52); livraisonIcon.setFitWidth(62);
			livraison.setGraphic(livraisonIcon);
			livraison.setContentDisplay(ContentDisplay.TOP);
			
			intro.getChildren().addAll(accueil,stock,fournisseur,livraison);
	        /***********************/
	        
	        
	        HBox frameButtons = new HBox(10);
	        frameButtons.setAlignment(Pos.CENTER_RIGHT);
	        frameButtons.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
	        
	        Hyperlink exitButton = new Hyperlink("x");
	        exitButton.setPadding(new Insets(0,20,0,0));
			exitButton.setStyle("-fx-text-fill: #b8b3ad;-fx-border-color: transparent;-fx-underline: false;-fx-font-size: 18px;-fx-font-weight: bold;");
			
			frameButtons.getChildren().add(exitButton);
	        
			exitButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent event) {
	            	Platform.exit();
	            }
	        });
	        
			/*
			VBox Contenu = new VBox();
			Contenu.setPadding(new Insets(100, 0, 50, 50));
			Contenu.setPrefSize(width *.8, height);
			Contenu.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
			Contenu.setAlignment(Pos.TOP_CENTER);
			
			TextField search = new TextField();
			search.setPromptText("Recherche");
			search.setMaxWidth(width*.8-200);
			search.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
			Contenu.getChildren().addAll(search);
			*/
			
			BorderPane Contenu = new BorderPane();
			Contenu.setPadding(new Insets(100, 0, 50, 100));
			Contenu.setPrefSize(width *.8, height);
			Contenu.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
			
			TextField search = new TextField();
			search.setPromptText("Recherche");
			search.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
			search.setMaxWidth(width*.8-200);
			Contenu.setTop(search);
			
			VBox rightFrame = new VBox();
			rightFrame.setPrefSize(width *.8, height);
			rightFrame.getChildren().addAll(frameButtons,Contenu);
			
			
			root.setLeft(intro);
			root.setRight(rightFrame);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.initStyle(StageStyle.UNDECORATED);
		PageAdmin pa = new PageAdmin();
		/*
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = primaryStage.getX() - event.getScreenX();
                yOffset = primaryStage.getY() - event.getScreenY();
            }
        });
		
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() + xOffset);
                primaryStage.setY(event.getScreenY() + yOffset);
            }
        });
		*/
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
    public void stop() throws Exception {
        //System.out.println("stopped.");
        super.stop();
    }
}
