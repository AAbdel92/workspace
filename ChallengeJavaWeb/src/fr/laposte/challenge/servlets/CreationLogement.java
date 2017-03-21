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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String display = "hidden";
		request.setAttribute("display", display);
		request.setAttribute("resultat", afficherListeProprio());
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("creationLogement.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdresseBean adresse = new AdresseBean();
			adresse.setVoie(request.getParameter("inputVoie"));
			adresse.setRue(request.getParameter("inputRue"));
			adresse.setCodePostal(request.getParameter("inputCodePostal"));
			adresse.setVille(request.getParameter("inputVille"));
		
		AdresseDAO adresseDAO = new AdresseDAO(adresse);
			adresseDAO.ouvrirConnexion();
			adresseDAO.insererAdresse();
			adresseDAO.fermerConnexion();
			
		ProprietaireDAO proprioDAO = new ProprietaireDAO();
			proprioDAO.ouvrirConnexion();
			proprioDAO.selectProprio(Integer.parseInt(request.getParameter("inputProprio")));
			proprioDAO.fermerConnexion();		
		
		LogementBean appart = new LogementBean(adresse);
			appart.setDescription(request.getParameter("inputDescription"));
			appart.setCompAdresse(request.getParameter("inputCompAdresse"));
			appart.setProprio(proprioDAO.getProprio());
			
		LogementDAO appartDAO = new LogementDAO(appart);
			appartDAO.ouvrirConnexion();
			appartDAO.insererAppart();
			appartDAO.fermerConnexion();
			
		
		String display = "show";		
			request.setAttribute("display", display);
			request.setAttribute("resultat", afficherListeProprio());
		
		RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("creationLogement.jsp");
			dispatcher.forward(request, response);		
	}
	
	protected String afficherListeProprio() {
		String resultat = "";
		
		ProprietaireDAO proprioDAO = new ProprietaireDAO();
		
		proprioDAO.ouvrirConnexion();
		proprioDAO.selectProprios();
		
		for (int i = 0; i < proprioDAO.getListeProprio().size(); i++) {
			
			resultat += "<option value=\"" + 
						proprioDAO.getListeProprio().get(i).getId() + 
						"\">" + 
						proprioDAO.getListeProprio().get(i).getNom() + 
						" " + 
						proprioDAO.getListeProprio().get(i).getPrenom();
			
		}
		proprioDAO.fermerConnexion();
		return resultat;
		
	}
}
