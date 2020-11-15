package pkg01_solid_srp;


public class imposto {
    
    public double calcularImposto(Produto produto, double taxa) {
        return produto.getPreco() * taxa;
        
    }
}
