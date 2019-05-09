package com.example.meauapp;

import java.util.ArrayList;

public class Animal {
    private String NomeAnimal, Especie, Sexo, Idade,Porte, Doencas, SobreAnimal;
    private ArrayList<String> Temperamento,Saude, Exigencias;
    public Animal() {

    }

    public String getNomeAnimal() {
        return NomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        NomeAnimal = nomeAnimal;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String especie) {
        Especie = especie;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getIdade() {
        return Idade;
    }

    public void setIdade(String idade) {
        Idade = idade;
    }

    public String getPorte() {
        return Porte;
    }

    public void setPorte(String porte) {
        Porte = porte;
    }

    public String getDoencas() {
        return Doencas;
    }

    public void setDoencas(String doencas) {
        Doencas = doencas;
    }

    public String getSobreAnimal() {
        return SobreAnimal;
    }

    public void setSobreAnimal(String sobreAnimal) {
        SobreAnimal = sobreAnimal;
    }

    public ArrayList<String> getTemperamento() {
        return Temperamento;
    }

    public void setTemperamento(ArrayList<String> temperamento) {
        Temperamento = temperamento;
    }

    public ArrayList<String> getSaude() {
        return Saude;
    }

    public void setSaude(ArrayList<String> saude) {
        Saude = saude;
    }

    public ArrayList<String> getExigencias() {
        return Exigencias;
    }

    public void setExigencias(ArrayList<String> exigencias) {
        Exigencias = exigencias;
    }
}