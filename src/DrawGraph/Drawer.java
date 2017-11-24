package DrawGraph;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Drawer extends JPanel {

    int width;
    int height;
    Color edgeColor;

    ArrayList<Node> nodes;
    ArrayList<edge> edges;

    public Drawer() { //Constructor
        nodes = new ArrayList<Node>();
        edges = new ArrayList<edge>();
        width = 30;
        height = 30;
        edgeColor = Color.BLACK;
    }

    private class Node {

        int x, y;
        String name;

        public Node(String myName, int myX, int myY) {
            x = myX;
            y = myY;
            name = myName;
        }
    }

    private class edge {

        int i, j;

        public edge(int ii, int jj) {
            i = ii;
            j = jj;
        }
    }

    public void addNode(String name, int x, int y) {
        //add a node at pixel (x,y)
        nodes.add(new Node(name, x, y));
        this.repaint();
    }

    public void addEdge(int i, int j) {
        //add an edge between nodes i and j
        edges.add(new edge(i, j));
        this.repaint();
    }
    
    public void deleteNodes()
    {
        nodes.clear();
        edges.clear();
        this.repaint();
    }
    

    @Override
    public void paintComponent(Graphics g){ // draw the nodes and edges
        
        super.paintComponent(g);
        
        FontMetrics f = g.getFontMetrics();
        int nodeHeight = Math.max(height, f.getHeight());

        g.setColor(edgeColor);
        for (edge e : edges) {
            g.drawLine(nodes.get(e.i).x, nodes.get(e.i).y, nodes.get(e.j).x, nodes.get(e.j).y);
        }

        for (Node n : nodes) {
            int nodeWidth = Math.max(width, f.stringWidth(n.name) + width / 2);
            g.setColor(Color.white);
            g.fillOval(n.x - nodeWidth / 2, n.y - nodeHeight / 2, nodeWidth, nodeHeight);
            g.setColor(Color.black);
            g.drawOval(n.x - nodeWidth / 2, n.y - nodeHeight / 2, nodeWidth, nodeHeight);

            g.drawString(n.name, n.x - f.stringWidth(n.name) / 2, n.y + f.getHeight() / 2);
        }
    }
    
    public Color getEdgeColor() {
        return edgeColor;
    }

    public void setEdgeColor(Color edgeColor) {
        this.edgeColor = edgeColor;
    }
        
}
