/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.veterinaria.models;

import java.util.ArrayList;

public class Consultas {
    private int id;
    private String date;
    private Animal animal;
    private MedicosVeterinarios veterinario;
    private ArrayList<Medicamentos> medicamentos = new ArrayList<>();
    private ArrayList<Exames> exames = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public MedicosVeterinarios getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(MedicosVeterinarios veterinario) {
        this.veterinario = veterinario;
    }

    public ArrayList<Medicamentos> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamentos> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public ArrayList<Exames> getExames() {
        return exames;
    }

    public void setExames(ArrayList<Exames> exames) {
        this.exames = exames;
    }
    
    
}
