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
public class Resultado {
    
    String log;
    int[][] cromossomo;
    int[] resultado;
    String[] cidade;

    public Resultado(String log, int[][] cromossomo, int[] resultado, String[] cidade) {
        this.log = log;
        this.cromossomo = cromossomo;
        this.resultado = resultado;
        this.cidade = cidade;
    }

    public String getLog() {
        return log;
    }

    public String[] getCidade() {
        return cidade;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public int[][] getCromossomo() {
        return cromossomo;
    }

    
    
}
