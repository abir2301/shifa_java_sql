package events;

import application.AdminWorkPlace;
import application.ClientWorkPlace;
import application.ClientWorkPlace;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import models.AcceulModel;
import models.ClientAcceilModel;
import models.FounisseurModel;

public class ClientAction  implements EventHandler {

	@Override
	public void handle(javafx.event.Event e ) {
		if(ClientWorkPlace.accueil==e.getSource())
		{
			System.out.print("acceil ");
			ClientWorkPlace.Contenu.getChildren().removeAll(ClientWorkPlace.Contenu.getChildren());
			ClientWorkPlace.searchBox.getChildren().removeAll(ClientWorkPlace.searchBox.getChildren());

	    
			ClientWorkPlace.accueil.setStyle("-fx-background-color: rgba(0, 100, 100, 0.3);-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light ");
			
			ClientWorkPlace.commande.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
           ClientWorkPlace.searchBox.setAlignment(Pos.TOP_CENTER);
           ClientWorkPlace.searchBox.getChildren().add(ClientAcceilModel.getSerchBox());
           ClientWorkPlace.searchBox.setAlignment(Pos.TOP_CENTER);
           ClientWorkPlace.searchBox.getChildren().add(ClientAcceilModel.getFilters());

		  ClientWorkPlace.Contenu.setTop(ClientAcceilModel.getAllMedContent());
			
			
			

		}
		
		if (ClientWorkPlace.commande==e.getSource())
		{
			System.out.print("acommande ");
			ClientWorkPlace.Contenu.getChildren().removeAll(ClientWorkPlace.Contenu.getChildren());
			ClientWorkPlace.searchBox.getChildren().removeAll(ClientWorkPlace.searchBox.getChildren());
		

    
		  ClientWorkPlace.commande.setStyle("-fx-background-color: rgba(0, 100, 100, 0.3);-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light ");
		  
		  ClientWorkPlace.accueil.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
		  ClientWorkPlace.Contenu.setTop(ClientAcceilModel.getAllCommandeClient());
		  
          ClientWorkPlace.searchBox.setAlignment(Pos.TOP_CENTER);
          ClientWorkPlace.searchBox.getChildren().add(ClientAcceilModel.message());
		  ClientWorkPlace.Contenu.setBottom(ClientAcceilModel.createCommandeClient());
		  ClientWorkPlace.Contenu.setMargin(ClientAcceilModel.createCommandeClient(), new Insets(10, 10, 10, 50));

		}
			
		
		}}
