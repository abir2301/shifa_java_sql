package oo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pharmacie {
	
	
	private static Pharmacie selectedPharmacie  ;
  public static Pharmacie getSelectedPharmacie() {
		return selectedPharmacie;
	}
   
   
	public static void setSelectedPharmacie(Pharmacie selectedPharmacie) {
		Pharmacie.selectedPharmacie = selectedPharmacie;
	}
private  StringProperty numNational ;
  private  StringProperty  nom ;
  private  StringProperty adresse  ;
  private  StringProperty numtel  ;
  private  StringProperty type ;
  private   StringProperty  jour  ;
  
  public StringProperty numProperty() { return this.numNational; }
  public StringProperty nomProperty() { return this.nom; }
  public StringProperty adresseProperty() { return this.adresse; }
  public StringProperty contactProperty() { return this.numtel; }
  public StringProperty typeProperty() { return this.type; }
  public StringProperty jourProperty() { return this.jour; }


  
public Pharmacie(String numNational, String nom, String adresse, String numtel, String type, String jour) {
	super();
	this.numNational =  new SimpleStringProperty(numNational);
	this.nom =  new SimpleStringProperty(nom);
	this.adresse = new SimpleStringProperty( adresse);
	this.numtel =  new SimpleStringProperty(numtel);
	this.type =  new SimpleStringProperty(type);
	this.jour =  new SimpleStringProperty(jour);
}


public Pharmacie() {
	super();
}


public String getNumNational() {
	return numNational.get();
}


public void setNumNational(String numNational) {
	this.numNational .set(numNational);
}


public String getNom() {
	return nom.get();
}


public void setNom(String nom) {
	this.nom.set(nom);
}


public String getAdresse() {
	return adresse.get();
}


public void setAdresse(String adresse) {
	this.adresse.set(adresse);
}


public String getNumtel() {
	return numtel.get();
}


public void setNumtel(String numtel) {
	this.numtel .set(numtel);
}


public String getType() {
	return type.get();
}


public void setType(String type) {
	this.type.set(type);
}


public String getJour() {
	return jour.get();
}


public void setJour( String  jour) {
	this.jour.set(jour );
}
 

  
	
	
}
