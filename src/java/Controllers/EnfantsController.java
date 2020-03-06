package Controllers;

import Models.Enfant;
import Models.Famille;
import Services.EnfantService;
import Services.FamillieService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "EnfantsController", urlPatterns = {"/Enfants"})
public class EnfantsController extends Controller {
    

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
            EnfantService es = new EnfantService(getData());
            String action = request.getParameter("action");
            Enfant enfant;
            if (action == null)
                action = "";
            switch(action)
            {
                case "add":
                    enfant = new Enfant(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("cne"), new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date_naissance")),
                                request.getParameter("classe"), request.getParameter("assurance"), id);
                    out.print(es.add(enfant));
                    break;
                case "delete":
                    enfant = new Enfant(Integer.parseInt(request.getParameter("id")));
                    es.delete(enfant);
                    break;
                case "update":
                    enfant = new Enfant(Integer.parseInt(request.getParameter("id")), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("cne"), 
                            new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date_naissance")),
                                request.getParameter("classe"), request.getParameter("assurance"), id);
                    es.update(enfant.getID(), enfant);
                    break;
                default:
                    Famille famille = fs.get(id);
                    request.setAttribute("num_adhesion", id);
                    request.setAttribute("enfants", es.getByFamily(id));
                    request.getRequestDispatcher("WEB-INF/views/famille/enfants.jsp").forward(request, response);
                    break;
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException | ParseException ex) {
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
