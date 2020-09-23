/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetojogo01;

import java.util.Scanner;

/**
 *
 * @author Erick
 */
public class Jogo {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    
    public static void main(String[] args) throws InterruptedException, Exception {
        int op;
        Guerreiro g = new Guerreiro("Kratos");
        Zumbi z = new Zumbi("Zumbilandia");
        Arqueiro a = new Arqueiro("Vaarus");
        
        Scanner sc = new Scanner(System.in);
        int contBatalha = 1;
        /////////////////////////////////////////////////
        
        while(true) {
        System.out.println("\n\n> Escolha a Luta:");
        System.out.println("1:Guerreiro Vs Zumbi:");
        System.out.println("2:Arqueiro Vs Zumbi:");
        System.out.println("3:Arqueiro Vs Guerreiro:");
        System.out.print("Escolha: ");
        op = sc.nextInt();
        
        switch(op) {
            case 1:
                try {
                    
                while(g.getVida() > 0 && z.getVida() > 0) {
                    System.out.println("Iniciando batalha #" + (contBatalha++));
                    z.defender( g.atacar() );
                    g.defender( z.atacar() );
                    System.out.printf("%s %.2f vs %.2f %s \n", g.getNome(), 
                    g.getVida(), z.getVida(), z.getNome());
                    Thread.sleep(3000);//
        }//Fim while
                System.out.println("###################################");
                if(g.getVida() > 0 && z.getVida() == 0) {
                    System.out.println("Guerreiro " + g.getNome() + " venceu!");
                } else if(g.getVida() == 0 && z.getVida() > 0) {
                    System.out.println("Zumbi " + z.getNome() + " venceu!");
                } else {
                    System.out.println("PARTIDA EMPATADA!");
        }//
                } catch (Exception e) {
                    System.err.println("Erro Na Batalha." + e.getMessage());
            }
            break; //FIM DO CASE 1
        
            case 2:
                try {
               
                while(a.getVida() > 0 && z.getVida() > 0) {
                    System.out.println("Iniciando batalha #" + (contBatalha++));
                    z.defender(a.atacar());
                    a.defender(z.atacar());
                    System.out.printf("%s %.2f vs %.2f %s \n", a.getNome(),
                            a.getVida(),z.getVida(),z.getNome());
                    Thread.sleep(3000);//
                }
                    System.out.println("###################################");
                    if(a.getVida() > 0 && z.getVida() == 0 ) {
                        System.out.println("Arqueiro " + a.getNome() + "Venceu!");
                        
                }else if(a.getVida() == 0 && z.getVida() > 0) {
                      System.out.println("Zumbi" + z.getNome() + "Venceu!");
                }else{
                     System.out.println("PARTIDA EMPATADA!");
            }//
               }catch (Exception e){
                    System.out.println("Erro Na Batalha." + e.getMessage());
            }
               break; // FIM DO CASE 2
            case 3:
                try{
                    
               while(a.getVida() > 0 && g.getVida() > 0) {
                   System.out.println("Iniciando Batalha # " + (contBatalha++));
                   g.defender(a.atacar());
                   a.defender(g.atacar());
                   System.out.printf("%s %.2f vs %.2f %s \n", a.getNome(),
                            a.getVida(),g.getVida(),g.getNome());
                   Thread.sleep(3000);//
            }
                System.out.println("######################################");
                if(a.getVida() > 0 && g.getVida() == 0) {
                    System.out.println("Arquiro " + a.getNome() + "Venceu!");
                }else if(a.getVida() == 0 && g.getVida() > 0) {
                    System.out.println("Guerreiro " + g.getNome() + "Venceu!");
                }else{
                    System.out.println("PARTIDA EMPATADA!");
             }
                }catch(Exception e){
                    System.out.println("Erro Na Batalha." + e.getMessage());
                }
                break; //FIM DO CASE 3
       }
    }
 }
}