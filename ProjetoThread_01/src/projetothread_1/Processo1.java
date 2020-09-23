/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetothread_1;

/**
 *
 * @author Erick
 */
public class Processo1 extends Thread{
   @Override
    public void run() {
        System.out.println("Nome da Thread (Herança): " + Thread.currentThread().getName());
    }
    
}
