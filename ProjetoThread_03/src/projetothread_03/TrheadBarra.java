
package projetothread_03;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Erick
 */
public class TrheadBarra implements Runnable{
    private JProgressBar barra;
    private int velocidade;

    public TrheadBarra(JProgressBar barra, int velocidade) {
        this.barra = barra;
        this.velocidade = velocidade;
    }
    
    private void simularBarra() throws InterruptedException {
        for(int i = 0; i <= 100; i++) {
            barra.setValue(i);
            barra.setString(i + "%");
            Thread.sleep(velocidade);
            
        }
    }
    
    @Override
    public void run() {
        try {
            simularBarra();
            
        } catch (InterruptedException ex) {
            System.out.println("Erro ao simular a barra: " + ex.getMessage());
            
        }
    }
    
    
}
