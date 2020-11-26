/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoJavaFx_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projetoJavaFx_01.bd.BancoDados_MYSQL;

/**
 *
 * @author Erick
 */
public class TelaLogin extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane painel = new AnchorPane();
        painel.setPrefSize(400, 300);

        TextField campoEmail = new TextField();
        campoEmail.setPromptText("Digite seu e-mail");
        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");
        Button botaoEntrar = new Button("Entrar");
        Button botaoSair = new Button("Sair");
        Text txtLogin = new Text("Entrar no sistema");

        painel.getChildren().addAll(campoEmail, campoSenha,
                botaoEntrar, botaoSair, txtLogin);
        painel.setStyle("-fx-background-color: "
                + "linear-gradient(from 0% 0% to 100% 100%, white 0%, black 100%);");

        Scene cena = new Scene(painel);

        stage.setScene(cena);
        stage.show();

        // posições:
        txtLogin.setLayoutX((painel.getWidth() - campoEmail.getWidth()) / 2.0);
        campoEmail.setLayoutX((painel.getWidth() - campoEmail.getWidth()) / 2.0);
        campoSenha.setLayoutX((painel.getWidth() - campoSenha.getWidth()) / 2.0);
        botaoEntrar.setLayoutX((painel.getWidth() - botaoEntrar.getWidth()) / 2.0);
        botaoSair.setLayoutX((painel.getWidth() - botaoSair.getWidth()) / 2.0);

        txtLogin.setLayoutY(50);
        campoEmail.setLayoutY(70);
        campoSenha.setLayoutY(120);
        botaoEntrar.setLayoutY(170);
        botaoSair.setLayoutY(220);

        // ações dos botões:
        botaoSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                stage.close();
            }
        });

        botaoEntrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                BancoDados_MYSQL bd = null;
                Connection con;
                PreparedStatement consulta = null;
                ResultSet rs = null;
                try {
                    bd = new BancoDados_MYSQL();
                    con = bd.conectar();
                    // pegar email e senha:
                    String emailDigitado = campoEmail.getText();
                    String senhaDigitada = campoSenha.getText();
                    // select no banco de dados:
                    consulta = con.prepareStatement("SELECT * FROM cliente WHERE email = ? AND senha = md5(?)");
                    consulta.setString(1, emailDigitado);
                    consulta.setString(2, senhaDigitada);

                    rs = consulta.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                                "Login efetuado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        stage.close();
                        TelaCadastroUsuario telaCadastro = new TelaCadastroUsuario();
                        telaCadastro.start(stage);
                    } else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                                "E-mail e senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                            "Erro ao efetuar login. Detalhes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        if (consulta != null) {
                            consulta.close();
                        }
                        if (rs != null) {
                            rs.close();
                        }
                        bd.desconectar();
                    } catch (Exception e) {
                        System.out.println("Erro ao fechar select. Detalhes: " + e.getMessage());
                    }
                   
                }
            }
        });

    } // fim do start

    public static void main(String[] args) {
        launch(args);
    }

}
