package fr.laposte.challenge.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.laposte.challenge.bean.AdresseBean;
import fr.laposte.challenge.bean.LogementBean;
import fr.laposte.challenge.bean.ProprietaireBean;

public class LogementDAO extends DAO {
	
	private LogementBean appart;
	private List<LogementBean> listeApparts;
	
	public LogementDAO () {
		
	}
	public LogementDAO (LogementBean appart) {
		this.appart = appart;
	}
	
	public void insererAppart() {
		ouvrirConnexion();		
		requeteSql = "INSERT INTO `logement` (`adresse_id`, `proprietaire_id`, `description`,`compAdresse`) VALUES " + 
					"('" + this.appart.getAdresse().getId() + 
					"', " + this.appart.getProprio().getId() + 
					", '" + this.appart.getDescription() + 
					"', '" + this.appart.getCompAdresse() + 					
					"')";		
		try {
			statement = connexion.prepareStatement(requeteSql);
			statement.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		fermerConnexion();
	}
	
	public void selectLogements(int proprioId) {
		ouvrirConnexion();		
		this.listeApparts = new ArrayList<>();
		this.requeteSql = "SELECT logement.*, adresse.* FROM `logement` "
				+ "JOIN `adresse` ON logement.adresse_id = adresse.id "
				+ "JOIN `proprietaire` ON logement.proprietaire_id = proprietaire.id "
				+ "WHERE proprietaire.id LIKE " + proprioId;
		try {
			statement = connexion.prepareStatement(requeteSql);
			this.resultat = statement.executeQuery();
			while (resultat.next()) {
				this.appart = new LogementBean();
				this.appart.setId(resultat.getInt(1));
				this.appart.setDescription(resultat.getString(2));
				this.appart.setCompAdresse(resultat.getString(5));
				this.appart.setAdresse(new AdresseBean());
				this.appart.getAdresse().setId(resultat.getInt(6));
				this.appart.getAdresse().setVoie(resultat.getString(7));
				this.appart.getAdresse().setRue(resultat.getString(8));
				this.appart.getAdresse().setCodePostal(resultat.getString(9));
				this.appart.getAdresse().setVille(resultat.getString(10));
				this.listeApparts.add(this.appart);
			}
			this.resultat.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fermerConnexion();		
	}
	
	public void selectProprio( int appartId) {
		ouvrirConnexion();
		this.appart = new LogementBean();
		this.requeteSql = "SELECT * FROM `proprietaire` " + 
				"JOIN `logement` " + 
				"ON logement.proprietaire_id = proprietaire.id " + 
				"WHERE logement.id LIKE " + appartId;
		try {
			statement = connexion.prepareStatement(requeteSql);
			this.resultat = statement.executeQuery();
			while (resultat.next()) {
				this.appart.setProprio(new ProprietaireBean());
				this.appart.getProprio().setId(resultat.getInt(1));
				this.appart.getProprio().setNom(resultat.getString(2));
				this.appart.getProprio().setPrenom(resultat.getString(3));
				this.appart.getProprio().setTel(resultat.getString(4));;
			}
			this.resultat.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fermerConnexion();
	}
	
	public void selectLogement(int appartId) {
		ouvrirConnexion();		
		this.appart = new LogementBean();
		this.appart.setAdresse(new AdresseBean());
		this.requeteSql = "SELECT logement.*, adresse.* FROM `logement` "
				+ "JOIN `adresse` ON logement.adresse_id = adresse.id "
				+ "WHERE logement.id LIKE " + appartId;
		try {
			statement = connexion.prepareStatement(requeteSql);
			this.resultat = statement.executeQuery();
			while (resultat.next()) {
				this.appart.setId(resultat.getInt(1));
				this.appart.setDescription(resultat.getString(2));
				this.appart.setCompAdresse(resultat.getString(5));				
				this.appart.getAdresse().setId(resultat.getInt(6));
				this.appart.getAdresse().setVoie(resultat.getString(7));
				this.appart.getAdresse().setRue(resultat.getString(8));
				this.appart.getAdresse().setCodePostal(resultat.getString(9));
				this.appart.getAdresse().setVille(resultat.getString(10));
			}
			this.resultat.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fermerConnexion();		
	}
	
	public void rechercheApparts(String ville, String dateDebut, String dateFin) {
		ouvrirConnexion();		
		this.listeApparts = new ArrayList<>();
		
		this.requeteSql = "SELECT logement.*, adresse.* FROM `logement` "
				+ "JOIN `disponibilites` ON logement.id = disponibilites.logement_id "
				+ "JOIN `adresse` ON logement.adresse_id = adresse.id "
				+ "WHERE adresse.ville LIKE '" + ville + "' AND '" 
				+ dateDebut + "' >= disponibilites.dateDebut AND '" 
				+ dateFin + "' <= disponibilites.dateFin";
		try {
			statement = connexion.prepareStatement(requeteSql);
			this.resultat = statement.executeQuery();
			while (this.resultat.next()) {
				this.appart = new LogementBean();
				this.appart.setId(resultat.getInt(1));
				this.appart.setDescription(resultat.getString(2));
				this.appart.setCompAdresse(resultat.getString(5));
				this.appart.setAdresse(new AdresseBean());
				this.appart.getAdresse().setId(resultat.getInt(6));
				this.appart.getAdresse().setVoie(resultat.getString(7));
				this.appart.getAdresse().setRue(resultat.getString(8));
				this.appart.getAdresse().setCodePostal(resultat.getString(9));
				this.appart.getAdresse().setVille(resultat.getString(10));

				this.listeApparts.add(this.appart);				
			}
			this.resultat.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fermerConnexion();
	}
	
	public LogementBean getAppart() {
		return appart;
	}
	public void setAppart(LogementBean appart) {
		this.appart = appart;
	}
	public List<LogementBean> getListeApparts() {
		return listeApparts;
	}
	public void setListeApparts(List<LogementBean> listeApparts) {
		this.listeApparts = listeApparts;
	}
	

}
