# - ETAPA 01:
## Erros Encontrados no Código Java de Conexão com MySQL

Este README resume os principais erros encontrados no código fornecido para a conexão com o banco de dados MySQL.

## 1. **Erro no Carregamento do Driver JDBC**
   - **Problema**: O driver JDBC do MySQL foi carregado de forma incorreta.
   - **Solução**: O driver correto é `com.mysql.cj.jdbc.Driver`, e não `com.mysql.Driver.Manager`.
   
## 2. **Concorrência e Vulnerabilidade de SQL Injection**
   - **Problema**: A query SQL foi construída concatenando diretamente os parâmetros de entrada, o que pode resultar em **SQL Injection**.
   - **Solução**: Use **`PreparedStatement`** para evitar SQL Injection e melhorar a segurança.

## 3. **Exceções Não Tratadas Adequadamente**
   - **Problema**: As exceções são capturadas, mas não fornecem informações úteis para depuração.
   - **Solução**: Implemente o uso de `e.printStackTrace()` para exibir a causa do erro no console.

## 4. **Verificação de Conexão Não Realizada**
   - **Problema**: O código não verifica se a conexão com o banco de dados foi bem-sucedida.
   - **Solução**: Verifique se a conexão (`conn`) não é `null` antes de usá-la.

## 5. **Conexão Não Fechada Adequadamente**
   - **Problema**: A conexão com o banco de dados não é fechada corretamente, o que pode resultar em vazamento de recursos.
   - **Solução**: Utilize **`try-with-resources`** para garantir que a conexão seja fechada automaticamente.

## 6. **Falta de Mensagens Claras em Caso de Erro**
   - **Problema**: Se o usuário ou senha estiverem incorretos, o código não exibe uma mensagem explicativa.
   - **Solução**: Exiba mensagens de erro claras, como "Usuário ou senha incorretos".

## 7. **Configuração de Classe Principal no `pom.xml`**
   - **Problema**: O nome da classe principal e o pacote no `pom.xml` podem não corresponder ao código real.
   - **Solução**: Certifique-se de que o valor de `<exec.mainClass>` no `pom.xml` corresponde ao nome correto da classe principal.

## 8. **Credenciais de Banco de Dados Codificadas**
   - **Problema**: As credenciais de banco de dados (usuário e senha) estão codificadas diretamente no código.
   - **Solução**: Use variáveis de ambiente ou arquivos de configuração para armazenar credenciais de maneira segura.


# - ETAPA 02:
