package pkg04_solid_isp;

public class Terceirizado implements IFuncionario,IFerias {

    @Override
    public void trabalhar() {
        // implementação
        System.out.println("Trabalhar 8h/dia");
    }

    @Override
    public void tirarFeiras() {
        // implementação
        System.out.println("Direito a 30 dias/ano");
    }
    }
