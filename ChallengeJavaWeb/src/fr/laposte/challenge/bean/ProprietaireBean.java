package fr.laposte.challenge.bean;

public class ProprietaireBean {
	
	
	private int id;	
	private String nom;
	private String prenom;
	private String tel;
	
	public ProprietaireBean () {
		
		}	
	
	public ProprietaireBean(int id, String nom, String prenom, String tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}


















	public String toString() {
		return this.nom + " " + this.prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
