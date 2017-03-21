package fr.laposte.challenge.bean;

public class AdresseBean {
	
	private int id;
	private String voie;
	private String rue;
	private String codePostal;
	private String ville;
	
	
	
	
	
	
	
	
	
	
	public String toString() {
		
		return this.voie + ", " + this.rue + " " + this.codePostal + " " + this.ville;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
