
package projetothread_1;

/**
 *
 * @author Erick
 */
public class Programa {

    public static void main(String[] args) {
        Thread t1 = new Processo1();
        t1.setName("Proceso1");
        t1.start();
        
        Thread t2 = new Thread (new Processo2(), "Processo 2");
        t2.start();
    }
    
}
