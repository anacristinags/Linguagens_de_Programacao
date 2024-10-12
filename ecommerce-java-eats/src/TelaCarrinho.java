import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// --------- 10) PAINEL CARRINHO DE COMPRAS ---------
public class TelaCarrinho extends JFrame {
    // 10.1 componentes básicos da painel
    private JLabel texto1TP = new JLabel("JAVA EATS");
    private JLabel texto2TP = new JLabel("Seu carrinho de Compras:");
    private JLabel texto3TP = new JLabel("Remover pedido de Número:");
    private JLabel texto4TP = new JLabel("Valor Total: ");
    JTextArea areaTextoCarrinho = new JTextArea();
    JScrollPane scrollTextoCarrinho = new JScrollPane(areaTextoCarrinho);
    StringBuilder conteudoCarrinho = new StringBuilder();
    JTextField numeroPedido = new JTextField(5);
    JButton botaoRemove = new JButton("Remover");
    JButton botaoVoltar = new JButton("Voltar");
    JButton botaoFinalizar = new JButton("Finalizar Pedido");

    // 10.2 Construtor
    public TelaCarrinho(){
        // Config do painel
        setTitle("Carrinho de Compras");
        setSize(550,450);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        // métodos:
        adicionarComponentes(); percorrerCarrinho(); carrinhoVazio();
    }

    // 10.3 adicionar e configurar posições dos componentes
    public void adicionarComponentes(){
        // config textos
        add(texto1TP);
        texto1TP.setFont(new Font("Arial", Font.BOLD, 16));
        texto1TP.setBounds(15, 0, 450, 30);
        add(texto2TP);
        texto2TP.setBounds(15, 20, 450, 30);
        texto2TP.setFont(new Font("Arial", Font.BOLD, 16));
        add(texto3TP);
        texto3TP.setFont(new Font("Arial", Font.BOLD, 14));
        texto3TP.setBounds(15, 305, 240, 25);
        add(texto4TP);
        texto4TP.setFont(new Font("Arial", Font.BOLD, 14));
        texto4TP.setBounds(15, 330, 340, 25);

        // config Jtextfield
        add(numeroPedido);
        numeroPedido.setBounds(220,307, 80, 25);
        numeroPedido.addKeyListener(new KeyAdapter() { // garantindo a entrada de apenas números
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) &&  c!=KeyEvent.VK_DELETE && numeroPedido.getText().length()<4)){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
        // btn
        add(botaoRemove);
        botaoRemove.setBounds(320, 307, 110,25);
        add(botaoVoltar);
        botaoVoltar.setBounds(60, 365, 110,25);
        add(botaoFinalizar);
        botaoFinalizar.setBounds(220, 365, 200,25);
        botaoFinalizar.setEnabled(false);


        // config JTextArea e JScrollPane
        areaTextoCarrinho.setEditable(false);
        scrollTextoCarrinho.setBounds(15, 50, 500, 250);
        scrollTextoCarrinho.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK)); // Borda vertical
        add(scrollTextoCarrinho);

        // chamando método que remove do carrinho
        removerCarrinho();
        valorTotal();
        voltarBotao();
        finalizarPedido();
    }

    // 10.4 Percorre array e imprime
    public void percorrerCarrinho(){
        for (ItemCarrinho item : CarrinhoDeCompras.getInstance().getItens()) {
            conteudoCarrinho.append(item.toString()).append("\n");
        }
        areaTextoCarrinho.setText(conteudoCarrinho.toString());
    }

    // 10.5 remove item do array
    public void removerCarrinho(){
        botaoRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numero = numeroPedido.getText(); // pega o texto do JTextField
                CarrinhoDeCompras.getInstance().removerItem(numero); // remove do array de acordo com o texto
                dispose(); // fecha tela
            }
        });
    }

    // 10.6 muda valor total
    public void valorTotal(){
        texto4TP.setText(CarrinhoDeCompras.valorTotalCompra() + " " + CarrinhoDeCompras.quantidadeTotalItens());
    }

    // 10.7 botao voltar
    public void voltarBotao(){
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    // 10.8 abre nova tela de pagamento
    public void finalizarPedido(){
        botaoFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPagamento pagamento = new TelaPagamento(); // Instancia nova tela
                pagamento.setVisible(true); // Torna a nova janela visível

                dispose(); // Fecha a janela do carrinho
            }
        });
    }

    // 10.9 condição para que não consigar ir para tela de pagamento com o carrinho vazio
    public void carrinhoVazio(){
        if (CarrinhoDeCompras.getQuantidadeTotal()== 0){
            botaoFinalizar.setEnabled(false);
        } else if (CarrinhoDeCompras.getQuantidadeTotal()>0) {
            botaoFinalizar.setEnabled(true);
        }
    }


}
