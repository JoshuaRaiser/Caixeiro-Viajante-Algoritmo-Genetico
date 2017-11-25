package DrawGraph;

import java.awt.Color;

/**
 *
 * @author Joshua Raiser
 */
public class Edge {

        int i, j;
        Color color;

        public Edge(int ii, int jj) {
            i = ii;
            j = jj;
            color = Color.BLACK;
        }
        
        public Edge(int ii, int jj, Color color) {
            i = ii;
            j = jj;
            this.color = color;
        }
    }
