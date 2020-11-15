
package pkg02_solid_ocp;

public class Main {

    public static void main(String[] args) {
        EditorGrafico eg =  new EditorGrafico();
        Circulo c1 = new Circulo();
        eg.desenharForma(c1);
        
        Retangulo r1 = new Retangulo();
        eg.desenharForma(r1);
        
        Triangulo t1 = new Triangulo();
        eg.desenharForma(t1);
    }
    
}
