package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

public class EditerCollaborateurController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String matriculeParam = req.getParameter("matricule");
		
		if (StringUtils.isBlank(matriculeParam)) {
			resp.sendError(400, "Un matricule est attendu");
		} else {
			resp.setContentType("text/html");
			resp.getWriter().write("<h1>Editer des collaborateurs</h1>" 
					+ "<ul>" 
					+ "<li>" + matriculeParam + "</li>"
					+ "</ul>");
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String messageError = "Les paramètres suivant sont incorrects";
		String matriculeParam = req.getParameter("matricule");
		String titreParam = req.getParameter("titre");
		String nomParam = req.getParameter("nom");
		String prenomParam = req.getParameter("prenom");
		
		if (StringUtils.isBlank(matriculeParam) || StringUtils.isBlank(titreParam) || StringUtils.isBlank(nomParam) || StringUtils.isBlank(prenomParam)) {
			
			if (StringUtils.isBlank(matriculeParam)) {
				messageError += "matricule";
			}
			if (StringUtils.isBlank(titreParam)) {
				messageError += "titre";
			}
			if (StringUtils.isBlank(nomParam)) {
				messageError += "nom";
			}
			if (StringUtils.isBlank(prenomParam)) {
				messageError += "prenom";
			}
			resp.sendError(400, messageError);
		} else {
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write("<html><head><meta charset=\"utf-8\" /></head><body><h1>Edition des collaborateurs</h1>" 
					+ "<p>Création d'un coolaborateur avec les information suivantes :<p>" 
					+ "<ul>" 
					+ "<li>matricule = " + matriculeParam + "</li>" 
					+ "<li>titre = " + titreParam + "</li>" 
					+ "<li>nom = " + nomParam + "</li>" 
					+ "<li>prenom = " + prenomParam + "</li>" 
					+ "</ul></body></html>");
			resp.setStatus(201);
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}