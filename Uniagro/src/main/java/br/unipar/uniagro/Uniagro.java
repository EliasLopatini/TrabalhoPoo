/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.uniagro;

import br.unipar.uniagro.domain.Marca;
import br.unipar.uniagro.domain.Produto;
import br.unipar.uniagro.enums.ClasseProdutoEnum;
import br.unipar.uniagro.enums.StatusProdutoEnum;
import br.unipar.uniagro.infraestructure.DataBaseConection;
import br.unipar.uniagro.services.MarcaService;
import br.unipar.uniagro.services.ProdutoService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Uniagro {

    public static void main(String[] args) throws Exception {
         /*
           /*
            RQF.001 - MANTER MARCA   - OK
            RQF.002 - MANTER UM PRODUTO
            RQF.003 - MANTER LOTES DO PRODUTOS(Produto, Dt Fabric.,
            Dt. Validade,
            Numero do Lote(AZ-O1JAJ2),
            Quantidade,
            Observacao)
            RQF.004 - MANTER CLIENTE(Nome, Cpf, Endereco, Telefone)
            RQF.005 - MANTER FORMAS DE PAGAMENTO(Id, Nome)
            RQF.006 - REALIZAR VENDA - Não precisa para o trabalho
            */
            
//         try{
            Marca marca = new Marca();
            marca.setNome(UUID.randomUUID().toString());
            
            Marca marca1 = new Marca();
            marca1.setNome("SUMITOMO");
            
            
//            
            MarcaService marcaService = new MarcaService();
            marcaService.insert(marca1);
            marcaService.insert(marca);
            
            
//            
//            Marca basf = new Marca();
//            basf.setId(2);
//            basf.setNome("BASF-adhadjhajshgdhgasdjgh");
//            
//            marcaService.update(basf);
//            
//            marcaService.deleteById(basf.getId());
//            
//            ArrayList<Marca> resultado = marcaService.findAll();
//            System.out.println(resultado.toString());
//            
//            Marca resultadoFindById = marcaService.findById(2);
//            System.out.println(resultadoFindById.toString());
//            
//        } catch (Exception ex) {
            
//        }
         
        try{
            Produto produto = new Produto();
            produto.setNome("SUMYRODI");
            produto.setClasse(ClasseProdutoEnum.FUNGICIDA);
            produto.setDtAtualizacao(new Date());
            produto.setMarca(marca);
            produto.setVlrPreco(120.0);
            produto.setStatus(StatusProdutoEnum.ATIVO);
            
            ProdutoService ps = new ProdutoService();
            ps.insert(produto);
            
            Produto produto2 = new Produto();
            produto2.setId(32);
            produto2.setNome("TRICEA");
            produto2.setClasse(ClasseProdutoEnum.HERBICIDA);
            produto2.setDtAtualizacao(new Date());
            produto2.setMarca(marca1);
            produto2.setVlrPreco(240.0);
            produto2.setStatus(StatusProdutoEnum.INATIVO);
            
            
            ps.update(produto2);
           ps.deleteById(31);
//            
//            
//            ArrayList<Produto> produtos = ps.findaAll();
//            System.out.println(produtos.toString());
//            
//            
            Produto resultadoFindByIdProduto = ps.findById(32);
            System.out.println(resultadoFindByIdProduto.toString());
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            
            
    }
}
