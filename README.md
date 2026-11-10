# Desafio Thread - iFood
Um projeto que foi desenvolvido durante o tutorial sobre Threads em Java 21, utilizando o conceito de concorrência e paralelismo para otimizar o desempenho de aplicações.

## Objetivo:
O objetivo deste projeto é demonstrar a utilização de Threads em Java para executar tarefas simultaneamente, aproveitando os recursos do processador e melhorando a eficiência do programa.

## Tecnologias Utilizadas:
- Java 21
- IntelliJ IDEA
- Java Threads
- Java NIO (java.nio.file)

## Funcionalidades:
- Pesquisa de nomes em arquivos .txt.
- Leitura simultânea de múltiplos arquivos.
- Identificação do número da linha em que o nome foi encontrado.
- Contagem de ocorrências por arquivo.
- Medição do tempo total de execução.
- Tratamento de exceções durante a leitura dos arquivos.
- Exibição de resultados de forma organizada no console.

## Estrutura do Projeto:
```
DesafioThread/
├── .idea/
├── arquivos/
│   ├── signatarios-fev-2002.txt
│   ├── signatarios-fev-2016.txt
│   └── signatarios-out-2014.txt
├── out/
├── src/
│   ├── BuscaNomeRunnable.java
│   └── Main.java
├── .gitignore
├── DesafioThread.iml
└── README.md
```

## Resultado da execução:
Dependendo da velocidade do processador e do número de núcleos disponíveis, o tempo de execução pode variar. Abaixo está um exemplo de saída do programa:
```
Procurando: Dave
Iniciando busca no arquivo: signatarios-fev-2016.txt/ Virtual Thread: true/ Thread ID: 24
Iniciando busca no arquivo: signatarios-fev-2002.txt/ Virtual Thread: true/ Thread ID: 22
Iniciando busca no arquivo: signatarios-out-2014.txt/ Virtual Thread: true/ Thread ID: 25
Busca Finalizada! Ocorrências: 0
[signatarios-fev-2002.txt] Linha 4 : Dave Wilson
[signatarios-fev-2016.txt] Linha 5 : Dave Martin
Busca Finalizada! Ocorrências: 1
Busca Finalizada! Ocorrências: 1
Todas as buscas foram finalizadas.
Tempo Total: 83 ms
```

## Conceitos estudados no desafio:
- Threads e programação concorrente.
- Interface Runnable.
- Métodos Thread.start(), join(), Executors.newVirtualThreadPerTaskExecutor(), ExecutorService, submit() e Virtual Threads.
- Identificação da Thread atual com Thread.currentThread().
- Diferenças entre Platform Threads e Virtual Threads.
- Leitura de arquivos utilizando BufferedReader e Files.

## Referências:
- [Tutorial sobre Threads em Java - YouTube](https://youtu.be/OXqtS_nhUfk?si=TvotCZvL_ogJtu1o)
- [Desafio Thread em Java](https://www.matheusleandro.com.br/desafios/vaga-de-estagio-em-desenvolvimento-java)