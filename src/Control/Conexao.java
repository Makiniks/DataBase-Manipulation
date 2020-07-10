/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Conexao {
    
    public Connection getConnection() {
        
        try {
            
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/dados","root","");
            
        }
        
        catch(SQLException excecao){
            
            throw new RuntimeException(excecao);
            
        }
    }
    
}
