package projetothread_03;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Erick
 */
public class Janela  extends JFrame{
    private JPanel painel = new JPanel();
    private JProgressBar barra1 = new JProgressBar();
    private JProgressBar barra2 = new JProgressBar();
    private JProgressBar barra3 = new JProgressBar();
    //
    public void montarJanela() {
        setTitle("Barra com Threads");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        add(painel);
        montarPainel();
        goThreads();
    }
    private void montarPainel() {
        barra1.setForeground(Color.RED);
        barra1.setBackground(Color.WHITE);
        barra1.setValue(0);
        barra1.setPreferredSize(new Dimension(350,30));
        barra1.setStringPainted(true);
        
        barra2.setForeground(Color.GREEN);
        barra2.setBackground(Color.WHITE);
        barra2.setValue(0);
        barra2.setPreferredSize(new Dimension(350,30));
        barra2.setStringPainted(true);
        
        barra3.setForeground(Color.BLUE);
        barra3.setBackground(Color.WHITE);
        barra3.setValue(0);
        barra3.setPreferredSize(new Dimension(350,30));
        barra3.setStringPainted(true);
        
        painel.add(barra1);
        painel.add(barra2);
        painel.add(barra3);
    }
    
    private void goThreads() {
        Thread t1 = new Thread( new TrheadBarra(barra1, 20) );
        Thread t2 = new Thread( new TrheadBarra(barra2, 40) );
        Thread t3 = new Thread( new TrheadBarra(barra3, 70) );
        
        t1.start();
        t2.start();
        t3.start();
    }
}
