package App;

import AlgoritmoGenetico.Configuracao;
import AlgoritmoGenetico.AlgoritmoGenetico;
import DrawGraph.Edge;
import DrawGraph.Node;
import Model.Mapa;
import Model.Resultado;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Joshua Raiser
 */
public class MainApplication extends JFrame {

    String[] cidades_c = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    //String caminhoArquivo;
    String conteudoArquivo;
    String log;

    public static int numeroPopulacoes;
    int numeroCidades;
    public static int numeroGeracoes;

    float taxaMutacao;

    boolean mostrarGeracoes;

    AlgoritmoGenetico algoritmoGenetico;
    Configuracao configuracoes;
    Mapa mapa;

    public MainApplication() {
        initComponents();

        log = "";

        jMenu2.setEnabled(false);
        jMenuItem2.setEnabled(false);
        jButton1.setEnabled(false);
        jButton3.setEnabled(false);

        drawer1.setVisible(true);

        // seta configurações básicas iniciais
        mostrarGeracoes = true;
        taxaMutacao = (float) 0.5; // 0.5%
        numeroGeracoes = 3000;
        numeroPopulacoes = 10;

}

public void carregaGrafo() {
        drawer1.deleteNodes();
        
        String entradas[] = conteudoArquivo.split(Pattern.quote(";"));
        numeroCidades = (int) Math.sqrt(entradas.length);

        int[][] cidades = new int[numeroCidades][numeroCidades];
        int c_atual = 0;

        // obtém as cidades
        for (int i = 0; i < numeroCidades; i++) {
            for (int j = 0; j < numeroCidades; j++) {
                cidades[i][j] = Integer.parseInt(entradas[c_atual]);
                c_atual++;
            }
        }
        mapa = new Mapa(cidades);

        // faz o mapeamento das cidades para gerar o grafo 
        for (int i = 0; i < numeroCidades; i++) {
            int x, y;
            
            x = new Random().nextInt(drawer1.getBounds().width);
            y = new Random().nextInt(drawer1.getBounds().height);
            
            while((x <= 100 && y <= 100) ||  (x >= drawer1.getBounds().width-100 && y >= drawer1.getBounds().height-100))
            {
                x = new Random().nextInt(drawer1.getBounds().width);
                y = new Random().nextInt(drawer1.getBounds().height);
            }      
            drawer1.addNode((String) cidades_c[i], x, y);
        }

        // faz as ligações entre as cidades
        for (int i = 0; i < numeroCidades; i++) {
            for (int j = i + 1; j < numeroCidades; j++) {
                drawer1.addEdge(i, j);
            }
        }

        //System.out.println(nodes.size() + " - " + edges.size());
        
        jMenu2.setEnabled(true);
        jMenuItem2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        drawer1 = new DrawGraph.Drawer();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PCV-AG graph");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        drawer1.setBackground(new java.awt.Color(255, 255, 255));
        drawer1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        drawer1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout drawer1Layout = new javax.swing.GroupLayout(drawer1);
        drawer1.setLayout(drawer1Layout);
        drawer1Layout.setHorizontalGroup(
            drawer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 956, Short.MAX_VALUE)
        );
        drawer1Layout.setVerticalGroup(
            drawer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 255, 0));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Para começar, importe o arquivo com a matriz de adjacência (valores devem ser separados por ponto e vírgula). Exemplo: \n0;1;4;5;\n1;0;6;2;\n4;6;0;8;\n5;2;8;0\nE então, pressione iniciar no canto superior esquerdo.");
        jTextArea1.setCaretColor(new java.awt.Color(51, 204, 0));
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/files.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setName(""); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/play-button.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/import.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drawer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(drawer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/import-16.png"))); // NOI18N
        jMenu1.setText("Arquivo");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Importar Arquivo");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Randomizar Grafo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/play-button-16.png"))); // NOI18N
        jMenu2.setText("Iniciar");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        
        jTextArea1.append("\nProcessando algoritmo genético...\n\n");
        // atribui as configurações iniciais e as obtidoas com o mapa para montar as configurações do algoritmo genético
        configuracoes = new Configuracao(mostrarGeracoes, taxaMutacao, numeroGeracoes, numeroCidades, numeroPopulacoes);
        algoritmoGenetico = new AlgoritmoGenetico(mapa, configuracoes);
        
        Resultado res = algoritmoGenetico.executar();
        jTextArea1.append("\n\n" + res.getLog() + "\n * Finalizado com exito.");    
        
        log = res.getLog();
        
        // em [0][i] contém as ligações (edges)
        int[][] cromossomo = res.getCromossomo();
        
        ArrayList<Node> nodes = new ArrayList<>();
        
        // salva os nodes antes de deletá-los
        for(Node node : drawer1.getNodes())
        {
            nodes.add(node);
        }
        drawer1.deleteNodes();
        
        // repinta os nodes
        for(int i = 0; i < nodes.size(); i++)
        {
            /*if (i == 0)
            {
                drawer1.addNode(nodes.get(i).getName(), nodes.get(i).getX(), nodes.get(i).getY(), true);
            }*/
            drawer1.addNode(nodes.get(i).getName(), nodes.get(i).getX(), nodes.get(i).getY());
            
        }
        // faz as ligações entre as cidades resultado
        
        /*for (int i = 0; i < numeroCidades; i++) {
            
            for(int j = 0; j < numeroCidades; j++)
            {
                System.out.print(cromossomo[i][j]+"\t");
            }
            System.out.println("");
        }*/
        
        // faz as ligações entre as cidades
        for (int i = 0; i < numeroCidades-1; i++) {
            System.out.println(cromossomo[0][i]);
            int aux = i;
            int x = cromossomo[0][aux];
            int y = cromossomo[0][aux+1];
            System.out.println(x + " - " + y);
            drawer1.addEdge(x, y, Color.RED);
            //for (int j = i + 1; j < numeroCidades; j++) {
            //    drawer1.addEdge(j, i, Color.RED);
            //}
        }
        drawer1.addEdge(cromossomo[0][numeroCidades-1], cromossomo[0][0], Color.RED);

        jButton1.setEnabled(true);
        
        this.repaint();
        
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JFileChooser abrir = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PCV-AG graph (.graph) files", "graph");
        abrir.setFileFilter(filter);
        String caminhoArquivo = "";
        int retorno = abrir.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            caminhoArquivo += abrir.getSelectedFile().getAbsolutePath();
        }

        ler(caminhoArquivo);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        carregaGrafo();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LogFrame logf = new LogFrame();
        logf.carregaLog(log);
        logf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JFileChooser abrir = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PCV-AG graph (.graph) files", "graph");
        abrir.setFileFilter(filter);
        String caminhoArquivo = "";
        int retorno = abrir.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            caminhoArquivo += abrir.getSelectedFile().getAbsolutePath();
        }

        ler(caminhoArquivo);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextArea1.append("\nProcessando algoritmo genético...\n\n");
        // atribui as configurações iniciais e as obtidoas com o mapa para montar as configurações do algoritmo genético
        configuracoes = new Configuracao(mostrarGeracoes, taxaMutacao, numeroGeracoes, numeroCidades, numeroPopulacoes);
        algoritmoGenetico = new AlgoritmoGenetico(mapa, configuracoes);
        
        Resultado res = algoritmoGenetico.executar();
        jTextArea1.append("\n\n" + res.getLog() + "\n * Finalizado com exito.");    
        
        log = res.getLog();
        
        // em [0][i] contém as ligações (edges)
        int[][] cromossomo = res.getCromossomo();
        
        ArrayList<Node> nodes = new ArrayList<>();
        
        // salva os nodes antes de deletá-los
        for(Node node : drawer1.getNodes())
        {
            nodes.add(node);
        }
        drawer1.deleteNodes();
        
        // repinta os nodes
        for(int i = 0; i < nodes.size(); i++)
        {
            /*if (i == 0)
            {
                drawer1.addNode(nodes.get(i).getName(), nodes.get(i).getX(), nodes.get(i).getY(), true);
            }*/
            drawer1.addNode(nodes.get(i).getName(), nodes.get(i).getX(), nodes.get(i).getY());
            
        }
        // faz as ligações entre as cidades resultado
        
        /*for (int i = 0; i < numeroCidades; i++) {
            
            for(int j = 0; j < numeroCidades; j++)
            {
                System.out.print(cromossomo[i][j]+"\t");
            }
            System.out.println("");
        }*/
        
        // faz as ligações entre as cidades
        for (int i = 0; i < numeroCidades-1; i++) {
            System.out.println(cromossomo[0][i]);
            int aux = i;
            int x = cromossomo[0][aux];
            int y = cromossomo[0][aux+1];
            System.out.println(x + " - " + y);
            drawer1.addEdge(x, y, Color.RED);
            //for (int j = i + 1; j < numeroCidades; j++) {
            //    drawer1.addEdge(j, i, Color.RED);
            //}
        }
        drawer1.addEdge(cromossomo[0][numeroCidades-1], cromossomo[0][0], Color.RED);

        jButton1.setEnabled(true);
        
        this.repaint();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MouseClicked
    
    private void ler(String caminho) {
        try {
            //Indicamos o arquivo que será lido
            FileReader fileReader = new FileReader(caminho);
                        
            //Criamos o objeto bufferReader que nos
            // oferece o método de leitura readLine()
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //String que irá receber cada linha do arquivo
            String linhas = "";

            //Fazemos um loop linha a linha no arquivo,
            // enquanto ele seja diferente de null.
            //O método readLine() devolve a linha na
            // posicao do loop para a variavel linha.
            String br;
            while ((br = bufferedReader.readLine()) != null) {
                //Aqui imprimimos a linha
                linhas += br;
            }
            //liberamos o fluxo dos objetos ou fechamos o arquivo
            fileReader.close();
            bufferedReader.close();
            jTextArea1.append("\n\nCarregando arquivo em: "+ caminho +"\n");
            jTextArea1.append("* sequencia de dados encontrada: "+linhas);
            //conteudoArquivo = "";
            conteudoArquivo = linhas;
        } catch (IOException e) {
            //System.out.println("erro aqui   \n" + e.getMessage());
        }

        jButton1.setEnabled(false);
        carregaGrafo();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            /*for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
        

} catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApplication.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApplication.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApplication.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApplication.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DrawGraph.Drawer drawer1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
