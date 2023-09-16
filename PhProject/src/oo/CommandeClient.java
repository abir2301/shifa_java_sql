package oo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CommandeClient {
	  public CommandeClient() {
		super();
	}
	private StringProperty id  ;
	  private StringProperty  quantite ;
	  private StringProperty   dateCommande ;
	  private StringProperty   mpass ;
	  private StringProperty     numph ;
	  private StringProperty   nummed ;
	  private StringProperty   type ;
	 
	    public StringProperty idProperty() { return this.id; }
	    public StringProperty mpassProperty() { return this.mpass; }
	    public StringProperty numphProperty() { return this.numph; }
	    public StringProperty nummedProperty() { return this.nummed; }
	    public StringProperty typeProperty() { return this.type; }
	    public StringProperty quantiteProperty() { return this.quantite; }
	    public StringProperty dateCommandeProperty() { return this.dateCommande; }


	public String getdateCommande() {
		return dateCommande.get();
	}
	public void setdateCommande(String dateCommande) {
		this.dateCommande.set(dateCommande);
	}
	
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id);;
	}
	public String getQuantite() {
		return quantite.get();
	}
	public void setQuantite(String quantite) {
		this.quantite.set(quantite);;
	}
	public String getMpass() {
		return mpass.get();
	}
	public void setMpass(String mpass) {
		this.mpass .set(mpass);
	}
	public String getNumph() {
		return numph.get();
	}
	public void setNumph(String numph) {
		this.numph .set(numph);
	}
	public String getNummed() {
		return nummed.get();
	}
	public void setNummed(String nummed) {
		this.nummed.set(nummed);;
	}
	public String getType() {
		return type.get();
	}
	public void setType(String type) {
		this.type .set(type);
	}
	public CommandeClient(String id, String quantite, String dataCommande ,String mpass, String numph, String nummed, String type) {
		this.id= new SimpleStringProperty(id);
		this.quantite = new SimpleStringProperty(quantite);
		this.dateCommande= new SimpleStringProperty(dataCommande);
		this.mpass = new SimpleStringProperty(mpass);
		this.numph = new SimpleStringProperty(numph);
		this.nummed =  new SimpleStringProperty(nummed);
		this.type =  new SimpleStringProperty(type);
	}
	
	
}
