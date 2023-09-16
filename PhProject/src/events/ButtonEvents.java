package events;

import java.sql.SQLException;

import application.AdminWorkPlace;
import application.ClientWorkPlace;
import application.Main;
import dao.ClientDAO;
import dao.PharmacieDAO;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import oo.Client;
import oo.Pharmacie;

public class ButtonEvents  implements EventHandler {
	Main main ;
	

	public ButtonEvents(Main m ) {
		this.main=m  ;
		
	}

	@Override
	public void handle(javafx.event.Event e  ) {
		//login ph or clien 
		 if (main.login==e.getSource())
		 { 
		
		 String  mpass  =  (String)main.passwordField.getText();
		 
		 
		 if((Character.compare(mpass.charAt(0),'p')==0) && (Character.compare(mpass.charAt(1),'h')==0))
		 {
		 
		 System.out.print(" this is an admin \n  ");
			 try {
			   Pharmacie ph = PharmacieDAO.getPharmacieFromNum(mpass);
			   System.out.print(" 1 \n  ");
			   System.out.print(ph.toString());
			   System.out.print(" 2 \n  ");
			   Pharmacie.setSelectedPharmacie(ph);
			   main.stage.setScene(AdminWorkPlace.getScene());
			   
			} catch (ClassNotFoundException  | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.print(e1.getMessage());
				
			}
			 
		 }
		 else {
			 System.out.print(" it s a client   ");
				
				try {
					 ClientDAO.getClientbympass(mpass);
					 
					 System.out.print("gett client buttoon ");
				
				 System.out.print("gett client buttoon ");
				 main.stage.setScene(ClientWorkPlace.getScene());
				 System.out.print("gett client buttoon ");
				} catch (Exception e2) {
					// TODO: handle exception
				}
				 
		 }
		 
	}
		 //create new ph 
		 if  (main.confirmerAdmin==e.getSource())
		 { System.out.print(" confirm admin  button ");
		 
		 if  (main.confirmerClient==e.getSource()){
			
			 System.out.print("confirm client  button ");
			 }
		
		
	}

	}}
