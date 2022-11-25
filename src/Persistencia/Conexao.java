package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private String usuario;
    private String senha;
    private String caminho;
    private Connection minhaConexao;

    public Conexao(String usuario, String senha, String caminho){
        this.usuario = usuario;
        this.senha = senha;
        this.caminho = caminho;
    }

    public void conectar(){
        try {
            Class.forName("org.postgresql.Driver"); // CARREGA O DRIVER
            minhaConexao = DriverManager.getConnection(usuario, senha, caminho);
        } catch (Exception e){
            System.out.println("Erro na conexao" + e.getMessage());
        }
    }
    public void desconectar(){
        try {
            minhaConexao.close();
        } catch (Exception e){
            System.out.println("Erro na desconexao" + e.getMessage());
        }
    }

    public Connection getConexao(){
        return minhaConexao;
    }
}
