package application;
	
import java.io.FileInputStream;

import dao.MedicamentDAO;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import oo.Medicament;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class StockDelete3 extends Application {
	
double xOffset ,yOffset;
int i = 1;


	
	@Override
	public void start(Stage primaryStage) {
		try {
			//primaryStage.initStyle(StageStyle.UNDECORATED);
			

			VBox root = new VBox();
			
			int width=580,height=400;
			int toolBarHeight = 20;
			Scene scene = new Scene(root,width,height);
			
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
			
			
			//framePlus.getChildren().addAll(testButton,plusButton);
			framePlus.getChildren().addAll(plusButton);
			
			VBox SupprimerBox0 = new VBox(20);
			SupprimerBox0.setPrefSize(width , height);
			SupprimerBox0.setPadding(new Insets(20, 40, 50, 50));
			SupprimerBox0.setBackground(new Background(new BackgroundFill(Color.valueOf("#262626"), null, null)));
			
			Label msgSupprimer = new Label("Supprimer");
			msgSupprimer.setFont(Font.font("",FontWeight.LIGHT,56));
			msgSupprimer.setTextFill(Color.valueOf("#e6e0d8"));
			msgSupprimer.setPadding(new Insets(15,0,0,0));
			
			
			VBox SupprimerBox = new VBox(20);
			SupprimerBox.setPrefSize(width , height);
			SupprimerBox.setPadding(new Insets(20, 20, 30, 20));
			SupprimerBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#262626"), null, null)));
			
			ScrollPane scpane = new ScrollPane();
			//scpane.setMaxWidth(width);
			scpane.setPrefHeight(height);
			scpane.setFitToWidth(true);
			scpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
			scpane.setStyle("-fx-background-color:transparent;");
			
			
			
			Label medId = new Label("ID Medicament : ");
			medId.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
			medId.setPadding(new Insets(6,80,6,10));
			
			
			TextField qteSupprimer = new TextField();
			qteSupprimer.setPromptText("id");
			qteSupprimer.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
			qteSupprimer.setPadding(new Insets(6,0,6,10));
			
			HBox MedQteSupp = new HBox(20);
			MedQteSupp.getChildren().addAll(medId,qteSupprimer);
			
			SupprimerBox.getChildren().addAll(MedQteSupp);
			scpane.setContent(SupprimerBox);
			SupprimerBox0.getChildren().addAll(msgSupprimer,scpane);
			
			plusButton.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent event) {
	            	HBox newHB = MedQteSupp;
	            	
	            }	
	        });
			
			
			root.getChildren().addAll(SupprimerBox0,framePlus);
			
			plusButton.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent event) {
	            	System.out.print("delete med ");
	            	MedicamentDAO.delete(qteSupprimer.getText());
	            	
	            	
	            	
	            }	
	        });
			/*
			testButton.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent event) {
	            	
	            	HBox nodeHBox = (HBox) SupprimerBox.getChildren().get(2);
	            	TextField test = (TextField) nodeHBox.getChildren().get(0);
	            	System.out.println(test.getText());
	            }	
	        });
			
			*/
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
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
