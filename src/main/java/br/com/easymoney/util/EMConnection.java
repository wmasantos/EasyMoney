package br.com.easymoney.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Scope(value = "prototype")
public class EMConnection {
    private final String driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://192.168.7.35:5432/easymoney";
    private final String usuario = "cronos.homolog";
    private final String senha = "ENG1Homolog";
    private Connection con;

    public EMConnection() {
        try {
            Class.forName(driver);            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EMConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }  
    
    public Connection getConnection(){
        if(con == null){
            try {
                con = DriverManager.getConnection(url, usuario, senha);
                con.setAutoCommit(false);
                return con;
            } catch (SQLException ex) {
                Logger.getLogger(EMConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
           return con; 
        }
        
        return null;
    }
    
    public boolean closeConnection(){
        try {
            con.close();
            con = null;
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EMConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
