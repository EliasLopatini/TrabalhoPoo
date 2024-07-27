/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.uniagro.services;

import br.unipar.uniagro.domain.FormaPagamento;
import br.unipar.uniagro.exceptions.BussinesException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 00236544
 */
public class FormaPagamentoService {
    public FormaPagamento insert(FormaPagamento formaPagamento) throws Exception, BussinesException{
        if(formaPagamento.getId()!= null){
            throw new Exception("Para a inserção nao devese informar um id");
        }
        validate(formaPagamento);
        
        formaPagamento.setDtInsercao(new Date());
        formaPagamento.setDtAtualizacao(new Date());
        
        
        
        //chamar o repo
        return formaPagamento;
    }
    
    public FormaPagamento update(FormaPagamento formaPagamento)throws Exception{
        ValidateId(formaPagamento.getId());
        validate(formaPagamento);
        
        formaPagamento.setDtAtualizacao(new Date());
        
        //chamar o repo
        return formaPagamento;
    }
    
    public void deleteById(Integer id) throws Exception{
        
        //chamar o repo
        ValidateId(id);
    }
    public ArrayList<FormaPagamento> findaAll(){
        //chamar o repo
        return new ArrayList<FormaPagamento>();
    }
    
    public FormaPagamento findById(Integer id) throws Exception{
        ValidateId(id);
        
        //chamar o repo
        return new FormaPagamento();
    }
    
    private void validate(FormaPagamento formaPagamento)throws Exception{
        if((formaPagamento.getNome() == null) ||
          (formaPagamento.getNome().isEmpty())||
          (formaPagamento.getNome().length()<3)){
            throw new BussinesException("O nome da forma de pagamento é obrigatorio");
        }
}
    
    
    private void ValidateId(Integer id) throws Exception{
        if(id == null){
            throw new Exception("O ID é Obrigatorio");
        }
        
    }
}
