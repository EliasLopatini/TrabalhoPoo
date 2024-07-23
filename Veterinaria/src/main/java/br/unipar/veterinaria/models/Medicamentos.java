/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.veterinaria.models;

import java.util.ArrayList;

/**
 *
 * id: Identificador único do medicamento
nome: Nome do medicamento
descrição: Descrição ou detalhes sobre o medicamento
consultas: Lista de consultas em que o medicamento foi utilizado
 */
public class Medicamentos {
    
    private int id;
    private String nome;
    private String descricao;
    private ArrayList<Consultas> consulta = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Consultas> getConsulta() {
        return consulta;
    }

    public void setConsulta(ArrayList<Consultas> consulta) {
        this.consulta = consulta;
    }
    
    
}
