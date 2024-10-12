package POO;

import java.util.Scanner;

public class CartaoDebito extends FormaPagamento {
    //Construtor
    public CartaoDebito() {
        super("Débito");
    }

    //Métodos
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de " + valor + " realizado com Débito.");
    }

    @Override
    public void solicitarDadosPagamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do cartão de débito: ");
        String numeroCartao = scanner.nextLine();
        System.out.print("Digite a data de validade (MM/AA): ");
        String validade = scanner.nextLine();
        System.out.print("Digite o código de segurança: ");
        String codigoSeguranca = scanner.nextLine();
        System.out.println("Dados do cartão de débito recebidos.");
    }
}
