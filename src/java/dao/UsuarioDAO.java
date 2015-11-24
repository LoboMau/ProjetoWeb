
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author LoboMau
 */
public class UsuarioDAO {
   
    
    public UsuarioDAO()
    {
    
    }
    
    public boolean inserir(Usuario usuario)
    {
        String sql = "INSERT INTO usuario(nome,apelido,email,senha) VALUES(?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = ConectaBd.getPreparedStatement(sql);
        try {
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getApelido());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getSenha());
            
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean atualizar(Usuario usuario)
    {
        String sql = "UPDATE usuario set nome=?,apelido=?,email=?, senha=? where id_usuario=?";
        Boolean retorno = false;
        PreparedStatement pst = ConectaBd.getPreparedStatement(sql);
        try {
          
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getApelido());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getSenha());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean excluir(Usuario usuario)
    {
        String sql = "DELETE FROM usuario where nome=?";
        Boolean retorno = false;
        PreparedStatement pst = ConectaBd.getPreparedStatement(sql);
        try {
          
           
            pst.setString(1, usuario.getNome());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    
    public List<Usuario> listar()
    {
         String sql = "SELECT * FROM usuario";
        List<Usuario> retorno = new ArrayList<Usuario>();
        
        PreparedStatement pst = ConectaBd.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Usuario item = new Usuario();
                item.setNome(res.getString("nome"));
                item.setApelido(res.getString("apelido"));
                item.setEmail(res.getString("email"));
                item.setSenha(res.getString("senha"));
                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    public Usuario buscar(Usuario usuario)
    {
         String sql = "SELECT * FROM usuario where nome=?";
        Usuario retorno = null;
        
        PreparedStatement pst = ConectaBd.getPreparedStatement(sql);
        try {
           
            pst.setString(1, usuario.getNome());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Usuario();
                retorno.setNome(res.getString("nome"));
                retorno.setApelido(res.getString("apelido"));
                retorno.setEmail(res.getString("email"));
                retorno.setEmail(res.getString("senha"));
                
                
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }


}
