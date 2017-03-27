package fr.laposte.challenge.daos;

import java.sql.SQLException;
import java.sql.Statement;

import fr.laposte.challenge.bean.AdresseBean;

public class AdresseDAO extends DAO{
	
	private AdresseBean adresse;
	
	public AdresseDAO () {
		
	}
	public AdresseDAO (AdresseBean adresse) {
		this.adresse = adresse;
	}
	
	public void insererAdresse() {
		ouvrirConnexion();		
		requeteSql = "INSERT INTO `adresse` (`voie`,`rue`, `codePostal`, `ville`) VALUES ";
		requeteSql += "('"+ this.adresse.getVoie() + 
					"', \"" + this.adresse.getRue() + 
					"\", '" + this.adresse.getCodePostal() + 
					"', '" + this.adresse.getVille() + 
					"')";
		
		try {
			statement = connexion.prepareStatement(requeteSql, Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			resultat = statement.getGeneratedKeys();
			if (resultat.next()) {
				this.adresse.setId(1);
			}			
//		requeteSql = "SELECT `id` FROM `adresse` ORDER BY `id` DESC LIMIT 1";
//		resultat = statement.executeQuery(requeteSql);	
//		while (resultat.next()) {
//			this.adresse.setId(resultat.getInt("id"));	
//		}		
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		fermerConnexion();
	}
	public void selectAdresse(int appartId) {
		ouvrirConnexion();		
		this.adresse = new AdresseBean();
		this.requeteSql = "SELECT * FROM `adresse` " + 
						"JOIN `logement` " + 
						"ON adresse.id = logement.adresse_id " + 
						"WHERE logement.id LIKE " + appartId;
		try {
			statement = connexion.prepareStatement(requeteSql);
			this.resultat = this.statement.executeQuery();
			while (resultat.next()) {						
				this.adresse.setId(resultat.getInt(1));
				this.adresse.setVoie(resultat.getString(2));
				this.adresse.setRue(resultat.getString(3));
				this.adresse.setCodePostal(resultat.getString(4));
				this.adresse.setVille(resultat.getString(5));
			}
			this.resultat.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		fermerConnexion();		
	}
	public AdresseBean getAdresse() {
		return this.adresse;
	}
	public void setAdresse(AdresseBean adresse) {
		this.adresse = adresse;
	}
	

}
