package oo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fournisseur {

	private  StringProperty num;
	  private  StringProperty nomf ;
	  private  StringProperty adresse ;
	  private  StringProperty numtel ;
	public String getNum() {
		return num.get();
	}
	public void setNum(String num) {
		this.num.set(num);;
	}
	public String getNomf() {
		return nomf.get();
	}
	public void setNomf(String nomf) {
		this.nomf.set(nomf);;
	}
	public String getAdresse() {
		return adresse.get();
	}
	public void setAdresse(String adresse) {
		this.adresse.set(adresse);;
	}
	public String getNumtel() {
		return numtel.get();
	}
	public void setNumtel(String numtel) {
		this.numtel.set(numtel);
	}
	public StringProperty numProperty() { return this.num; }
    public StringProperty nomfProperty() { return this.nomf; }
    public StringProperty adresseProperty() { return this.adresse; }
    public StringProperty numtelProperty() { return this.numtel; }
  

	public Fournisseur(String num, String nomf, String adresse, String numtel) {
		super();
		this.num =  new SimpleStringProperty(num);
		this.nomf =  new SimpleStringProperty(nomf);
		this.adresse = new SimpleStringProperty(adresse);
		this.numtel =  new SimpleStringProperty(numtel);
	}
	public Fournisseur() {
		super();
	}
	  
}