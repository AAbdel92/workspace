package fr.laposte.challenge.bean;

import java.util.Date;

public class DisponibiliteBean {
	
	private int id;	
	private String dateDebut;
	private String dateFin;
	private LogementBean appart;
	
	public DisponibiliteBean () {
		
	}	
	public DisponibiliteBean(int id, String dateDebut, String dateFin) {
		super();		
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	






	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public LogementBean getAppart() {
		return appart;
	}
	public void setAppart(LogementBean appart) {
		this.appart = appart;
	}
}
