package POO;

import java.util.Scanner;

public class CartaoCredito extends FormaPagamento {
    //Construtor
    public CartaoCredito() {
        super("Crédito");
    }

    //Métodos
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de " + valor + " realizado com Crédito.");
    }

    @Override
    public void solicitarDadosPagamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do cartão de crédito: ");
        String numeroCartao = scanner.nextLine();
        System.out.print("Digite a data de validade (MM/AA): ");
        String validade = scanner.nextLine();
        System.out.print("Digite o código de segurança: ");
        String codigoSeguranca = scanner.nextLine();
        System.out.println("Dados do cartão de crédito recebidos.");
    }
}
