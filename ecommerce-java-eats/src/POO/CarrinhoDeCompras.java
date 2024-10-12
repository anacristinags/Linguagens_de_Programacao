package POO;

import java.util.ArrayList;

public class CarrinhoDeCompras {
    // atributo do tipo arrayList da Classe ItemVenda
    private ArrayList<ItemVenda> itens = new ArrayList<>();

    // método para adicionar item ao carrinho
    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    // método para remover item do carrinho
    public void removerItem(int item) {
        itens.remove(item);
    }

    // método que calcula o valor total
    public double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.calcularTotal();
        }
        System.out.println("Valor total do carrinho: "+String.format("%.2f", total));
        return total;
    }

    // metodo para exibir itens do carrinho
    public void exibirCarrinho() {
        System.out.println("Seu Carrinho de Compras:");
        int i =1;
        for (ItemVenda item : itens) {
            System.out.println(i+") "+item+"\n");
            i += 1;
        }
        calcularTotal();
        System.out.println("\n");
    }
}
