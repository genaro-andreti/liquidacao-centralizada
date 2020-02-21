# Sicredi-Liquidação Centralizada

## Sobre a aplicação
* Consiste em ler o arquivo SLC0001-modelo.xml que se encontra no diretório /data/in na raiz do projeto e grava na base de dados em memória, o processamento ocorre 1 minuto após a anicialização da aplicação e depois roda a cada hora.

## Executar a aplicação:
* entrar na raiz do projeto e executar o comando mvn clean package
* entrar na raiz do projeto no diretório target e executar o comando (java -jar liquidacao-centralizada-0.0.1-SNAPSHOT.jar)

## Executar os testes:
* entrar na raiz do projeto e executar o comando (mvn clean test)