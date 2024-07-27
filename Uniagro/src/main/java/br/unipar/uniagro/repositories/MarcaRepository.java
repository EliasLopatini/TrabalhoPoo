/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.uniagro.repositories;

import br.unipar.uniagro.domain.Marca;
import br.unipar.uniagro.infraestructure.DataBaseConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author 00236544
 */
public class MarcaRepository {
    
   private static final String INSERT = 
            "INSERT INTO MARCA(NOME, DT_INSERCAO, DT_ATUALIZACAO) " +
            "VALUES(?, ?, ?)";
    private static final String UPDATE = 
            "UPDATE MARCA SET NOME = ?, DT_ATUALIZACAO = ? " +
            "WHERE ID = ?";
    private static final String DELETE = 
            "DELETE FROM MARCA WHERE ID = ?";
    private static final String FIND_ALL = 
            "SELECT " +
            "	ID, NOME, DT_INSERCAO, DT_ATUALIZACAO " +
            "FROM MARCA";
    private static final String FIND_BY_ID = 
            "SELECT " +
            "	ID, NOME, DT_INSERCAO, DT_ATUALIZACAO " +
            "FROM MARCA WHERE ID = ?";
    
    public Marca insert(Marca marca) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = new DataBaseConection().getConnection();
            
            pstmt = conn.prepareStatement(INSERT, 
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, marca.getNome());
            pstmt.setDate(2, new Date(marca.getDtInsercao().getTime()));
            pstmt.setDate(3, new Date(marca.getDtAtualizacao().getTime()));
            
            pstmt.executeUpdate();
  
            rs = pstmt.getGeneratedKeys();
            rs.next();
            
            marca.setId(rs.getInt(1));
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
        
        return marca;
    }
    
    public Marca update(Marca marca) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseConection().getConnection();
            
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, marca.getNome());
            pstmt.setDate(2, new Date(marca.getDtAtualizacao().getTime()));
            pstmt.setInt(3, marca.getId());
            
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
        
        return marca;
    }
    
    public void delete(Integer id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseConection().getConnection();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }
    
    public ArrayList<Marca> findAll() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Marca> resultados = new ArrayList<>();
        
        try {
            conn = new DataBaseConection().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                Marca marca = new Marca();
                marca.setId(rs.getInt("ID"));
                marca.setNome(rs.getString("NOME"));
                marca.setDtInsercao(rs.getDate("DT_INSERCAO"));
                marca.setDtAtualizacao(rs.getDate("DT_ATUALIZACAO"));
            
                resultados.add(marca);
            }
            
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) rs.close();
        }
        
        return resultados;
    }
    
    public Marca findById(Integer id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Marca marca = new Marca();
        
        try {
            conn = new DataBaseConection().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                marca.setId(rs.getInt("ID"));
                marca.setNome(rs.getString("NOME"));
                marca.setDtInsercao(rs.getDate("DT_INSERCAO"));
                marca.setDtAtualizacao(rs.getDate("DT_ATUALIZACAO"));
            }
            
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) rs.close();
        }
        
        return marca;
    }
}
