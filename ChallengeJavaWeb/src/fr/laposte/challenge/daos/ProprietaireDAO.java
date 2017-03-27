package fr.laposte.challenge.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.laposte.challenge.bean.ProprietaireBean;

public class ProprietaireDAO extends DAO{
	
	private ProprietaireBean proprio;	
	private List<ProprietaireBean> listeProprio;
	
	public ProprietaireDAO() {
		
	}
	
	public ProprietaireDAO (ProprietaireBean proprio) {
		this.proprio = proprio;
	}
	
	public void insererProprio() {
		ouvrirConnexion();		
		requeteSql = "INSERT INTO `proprietaire` (`nom`,`prenom`, `tel`) VALUES " + 
					"('"+ this.proprio.getNom() + "', '" + this.proprio.getPrenom() + 
					"', '" + this.proprio.getTel() + "')";
		
		try {
			statement = connexion.prepareStatement(requeteSql);
			statement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		fermerConnexion();
	}
	
	public void selectProprios() {		
		ouvrirConnexion();				
		this.listeProprio = new ArrayList<>();
		requeteSql = "SELECT * FROM `proprietaire`";
		try {
			statement = connexion.prepareStatement(requeteSql);
			resultat = statement.executeQuery();
			while (resultat.next()) {						
				this.listeProprio.add(new ProprietaireBean(
						this.resultat.getInt("id"),
						this.resultat.getString("nom"),
						this.resultat.getString("prenom"), 
						this.resultat.getString("tel")));
			}
			this.resultat.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fermerConnexion();
	}
	
	public void selectProprio(int id) {
		ouvrirConnexion();		
		this.proprio = new ProprietaireBean();
		requeteSql = "SELECT * FROM `proprietaire` WHERE `id` LIKE " + id ;
		try {
			statement = connexion.prepareStatement(requeteSql);
			resultat = statement.executeQuery();
			while (resultat.next()) {						
				this.proprio.setId(resultat.getInt("id"));
				this.proprio.setNom(resultat.getString("nom"));
				this.proprio.setPrenom(resultat.getString("prenom"));
			}
			this.resultat.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fermerConnexion();		
	}

	public ProprietaireBean getProprio() {
		return proprio;
	}

	public void setProprio(ProprietaireBean proprio) {
		this.proprio = proprio;
	}

	public List<ProprietaireBean> getListeProprio() {
		return listeProprio;
	}

	public void setListeProprio(List<ProprietaireBean> listeProprio) {
		this.listeProprio = listeProprio;
	}
	
	
}
