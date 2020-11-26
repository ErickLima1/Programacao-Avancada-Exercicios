/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoJavaFx_01.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLException;
/**
 *
 * @author Erick
 */
public class BancoDados_MYSQL {
    Connection conexao = null;

    public Connection conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            
            String url = "jdbc:mysql://localhost:3306/loja", usuario = "root", senha = "";
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
            throw new Exception("Erro! Classe não encontrada. Detalhes: " + e.getMessage());
        } catch (SQLException e) {
            throw new Exception("Erro! Problema de SQL. Detalhes: " + e.getMessage());
        }
        return conexao;
    }

    public boolean isConectado() throws Exception {
        try {
            if (conexao != null && !conexao.isClosed()) {
                return true;
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao verificar conexão. Detalhes: "
                    + e.getMessage());
        }
        return false;
    }

    public void desconectar() throws Exception {
        try {
            conexao.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao fechar conexão. Detalhes: "
                    + e.getMessage());
        }
    }

} // fim da classe


