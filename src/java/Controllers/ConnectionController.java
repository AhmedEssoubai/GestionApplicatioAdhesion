package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Utilisateur;
import Services.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Zed
 */
@WebServlet(name = "ConnectionController", urlPatterns = {"/Connect"})
public class ConnectionController extends Controller {
    
    private static final long serialVersionUID = 1L;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/connecter.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean valid = false;
        Utilisateur utilisateur = null;
        FamillieService famillieService = null;
        EnfantService es = null;
        
        try { 
            UserService utilisateurService = new UserService(getData());
            famillieService = new FamillieService(getData());
            String email = request.getParameter("email");
            String motPasse = request.getParameter("password");
            es = new EnfantService(getData());
        
            if (email != null && motPasse != null)
            {
                utilisateur = utilisateurService.verify(email, motPasse);
                if (utilisateur != null)
                    valid = true;
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (valid)
        {
            HttpSession session = request.getSession();
            session.setAttribute("utilisateur", utilisateur);
            int num = famillieService.hasFamily(utilisateur);
            session.setAttribute("isAdmin", famillieService != null && num == -1);
            session.setAttribute("num_adhesion", num);
            String dir = "Accueil"; 
            if (num != -1)
            {
                boolean complete = es.getCountByFamily(num) != 0;
                session.setAttribute("complete", complete);
                if (complete)
                    dir = "Parents?num=" + num;
                else
                    dir = "AjouterEnfants";
            }
            response.sendRedirect(dir);
        }
        else
        {
            request.setAttribute("err", 1);
            doGet(request, response);
        }
    }
        
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
