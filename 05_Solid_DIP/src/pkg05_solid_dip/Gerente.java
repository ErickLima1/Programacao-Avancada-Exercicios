package pkg05_solid_dip;

// high-level (alto nível):
public class Gerente {
    
    private IFuncionario trabalhador;
 
    public void setTrabalhador(IFuncionario trabalhador) {
        this.trabalhador = trabalhador;
    }
    
    public void gerenciar() {
        if(trabalhador != null) {
            trabalhador.trabalhar();
        } else {
            throw new RuntimeException("Nenhum funcionario atrelado ao gerente");
        }
    }
        
}
