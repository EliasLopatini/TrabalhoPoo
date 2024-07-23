/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.veterinaria.models;

import java.util.ArrayList;

public class Animal {
    
    private int id;
    private String nome;
    private String especie;
    private String Raca;
    private Proprietario proprietario;
    private ArrayList<Vacinas> vacinas = new ArrayList<>();
    private ArrayList<Consultas> consultas = new ArrayList<>();
    private ArrayList<BanhoETosa> banhosETosas = new ArrayList<>();

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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String Raca) {
        this.Raca = Raca;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public ArrayList<Vacinas> getVacinas() {
        return vacinas;
    }

    public void setVacinas(ArrayList<Vacinas> vacinas) {
        this.vacinas = vacinas;
    }

    public ArrayList<Consultas> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consultas> consultas) {
        this.consultas = consultas;
    }

    public ArrayList<BanhoETosa> getBanhosETosas() {
        return banhosETosas;
    }

    public void setBanhosETosas(ArrayList<BanhoETosa> banhosETosas) {
        this.banhosETosas = banhosETosas;
    }
    
    
    
    
    
}
