package fr.laposte.challenge.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	protected String url = "jdbc:mysql://localhost/simplonairbnb";
	protected String login = "root";
	protected String motDePasse = "";
	protected String requeteSql;
	protected Connection connexion = null;
	protected PreparedStatement statement = null;
	protected ResultSet resultat = null;
	
	public void ouvrirConnexion() {		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection(url, login, motDePasse);			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
	}
	
	public void fermerConnexion() {
		
		try {						
			statement.close();
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
