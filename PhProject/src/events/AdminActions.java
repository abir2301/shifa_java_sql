package events;

import application.AdminWorkPlace;
import application.PageStock;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import models.AcceulModel;
import models.FounisseurModel;
import models.StockModel;

public class AdminActions  implements EventHandler  {
	
@Override
public void handle(javafx.event.Event e ) {
	if(AdminWorkPlace.accueil==e.getSource())
	{
		//remove all centent 
		AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
		AdminWorkPlace.searchBox.getChildren().removeAll(AdminWorkPlace.searchBox.getChildren());
       // change buttons state 
		AdminWorkPlace.accueil.setStyle("-fx-background-color: rgba(0, 100, 100, 0.3);-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light ");
		AdminWorkPlace.stock.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
		AdminWorkPlace.fournisseur.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
		//set new elements 
		AdminWorkPlace.searchBox.setAlignment(Pos.TOP_CENTER);
		AdminWorkPlace.searchBox.getChildren().add(AcceulModel.getSerchBox());
		AdminWorkPlace.searchBox.setAlignment(Pos.TOP_CENTER);
		AdminWorkPlace.searchBox.getChildren().add(AcceulModel.getfilterGroupe());
		//AdminWorkPlace.searchBox.setMargin(AcceulModel.getfilterGroupe(),  new Insets(10, 1180, 10, 110) );
		
		AdminWorkPlace.Contenu.setCenter(AcceulModel.getContenue());
		
		
		
	}
	else {
	if (AdminWorkPlace.stock==e.getSource())
	{
		System.out.print("stock ");
		//remove all content 
		AdminWorkPlace.searchBox.getChildren().removeAll(AdminWorkPlace.searchBox.getChildren());
		AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
	 // change buttons state 
		AdminWorkPlace.Contenu.getChildren().addAll(AcceulModel.getContenue());
		AdminWorkPlace.accueil.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
		AdminWorkPlace.fournisseur.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
	    AdminWorkPlace.stock.setStyle("-fx-background-color: rgba(0, 100, 100, 0.3);-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light ");
		//set new elements
	    
	    AdminWorkPlace.Contenu.setRight(StockModel.getStickers());
	    AdminWorkPlace.searchBox.setAlignment(Pos.TOP_CENTER);
		AdminWorkPlace.searchBox.getChildren().add(StockModel.getSerchBox());
		AdminWorkPlace.searchBox.setAlignment(Pos.TOP_CENTER);
		AdminWorkPlace.searchBox.getChildren().add(StockModel.getfilterGroupe());
		AdminWorkPlace.Contenu.setBottom(StockModel.getMiniMenue());
		BorderPane.setAlignment(StockModel.getMiniMenue(), Pos.TOP_RIGHT);
		BorderPane.setMargin(StockModel.getMiniMenue(), new Insets(10, 10, 10, 10));

		AdminWorkPlace.Contenu.setCenter(StockModel.getAllContenuestock());
		//AdminWorkPlace.searchBox.setMargin(AcceulModel.getfilterGroupe(),  new Insets(10, 1180, 10, 110) );
	//AdminWorkPlace.Contenu.setCenter(StockModel.getAllContenuestock());
  
		
		
	}
	else 
		//remove all content 
	{   AdminWorkPlace.Contenu.getChildren().removeAll(AdminWorkPlace.Contenu.getChildren());
	    AdminWorkPlace.searchBox.getChildren().removeAll(AdminWorkPlace.searchBox.getChildren());
	    // change buttons state 
		AdminWorkPlace.accueil.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
		AdminWorkPlace.stock.setStyle("-fx-background-color: transparent;-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light");
	    AdminWorkPlace.fournisseur.setStyle("-fx-background-color: rgba(0, 100, 100, 0.3);-fx-text-fill: #c7b7a7;-fx-font-size: 16px;-fx-font-weight: light ");
	    //add new elements 
	    AdminWorkPlace.searchBox.setAlignment(Pos.TOP_CENTER);
		AdminWorkPlace.searchBox.getChildren().add(FounisseurModel.getSerchBox());
		AdminWorkPlace.searchBox.setAlignment(Pos.TOP_CENTER);
		AdminWorkPlace.searchBox.getChildren().add(FounisseurModel.getfilterGroupe());
		AdminWorkPlace.Contenu.setCenter(FounisseurModel.getAllContenue());
		AdminWorkPlace.Contenu.setBottom(FounisseurModel.createCommandeMed());
		AdminWorkPlace.Contenu.setMargin(FounisseurModel.createCommandeMed(), new Insets(10, 10, 10, 50));

		//BorderPane.setAlignment(FounisseurModel.creation, Pos.TOP_RIGHT);
	    
	}
	
	
}}
	
}
