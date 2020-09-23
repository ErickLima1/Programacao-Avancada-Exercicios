/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetojogo01;

import java.util.Random;

/**
 *
 * @author Erick
 */
public class Personagem {
    // atributos:
    private String nome;
    private double vida = 10.0;
    
    Random r = new Random();
    
    // construtores:
    public Personagem() {
    }

    public Personagem(String nome) throws Exception{
        if(nome.length() < 1) {
             throw new Exception("Nome não Inserido");
        }else{
              this.nome = nome;
     }
    }

    // encapsulamento:
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception{
        if(this.nome.length() < 1) {
            throw new Exception("Nome Não Inserido");
        }else{
            this.nome = nome;
        }
    }

    public double getVida() {
        if(this.vida > 0)
            return vida;
        else
            return 0.0;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }
    
    public double atacar(double MIN_DANO, double MAX_DANO){
        return MIN_DANO + (MAX_DANO - MIN_DANO) * r.nextDouble();
    }
    
    public void defender(double dano, double MIN_ARMADURA, double MAX_ARMADURA) {
        double armadura = MIN_ARMADURA +  (MAX_ARMADURA - MIN_ARMADURA) * r.nextDouble();
        double ataque = armadura - dano;
        if(ataque > 0) {
            this.setVida(this.getVida() - ataque);
                System.out.printf("Ataque Efetuado: " + this.nome + " Peerdeu %2f de vida \n", ataque);
        }else{
                System.out.println("Ataque defendido");
        }
    
 } // fim da classe
}
