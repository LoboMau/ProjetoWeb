
package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LoboMau
 */

public class GetUsuario extends HttpServlet {
   private UsuarioDAO usuarioDAO;
  
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String id = request.getParameter("id");       
        Usuario usuario = (Usuario) usuarioDAO.listar();
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("usuarioinfo.jsp").forward(request, response);
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(GetUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(GetUsuario.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

   
    @Override
    public String getServletInfo() {
        return "Breve descrição";
    }
}
