/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.uniagro.services;

import br.unipar.uniagro.domain.Marca;
import br.unipar.uniagro.exceptions.BussinesException;
import br.unipar.uniagro.repositories.MarcaRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MarcaService {
    
    public Marca insert(Marca marca) throws Exception, BussinesException{
        if(marca.getId()!= null){
            throw new Exception("Para a inserção nao devese informar um id");
        }
        validate(marca);
        
        marca.setDtInsercao(new Date());
        marca.setDtAtualizacao(new Date());
     
        new MarcaRepository().insert(marca);
        return marca;
    }
    
    public Marca update(Marca marca)throws Exception{
        ValidateId(marca.getId());
        validate(marca);
        
        marca.setDtAtualizacao(new Date());
        
        new MarcaRepository().update(marca);
        return marca;
    }
    
    public void deleteById(Integer id) throws Exception{
        
        new MarcaRepository().delete(id);
        ValidateId(id);
    }
    public ArrayList<Marca> findAll() throws SQLException{
        return new MarcaRepository().findAll();
    }
    
    public Marca findById(Integer id) throws Exception{
        ValidateId(id);
        
        //chamar o repo
        return new Marca();
    }
    
    private void validate(Marca marca)throws Exception{
        if((marca.getNome() == null) ||
          (marca.getNome().isEmpty())||
          (marca.getNome().length()<3)){
            throw new BussinesException("O nome da marca é obrigatorio");
        }
}
    
    
    private void ValidateId(Integer id) throws Exception{
        if(id == null){
            throw new Exception("O ID é Obrigatorio");
        }
        
    }
}
