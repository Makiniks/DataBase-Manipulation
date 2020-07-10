/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Cliente;
import Model.Nicho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Comandos {
    
    Connection conexao;
    
    public Comandos() {
        
        this.conexao = new Conexao().getConnection();
        
    }
    
    public void Selecionar(String sql) {
        
        try {
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            
        }
        
        catch (SQLException u) {
            
            
            
        }
        
    }
    
    public void Inserir_Cliente(Cliente cliente) {
        
        String sql = "insert into dados.clientes(Nicho, Status, Nome, Email) values(?, ?, ?, ?)";
        
        try {
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cliente.getNicho());
            stmt.setBoolean(2, cliente.isStatus());
            stmt.setString(3, cliente.getNome());
            stmt.setString(4, cliente.getEmail());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente inserido.");
            
        }
        
        catch (SQLException u) {
            
            JOptionPane.showMessageDialog(null, "Falha ao inserir cliente: " + u);
            
        }
        
    }
    
    public void Inserir_Nicho(Nicho nicho) {
        
        String sql = "insert into dados.nichos(Nicho) values(?)";
        
        try {
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nicho.getNicho());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Nicho inserido.");
            
        }
        
        catch (SQLException u) {
            
            JOptionPane.showMessageDialog(null, "Falha ao inserir nicho: " + u);
            
        }
        
    }
    
    public void Alterar(Cliente cliente) {
        
        String sql = "update dados.clientes set Nicho = ?, Nome = ?, Email = ? where ID = ?";
        
        try {
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, cliente.getNicho());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getID());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado.");
            
        }
        
        catch (SQLException u) {
            
            JOptionPane.showMessageDialog(null, "Falha ao atualizar dados.");
            
        }
        
    }
    
    public void Deletar(int ID) {
        
        String sql = "delete from clientes where ID = ?";
        
        try {
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, ID);
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente deletado.");
            
        }
        
        catch (SQLException u) {
            
            JOptionPane.showMessageDialog(null, "Falha ao deletar cliente " + ID + ".");
            
        }
        
    }
    
}
