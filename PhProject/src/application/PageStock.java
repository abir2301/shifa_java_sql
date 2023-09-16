package application;

import application.PageAdmin;
import application.StockAdd3;
import application.StockDelete3;

import java.io.FileInputStream;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class PageStock extends Application {

	double xOffset, yOffset;
	int n = 0;
	public Button addButton, editButton, deleteButton, accueil, stock, fournisseur, livraison, bestSeller, finStock,
			perime;

	Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			// primaryStage.initStyle(StageStyle.UNDECORATED);

			BorderPane root = new BorderPane();

			int width = 1500, height = 900;
			int toolBarHeight = 20;
			Scene scene = new Scene(root, width, height);

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

			////////////////// buttonns
			StackPane leftFrame = new StackPane();
			leftFrame.setPrefSize(width * .2, height);

			VBox miniMenu = new VBox();
			miniMenu.setMaxSize(120, 180);
			// miniMenu.setPadding(new Insets(0,0,0,0));
			miniMenu.setBackground(new Background(new BackgroundFill(Color.valueOf("#181818"), null, null)));
			miniMenu.setAlignment(Pos.CENTER);

			addButton = new Button("Ajouter");
			addButton.setPrefSize(120, 60);
			addButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #80756a;-fx-font-size: 20px;");

			editButton = new Button("Modifier");
			editButton.setPrefSize(120, 60);
			editButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #80756a;-fx-font-size: 20px; ");

			deleteButton = new Button("Supprimer");
			deleteButton.setPrefSize(120, 60);
			deleteButton.setStyle("-fx-background-color: transparent;-fx-text-fill: #80756a;-fx-font-size: 20px;");

			miniMenu.getChildren().addAll(addButton, editButton, deleteButton);
			// stock box
			leftFrame.setAlignment(miniMenu, Pos.BOTTOM_RIGHT);

			VBox intro = new VBox(25);
			intro.setPrefSize(width * .2, height);
			intro.setAlignment(Pos.BOTTOM_LEFT);

			Image introBackground = new Image(
					new FileInputStream("src/ProjetJavaPharmacie/imagesJava/introBackground.jpg"));

			////// buttons
			intro.setBackground(new Background(new BackgroundImage(introBackground, null, null, null, null)));

			/*
			 * accueil = new Button("Accueil"); //accueil.setPadding(new Insets(0,70,0,0));
			 * accueil.setPrefSize(width*.2, 80); accueil.
			 * setStyle("-fx-background-color: transparent ;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light "
			 * ); ImageView home = new ImageView(new Image(new
			 * FileInputStream("src/ProjetJavaPharmacie/imagesJava/home.png")));
			 * home.setFitHeight(50); home.setFitWidth(60); accueil.setGraphic(home);
			 * accueil.setContentDisplay(ContentDisplay.TOP);
			 * 
			 * 
			 * 
			 * stock = new Button("Stock"); stock.setOnAction(null); //stock.setPadding(new
			 * Insets(0,82,0,0)); stock.setPrefSize(width*.2, 80); stock.
			 * setStyle("-fx-background-color: rgba(0, 100, 100, 0.3);-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light"
			 * ); ImageView stockIcon = new ImageView(new Image(new
			 * FileInputStream("src/ProjetJavaPharmacie/imagesJava/stock.png")));
			 * stockIcon.setFitHeight(60); stockIcon.setFitWidth(60);
			 * stock.setGraphic(stockIcon); stock.setContentDisplay(ContentDisplay.TOP);
			 * 
			 * fournisseur = new Button("Fournisseur"); //fournisseur.setPadding(new
			 * Insets(0,27,0,0)); fournisseur.setPrefSize(width*.2, 80); fournisseur.
			 * setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light "
			 * ); ImageView fournisseurIcon = new ImageView(new Image(new
			 * FileInputStream("src/ProjetJavaPharmacie/imagesJava/fournisseur.png")));
			 * fournisseurIcon.setFitHeight(37); fournisseurIcon.setFitWidth(50);
			 * fournisseur.setGraphic(fournisseurIcon);
			 * fournisseur.setContentDisplay(ContentDisplay.TOP);
			 * 
			 * livraison = new Button("Livraison"); livraison.setPadding(new
			 * Insets(0,0,150,0)); livraison.setPrefSize(width*.2, 80); livraison.
			 * setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light "
			 * ); ImageView livraisonIcon = new ImageView(new Image(new
			 * FileInputStream("src/ProjetJavaPharmacie/imagesJava/livraison.png")));
			 * livraisonIcon.setFitHeight(52); livraisonIcon.setFitWidth(62);
			 * livraison.setGraphic(livraisonIcon);
			 * livraison.setContentDisplay(ContentDisplay.TOP);
			 * 
			 * 
			 * 
			 * 
			 * intro.getChildren().addAll(accueil,stock,fournisseur,livraison);
			 *//***********************/

			HBox frameButtons = new HBox(10);
			frameButtons.setAlignment(Pos.CENTER_RIGHT);
			frameButtons.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));

			Hyperlink exitButton = new Hyperlink("x");
			exitButton.setPadding(new Insets(0, 20, 0, 0));
			exitButton.setStyle(
					"-fx-text-fill: #b8b3ad;-fx-border-color: transparent;-fx-underline: false;-fx-font-size: 18px;-fx-font-weight: bold;");

			frameButtons.getChildren().add(exitButton);

			exitButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Platform.exit();
				}
			});

			BorderPane Contenu = new BorderPane();
			Contenu.setPadding(new Insets(100, 0, 50, 100));
			Contenu.setPrefSize(width * .8, height);
			Contenu.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));

			/*
			 * TextField search = new TextField(); search.setPromptText("Recherche");
			 * search.
			 * setStyle("-fx-background-color: #333333;-fx-text-fill: white; -fx-font-size: 16px;"
			 * );
			 * 
			 * search.setMaxWidth(990); Contenu.setTop(search);
			 * 
			 * TableView tableView = new TableView(); tableView.setMaxSize(900, 400);
			 * TableColumn<Medicament, String> medicamentId = new
			 * TableColumn<>("Ref Medicament"); TableColumn<Medicament, String> label = new
			 * TableColumn<>("Label"); TableColumn<Medicament, String> qte = new
			 * TableColumn<>("Quantité"); TableColumn<Medicament, String> prix = new
			 * TableColumn<>("Prix");
			 * 
			 * tableView.getColumns().addAll(medicamentId,label,qte,prix);
			 * 
			 * tableView.getItems().add( new Medicament("007", "Gripex"));
			 * tableView.getItems().add( new Medicament("006", "Panadol"));
			 * tableView.getItems().add( new Medicament("008", "Vitamine C")); ////// button
			 * stock Contenu.setCenter(tableView); Contenu.setAlignment(tableView,
			 * Pos.TOP_LEFT); Contenu.setMargin(tableView, new Insets(120,0,0,0));
			 */

			/*
			 * bestSeller = new Button("Best-seller"); bestSeller.setPadding(new
			 * Insets(10,30,10,30)); bestSeller.
			 * setStyle("-fx-background-color: #b98b56;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold "
			 * );
			 * 
			 * finStock = new Button("Fin stock"); finStock.setPadding(new
			 * Insets(10,30,10,30)); finStock.
			 * setStyle("-fx-background-color: #b98b56;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold "
			 * );
			 * 
			 * perime = new Button("Périmé"); perime.setPadding(new Insets(10,30,10,30));
			 * perime.
			 * setStyle("-fx-background-color: #b98b56;-fx-text-fill: #303030;-fx-font-size: 20px;-fx-font-weight: bold "
			 * );
			 * 
			 * // stickers button stock VBox stickers = new VBox(10);
			 * stickers.setAlignment(Pos.CENTER_RIGHT); stickers.setBackground(new
			 * Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
			 * stickers.getChildren().addAll(bestSeller,finStock,perime);
			 */

			// button stock

			Button menuButton = new Button();
			menuButton.setPrefSize(40, 40);
			menuButton.setStyle(
					"-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
			ImageView menuButtonIcon = new ImageView(
					new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/menu.png")));
			menuButtonIcon.setFitHeight(40);
			menuButtonIcon.setFitWidth(40);
			menuButton.setGraphic(menuButtonIcon);

			HBox menuBox = new HBox(10);
			menuBox.setAlignment(Pos.CENTER_RIGHT);
			// menuBox.setBackground(new Background(new
			// BackgroundFill(Color.valueOf("#272727"), null, null)));
			menuBox.setStyle("-fx-background-color: transparent ; ");

			menuBox.getChildren().add(menuButton);

			menuButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					if (n == 0) {
						System.out.println(n);
						miniMenu.translateXProperty().set(0);
						Timeline timeline = new Timeline();
						KeyValue kv = new KeyValue(miniMenu.translateXProperty(), miniMenu.getWidth(),
								Interpolator.EASE_IN);
						KeyFrame kf = new KeyFrame(Duration.seconds(.3), kv);
						timeline.getKeyFrames().add(kf);
						timeline.play();
						n++;
					} else {
						System.out.println(n);
						// miniMenu.translateXProperty().set(0);
						Timeline timeline = new Timeline();
						KeyValue kv = new KeyValue(miniMenu.translateXProperty(), 0, Interpolator.EASE_IN);
						KeyFrame kf = new KeyFrame(Duration.seconds(.3), kv);
						timeline.getKeyFrames().add(kf);
						timeline.play();
						n--;
						return;
					}

				}
			});

			addButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					updateAdd(null, root);

					Timeline timeline = new Timeline();
					KeyValue kv = new KeyValue(miniMenu.translateXProperty(), 0, Interpolator.EASE_IN);
					KeyFrame kf = new KeyFrame(Duration.seconds(.3), kv);
					timeline.getKeyFrames().add(kf);
					timeline.play();
					n--;
				}
			});

			editButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					updateMod(null, root);

					Timeline timeline = new Timeline();
					KeyValue kv = new KeyValue(miniMenu.translateXProperty(), 0, Interpolator.EASE_IN);
					KeyFrame kf = new KeyFrame(Duration.seconds(.3), kv);
					timeline.getKeyFrames().add(kf);
					timeline.play();
					n--;
				}
			});

			deleteButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					updateDel(null, root);

					Timeline timeline = new Timeline();
					KeyValue kv = new KeyValue(miniMenu.translateXProperty(), 0, Interpolator.EASE_IN);
					KeyFrame kf = new KeyFrame(Duration.seconds(.3), kv);
					timeline.getKeyFrames().add(kf);
					timeline.play();
					n--;
				}
			});

			VBox rightFrame = new VBox();
			rightFrame.setPrefSize(width * .8, height);
			rightFrame.getChildren().addAll(frameButtons, Contenu);
			// button stock
			intro.getChildren().add(menuBox);

			leftFrame.getChildren().addAll(miniMenu, intro);
			// leftFrame.getChildren().addAll(intro,miniMenu);
			root.setRight(rightFrame);
			root.setLeft(leftFrame);

			primaryStage.setScene(scene);
			primaryStage.show();

			/********************/
			menuButton.translateYProperty().set(170);
			Timeline timelineMenu = new Timeline();
			KeyValue kv = new KeyValue(menuButton.translateYProperty(), 0, Interpolator.EASE_IN);
			KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
			timelineMenu.getKeyFrames().add(kf);
			timelineMenu.play();

			accueil.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("wat");
					PageAdmin pa = new PageAdmin();
					Scene s = pa.getHomeScene();
					primaryStage.setScene(s);
					primaryStage.show();
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

	public class Medicament {
		public String id;
		public String label;

		public Medicament(String id, String label) {
			this.id = id;
			this.label = label;
		}

	}

	// @Override
	public void updateAdd(Observable o, Object arg) {
		Platform.runLater(new Runnable() {
			public void run() {
				new StockAdd3().start(new Stage());
			}
		});
	}

	public void updateMod(Observable o, Object arg) {
		Platform.runLater(new Runnable() {
			public void run() {
				new StockEdit().start(new Stage());
			}
		});
	}

	public void updateDel(Observable o, Object arg) {
		Platform.runLater(new Runnable() {
			public void run() {
				new StockDelete3().start(new Stage());
			}
		});
	}

	@Override
	public void stop() throws Exception {
		// System.out.println("stopped.");
		super.stop();
	}
}
