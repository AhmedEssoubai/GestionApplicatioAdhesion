/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Services.*;
import Models.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zed
 */
@WebServlet(name = "Signin", urlPatterns = {"/Signin"})
public class Signin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Signin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Signin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
            ParentService P = new ParentService();
            UserService U = new UserService();
            FamillieService F = new FamillieService();
            String nom=request.getParameter("nom");
            String prenom=request.getParameter("prenom");
            String cin=request.getParameter("cin");
            String email=request.getParameter("email");
            String password=request.getParameter("password");                                       
            String tel=request.getParameter("tel");
            String profession=request.getParameter("profession");
            String recevoir=request.getParameter("recevoir");
            
            
            Parents Pa= new Parents(prenom, nom, cin, tel, email, profession);
            Utilisateur User = new Utilisateur(email, password);
            P._Add(Pa);
            Pa=P._get_by_cin(cin);
            U._Add(User);
            User=U._verify(email, password);
            if(!request.getParameter("delegue").equals("")){
                if(!request.getParameter("recevoir").equals("")){
                    Famille f = new Famille(User.getID(),Pa.getID(),Integer.parseInt(recevoir));
                     F._Add(f);
                    Pa.setID_famille(f.getID_famille());
                }
                else {
                     Famille f1 = new Famille(User.getID(),Pa.getID(),0);
                     F._Add(f1);
                    Pa.setID_famille(f1.getID_famille());
                    }
            }
            response.sendRedirect(request.getContextPath() + "/Login");
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
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
