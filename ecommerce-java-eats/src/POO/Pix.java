package POO;

import java.util.Scanner;

public class Pix extends FormaPagamento {
    //Construtor
    public Pix() {
        super("Pix");
    }

    //Métodos
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de " + valor + " realizado com Pix.");
    }

    @Override
    public void solicitarDadosPagamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a chave Pix: ");
        String chavePix = scanner.nextLine();
        System.out.println("Chave Pix recebida.");
    }
}
