package Controllers;

import Models.Enfant;
import Models.FactureItem;
import Services.EnfantService;
import Services.FamillieService;
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
@WebServlet(name = "FactureController", urlPatterns = {"/Facture"})
public class FactureController extends Controller {
    

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
            FamillieService fs = new FamillieService(getData());
            EnfantService es = new EnfantService(getData());
            ArrayList<FactureItem> factureItems = new ArrayList<>();
            factureItems.add(new FactureItem("Adhésion", 100));
            float total = 100;
            ArrayList<Enfant> enfants = es.getByFamily(id);
            for(Enfant enfant : enfants)
            {
                float prix = 450;
                if (enfant.getAssurance().equals("Assurance Hospitalisation"))
                    prix = 500;
                factureItems.add(new FactureItem("Assurance de " + enfant.getPrenom() + " " + enfant.getNom(), prix));
                total += prix;
            }
            request.setAttribute("num_adhesion", id);
            request.setAttribute("items", factureItems);
            request.setAttribute("total", total);
            request.getRequestDispatcher("WEB-INF/views/famille/facture.jsp").forward(request, response);
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
