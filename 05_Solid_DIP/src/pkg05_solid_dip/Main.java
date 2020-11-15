package pkg05_solid_dip;

public class Main {

    public static void main(String[] args) {
        Gerente g1 = new Gerente();
        g1.setTrabalhador( new Funcionario());
        g1.gerenciar();
        
        g1.setTrabalhador(new Terceirizado());
        g1.gerenciar();
    }
    
}
