package oo;


public class Marque {
	
	private  String idmarque;
	private  String nommarque ;
	public String getIdmarque() {
		return idmarque;
	}
	public void setIdmarque(String idmarque) {
		this.idmarque = idmarque;
	}
	public String getNommarque() {
		return nommarque;
	}
	public void setNommarque(String nommarque) {
		this.nommarque = nommarque;
	}
	public Marque(String idmarque, String nommarque) {
		super();
		this.idmarque = idmarque;
		this.nommarque = nommarque;
	}
}
