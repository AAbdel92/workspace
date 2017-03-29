package fr.laposte.challenge.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.laposte.challenge.bean.TypeLogementBean;
import fr.laposte.challenge.daos.TypeLogementDAO;

/**
 * Servlet implementation class CreationTypeLogement
 */
@WebServlet("/CreationTypeLogement")
public class CreationTypeLogement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationTypeLogement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String nom = request.getParameter("submitCreer");
    	
    	TypeLogementBean typeAppart = new TypeLogementBean();
    		typeAppart.setNom(nom);
    		
    	TypeLogementDAO typeAppartDAO = new TypeLogementDAO();
    		typeAppartDAO.insertType(typeAppart);
    		
    		request.setAttribute("display", "show");
    		request.setAttribute("confirmation", "Type de logement crée !");
    		
    		RequestDispatcher dispatcher;
    		dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/typeLogement.jsp");
    		dispatcher.forward(request, response);
	}
}
