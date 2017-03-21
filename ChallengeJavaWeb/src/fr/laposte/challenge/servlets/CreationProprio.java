package fr.laposte.challenge.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.laposte.challenge.bean.ProprietaireBean;
import fr.laposte.challenge.daos.ProprietaireDAO;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/CreationProprio")
public class CreationProprio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationProprio() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String display = "hidden";
		request.setAttribute("display", display);
		RequestDispatcher dispatcher;		
		dispatcher = request.getRequestDispatcher("creationProprio.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		ProprietaireBean proprio = new ProprietaireBean();
			proprio.setNom(request.getParameter("inputNom"));
			proprio.setPrenom(request.getParameter("inputPrenom"));
			proprio.setTel(request.getParameter("inputTel"));
		
		ProprietaireDAO proprioDAO = new ProprietaireDAO(proprio);
			proprioDAO.ouvrirConnexion();
			proprioDAO.insererProprio();
			proprioDAO.fermerConnexion();
		
		String display = "show";
			request.setAttribute("display", display);
		
		RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("creationProprio.jsp");
			dispatcher.forward(request, response);
		
		
		
		
				
	}

}
