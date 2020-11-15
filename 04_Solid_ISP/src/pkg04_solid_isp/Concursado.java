package pkg04_solid_isp;

public class Concursado implements IFuncionario, IFerias {

    @Override
    public void trabalhar() {
        // implementação
        System.out.println("Trabalhar 6h/dia");
    }
  
    @Override
    public void tirarFeiras() {
        // implementação
        System.out.println("Direito a 45 dias/ano");
    }
    
}
