# <p align="center">JAVA EATS</p>


# <p align="center"><img src="https://github.com/user-attachments/assets/19b3f522-1442-4dfd-aba7-e5d03a64cf4b" alt="Logo"></p>

### Trabalho final de LP e POO. 
Os arquivos .java estão na pasta "src", e as classes referentes à matéria de POO estão na pasta `src/POO `.

## Sumário

1. [Informações sobre o Projeto](#informações-sobre-o-projeto)
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)
3. [Pré-requisitos](#pré-requisitos)
4. [Como Utilizar](#como-utilizar)
5. [Imagens, Vídeos ou GIFs](#imagens-vídeos-ou-gifs)
6. [Desenvolvedores](#desenvolvedores)
7. [Futuras Melhorias](#futuras-melhorias)
8. [Licença](#licença)

---

## Informações sobre o Projeto

Este projeto é uma aplicação desktop desenvolvida para ser utilizada como um sistema de vendas de um restaurante. Ele foi criado para cadastrar clientes, permitir login, escolher produtos da vitrine e adicioná-los ao carrinho (ou removê-los), e realizar o pagamento do pedido.

Obs: para acessar uma versão do projeto que funcione no terminal, utilize a pasta `src/POO` presente no repositório.

## Tecnologias Utilizadas

- IDEA - `IntelliJ`
- Java JDK - `versão do JDK`
- Interface gráfica - `Swing`
- Banco de dados - `SQLite`

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

- IDEA `IntelliJ`
- Banco de Dados `SQLite`
- Biblioteca `sqlite-jdbc-3.42.0.0.jar`

## Como Utilizar

Siga os passos abaixo para configurar e executar o projeto:

1. Clone o repositório usando o GitHub Desktop:
    - Abra o GitHub Desktop.
    - Vá em `File` > `Clone repository`.
    - Insira o URL do repositório: `https://github.com/Kevthiago/EcommerceLP` ou `https://github.com/anacristinags/Linguagens_de_Programacao/ecommerce-java-eats`.
    - Escolha o local onde deseja clonar o repositório e clique em `Clone`.

2. Abra o projeto no IntelliJ IDEA:
    - Abra o IntelliJ IDEA.
    - Vá em `File` > `Open...`.
    - Navegue até o diretório onde você clonou o repositório e selecione a pasta do projeto.
    - Clique em `OK` para abrir o projeto.

3. Instale as dependências:
    - No IntelliJ IDEA, adicione a biblioteca `sqlite-jdbc-3.42.0.0.jar` à estrutura do projeto.
    - Instale o banco de dados `SQLite` para configurar a conexão.
    - Confira e configure a `URL`, `USER` e `SENHA` na classe `ConexaoBD` conforme necessário.
    - Sentença utilizada para criar a tabela:
  
      
       ![Script SQL](https://github.com/user-attachments/assets/840985d4-4ec6-4079-8766-5f85ceda5087)


      - Diagrama de Classes representando a tabela no Banco de Dados:


      ![Diagrama de Classes](https://github.com/user-attachments/assets/f625e251-ba7d-4b03-ae30-b59e5e0a019e)

      

5. Execute a aplicação:
    - No IntelliJ IDEA, localize o arquivo principal da aplicação `TelaLogin.java`.
    - Clique com o botão direito na classe principal e selecione `Run 'TelaLogin.main()'`.
    - Aguarde até que a aplicação inicie completamente.
    - Obs: cada tela pode ser executada separadamente, mas recomenda-se iniciar pela `TelaLogin` para uma melhor experiência.

6. Acesse a aplicação:
    - A aplicação desktop deve abrir automaticamente. Siga as instruções na tela para começar a usar a aplicação.

## Imagens, Vídeos ou GIFs
> Observação: os GIFs estão acelerados. Ao final da sessão, há um vídeo demonstrando o projeto completo de forma mais detalhada.
### Tela de Login/Cadastro
#### Tela de Cadastro
<div align="center"> <img src="https://github.com/Kevthiago/EcommerceLP/assets/145061688/a5a836ca-7ff4-4e1c-99ff-35837d27259a" width="700px" />
 </div> 

#### Tela de Login
<div align="center"> <img src="https://github.com/Kevthiago/EcommerceLP/assets/145061688/68c720ff-e9d0-4465-9683-f8a24b92ce64" width="700px" />
 </div> 

### Tela de Vitrine de Produtos
<div align="center"> <img src="https://github.com/Kevthiago/EcommerceLP/assets/145061688/af735cc4-77a6-45d6-8d44-ba4cca0e7b29" width="700px" />
 </div> 

### Tela de Carrinho
<div align="center"> <img src="https://github.com/Kevthiago/EcommerceLP/assets/145061688/d68c842d-7a53-4197-9847-6c8589ef91f4" width="700px" />
 </div> 

### Tela de Pagamentos
<div align="center"> <img src="https://github.com/Kevthiago/EcommerceLP/assets/145061688/15245547-fac9-4013-be9c-fead11d49462" width="700px" />
 </div> 

### Demonstração em Vídeo: 

 https://github.com/Kevthiago/EcommerceLP/assets/145061688/3f1efe3f-8219-4954-8ddd-2d0618851f1d 

## Desenvolvedores

- **Kevin Thiago dos Santos**
    - GitHub: `https://github.com/Kevthiago`
    - LinkedIn: `https://www.linkedin.com/in/kevin-thiago-15577520b/`

- **Ana Cristina Gonçalvez Siqueira**
    - GitHub: `https://github.com/anacristinags`
    - LinkedIn: `https://www.linkedin.com/in/ana-cristina-g-97122b242/`

## Futuras Melhorias

- [ ] Adicionar novas funcionalidades, como `botões para remover item do carrinho` sem precisar do código e `cálculo para taxa de entrega`.
- [ ] Melhorar a performance da aplicação em `usabilidade`, `segurança`, `design`, `conexão com banco de dados` e `cadastro/login de usuário`.
- [ ] Corrigir bugs relacionados à `conexão com banco de dados` e aos `dados do cliente no cadastro`.
- [ ] Implementar testes automatizados para `detectar bugs` e `pontos a melhorar`.


