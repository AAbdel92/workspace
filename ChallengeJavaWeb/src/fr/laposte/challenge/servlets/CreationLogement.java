package fr.laposte.challenge.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.laposte.challenge.bean.AdresseBean;
import fr.laposte.challenge.bean.LogementBean;
import fr.laposte.challenge.daos.AdresseDAO;
import fr.laposte.challenge.daos.LogementDAO;
import fr.laposte.challenge.daos.ProprietaireDAO;

/**
 * Servlet implementation class CreationLogement
 */
@WebServlet("/CreationLogement")
public class CreationLogement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationLogement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String display = "hidden";
		
		ProprietaireDAO proprioDAO = new ProprietaireDAO();
		
	
		proprioDAO.selectProprios();
	
		
		request.setAttribute("display", display);
		request.setAttribute("resultat", proprioDAO.getListeProprio());
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/creationLogement.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdresseBean adresse = new AdresseBean();
			adresse.setVoie(request.getParameter("inputVoie"));
			adresse.setRue(request.getParameter("inputRue"));
			adresse.setCodePostal(request.getParameter("inputCodePostal"));
			adresse.setVille(request.getParameter("inputVille"));
		
		AdresseDAO adresseDAO = new AdresseDAO(adresse);
		
			adresseDAO.insererAdresse();
		
			
		ProprietaireDAO proprioDAO = new ProprietaireDAO();
	
			proprioDAO.selectProprio(Integer.parseInt(request.getParameter("inputProprio")));
			
		
		LogementBean appart = new LogementBean(adresse);
			appart.setDescription(request.getParameter("inputDescription"));
			appart.setCompAdresse(request.getParameter("inputCompAdresse"));
			appart.setProprio(proprioDAO.getProprio());
			
		LogementDAO appartDAO = new LogementDAO(appart);
		
			appartDAO.insererAppart();
		
			
		
		String display = "show";		
			request.setAttribute("display", display);
			request.setAttribute("resultat", proprioDAO.getListeProprio());
		
		RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/creationLogement.jsp");
			dispatcher.forward(request, response);		
	}
	
//	protected String afficherListeProprio() {
//		String resultat = "";
//		
//		ProprietaireDAO proprioDAO = new ProprietaireDAO();
//		
//	
//		proprioDAO.selectProprios();
//		
//		for (int i = 0; i < proprioDAO.getListeProprio().size(); i++) {
//			
//			resultat += "<option value=\"" + 
//						proprioDAO.getListeProprio().get(i).getId() + 
//						"\">" + 
//						proprioDAO.getListeProprio().get(i).getNom() + 
//						" " + 
//						proprioDAO.getListeProprio().get(i).getPrenom();
//			
//		}
//		proprioDAO.fermerConnexion();
//		return resultat;
//		
//	}
}
