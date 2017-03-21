package fr.laposte.challenge.bean;

public class LogementBean {
	
	private int id;
	private String description;	
	private String compAdresse;
	//private List<DisponibiliteBean> listeDispo;
	//private int proprioId;
	private AdresseBean adresse;
	private ProprietaireBean proprio;
	
	public LogementBean () {
		
	}
	public LogementBean ( AdresseBean adresse) {
		
		this.adresse = adresse;		
	}	
	public LogementBean(int id, String description, String compAdresse, AdresseBean adresse, ProprietaireBean proprio) {
		super();
		this.id = id;
		this.description = description;
		this.compAdresse = compAdresse;
		this.adresse = adresse;
		this.proprio = proprio;
	}
	
	public String toString() {
		
		return this.adresse.toString() + " Complément d'adresse : " + this.compAdresse + 
				" description : " + this.description;
	}










//	public ProprietaireBean getProprio() {
//		return proprio;
//	}	
//	public void setProprio(ProprietaireBean proprio) {
//		this.proprio = proprio;
//	}	
	public AdresseBean getAdresse() {
		return adresse;
	}	
	public void setAdresse(AdresseBean adresse) {
		this.adresse = adresse;
	}	
	public String getCompAdresse() {
		return compAdresse;
	}	
	public void setCompAdresse(String compAdresse) {
		this.compAdresse = compAdresse;
	}		
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public int getProprioId() {
//		return this.proprioId;
//	}
//	public void setProprioId(int proprioId) {
//		this.proprioId = proprioId;
//	}	
//	public int getAdresseId() {
//		return this.adresseId;
//	}
//	public void setAdresseId(int adresseId) {
//		this.adresseId = adresseId;
//	}
//	public List<DisponibiliteBean> getListeDispo() {
//		return listeDispo;
//	}
//	public void setListeDispo(List<DisponibiliteBean> listeDispo) {
//		this.listeDispo = listeDispo;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProprietaireBean getProprio() {
		return proprio;
	}
	public void setProprio(ProprietaireBean proprio) {
		this.proprio = proprio;
	}	
	
}
