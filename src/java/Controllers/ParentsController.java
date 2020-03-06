package Controllers;

import Models.Famille;
import Models.Parent;
import Services.FamillieService;
import Services.ParentService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "ParentsController", urlPatterns = {"/Parents"})
public class ParentsController extends Controller {

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
        String num = request.getParameter("num");
        if (num == null || num.isEmpty())
        {
            response.sendRedirect("Accueil");
            return;
        }
        int id = Integer.parseInt(num);
        try
        {
            PrintWriter out = response.getWriter();
            FamillieService fs = new FamillieService(getData());
            ParentService ps = new ParentService(getData());
            String action = request.getParameter("action");
            Parent parent;
            if (action == null)
                action = "";
            switch(action)
            {
                case "add":
                    parent = new Parent(request.getParameter("prenom"), request.getParameter("nom"), request.getParameter("cin"),
                                request.getParameter("tel"), request.getParameter("email"), request.getParameter("tel"), id);
                    out.print(ps.add(parent));
                    break;
                case "delete":
                    parent = new Parent(Integer.parseInt(request.getParameter("id")));
                    ps.delete(parent);
                    break;
                case "update":
                    parent = new Parent(Integer.parseInt(request.getParameter("id")), request.getParameter("prenom"), request.getParameter("nom"), request.getParameter("cin"),
                                request.getParameter("tel"), request.getParameter("email"), request.getParameter("profession"), id);
                    ps.update(parent.getID(), parent);
                    break;
                default:
                    Famille famille = fs.get(id);
                    System.err.println((famille == null) + " | " + (ps == null));
                    request.setAttribute("num_adhesion", id);
                    request.setAttribute("tuteur", ps.get(famille.getID_TUTEUR()));
                    request.setAttribute("parents", ps.getByFamily(id, famille.getID_TUTEUR()));
                    request.getRequestDispatcher("WEB-INF/views/famille/parents.jsp").forward(request, response);
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
