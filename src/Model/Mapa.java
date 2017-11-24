/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Joshua Raiser
 */
public class Mapa {

    private int[][] mapa;

    /**
     * Construtor mapa
     *
     * @param mapa matriz de adjacência
     */
    public Mapa(int[][] mapa) {
        this.mapa = mapa;
    }

    public int[][] getMapa() {
        return mapa;
    }

}
