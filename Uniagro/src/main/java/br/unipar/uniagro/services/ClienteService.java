/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.uniagro.services;

import br.unipar.uniagro.domain.Cliente;
import br.unipar.uniagro.domain.LotesProduto;
import br.unipar.uniagro.exceptions.BussinesException;
import br.unipar.uniagro.repositories.MarcaRepository;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 00236544
 */
public class ClienteService {
      public Cliente insert(Cliente cliente) throws Exception, BussinesException{
        if(cliente.getId()!= null){
            throw new Exception("Para a inserção nao devese informar um id");
        }
        validate(cliente);
        
        cliente.setDtInsercao(new Date());
        cliente.setDtAtualizacao(new Date());
        
        
        
        //chamar o repo
        return cliente;
    }
    
    public Cliente update(Cliente cliente)throws Exception{
        ValidateId(cliente.getId());
        validate(cliente);
        
        cliente.setDtAtualizacao(new Date());
        
        
        return cliente;
    }
    
    public void deleteById(Integer id) throws Exception{
        
        //chamar o repo
        ValidateId(id);
    }
    public ArrayList<Cliente> findaAll(){
        //chamar o repo
        return new ArrayList<Cliente>();
    }
    
    public Cliente findById(Integer id) throws Exception{
        ValidateId(id);
        
        //chamar o repo
        return new Cliente();
    }
    
// private String nome;
//    private String cpf;
//    private String endereco;
//    private String telefone;
    private void validate(Cliente cliente)throws Exception{
   
        if((cliente.getNome()== null) ||
          (cliente.getNome().length()<3)||
          (cliente.getNome().length()>60)){
           throw new BussinesException("O nome do cliente é obrigatorio e nao deve"
                                     +" posssuir mais de 60 caracteres e menos de 3");
        }
        if((cliente.getCpf()== null) ||
          (cliente.getCpf().length()<11)||
          (cliente.getCpf().length()>11)){
           throw new BussinesException("0 cpf é obrigatori0 e nao deve"
                                     +" posssuir 11 caracteres");
        }
        if((cliente.getTelefone()== null) ||
          (cliente.getTelefone().length()<11)||
          (cliente.getTelefone().length()>11)){
           throw new BussinesException("0 telefone é obrigatori0 e nao deve"
                                     +" posssuir 11 caracteres");
        }
        if((cliente.getEndereco()== null) ||
          (cliente.getEndereco().length()<10)||
          (cliente.getEndereco().length()>60)){
           throw new BussinesException("o endereço é obrigatori0 e nao deve"
                                     +" posssuir mais de 60 caracteres e menos de 10");
        }
}
    
    
    private void ValidateId(Integer id) throws Exception{
        if(id == null){
            throw new Exception("O ID é Obrigatorio");
        }
        
    }
}
