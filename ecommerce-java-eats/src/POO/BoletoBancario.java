package POO;

import java.util.Scanner;

public class BoletoBancario extends FormaPagamento {
    //Construtor
    public BoletoBancario() {
        super("Boleto");
    }

    //Métodos
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de " + valor + " realizado com Boleto.");
    }

    @Override
    public void solicitarDadosPagamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF/CNPJ do pagador: ");
        String cpfCnpj = scanner.nextLine();
        System.out.println("CPF/CNPJ recebido.");
    }
}
