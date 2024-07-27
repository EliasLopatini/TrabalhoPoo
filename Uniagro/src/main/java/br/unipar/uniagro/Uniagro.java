/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.uniagro;

import br.unipar.uniagro.domain.Marca;
import br.unipar.uniagro.infraestructure.DataBaseConection;
import br.unipar.uniagro.services.MarcaService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Uniagro {

    public static void main(String[] args) {
        
     
         /*
            RQF.001 - MANTER MARCA
            RQF.002 - MANTER UM PRODUTO
            RQF.003 - MANTER LOTES DO PRODUTOS(Produto, Dt Fabric.,
            Dt. Validade,
            Numero do Lote(AZ-O1JAJ2,
            Quantidade,
            Observacao))
            RQF.004 - MANTER CLIENTE(Nome, Cpf, Endereco, Telefone)
            RQF.005 - MANTER FORMAS DE PAGAMENTO(Id, Nome)
        
            RQF.006 - REALIZAR VENDA
            */
            
         try{
            Marca marca = new Marca();
            marca.setNome(UUID.randomUUID().toString());
            
            MarcaService marcaService = new MarcaService();
            marcaService.insert(marca);
            
            Marca basf = new Marca();
            basf.setId(2);
            basf.setNome("BASF-adhadjhajshgdhgasdjgh");
            
            marcaService.update(basf);
            
            marcaService.deleteById(basf.getId());
            
            ArrayList<Marca> resultado = marcaService.findAll();
            System.out.println(resultado.toString());
            
            Marca resultadoFindById = marcaService.findById(2);
            System.out.println(resultadoFindById.toString());
            
        } catch (Exception ex) {
            
        }
            
            
    }
}
