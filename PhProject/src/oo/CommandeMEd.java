package oo;

import java.sql.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class CommandeMEd {
	private  StringProperty id;
	private  StringProperty ph;
	private  StringProperty med ;
	private  StringProperty numf ;
	private  StringProperty prix ;
	private  StringProperty  datec ;
	private  StringProperty   datel ;
	private  StringProperty   quantite;
	public String geId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id); 
	}
	public String getPh() {
		return ph.get();
	}
	public void setPh(String ph) {
		this.ph.set(ph); 
	}
	public String getMed() {
		return med.get();
	}
	public void setMed(String med) {
		this.med.set(med); 
	}
	public String getNumf() {
		return numf.get();
	}
	public void setNumf(String numf) {
		this.numf.set(numf);
	}
	public String getPrix() {
		return prix.get();
	}
	public void setPrix(String prix) {
		this.prix.set(prix);
	}
	public String  getDatec() {
		return datec.get();
	}
	public void setDatec(String  datec) {
		this.datec.set(datec );
	}
	public String  getDatel() {
		return datel.get();
	}
	public void setDatel(String  datel) {
		this.datel.set(datel);;
	}
	public String getQauntite() {
		return quantite.get();
	}
	public void setQauntite(String qauntite) {
		this.quantite.set(qauntite);
	}
	public CommandeMEd(String id ,String ph, String med, String numf, String prix, String  datec, String  datel, String quantite) {
		super();
		this.id= new SimpleStringProperty(id);
		this.ph = new SimpleStringProperty(ph);
		this.med = new SimpleStringProperty(med);
		this.numf = new SimpleStringProperty(numf);
		this.prix = new SimpleStringProperty(prix);
		this.datec = new SimpleStringProperty(datec);
		this.datel = new SimpleStringProperty(datel);
		this.quantite = new SimpleStringProperty(quantite);
	}
	public CommandeMEd() {
		super();
	}
	
	 public StringProperty idProperty() { return this.id; }
	    public StringProperty phProperty() { return this.ph; }
	    public StringProperty medProperty() { return this.med; }
	    public StringProperty numfProperty() { return this.numf; }
	    public StringProperty prixProperty() { return this.prix; }
	    public StringProperty datecProperty() { return this.datec; }
	    public StringProperty datelProperty() { return this.datel; }
	    public StringProperty quantiteProperty() { return this.quantite; }
	
	
	
	
	
	

}
