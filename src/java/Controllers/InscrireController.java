package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Services.*;
import Models.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Zed
 */
@WebServlet(name = "InscrireController", urlPatterns = {"/Inscrire"})
public class InscrireController extends Controller {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/inscrire.jsp");
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
        try {
            ParentService P = new ParentService(getData());
            UserService U = new UserService(getData());
            FamillieService F = new FamillieService(getData());
            String nom=request.getParameter("nom");
            String prenom=request.getParameter("prenom");
            String cin=request.getParameter("cin");
            String email=request.getParameter("email");
            String password=request.getParameter("password");                                       
            String tel=request.getParameter("tel");
            String profession=request.getParameter("profession");
            
            
            Utilisateur user = new Utilisateur(email, password);
            user.setID(U.add(user));
            
            Famille f = new Famille(user.getID(), -1, request.getParameter("recevoir")!= null, request.getParameter("delegue")!= null);
            f.setNUM_adhesion(F.add(f));
            
            Parent p = new Parent(prenom, nom, cin, tel, email, profession, f.getNUM_adhesion());
            f.setID_TUTEUR(P.add(p));
            
            F.update(f.getNUM_adhesion(), f);
            
            response.sendRedirect(request.getContextPath() + "/Connect");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(InscrireController.class.getName()).log(Level.SEVERE, null, ex);
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
