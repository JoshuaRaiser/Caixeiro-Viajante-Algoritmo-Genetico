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
