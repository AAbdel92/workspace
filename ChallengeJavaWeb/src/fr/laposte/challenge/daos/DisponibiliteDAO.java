package fr.laposte.challenge.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.laposte.challenge.bean.DisponibiliteBean;

public class DisponibiliteDAO extends DAO {
	
	private DisponibiliteBean dispo;	
	private List<DisponibiliteBean> listeDispos;
	
	public DisponibiliteDAO() {
		
	}
	public DisponibiliteDAO(DisponibiliteBean dispo) {
		this.dispo = dispo;
	}
	
//	public void selectDispos(int proprioId) {
//		
//		this.listeDispos = new ArrayList<>();
//		requeteSql = "SELECT * FROM `disponibilites` JOIN `logement` " + 
//						"ON disponibilites.logement_id = logement.id " + 
//						"JOIN `proprietaire` " + 
//						"ON logement.proprietaire_id = proprietaire.id " + 
//						"WHERE proprietaire.id LIKE " + proprioId;
//		try {
//			resultat = statement.executeQuery(requeteSql);
//			while (resultat.next()) {						
//				this.listeDispos.add(new DisponibiliteBean(
//						this.resultat.getInt("id"),
//						this.resultat.getDate("dateDebut"),
//						this.resultat.getDate("dateFin")));
//			}
//			this.resultat.close();	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public void insererDispo() {
		this.requeteSql = "INSERT INTO `disponibilites` (`dateDebut`, `dateFin`, `logement_id`)" + 
							"VALUES ('" + this.dispo.getDateDebut() + 
							"', '" + this.dispo.getDateFin() + 
							"', " + this.dispo.getAppart().getId() + 
							")";
		try {
			statement.executeUpdate(requeteSql);			
		} catch (SQLException e) {
			e.printStackTrace();		
		}		
	}
	
	public DisponibiliteBean getDispo() {
		return dispo;
	}
	public void setDispo(DisponibiliteBean dispo) {
		this.dispo = dispo;
	}

}
