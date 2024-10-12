import javax.swing.*;
import java.util.ArrayList;

// classe para gerenciar o carrinho (arrays)
public class CarrinhoDeCompras {
        // atributos
        private static CarrinhoDeCompras instance;
        private ArrayList<ItemCarrinho> itens;
        static int quantidadeTotal;

        // construtor
        private CarrinhoDeCompras() {
            itens = new ArrayList<>();
        }

        // método para chamar inicialmente o construtor ou depois retornar instância existente
        public static CarrinhoDeCompras getInstance() {
            if (instance == null) {
                instance = new CarrinhoDeCompras();
            }
            return instance;
        }


        // metodo para add itens
        public void adicionarItem(ItemCarrinho item) {
            itens.add(item);
        }

        // método para remover itens
        public void removerItem(String numPedido) {
            // Variável para verificar se o número do pedido foi encontrado
            boolean encontrado = false;

            // loop para percorrer array e encontrar o numero
            for (ItemCarrinho item : itens) {
                if (item.getNumPedido().equals(numPedido)) {
                    itens.remove(item); // removendo item
                    JOptionPane.showMessageDialog(null, "Produto(s) removido(s) com sucesso!",
                            "Pedido Removido", JOptionPane.INFORMATION_MESSAGE);
                    encontrado = true; // tornando variavel true
                    break;
                }
            }
            // se o número não for encontrado imprime mensagem de erro
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Número do pedido não encontrado",
                        "Erro na remoçõa do Pedido", JOptionPane.ERROR_MESSAGE);
            }
        }

        // método do tipo ArrayList que retorna objs do tipo 'ItemCarrinho"
        public ArrayList<ItemCarrinho> getItens() {
            return itens;
        }


        // Método para mostrar o valor total da compra
        public static String valorTotalCompra() {
            if (CarrinhoDeCompras.getInstance() == null){
                JOptionPane.showMessageDialog(null, "Carrinho vazio!");
            } else {
                double precoTotal = 0;
                for (ItemCarrinho i : instance.itens) {
                    precoTotal += i.getPrecoTotal();
                }
                return "Valor Total: " + String.format("%.2f", precoTotal);
            }
            return null;
        }

        // Método para mostrar a quantidade total de itens
        public static String quantidadeTotalItens() {
            if (CarrinhoDeCompras.getInstance() == null){
                JOptionPane.showMessageDialog(null, "Carrinho vazio!");
            } else {
                quantidadeTotal = 0;
                for (ItemCarrinho i : instance.itens) {
                    quantidadeTotal += i.getQuantidade();
                }
                return "Quantidade total de itens: " + quantidadeTotal;
            }
            return null;
         }

        public static int getQuantidadeTotal() {
            for (ItemCarrinho i : instance.itens) {
                quantidadeTotal += i.getQuantidade();
            }
            return quantidadeTotal;
        }

        public static void zerarCarrinho(){
            getInstance().itens.clear();

        }


}

