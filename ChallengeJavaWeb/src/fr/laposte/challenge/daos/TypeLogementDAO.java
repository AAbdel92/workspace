package fr.laposte.challenge.daos;

import java.sql.SQLException;
import java.sql.Statement;

import fr.laposte.challenge.bean.TypeLogementBean;

public class TypeLogementDAO extends DAO {
	
	public TypeLogementBean insertType(TypeLogementBean typeAppart) {
		ouvrirConnexion();
		requeteSql = "INSERT INTO `typelogement` (`nom`) "
				+ "VALUES ('" + typeAppart.getNom() + "')";		
		try {
			statement = connexion.prepareStatement(requeteSql, Statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			resultat = statement.getGeneratedKeys();
			if (resultat.next()) {
				typeAppart.setId(1);
			}
			resultat.close();	
		} catch (SQLException e) {
			e.printStackTrace();
		}					
		fermerConnexion();
		return typeAppart;
	}
}
