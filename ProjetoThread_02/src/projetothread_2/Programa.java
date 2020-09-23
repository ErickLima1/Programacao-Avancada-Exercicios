
package projetothread_2;

/**
 *
 * @author Erick
 */
public class Programa {
    public static void main(String[] args) {
        Processo p1 = new Processo();
        Processo p2 = new Processo();
        
        p1.setId( 1 );
        p2.setId( 2 );
        
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        
        t1.start();
        t2.start();
        
    }
}
