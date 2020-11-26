/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoJavaFx_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projetoJavaFx_01.bd.BancoDados_MYSQL;

/**
 *
 * @author Erick
 */
public class TelaCadastroUsuario extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane painel = new AnchorPane();
        painel.setPrefSize(400, 300);

        TextField campoNome = new TextField();
        campoNome.setPromptText("Digite seu nome");
        TextField campoEmail = new TextField();
        campoEmail.setPromptText("Digite seu e-mail");
        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");
        Button botaoEntrar = new Button("Cadastrar");
        Text txtCadastro = new Text("Faça seu cadastro");

        painel.getChildren().addAll(campoNome, campoEmail, campoSenha,
                botaoEntrar, txtCadastro);
        painel.setStyle("-fx-background-color: "
                + "linear-gradient(from 0% 0% to 100% 100%, white 0%, blue 100%);");

        Scene cena = new Scene(painel);

        stage.setScene(cena);
        stage.show();

        // posições:
        txtCadastro.setLayoutX((painel.getWidth() - campoEmail.getWidth()) / 2.0);
        campoNome.setLayoutX((painel.getWidth() - campoNome.getWidth()) / 2.0);
        campoEmail.setLayoutX((painel.getWidth() - campoEmail.getWidth()) / 2.0);
        campoSenha.setLayoutX((painel.getWidth() - campoSenha.getWidth()) / 2.0);
        botaoEntrar.setLayoutX((painel.getWidth() - botaoEntrar.getWidth()) / 2.0);

        txtCadastro.setLayoutY(50);
        campoNome.setLayoutY(70);
        campoEmail.setLayoutY(120);
        campoSenha.setLayoutY(170);
        botaoEntrar.setLayoutY(220);

        // ações dos botões:
        botaoEntrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                // inserir no banco de dados!
                BancoDados_MYSQL bd = null;
                PreparedStatement inserir = null;
                try {
                    bd = new BancoDados_MYSQL();
                    Connection con = bd.conectar();
                    // pegar valores:
                    String nomeDigitado  = campoNome.getText();
                    String emailDigitado = campoEmail.getText();
                    String senhaDigitada = campoSenha.getText();
                    
                    // validação dos campos:
                    if(nomeDigitado.length() <= 1) 
                        throw new Exception("Nome inválido. Precisa ter mais de uma letra.");
                    if(emailDigitado.length() <= 1)
                        throw new Exception("E-mail inválido. Precisa ter mais de uma letra.");
                    if(senhaDigitada.length() <= 5)
                        throw new Exception("Senha inválida. Precisa ter mais de seis caracteres.");
                    
                    // inserir de fato: 
                    inserir = con.prepareStatement("INSERT INTO cliente (nome, email, senha) VALUES (?, ?, md5(?))");
                    inserir.setString(1, nomeDigitado);
                    inserir.setString(2, emailDigitado);
                    inserir.setString(3, senhaDigitada);
                    inserir.executeUpdate();

                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                            "Cliente inserido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    
                    // limpar campos:
                    campoNome.setText("");
                    campoEmail.setText("");
                    campoSenha.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), 
                            "Erro ao cadastrar cliente. Detalhes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (inserir != null) {
                            inserir.close();
                        }
                        bd.desconectar();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), 
                            "Erro ao fechar insert. Detalhes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

    } // fim do start

    public static void main(String[] args) {
        launch(args);
    }

}
