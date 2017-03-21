package fr.laposte.challenge.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.laposte.challenge.bean.DisponibiliteBean;
import fr.laposte.challenge.daos.DisponibiliteDAO;
import fr.laposte.challenge.daos.LogementDAO;
import fr.laposte.challenge.daos.ProprietaireDAO;

/**
 * Servlet implementation class AjoutDispo
 */
@WebServlet("/AffichageLogements")
public class AffichageLogements extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProprietaireDAO proprioDAO;
	private LogementDAO appartDAO;
	private String hidden = "hidden";
	private String show = "show";       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageLogements() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		request.setAttribute("proprioDisplay", hidden);
		request.setAttribute("logementDisplay", hidden);
		request.setAttribute("confirmationDisplay", hidden);
		request.setAttribute("noLogementDisplay", hidden);
		request.setAttribute("resultat", afficherListeProprio());
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("affichageLogements.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("submitProprio") != null) {
		
			this.appartDAO = new LogementDAO();
				appartDAO.ouvrirConnexion();
				appartDAO.selectLogements(Integer.parseInt(request.getParameter("inputProprio")));
				appartDAO.fermerConnexion();
			
			this.proprioDAO = new ProprietaireDAO();
				proprioDAO.ouvrirConnexion();
				proprioDAO.selectProprio(Integer.parseInt(request.getParameter("inputProprio")));
				proprioDAO.fermerConnexion();
				
			request.setAttribute("nomProprio", this.proprioDAO.getProprio().toString());
			
			String hasLogement = afficherListeApparts(this.appartDAO);
				if (hasLogement != null) {				
					request.setAttribute("proprioDisplay", show);
					request.setAttribute("confirmationDisplay", hidden);
					request.setAttribute("logementDisplay", show);
					request.setAttribute("noLogementDisplay", hidden);
					request.setAttribute("logements", hasLogement);
				} else {
					request.setAttribute("proprioDisplay", show);
					request.setAttribute("confirmationDisplay", hidden);
					request.setAttribute("logementDisplay", hidden);
					request.setAttribute("noLogementDisplay", show);
				}						 
		} else {
			request.setAttribute("logements", afficherListeApparts(this.appartDAO));
			
			LogementDAO appartDAO = new LogementDAO();
				appartDAO.ouvrirConnexion();
				appartDAO.selectProprio(Integer.parseInt(request.getParameter("inputLogement")));
				appartDAO.fermerConnexion();			
		
				appartDAO.ouvrirConnexion();
				appartDAO.selectLogement(Integer.parseInt(request.getParameter("inputLogement")));
				appartDAO.fermerConnexion();	
			
			DisponibiliteBean dispo = new DisponibiliteBean();
				dispo.setAppart(appartDAO.getAppart());
				dispo.setDateDebut(request.getParameter("inputDateDebut"));
				dispo.setDateFin(request.getParameter("inputDateFin"));				
			
			DisponibiliteDAO dispoDAO = new DisponibiliteDAO(dispo);
				dispoDAO.ouvrirConnexion();
				dispoDAO.insererDispo();
				dispoDAO.fermerConnexion();	
				
			request.setAttribute("proprioDisplay", show);
			request.setAttribute("confirmationDisplay", show);
			request.setAttribute("logementDisplay", show);
			request.setAttribute("noLogementDisplay", hidden);
			}
	request.setAttribute("resultat", afficherListeProprio());
	
	RequestDispatcher dispatcher;	
		dispatcher = request.getRequestDispatcher("affichageLogements.jsp");
		dispatcher.forward(request, response);
	}
	
	
	protected String afficherListeProprio() {
		StringBuilder resultat = new StringBuilder();
		String option;		
		ProprietaireDAO proprioDAO = new ProprietaireDAO();		
			proprioDAO.ouvrirConnexion();
			proprioDAO.selectProprios();
			proprioDAO.fermerConnexion();
		
		for (int i = 0; i < proprioDAO.getListeProprio().size(); i++) {			
			option = "<option value=\"" + 
						proprioDAO.getListeProprio().get(i).getId() + 
						"\">" + 
						proprioDAO.getListeProprio().get(i).getNom() + 
						" " + 
						proprioDAO.getListeProprio().get(i).getPrenom() + 
						"</option>";
			resultat.append(option);			
		}		
		return resultat.toString();		
	}
	
	protected String afficherListeApparts(LogementDAO appartDAO) {			
		
		if (!(appartDAO.getListeApparts().isEmpty())) {	
			StringBuilder resultat = new StringBuilder();
			String option;			
			for (int i = 0; i < appartDAO.getListeApparts().size(); i++) {			
				option = "<option value=\"" + appartDAO.getListeApparts().get(i).getId() + 
							"\">" + appartDAO.getListeApparts().get(i).getAdresse().toString() + 
							"</option>";
				resultat.append(option);
		}
		return resultat.toString();
		} else {
			return null;
		}		
	}
}
