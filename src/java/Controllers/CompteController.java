/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Famille;
import Models.Utilisateur;
import Services.FamillieService;
import Services.UserService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
@WebServlet(name = "CompteController", urlPatterns = {"/Compte"})
public class CompteController extends Controller {

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
        HttpSession session = request.getSession();
        request.setAttribute("email", ((Utilisateur)session.getAttribute("utilisateur")).getEmail());
        Object num = request.getSession().getAttribute("num_adhesion");
        if (num != null && (int)num != -1)
            try {
                FamillieService fs = new FamillieService(getData());
                Famille f = fs.get((int)num);
                if (f != null)
                {
                    request.setAttribute("delegue", f.getDELEGUE_OPT());
                    request.setAttribute("recevoir", f.getRECEVOIR_OPT());
                    System.err.println(f.getDELEGUE_OPT() + " - " + f.getRECEVOIR_OPT());
                }
            } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
                request.setAttribute("status", 0);
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        request.getRequestDispatcher("WEB-INF/views/utilisateur/params.jsp").forward(request, response);
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
        
        try { 
            Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("utilisateur");
            UserService us = new UserService(getData());
            String email = request.getParameter("email-c");
            String motPasse = request.getParameter("old_password");
            String newMotPasse = request.getParameter("new_password");
            if (utilisateur.getPassword().equals(motPasse)){
                Utilisateur u = new Utilisateur(utilisateur.getID(), email, motPasse);
                if (newMotPasse != null && !newMotPasse.isEmpty())
                    u.setPassword(newMotPasse);
                if (us.update(u.getID(), u))
                    request.getSession().setAttribute("utilisateur", u);
                if (request.getSession().getAttribute("num_adhesion") != null)
                {
                    FamillieService fs = new FamillieService(getData());
                    Famille f = fs.get((int)request.getSession().getAttribute("num_adhesion"));
                    if (f != null)
                    {
                        f.setRECEVOIR_OPT(request.getParameter("recevoir")!= null);
                        f.setDELEGUE_OPT(request.getParameter("delegue")!= null);
                        fs.update(f.getNUM_adhesion(), f);
                    }
                }
                request.setAttribute("status", 1);
            }
            else
                request.setAttribute("status", 0);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            request.setAttribute("status", 0);
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        doGet(request, response);
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
