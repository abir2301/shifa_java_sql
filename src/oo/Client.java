package oo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
	
	public   StringProperty  ncin;
	  public   StringProperty mpass ;
	public   StringProperty email ;
	  public  StringProperty adresse ;
	  public   StringProperty nom ;
	  public   StringProperty prenom ;
	private static  Client selecteClient;
	
	public Client() {
		super();
	}
	  public StringProperty ncinProperty() { return this.ncin; }
	    public StringProperty mpassProperty() { return this.mpass; }
	    public StringProperty emailProperty() { return this.email; }
	    public StringProperty eadresseProperty() { return this.adresse; }
	    public StringProperty nomProperty() { return this.nom; }
	    public StringProperty prenomProperty() { return this.prenom; }

	    
	public Client(String ncin, String mpass, String email , String adresse , String nom , String prenom ) {
		super();
		this.ncin =  new SimpleStringProperty(ncin);
		this.mpass = new SimpleStringProperty(mpass) ;
		this.email =  new SimpleStringProperty(email);
		this.adresse =  new SimpleStringProperty(adresse);
		this.nom =  new SimpleStringProperty(nom);
		this.prenom =  new SimpleStringProperty(prenom);
	}
	public String getNcin() {
		return ncin.get();
	}
	public void setNcin(String ncin) {
		this.ncin.set(ncin);
	}
	public String getMpass() {
		return mpass.get();
	}
	public void setMpass(String mpass) {
		this.mpass.set(mpass);
	}
	public String getEmail() {
		return email.get();
	}
	public void setAdresse(String adresse) {
		this.adresse.set(adresse);
	}
	public String getAdresse() {
		return adresse.get();
	}
	public void setEmail(String email) {
		this.email.set(email);
		
	}
	public String getNom() {
		return nom.get();
	}
	public void setNom(String  nom) {
		this.nom.set(nom);;
	}
	public String getPrenom() {
		return prenom.get();
	}
	public void setPrenom(String prenon) {
		this.prenom.set(prenon);
	}
	public static void setSelecteClient(Client selecteClient) {
		Client.selecteClient = selecteClient;
	}
	public static Client getSelecteClient() {
		 return Client.selecteClient ;
	}
	
}