/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.TPersonalJpaController;
import Model.TPersonal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ESTACION 2
 */
public class Guardar extends HttpServlet {

TPersonalJpaController controlador ;

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            // TPersonalJpaController controlador = new TPersonalJpaController();
            TPersonal personal = new TPersonal();
            
            personal.setId(Integer.parseInt(request.getParameter("id")));
            personal.setNombre(request.getParameter("nombre"));
            personal.setTelefono(request.getParameter("telefono"));
          
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitangieeDB");
            controlador = new TPersonalJpaController(emf);
            
            controlador.create(personal);
            response.sendRedirect("page1.jsp");
           
            try {
                /* TODO output your page here. You may use following sample code. */
               
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro guardado</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Registro guardado en" + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
                
            }
            
            finally {
                out.close();
            }
       
        } catch (Exception ex) {
            
        Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
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

}
