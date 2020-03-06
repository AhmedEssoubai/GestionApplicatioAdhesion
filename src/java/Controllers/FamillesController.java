package Controllers;

import Models.Famille;
import Models.Utilisateur;
import Services.EnfantService;
import Services.FamillieService;
import Services.ParentService;
import Services.UserService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmed
 */
@WebServlet(name = "FamillesController", urlPatterns = {"/Familles"})
public class FamillesController extends Controller {

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
        try
        {
            FamillieService fs = new FamillieService(getData());
            String action = request.getParameter("action");
            if (action == null)
                action = "";
            switch(action)
            {
                case "delete":
                    Famille famille = new Famille(Integer.parseInt(request.getParameter("id")));
                    fs.delete(famille);
                    UserService us = new UserService(getData());
                    us.delete(new Utilisateur(famille.getID_UTILISATEUR()));
                    break;
                default:
                    EnfantService es = new EnfantService(getData());
                    ParentService ps = new ParentService(getData());
                    ArrayList<Famille> familles = fs.getAll();
                    for(Famille f : familles)
                    {
                        f.setTuteur(ps.get(f.getID_TUTEUR()));
                        f.setNbEnfants(es.getCountByFamily(f.getNUM_adhesion()));
                    }
                    request.setAttribute("familles", familles);
                    request.getRequestDispatcher("WEB-INF/views/admin/familles.jsp").forward(request, response);
                    break;
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ParentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
