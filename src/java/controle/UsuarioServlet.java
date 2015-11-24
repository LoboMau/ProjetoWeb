
package controle;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

   
    private UsuarioDAO usuarioDAO;

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        usuarioDAO = new UsuarioDAO();
        
        String id_usuario = request.getParameter("id_usuario");
        String nome = request.getParameter("name");
        String apelido = request.getParameter("apelido");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String operation = request.getParameter("operation");

        Usuario usuario = new Usuario(id_usuario, nome, apelido, email, senha);

        if (operation.equalsIgnoreCase("inserir")) {
            usuarioDAO.inserir(usuario);
            request.setAttribute("usuario", usuario);
        } else if (operation.equalsIgnoreCase("Edit")) {
            usuarioDAO.atualizar(usuario);
            Usuario buscarUsuario = (Usuario) usuarioDAO.listar();
            request.setAttribute("usuario", buscarUsuario);
        } else if (operation.equalsIgnoreCase("Delete")) {
            usuarioDAO.excluir(usuario);
        } else if (operation.equalsIgnoreCase("Buscar")) {
            Usuario buscarUsuario = null;
            usuarioDAO.buscar(usuario);
            request.setAttribute("usuario", buscarUsuario);
        }
        request.getRequestDispatcher("usuarioinfo.jsp").forward(request, response);
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Breve descrição";
    }
}
