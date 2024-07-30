/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.uniagro.repositories;

import br.unipar.uniagro.domain.Marca;
import br.unipar.uniagro.domain.Produto;
import br.unipar.uniagro.enums.ClasseProdutoEnum;
import br.unipar.uniagro.enums.StatusProdutoEnum;
import br.unipar.uniagro.infraestructure.DataBaseConection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author 00236544
 */
public class ProdutoRepository {
    
    private static final String INSERT = 
            "INSERT INTO PRODUTO(NOME, VLR_PRECO, CLASSE, STATUS, DT_INSERCAO, DT_ATUALIZACAO, ID_MARCA) " +
            "VALUES(?, ?, ?,?, ?, ?,?)";
    private static final String UPDATE = 
            "UPDATE PRODUTO SET "
            + "NOME = ?, "
            + "VLR_PRECO = ?, "
            + "CLASSE = ?, "
            + "STATUS = ?, "
            + "DT_ATUALIZACAO = ?, "
            + "ID_MARCA = ? "
            + "WHERE ID = ?";
    private static final String DELETE = 
            "DELETE FROM PRODUTO WHERE ID = ?";
    private static final String FIND_ALL = 
            "SELECT " +
            "ID, NOME, VLR_PRECO, CLASSE, STATUS, DT_INSERCAO, DT_ATUALIZACAO, ID_MARCA " +
            "FROM PRODUTO";
    private static final String FIND_BY_ID = 
            "SELECT " +
            "ID, NOME, VLR_PRECO, CLASSE, STATUS, DT_INSERCAO, DT_ATUALIZACAO, ID_MARCA " +
            "FROM PRODUTO WHERE ID = ?";
    
    public Produto insert(Produto produto) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = new DataBaseConection().getConnection();
            
            pstmt = conn.prepareStatement(INSERT, 
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, produto.getNome());
            pstmt.setDouble(2, produto.getVlrPreco());
            pstmt.setString(3, produto.getClasse().name());
            pstmt.setString(4, produto.getStatus().name());
            pstmt.setDate(5, new Date(produto.getDtInsercao().getTime()));
            pstmt.setDate(6, new Date(produto.getDtAtualizacao().getTime()));
            pstmt.setInt(7, produto.getMarca().getId());
            
            pstmt.executeUpdate();
  
            rs = pstmt.getGeneratedKeys();
            rs.next();
            
            produto.setId(rs.getInt(1));
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
        
        return produto;
    }
    
    
    
    public Produto update(Produto produto) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DataBaseConection().getConnection();
            
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, produto.getNome());
            pstmt.setDouble(2, produto.getVlrPreco());
            pstmt.setString(3, produto.getClasse().name());
            pstmt.setString(4, produto.getStatus().name());
            pstmt.setDate(5, new Date(produto.getDtAtualizacao().getTime()));
            pstmt.setInt(6, produto.getMarca().getId());
            pstmt.setInt(7, produto.getId());
            
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
        
        return produto;
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
    
    public ArrayList<Produto> findAll() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
            conn = new DataBaseConection().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("ID"));
                p.setNome(rs.getString("NOME"));
                p.setDtInsercao(rs.getDate("DT_INSERCAO"));
                p.setDtAtualizacao(rs.getDate("DT_ATUALIZACAO"));
                p.setVlrPreco(rs.getDouble("VLR_PRECO"));
                p.setStatus(StatusProdutoEnum.valueOf(rs.getString("STATUS")));
                p.setClasse(ClasseProdutoEnum.valueOf(rs.getString("CLASSE")));
                p.setMarca(new MarcaRepository().findById(rs.getInt("ID_MARCA")));
                        
                produtos.add(p);
            }
            
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
        
        return produtos;
    }
    
    public Produto findById(Integer id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Produto p = new Produto();
        
        try {
            conn = new DataBaseConection().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                p.setId(rs.getInt("ID"));
                p.setNome(rs.getString("NOME"));
                p.setDtInsercao(rs.getDate("DT_INSERCAO"));
                p.setDtAtualizacao(rs.getDate("DT_ATUALIZACAO"));
                p.setVlrPreco(rs.getDouble("VLR_PRECO"));
                p.setStatus(StatusProdutoEnum.valueOf(rs.getString("STATUS")));
                p.setClasse(ClasseProdutoEnum.valueOf(rs.getString("CLASSE")));
                p.setMarca(new MarcaRepository().findById(rs.getInt("ID_MARCA")));         
            }
            
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
        
        return p;
    }
    
}
