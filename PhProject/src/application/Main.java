package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;

import java.io.FileInputStream;
import java.sql.SQLException;

import dao.ClientDAO;
import dao.PharmacieDAO;
import events.ButtonEvents;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import oo.Client;
import oo.Pharmacie;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


 public class Main extends Application {
 

	double xOffset, yOffset;
	public Button confirmerAdmin, confirmerClient;
	public Button login;
	public  static Stage stage;
	public int width = 1100;
	public int height = 700;
	public PasswordField passwordField ;
	public TextField  emailField ;
	public static String css ;
	
	@Override
	public void start(Stage primaryStage) {
           
		try {
			
			this.stage = primaryStage;
			// primaryStage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(false);
			BorderPane root = new BorderPane();

			int toolBarHeight = 20;
			Scene scene = new Scene(root, width, height);
			css =this.getClass().getResource("style.css").toExternalForm();
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

			StackPane introStack = new StackPane();

			VBox intro = new VBox();
			intro.setPrefSize(width / 2, height);
			intro.setBackground(new Background(new BackgroundFill(Color.valueOf("#b98b56"), null, null)));
			intro.setAlignment(Pos.CENTER);
			// logoo

			Image logo = new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/Logo.png"));
			ImageView logoView = new ImageView(logo);
			/*
			 * Button logobutton = new Button(); logobutton.setGraphic(logoView);
			 */
			Label welcome = new Label("BIENVENUE A");
			welcome.setFont(Font.font("", FontWeight.MEDIUM, 18));

			Label companyName = new Label("SHIFA");
			companyName.setFont(Font.font("", FontWeight.BOLD, 42));

			intro.getChildren().addAll(logoView, welcome, companyName);

			/************************************/

			VBox leftFrame1 = new VBox();
			leftFrame1.setPrefSize(width / 2, height);

			HBox frameButtonsLeft = new HBox(10);
			frameButtonsLeft.setAlignment(Pos.CENTER_RIGHT);
			frameButtonsLeft.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));

			Hyperlink exitButtonLeft = new Hyperlink("x");
			exitButtonLeft.setPadding(new Insets(0, 18, 0, 0));
			exitButtonLeft.setStyle(
					"-fx-text-fill: #b8b3ad;"
					+ "-fx-border-color: transparent;"
					+ "-fx-underline: false;"
					+ "-fx-font-size: 18px;"
					+ "-fx-font-weight: bold;");

			Hyperlink backButtonLeft = new Hyperlink("<");
			backButtonLeft.setPadding(new Insets(0, 18, 0, 0));
			backButtonLeft.setStyle(
					"-fx-text-fill: #b8b3ad;"
					+ "-fx-border-color: transparent;"
					+ "-fx-underline: false;"
					+ "-fx-font-size: 18px;"
					+ "-fx-font-weight: bold;");

			frameButtonsLeft.getChildren().addAll(backButtonLeft, exitButtonLeft);

			exitButtonLeft.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Platform.exit();
				}
			});

			backButtonLeft.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("Hello2");
					intro.translateXProperty().set(intro.getWidth());
					Timeline timeline = new Timeline();
					KeyValue kv = new KeyValue(intro.translateXProperty(), 0, Interpolator.EASE_IN);
					KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
					timeline.getKeyFrames().add(kf);
					timeline.play();

				}
			});

			VBox users = new VBox(30);
			users.setPrefSize(width / 2, height);
			users.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
			users.setAlignment(Pos.CENTER);

			Button admin = new Button("Admin");
			admin.setPrefSize(200, 200);
			admin.setStyle(
					"-fx-background-color: transparent;"
					+ "-fx-text-fill: #c7b7a7;"
					+ "-fx-font-size: 16px;"
					);
			ImageView adminIcon = new ImageView(
					new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/Admin.png")));
			adminIcon.setFitHeight(100);
			adminIcon.setFitWidth(100);
			admin.setGraphic(adminIcon);
			admin.setContentDisplay(ContentDisplay.TOP);

			Label sep = new Label("_____________");
			sep.setStyle("-fx-font-size: 35px;-fx-font-weigh: BOLD");

			Button client = new Button("Client");
			client.setPrefSize(200, 200);
			client.setStyle(
					"-fx-background-color: transparent;"
					+ "-fx-text-fill: #c7b7a7;"
					+ "-fx-font-size: 16px;"
					);
			ImageView clientIcon = new ImageView(
					new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/Client.png")));
			clientIcon.setFitHeight(100);
			clientIcon.setFitWidth(100);
			client.setGraphic(clientIcon);
			client.setContentDisplay(ContentDisplay.TOP);

			users.getChildren().addAll(admin, sep, client);

			leftFrame1.getChildren().addAll(frameButtonsLeft, users);

			// introStack.getChildren().addAll(leftFrame1,intro);

			/*************************************************************/

			VBox leftFrame2 = new VBox();
			leftFrame2.setPrefSize(width / 2, height);

			HBox frameButtonsLeft2 = new HBox(10);
			frameButtonsLeft2.setAlignment(Pos.CENTER_RIGHT);
			frameButtonsLeft2.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));

			Hyperlink exitButtonLeft2 = new Hyperlink("x");
			exitButtonLeft2.setPadding(new Insets(0, 18, 0, 0));
			exitButtonLeft2.setStyle(
					"-fx-text-fill: #b8b3ad;"
					+ "-fx-border-color: transparent;"
					+ "-fx-underline: false;"
					+ "-fx-font-size: 18px;"
					+ "-fx-font-weight: bold;");

			Hyperlink backButtonLeft2 = new Hyperlink("<");
			backButtonLeft2.setPadding(new Insets(0, 18, 0, 0));
			backButtonLeft2.setStyle(
					"-fx-text-fill: #b8b3ad;"
					+ "-fx-border-color: transparent;"
					+ "-fx-underline: false;"
					+ "-fx-font-size: 18px;"
					+ "-fx-font-weight: bold;");

			frameButtonsLeft2.getChildren().addAll(backButtonLeft2, exitButtonLeft2);

			exitButtonLeft2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Platform.exit();
				}
			});

			backButtonLeft2.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("Hello3");
					// intro.translateXProperty().set(intro.getWidth());
					Timeline timeline = new Timeline();
					KeyValue kv = new KeyValue(leftFrame1.translateXProperty(), 0, Interpolator.EASE_IN);
					KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
					timeline.getKeyFrames().add(kf);
					timeline.play();

				}
			});

			// admin create acount
			VBox adminBox = new VBox(15);
			adminBox.setPadding(new Insets(0, 70, 10, 70));
			adminBox.setPrefSize(width / 2, height);
			adminBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));

			Label bonjourAdmin = new Label("Créez votre compte,");
			bonjourAdmin.setFont(Font.font("", FontWeight.MEDIUM, 43));
			bonjourAdmin.setTextFill(Color.valueOf("#e6e0d8"));
			bonjourAdmin.setPadding(new Insets(15, 0, 0, 0));

			Label adminTitre = new Label("Admin ");
			adminTitre.setFont(Font.font("", FontWeight.BOLD, 25));
			adminTitre.setTextFill(Color.valueOf("#e6e0d8"));
			adminTitre.setPadding(new Insets(15, 0, 0, 0));

			TextField adminCin = new TextField();
			adminCin.setPromptText("Ncin");
			adminCin.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");

			PasswordField numPh = new PasswordField();
			numPh.setPromptText("numPharmacie");
			numPh.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");

			Label pharmTitre = new Label("Pharmacie");
			pharmTitre.setFont(Font.font("", FontWeight.BOLD, 25));
			pharmTitre.setTextFill(Color.valueOf("#e6e0d8"));
			pharmTitre.setPadding(new Insets(15, 0, 0, 0));

			TextField nomphField = new TextField();
			nomphField.setPromptText("Nom");
			nomphField.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");

			TextField adresseField = new TextField();
			adresseField.setPromptText("Adresse");
			adresseField.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");

			TextField contactField = new TextField();
			contactField.setPromptText("Contact");
			contactField.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");

			TextField typephField = new TextField();
			typephField.setPromptText("Type");
			typephField.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");
			
			TextField horaire = new TextField();
			horaire.setPromptText(" numero de 1 a 7  jour de travail ");
			horaire.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");

			VBox SignUpBoxAdmin = new VBox();
			SignUpBoxAdmin.setAlignment(Pos.CENTER);
			SignUpBoxAdmin.setPadding(new Insets(20, 50, 50, 50));
			// add new ph acount to the db and oppen ph acount
			confirmerAdmin = new Button("Confirmer");
			confirmerAdmin.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					Pharmacie p=new Pharmacie(
							numPh.getText(),
							nomphField.getText(),
							adresseField.getText()	,
							contactField.getText(),
							typephField.getText(), 
							horaire.getText());
					try {
						PharmacieDAO.insertPharmacie(p);
						Pharmacie.setSelectedPharmacie(p);
						   Main.stage.setScene(AdminWorkPlace.getScene());

					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
							
							
							
							
					}
				});
			
			//confirmerAdmin.setOnAction();
			confirmerAdmin.setPadding(new Insets(18, 50, 22, 50));
			confirmerAdmin.setStyle(
					"-fx-background-color: #b98b56;"
					+ "-fx-text-fill: #303030;"
					+ "-fx-font-size: 20px;"
					+ "-fx-font-weight: bold ");

			SignUpBoxAdmin.getChildren().addAll(confirmerAdmin);

			adminBox.getChildren().addAll(bonjourAdmin, adminTitre, adminCin);
			adminBox.getChildren().addAll( pharmTitre,numPh, nomphField, adresseField, contactField, typephField, horaire);
			adminBox.getChildren().add(SignUpBoxAdmin);

			leftFrame2.getChildren().addAll(frameButtonsLeft2, adminBox);

			// introStack.getChildren().addAll(leftFrame2,leftFrame1,intro);

			/****************************** CLIENT **************************/

			VBox leftFrame3 = new VBox();
			leftFrame3.setPrefSize(width / 2, height);

			HBox frameButtonsLeft3 = new HBox(10);
			frameButtonsLeft3.setAlignment(Pos.CENTER_RIGHT);
			frameButtonsLeft3.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));

			Hyperlink exitButtonLeft3 = new Hyperlink("x");
			exitButtonLeft3.setPadding(new Insets(0, 18, 0, 0));
			exitButtonLeft3.setStyle(
					"-fx-text-fill: #b8b3ad;"
					+ "-fx-border-color: transparent;"
					+ "-fx-underline: false;"
					+ "-fx-font-size: 18px;"
					+ "-fx-font-weight: bold;");

			Hyperlink backButtonLeft3 = new Hyperlink("<");
			backButtonLeft3.setPadding(new Insets(0, 18, 0, 0));
			backButtonLeft3.setStyle(
					"-fx-text-fill: #b8b3ad;"
					+ "-fx-border-color: transparent;"
					+ "-fx-underline: false;"
					+ "-fx-font-size: 18px;"
					+ "-fx-font-weight: bold;");

			frameButtonsLeft3.getChildren().addAll(backButtonLeft3, exitButtonLeft3);

			exitButtonLeft3.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Platform.exit();
				}
			});

			backButtonLeft3.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("Hello4");

					Timeline timeline = new Timeline();
					KeyValue kv = new KeyValue(leftFrame1.translateXProperty(), 0, Interpolator.EASE_IN);
					KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
					timeline.getKeyFrames().add(kf);
					timeline.play();

				}
			});
			// create new client acount
			VBox clientBox = new VBox(15);
			clientBox.setPadding(new Insets(0, 70, 10, 70));
			clientBox.setPrefSize(width / 2, height);
			clientBox.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));
			// clientBox.setAlignment(Pos.CENTER_LEFT);

			clientBox.getChildren().add(frameButtonsLeft3);

			Label bonjourClient = new Label("Créez votre compte,");
			bonjourClient.setFont(Font.font("", FontWeight.MEDIUM, 43));
			bonjourClient.setTextFill(Color.valueOf("#e6e0d8"));
			bonjourClient.setPadding(new Insets(15, 0, 0, 0));

			Label clientTitre = new Label("Client ");
			clientTitre.setFont(Font.font("", FontWeight.BOLD, 25));
			clientTitre.setTextFill(Color.valueOf("#e6e0d8"));
			clientTitre.setPadding(new Insets(15, 0, 0, 0));

			TextField cinClient = new TextField();
			cinClient.setPromptText(" numero cin ");
			cinClient.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");
			TextField emailFieldClient = new TextField();
			emailFieldClient.setPromptText("E-mail");
			emailFieldClient.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");

			PasswordField passwordFieldClient = new PasswordField();
			passwordFieldClient.setPromptText("Mot de passe");
			passwordFieldClient.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");

			TextField adresseFieldClient = new TextField();
			adresseFieldClient.setPromptText("Adresse");
			adresseFieldClient.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");

			TextField nomClient = new TextField();
			nomClient.setPromptText("Contact");
			nomClient.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");
			TextField prenomClient = new TextField();
			prenomClient.setPromptText("Contact");
			prenomClient.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");

			VBox SignUpBoxClient = new VBox();
			SignUpBoxClient.setAlignment(Pos.CENTER);
			SignUpBoxClient.setPadding(new Insets(20, 50, 50, 50));
// insert client acount into database  
			confirmerClient = new Button("Confirmer");
			confirmerClient.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
				Client p=new Client(
						cinClient.getText(),
						passwordFieldClient.getText(),
						emailFieldClient.getText()	,
						adresseFieldClient.getText(),
						nomClient.getText(),
						prenomClient.getText());
						
				try {
					ClientDAO.insertClient(p);
					Client.setSelecteClient(p);
					   Main.stage.setScene(AdminWorkPlace.getScene());

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
						
						
						
						
				}
			});
			//confirmerClient.setOnAction(new ButtonEvents(this));
			confirmerClient.setPadding(new Insets(18, 50, 22, 50));
			confirmerClient.setStyle(
					"-fx-background-color: #b98b56;"
					+ "-fx-text-fill: #303030;"
					+ "-fx-font-size: 20px;"
					+ "-fx-font-weight: bold ");

			SignUpBoxClient.getChildren().addAll(confirmerClient);

			clientBox.getChildren().addAll(bonjourClient, clientTitre, cinClient,passwordFieldClient,emailFieldClient);
			clientBox.getChildren().addAll(adresseFieldClient,nomClient,prenomClient );
			clientBox.getChildren().add(SignUpBoxClient);

			leftFrame3.getChildren().addAll(frameButtonsLeft3, clientBox);

			introStack.getChildren().addAll(leftFrame3, leftFrame2, leftFrame1, intro);

			/************************ Animation admin & client *************/
			// change interface to addmin registration
			admin.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					// intro.translateXProperty().set(intro.getWidth());
					introStack.getChildren().removeAll(leftFrame3, leftFrame2, leftFrame1, intro);
					introStack.getChildren().addAll(leftFrame2, leftFrame1, intro);

					Timeline timeline = new Timeline();
					KeyValue kv = new KeyValue(leftFrame1.translateXProperty(), width / 2, Interpolator.EASE_IN);
					KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
					timeline.getKeyFrames().add(kf);
					timeline.play();

				}
			});
			// change interface to register client
			client.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					// intro.translateXProperty().set(intro.getWidth());
					introStack.getChildren().removeAll(leftFrame3, leftFrame2, leftFrame1, intro);
					introStack.getChildren().addAll(leftFrame3, leftFrame1, intro);

					Timeline timeline = new Timeline();
					KeyValue kv = new KeyValue(leftFrame1.translateXProperty(), width / 2, Interpolator.EASE_IN);
					KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
					timeline.getKeyFrames().add(kf);
					timeline.play();

				}
			});

			/**************************************************************/
			HBox frameButtons = new HBox(10);
			frameButtons.setAlignment(Pos.CENTER_RIGHT);
			frameButtons.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));

			Hyperlink exitButton = new Hyperlink("x");
			exitButton.setPadding(new Insets(0, 18, 0, 0));
			exitButton.setStyle(
					"-fx-text-fill: #b8b3ad;"
					+ "-fx-border-color: transparent;"
					+ "-fx-underline: false;"
					+ "-fx-font-size: 18px;"
					+ "-fx-font-weight: bold;");

			frameButtons.getChildren().add(exitButton);

			exitButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Platform.exit();
				}
			});
			// get connection either client or admin

			VBox ContenuRight = new VBox();
			ContenuRight.setPadding(new Insets(20, 50, 50, 50));
			ContenuRight.setPrefSize(width / 2, height);
			ContenuRight.setBackground(new Background(new BackgroundFill(Color.valueOf("#272727"), null, null)));

			// src/ProjetJavaPharmacie/imagesJava/

			Image logo2 = new Image(new FileInputStream("src/ProjetJavaPharmacie/imagesJava/Logo2.png"));
			ImageView logoView2 = new ImageView(logo2);

			logoView2.setFitHeight(94);
			logoView2.setFitWidth(150);

			Label bonjour = new Label("Bonjour,");
			bonjour.setFont(Font.font("", FontWeight.MEDIUM, 50));
			bonjour.setTextFill(Color.valueOf("#e6e0d8"));
			bonjour.setPadding(new Insets(15, 0, 0, 0));

			Label connecter = new Label("connectez-vous pour continuer");
			connecter.setFont(Font.font("", FontWeight.LIGHT, 16));
			connecter.setTextFill(Color.valueOf("#e6e0d8"));

			Label ncin = new Label("Ncin");
			ncin.setFont(Font.font("", FontWeight.MEDIUM, 22));
			ncin.setTextFill(Color.valueOf("#e6e0d8"));
			ncin.setPadding(new Insets(40, 0, 7, 0));

			 emailField = new TextField();
			emailField.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white;"
					+ " -fx-font-size: 16px;");

			Label password = new Label("Mot de passe");
			password.setFont(Font.font("", FontWeight.MEDIUM, 22));
			password.setTextFill(Color.valueOf("#e6e0d8"));
			password.setPadding(new Insets(23, 0, 7, 0));

			 passwordField = new PasswordField();
			passwordField.setStyle("-fx-background-color: #333333;"
					+ "-fx-text-fill: white; "
					+ "-fx-font-size: 16px;");

			Label forgotpassword = new Label("Mot de pass oublié ?");
			forgotpassword.setFont(Font.font("", FontWeight.LIGHT, 16));
			forgotpassword.setTextFill(Color.valueOf("#e6e0d8"));

			/******************/

			Hyperlink NouveauCompte = new Hyperlink("Créer nouveau compte");
			NouveauCompte.setStyle("-fx-text-fill: #b98b56");
			Text pasCompte = new Text("Vous n'avez pas de compte ? ");
			pasCompte.setFill(Color.valueOf("#e6e0d8"));

			VBox SignUpBox = new VBox();
			SignUpBox.setAlignment(Pos.CENTER);
			SignUpBox.setPadding(new Insets(30, 50, 50, 50));

			login = new Button("Se connecter");
			System.out.print("passord "+passwordField.getText());
			login.setOnAction(new ButtonEvents(this));
			try {
				// login.setOnAction( stage.setScene(PageAdmin2.scene));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			TextFlow SignUp = new TextFlow(pasCompte, NouveauCompte);

			login.setPadding(new Insets(18, 50, 22, 50));
			login.setStyle(
					"-fx-background-color: #b98b56;"
					+ "-fx-text-fill: #303030;"
					+ "-fx-font-size: 20px;"
					+ "-fx-font-weight: bold ");

			SignUp.setPadding(new Insets(14, 0, 0, 0));

			

			NouveauCompte.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println(passwordField.getText());
					intro.translateXProperty().set(0);
					Timeline timeline = new Timeline();
					KeyValue kv = new KeyValue(intro.translateXProperty(), intro.getWidth(), Interpolator.EASE_IN);
					KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
					timeline.getKeyFrames().add(kf);
					timeline.play();

				}
			});

			// ContenuRight.setAlignment(Pos.CENTER);
			ContenuRight.getChildren().addAll(logoView2, bonjour, connecter);
			ContenuRight.getChildren().addAll(password, passwordField, forgotpassword);

			SignUpBox.getChildren().addAll(login, SignUp);
			ContenuRight.getChildren().add(SignUpBox);

			VBox rightFrame = new VBox();
			rightFrame.setPrefSize(width / 2, height);
			rightFrame.getChildren().addAll(frameButtons, ContenuRight);

			root.setRight(rightFrame);
			root.setLeft(introStack);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		launch(args);
	}

	@Override
	public void stop() throws Exception {
		// System.out.println("stopped.");
		super.stop();
	}
}

