package application;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.CommandeClientDAO;
import dao.MedicamentDAO;
import dao.PharmacieDAO;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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
import javafx.util.StringConverter;
import oo.Client;
import oo.CommandeClient;
import oo.Pharmacie;

public class NewCommandeClient extends Application {
	double xOffset ,yOffset;
	int i = 1;
	 public static Scene scene ;
	  public static ComboBox<String> combo_boxph,combo_boxmed ;
	  public String medInput , phnameInput ;
	 
	   public static StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
          DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern("dd-MM-yyyy");
         
          @Override
          public String toString(LocalDate date) {
              if (date != null) {
                  return dateFormatter.format(date);
              } else {
                  return "";
              }
          }
          @Override
          public LocalDate fromString(String string) {
              if (string != null && !string.isEmpty()) {
                  return LocalDate.parse(string, dateFormatter);
              } else {
                  return null;
              }
          }
      };   
	  EventHandler<ActionEvent> event =
				 
              new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
        	phnameInput=combo_boxph.getValue();
          
        }
    };
    EventHandler<ActionEvent> event1 =
			 
            new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
         medInput=combo_boxmed.getValue();
      }
  };
		
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
				
				Label msgAjouter = new Label("commander medicament   ");
				
				msgAjouter.setFont(Font.font("",FontWeight.LIGHT,14));
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
				
				
				
				Label comId = new Label(" ID commande: ");
				comId.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
				comId.setPadding(new Insets(6,80,6,10));
				
				Label quantite  = new Label("quantite medicament   :");
				quantite.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
				quantite.setPadding(new Insets(6,80,6,10));
				
				Label med = new Label("ID medicament : ");
				med.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
				med.setPadding(new Insets(6,80,6,10));
				
				Label date = new Label("date creation  :");
				date.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
				date.setPadding(new Insets(6,80,6,10));
				
				Label ph  = new Label("num pharmacie  :");
				ph.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
				ph.setPadding(new Insets(6,80,6,10));
				
				
				
				TextField id = new TextField();
				id.setPromptText("id commande ");
				id.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
				id.setPadding(new Insets(6,0,6,10));
				
				TextField quantitefield = new TextField();
				quantitefield.setPromptText("prix med ");
				quantitefield.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
				quantitefield.setPadding(new Insets(6,0,6,10));
				
				
				try {
					
					combo_boxph= new ComboBox(
							FXCollections.observableArrayList(PharmacieDAO.pharmaciList()));
					combo_boxph.setOnAction(event);
					combo_boxmed= new ComboBox(
							FXCollections.observableArrayList(MedicamentDAO.MedicamentLsit()));
					combo_boxmed.setOnAction(event1);
					
							
			        
			        
				} catch (Exception e) {
					// TODO: handle exception
				}
				 
					
					
					
					TextField datelfield = new TextField();
					
					datelfield.setPromptText("25-01-2010");
					datelfield.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
					datelfield.setPadding(new Insets(6,0,6,10));
				
				
				
				
			
				
				
				

			HBox MedQteSupp = new HBox();
			
			HBox MedQteSupp1 = new HBox();
			
			HBox MedQteSupp3 = new HBox(20);
			HBox MedQteSupp4 = new HBox(20);
			HBox MedQteSupp5 = new HBox(20);
			HBox MedQteSupp6 = new HBox(20);
			HBox MedQteSupp7 = new HBox(20);
			MedQteSupp1.getChildren().addAll(quantite,quantitefield);
			MedQteSupp.getChildren().addAll(comId,id);
			MedQteSupp3.getChildren().addAll(med,combo_boxmed);
			MedQteSupp4.getChildren().addAll(ph,combo_boxph);
			MedQteSupp5.getChildren().addAll(date,datelfield);
			
			AjouterBox.getChildren().addAll(MedQteSupp,MedQteSupp1,MedQteSupp3,MedQteSupp4,MedQteSupp5);
			
			plusButton.setOnAction(new EventHandler<ActionEvent>() {
				  
				  @Override public void handle(ActionEvent arg0) {
				  
				  try {
					 String type = "type ";
					Pharmacie p= PharmacieDAO.getPharmacieFromNom(phnameInput);
					CommandeClient  c= new CommandeClient(
							id.getText(),
							quantitefield.getText(),
							datelfield.getText(),
							Client.getSelecteClient().getMpass(),
							p.getNumNational(),
							medInput,
							type
	                		  );
					CommandeClientDAO.insertCommandeClient(c);
					System.out.print("commande inserte ");
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                  				   
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
	    }}
	




	

