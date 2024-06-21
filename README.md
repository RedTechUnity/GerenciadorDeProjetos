# Gerenciador de Projetos

Este é um projeto web para gerenciar projetos, utilizando Java, Tomcat e MySQL.

## Pré-requisitos

Certifique-se de que você tem os seguintes softwares instalados:

1. Apache Tomcat 9.0.x
2. MySQL Server 5.7 ou superior

## Configuração do Banco de Dados

1. Inicie o serviço MySQL.
2. Abra o cliente MySQL e execute os seguintes comandos para criar o banco de dados e as tabelas necessárias:

    ```sql
    CREATE DATABASE gerenciamento_projetos;
    USE gerenciamento_projetos;

    CREATE TABLE usuarios (
        id INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(100),
        email VARCHAR(100),
        senha VARCHAR(100)
    );

    CREATE TABLE projetos (
        id INT AUTO_INCREMENT PRIMARY KEY,
        titulo VARCHAR(100),
        descricao TEXT,
        dataFinal DATE,
        status VARCHAR(50),
        usuarioId INT,
        FOREIGN KEY (usuarioId) REFERENCES usuarios(id)
    );
    ```

3. No arquivo `src/main/java/service/Conexao.java`, atualize o usuário e a senha do banco de dados:


## Configuração do Tomcat

1. Certifique-se de que o Tomcat está instalado e configurado corretamente.

## Acesso à Aplicação

1. Abra o navegador e acesse `http://localhost:8080/GerenciadorDeProjetos`.
2. A aplicação deve estar funcionando e conectada ao banco de dados MySQL.

## Solução de Problemas

- **Erro 404 - Não Encontrado:** Certifique-se de que o servlet está corretamente mapeado no `web.xml` e que a estrutura do projeto está correta.
- **Erro 500 - Internal Server Error:** Verifique os logs do Tomcat para mais detalhes. Certifique-se de que o driver JDBC está no classpath e que as configurações de conexão no `Conexao.java` estão corretas.
- **Conexão com MySQL:** Certifique-se de que o MySQL está em execução e que o banco de dados `gerenciamento_projetos` foi criado corretamente. Verifique as credenciais no arquivo `Conexao.java`.

