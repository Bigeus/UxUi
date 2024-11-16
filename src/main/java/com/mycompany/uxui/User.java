package com.mycompany.uxui;

/**
 * Classe responsável pelo gerenciamento de usuários e autenticação no sistema.
 * Realiza operações de conexão com banco de dados e verificação de credenciais.
 *
 * @author Vinícius Simões
 * @version 1.0
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

    /**
     * Nome do usuário após autenticação bem-sucedida
     */
    public String nome = "";

    /**
     * Indica o resultado da última operação de verificação de usuário
     */
    public boolean result = false;

    /**
     * Estabelece uma conexão com o banco de dados MySQL.
     *
     * @return Connection objeto de conexão com o banco de dados, ou null em
     * caso de falha na conexão
     */
    public Connection conectarBD() {
        // Inicializa a conexão como null
        Connection conn = null;

        try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();

            // Define a URL de conexão com o banco de dados
            // Formato: jdbc:mysql://endereco_servidor/nome_banco?parametros
            String url = "jdbc:mysql://127.0.0.1/test?user=root&password=123456";

            // Estabelece a conexão usando os parâmetros definidos na URL
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Em caso de erro na conexão, retorna null
            // TODO: Implementar log de erro e tratamento adequado da exceção
        }

        return conn;
    }

    /**
     * Verifica as credenciais do usuário no banco de dados.
     *
     * @param login nome de usuário a ser verificado
     * @param senha senha do usuário para autenticação
     * @return boolean true se as credenciais forem válidas, false caso
     * contrário
     *
     * @see #conectarBD()
     */
    public boolean verificarUsuario(String login, String senha) {
        // Inicializa a string SQL
        String sql = "";

        // Obtém a conexão com o banco de dados
        Connection conn = conectarBD();

        // Monta a query SQL para verificar as credenciais
        // ATENÇÃO: Esta implementação é vulnerável a SQL Injection
        // TODO: Implementar PreparedStatement para maior segurança
        sql += "select nome from usuarios ";
        sql += "where login = " + " ' " + login + " ' ";
        sql += " and senha = " + " ' '" + senha + " ' ;";

        try {
            // Cria um statement para executar a query
            Statement st = conn.createStatement();

            // Executa a consulta e obtém o resultado
            ResultSet rs = st.executeQuery(sql);

            // Verifica se encontrou algum resultado
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Em caso de erro na consulta, mantém result como false
            // TODO: Implementar log de erro e tratamento adequado da exceção
        }

        return result;
    }
}
