package Controllers;

import Models.Enfant;
import Services.EnfantService;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ahmed
 */
@WebServlet(name = "AjouterEnfantController", urlPatterns = {"/AjouterEnfants"})
public class AjouterEnfantController extends Controller {

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
        boolean valid = true;
        
        if (valid)
            request.getRequestDispatcher("WEB-INF/views/famille/ajouter-enfants.jsp").forward(request, response);
        else
            response.sendRedirect("Accueil");
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
        String[] noms = request.getParameterValues("nom");
        String[] prenoms = request.getParameterValues("prenom");
        String[] cnes = request.getParameterValues("cne");
        String[] date_naissances = request.getParameterValues("date_naissance");
        String[] classes = request.getParameterValues("classe");
        String[] assurances = request.getParameterValues("assurance");
        
        try {
            EnfantService es = new EnfantService(getData());
            for(int i = 0; i < noms.length; i++)
            {
                Enfant enfant = new Enfant(noms[i], prenoms[i], cnes[i], new SimpleDateFormat("yyyy-MM-dd").parse(date_naissances[i]), 
                        classes[i], assurances[i], (int)request.getSession().getAttribute("num_adhesion"));
                
                es.add(enfant);
            }
            request.getSession().setAttribute("complete", true);
            response.sendRedirect("Parents");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException | ParseException e) {
            e.printStackTrace();
            response.sendRedirect("AjouterEnfants");
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
