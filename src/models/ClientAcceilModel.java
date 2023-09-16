package models;
import java.io.FileInputStream;
import java.sql.SQLException;

import application.AdminWorkPlace;
import application.ClientWorkPlace;

import application.Main;
import application.NewCommande;
import application.NewCommandeClient;
import dao.CommandeClientDAO;
import dao.MedicamentDAO;
import dao.PharmacieDAO;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import oo.Client;
import oo.CommandeClient;
import oo.Medicament;
import oo.Pharmacie;

public class ClientAcceilModel {
	public static  int width=1500,height=900;
	 public static  ObservableList<CommandeClient> rs  ;
	 public static String researchValue = null ; 
	  public static  TextField search ;
	  public static Button filtre1 ,filtre2, filtre3;
	  
	  public static void AddCommandeClient(Observable o, Object arg) {
			Platform.runLater(new Runnable() {
				public void run() {
					new  NewCommandeClient().start(new Stage());
				}
			});
		}
	  public static Button createCommandeClient() {
		Button creation1 = new Button ("commander medicament ");
		creation1.setPrefSize(350,50);
		 creation1.setPadding(new Insets(0, 10, 0, 10));
			creation1.setStyle(
					"-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight:bold ");
			creation1.setOnAction(
					new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								AddCommandeClient(null, Main.stage);

							}
						});

		  return creation1;
	  }
	  
	  public static Label message () {
		  Label l = new Label ("COMMANDE EFFECTUER  ");
		 l.setFont(Font.font("",FontWeight.LIGHT,14));
			l.setTextFill(Color.valueOf("#e6e0d8"));
			l.setPadding(new Insets(8,0,0,0));
		  return l ;
	  }

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
public static HBox getFilters() {
		
	
	HBox filtreButtons = new HBox(90);
    filtreButtons.setPadding(new Insets(10, 180, 10, 150));
    filtreButtons.setSpacing(50);
   filtreButtons.setMargin(filtreButtons, null);
    
   // filtreButtons.setSpacing(width);
   
	filtre1 = new Button("liste des pharmacie  ");
	
	filtre1.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent event) {
	    	
			ClientWorkPlace.Contenu.getChildren().removeAll(ClientWorkPlace.Contenu.getChildren());
			ClientWorkPlace.Contenu.setTop(ClientAcceilModel.getAllPharmacieContent());

			 researchValue = search.getText();
			
	    
	    }});

	//filtre1.setPrefSize(100,30);
	filtre1.setPadding(new Insets(0, 10, 0, 10) );
	filtre1.setPrefSize(300,30);
	filtre1.setStyle("-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");
	
	 filtre2 = new Button("liste des medicament ");
	 filtre2.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		    	
		    	 researchValue = search.getText();
					System.out.print(researchValue);
				ClientWorkPlace.Contenu.getChildren().removeAll(ClientWorkPlace.Contenu.getChildren());
				ClientWorkPlace.Contenu.setTop(ClientAcceilModel.getAllPharmacieMed());

				 
				
		    
		    }});
	 filtre2.setPrefSize(300,30);
	// filtre2.setOnAction();
	
	//filtre2.setPrefSize(500,30);
	filtre2.setPadding(new Insets(0, 10, 0, 10) );
	
	filtre2.setStyle("-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");
	
	 filtre3 = new Button(" ph/med  ");
	 filtre3.setPrefSize(300,30);
	//filtre3.setPrefSize(100,30);
	filtre3.setPadding(new Insets(0, 10, 0, 10) );
	filtre3.setStyle("-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");
	
	
	
	filtreButtons.getChildren().addAll(filtre1,filtre2);

	
	return filtreButtons;

		
	}

 public static TableView getAllMedContent() {
	
	
	 
	TableView tableView = new TableView();
	
	TableViewSelectionModel<Medicament> selectionModel = 
		    tableView.getSelectionModel();
	selectionModel.setSelectionMode(
		    SelectionMode.SINGLE);
	
	ObservableList<Medicament> selectedItems = 
		    selectionModel.getSelectedItems();
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	


	
tableView.setStyle("-fx-background-color: transparent;");
    
	TableColumn<Medicament, String> idCol = 
	    new TableColumn<>("reference med ");
	idCol.setMinWidth(50);
	TableColumn<Medicament, String> nomCol        = 
	    new TableColumn<>("nom med ");
	
	TableColumn<Medicament, String> desCol       = 
		    new TableColumn<>("descrption ");
		
	TableColumn<Medicament, String> marqueCol   = 
	    new TableColumn<>("marque med ");
	
	TableColumn<Medicament, String> typeCol   = 
	    new TableColumn<>("type med  ");
	
	

	tableView.setPadding(new Insets(20, 150, 10, 50));
	idCol.setCellValueFactory(data -> data.getValue().idProperty());
	nomCol.setCellValueFactory(data -> data.getValue().nomProperty());
	desCol.setCellValueFactory(data -> data.getValue().descriptionProperty());

	marqueCol.setCellValueFactory(data->data.getValue().marqueProperty());
	typeCol.setCellValueFactory(data->data.getValue().typeProperty());
	
	typeCol.setCellValueFactory(data -> data.getValue().typeProperty());
	
	tableView.getColumns().addAll(idCol,nomCol,desCol,marqueCol,typeCol);
	 
	  ObservableList<Medicament> rs ;
	 rs =null;
	try {
		rs = MedicamentDAO.MedicamentLsitClient();
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
	
public static TableView getAllPharmacieContent() {
	
	
	 
	TableView tableView = new TableView();
	
	TableViewSelectionModel<Pharmacie> selectionModel = 
		    tableView.getSelectionModel();
	selectionModel.setSelectionMode(
		    SelectionMode.SINGLE);
	
	ObservableList<Pharmacie> selectedItems = 
		    selectionModel.getSelectedItems();
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	


	
tableView.setStyle("-fx-background-color: transparent;");
    
	TableColumn<Pharmacie, String> idCol = 
	    new TableColumn<>("reference med ");
	idCol.setMinWidth(50);
	TableColumn<Pharmacie, String> nomCol        = 
	    new TableColumn<>("nom Pharmacie  ");
	
	TableColumn<Pharmacie, String> adresseCol       = 
		    new TableColumn<>("adresse ");
		
	TableColumn<Pharmacie, String> numtelCol   = 
	    new TableColumn<>("contact ");
	
	TableColumn<Pharmacie, String> typeCol   = 
	    new TableColumn<>("type pharmacie   ");
	
	TableColumn<Pharmacie, String> jourCol   = 
		    new TableColumn<>(" jour de travail /7 ");
	
	

	tableView.setPadding(new Insets(20, 150, 10, 50));
	idCol.setCellValueFactory(data -> data.getValue().numProperty());
	nomCol.setCellValueFactory(data -> data.getValue().nomProperty());
	adresseCol.setCellValueFactory(data -> data.getValue().adresseProperty());

	 numtelCol.setCellValueFactory(data->data.getValue().contactProperty());
	typeCol.setCellValueFactory(data->data.getValue().typeProperty());
	
	jourCol.setCellValueFactory(data -> data.getValue().jourProperty());
	
	tableView.getColumns().addAll(nomCol,adresseCol,numtelCol,typeCol,jourCol);
	 
	  ObservableList<Pharmacie> rs ;
	 rs =null;
	try {
		rs = PharmacieDAO.getphList();
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

public static TableView getAllPharmacieMed() {
	
	
	 
	TableView tableView = new TableView();
	
	TableViewSelectionModel<Pharmacie> selectionModel = 
		    tableView.getSelectionModel();
	selectionModel.setSelectionMode(
		    SelectionMode.SINGLE);
	
	ObservableList<Pharmacie> selectedItems = 
		    selectionModel.getSelectedItems();
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	


	
tableView.setStyle("-fx-background-color: transparent;");
    
	
	TableColumn<Pharmacie, String> nomCol        = 
	    new TableColumn<>("nom Pharmacie  ");
	
	TableColumn<Pharmacie, String> adresseCol       = 
		    new TableColumn<>("adresse ");
		
	TableColumn<Pharmacie, String> numtelCol   = 
	    new TableColumn<>("contact ");
	
	TableColumn<Pharmacie, String> typeCol   = 
	    new TableColumn<>("type pharmacie   ");
	
	TableColumn<Pharmacie, String> jourCol   = 
		    new TableColumn<>(" jour de travail /7 ");
	TableColumn<Pharmacie, String> idCol = 
		    new TableColumn<>(" prix (dt) ");
		idCol.setMinWidth(50);
	

	tableView.setPadding(new Insets(20, 150, 10, 50));
	idCol.setCellValueFactory(data -> data.getValue().numProperty());
	nomCol.setCellValueFactory(data -> data.getValue().nomProperty());
	adresseCol.setCellValueFactory(data -> data.getValue().adresseProperty());

	 numtelCol.setCellValueFactory(data->data.getValue().contactProperty());
	typeCol.setCellValueFactory(data->data.getValue().typeProperty());
	
	jourCol.setCellValueFactory(data -> data.getValue().jourProperty());
	
	tableView.getColumns().addAll(nomCol,adresseCol,numtelCol,typeCol,jourCol,idCol);
	 
	  ObservableList<Pharmacie> rs ;
	 rs =null;
	try {
		rs = PharmacieDAO.getphListByMed(researchValue);
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
	
/*public static TableView getAllCommandeClient() {
	
	 
	TableView tableView = new TableView();
	
	TableViewSelectionModel<Pharmacie> selectionModel = 
		    tableView.getSelectionModel();
	selectionModel.setSelectionMode(
		    SelectionMode.SINGLE);
	
	ObservableList<Pharmacie> selectedItems = 
		    selectionModel.getSelectedItems();
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	


	
tableView.setStyle("-fx-background-color: transparent;");
    
	TableColumn<Pharmacie, String> idCol = 
	    new TableColumn<>("reference med ");
	idCol.setMinWidth(50);
	TableColumn<Pharmacie, String> nomCol        = 
	    new TableColumn<>("nom Pharmacie  ");
	
	TableColumn<Pharmacie, String> adresseCol       = 
		    new TableColumn<>("adresse ");
		
	TableColumn<Pharmacie, String> numtelCol   = 
	    new TableColumn<>("contact ");
	
	TableColumn<Pharmacie, String> typeCol   = 
	    new TableColumn<>("type pharmacie   ");
	
	TableColumn<Pharmacie, String> jourCol   = 
		    new TableColumn<>(" jour de travail /7 ");
	
	

	tableView.setPadding(new Insets(20, 150, 10, 50));
	idCol.setCellValueFactory(data -> data.getValue().numProperty());
	nomCol.setCellValueFactory(data -> data.getValue().nomProperty());
	adresseCol.setCellValueFactory(data -> data.getValue().adresseProperty());

	 numtelCol.setCellValueFactory(data->data.getValue().contactProperty());
	typeCol.setCellValueFactory(data->data.getValue().typeProperty());
	
	jourCol.setCellValueFactory(data -> data.getValue().jourProperty());
	
	tableView.getColumns().addAll(nomCol,adresseCol,numtelCol,typeCol,jourCol);
	 
	  ObservableList<Pharmacie> rs ;
	 rs =null;
	try {
		rs = PharmacieDAO.getphList();
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
	
}*/

public static TableView  getAllCommandeClient(){
	
	
	 
	TableView tableView = new TableView();
	
	TableViewSelectionModel<CommandeClient> selectionModel = 
		    tableView.getSelectionModel();
	selectionModel.setSelectionMode(
		    SelectionMode.SINGLE);
	
	ObservableList<CommandeClient> selectedItems = 
		    selectionModel.getSelectedItems();
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	


	
tableView.setStyle("-fx-background-color: transparent;");
    
	
	TableColumn<CommandeClient, String> idCol        = 
	    new TableColumn<>(" id commande   ");
	
	TableColumn<CommandeClient, String> quantiteCol       = 
		    new TableColumn<>(" quantite  ");
		
	TableColumn<CommandeClient, String> dateCol   = 
	    new TableColumn<>("date commande  ");
	
	TableColumn<CommandeClient, String> idcCol   = 
	    new TableColumn<>(" id client   ");
	
	TableColumn<CommandeClient, String> phCol   = 
		    new TableColumn<>(" pharamacie  ");
	TableColumn<CommandeClient, String> medCol = 
		    new TableColumn<>(" medicament   ");
		idCol.setMinWidth(50);
	

	tableView.setPadding(new Insets(20, 150, 10, 50));
	idCol.setCellValueFactory(data -> data.getValue().idProperty());
	quantiteCol.setCellValueFactory(data -> data.getValue().quantiteProperty());
	dateCol.setCellValueFactory(data -> data.getValue().dateCommandeProperty());

	 idcCol.setCellValueFactory(data->data.getValue().mpassProperty());
	phCol.setCellValueFactory(data->data.getValue().numphProperty());
	
	medCol.setCellValueFactory(data -> data.getValue().nummedProperty());
	
	tableView.getColumns().addAll(idCol,medCol,quantiteCol,phCol,dateCol);
	 
	  ObservableList<CommandeClient> rs ;
	 rs =null;
	try {
		rs = CommandeClientDAO.getCommandeByClient(Client.getSelecteClient().getMpass());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	tableView.setPlaceholder( new Label("pas de commande efectuer allez cherchez de nouveau  "));
	tableView.setItems(rs);

	
	return tableView ;
	
}
	






	 }
