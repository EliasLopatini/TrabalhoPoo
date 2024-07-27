/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.uniagro.services;
import br.unipar.uniagro.domain.LotesProduto;
import br.unipar.uniagro.exceptions.BussinesException;
import java.util.ArrayList;
import java.util.Date;


public class LoteProdutoService {
       public LotesProduto insert(LotesProduto lote) throws Exception, BussinesException{
        if(lote.getId()!= null){
            throw new Exception("Para a inserção nao devese informar um id");
        }
        validate(lote);
        
        lote.setDtInsercao(new Date());
        lote.setDtAtualizacao(new Date());
        
        
        
        //chamar o repo
        return lote;
    }
    
    public LotesProduto update(LotesProduto lote)throws Exception{
        ValidateId(lote.getId());
        validate(lote);
        
        lote.setDtAtualizacao(new Date());
        
        //chamar o repo
        return lote;
    }
    
    public void deleteById(Integer id) throws Exception{
        
        //chamar o repo
        ValidateId(id);
    }
    public ArrayList<LotesProduto> findaAll(){
        //chamar o repo
        return new ArrayList<LotesProduto>();
    }
    
    public LotesProduto findById(Integer id) throws Exception{
        ValidateId(id);
        
        //chamar o repo
        return new LotesProduto();
    }
    
    /**
 private Produto produto;
    private Date dtFab;
    private Date dtVenc;
    private String codLote;
    private long quantidade;
    private String observacao;
 */
    private void validate(LotesProduto lote)throws Exception{
        if(lote.getProduto()== null){
            throw new BussinesException("O data de fabricação é obrigatoria");
        }
        if(lote.getDtFab()== null){
            throw new BussinesException("O data de fabricação é obrigatoria");
        }
         if(lote.getDtVenc()== null){
            throw new BussinesException("O data de Vencimento é obrigatoria");
        }
        if((lote.getCodLote() == null) ||
          (lote.getCodLote().length()<3)||
          (lote.getCodLote().length()>60)){
           throw new BussinesException("O codigo do lote é obrigatorio e nao deve"
                                     +" posssuir mais de 60 caracteres e menos de 3");
        }
        if(lote.getQuantidade() == null){
            throw new BussinesException("O preço é obrigatorio");
        }
        if(lote.getQuantidade() >= 0){
            throw new BussinesException("O preço deve ser maior que 0");
        }
        if((lote.getObservacao()== null) ||
          (lote.getObservacao().length()<3)||
          (lote.getObservacao().length()>60)){
           throw new BussinesException("A observação é obrigatoria e nao deve"
                                     +" posssuir mais de 60 caracteres e menos de 3");
        }
}
    
    
    private void ValidateId(Integer id) throws Exception{
        if(id == null){
            throw new Exception("O ID é Obrigatorio");
        }
        
    }
}
