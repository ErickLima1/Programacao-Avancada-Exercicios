/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Erick
 */
public class ArrayListMap {

    
    public static void main(String[] args) {
        ArrayList<String> estados = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int total = 3;
        
        for(int i =0; i < total; i++) {
            try {
                System.out.println("Entrem com o nome do estado:");
                String e = sc.nextLine().trim().toUpperCase();
                if(e.length() <= 0) {
                    throw new Exception("Estado não pode ser branco.");
                }
                if(!estados.contains(e)) {
                    estados.add(e);
                }else{
                    throw new Exception("Estado " + e + " Ja foi Cadastrado.");
                }
            } catch (Exception ex) {
                i--;
                System.out.println(">>Erro!<< " +  ex.getMessage());
                
            }
        }
        Collections.sort(estados);
        System.out.println(estados);
    }
    
}
