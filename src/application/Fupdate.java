package application;

import dao.FournisseurDAO;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import oo.Fournisseur;

public class Fupdate extends Application {

	double xOffset ,yOffset;
	int i = 1;
	 public static Scene scene  ;

		@Override
		public void start(Stage primaryStage) {
			try {
				
				//primaryStage.initStyle(StageStyle.UNDECORATED);
				
				
				VBox root = new VBox();
				
				
				int width=580,height=400;
				int toolBarHeight = 20;
				scene = new Scene(root,width,height);
				String css =this.getClass().getResource("style.css").toExternalForm();
				scene.getStylesheets().add(css);

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
				
				HBox frameButtons = new HBox(10);
		        frameButtons.setAlignment(Pos.CENTER_RIGHT);
		        frameButtons.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
		        
		        Hyperlink exitButton = new Hyperlink("x");
		        exitButton.setPadding(new Insets(0,18,0,0));
				exitButton.setStyle("-fx-text-fill: #b8b3ad;-fx-border-color: transparent;-fx-underline: false;-fx-font-size: 18px;-fx-font-weight: bold;");
				
				frameButtons.getChildren().add(exitButton);
		        
				exitButton.setOnAction(new EventHandler<ActionEvent>() {
		            public void handle(ActionEvent event) {
		            	Platform.exit();
		            	
		            }
		        });
				
				
				HBox framePlus = new HBox(10);
				framePlus.setAlignment(Pos.TOP_RIGHT);
				framePlus.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
				 Hyperlink plusButton = new Hyperlink("confirm");
			        plusButton.setPadding(new Insets(-20,18,0,0));
					plusButton.setStyle("-fx-text-fill: #b8b3ad;-fx-border-color: transparent;-fx-underline: false;-fx-font-size: 20px;-fx-font-weight: bold;");
					
					
				
				
				
				
				framePlus.getChildren().addAll(plusButton);
				
				VBox AjouterBox0 = new VBox(20);
				AjouterBox0.setPrefSize(width , height);
				AjouterBox0.setPadding(new Insets(20, 40, 50, 50));
				AjouterBox0.setBackground(new Background(new BackgroundFill(Color.valueOf("#262626"), null, null)));
				
				Label msgAjouter = new Label("modifier ");
				
				msgAjouter.setFont(Font.font("",FontWeight.LIGHT,30));
				msgAjouter.setTextFill(Color.valueOf("#e6e0d8"));
				msgAjouter.setPadding(new Insets(8,0,0,0));
				
				
				VBox AjouterBox = new VBox(20);
				AjouterBox.setPrefSize(width , height);
				AjouterBox.setPadding(new Insets(20, 20,15, 20));
				AjouterBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#262626"), null, null)));
				
				
				ScrollPane scpane = new ScrollPane();
				//scpane.setMaxWidth(width);
				scpane.setPrefHeight(height);
				scpane.setFitToWidth(true);
				scpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
				scpane.setStyle("-fx-background-color:transparent;");
				
				
				
				Label FournisseurId = new Label("ID  fournisseur  : ");
				FournisseurId.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
				FournisseurId.setPadding(new Insets(6,80,6,10));
				Label nomFour = new Label("Nom fournisseur   :");
				nomFour.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
				nomFour.setPadding(new Insets(6,80,6,10));
				Label adresseF = new Label("Adresse : ");
				adresseF.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
				adresseF.setPadding(new Insets(6,80,6,10));
				Label numtel = new Label("Mum Tel:");
				numtel.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
				numtel.setPadding(new Insets(6,80,6,10));
				
				
				TextField id = new TextField();
				id.setPromptText("id fournisseur ");
				id.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
				id.setPadding(new Insets(6,0,6,10));
				
				
				
				
				TextField nom = new TextField();
				nom.setPromptText("mon fournisseur ");
				nom.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
				nom.setPadding(new Insets(6,0,6,10));
				
				
				
				
				
				TextField desc = new TextField();
				desc.setPromptText("dadresse fournisseur ");
				desc.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
				desc.setPadding(new Insets(6,0,6,10));
				
				
				
				TextField marqueMed = new TextField();
				marqueMed.setPromptText("num tel ");
				marqueMed.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
				marqueMed.setPadding(new Insets(6,0,6,10));
				
				
				
				
				
			
			
			HBox MedQteSupp = new HBox();
			MedQteSupp.getChildren().addAll(FournisseurId,id);
			HBox MedQteSupp1 = new HBox();
			MedQteSupp1.getChildren().addAll(nomFour,nom);
			HBox MedQteSupp3 = new HBox(20);
			MedQteSupp3.getChildren().addAll(adresseF,desc);
			HBox MedQteSupp4 = new HBox(20);
			MedQteSupp4.getChildren().addAll(numtel,marqueMed);
			AjouterBox.getChildren().addAll(MedQteSupp,MedQteSupp1,MedQteSupp3,MedQteSupp4);
			
			plusButton.setOnAction(new EventHandler<ActionEvent>() {
				  
				  @Override public void handle(ActionEvent arg0) {
				  System.out.print("into insert fourrnisseur  "); 
				 Fournisseur m = new Fournisseur(
				  id.getText(), nom.getText(), desc.getText(), marqueMed.getText()
				 );
				 FournisseurDAO.update(m);
				  
				  }
				  
			});
			
			
			
			
			scpane.setContent(AjouterBox);
			AjouterBox0.getChildren().addAll(msgAjouter,scpane);
			
			
			
			root.getChildren().addAll(AjouterBox0,framePlus);
			
			
			
			
			primaryStage.setScene(scene);
			
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//StockAdd3 exp = new StockAdd3();
		launch(args);
	}
	

	
	@Override
    public void stop() throws Exception {
        //System.out.println("stopped.");
        super.stop();
    }
}





