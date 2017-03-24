package fr.laposte.challenge.validation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validation {
	
	private static String regex;	
	private static Pattern pattern;
	private static Matcher matcher;
	
	public static boolean checkNom(String nom) {	
		
		 regex = "^[A-Z][a-z]+(-[A-Z][a-z]*|\\s[A-Z][a-z]*|)[a-z]*";
		 pattern = Pattern.compile(regex);
		 matcher = pattern.matcher(nom);
		 	
		 return matcher.matches();
	}
	public static boolean checkPrenom(String prenom) {		 
			
		 regex = "^[A-Z][a-z]+(-[A-Z]|)[a-z]*";
		 pattern = Pattern.compile(regex);
		 matcher = pattern.matcher(prenom);		 
		 return matcher.matches();
	 }
	public static boolean checkTel(String tel) {
		regex = "^(?:0|\\(?\\+33\\)?\\s?|0033\\s?)[1-79](?:[\\.\\-\\s]?\\d\\d){4}$";
		 pattern = Pattern.compile(regex);
		 matcher = pattern.matcher(tel);		 
		 return matcher.matches();
	 }
	public static boolean checkDate() {
		 return true;
	 }
	public static boolean checkVoie() {
		 return true;
	 }
	public static boolean checkRue() {
		 return true;
	 }
	public static boolean checkCodePostal() {
		 return true;
	 }
	public static boolean checkVille() {
		 return true;
	 }

}
