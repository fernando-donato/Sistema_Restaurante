/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restauranteapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO {
    public void cadastrarClientes(Clientes clientes) throws SQLException {
        String sql = "INSERT INTO clientes (nome, telefone, email) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, clientes.getNome());
            stmt.setString(2, clientes.getTelefone());
            stmt.setString(3, clientes.getEmail());
            stmt.executeUpdate();
        }
    }
    
    public List<Clientes> listarClientes() throws SQLException {
        List<Clientes> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Clientes clientes = new Clientes();
                clientes.setId(rs.getInt("id_cliente"));
                clientes.setNome(rs.getString("nome"));
                clientes.setTelefone(rs.getString("telefone"));
                clientes.setEmail(rs.getString("email"));
                clientes.add(clientes);
            }
        }
        
        return clientes;
    }
}