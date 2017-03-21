package fr.laposte.challenge.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	
	protected String url = "jdbc:mysql://localhost/simplonairbnb";
	protected String login = "root";
	protected String motDePasse = "";
	protected String requeteSql;
	protected Connection connexion = null;
	protected Statement statement = null;
	protected ResultSet resultat = null;
	
	public void ouvrirConnexion() {		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection(url, login, motDePasse);
			statement = connexion.createStatement();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
	}
	
	public void fermerConnexion() {
		
		try {			
			connexion.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
