/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmapp;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Erick
 */
public class HASHMAPp {

    
    public static void main(String[] args) {
        HashMap<String, String> estados = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int total = 4;
        
        for(int i = 0; i < total; i++) {
            try {
                System.out.println("Informe a sigla do estado.");
                String sigla = sc.nextLine().trim().toUpperCase();
                if(sigla.length() <= 0) {
                    throw new Exception("Sigla não pode ser vazia.");
                    
                }
                if(! estados.containsKey(sigla)) {
                    //pedir estado//
                    System.out.println("Informe o Estado");
                    String e = sc.nextLine().trim().toUpperCase();
                    if(e.length()<= 0) {
                        throw new Exception("Estado não pode ser vazio.");
                    }
                    
                    if(! estados.containsValue(e)) {
                        estados.put(sigla,e);
                       
                    }else{
                         throw  new Exception("Estado " + e + " Ja Cadastrado");
                    }
                    
                }else{
                    throw new Exception("Sigla " + sigla + " Ja cadastrada.");
                }
                
            } catch (Exception ex) {
                i--;
                System.out.println(">>Erro<< " + ex.getMessage());
           }
       }
        System.out.println("--------------------");
        System.out.println(estados);
        
   }
    
}
