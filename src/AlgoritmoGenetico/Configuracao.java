/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmoGenetico;

/**
 *
 * @author Joshua Raiser
 */
public class Configuracao {

    private boolean mostrarEvolucao;
    private float taxaMutacao;
    private int numeroEvolucoes;
    private int numeroCidades;
    private int numeroPopulacoes;

    public Configuracao(boolean mostrarEvolucao, float taxaMutacao, int numeroEvolucoes, int numeroCidades, int numeroPopulacoes) {
        this.mostrarEvolucao = mostrarEvolucao;
        this.taxaMutacao = taxaMutacao;
        this.numeroEvolucoes = numeroEvolucoes;
        this.numeroCidades = numeroCidades;
        this.numeroPopulacoes = numeroPopulacoes;
    }

    public int getNumeroCidades() {
        return numeroCidades;
    }

    public int getNumeroPopulacoes() {
        return numeroPopulacoes;
    }

    public boolean isMostrarEvolucao() {
        return mostrarEvolucao;
    }

    public float getTaxaMutacao() {
        return taxaMutacao;
    }

    public int getNumeroEvolucoes() {
        return numeroEvolucoes;
    }

    public void setMostrarEvolucao(boolean mostrarEvolucao) {
        this.mostrarEvolucao = mostrarEvolucao;
    }

    public void setTaxaMutacao(float taxaMutacao) {
        this.taxaMutacao = taxaMutacao;
    }

    public void setNumeroEvolucoes(int numeroEvolucoes) {
        this.numeroEvolucoes = numeroEvolucoes;
    }

}
