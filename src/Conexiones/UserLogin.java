package Conexiones;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UserLogin extends conexionSQL{
	public boolean login(usuarios user){
		
		conexionSQL cc = new conexionSQL();
		Connection con = cc.conexion();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select usuario, password from usuarios where usuario = ?";
		
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsuario());
			rs = ps.executeQuery();

			if(rs.next()){
				if(user.getPassword().equals(rs.getString(2))){
					
					return true;
				} else{
					return false;
				}
			}
			return false;
			
		} catch(SQLException ex){
			return false;
		}
	}
}
