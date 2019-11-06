package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexionSQL {
    Connection con;
    
    public Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/escuela2","werner","1234");
            //JOptionPane.showMessageDialog(null,"Connection status: OK");
        }catch (Exception e)
        {
                    JOptionPane.showMessageDialog(null,"Error en la conexion de base de datos");
                            }
            return con;
    }    
    
}
