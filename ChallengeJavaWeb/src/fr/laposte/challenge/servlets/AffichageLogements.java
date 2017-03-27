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
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						
		request.setAttribute("proprioDisplay", hidden);
		request.setAttribute("logementDisplay", hidden);
		request.setAttribute("confirmationDisplay", hidden);
		request.setAttribute("noLogementDisplay", hidden);
		
		ProprietaireDAO proprioDAO = new ProprietaireDAO();		
		
		proprioDAO.selectProprios();		
		
		request.setAttribute("resultat", proprioDAO.getListeProprio());
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("affichageLogements.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("submitProprio") != null) {
		
			this.appartDAO = new LogementDAO();
			
				appartDAO.selectLogements(Integer.parseInt(request.getParameter("inputProprio")));
				
			
			this.proprioDAO = new ProprietaireDAO();
				
				proprioDAO.selectProprio(Integer.parseInt(request.getParameter("inputProprio")));
			
				
			request.setAttribute("nomProprio", this.proprioDAO.getProprio().toString());
			
				if (!this.appartDAO.getListeApparts().isEmpty()) {				
					request.setAttribute("proprioDisplay", show);
					request.setAttribute("confirmationDisplay", hidden);
					request.setAttribute("logementDisplay", show);
					request.setAttribute("noLogementDisplay", hidden);
					request.setAttribute("logements", this.appartDAO.getListeApparts());					
				} else {
					request.setAttribute("proprioDisplay", show);
					request.setAttribute("confirmationDisplay", hidden);
					request.setAttribute("logementDisplay", hidden);
					request.setAttribute("noLogementDisplay", show);
				}
				ProprietaireDAO proprioDAO = new ProprietaireDAO();		
				
				proprioDAO.selectProprios();
				request.setAttribute("resultat", proprioDAO.getListeProprio());
				
		} else {
			request.setAttribute("logements",  this.appartDAO.getListeApparts());
			
			
			LogementDAO appartDAO = new LogementDAO();
		
				appartDAO.selectProprio(Integer.parseInt(request.getParameter("inputLogement")));
						
		
			
				appartDAO.selectLogement(Integer.parseInt(request.getParameter("inputLogement")));
			
			
			DisponibiliteBean dispo = new DisponibiliteBean();
				dispo.setAppart(appartDAO.getAppart());
				dispo.setDateDebut(request.getParameter("inputDateDebut"));
				dispo.setDateFin(request.getParameter("inputDateFin"));				
			
			DisponibiliteDAO dispoDAO = new DisponibiliteDAO(dispo);
			
				dispoDAO.insererDispo();
			
				
			request.setAttribute("proprioDisplay", show);
			request.setAttribute("confirmationDisplay", show);
			request.setAttribute("logementDisplay", show);
			request.setAttribute("noLogementDisplay", hidden);
			}
		

		ProprietaireDAO proprioDAO = new ProprietaireDAO();
		

		proprioDAO.selectProprios();
		
		
	request.setAttribute("resultat", proprioDAO.getListeProprio());
	
	RequestDispatcher dispatcher;	
		dispatcher = request.getRequestDispatcher("affichageLogements.jsp");
		dispatcher.forward(request, response);
	}	
}
