package DrawGraph;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Joshua Raiser
 */
public class Drawer extends JPanel {

    int width;
    int height;

    ArrayList<Node> nodes;
    ArrayList<Edge> edges;

    public Drawer() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        width = 30;
        height = 30;
    }

    public void addNode(String name, int x, int y) {
        // adiciona um nodo ao pixel de cordenada (x,y)
        nodes.add(new Node(name, x, y));
        this.repaint();
    }
    
    public void addEdge(int i, int j, Color color) {
        // adiciona uma linha entre os nodos i e j
        edges.add(new Edge(i, j, color));
        this.repaint();
    }

    public void addEdge(int i, int j) {
        // adiciona uma linha entre os nodos i e j
        edges.add(new Edge(i, j));
        this.repaint();
    }

    public void deleteNodes() {
        nodes.clear();
        edges.clear();
        this.repaint();
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    @Override
    public void paintComponent(Graphics g) { // desenha os nodos e as linhas

        super.paintComponent(g);

        FontMetrics f = g.getFontMetrics();
        int nodeHeight = Math.max(height, f.getHeight());

        for (Edge e : edges) {
            g.setColor(e.color);
            g.drawLine(nodes.get(e.i).x, nodes.get(e.i).y, nodes.get(e.j).x, nodes.get(e.j).y);
        }

        for (Node n : nodes) {
            int nodeWidth = Math.max(width, f.stringWidth(n.name) + width / 2);
            g.setColor(Color.WHITE);
            if (n.init) {
                g.setColor(Color.RED);
            }
            g.fillOval(n.x - nodeWidth / 2, n.y - nodeHeight / 2, nodeWidth, nodeHeight);
            g.setColor(Color.BLACK);
            g.drawOval(n.x - nodeWidth / 2, n.y - nodeHeight / 2, nodeWidth, nodeHeight);

            g.drawString(n.name, n.x - f.stringWidth(n.name) / 2, n.y + f.getHeight() / 2);
        }
    }

}
