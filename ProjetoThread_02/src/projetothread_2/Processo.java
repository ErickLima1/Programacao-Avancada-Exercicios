
package projetothread_2;

/**
 *
 * @author Erick
 */
public class Processo  implements Runnable{
    private int id;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    ////
    
    @Override
    public void run() {
        for(int i = 0; i < 10000; i++) {
            System.out.println("Thread : " + getId() + " Valor de i: " + i);
        }
    }
    
    
}
