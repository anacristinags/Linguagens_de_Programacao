# Sistema de Loteria em Java - LotoFácil 🎰

## Descrição:
O sistema chamado LotoFácil, tem como objetivo gerar jogos aleatórios, permitir que os jogadores façam suas apostas, verificar os resultados e calcular prêmios de acordo com as regras da loteria. O código `Main.java` funciona por meio do terminal, lendo e escrevendo dados, já o código `loto.java` possui uma interface gráfica. 

## Requisitos do Projeto:
Este repositório contém as especificações detalhadas para a implementação de um menu de loteria, utilizando as estruturas `switch case` e `do while`. O menu permite ao usuário fazer diferentes tipos de apostas enquanto não optar por sair do sistema digitando o número zero.

**Menu LOTOFÁCIL:**
| Sem interface Gráfica | Com interface Gráfica |
| -------------------------- | ------------- |
| 1) Apostar de 0 a 100  <br> 2) Apostar de A à Z  <br> 3) Apostar em par ou ímpar  <br> 0) Sair   | <div align="center"> <img src="https://github.com/anacristinags/LotoFacil/assets/145061688/d14e74b6-1ad8-47a9-9052-2c7e58ef5180" width="700px" />
 </div> 

**Regras para a Aposta de 0 a 100:**
- Leia um número inteiro via teclado, de 0 a 100. Caso o número seja maior que 100 ou menor que 0, imprima a mensagem: “Aposta inválida.”.
- Utilize a biblioteca `Random` para sortear aleatoriamente um número de 0 a 100.
- Compare o número escolhido pelo usuário apostador com o número sorteado pelo sistema.
- Se o usuário acertar a aposta, imprima a mensagem “Você ganhou R$ 1.000,00 reais.”. Caso contrário, imprima: “Que pena! O número sorteado foi: X.”.

**Regras para a Aposta de A à Z:**
- Leia um caractere via teclado, de A à Z, podendo ser lido como maiúsculo ou minúsculo. Caso não seja uma letra, imprima: “Aposta inválida.”.
- Converta a entrada do usuário apostador para maiúsculo, utilizando o método `Character.toUpperCase()`.
- Compare a letra lida via teclado, convertida para maiúsculo, com a letra premiada.
- Se o usuário acertar a aposta, imprima “Você ganhou R$ 500,00 reais.”. Caso contrário, imprima: “Que pena! A letra sorteada foi: X.”.

**Regras para a Aposta de Número Par ou Ímpar:**
- Leia um número inteiro via teclado.
- O prêmio será dado caso o usuário digite um número par. O sistema não irá premiar jogadores que digitarem um número ímpar.
- Se o número digitado for par, imprima “Você ganhou R$ 100,00 reais.”. Caso o usuário digite um número ímpar, imprima: “Que pena! O número digitado é ímpar e a premiação foi para números pares.”.

## Demonstração em vídeo: <br>


https://github.com/anacristinags/LotoFacil/assets/145061688/e833c6fd-4eef-4837-8b47-829fd6821174


<br>Link Youtube: https://www.youtube.com/watch?v=dCcWPPjKxXM 

## 

### Como executar e especificações do Código
- **JDK:** O projeto foi desenvolvido e testado utilizando o JDK 21.0.2;
#### Sem Interface
- Para rodar o programa, copie o código-fonte do arquivo `Main.java` para sua IDE, compile e execute-o;
<br>**Bibliotecas Utilizadas:**
- `java.util.Scanner`: Utilizada para receber entrada do usuário a partir do console.
- `java.io.*`: Utilizada para operações de entrada e saída de dados, como leitura de entrada do teclado e exibição de mensagens.
- `java.util.Random`: Utilizada para gerar números aleatórios.
- `java.io.IOException`: Utilizada para tratar exceções relacionadas a operações de entrada e saída de dados.
- `java.util.InputMismatchException`: Utilizada para capturar exceções relacionadas a entradas de dados incorretas.
- `java.lang.Object`: Importada implicitamente, é a superclasse de todas as classes no Java.
#### Com Interface
- Para rodar o programa, baixe a pasta `com_interface`, abra a pasta em sua IDE, compile e execute-o;
<br>**Bibliotecas Utilizadas:**
- `javax.swing.*`: Utilizada para criação de interfaces gráficas de usuário (GUI).
- `java.awt.*`: Utilizada para a criação e manipulação de componentes gráficos, como eventos de entrada.
- `java.awt.event.ActionEvent` e `java.awt.event.ActionListener`: Utilizada para eventos de ação, como cliques em botões.
- `java.awt.event.KeyAdapter` e `java.awt.event.KeyEvent`: Utilizada para eventos de teclado, como pressionar e soltar teclas.
- `java.io.IOException`: Utilizada para tratar exceções relacionadas a operações de entrada e saída de dados.
- `java.util.Random`: Utilizada para gerar números aleatórios.
- `java.awt.Color`: Utilizada para representar e manipular cores nas aplicações gráficas.

## Conclusão
Esse programa foi fundamental para o esclarecimento de aplicações em Java e desenvolvimento de interfaces gráficas com Swing.
