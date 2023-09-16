package models;


import java.io.FileInputStream;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import application.AdminWorkPlace;
import dao.CommandeClientDAO;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import oo.CommandeClient;
import oo.Pharmacie;

public class AcceulModel {
	//public static AcceulModel model = this ;
	 public static  int width=1500,height=900;
	 public static  ObservableList<CommandeClient> rs  ;
	 public static String researchValue = null ; 
	  public static  TextField search ;
	  public static Button filtre1 ,filtre2, filtre3;
	
	public static TextField getSerchBox() {
		
		
		
		
		
		search = new TextField();
	    search.setPadding(new Insets(10, 20, 10, 10));
		//search.setPadding(new Insets(10, 50, 10, 10));
		search.setPromptText("Recherche  commande client   ");
		search.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
		search.setMaxWidth(990);
		// search.setPadding(new Insets(20, 150, 10, 10));
		return search ;

		
	}
	

	public static HBox  getfilterGroupe() {
		
        HBox filtreButtons = new HBox(90);
        filtreButtons.setPadding(new Insets(10, 180, 10, 150));
        filtreButtons.setSpacing(50);
        filtreButtons.setMargin(filtreButtons, null);
        
       // filtreButtons.setSpacing(width);
       
		filtre1 = new Button("date commande  ");
		filtre1.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	
					 researchValue = search.getText();
					 System.out.print(researchValue+"\n");
		            System.out.println("get commande by date ");

					AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
					AdminWorkPlace.Contenu.setCenter(AcceulModel.getContenueByDate());}}

				
		    
		);
	
		//filtre1.setPrefSize(100,30);
		filtre1.setPadding(new Insets(0, 10, 0, 10) );
		filtre1.setPrefSize(300,30);
		filtre1.setStyle("-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");
		
		 filtre2 = new Button("Num Medicament ");
		 filtre2.setPrefSize(300,30);
		 filtre2.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent event) {
			    	
						 researchValue = search.getText();
						 System.out.print(researchValue+"\n");
			            System.out.println("get commande by med ");

						AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
						AdminWorkPlace.Contenu.setCenter(AcceulModel.getContenueByMed());}}

					
			    
			);
		
		//filtre2.setPrefSize(500,30);
		filtre2.setPadding(new Insets(0, 10, 0, 10) );
		
		filtre2.setStyle("-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");
		
		 filtre3 = new Button("non clien ");
		 filtre3.setPrefSize(180,30);
		 filtre3.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent event) {
			    	
						 researchValue = search.getText();
						 System.out.print(researchValue+"\n");
			            System.out.println("get commande by client ");

						AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
						AdminWorkPlace.Contenu.setCenter(AcceulModel.getContenueByClient());}}

					
			    
			);
		//filtre3.setPrefSize(100,30);
		filtre3.setPadding(new Insets(0, 10, 0, 10) );
		filtre3.setStyle("-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");
		
		
		
		filtreButtons.getChildren().addAll(filtre1,filtre2,filtre3);
		
		 
		
		return filtreButtons ;
	}
	
	
	
	public static TableView getContenue() {
		
		
		 
		TableView tableView = new TableView();
		
		TableViewSelectionModel<CommandeClient> selectionModel = 
			    tableView.getSelectionModel();
		selectionModel.setSelectionMode(
			    SelectionMode.SINGLE);
		
		ObservableList<CommandeClient> selectedItems = 
			    selectionModel.getSelectedItems();
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		


		
	tableView.setStyle("-fx-background-color: transparent;");
	    
		TableColumn<CommandeClient, String> idCol = 
		    new TableColumn<>("numero commande ");
		idCol.setMinWidth(50);
		TableColumn<CommandeClient, String> quantiteCol        = 
		    new TableColumn<>("quantite");
		quantiteCol.setMinWidth(50);
		TableColumn<CommandeClient, String> dataCommandeCol       = 
			    new TableColumn<>("Data Commande");
			quantiteCol.setMinWidth(100);
		TableColumn<CommandeClient, String> mpassCol   = 
		    new TableColumn<>("client");
		mpassCol.setMinWidth(50);
		TableColumn<CommandeClient, String> numphCol   = 
		    new TableColumn<>("Pharmacie ");
		numphCol.setMinWidth(50);
		TableColumn<CommandeClient, String> nummedCol    = 
			    new TableColumn<>("medicament ");
		nummedCol.setMinWidth(50);
		TableColumn<CommandeClient, String> typeCol    = 
			    new TableColumn<>("type commande  ");
		typeCol.setMinWidth(50);

		tableView.setPadding(new Insets(20, 150, 10, 50));
		idCol.setCellValueFactory(data -> data.getValue().idProperty());
		quantiteCol.setCellValueFactory(data -> data.getValue().quantiteProperty());
		dataCommandeCol.setCellValueFactory(data -> data.getValue().dateCommandeProperty());

		mpassCol.setCellValueFactory(data->data.getValue().mpassProperty());
		numphCol.setCellValueFactory(data->data.getValue().numphProperty());
		nummedCol.setCellValueFactory(data -> data.getValue().nummedProperty());
		typeCol.setCellValueFactory(data -> data.getValue().typeProperty());
		
		tableView.getColumns().addAll(idCol,quantiteCol,dataCommandeCol,mpassCol,nummedCol);
		 rs =null;
		try {
			rs = CommandeClientDAO.getCommandeClient(Pharmacie.getSelectedPharmacie().getNumNational());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableView.setPlaceholder( new Label("n y a pas de commande "));
		tableView.setItems(rs);

		
		return tableView ;
		
	}
	

	public static TableView getContenueByDate() {
		
		
		 
		TableView tableView = new TableView();
	tableView.setStyle("-fx-background-color: transparent;");
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	    
		TableColumn<CommandeClient, String> idCol = 
		    new TableColumn<>("numero commande ");
		idCol.setMinWidth(50);
		TableColumn<CommandeClient, String> quantiteCol        = 
		    new TableColumn<>("quantite");
		quantiteCol.setMinWidth(50);
		TableColumn<CommandeClient, String> dataCommandeCol       = 
			    new TableColumn<>("Data Commande");
			quantiteCol.setMinWidth(100);
		TableColumn<CommandeClient, String> mpassCol   = 
		    new TableColumn<>("client");
		mpassCol.setMinWidth(50);
		TableColumn<CommandeClient, String> numphCol   = 
		    new TableColumn<>("Pharmacie ");
		numphCol.setMinWidth(50);
		TableColumn<CommandeClient, String> nummedCol    = 
			    new TableColumn<>("medicament ");
		nummedCol.setMinWidth(50);
		TableColumn<CommandeClient, String> typeCol    = 
			    new TableColumn<>("type commande  ");
		typeCol.setMinWidth(50);

		tableView.setPadding(new Insets(20, 150, 10, 50));
		idCol.setCellValueFactory(data -> data.getValue().idProperty());
		quantiteCol.setCellValueFactory(data -> data.getValue().quantiteProperty());
		dataCommandeCol.setCellValueFactory(data -> data.getValue().dateCommandeProperty());

		mpassCol.setCellValueFactory(data->data.getValue().mpassProperty());
		numphCol.setCellValueFactory(data->data.getValue().numphProperty());
		nummedCol.setCellValueFactory(data -> data.getValue().nummedProperty());
		typeCol.setCellValueFactory(data -> data.getValue().typeProperty());
		
		tableView.getColumns().addAll(idCol,quantiteCol,dataCommandeCol,mpassCol,nummedCol);
		 rs =null;
		try {
			rs = CommandeClientDAO.getCommandeClientbyDate(researchValue , Pharmacie.getSelectedPharmacie().getNumNational());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableView.setPlaceholder( new Label("n y a pas de commande "));
		tableView.setItems(rs);

		
		return tableView ;
		
	}
	
	public static TableView getContenueByMed() {
		
		
		 
		TableView tableView = new TableView();
	tableView.setStyle("-fx-background-color: transparent;");
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	    
		TableColumn<CommandeClient, String> idCol = 
		    new TableColumn<>("numero commande ");
		idCol.setMinWidth(50);
		TableColumn<CommandeClient, String> quantiteCol        = 
		    new TableColumn<>("quantite");
		quantiteCol.setMinWidth(50);
		TableColumn<CommandeClient, String> dataCommandeCol       = 
			    new TableColumn<>("Data Commande");
			quantiteCol.setMinWidth(100);
		TableColumn<CommandeClient, String> mpassCol   = 
		    new TableColumn<>("client");
		mpassCol.setMinWidth(50);
		TableColumn<CommandeClient, String> numphCol   = 
		    new TableColumn<>("Pharmacie ");
		numphCol.setMinWidth(50);
		TableColumn<CommandeClient, String> nummedCol    = 
			    new TableColumn<>("medicament ");
		nummedCol.setMinWidth(50);
		TableColumn<CommandeClient, String> typeCol    = 
			    new TableColumn<>("type commande  ");
		typeCol.setMinWidth(50);

		tableView.setPadding(new Insets(20, 150, 10, 50));
		idCol.setCellValueFactory(data -> data.getValue().idProperty());
		quantiteCol.setCellValueFactory(data -> data.getValue().quantiteProperty());
		dataCommandeCol.setCellValueFactory(data -> data.getValue().dateCommandeProperty());

		mpassCol.setCellValueFactory(data->data.getValue().mpassProperty());
		numphCol.setCellValueFactory(data->data.getValue().numphProperty());
		nummedCol.setCellValueFactory(data -> data.getValue().nummedProperty());
		typeCol.setCellValueFactory(data -> data.getValue().typeProperty());
		
		tableView.getColumns().addAll(idCol,quantiteCol,dataCommandeCol,mpassCol,nummedCol);
		 rs =null;
		try {
			rs = CommandeClientDAO.getCommandebyMed(researchValue, Pharmacie.getSelectedPharmacie().getNumNational());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableView.setPlaceholder( new Label("n y a pas de commande "));
		tableView.setItems(rs);

		
		return tableView ;
		
	}
	public static TableView getContenueByClient() {
		
		
		 
		TableView tableView = new TableView();
	tableView.setStyle("-fx-background-color: transparent;");
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	    
		TableColumn<CommandeClient, String> idCol = 
		    new TableColumn<>("numero commande ");
		idCol.setMinWidth(50);
		TableColumn<CommandeClient, String> quantiteCol        = 
		    new TableColumn<>("quantite");
		quantiteCol.setMinWidth(50);
		TableColumn<CommandeClient, String> dataCommandeCol       = 
			    new TableColumn<>("Data Commande");
			quantiteCol.setMinWidth(100);
		TableColumn<CommandeClient, String> mpassCol   = 
		    new TableColumn<>("client");
		mpassCol.setMinWidth(50);
		TableColumn<CommandeClient, String> numphCol   = 
		    new TableColumn<>("Pharmacie ");
		numphCol.setMinWidth(50);
		TableColumn<CommandeClient, String> nummedCol    = 
			    new TableColumn<>("medicament ");
		nummedCol.setMinWidth(50);
		TableColumn<CommandeClient, String> typeCol    = 
			    new TableColumn<>("type commande  ");
		typeCol.setMinWidth(50);

		tableView.setPadding(new Insets(20, 150, 10, 50));
		idCol.setCellValueFactory(data -> data.getValue().idProperty());
		quantiteCol.setCellValueFactory(data -> data.getValue().quantiteProperty());
		dataCommandeCol.setCellValueFactory(data -> data.getValue().dateCommandeProperty());

		mpassCol.setCellValueFactory(data->data.getValue().mpassProperty());
		numphCol.setCellValueFactory(data->data.getValue().numphProperty());
		nummedCol.setCellValueFactory(data -> data.getValue().nummedProperty());
		typeCol.setCellValueFactory(data -> data.getValue().typeProperty());
		
		tableView.getColumns().addAll(idCol,quantiteCol,dataCommandeCol,mpassCol,nummedCol);
		 rs =null;
		try {
			rs = CommandeClientDAO.getCommandebyClient(researchValue, Pharmacie.getSelectedPharmacie().getNumNational());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableView.setPlaceholder( new Label("n y a pas de commande "));
		tableView.setItems(rs);

		
		return tableView ;
	}
	

}
