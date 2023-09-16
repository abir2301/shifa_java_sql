package models;

import java.awt.MenuBar;
import java.io.FileInputStream;
import java.sql.SQLException;

import application.AdminWorkPlace;
import application.Fadd;
import application.Fdelete;
import application.Fupdate;
import application.Main;
import application.NewCommande;
import application.StockAdd3;
import application.StockDelete3;
import application.StockEdit;
import dao.FournisseurDAO;
import dao.MedicamentDAO;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import oo.Fournisseur;
import oo.Medicament;
import oo.Pharmacie;

public class FounisseurModel {
	public static TextField search;
	public static Button filtre1, filtre2, filtre3, filtre4, creation  ;
	public static String researchValue = null;
	
	
	public static void AddCommande(Observable o, Object arg) {
		Platform.runLater(new Runnable() {
			public void run() {
				new Fadd().start(new Stage());
			}
		});
	}
	public static void updateAdd(Observable o, Object arg) {
		Platform.runLater(new Runnable() {
			public void run() {
				new NewCommande().start(new Stage());
			}
		});
	}
	public  static void updateMod(Observable o, Object arg) {
		Platform.runLater(new Runnable() {
			public void run() {
				new Fupdate().start(new Stage());
			}
		});
	}

	public static void updateDel(Observable o, Object arg) {
		Platform.runLater(new Runnable() {
			public void run() {
				new Fdelete().start(new Stage());
			}
		});
	}
	 public static Button createCommandeMed() {
		 creation = new Button("commander  ");
		creation.setPrefSize(200,50);
		
		 creation.setPadding(new Insets(0, 10, 0, 10));
			creation.setStyle(
					"-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight:bold ");
			creation.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								AddCommande(null, Main.stage);

							}
						});

		 return creation ;
		 
	 }
public static HBox getSerchBox() {
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
		      item3.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
				item2.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");

				item1.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
		      menu.getItems().addAll(item1,item2,item3);
			menuButton.getMenus().add(menu);
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
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		search = new TextField();
		search.setPadding(new Insets(10, 50, 10, 10));
		search.setPromptText("Recherche  fournisseeur  ");
		search.setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;");
		search.setMaxWidth(10000);
		// search.setPadding(new Insets(20, 150, 10, 10));
		searchBox.getChildren().addAll(search,menuButton);
		return searchBox;

	}
	public static HBox getfilterGroupe() {

		HBox filtreButtons = new HBox(90);
		filtreButtons.setPadding(new Insets(10, 180, 10, 150));
		filtreButtons.setSpacing(50);
		filtreButtons.setMargin(filtreButtons, null);

		// filtreButtons.setSpacing(width);

		filtre1 = new Button("Nom");
		filtre1.setPrefSize(180,30);
		filtre1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				researchValue = search.getText();
				System.out.print(researchValue + "\n");
				System.out.println("get fournisseur by non   ");

				AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
				 //AdminWorkPlace.Contenu.setRight(StockModel.getStickers());
				
				AdminWorkPlace.Contenu.setCenter(FounisseurModel.getFournisseurBynon());

				
			}
		}

		);

		// filtre1.setPrefSize(100,30);
		filtre1.setPadding(new Insets(0, 10, 0, 10));
		filtre1.setStyle(
				"-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight:bold ");

		filtre2 = new Button("Adresse");
		filtre2.setPrefSize(180,30);
		filtre2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				researchValue = search.getText();
				System.out.print(researchValue + "\n");
				System.out.println("get  four  by adrees marque   ");

				AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
				 //AdminWorkPlace.Contenu.setRight(StockModel.getStickers());
				
				AdminWorkPlace.Contenu.setCenter(FounisseurModel.getFournisseurAdresse());

				
			}
		}

		);

		// filtre2.setPrefSize(500,30);
		filtre2.setPadding(new Insets(0, 10, 0, 10));

		filtre2.setStyle(
				"-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold ");

		filtre3 = new Button("numMed");
		filtre3.setPrefSize(180,30);
		filtre3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				researchValue = search.getText();
				System.out.print(researchValue + "\n");
				System.out.println("get fou bt med    ");

				AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
				
				AdminWorkPlace.Contenu.setCenter(FounisseurModel.getFournisseurMed());

			}
		}

		);
		
		filtre3.setPadding(new Insets(0, 10, 0, 10));
		filtre3.setStyle(
				"-fx-background-color: #a1703a;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold");

		 
		filtreButtons.getChildren().addAll(filtre1, filtre2, filtre3 );
		// filtreButtons.setPadding(new Insets(20, 200, 10, 10));

		return filtreButtons;
	}
 
	public static TableView getAllContenue() {



		TableView tableView = new TableView();
		tableView.setStyle("-fx-background-color: transparent;");
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<Fournisseur, String> numCol = new TableColumn<>("num Fournisseur ");
		//idCol.setMaxWidth(30);
		TableColumn<Fournisseur, String> nomfCol = new TableColumn<>("nomF");
		//phCol.setMinWidth(30);
		TableColumn<Fournisseur, String> adresseCol = new TableColumn<>("adresse");
		//medCol.setMinWidth(30);
		TableColumn<Fournisseur, String> numtelCol = new TableColumn<>("numero tel ");
		//prixCol.setMinWidth(30);
		

		tableView.setPadding(new Insets(20, 150, 10, 50));
		numCol.setCellValueFactory(data -> data.getValue().numProperty());
		nomfCol.setCellValueFactory(data -> data.getValue().nomfProperty());
		adresseCol.setCellValueFactory(data -> data.getValue().adresseProperty());
		numtelCol.setCellValueFactory(data -> data.getValue().numtelProperty());
	

		tableView.getColumns().addAll(numCol,nomfCol,adresseCol,numtelCol);
		
		 ObservableList<Fournisseur> rs =null ;
		 try {
				rs = FournisseurDAO.getAllFournisseur(Pharmacie.getSelectedPharmacie().getNumNational());
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
	
	public static TableView getFournisseurBynon() {



		TableView tableView = new TableView();
		tableView.setStyle("-fx-background-color: transparent;");
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<Fournisseur, String> numCol = new TableColumn<>("num Fournisseur ");
		//idCol.setMaxWidth(30);
		TableColumn<Fournisseur, String> nomfCol = new TableColumn<>("nomF");
		//phCol.setMinWidth(30);
		TableColumn<Fournisseur, String> adresseCol = new TableColumn<>("marque");
		//medCol.setMinWidth(30);
		TableColumn<Fournisseur, String> numtelCol = new TableColumn<>("type");
		//prixCol.setMinWidth(30);
		

		tableView.setPadding(new Insets(20, 150, 10, 50));
		numCol.setCellValueFactory(data -> data.getValue().numProperty());
		nomfCol.setCellValueFactory(data -> data.getValue().nomfProperty());
		adresseCol.setCellValueFactory(data -> data.getValue().adresseProperty());
		numtelCol.setCellValueFactory(data -> data.getValue().numtelProperty());
	

		tableView.getColumns().addAll(numCol,nomfCol,adresseCol,numtelCol);
		
		 ObservableList<Fournisseur> rs =null ;
		 try {
				rs = FournisseurDAO.getFournisseurNoun( Pharmacie.getSelectedPharmacie().getNumNational(),researchValue) ;
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
	public static TableView getFournisseurAdresse() {

 

		TableView tableView = new TableView();
		tableView.setStyle("-fx-background-color: transparent;");
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<Fournisseur, String> numCol = new TableColumn<>("num Fournisseur ");
		//idCol.setMaxWidth(30);
		TableColumn<Fournisseur, String> nomfCol = new TableColumn<>("nomF");
		//phCol.setMinWidth(30);
		TableColumn<Fournisseur, String> adresseCol = new TableColumn<>("marque");
		//medCol.setMinWidth(30);
		TableColumn<Fournisseur, String> numtelCol = new TableColumn<>("type");
		//prixCol.setMinWidth(30);
		

		tableView.setPadding(new Insets(20, 150, 10, 50));
		numCol.setCellValueFactory(data -> data.getValue().numProperty());
		nomfCol.setCellValueFactory(data -> data.getValue().nomfProperty());
		adresseCol.setCellValueFactory(data -> data.getValue().adresseProperty());
		numtelCol.setCellValueFactory(data -> data.getValue().numtelProperty());
	

		tableView.getColumns().addAll(numCol,nomfCol,adresseCol,numtelCol);
		
		 ObservableList<Fournisseur> rs =null ;
		 try {
				rs = FournisseurDAO.getFournisseurAdresse( Pharmacie.getSelectedPharmacie().getNumNational(),researchValue) ;
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
	
	public static TableView getFournisseurMed() {

		 

		TableView tableView = new TableView();
		tableView.setStyle("-fx-background-color: transparent;");
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		TableColumn<Fournisseur, String> numCol = new TableColumn<>("num Fournisseur ");
		//idCol.setMaxWidth(30);
		TableColumn<Fournisseur, String> nomfCol = new TableColumn<>("nomF");
		//phCol.setMinWidth(30);
		TableColumn<Fournisseur, String> adresseCol = new TableColumn<>("marque");
		//medCol.setMinWidth(30);
		TableColumn<Fournisseur, String> numtelCol = new TableColumn<>("type");
		//prixCol.setMinWidth(30);
		

		tableView.setPadding(new Insets(20, 150, 10, 50));
		numCol.setCellValueFactory(data -> data.getValue().numProperty());
		nomfCol.setCellValueFactory(data -> data.getValue().nomfProperty());
		adresseCol.setCellValueFactory(data -> data.getValue().adresseProperty());
		numtelCol.setCellValueFactory(data -> data.getValue().numtelProperty());
	

		tableView.getColumns().addAll(numCol,nomfCol,adresseCol,numtelCol);
		
		 ObservableList<Fournisseur> rs =null ;
		 try {
				rs = FournisseurDAO.getFournisseurMEd( Pharmacie.getSelectedPharmacie().getNumNational(),researchValue) ;
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
