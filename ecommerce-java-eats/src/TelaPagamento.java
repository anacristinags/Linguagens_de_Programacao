import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TelaPagamento extends JFrame {

    // Componentes da interface
    private JPanel telaPay;
    private JPanel containerComponentes;
    private JComboBox<String> opcoesPay;
    private JLabel textOpcoes;
    private JLabel textValor;
    private JLabel textQuantidade;
    private JButton finalizar;
    private JButton voltar;
    private JSeparator linha1;
    private JSeparator linha2;
    private JLabel quantidade;
    private JLabel valor;
    private JLabel titulo;

    // Instância da classe Pagamento
    private Pagamento pagamento;

    /**
     * Construtor da tela de pagamento.
     * Configura a janela e inicializa os componentes.
     */
    public TelaPagamento() {
        this.setTitle("Pagamento");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        pagamento = new Pagamento();

        inicializarComponentes();
        configurarComponentes();
        adicionarComponentes();
        adicionarAcoes();

        this.setVisible(true);
    }

    // Inicializa os componentes da interface
    private void inicializarComponentes() {
        telaPay = new JPanel(new BorderLayout());
        containerComponentes = new JPanel();
        opcoesPay = new JComboBox<>();
        textOpcoes = new JLabel();
        textValor = new JLabel();
        textQuantidade = new JLabel();
        finalizar = new JButton();
        voltar = new JButton();
        linha1 = new JSeparator();
        linha2 = new JSeparator();
        quantidade = new JLabel(CarrinhoDeCompras.quantidadeTotalItens());
        valor = new JLabel(CarrinhoDeCompras.valorTotalCompra());
        titulo = new JLabel("Tela de pagamento", SwingConstants.CENTER);
    }

    // Configura as propriedades dos componentes
    private void configurarComponentes() {
        containerComponentes.setLayout(null);

        configurarComboBox();
        configurarLabels();
        configurarTextFields();
        configurarBotoes();
        configurarSeparadores();
        configurarTitulo();
    }

    // Configura a ComboBox de opções de pagamento
    private void configurarComboBox() {
        opcoesPay.setFont(new Font("Arial", Font.BOLD, 14));
        opcoesPay.addItem("Cartão de crédito");
        opcoesPay.addItem("Boleto bancário");
        opcoesPay.addItem("Cartão de débito");
        opcoesPay.addItem("Pix");
        opcoesPay.setSelectedItem("Cartão de crédito");
        opcoesPay.setBounds(66, 219, 250, 30);
    }

    // Configura os Labels
    private void configurarLabels() {
        textValor.setFont(new Font("Arial", Font.BOLD, 14));
        textValor.setText("Valor total:");
        textValor.setBounds(20, 100, 250, 30);

        textQuantidade.setFont(new Font("Arial", Font.BOLD, 14));
        textQuantidade.setText("Quantidade de itens:");
        textQuantidade.setBounds(20, 20, 250, 30);

        textOpcoes.setFont(new Font("Arial", Font.BOLD, 14));
        textOpcoes.setText("Forma de pagamento:");
        textOpcoes.setBounds(20, 188, 250, 30);

        valor.setFont(new Font("Arial", Font.BOLD, 14));
        valor.setBounds(30, 131, 300, 30);
        valor.setForeground(Color.BLACK);
        valor.setBackground(Color.WHITE);
        valor.setEnabled(false);

        quantidade.setFont(new Font("Arial", Font.BOLD, 14));
        quantidade.setBounds(30, 51, 300, 30);
        quantidade.setForeground(Color.BLACK);
        quantidade.setBackground(Color.WHITE);
        quantidade.setEnabled(false);
    }

    // Configura os TextFields
    private void configurarTextFields() {
    }

    // Configura os botões
    private void configurarBotoes() {
        finalizar.setFont(new Font("Arial", Font.BOLD, 14));
        finalizar.setText("Pagamento");
        finalizar.setBackground(new Color(0x00FF00));
        finalizar.setBounds(66, 347, 250, 30);

        voltar.setFont(new Font("Arial", Font.BOLD, 14));
        voltar.setText("Voltar");
        voltar.setBackground(new Color(0xFF0000));
        voltar.setBounds(66, 380, 250, 30);
    }

    // Configura os separadores
    private void configurarSeparadores() {
        linha1.setBounds(19, 179, 349, 30);
        linha2.setBounds(19, 328, 349, 30);
    }

    // Configura o título
    private void configurarTitulo() {
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    }

    // Adiciona os componentes ao container
    private void adicionarComponentes() {
        containerComponentes.add(opcoesPay);
        containerComponentes.add(textOpcoes);
        containerComponentes.add(textValor);
        containerComponentes.add(valor);
        containerComponentes.add(textQuantidade);
        containerComponentes.add(quantidade);
        containerComponentes.add(finalizar);
        containerComponentes.add(voltar);
        containerComponentes.add(linha1);
        containerComponentes.add(linha2);

        telaPay.add(titulo, BorderLayout.NORTH);
        telaPay.add(containerComponentes, BorderLayout.CENTER);
        this.add(telaPay);
    }

    /**
     * Adiciona as ações de funcionalidade aos botões.
     */
    private void adicionarAcoes() {
        finalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obter dados de pagamento da interface
                String tipoPagamento = (String) opcoesPay.getSelectedItem();
                String dadosPagamento = "";

                if (tipoPagamento.equals("Cartão de crédito") || tipoPagamento.equals("Cartão de débito")) {
                    try {
                        // Configura os formatadores de máscara para os campos do cartão
                        MaskFormatter maskNumeroCartao = new MaskFormatter("#### #### #### ####");
                        maskNumeroCartao.setPlaceholderCharacter('_');
                        MaskFormatter maskValidade = new MaskFormatter("##/##");
                        maskValidade.setPlaceholderCharacter('_');
                        MaskFormatter maskCodigoSeguranca = new MaskFormatter("###");
                        maskCodigoSeguranca.setPlaceholderCharacter('_');

                        // Campos formatados para entrada de dados do cartão
                        JFormattedTextField numeroCartao = new JFormattedTextField(maskNumeroCartao);
                        JFormattedTextField validade = new JFormattedTextField(maskValidade);
                        JFormattedTextField codigoSeguranca = new JFormattedTextField(maskCodigoSeguranca);

                        // ComboBox para seleção de parcelas
                        JComboBox<String> parcelas = new JComboBox<>();
                        for (int i = 1; i <= 10; i++) {
                            parcelas.addItem(i + "x");
                        }

                        // Define a mensagem a ser exibida no diálogo de entrada de dados
                        Object[] mensagem;
                        if (tipoPagamento.equals("Cartão de crédito")) {
                            mensagem = new Object[]{
                                    "Número do Cartão:", numeroCartao,
                                    "Validade (MM/AA):", validade,
                                    "Código de Segurança:", codigoSeguranca,
                                    "Parcelas:", parcelas
                            };
                        } else {
                            mensagem = new Object[]{
                                    "Número do Cartão:", numeroCartao,
                                    "Validade (MM/AA):", validade,
                                    "Código de Segurança:", codigoSeguranca
                            };
                        }

                        // Exibe o diálogo de entrada de dados do cartão
                        int option = JOptionPane.showConfirmDialog(null, mensagem, "Dados do Cartão", JOptionPane.OK_CANCEL_OPTION);
                        if (option == JOptionPane.OK_OPTION) {
                            // Verifica se todos os campos estão preenchidos
                            if (numeroCartao.getText().contains("_") || validade.getText().contains("_") || codigoSeguranca.getText().contains("_")) {
                                JOptionPane.showMessageDialog(TelaPagamento.this, "Por favor, preencha todos os campos do cartão.");
                                return; // Se algum campo está incompleto, não prosseguir com o pagamento
                            }

                            String parcelasSelecionadas = tipoPagamento.equals("Cartão de crédito") ? parcelas.getSelectedItem().toString() : "1x";
                            dadosPagamento = String.format("numero_cartao:%s;vencimento:%s;codigo_segurança:%s;parcelas:%s",
                                    numeroCartao.getText(), validade.getText(), codigoSeguranca.getText(), parcelasSelecionadas);
                        } else {
                            return; // Se o usuário cancelar, não prosseguir com o pagamento
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    // Dados de pagamento para outras opções
                    dadosPagamento = "tipo_pagamento_simples";
                }

                // Configura os dados de pagamento na instância de pagamento
                pagamento.setTipoPagamento(tipoPagamento);
                pagamento.setDadosPagamento(dadosPagamento);

                // Efetua o pagamento
                pagamento.efetuarPagamento();

                // Verifica o status do pagamento
                String status = pagamento.getStatusPagamento();
                if (status.equals("aprovado")) {
                    JOptionPane.showMessageDialog(TelaPagamento.this, "Pagamento finalizado com sucesso!");
                    CarrinhoDeCompras.zerarCarrinho(); // zera carrinho de compras
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha janela
                } else if (status.equals("pendente")) {
                    JOptionPane.showMessageDialog(TelaPagamento.this, "Pagamento pendente. Aguarde a confirmação.");
                } else {
                    JOptionPane.showMessageDialog(TelaPagamento.this, "Pagamento recusado. Tente novamente.");
                }

                // Fecha a janela
                dispose();
            }
        });

        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fecha a janela
                dispose();
            }
        });
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaPagamento::new);
    }
}
