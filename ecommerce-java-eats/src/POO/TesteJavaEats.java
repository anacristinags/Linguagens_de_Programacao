package POO;

import java.util.Scanner;

public class TesteJavaEats {
    public static void main(String[] args) {
        // Criando objetos do tipo pizza
        Produto pizzaCalabresa = new Pizza("Pizza de Calabresa",
                "muçarela, calabresa e orégano", 50.90, "Média");
        Produto pizzaFrango = new Pizza("Pizza de Frango com Catupiry",
                "muçarela, frango, catupiry e orégano", 62.90, "Grande");
        Produto pizzaMarguerita = new Pizza("Pizza Marguerita",
                "muçarela, tomate, manjericão e orégano", 82.90, "Gigante");

        // Criando objetos do tipo hambúrguer
        Produto hamburguerTradicional = new Hamburguer("Tradicional Burger",
                "Pão brioche, burger 340g, bacon, cebola e molho", 36.99,
                "Bem Passada", "sem cebola");
        Produto hamburguerFrango = new Hamburguer("Chicken Burger",
                "Pão brioche, burger de frango 180g, duplo queijo, salada e molho",
                33.99, "Ao Ponto", "sem salada");
        Produto hamburguerSmash = new Hamburguer("Smash Burger",
                "Pão brioche, quádruplo burger super smash, duplo cheddar e molho",
                29.99, "Mal Passada", "Completo");

        // Criando objetos do tipo bebidas
        Produto cocaLata = new Bebida("Coca-Cola", "Bebida gelada em lata",
                6.00, "350ml");
        Produto heineken = new Bebida("Heineken", "Bebida gelada long neck",
                7.50, "330ml");
        Produto cocaGarrafa = new Bebida("Coca-Cola", "Bebida gelada em garrafa pet",
                12.50, "2L");

        // Catálogo de produtos
        System.out.println("------------------Bem-vindo(a) à Java Eats!------------------");
        System.out.println("Catálogo de Produtos:");
        System.out.println("------------------------------------------------------------");
        System.out.printf("1. %-40s - R$ %.2f\n", pizzaCalabresa.getNome(), pizzaCalabresa.getPreco());
        System.out.printf("   %-40s\n", pizzaCalabresa.getDescricao());
        System.out.printf("2. %-40s - R$ %.2f\n", pizzaFrango.getNome(), pizzaFrango.getPreco());
        System.out.printf("   %-40s\n", pizzaFrango.getDescricao());
        System.out.printf("3. %-40s - R$ %.2f\n", pizzaMarguerita.getNome(), pizzaMarguerita.getPreco());
        System.out.printf("   %-40s\n", pizzaMarguerita.getDescricao());
        System.out.printf("4. %-40s - R$ %.2f\n", hamburguerTradicional.getNome(), hamburguerTradicional.getPreco());
        System.out.printf("   %-40s\n", hamburguerTradicional.getDescricao());
        System.out.printf("5. %-40s - R$ %.2f\n", hamburguerFrango.getNome(), hamburguerFrango.getPreco());
        System.out.printf("   %-40s\n", hamburguerFrango.getDescricao());
        System.out.printf("6. %-40s - R$ %.2f\n", hamburguerSmash.getNome(), hamburguerSmash.getPreco());
        System.out.printf("   %-40s\n", hamburguerSmash.getDescricao());
        System.out.printf("7. %-40s - R$ %.2f\n", cocaLata.getNome(), cocaLata.getPreco());
        System.out.printf("   %-40s\n", cocaLata.getDescricao());
        System.out.printf("8. %-40s - R$ %.2f\n", heineken.getNome(), heineken.getPreco());
        System.out.printf("   %-40s\n", heineken.getDescricao());
        System.out.printf("9. %-40s - R$ %.2f\n", cocaGarrafa.getNome(), cocaGarrafa.getPreco());
        System.out.printf("   %-40s\n", cocaGarrafa.getDescricao());
        System.out.println("------------------------------------------------------------");

        // Scanner para interação com o usuário
        Scanner scanner = new Scanner(System.in);

        // Solicitando dados do cliente
        System.out.println("\nPor favor, insira seus dados:");
        System.out.print("Nome: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Email: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Endereço: ");
        String enderecoCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, emailCliente, enderecoCliente);

        // Criando carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        // Menu de interação
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("------------------------------------------------------------");
            System.out.println("1. Adicionar item ao carrinho");
            System.out.println("2. Remover item do carrinho");
            System.out.println("3. Ver carrinho");
            System.out.println("4. Realizar pagamento");
            System.out.println("5. Sair");
            System.out.println("------------------------------------------------------------");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.println("\nSelecione o produto:");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("1. Pizza de Calabresa");
                    System.out.println("2. Pizza de Frango com Catupiry");
                    System.out.println("3. Pizza Marguerita");
                    System.out.println("4. Tradicional Burger");
                    System.out.println("5. Chicken Burger");
                    System.out.println("6. Smash Burger");
                    System.out.println("7. Coca-Cola Lata");
                    System.out.println("8. Heineken");
                    System.out.println("9. Coca-Cola Garrafa");
                    System.out.println("------------------------------------------------------------");
                    int produtoOpcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    ItemVenda itemVenda = null;
                    switch (produtoOpcao) {
                        case 1:
                            itemVenda = new ItemVenda(pizzaCalabresa, quantidade);
                            break;
                        case 2:
                            itemVenda = new ItemVenda(pizzaFrango, quantidade);
                            break;
                        case 3:
                            itemVenda = new ItemVenda(pizzaMarguerita, quantidade);
                            break;
                        case 4:
                            itemVenda = new ItemVenda(hamburguerTradicional, quantidade);
                            break;
                        case 5:
                            itemVenda = new ItemVenda(hamburguerFrango, quantidade);
                            break;
                        case 6:
                            itemVenda = new ItemVenda(hamburguerSmash, quantidade);
                            break;
                        case 7:
                            itemVenda = new ItemVenda(cocaLata, quantidade);
                            break;
                        case 8:
                            itemVenda = new ItemVenda(heineken, quantidade);
                            break;
                        case 9:
                            itemVenda = new ItemVenda(cocaGarrafa, quantidade);
                            break;
                        default:
                            System.out.println("Opção de produto inválida.");
                            continue;
                    }
                    carrinhoDeCompras.adicionarItem(itemVenda);
                    System.out.println("\nItem adicionado ao carrinho.");
                    break;

                case 2:
                    carrinhoDeCompras.exibirCarrinho();
                    System.out.print("\nDigite o número do item para remover: ");
                    int itemRemover = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    carrinhoDeCompras.removerItem(itemRemover - 1);
                    System.out.println("Item removido do carrinho.");
                    break;

                case 3:
                    carrinhoDeCompras.exibirCarrinho();
                    break;

                case 4:
                    double valorTotal = carrinhoDeCompras.calcularTotal();
                    System.out.println("\nSelecione a forma de pagamento:");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("1. Débito");
                    System.out.println("2. Crédito");
                    System.out.println("3. Pix");
                    System.out.println("4. Boleto");
                    System.out.println("------------------------------------------------------------");
                    int pagamentoOpcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    FormaPagamento formaPagamento = null;
                    switch (pagamentoOpcao) {
                        case 1:
                            formaPagamento = new CartaoDebito();
                            break;
                        case 2:
                            formaPagamento = new CartaoCredito();
                            break;
                        case 3:
                            formaPagamento = new Pix();
                            break;
                        case 4:
                            formaPagamento = new BoletoBancario();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            continue;
                    }

                    // Solicitar dados de pagamento e realizar o pagamento
                    formaPagamento.solicitarDadosPagamento();
                    formaPagamento.pagar(valorTotal);
                    break;

                case 5:
                    System.out.println("\nSaindo...");
                    System.exit(0);

                default:
                    System.out.println("\nOpção inválida.");
            }
        }
    }
}
