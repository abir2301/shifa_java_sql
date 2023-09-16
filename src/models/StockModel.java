package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.naming.directory.SearchResult;

import application.AdminWorkPlace;
import application.Main;
import application.StockAdd3;
import application.StockDelete3;
import application.StockEdit;
import dao.CommandeClientDAO;
import dao.CommandeMedDAO;
import dao.MedicamentDAO;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import oo.CommandeClient;
import oo.CommandeMEd;
import oo.Fournisseur;
import oo.Medicament;
import oo.MedicamentPh;
import oo.Pharmacie;

public class StockModel {
	int n = 0;
	public static Button addButton, editButton, deleteButton, bestSeller, finStock, perime;
	public static String researchValue = null;
	public static TextField search;
	public static Button filtre1, filtre2, filtre3 , filtre4;
	public static ObservableList<CommandeMEd> rs;
	public static ObservableList<MedicamentPh> rs1;
	
	public static void updateAdd(Observable o, Object arg) {
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

	public static void updateDel(Observable o, Object arg) {
		Platform.runLater(new Runnable() {
			public void run() {
				new StockDelete3().start(new Stage());
			}
		});
	}

	public static HBox getMiniMenue() {
		HBox searchBox = new HBox(10);
		searchBox.setPadding(new Insets(0, 500, 0, 150));
		searchBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
		
		javafx.scene.control.MenuBar  menuButton = new javafx.scene.control.MenuBar();
		((Region) menuButton).setPrefSize(40, 40);
		menuButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
		try {
			
			ImageView menuButtonIcon = new ImageView(
					new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/menu.png")));
			menuButtonIcon.setFitHeight(40);
			menuButtonIcon.setFitWidth(40);
			
			
			Menu menu = new Menu("", menuButtonIcon) ;
			MenuItem item1 = new MenuItem("Ajouter");
		    MenuItem item2 = new MenuItem("modifier ");
		     MenuItem item3 = new MenuItem("suprimer");
		     
		     item1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				updateAdd(null, Main.stage);

			}
		});
		     item2.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						updateMod(null, Main.stage);

					}
				});
		     item3.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						updateDel(null, Main.stage);

					}
				});
		      item3.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
				item2.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");

				item1.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
		      menu.getItems().addAll(item1,item2,item3);
			menuButton.getMenus().add(menu);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		// search.setPadding(new Insets(20, 150, 10, 10));
		searchBox.getChildren().addAll(menuButton);
		return searchBox;

	}

	public static VBox getStickers() {

		bestSeller = new Button("Best-seller");
		bestSeller.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
				 AdminWorkPlace.Contenu.setRight(StockModel.getStickers());
				
				AdminWorkPlace.Contenu.setCenter(StockModel.getAllContenuestockBestSeller());
			}});
		bestSeller.setPadding(new Insets(10, 30, 10, 30));
		bestSeller.setStyle(
				"-fx-background-color: #b98b56;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");

		finStock = new Button("Fin stock");
		finStock.setPadding(new Insets(10, 30, 10, 30));
		finStock.setStyle(
				"-fx-background-color: #b98b56;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");

		perime = new Button("Périmé");
		perime.setPadding(new Insets(10, 30, 10, 30));
		perime.setStyle(
				"-fx-background-color: #b98b56;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");

		// stickers button stock
		VBox stickers = new VBox(10);
		stickers.setAlignment(Pos.CENTER_RIGHT);
		stickers.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
		stickers.getChildren().addAll(bestSeller, finStock, perime);

		return stickers;
	}

	public static TextField getSerchBox() {

		search = new TextField();
		search.setPadding(new Insets(10, 20, 10, 10));
		search.setPromptText("Recherche stock ");
		search.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
		search.setMaxWidth(990);
		// search.setPadding(new Insets(20, 150, 10, 10));
		return search;

	}

	public static HBox getfilterGroupe() {

		HBox filtreButtons = new HBox(90);
		filtreButtons.setPadding(new Insets(10, 180, 10, 150));
		filtreButtons.setSpacing(50);
		filtreButtons.setMargin(filtreButtons, null);

		// filtreButtons.setSpacing(width);

		filtre1 = new Button("TYPE ");
		filtre1.setPrefSize(180,30);
		filtre1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				researchValue = search.getText();
				System.out.print(researchValue + "\n");
				System.out.println("get med   by type  ");

				AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
				 AdminWorkPlace.Contenu.setRight(StockModel.getStickers());
				
				AdminWorkPlace.Contenu.setCenter(StockModel.getAllContenuestockByType());
			}
		}

		);

		// filtre1.setPrefSize(100,30);
		filtre1.setPadding(new Insets(0, 10, 0, 10));
		filtre1.setStyle(
				"-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight:bold ");

		filtre2 = new Button("MARQUE");
		filtre1.setPrefSize(180,30);
		filtre2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				researchValue = search.getText();
				System.out.print(researchValue + "\n");
				System.out.println("get med   by marque   ");

				AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
				 AdminWorkPlace.Contenu.setRight(StockModel.getStickers());
				
				AdminWorkPlace.Contenu.setCenter(StockModel.getAllContenuestockByMarque());
			}
		}

		);

		// filtre2.setPrefSize(500,30);
		filtre2.setPadding(new Insets(0, 10, 0, 10));
		filtre2.setPrefSize(180,30);
		filtre2.setStyle(
				"-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");

		filtre3 = new Button("NOM");
		filtre3.setPrefSize(180,30);
		filtre3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				researchValue = search.getText();
				System.out.print(researchValue + "\n");
				System.out.println("get med   by marque   ");

				AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
				 AdminWorkPlace.Contenu.setRight(StockModel.getStickers());
				
				AdminWorkPlace.Contenu.setCenter(StockModel.getAllContenuestockByName());
			}
		}

		);
		
		filtre3.setPadding(new Insets(0, 10, 0, 10));
		
		filtre3.setStyle(
				"-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold");

		 filtre4 = new Button(" ALL");
		 filtre4.setPrefSize(180,30);
		filtre4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				researchValue = search.getText();
				System.out.print(researchValue + "\n");
				System.out.println( "show all med    ");

				AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
				 AdminWorkPlace.Contenu.setRight(StockModel.getStickers());
				
				AdminWorkPlace.Contenu.setCenter(StockModel.getAllContenue());
			}
		}

		);
		//filtre4.setPrefSize(100, 30);
		filtre4.setPadding(new Insets(0, 10, 0, 10));
		filtre4.setStyle(
				"-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");
		Button  filtre5 = new Button(" fournisseur");
		 filtre5.setPrefSize(250,30);

		filtre4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			}
		}

		);
		filtre5.setPadding(new Insets(0, 10, 0, 10));
		filtre5.setStyle(
				"-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");
		filtreButtons.getChildren().addAll(filtre1, filtre2, filtre3, filtre5);
		// filtreButtons.setPadding(new Insets(20, 200, 10, 10));

		return filtreButtons;
	}

	public static TableView getAllContenue() {



		TableView tableView = new TableView();
		tableView.setStyle("-fx-background-color: transparent;");
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<Medicament, String> idCol = new TableColumn<>("Med");
		//idCol.setMaxWidth(30);
		TableColumn<Medicament, String> desCol = new TableColumn<>("description");
		//phCol.setMinWidth(30);
		TableColumn<Medicament, String> marqueCol = new TableColumn<>("marque");
		//medCol.setMinWidth(30);
		TableColumn<Medicament, String> typeCol = new TableColumn<>("type");
		//prixCol.setMinWidth(30);
		TableColumn<Medicament, String> nbCol = new TableColumn<>("N°");
		//numfCol.setMaxWidth(50);
		

		tableView.setPadding(new Insets(20, 150, 10, 50));
		idCol.setCellValueFactory(data -> data.getValue().idProperty());
		desCol.setCellValueFactory(data -> data.getValue().descriptionProperty());
		marqueCol.setCellValueFactory(data -> data.getValue().marqueProperty());
		typeCol.setCellValueFactory(data -> data.getValue().typeProperty());
		nbCol.setCellValueFactory(data -> data.getValue().nomProperty());
		;

		tableView.getColumns().addAll(idCol,desCol,marqueCol, typeCol,nbCol);
		
		 ObservableList<Medicament> rs =null ;
		 try {
				rs = MedicamentDAO.getAllMedWithDetail(Pharmacie.getSelectedPharmacie().getNumNational() );
				System.out.print("after rs get all ");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		/*
		 * rs = null; try { rs = MedicamentDAO.getAllStock(); } catch
		 * (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
		 * }
		 */
		 
		tableView.setPlaceholder(new Label("pas de medicament "));
		tableView.setItems(rs);
	System.out.print("after get all table view items");
		return tableView;


	}

	public static TableView getAllContenuestock() {
  
		TableView tableView = new TableView();
		tableView.setStyle("-fx-background-color: transparent;");
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<CommandeMEd, String> idCol = new TableColumn<>("num-Com");
		//idCol.setMaxWidth(30);
		TableColumn<CommandeMEd, String> phCol = new TableColumn<>("ph  ");
		//phCol.setMinWidth(30);
		TableColumn<CommandeMEd, String> medCol = new TableColumn<>("nom-med  ");
		//medCol.setMinWidth(30);
		TableColumn<CommandeMEd, String> prixCol = new TableColumn<>("prix-med ");
		//prixCol.setMinWidth(30);
		TableColumn<CommandeMEd, String> numfCol = new TableColumn<>("fournisseur");
		//numfCol.setMaxWidth(50);
		TableColumn<CommandeMEd, String> datecCol = new TableColumn<>("date-creation");
		//datecCol.setMaxWidth(50);
		TableColumn<CommandeMEd, String> datelCol = new TableColumn<>("date-limite");
		//datecCol.setMaxWidth(20);
		TableColumn<CommandeMEd, String> quantiteCol = new TableColumn<>("quantite");
		//quantiteCol.setMaxWidth(10);

		tableView.setPadding(new Insets(20, 150, 10, 50));
		idCol.setCellValueFactory(data -> data.getValue().idProperty());
		phCol.setCellValueFactory(data -> data.getValue().phProperty());
		medCol.setCellValueFactory(data -> data.getValue().medProperty());
		numfCol.setCellValueFactory(data -> data.getValue().numfProperty());
		prixCol.setCellValueFactory(data -> data.getValue().prixProperty());
		datecCol.setCellValueFactory(data -> data.getValue().datecProperty());
		datelCol.setCellValueFactory(data -> data.getValue().datelProperty());
		quantiteCol.setCellValueFactory(data -> data.getValue().quantiteProperty());

		tableView.getColumns().addAll(medCol,datecCol,datelCol,quantiteCol,prixCol,idCol );
		 ObservableList<CommandeMEd> rs =null ;
		 try {
				rs = CommandeMedDAO.getAllStock(Pharmacie.getSelectedPharmacie().getNumNational());
				System.out.print("after rs get all ");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		/*
		 * rs = null; try { rs = MedicamentDAO.getAllStock(); } catch
		 * (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
		 * }
		 */
		 
		tableView.setPlaceholder(new Label("pas de medicament "));
		tableView.setItems(rs);
System.out.print("after get all table view items");
		return tableView;

	}


public static TableView getAllContenuestockByType() {
	  
	TableView tableView = new TableView();
	tableView.setStyle("-fx-background-color: transparent;");
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	TableColumn<CommandeMEd, String> idCol = new TableColumn<>("num-Com");
	//idCol.setMaxWidth(30);
	TableColumn<CommandeMEd, String> phCol = new TableColumn<>("ph  ");
	//phCol.setMinWidth(30);
	TableColumn<CommandeMEd, String> medCol = new TableColumn<>("num-me  ");
	//medCol.setMinWidth(30);
	TableColumn<CommandeMEd, String> prixCol = new TableColumn<>("prix-med(dt)");
	//prixCol.setMinWidth(30);
	TableColumn<CommandeMEd, String> numfCol = new TableColumn<>("fournisseur");
	//numfCol.setMaxWidth(50);
	TableColumn<CommandeMEd, String> datecCol = new TableColumn<>("date-creation");
	//datecCol.setMaxWidth(50);
	TableColumn<CommandeMEd, String> datelCol = new TableColumn<>("date-limite");
	//datecCol.setMaxWidth(20);
	TableColumn<CommandeMEd, String> quantiteCol = new TableColumn<>("quantite");
	//quantiteCol.setMaxWidth(10);

	tableView.setPadding(new Insets(20, 150, 10, 50));
	idCol.setCellValueFactory(data -> data.getValue().idProperty());
	phCol.setCellValueFactory(data -> data.getValue().phProperty());
	medCol.setCellValueFactory(data -> data.getValue().medProperty());
	numfCol.setCellValueFactory(data -> data.getValue().numfProperty());
	prixCol.setCellValueFactory(data -> data.getValue().prixProperty());
	datecCol.setCellValueFactory(data -> data.getValue().datecProperty());
	datelCol.setCellValueFactory(data -> data.getValue().datelProperty());
	quantiteCol.setCellValueFactory(data -> data.getValue().quantiteProperty());

	tableView.getColumns().addAll(medCol,datecCol,datelCol,quantiteCol,prixCol,idCol );
	 ObservableList<CommandeMEd> rs =null ;
	 try {
			rs = CommandeMedDAO.getAllStockByType (Pharmacie.getSelectedPharmacie().getNumNational(), researchValue );
			System.out.print("after rs get all ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	/*
	 * rs = null; try { rs = MedicamentDAO.getAllStock(); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
	 * }
	 */
	 
	tableView.setPlaceholder(new Label("pas de medicament "));
	tableView.setItems(rs);
System.out.print("after get all table view items");
	return tableView;

}



public static TableView getAllContenuestockByMarque() {
	  
	TableView tableView = new TableView();
	tableView.setStyle("-fx-background-color: transparent;");
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	TableColumn<CommandeMEd, String> idCol = new TableColumn<>("num-Com");
	//idCol.setMaxWidth(30);
	TableColumn<CommandeMEd, String> phCol = new TableColumn<>("ph  ");
	//phCol.setMinWidth(30);
	TableColumn<CommandeMEd, String> medCol = new TableColumn<>("num-me  ");
	//medCol.setMinWidth(30);
	TableColumn<CommandeMEd, String> prixCol = new TableColumn<>("prix-med(dt)");
	//prixCol.setMinWidth(30);
	TableColumn<CommandeMEd, String> numfCol = new TableColumn<>("fournisseur");
	//numfCol.setMaxWidth(50);
	TableColumn<CommandeMEd, String> datecCol = new TableColumn<>("date-creation");
	//datecCol.setMaxWidth(50);
	TableColumn<CommandeMEd, String> datelCol = new TableColumn<>("date-limite");
	//datecCol.setMaxWidth(20);
	TableColumn<CommandeMEd, String> quantiteCol = new TableColumn<>("quantite");
	//quantiteCol.setMaxWidth(10);

	tableView.setPadding(new Insets(20, 150, 10, 50));
	idCol.setCellValueFactory(data -> data.getValue().idProperty());
	phCol.setCellValueFactory(data -> data.getValue().phProperty());
	medCol.setCellValueFactory(data -> data.getValue().medProperty());
	numfCol.setCellValueFactory(data -> data.getValue().numfProperty());
	prixCol.setCellValueFactory(data -> data.getValue().prixProperty());
	datecCol.setCellValueFactory(data -> data.getValue().datecProperty());
	datelCol.setCellValueFactory(data -> data.getValue().datelProperty());
	quantiteCol.setCellValueFactory(data -> data.getValue().quantiteProperty());

	tableView.getColumns().addAll(medCol,datecCol,datelCol,quantiteCol,prixCol,idCol );
	 ObservableList<CommandeMEd> rs =null ;
	 try {
			rs = CommandeMedDAO.getAllStockByMarque (Pharmacie.getSelectedPharmacie().getNumNational(), researchValue );
			System.out.print("after rs get all ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	/*
	 * rs = null; try { rs = MedicamentDAO.getAllStock(); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
	 * }
	 */
	 
	tableView.setPlaceholder(new Label("pas de medicament "));
	tableView.setItems(rs);
System.out.print("after get all table view items");
	return tableView;

}

public static TableView getAllContenuestockByName() {
	  
	TableView tableView = new TableView();
	tableView.setStyle("-fx-background-color: transparent;");
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	TableColumn<CommandeMEd, String> idCol = new TableColumn<>("num-Com");
	//idCol.setMaxWidth(30);
	TableColumn<CommandeMEd, String> phCol = new TableColumn<>("ph  ");
	//phCol.setMinWidth(30);
	TableColumn<CommandeMEd, String> medCol = new TableColumn<>("num-me  ");
	//medCol.setMinWidth(30);
	TableColumn<CommandeMEd, String> prixCol = new TableColumn<>("prix-med(dt)");
	//prixCol.setMinWidth(30);
	TableColumn<CommandeMEd, String> numfCol = new TableColumn<>("fournisseur");
	//numfCol.setMaxWidth(50);
	TableColumn<CommandeMEd, String> datecCol = new TableColumn<>("date-creation");
	//datecCol.setMaxWidth(50);
	TableColumn<CommandeMEd, String> datelCol = new TableColumn<>("date-limite");
	//datecCol.setMaxWidth(20);
	TableColumn<CommandeMEd, String> quantiteCol = new TableColumn<>("quantite");
	//quantiteCol.setMaxWidth(10);

	tableView.setPadding(new Insets(20, 150, 10, 50));
	idCol.setCellValueFactory(data -> data.getValue().idProperty());
	phCol.setCellValueFactory(data -> data.getValue().phProperty());
	medCol.setCellValueFactory(data -> data.getValue().medProperty());
	numfCol.setCellValueFactory(data -> data.getValue().numfProperty());
	prixCol.setCellValueFactory(data -> data.getValue().prixProperty());
	datecCol.setCellValueFactory(data -> data.getValue().datecProperty());
	datelCol.setCellValueFactory(data -> data.getValue().datelProperty());
	quantiteCol.setCellValueFactory(data -> data.getValue().quantiteProperty());

	tableView.getColumns().addAll(medCol,datecCol,datelCol,quantiteCol,prixCol,idCol );
	 ObservableList<CommandeMEd> rs =null ;
	 try {
			rs = CommandeMedDAO.getAllStockByName (Pharmacie.getSelectedPharmacie().getNumNational(), researchValue );
			System.out.print("after rs get all ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	/*
	 * rs = null; try { rs = MedicamentDAO.getAllStock(); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
	 * }
	 */
	 
	tableView.setPlaceholder(new Label("pas de medicament "));
	tableView.setItems(rs);
System.out.print("after get all table view items");
	return tableView;

}



public static TableView getAllContenuestockBestSeller() {
	  
	TableView tableView = new TableView();
	tableView.setStyle("-fx-background-color: transparent;");
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	TableColumn<Medicament, String> idCol = new TableColumn<>("Med");
	//idCol.setMaxWidth(30);
	TableColumn<Medicament, String> desCol = new TableColumn<>("description");
	//phCol.setMinWidth(30);
	TableColumn<Medicament, String> marqueCol = new TableColumn<>("marque");
	//medCol.setMinWidth(30);
	TableColumn<Medicament, String> typeCol = new TableColumn<>("type");
	//prixCol.setMinWidth(30);
	TableColumn<Medicament, String> nbCol = new TableColumn<>("N°");
	//numfCol.setMaxWidth(50);
	

	tableView.setPadding(new Insets(20, 150, 10, 50));
	idCol.setCellValueFactory(data -> data.getValue().idProperty());
	desCol.setCellValueFactory(data -> data.getValue().descriptionProperty());
	marqueCol.setCellValueFactory(data -> data.getValue().marqueProperty());
	typeCol.setCellValueFactory(data -> data.getValue().typeProperty());
	nbCol.setCellValueFactory(data -> data.getValue().nomProperty());
	;

	tableView.getColumns().addAll(idCol,desCol,marqueCol, typeCol,nbCol);
	
	 ObservableList<Medicament> rs =null ;
	 try {
			rs = MedicamentDAO.getmedPerime(Pharmacie.getSelectedPharmacie().getNumNational() );
			System.out.print("after rs get all ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	/*
	 * rs = null; try { rs = MedicamentDAO.getAllStock(); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
	 * }
	 */
	 
	tableView.setPlaceholder(new Label("pas de medicament "));
	tableView.setItems(rs);
System.out.print("after get all table view items");
	return tableView;

}

}