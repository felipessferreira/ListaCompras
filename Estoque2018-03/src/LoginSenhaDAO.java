

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static sun.security.jgss.GSSUtil.login;


public class LoginSenhaDAO {
    
    private Connection conexao;
    
    public LoginSenhaDAO () throws SQLException {
      this.conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/estoque2018", "root", "???");
      System.out.println("Conexao: " + this.conexao);
    }

  public boolean consultaLogin (String u, String s ){
    String sql = "select * from estoque2018.login where login=? and senha=?";
    
    try {
    PreparedStatement ps = this.conexao.prepareStatement(sql);
        Object login = null;
        ps.setString(1, u);
        Object senha = null;
        ps.setString(2, s);
        ResultSet rs = ps.executeQuery();
        boolean first = rs.first();
        if (first == true){
        
            System.out.println("Usuário logado!");
            

    }
        
        return first;
    }
    catch (SQLException ex) {
            Logger.getLogger(LoginSenhaDAO.class.getName()).log(Level.SEVERE, null, ex);
        
   }
   return false;
    }

    void consultalogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
