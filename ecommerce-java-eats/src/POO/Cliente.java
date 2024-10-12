package POO;

import java.util.Scanner;

public class Cliente extends Usuario {
    // Atributos
    private String endereco;

    // Construtor
    public Cliente(String nome, String email, String endereco) {
        super(nome, email);
        this.endereco = endereco;
    }

    // Getters and Setters
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Métodos
    @Override
    public void solicitarDadosUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        setNome(nome);

        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();
        setEmail(email);

        System.out.print("Digite o endereço do cliente: ");
        endereco = scanner.nextLine();

        System.out.println("Dados do cliente recebidos.");
    }
}
