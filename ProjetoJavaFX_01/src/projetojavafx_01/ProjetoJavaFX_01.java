
package projetojavafx_01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick
 */
public class ProjetoJavaFX_01 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane painel = new AnchorPane();
       //Adicionando os textos//Adicionando botão
        TextField campoEmail = new  TextField();
        campoEmail.setPromptText("Digite o seu E-mail");
        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite a sua Senha");
        Button botaoEntrar = new Button("Entrar");
        Button botaoSair = new Button("Sair");
        Text txtLogin = new Text("Entra no Sistema");
        
        
       //Adicionando os componentes do painel
        painel.getChildren().addAll(campoEmail,campoSenha,botaoEntrar,botaoSair,txtLogin);
        //Adicionando o Css
        painel.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, white 0%, black 100%);");
        
        
        painel.setPrefSize(400, 300);
       
        Scene cena = new Scene(painel);
       
        stage.setScene(cena);
        stage.show();
       
       //Posição
        txtLogin.setLayoutX((painel.getWidth() - campoEmail.getWidth()) /2.0);
        campoEmail.setLayoutX((painel.getWidth() - campoEmail.getWidth()) /2.0);
        campoSenha.setLayoutX((painel.getWidth() - campoSenha.getWidth()) /2.0);
        botaoEntrar.setLayoutX((painel.getWidth() - botaoEntrar.getWidth()) /2.0);
        botaoSair.setLayoutX((painel.getWidth() - botaoSair.getWidth()) /2.0);
        
        txtLogin.setLayoutY(50);
        campoEmail.setLayoutY(70);
        campoSenha.setLayoutY(120);
        botaoEntrar.setLayoutY(170);
        botaoSair.setLayoutY(220);
      //Funcionaldiade do botãos
        botaoSair.setOnAction(new  EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                stage.close();
            }
        });
        
        botaoEntrar.setOnAction(new  EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if(campoEmail.getText().equals("admin@gmail.com") && campoSenha.getText().equals("12345")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Login Efetuado com Seucesso", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "E-mail ou Senha Invalida.","Erro",JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
    
    }//Fim Start
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
