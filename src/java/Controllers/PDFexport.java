package Controllers;

import Models.Enfant;
import Models.Parent;
import Services.EnfantService;
import Services.FamillieService;
import Services.ParentService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;

/**
 *
 * @author Zed
 */
@WebServlet(name = "PDFexport", urlPatterns = {"/Export"})
public class PDFexport extends Controller {
    
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
        String num = request.getParameter("num");
        if (num == null || num.isEmpty())
        {
            response.sendRedirect("Accueil");
            return;
        }
        int id = Integer.parseInt(num);
        
        List<Enfant> enfants = new ArrayList<>();
        Parent tuteur = null;
        try
        {
            FamillieService fs = new FamillieService(getData());
            int id_tut = fs.get(id).getID_TUTEUR();
            ParentService ps = new ParentService(getData());
            tuteur = ps.get(id_tut);
            EnfantService es = new EnfantService(getData());
            enfants = es.getByFamily(id);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PDFexport.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setContentType("application/pdf;charset=UTF-8");

        response.addHeader("Content-Disposition", "inline; filename=" + "document.pdf");
        ServletOutputStream out = response.getOutputStream();

        ByteArrayOutputStream baos = getPdfFile(tuteur, enfants);
        baos.writeTo(out);
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
        processRequest(request, response);
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

    private static ByteArrayOutputStream getPdfFile(Parent tuteur,  List<Enfant> enfants) {

        Document document = new Document();
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(8);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{1, 3, 3, 3, 3, 3, 3, 2});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("#", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Nom", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Prenom", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("CNE", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Date naissence", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Grade", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Assurance", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Prix", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);
            float total = 0;

            for (Enfant enfant : enfants) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(String.valueOf(enfant.getID())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(enfant.getNom()));
                //cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(enfant.getPrenom()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(enfant.getCne()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(enfant.getDate_naissence().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(enfant.getGrade()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(enfant.getAssurance()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                float prix = enfant.getAssurance().equals("Assurance Hospitalisation") ? 500 : 450;
                cell = new PdfPCell(new Phrase(prix + " DH"));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                total += prix;
            }

            PdfWriter.getInstance(document, bout);
            document.open();
            document.addTitle("Document d'adhésion");
            Font hFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 28);
            Font rFont = FontFactory.getFont(FontFactory.HELVETICA, 16);
            Font bFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            // Ajoute le titre
            Paragraph preface = new Paragraph();
            addEmptyLine(preface, 1);
            preface.add(new Paragraph("Document d'adhésion", hFont));
            addEmptyLine(preface, 2);
            // Ajouter tuteur
            preface.add(new Paragraph(tuteur.getNom() + " " + tuteur.getPrenom(), bFont));
            addEmptyLine(preface, 1);
            preface.add(new Paragraph("CIN : " + tuteur.getCin(), rFont));
            addEmptyLine(preface, 1);
            preface.add(new Paragraph("Profession : " + tuteur.getProfession(), rFont));
            addEmptyLine(preface, 1);
            preface.add(new Paragraph("Email : " + tuteur.getEmail(), rFont));
            addEmptyLine(preface, 3);
            document.add(preface);
            document.add(table);
            // Ajouter prix
            preface = new Paragraph();
            addEmptyLine(preface, 2);
            preface.add(new Paragraph("Assurances des enfants : " + total + " DH", rFont));
            addEmptyLine(preface, 1);
            preface.add(new Paragraph("Coût total de l’adhésion  : 100 DH", rFont));
            addEmptyLine(preface, 1);
            total += 100;
            preface.add(new Paragraph("Coût Total : " + total + " DH", rFont));
            document.add(preface);
            
            document.close();
            
        } catch (DocumentException ex) {
        
            Logger.getLogger(PDFexport.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bout; 
    }
    
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
