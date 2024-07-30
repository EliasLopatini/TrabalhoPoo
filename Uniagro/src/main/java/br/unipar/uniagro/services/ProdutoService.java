/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.uniagro.services;

import br.unipar.uniagro.domain.Marca;
import br.unipar.uniagro.domain.Produto;
import br.unipar.uniagro.exceptions.BussinesException;
import br.unipar.uniagro.repositories.ProdutoRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 00236544
 */
public class ProdutoService {
    public Produto insert(Produto produto) throws Exception{
        if(produto.getId()!= null){
            throw new Exception("Para a inserção nao devese informar um id");
        }
        validate(produto);
        
        produto.setDtInsercao(new Date());
        produto.setDtAtualizacao(new Date());
        new ProdutoRepository().insert(produto);
        return produto;
    }
    
    public Produto update(Produto produto)throws Exception{
        ValidateId(produto.getId());
        validate(produto);
        produto.setDtAtualizacao(new Date());
        new ProdutoRepository().update(produto);
        return produto;
    }
    
    public void deleteById(Integer id) throws Exception{
        new ProdutoRepository().delete(id);
        ValidateId(id);
    }
    public ArrayList<Produto> findaAll() throws SQLException{
         return new ProdutoRepository().findAll();
    }
    
    public Produto findById(Integer id) throws Exception{
        ValidateId(id);
        return new ProdutoRepository().findById(id);
    }
    
    private void validate(Produto produto)throws Exception{
        if((produto.getNome() == null) ||
          (produto.getNome().length()<3)||
          (produto.getNome().length()>60)){
            throw new BussinesException("O nome do ptoduto é obrigatorio e nao deve"
                                     +" posssuir mais de 60 caracteres e menos de 3");
        }
        if(produto.getMarca() == null){
            throw new BussinesException("A marca é obrigatorio");
        }
        if(produto.getClasse() == null){
             throw new BussinesException("a classe é obrigatorio");
        }
        if(produto.getVlrPreco() == null){
            throw new BussinesException("O preço é obrigatorio");
        }
        if(produto.getVlrPreco() <= 0.0){
            throw new BussinesException("O preço deve ser maior que 0");
        }
        if(produto.getStatus()== null){
            throw new BussinesException("O Status do produto é obrigatorio");
        }
}
    
    private void ValidateId(Integer id) throws Exception{
        if(id == null){
            throw new Exception("O ID é Obrigatorio");
        }
}
}
