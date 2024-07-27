/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.uniagro.domain;

import br.unipar.uniagro.enums.ClasseProdutoEnum;
import br.unipar.uniagro.enums.StatusProdutoEnum;

/**
 *
 * @author 00236544
 */
public class Produto extends BaseEntity{
    private String nome;
    private Double vlrPreco;
    private ClasseProdutoEnum classe;
    private StatusProdutoEnum status;
    private Marca marca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getVlrPreco() {
        return vlrPreco;
    }

    public void setVlrPreco(Double vlrPreco) {
        this.vlrPreco = vlrPreco;
    }

    public ClasseProdutoEnum getClasse() {
        return classe;
    }

    public void setClasse(ClasseProdutoEnum classe) {
        this.classe = classe;
    }

    public StatusProdutoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusProdutoEnum status) {
        this.status = status;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
   
}
