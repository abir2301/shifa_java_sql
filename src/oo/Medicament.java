package oo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medicament {
	private  StringProperty idmed ;
	  private  StringProperty nom ;
	  private  StringProperty description ;
	  private  StringProperty marque ;
	  private  StringProperty type ;
	public String getIdmed() {
		return idmed.get();
	}
	public void setIdmed(String idmed) {
		this.idmed.set(idmed);
	}
	public String getNom() {
		return nom.get();
	}
	public void setNom(String nom) {
		this.nom.set(nom);
	}
	public String getDescription() {
		return description.get();
	}
	public void setDescription(String description) {
		this.description.set(description);
	}
	public String getMarque() {
		return marque.get();
	}
	public void setMarque(String marque) {
		this.marque.set(marque);}
	
	public String getType() {
		return type.get();
	}
	public void setType(String type) {
		this.type.set(type);
	}
	public Medicament(String idmed, String nom, String description, String marque, String type) {
		super();
		this.idmed =  new SimpleStringProperty(idmed);
		this.nom = new SimpleStringProperty(nom);
		this.description = new SimpleStringProperty(description );
		this.marque = new SimpleStringProperty(marque);
		this.type =new SimpleStringProperty(type);
	}
	 public StringProperty idProperty() { return this.idmed; }
	    public StringProperty nomProperty() { return this.nom; }
	    public StringProperty descriptionProperty() { return this.description; }
	    public StringProperty marqueProperty() { return this.marque; }
	    public StringProperty typeProperty() { return this.type; }
	  
	
	public Medicament() {
		super();
	}
	
}
