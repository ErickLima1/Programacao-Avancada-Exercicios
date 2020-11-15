
package pkg01_solid_srp;

public class Main {

    public static void main(String[] args) {
        //Composto
        Produto p1 =  new  Produto();
        imposto i1 =  new  imposto();
        double impostop1 = i1.calcularImposto(p1, 0.07);
        
       
    }
    
}
