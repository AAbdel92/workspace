package fr.laposte.challenge.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.laposte.challenge.daos.LogementDAO;
import fr.laposte.challenge.daos.ProprietaireDAO;

/**
 * Servlet implementation class Recherche
 */
@WebServlet("/Recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String hidden = "hidden";
	private String show = "show";       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherche() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("logementsDisplay", hidden);
		request.setAttribute("noLogementDisplay", hidden);
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("recherche.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		
		if (request.getParameter("submitRecherche") != null) {
		
		LogementDAO appartDAO = new LogementDAO();
			appartDAO.ouvrirConnexion();
			appartDAO.rechercheApparts(request.getParameter("inputVille"), 
										request.getParameter("inputDateDebut"), 
										request.getParameter("inputDateFin"));
			appartDAO.fermerConnexion();
			
			request.setAttribute("logementsDisplay", hidden);
			request.setAttribute("noLogementDisplay", hidden);
			String hasLogement = this.afficherListeApparts(appartDAO);
			if (hasLogement != null) {
				request.setAttribute("logementsDisplay", show);
				request.setAttribute("noLogementDisplay", hidden);
				request.setAttribute("logements", hasLogement);		
			} else {
				request.setAttribute("logementsDisplay", hidden);
				request.setAttribute("noLogementDisplay", show);
			}						
			dispatcher = request.getRequestDispatcher("recherche.jsp");
		} else {
			LogementDAO appartDAO = new LogementDAO();
				appartDAO.ouvrirConnexion();
				appartDAO.selectProprio(Integer.parseInt(request.getParameter("inputLogement")));
				appartDAO.fermerConnexion();			
			
			String nomProprio = appartDAO.getAppart().getProprio().toString();
			String telProprio = appartDAO.getAppart().getProprio().getTel();			
			request.setAttribute("nomProprio", nomProprio);
			request.setAttribute("telProprio", telProprio);
			request.setAttribute("display", show);

			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		
		
		dispatcher.forward(request, response);		
		
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