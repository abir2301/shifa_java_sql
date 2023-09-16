package oo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MedicamentPh {

	

		private  StringProperty idmed ;
		  private  StringProperty nom ;
		  private  StringProperty marque ;
		  private  StringProperty type ;
		  private  StringProperty quantite ;
		  
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
		public String getQuantite () {
			return quantite .get();
		}
		public void setQuantite (String description) {
			this.quantite .set(description);
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
		public MedicamentPh(String idmed, String nom, String marque, String type , String quantite) {
			super();
			this.idmed =  new SimpleStringProperty(idmed);
			this.nom = new SimpleStringProperty(nom);
			
			this.marque = new SimpleStringProperty(marque);
			this.type =new SimpleStringProperty(type);
			this.quantite = new SimpleStringProperty(quantite  );
		}
		 public StringProperty idProperty() { return this.idmed; }
		    public StringProperty nomProperty() { return this.nom; }
		    public StringProperty quantiteProperty() { return this.quantite; }
		    public StringProperty marqueProperty() { return this.marque; }
		    public StringProperty typeProperty() { return this.type; }
		   
		
		
	


}
